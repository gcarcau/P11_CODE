package com.medhead.api.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.medhead.api.CustomProperties;
import com.medhead.api.model.Demandes;
import com.medhead.api.model.Hopitaux;
import com.medhead.api.model.HopitauxSpecialisation;
import com.medhead.api.service.DemandesService;
import com.medhead.api.service.HopitauxService;
import com.medhead.api.service.HopitauxSpecialisationService;
import com.medhead.api.service.SpecialisationsService;
import com.medhead.api.model.Specialisations;

import lombok.Data;

@Data
@RestController
public class HopitauxController {
	CustomProperties props;
	@Autowired
	private HopitauxService hopitauxService;

	@Autowired
	private HopitauxSpecialisationService hsService;

	@Autowired
	private SpecialisationsService specialisationService;
	
	@Autowired
	private DemandesService demandesService;

	public static final String apiKey = "AIzaSyA5uA2iBVkz2TdAZI1B9lyk64Mxv4UijUg";
	public String adresse = "Paris";
	public String spec = "Dentaire";
	public String url = "";
	public String resultatId = "";
	public String localisation = "";
	public Integer distanceDerniere = 0, distanceEnCours = 0, nbLits = 0;
	public Long idHopitaux;
	public Long idSpecialisations;
	public Collection<String> lstId = new ArrayList<String>();
	Optional<Hopitaux> resultat;
	Hopitaux hopitalProche;
	Demandes demandes;
	

	@GetMapping("/hopitaux")
	public Iterable<Hopitaux> getHopitaux() {
		return hopitauxService.getHopitaux();
	}

	@GetMapping("/specialisations")
	public Iterable<Specialisations> getSpecialisations() {
		return specialisationService.getSpecialisations();
	}
	
	@GetMapping("/demandes")
	public Iterable<Demandes> getDemandes() {
		return demandesService.getDemandes();
	}
	
	@DeleteMapping("/demande/{id}")
	public void deleteDemand(@PathVariable("id") Long id) {
		try {
			demandesService.deleteDemandes(id);
			System.out.println("Une demande a été supprimée.");
		}
		catch(Exception e) {
			System.out.println("Une erreur est survenue lors de la suppression.");
		}
	}


