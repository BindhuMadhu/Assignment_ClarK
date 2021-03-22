package com.project.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Reporter;

import com.project.base.TestBase;

public class OfferSuccessPage extends TestBase {
	
	private final By reward_screen_header = By.xpath("//h1[@class=\"_header_ie5k4r\"]");
	private final By zum_angebot = By.xpath("//a[contains(@class,\"ember-view _button\")]");
	private final By Private_offer_assert = By.xpath("//h1[text()=\"Deine Angebote zur\"]");
	private final By  Jetzt_abschließen= By.xpath("//p[text()=\"DBV\"]/following-sibling::button/span/span");
	
	
	 public void verifyStaticTextonSuceesPage(String value) {
		 Reporter.log("validating the static text in the offer succes page", true);
		 String actual = gen.getFieldTextbyXpath(reward_screen_header);
		 assertEquals(actual, value,"Offer is not created successfully");
	}

	
	 public void verifyZumAngebotLink(String expected) {
		 Reporter.log("validating the Zum angebot link and on offer confirmationpage and asserting the offerId  ", true);
		 gen.waitAndClickByXpath(zum_angebot);
		 gen.threadWait("2");
		 String url =driver.getCurrentUrl();
		 String offer_id[] =url.split("[/]" );
		 com.setVariable("offerId", offer_id[6]);
		 String offerName= gen.getFieldTextbyXpath(Private_offer_assert);
		 assertEquals(offerName, expected,"Offer is not created successfully");
		
	}
	 
	 public void JetztAbschließenDBV() {
		 Reporter.log("Selecting the product for the offer created", true);
		 com.setVariable("product", "DBV");
		 gen.waitAndClickByXpath(Jetzt_abschließen);
	 }
	 
	 public void navigateToContractsPage() {
		 gen.waitAndClickByXpath(zum_angebot);
	 }
	 


}
