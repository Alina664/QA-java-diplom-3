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
        assertEquals("Проверяем какая вкладка сейчас активна, д.б. соусы","Соусы", mainPage.getTextActiveTab());
    }

    @Test
    @Description("При нажатии на вкладку Начинки, а затем на Булки, в блоке с ингридиентами список перемещается к булкам")
    public void goToBun () {
        mainPage.clickIngredients();
        mainPage.clickBun();
        assertEquals("Проверяем какая вкладка сейчас активна, д.б. Булки", "Булки", mainPage.getTextActiveTab());
    }

    @Test
    @Description("При нажатии на вкладку Начинки, в блоке с ингридиентами список перемещается к Начинкам")
    public void goToIngredients () {
        mainPage.clickIngredients();
        assertEquals("Проверяем какая вкладка сейчас активна, д.б. Начинки", "Начинки", mainPage.getTextActiveTab());
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
