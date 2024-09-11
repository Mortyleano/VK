package tests.anonymous;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import tests.TestBase;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckLegalRecommendationsLinkTest extends TestBase {

    private static final String HEADER_TEXT = "Правила применения рекомендательных технологий социальной сети ВКонтакте";

    @Test
    @Tag("smoke") @Tag("anonymous") @Tag("links")
    @DisplayName("Тест проверяет открытие страницы с правилами применения рекомендательных технологий сайта в анонимном режиме")
    void legalRecommendationsLinkTest() {
        open(baseUrl);
        MainPage mainPage = new MainPage();
        mainPage.clickLegalRecommendationsLink();
        assertThat(mainPage.getSubHeaderText())
                .as("Отсутствует ожидаемый подзаголовок страницы")
                .contains(HEADER_TEXT);
    }
}