import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

@Epic("Login user")
public class LoginTest {

    private final String email = "alina22222212@yandex.ru";
    private final String password = "12345678";

    @Test
    @Description("вход через кнопку «Личный кабинет»")
    public void loginFromLKButtonMainPage () {
        LoginPage addUser= open(MainPage.URL,
                LoginPage.class);
        addUser.clickLK();
        addUser.loginUser(email,password);
        MainPage mainPage = page(MainPage.class);
        assertTrue("Прореряем видимость кнопки Оформить заказ после регистрации", mainPage.isVisibleButtonEnterInAccount());
    }

    @Test
    @Description("вход по кнопке «Войти в аккаунт» на главной")
    public void loginFromEnterAccountMainPage () {
        MainPage mainPage= open(MainPage.URL,
                MainPage.class);
        mainPage.clickEnterAccount();
        LoginPage addUser = page(LoginPage.class);
        addUser.loginUser(email,password);
        assertTrue("Прореряем видимость кнопки Оформить заказ после регистрации", mainPage.isVisibleButtonEnterInAccount());
    }

    @Test
    @Description("вход через кнопку в форме восстановления пароля")
    public void loginFromRecoveryPassword () {
        LoginPage loginPage= open(MainPage.URL,
                LoginPage.class);
        loginPage.clickLK();
        loginPage.clickLinkRecoveryPassword();
        loginPage.clickLinkEnterFromRegistry();
        loginPage.loginUser(email,password);
        MainPage mainPage = page(MainPage.class);
        assertTrue("Прореряем видимость кнопки Оформить заказ после регистрации", mainPage.isVisibleButtonEnterInAccount());
    }

    @Test
    @Description("вход через кнопку в форме регистрации")
    public void loginFromRegisterForm () {
        LoginPage loginPage= open(MainPage.URL,
                LoginPage.class);
        loginPage.clickLK();
        loginPage.clickLinkRegisterUser();
        loginPage.clickLinkEnterFromRegistry();
        loginPage.loginUser(email,password);
        MainPage mainPage = page(MainPage.class);
        assertTrue("Прореряем видимость кнопки Оформить заказ после регистрации", mainPage.isVisibleButtonEnterInAccount());
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
