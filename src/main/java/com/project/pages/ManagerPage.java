package com.project.pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.testng.Reporter;

import com.project.base.TestBase;

public class ManagerPage extends TestBase {
	
	private final By Privathaftpflicht =By.xpath("//div[text()=\"Privathaftpflicht\"]");
	private final By Private_offer_assert = By.xpath("//h1[text()=\"Deine Angebote zur\"]");
	private final By Privathaftpflicht_contract = By.xpath("//div[contains(@class,'title') and text()=\"Privathaftpflicht\"][1]");
	private final By duplicate_offer = By.xpath("//div[text()=\"Privathaftpflicht\"][1]/preceding::h4[contains(text(),'Deine Angebote')]");

	public void navigateToManagerPage(String url) {
		driver.navigate().to(url);
	}

	public void assertOffer() {
		Reporter.log("Asserting the offer created", true);
		String url =driver.getCurrentUrl();
		String offer_id[] =url.split("[/]" );
		System.out.println("offerId is : "+offer_id[6]);
	    assertEquals(offer_id[6],com.getVariable("offerId"), "the offer is not present in the manager page");
		String offerName= gen.getFieldTextbyXpath(Private_offer_assert);
		assertEquals(offerName, data.getTestData("offer_Success_page"),"Offer is not created successfully");
	}
	
	public void naviagteToContractDetails() {
		Reporter.log("Navigating to contract details page", true);
		gen.waitAndClickByXpath(Privathaftpflicht);
		gen.threadWait("2");
	}
	
	public void getContractId() {
		Reporter.log("Asserting the contract created", true);
		gen.threadWait("1");
		gen.waitAndClickByXpath(Privathaftpflicht_contract);
		gen.threadWait("2");
		String url =driver.getCurrentUrl();
		String contract_id[] =url.split("[/]" );
		System.out.println("ContractId on Contract details page is : "+contract_id[6]);
	    com.setVariable("contractId", contract_id[6]);
		
	}
	
	public void assertDuplicateOfferCreated() {
		boolean flag = gen.assertElementPresentByXpath(duplicate_offer);
		assertEquals(flag, true, "duplicate Offer is not created");
		
	}
	
	
	
}
