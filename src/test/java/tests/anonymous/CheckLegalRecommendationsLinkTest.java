package tests.anonymous;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import tests.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Проверка открытия страницы с правилами применения рекомендательных технологий сайта в анонимном режиме")
public class CheckLegalRecommendationsLinkTest extends TestBase {

    private static final String HEADER_TEXT = "Правила применения рекомендательных технологий социальной сети ВКонтакте";

    @Test
    @Tag("smoke") @Tag("anonymous") @Tag("links")
    @DisplayName("Проверяет открытие страницы с правилами применения рекомендательных технологий сайта в анонимном режиме")
    void legalRecommendationsLinkTest() {
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();
        mainPage.clickLegalRecommendationsLink();
        assertThat(mainPage.getSubHeaderText())
                .contains(HEADER_TEXT)
                .as("Отсутствует ожидаемый подзаголовок страницы");
    }
}