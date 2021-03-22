package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;

import com.project.base.TestBase;

public class CheckoutPage extends TestBase{
	
	private final By herr = By.xpath("//input[@value=\"male\"]/..");
	private final By mrs = By.xpath("//input[@value=\"female\"]/..");
	private final By first_name = By.xpath("//input[@name=\"firstName\"]");
	private final By surname = By.xpath("//input[@name=\"lastName\"]");
	private final By street = By.xpath("//input[@name=\"street\"]");
	private final By house_no = By.xpath("//input[@name=\"houseNumber\"]");
	private final By zipcode = By.xpath("//input[@name=\"zipcode\"]");
	private final By place = By.xpath("//input[@name=\"city\"]");
	private final By phone = By.xpath("//input[@name=\"phoneNumber\"]");
	private final By dob = By.xpath("//input[@name=\"birthdate\"]");
	private final By weiter = By.xpath("//button[contains(@class,'ember-view _button')]");
	private final By next_working_day = By.xpath("//input[@value=\"next-working-day\"]");
	private final By previous_damage = By.xpath("//input[@value=\"false\"]");
	private final By iban = By.xpath("//input[contains(@name,'iban')]");
	private final By concent = By.xpath("//input[contains(@name,'consent')]");
	
	
	public void profileInfo(String gender, String firstname,String surName,String streetValue,String houseNo, String zip,String city,String dateOfBirth, String phoneNum) {
		Reporter.log("Filling the profie information", true);
		if(gender.equalsIgnoreCase("herr")) gen.waitAndClickByXpath(herr);
		if(gender.equalsIgnoreCase("mrs")) gen.waitAndClickByXpath(mrs);
		gen.enterValueinFieldByXpath(first_name, firstname);
		com.setVariable("name", firstname);
		gen.enterValueinFieldByXpath(surname, surName );
		com.setVariable("surname", surName);
		gen.enterValueinFieldByXpath(street, streetValue);
		com.setVariable("Street", streetValue);
		gen.enterValueinFieldByXpath(house_no, houseNo);
		com.setVariable("houseNumber", streetValue);
		gen.enterValueinFieldByXpath(zipcode, zip);
		gen.enterValueinFieldByXpath(place, city);
		com.setVariable("cityadd", city);
		gen.enterValueinFieldByXpath(dob, dateOfBirth);
		gen.enterValueinFieldByXpath(phone, phoneNum);
		gen.waitAndClickByXpath(weiter);
		
	}
	
	public void paymentDetails(String fakeIban) {
		Reporter.log("Entering the Payment details", true);
		try {
			gen.waitAndClickByXpath(next_working_day);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(next_working_day));
		}
		try {
			gen.waitAndClickByXpath(previous_damage);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(previous_damage));
		}

		gen.waitAndClickByXpath(weiter);
		gen.enterValueinFieldByXpath(iban, fakeIban);
		try {
			gen.waitAndClickByXpath(concent);
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(concent));
		}
		gen.waitAndClickByXpath(weiter);
	}

}
