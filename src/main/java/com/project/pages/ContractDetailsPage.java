package com.project.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import com.project.base.TestBase;

public class ContractDetailsPage extends TestBase{
   
	private final By offer_title = By.xpath("//div[contains(@class,'_content_13p7kx')]/h1[contains(@class,'title')]");
	private final By offer_product=By.xpath("//div[contains(@class,'_content_13p7kx')]/h2[contains(@class,'subtitle')]");
   
	
	public void assertContractId() {
		String url =driver.getCurrentUrl();
		String contractId[] =url.split("[/]" );
		System.out.println("offerId is : "+contractId[6]);
		assertEquals(contractId[6],com.getVariable("contractId"), "the contract is not present in the manager page");
	}
	
	public void assertContractDetails() {
		assertEquals(gen.getFieldTextbyXpath(offer_title).toLowerCase(),com.getVariable("offer_name").toLowerCase() ,
				"The contract is not created for the selected offer");
		assertEquals(gen.getFieldTextbyXpath(offer_product).toLowerCase(), com.getVariable("product").toLowerCase(), "The contract is created with different product");
		
	}


}
