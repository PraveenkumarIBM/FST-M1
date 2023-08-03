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
        time.sleep(2)
        driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
        driver.find_element(By.XPATH, "//ul[@id='sidenav']/li[3]/a").click()
        count = driver.find_elements(By.XPATH, "//table[@id='emgcontact_list']/tbody/tr/td[5]")
        for a in count:
            print(a.text)
        driver.quit()