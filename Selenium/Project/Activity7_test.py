import pytest
import time
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
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
        time.sleep(2)
        driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
        time.sleep(2)
        driver.find_element(By.XPATH, "//ul[@id='sidenav']/li[9]/a").click()
        time.sleep(2)
        driver.find_element(By.ID, "addWorkExperience").click()
        wait = WebDriverWait(driver, 10)
        wait.until(EC.visibility_of(driver.find_element(By.ID, "experience_employer")))
        driver.find_element(By.ID, "experience_employer").send_keys("ABC")
        driver.find_element(By.ID, "experience_jobtitle").send_keys("Tester")
        wait.until(EC.visibility_of(driver.find_element(By.ID, "btnWorkExpSave")))
        driver.find_element(By.ID, "btnWorkExpSave").click()
        time.sleep(2)
        actual = driver.find_element(By.CSS_SELECTOR, ".message.success.fadable").is_displayed()
        assert actual == True

        driver.quit()