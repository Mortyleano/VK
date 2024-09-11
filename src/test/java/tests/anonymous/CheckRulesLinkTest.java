package tests.anonymous;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import tests.TestBase;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckRulesLinkTest extends TestBase {

    private static final String HEADER_TEXT = "VK Terms of Service";

    @Test
    @Tag("smoke") @Tag("anonymous") @Tag("links")
    @DisplayName("Тест проверяет открытие страницы с правилами пользования сайта в анонимном режиме")
    void rulesLinkTest() {
        openSite();
        MainPage mainPage = new MainPage();
        mainPage.clickRulesLink();
        assertThat(mainPage.getSubHeaderText())
                .as("Отсутствует ожидаемый подзаголовок страницы")
                .contains(HEADER_TEXT);
    }
}