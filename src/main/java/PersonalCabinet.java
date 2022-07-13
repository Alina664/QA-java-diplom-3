import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalCabinet extends Header{
    //локатор для кнопки Оформить заказ c главной страницы
    @FindBy(how = How.XPATH,using = ".//nav[@class='Account_nav__Lgali']/p")
    private SelenideElement textLK;

    //локатор для кнопки Выход c формы авторизации
    @FindBy(how = How.XPATH,using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;

    public String getLKText(){
        return textLK.shouldHave(Condition.visible).getText();
    }

    public void clickExitLK(){
        logoutButton.click();
    }
}
