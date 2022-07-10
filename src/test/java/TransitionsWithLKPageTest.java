import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransitionsPageTest {
    private final String email = "alina22222@yandex.ru";
    private final String password = "12345678";
    LoginPage addUser;

    @Before
    public void enterAccount(){
        addUser= open(MainPage.URLLogin,
                LoginPage.class);
        addUser.loginUser(email,password);
    }

    //Переход в личный кабинет
    @Test
    public void loginFromLKWithMainPage () {
        addUser.clickLK();
        PersonalCabinet lkPage = page(PersonalCabinet.class);
        assertEquals("Прореряем видимость текста 'В этом разделе вы можете изменить свои персональные данные'", "В этом разделе вы можете изменить свои персональные данные", lkPage.getLKText());
    }

    //Выход из аккаунта
    @Test
    public void logoutWithLK () {
        addUser.clickLK();
        PersonalCabinet lkPage = page(PersonalCabinet.class);
        lkPage.clickExitLK();
        LoginPage logPage = page(LoginPage.class);
        assertTrue("Прореряем что, произошел переход на вкладку Вход", logPage.isVisibleTextOnPage("Вход"));
    }

    //Переход из личного кабинета в конструктор по кнопке Конструктор
    @Test
    public void goToTheMainPageWithLKFromConstructorButton () {
        addUser.clickLK();
        PersonalCabinet lkPage = page(PersonalCabinet.class);
        lkPage.clickConstructor();
        MainPage mainPage = page(MainPage.class);
        assertTrue("Прореряем что, перешли на страницу конструктор", mainPage.isVisibleTextWithConstructor());
    }

    //Переход из личного кабинета в конструктор по Лого
    @Test
    public void goToTheMainPageWithLKFromLogoButton () {
        addUser.clickLK();
        PersonalCabinet lkPage = page(PersonalCabinet.class);
        lkPage.clickLogo();
        MainPage mainPage = page(MainPage.class);
        assertTrue("Прореряем что, перешли на страницу конструктор", mainPage.isVisibleTextWithConstructor());
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
