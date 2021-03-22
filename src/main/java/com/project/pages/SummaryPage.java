package com.project.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;

import com.project.base.TestBase;

public class SummaryPage extends TestBase {
	private final By product = By.xpath("//dt[text()=\"Produkt\"]/following-sibling::dd[1]");
	private final By name = By.xpath("//dt[text()=\"Name\"]/following-sibling::dd[1]");
	private final By email = By.xpath("//dt[text()=\"E-Mail\"]/following-sibling::dd[1]");
	private final By weiter = By.xpath("//button[contains(@class,'ember-view _button')]");
	private final By success_message = By.xpath("//h1[contains(@class,'header')]");
	private final By to_contract_page= By.xpath("//div[contains(@class,'action')]/a[contains(@class,'ember-view _button')]");
	private final By close_alert= By.xpath("//button[contains(@class,'cucumber-close-modal')]");
	public void assertDetails(String produkt, String nameName, String emilId) {
		Reporter.log("Asserting the details in form summary", true);
		assertEquals(gen.getFieldTextbyXpathbyScroll(product), produkt,
				"The offer selected is different in summary page");
		assertEquals(gen.getFieldTextbyXpathbyScroll(name), nameName, "The name is different in summary page");
		assertEquals(gen.getFieldTextbyXpathbyScroll(email), emilId, "The email is different in summary page");

	}

	public void finalStepTocreateOffer() {
		Reporter.log("Completing the Offer creation process with selected product", true);
		try {
			gen.waitAndClickByXpath(weiter);
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(weiter));
		  }
	}
	
	public void assertSuuceesPage() {
		assertEquals(gen.getFieldTextbyXpath(success_message),"Vielen Dank, "+com.getVariable("name")+"!","message is not correct");;
	}
	public void navigateToContractPage() {
		Reporter.log("Navigating to contract page from the offer success page", true);
		gen.waitAndClickByXpath(to_contract_page);
		if(gen.assertElementPresentByXpath(close_alert))
		gen.waitAndClickByXpath(close_alert);
	}
}
