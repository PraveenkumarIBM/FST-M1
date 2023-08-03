import pytest
import time
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By

service = FirefoxService(GeckoDriverManager().install())
def test_Method():
    with webdriver.Firefox(service=service) as driver:
        driver.get("http://alchemy.hguy.co/orangehrm")
        driver.find_element(By.ID, "txtUsername").send_keys("orange")
        driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
        driver.find_element(By.ID, "btnLogin").click()
        time.sleep(3)
        driver.find_element(By.ID, "menu_pim_viewPimModule").click()
        time.sleep(3)
        driver.find_element(By.ID, "btnAdd").click()
        driver.find_element(By.ID, "firstName").send_keys("Shrri")
        driver.find_element(By.ID, "lastName").send_keys("Vithya")
        driver.find_element(By.ID, "btnSave").click()
        print("User added")
        time.sleep(2)
        driver.find_element(By.ID, "menu_pim_viewPimModule").click()
        time.sleep(2)
        driver.find_element(By.ID, "menu_pim_viewEmployeeList").click()
        time.sleep(2)
        driver.find_element(By.ID, "empsearch_employee_name_empName").send_keys("Shrri")
        driver.find_element(By.ID, "searchBtn").click()
        time.sleep(2)
        actual = driver.find_element(By.XPATH, "//tbody/tr[1]/td[3]/a").text
        assert "Shrri" in actual
        driver.quit()