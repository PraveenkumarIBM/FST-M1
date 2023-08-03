import pytest
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

service = FirefoxService(GeckoDriverManager().install())
def testMethod():
    with webdriver.Firefox(service=service) as driver:
        driver.get("http://alchemy.hguy.co/orangehrm")
        driver.find_element(By.ID, "txtUsername").send_keys("orange")
        driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
        driver.find_element(By.ID, "btnLogin").click()

        wait = WebDriverWait(driver, 10)
        wait.until(EC.visibility_of(driver.find_element(By.CLASS_NAME, "head")))
        actual = driver.find_element(By.XPATH, "//li[@class='current']/a/b").text
        assert "Dashboard" in actual
        driver.quit()