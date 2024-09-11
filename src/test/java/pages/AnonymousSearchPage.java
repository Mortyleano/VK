package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymousSearchPage {

    private final SelenideElement tabCommunities = $("[data-testid='search_tab_communities']");
    private final SelenideElement tabPeople = $("[data-testid='search_tab_people']");
    private final SelenideElement searchResultPage = $("#results");
    private final SelenideElement verifiedPageIcon = $(".page_verified");

    @Step("Пользователь нажимает на вкладку 'Сообщества'")
    public void clickTabCommunities() {
        tabCommunities.click();
    }

    @Step("Пользователь нажимает на вкладку 'Люди'")
    public void clickTabPeople() {
        tabPeople.click();
    }

    @Step("Получаем наименование сообщества из результатов поиска")
    public String getCommunityName() {
        return searchResultPage.getText();
    }

    @Step("Получаем имя пользователя из результатов поиска")
    public String getUserName() {
        return searchResultPage.getText();
    }

    @Step("Проверяем отображение галочки для верифицированных страниц")
    public boolean getVerifiedPageIcon() {
        return verifiedPageIcon.is(visible);
    }
}