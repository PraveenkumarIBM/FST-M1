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
        time.sleep(3)
        wait = WebDriverWait(driver, 10)
        wait.until(EC.visibility_of(driver.find_element(By.ID, "menu_directory_viewDirectory")))
        wait.until(EC.element_to_be_clickable(driver.find_element(By.ID, "menu_directory_viewDirectory")))
        driver.find_element(By.ID, "menu_directory_viewDirectory").click()
        time.sleep(3)
        actual = driver.find_element(By.XPATH, "//div[@class='head']").text
        assert "Search Directory" in actual
        driver.quit()