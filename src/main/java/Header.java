import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Header {

    //локатор-ссылка для перехода на форму с конструктором
    @FindBy(how = How.XPATH,using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    //локатор-ссылка для перехода на форму ленты заказов
    @FindBy(how = How.XPATH,using = ".//p[text()='Лента Заказов']")
    private SelenideElement orderFeedButton;

    //локатор-ссылка для лого сайта
    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoStellarBurgersButton;

    //локатор-ссылка для перехода в личный кабинет
    @FindBy(how = How.XPATH,using = ".//p[text()='Личный Кабинет']")
    private SelenideElement lkButton;

    //метод клика по кнопке Конструктор
    public void clickConstructor(){
        constructorButton.click();
    }

    //метод клика по кнопке Ленты Заказов
    public void clickOrderFeed(){
        orderFeedButton.click();
    }

    //метод клика по лого
    public void clickLogo(){
        logoStellarBurgersButton.click();
    }

    //метод клика по кнопке Личный Кабинет
    public void clickLK(){
        lkButton.click();
    }
}
