package tests.anonymous;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AnonymousSearchPage;
import pages.MainPage;
import tests.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckGroupAnonymousSearchResultTest extends TestBase {

    private static final String COMMUNITY_NAME = "Пикабу";

    @Test
    @Tag("smoke") @Tag("search") @Tag("anonymous")
    @DisplayName("Тест проверяет результаты анонимного поиска по наименованию группы")
    void groupAnonymousSearchResultTest() {
        openSite();
        new MainPage().clickAndSearchRequest(COMMUNITY_NAME);
        AnonymousSearchPage anonymousSearchPage = new AnonymousSearchPage();
        anonymousSearchPage.clickTabCommunities();
        assertThat(anonymousSearchPage.getCommunityName())
                .as("Отсутствует сообщество в результатах поиска")
                .contains(COMMUNITY_NAME);
        assertThat(anonymousSearchPage.getVerifiedPageIcon())
                .as("Отсутствует галочка верификации возле наименования сообщества")
                .isTrue();
    }
}