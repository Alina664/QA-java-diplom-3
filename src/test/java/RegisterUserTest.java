import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class RegisterUser {
    @Test
    public void addUserDataWithHeaderMainPage () {
        LoginPage addUser= open(MainPage.URL,
                LoginPage.class);
        addUser.registerUser(email, password, name);
        LoginPage newPage = page(LoginPage.class);
        token = localStorage().getItem("accessToken");
        assertTrue(message,newPage.isVisibleTextOnPage("Вход"));
    }
}
