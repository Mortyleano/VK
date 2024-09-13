package tests.anonymous;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AnonymousSearchPage;
import pages.MainPage;
import tests.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Проверка результатов анонимного поиска по имени пользователя")
public class CheckUserAnonymousSearchResultTest extends TestBase {

    private static final String USER_NAME = "Pavel Durov";

    @Test
    @Tag("smoke") @Tag("anonymous") @Tag("search")
    @DisplayName("Проверяет результаты анонимного поиска по имени пользователя")
    void userAnonymousSearchResultTest() {
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();
        mainPage.clickAndSearchRequest(USER_NAME);
        AnonymousSearchPage anonymousSearchPage = new AnonymousSearchPage();
        anonymousSearchPage.clickTabPeople();
        assertThat(anonymousSearchPage.getUserName())
                .contains(USER_NAME)
                .as("Отсутствует пользователь в результатах поиска");
        assertThat(anonymousSearchPage.getVerifiedPageIcon())
                .isTrue()
                .as("Отсутствует галочка верификации возле имени пользователя");
    }
}