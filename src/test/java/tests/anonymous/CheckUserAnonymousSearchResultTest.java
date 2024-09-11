package tests.anonymous;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AnonymousSearchPage;
import pages.MainPage;
import tests.TestBase;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckUserAnonymousSearchResultTest extends TestBase {

    private static final String USER_NAME = "Pavel Durov";

    @Test
    @Tag("smoke") @Tag("anonymous") @Tag("search")
    @DisplayName("Тест проверяет результаты анонимного поиска по имени пользователя")
    void userAnonymousSearchResultTest() {
        openSite();
        new MainPage().clickAndSearchRequest(USER_NAME);
        AnonymousSearchPage anonymousSearchPage = new AnonymousSearchPage();
        anonymousSearchPage.clickTabPeople();
        assertThat(anonymousSearchPage.getUserName())
                .as("Отсутствует пользователь в результатах поиска")
                .contains(USER_NAME);
        assertThat(anonymousSearchPage.getVerifiedPageIcon())
                .as("Отсутствует галочка верификации возле имени пользователя")
                .isTrue();
    }
}