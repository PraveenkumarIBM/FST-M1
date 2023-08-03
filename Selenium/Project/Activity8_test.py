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
        driver.find_element(By.XPATH, "//tbody/tr[1]/td[4]/div/a").click()
        dropdown = driver.find_element(By.XPATH, "//select[@id='applyleave_txtLeaveType']")
        s = Select(dropdown)
        s.select_by_value("1")
        driver.find_element(By.ID, "applyleave_txtFromDate").clear()
        driver.find_element(By.ID, "applyleave_txtFromDate").send_keys("2023-07-04")
        driver.find_element(By.ID, "applyleave_txtToDate").clear()
        driver.find_element(By.ID, "applyleave_txtToDate").send_keys("2023-07-04")
        driver.find_element(By.ID, "applyBtn").click()
        wait = WebDriverWait(driver, 10)
        wait.until(EC.visibility_of(driver.find_element(By.ID, "menu_leave_viewLeaveModule")))
        driver.find_element(By.ID, "menu_leave_viewLeaveModule").click()
        wait.until(EC.visibility_of(driver.find_element(By.ID, "menu_leave_viewMyLeaveList")))
        driver.find_element(By.ID, "menu_leave_viewMyLeaveList").click()
        actual = driver.find_element(By.XPATH, "//table[@id='resultTable']/tbody/tr[1]/td[6]/a").text
        assert "Pending Approval" in actual

        driver.quit()