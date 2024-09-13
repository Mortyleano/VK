package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement rulesLink = $("[href='/terms']");
    private final SelenideElement legalRecommendationsLink = $("a.LegalRecommendationsLink__link");
    private final SelenideElement subHeader = $(".wikiSubHeader, .wikiHeader");
    private final SelenideElement searchInput = $("[data-testid='search_top_input']");

    @Step("Открываем главную страницу сайта VK.com")
    public void openMainPage() {
        open(baseUrl);
    }

    @Step("Пользователь нажимает на ссылку 'Правила'")
    public void clickRulesLink() {
        rulesLink.click();
    }

    @Step("Пользователь нажимает на ссылку 'Применяются рекомендательные технологии'")
    public void clickLegalRecommendationsLink() {
        legalRecommendationsLink.scrollIntoView(true).click();
    }

    @Step("Пользователь нажимает на инпут поиска")
    public void clickAndSearchRequest(String text) {
        searchInput.click();
        searchInput.setValue(text).pressEnter();
    }

    @Step("Получаем подзаголовок на странице с правилами")
    public String getSubHeaderText() {
        return subHeader.getText();
    }
}