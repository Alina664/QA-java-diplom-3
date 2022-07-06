import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;

public class RegisterUserTest {

    @Test
    public void addUserDataWithHeaderMainPage () {

        //Configuration.browser = "firefox";
        // открывается страница и создаётся экземпляр класса страницы
        LoginPage addUser= open(MainPage.URL,
                LoginPage.class);
        addUser.registerUser("alina22222@yandex.ru","12345678","alina324323");
        LoginPage newPage = page(LoginPage.class);
        assertTrue("Проверяем, что после регистрации перешли на страницу входа",newPage.isVisibleContainText("Вход"));
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
