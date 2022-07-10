import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;

@Epic("Section 'Constructor'")
public class ConstructorTest {
    MainPage mainPage;

    @Before
    public void openURL(){
        mainPage= open(MainPage.URL, MainPage.class);
    }

    @Test
    @Description("При нажатии на вкладку Соусы, в блоке с ингридиентами список перемещается к соусам")
    public void goToSauce () {
        mainPage.clickSauce();
        assertTrue("Проверяем видимость слова Соусы",mainPage.isVisibleSauce());
    }

    @Test
    @Description("При нажатии на вкладку Начинки, в блоке с ингридиентами список перемещается к начинкам")
    public void goToBun () {
        mainPage.clickIngredients();
        mainPage.clickBun();
        assertTrue("Проверяем видимость слова Начинки",mainPage.isVisibleIngredients());
    }

    @Test
    @Description("При нажатии на вкладку Булки, в блоке с ингридиентами список перемещается к булкам")
    public void goToIngredients () {
        mainPage.clickIngredients();
        assertTrue("Проверяем видимость слова Булки", mainPage.isVisibleIngredients());
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
