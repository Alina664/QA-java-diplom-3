import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.Map;

public class LoginPage extends Header{

    //локатор-ссылка для заполнения email
    @FindBy(how = How.XPATH,using = ".//label[text()='Email']/following::input")
    private SelenideElement emailField;

    //локатор-ссылка для заполнения пароля
    @FindBy(how = How.XPATH,using = ".//label[text()='Пароль']/following::input")
    private SelenideElement passwordField;

    //локатор для текста ошибки в количестве символов для пароля при регистрации
    @FindBy(how = How.XPATH,using = ".//label[text()='Пароль']/following::input")
    private SelenideElement passwordErrorText;

    //локатор-ссылка для заполнения имени
    @FindBy(how = How.XPATH,using = ".//label[text()='Имя']/following::input")
    private SelenideElement nameField;

    //локатор для кнопки Войти c формы авторизации
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти']")
    private SelenideElement enterButton;

    //локатор-ссылка для перехода по ссылке Зарегистрироваться
    @FindBy(how = How.XPATH,using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registerLink;

    //локатор-ссылка для перехода по кнопке Зарегистрироваться
    @FindBy(how = How.XPATH,using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    //локатор-ссылка для перехода Восстановления пароля
    @FindBy(how = How.XPATH,using = ".//a[text()='Восстановить пароль']")
    private SelenideElement recoveryPasswordLink;

    //локатор-ссылка для перехода Войти
    @FindBy(how = How.XPATH,using = ".//a[text()='Войти']")
    private SelenideElement enterLink;

    //локатор для текста из формы
    @FindBy(how = How.XPATH,using = ".//div[@class='Auth_login__3hAey']/h2")
    private SelenideElement textAuthFormLink;

    public void setNameUser(String name){
        nameField.doubleClick();
        nameField.setValue(name);
    }

    public void setEmailUser(String email){
        emailField.doubleClick();
        emailField.setValue(email);
    }

    public void setPasswordUser(String password){
        passwordField.doubleClick();
        passwordField.setValue(password);
    }

    public void registerUser(String email, String password, String name){
        clickLK();
        clickLinkRegisterUser();
        setNameUser(name);
        setEmailUser(email);
        setPasswordUser(password);
        clickButtonRegisterUser();
    }

    public void loginUser(String email, String password){
        setEmailUser(email);
        setPasswordUser(password);
        enterButton.click();
    }

    public String getTextAuthForm(){
        return textAuthFormLink.getText();
    }

    public String getErrorTextEnterPassword(){
        return passwordErrorText.getText();
    }

    public Boolean isVisibleTextOnPage(String textFind){
        return textAuthFormLink.shouldHave(Condition.text(textFind)).isDisplayed();
    }

    public Boolean isVisibleErrorTextEnterPassword(){
        return passwordErrorText.isDisplayed();
    }

    public void clickLinkRecoveryPassword(){
        recoveryPasswordLink.click();
    }

    public void clickLinkEnterFromRegistry(){
        enterLink.click();
    }

    public void clickLinkRegisterUser(){
        registerLink.click();
    }

    public void clickButtonRegisterUser(){
        registerButton.click();
    }

    public HashMap<String, String> registerUserWithRandomData(){
        HashMap<String, String> account = new HashMap<>();
        // метод randomAlphabetic генерирует строку, состоящую только из букв, в качестве параметра передаём длину строки
        String userEmail = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        // с помощью библиотеки RandomStringUtils генерируем пароль
        String userPassword = RandomStringUtils.randomAlphabetic(10);
        // с помощью библиотеки RandomStringUtils генерируем имя курьера
        String userName = RandomStringUtils.randomAlphabetic(10);
        account.putAll(Map.of("email", userEmail,"password", userPassword,"name", userName));
        return account;
    }
}
