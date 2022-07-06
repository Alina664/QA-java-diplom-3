import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    @Test
    public void loginFromLKButtonMainPage () {
        LoginPage addUser= open(MainPage.URL,
                LoginPage.class);
        addUser.clickLK();
        addUser.loginUser("alina22222@yandex.ru","12345678");
        MainPage mainPage = page(MainPage.class);
        assertTrue("Прореряем видимость кнопки Оформить заказ после регистрации", mainPage.isVisibleButtonEnterInAccount());
    }

    @Test
    public void loginFromEnterAccountMainPage () {
        MainPage mainPage= open(MainPage.URL,
                MainPage.class);
        mainPage.clickEnterAccount();
        LoginPage addUser = page(LoginPage.class);
        addUser.loginUser("alina22222@yandex.ru","12345678");
        assertTrue("Прореряем видимость кнопки Оформить заказ после регистрации", mainPage.isVisibleButtonEnterInAccount());
    }

    @Test
    public void loginFromRecoveryPassword () {
        LoginPage loginPage= open(MainPage.URL,
                LoginPage.class);
        loginPage.clickLK();
        loginPage.clickLinkRecoveryPassword();
        loginPage.clickLinkEnterFromRegistry();
        loginPage.loginUser("alina22222@yandex.ru","12345678");
        MainPage mainPage = page(MainPage.class);
        assertTrue("Прореряем видимость кнопки Оформить заказ после регистрации", mainPage.isVisibleButtonEnterInAccount());
    }

    @Test
    public void loginFromRegisterForm () {
        LoginPage loginPage= open(MainPage.URL,
                LoginPage.class);
        loginPage.clickLK();
        loginPage.clickLinkRegisterUser();
        loginPage.clickLinkEnterFromRegistry();
        loginPage.loginUser("alina22222@yandex.ru","12345678");
        MainPage mainPage = page(MainPage.class);
        assertTrue("Прореряем видимость кнопки Оформить заказ после регистрации", mainPage.isVisibleButtonEnterInAccount());
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
