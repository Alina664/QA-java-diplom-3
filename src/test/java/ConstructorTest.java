import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.localStorage;
import static org.junit.Assert.*;

public class ContructorTest {

    @Test
    public void goToSauce () {
        //Configuration.browser = "firefox";
        // открывается страница и создаётся экземпляр класса страницы
        MainPage mainPage= open(MainPage.URL,
                MainPage.class);
        mainPage.clickSauce();
        assertTrue("message",mainPage.isVisibleSauce());
    }

    @Test
    public void goToBun () {
        //Configuration.browser = "firefox";
        // открывается страница и создаётся экземпляр класса страницы
        MainPage mainPage= open(MainPage.URL,
                MainPage.class);
        mainPage.clickIngredients();
        mainPage.clickBun();
        assertTrue("message",mainPage.isVisibleIngredients());
    }

    @Test
    public void goToIngredients () {
        //Configuration.browser = "firefox";
        // открывается страница и создаётся экземпляр класса страницы
        MainPage mainPage= open(MainPage.URL,
                MainPage.class);
        mainPage.clickIngredients();
        assertTrue("message", mainPage.isVisibleIngredients());
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
