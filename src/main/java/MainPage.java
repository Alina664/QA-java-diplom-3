import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

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

    public Boolean isVisibleButtonEnterInAccount(){
        placeOrderButton.should(Condition.visible);
        return placeOrderButton.isDisplayed();
    }

    //метод клика по кнопке Ленты Заказов
    public void clickEnterAccount(){
        enterInAccountButton.click();
    }
}
