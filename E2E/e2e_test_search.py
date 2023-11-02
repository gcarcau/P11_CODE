from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By

options = Options()
options.binary_location="D:\Téléchargements\chrome-win64\chrome-win64\chrome.exe"
driver = webdriver.Chrome(chrome_options=options, executable_path='./chromedriver.exe')
driver.get("http://localhost:4200/")
print(driver.title)
print(driver.current_url)

elem = driver.find_element_by_id('accBtnCherche')
driver.implicitly_wait(2)
elem.click()
driver.implicitly_wait(2)
elem = driver.find_element_by_id('rchIptAdd')
elem.send_keys("28 Mount St, Derby DE1 2HH, Royaume-Uni")

driver.implicitly_wait(2)
elem = driver.find_element_by_id('rchSelSpec')
elem.send_keys(Keys.ARROW_DOWN)
elem.send_keys(Keys.ARROW_DOWN)
elem.send_keys(Keys.ARROW_DOWN)
elem.send_keys(Keys.ARROW_DOWN)
elem.send_keys(Keys.TAB)

driver.implicitly_wait(2)
elem = driver.find_element_by_id('rchBtnCherche')
elem.click()

driver.implicitly_wait(10)
elem = driver.find_element_by_id('rchBtnReserver')
elem.click()
driver.implicitly_wait(5)
elem.click()



