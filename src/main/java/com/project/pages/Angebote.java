package com.project.pages;

import org.openqa.selenium.By;
import org.testng.Reporter;

import com.project.base.TestBase;

public class Angebote extends TestBase {

	private final By privathaftpflicht = By
			.xpath("//div[contains(@class,'box _content_1ner8p')]/span[text()=\"Privathaftpflicht\"]");

	private final By loslegen = By.xpath("//span[text()=\"Loslegen\"]/../../button[contains(@class,'ember-view _button')]");
	private final By answer2 = By.xpath("//input[@value=\"Ja\"]/../span");
	private final By answer3 = By.xpath("//input[@value=\"Ja, bis zu 150 Euro\"]/../span");
	private final By weiter = By.xpath("//button[contains(@class,'btn btn-primary btn')]");
	private final By Angebot_anfordern = By.xpath("//button[text()=\"Angebot anfordern\"]");

	public void selectPrivatLiability() {
		Reporter.log("Selecting the privathaftpflicht offer ", true);
		gen.waitAndClickByXpath(privathaftpflicht);
		com.setVariable("offer_name", "privathaftpflicht");
		gen.waitAndClickByXpath(loslegen);

	}

	public void quationarePrivathaftpflicht() {
		gen.waitAndClickByXpath(weiter);
		gen.waitAndClickByXpath(answer2);
		gen.waitAndClickByXpath(answer3);

	}

	public void createPrivatLiabilityOffer() {
		Reporter.log("Confirmation for create offer ", true);
		gen.waitAndClickByXpath(Angebot_anfordern);
	}

}
