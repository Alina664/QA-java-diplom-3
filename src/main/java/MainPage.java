import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    public static final String URLLogin = "https://stellarburgers.nomoreparties.site/login";

    //локатор для кнопки Оформить заказ c главной страницы
    @FindBy(how = How.XPATH,using = ".//button[text()='Оформить заказ']")
    private SelenideElement placeOrderButton;

    //локатор для кнопки Войти в аккаунт c главной страницы
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement enterInAccountButton;

    //локатор для кнопки Начинка в аккаунт c главной страницы
    @FindBy(how = How.XPATH,using = ".//span[text()='Начинки']")
    private SelenideElement ingredientButton;

    //локатор для кнопки Булки в аккаунт c главной страницы
    @FindBy(how = How.XPATH,using = ".//span[text()='Булки']")
    private SelenideElement bunButton;

    //локатор для кнопки Соусы в аккаунт c главной страницы
    @FindBy(how = How.XPATH,using = ".//span[text()='Соусы']")
    private SelenideElement sauceButton;

    //локатор для текста Собрать бургер c главной страницы
    @FindBy(how = How.XPATH,using = ".//section[@class='BurgerIngredients_ingredients__1N8v2']/h1")
    private SelenideElement assembleBurgerText;

    //локатор для текста Соусы c главной страницы
    @FindBy(how = How.XPATH,using = ".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Булки']")
    private SelenideElement bunTextOnIngredientList;

    //локатор для текста начинки c главной страницы
    @FindBy(how = How.XPATH,using = ".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Начинки']")
    private SelenideElement ingredientTextOnIngredientList;

    //локатор для текста Булки c главной страницы
    @FindBy(how = How.XPATH,using = ".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Соусы']")
    private SelenideElement sauceTextOnIngredientList;

    public Boolean isVisibleButtonEnterInAccount(){
        placeOrderButton.should(Condition.visible);
        return placeOrderButton.isDisplayed();
    }

    //метод клика по кнопке Ленты Заказов
    public void clickEnterAccount(){
        enterInAccountButton.click();
    }

    public Boolean isVisibleTextWithConstructor(){
        assembleBurgerText.should(Condition.visible);
        return assembleBurgerText.isDisplayed();
    }

    public void clickSauce(){
        sauceButton.click();
    }

    public void clickBun(){
        bunButton.click();
    }

    public void clickIngredients(){
        ingredientButton.click();
    }

    public Boolean isVisibleBun(){
        return bunTextOnIngredientList.isDisplayed();
    }

    public Boolean isVisibleSauce(){
        return sauceTextOnIngredientList.isDisplayed();
    }

    public Boolean isVisibleIngredients(){
        return ingredientTextOnIngredientList.isDisplayed();
    }

}
