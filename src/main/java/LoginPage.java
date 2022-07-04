import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    //локатор-ссылка для заполнения email
    @FindBy(how = How.XPATH,using = ".//label[text()='Email']")
    private SelenideElement emailField;

    //локатор-ссылка для заполнения пароля
    @FindBy(how = How.CLASS_NAME,using = "input__container")
    private SelenideElement passwordField;

    //локатор для кнопки Войти
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти']")
    private SelenideElement enterButton;

    //локатор-ссылка для перехода по кнопке Зарегистрироваться
    @FindBy(how = How.XPATH,using = ".//a[href='\register']")
    private SelenideElement authButton;

    //локатор-ссылка для перехода Восстановления пароля
    @FindBy(how = How.XPATH,using = ".//a[text()='Восстановить пароль']")
    private SelenideElement recoverPasswordButton;

}
