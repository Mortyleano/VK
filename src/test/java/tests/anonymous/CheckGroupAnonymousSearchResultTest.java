package tests.anonymous;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AnonymousSearchPage;
import pages.MainPage;
import tests.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Проверка результатов анонимного поиска по наименованию группы")
public class CheckGroupAnonymousSearchResultTest extends TestBase {

    private static final String COMMUNITY_NAME = "Пикабу";

    @Test
    @Tag("smoke") @Tag("search") @Tag("anonymous")
    @DisplayName("Проверяет результаты анонимного поиска по наименованию группы")
    void groupAnonymousSearchResultTest() {
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();
        mainPage.clickAndSearchRequest(COMMUNITY_NAME);
        AnonymousSearchPage anonymousSearchPage = new AnonymousSearchPage();
        anonymousSearchPage.clickTabCommunities();
        assertThat(anonymousSearchPage.getCommunityName())
                .contains(COMMUNITY_NAME)
                .as("Отсутствует сообщество в результатах поиска");
        assertThat(anonymousSearchPage.getVerifiedPageIcon())
                .isTrue()
                .as("Отсутствует галочка верификации возле наименования сообщества");
    }
}