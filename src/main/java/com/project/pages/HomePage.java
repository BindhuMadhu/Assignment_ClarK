package com.project.pages;

import org.openqa.selenium.By;
import org.testng.Reporter;

import com.project.base.TestBase;

public class HomePage extends TestBase {

	private final By accept_cookies = By.xpath(
			"//body[contains(@class,'clark body--web chrome chrome89 windows blink desktop clark2 ember-application')]");
	private final By accept = By.xpath("//button[contains(@class,'cookie-banner-accept-btn')]");

	private final By email = By.xpath("//input[@type=\"email\"]");
	private final By password = By.xpath("//input[@type=\"password\"]");
	private final By registrieren = By.xpath("//button[contains(@type,'submit')]");
	private final By user_profile = By.xpath("//span[contains(@class,'user-profile _profile-icon')]");
	private final By login_option = By.xpath("//a[@href=\"/de/app/login\"]");
	private final By login = By.xpath("//span[text()=\"Einloggen\"]");
	private final By close_alert = By.xpath(
			"//div[contains(@class,'modal-container')]/button[contains(@class,'cucumber-modal-close _button-close')]");

	private final By clark_logo = By.xpath("//a[@href='/de/app/'] ");
	private final By contracts = By.xpath("//a[@role=\"menuitem\" and text()=\"Verträge\"]");
	private final By angebote_link = By.xpath("//a[contains(@class,'page-navigation__link--offers _sections-link')]");

	public void acceptCookies() {
		if (gen.assertElementPresentByXpath(accept_cookies)) {
			Reporter.log("Accepting the cookies on home", true);
			gen.waitAndClickByXpath(accept);
		}

	}

	public void register(String emailId, String pass) {
		Reporter.log("Registering in Clark site", true);
		gen.enterValueinFieldByXpath(email, emailId);
		com.setVariable("email", emailId);
		gen.enterValueinFieldByXpath(password, pass);
		gen.waitAndClickByXpath(registrieren);
	}

	public void login(String emailId, String pass) {
		Reporter.log("Logging into Clark site", true);
		com.setVariable("login_mail", emailId);
		gen.waitAndClickByXpath(user_profile);
		gen.waitAndClickByXpath(login_option);
		gen.enterValueinFieldByXpath(email, emailId);
		gen.enterValueinFieldByXpath(password, pass);
		gen.waitAndClickByXpath(login);
		if (gen.assertElementPresentByXpath(close_alert)) {
			gen.waitAndClickByXpath(close_alert);
		}

	}

	public void navigateToHomePage() {
		Reporter.log("Navigating to Homepage", true);
		gen.waitAndClickByXpath(clark_logo);

	}

	public void navigateToContractPage() {
		Reporter.log("Navigating to Contracts listing page", true);
		gen.waitAndClickByXpath(contracts);

	}

	public void navigateToOfferCreationPage() {

		gen.waitAndClickByXpath(angebote_link);
	}

}
