import pytest
import time
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

service = FirefoxService(GeckoDriverManager().install())
def test_Method():
    with webdriver.Firefox(service=service) as driver:
        driver.get("http://alchemy.hguy.co/orangehrm")
        driver.find_element(By.ID, "txtUsername").send_keys("orange")
        driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
        driver.find_element(By.ID, "btnLogin").click()
        time.sleep(3)
        driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
        time.sleep(3)
        driver.find_element(By.ID, "btnSave").click()
        driver.find_element(By.ID, "personal_txtEmpFirstName").clear()
        driver.find_element(By.ID, "personal_txtEmpFirstName").send_keys("Shrri")
        driver.find_element(By.ID, "personal_txtEmpLastName").clear()
        driver.find_element(By.ID, "personal_txtEmpLastName").send_keys("Vithya")
        driver.find_element(By.ID, "personal_optGender_2").click()
        time.sleep(2)
        dropdown = driver.find_element(By.XPATH, "//select[@id='personal_cmbNation']")
        s = Select(dropdown)
        s.select_by_visible_text("Indian")

        driver.find_element(By.ID, "personal_DOB").clear()
        driver.find_element(By.ID, "personal_DOB").send_keys("1995-01-01")
        time.sleep(2)
        driver.find_element(By.ID, "btnSave").click()
        driver.quit()