	@SuppressWarnings("static-access")
	@GetMapping("/hopitaux/{idSpecialisation}/{adresse}")
	public Optional<Hopitaux> getHopitaux(@PathVariable("idSpecialisation") final Long idSpecialisation,
			@PathVariable("adresse") final String pAdresse) {
		Date dateDemande = new Date(System.currentTimeMillis());
		Optional<Hopitaux> newResultat =null;
		demandes = new Demandes();
		demandes.setAdresse(pAdresse);
		demandes.setDate(dateDemande);
		demandes = demandesService.saveDemandes(demandes);
		adresse = pAdresse;
		//resultat.empty();
		resultat = newResultat;
		lstId.clear();
		Long specId = idSpecialisation;
		Iterable<HopitauxSpecialisation> lstHS = hsService.getHSByIdSpec(specId);
		lstHS.forEach(hopitalSpecialisation -> {
			if (hopitalSpecialisation.getIdHopitaux().toString() != "") {
				lstId.add(hopitalSpecialisation.getIdHopitaux().toString());
			}
		});
		if (!lstId.isEmpty()) {
			distanceDerniere = 0;
			distanceEnCours = 0;
			nbLits = 0;
			idHopitaux = 0L;
			Iterable<Hopitaux> hopitaux = hopitauxService.getHopitaux(lstId);
			hopitaux.forEach(hopital -> {
				String destination = hopital.getLocalisation();
				destination = destination.replace(",", "");
				destination = destination.replace(" ", "+");
				url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + adresse + "&destinations="
						+ destination + "&units=meters&key=" + apiKey;
				HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
				HttpClient client = HttpClient.newBuilder().build();
				try {
					String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
					try {
						JSONObject jsonobj = new JSONObject(response);
						JSONArray dist = (JSONArray) jsonobj.get("rows");
						JSONObject obj2 = (JSONObject) dist.get(0);
						JSONArray disting = (JSONArray) obj2.get("elements");
						JSONObject obj3 = (JSONObject) disting.get(0);
						JSONObject obj4 = (JSONObject) obj3.get("distance");
						distanceEnCours = (Integer) obj4.get("value");
						nbLits = hopital.getNombreLit();
						if (nbLits > 0) {
							if (distanceDerniere == 0 || distanceEnCours < distanceDerniere) {
								distanceDerniere = distanceEnCours;
								idHopitaux = hopital.getId();
								nbLits = hopital.getNombreLit();
								hopitalProche = hopital;
								hopitalProche.setDistance((distanceDerniere / 1000) + " km");
							}
							System.out.println(hopital + " distance : " + (distanceEnCours / 1000)
									+ " km // Le plus proche : " + (distanceDerniere / 1000) + " km");
						}
					} catch (Exception e) {
						e.printStackTrace();
						demandes.setRetour("Une erreur est survenue : "+e);
						demandesService.saveDemandes(demandes);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					demandes.setRetour("Une erreur est survenue : "+e);
					demandesService.saveDemandes(demandes);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					demandes.setRetour("Une erreur est survenue : "+e);
					demandesService.saveDemandes(demandes);
				}
			});
			if (idHopitaux > 0) {		
				nbLits--;
				hopitalProche.setNombreLit(nbLits);
				hopitauxService.saveHopitaux(hopitalProche);
				resultat = hopitauxService.getHopitaux(idHopitaux);
				demandes.setRetour("Un hôpital a été trouvé : "+hopitalProche.getNom()+".Un lit vient d'être reservé, nombre de lit(s) restants : "+nbLits);
				demandesService.saveDemandes(demandes);
			} else {
				demandes.setRetour("Aucun hôpital n'a de lit disponible pour cette recherche.");
				demandesService.saveDemandes(demandes);
			}
			
			System.out.println(hopitauxService.getHopitaux(idHopitaux) + " distance : " + (distanceDerniere / 1000) + " km");
		} else {
			demandes.setRetour("Aucun hôpital n'a été trouvé.");
			demandesService.saveDemandes(demandes);
		}

		System.out.println(demandes);
		return resultat;
	}
	
	@SuppressWarnings("static-access")
	@GetMapping("/hopitaux_test/{idSpecialisation}/{adresse}")
	public Optional<Hopitaux> getHopitauxTest(@PathVariable("idSpecialisation") final Long idSpecialisation,
			@PathVariable("adresse") final String pAdresse) {
		Date dateDemande = new Date(System.currentTimeMillis());
		Optional<Hopitaux> newResultat =null;
		adresse = pAdresse;
		//resultat.empty();
		resultat = newResultat;
		lstId.clear();
		Long specId = idSpecialisation;
		Iterable<HopitauxSpecialisation> lstHS = hsService.getHSByIdSpec(specId);
		lstHS.forEach(hopitalSpecialisation -> {
			if (hopitalSpecialisation.getIdHopitaux().toString() != "") {
				lstId.add(hopitalSpecialisation.getIdHopitaux().toString());
			}
		});
		if (!lstId.isEmpty()) {
			distanceDerniere = 0;
			distanceEnCours = 0;
			nbLits = 0;
			idHopitaux = 0L;
			Iterable<Hopitaux> hopitaux = hopitauxService.getHopitaux(lstId);
			hopitaux.forEach(hopital -> {
				String destination = hopital.getLocalisation();
				destination = destination.replace(",", "");
				destination = destination.replace(" ", "+");
				url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + adresse + "&destinations="
						+ destination + "&units=meters&key=" + apiKey;
				HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
				HttpClient client = HttpClient.newBuilder().build();
				try {
					String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
					try {
						JSONObject jsonobj = new JSONObject(response);
						JSONArray dist = (JSONArray) jsonobj.get("rows");
						JSONObject obj2 = (JSONObject) dist.get(0);
						JSONArray disting = (JSONArray) obj2.get("elements");
						JSONObject obj3 = (JSONObject) disting.get(0);
						JSONObject obj4 = (JSONObject) obj3.get("distance");
						distanceEnCours = (Integer) obj4.get("value");
						nbLits = hopital.getNombreLit();
						if (nbLits > 0) {
							if (distanceDerniere == 0 || distanceEnCours < distanceDerniere) {
								distanceDerniere = distanceEnCours;
								idHopitaux = hopital.getId();
								nbLits = hopital.getNombreLit();
								hopitalProche = hopital;
								hopitalProche.setDistance((distanceDerniere / 1000) + " km");
							}
							System.out.println(hopital + " distance : " + (distanceEnCours / 1000)
									+ " km // Le plus proche : " + (distanceDerniere / 1000) + " km");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			if (idHopitaux > 0) {		
				resultat = hopitauxService.getHopitaux(idHopitaux);
			}
			
			System.out.println(hopitauxService.getHopitaux(idHopitaux) + " distance : " + (distanceDerniere / 1000) + " km");
		}

		System.out.println(demandes);
		return resultat;
	}

}