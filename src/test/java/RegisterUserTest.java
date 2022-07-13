import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

@Epic("Register user")
public class RegisterUserTest {
    LoginPage user = new LoginPage();
    private final String email = user.registerUserWithRandomData().get("email");
    private final String password = user.registerUserWithRandomData().get("password");
    private final String name = user.registerUserWithRandomData().get("name");

   @Test
   @Description("Проверяем, что при регистрации происходит переход на страницу Вход")
    public void registerUserSuccess () {
        LoginPage addUser= open(MainPage.URL,
                LoginPage.class);
        addUser.registerUser(email, password, name);
        LoginPage newPage = page(LoginPage.class);
        assertTrue("Проверяем, что произошел переход на страницу Входа",newPage.isVisibleTextOnPage("Вход"));
    }
}
