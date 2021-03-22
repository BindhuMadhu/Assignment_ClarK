package com.app.test;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com.project.base.TestBase;
import com.project.pages.Angebote;
import com.project.pages.CheckoutPage;
import com.project.pages.ContractDetailsPage;
import com.project.pages.HomePage;
import com.project.pages.ManagerPage;
import com.project.pages.OfferSuccessPage;
import com.project.pages.SummaryPage;

public class TestCases extends TestBase {

	Angebote angebote = new Angebote();
	OfferSuccessPage success = new OfferSuccessPage();
	ManagerPage managerPage = new ManagerPage();
	HomePage home = new HomePage();
	SummaryPage summary = new SummaryPage();
	CheckoutPage checkout = new CheckoutPage();
	ContractDetailsPage contract = new ContractDetailsPage();

	@Test(description = "To verify user can able to create offer by selecting product from the list and able to create/navigate to offer Contract successfully")
	public void TestCase_001() {
		Reporter.log("description : : To verify user can able to create offer by selecting product from the list and able to create/navigate to offer Contract successfully ",true);
		gen.launch(utils.getProperty("url"));
		home.acceptCookies();
		home.navigateToOfferCreationPage();
		angebote.selectPrivatLiability();
		angebote.quationarePrivathaftpflicht();
		angebote.createPrivatLiabilityOffer();
		success.verifyStaticTextonSuceesPage(data.getTestData("Offer_Success_message"));
		success.verifyZumAngebotLink(data.getTestData("offer_Success_page"));
		success.JetztAbschließenDBV();
		home.register(com.randomEmailAddress(), data.getTestData("dummy_password"));
		gen.threadWait("2");
		checkout.profileInfo(data.getTestData("gender"), com.fakerAddress("name"), com.fakerAddress("surname"),
				com.fakerAddress("Street"), com.fakerAddress("houseNo"), data.getTestData("zip"),
				com.fakerAddress("City"), data.getTestData("dob"), data.getTestData("phone"));
		gen.threadWait("1");
		checkout.paymentDetails(data.getTestData("iban"));
		summary.assertDetails(data.getTestData("product"), com.getVariable("name") + " " + com.getVariable("surname"),
				com.getVariable("email"));
		summary.finalStepTocreateOffer();
		summary.assertSuuceesPage();
		summary.navigateToContractPage();
		managerPage.getContractId();
	}

	@Test(description = "To verify the contract created for the offer is listed in manager page and the product selected is displaying under the contract selected")
	public void TestCase_002() {
		Reporter.log("description : : To verify the contract created for the offer is listed in manager page and the product selected is displaying under the contract selected",true);
		gen.launch(utils.getProperty("url"));
		home.acceptCookies();
		home.login(com.getVariable("email"), data.getTestData("dummy_password"));
		home.navigateToContractPage();
		managerPage.naviagteToContractDetails();
		contract.assertContractId();
		contract.assertContractDetails();

	}

	@Test(description  = "To verify the user able create a duplicate offer with same offer type and product")
	public void TestCase_003() {
		Reporter.log("description : : To verify the contract created for the offer is listed in manager page and the product selected is displaying under the contract selected",true);
		gen.launch(utils.getProperty("url"));
		home.acceptCookies();
		home.login(com.getVariable("email"), data.getTestData("dummy_password"));
		home.navigateToOfferCreationPage();
		angebote.selectPrivatLiability();
		angebote.quationarePrivathaftpflicht();
		angebote.createPrivatLiabilityOffer();
		success.verifyStaticTextonSuceesPage(data.getTestData("Offer_Success_message"));
		success.navigateToContractsPage();
		managerPage.assertDuplicateOfferCreated();

	}

	@Test(description = "To verify user able to create a Privathaftpflicht offer without selecting the product")
	public void TestCase_004() {
		Reporter.log("description : : To verify user able to create a Privathaftpflicht offer without selecting the product",true);
		gen.launch(utils.getProperty("url"));
		home.acceptCookies();
		home.navigateToOfferCreationPage();
		angebote.selectPrivatLiability();
		angebote.quationarePrivathaftpflicht();
		angebote.createPrivatLiabilityOffer();
		success.verifyStaticTextonSuceesPage(data.getTestData("Offer_Success_message"));

	}

	@Test(description = "To verify user can able to naviagte to the offer-details page from the offer creation success page")
	public void TestCase_005() {
		Reporter.log("description : : To verify user can able to naviagte to the offer-details page from the offer creation success page",true);
		gen.launch(utils.getProperty("url"));
		home.acceptCookies();
		home.navigateToOfferCreationPage();
		angebote.selectPrivatLiability();
		angebote.quationarePrivathaftpflicht();
		angebote.createPrivatLiabilityOffer();
		success.verifyStaticTextonSuceesPage(data.getTestData("Offer_Success_message"));
		success.verifyZumAngebotLink(data.getTestData("offer_Success_page"));

	}

	@Test(description = "To verify created offer is displaying in the manager page")
	public void TestCase_006() {
		Reporter.log("description : : To verify created offer is displaying in the manager page", true);
		gen.launch(utils.getProperty("url"));
		home.acceptCookies();
		home.navigateToOfferCreationPage();
		angebote.selectPrivatLiability();
		angebote.quationarePrivathaftpflicht();
		angebote.createPrivatLiabilityOffer();
		success.verifyStaticTextonSuceesPage(data.getTestData("Offer_Success_message"));
		success.verifyZumAngebotLink(data.getTestData("offer_Success_page"));
		home.navigateToHomePage();
		home.navigateToContractPage();
		managerPage.naviagteToContractDetails();
		managerPage.assertOffer();

	}

}