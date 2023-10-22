package com.medhead.api;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.medhead.api.controller.HopitauxController;
import com.medhead.api.service.DemandesService;
import com.medhead.api.service.HopitauxService;
import com.medhead.api.service.HopitauxSpecialisationService;
import com.medhead.api.service.SpecialisationsService;


@WebMvcTest(controllers = HopitauxController.class)
public class HopitauxControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HopitauxService hopitauxService;
    
    @MockBean
	private HopitauxSpecialisationService hsService;

    @MockBean
	private SpecialisationsService specialisationService;
	
    @MockBean
	private DemandesService demandesService;

    @Test
    public void testGetHopitaux() throws Exception {
        mockMvc.perform(get("/hopitaux"))
            .andExpect(status().isOk());
    }
    
    @Test
    public void testGetSpecialisations() throws Exception {
        mockMvc.perform(get("/specialisations"))
            .andExpect(status().isOk());
    }
    
    @Test
    public void testGetDemandes() throws Exception {
        mockMvc.perform(get("/demandes"))
            .andExpect(status().isOk());
    }

}