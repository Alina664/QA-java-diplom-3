import io.qameta.allure.Epic;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
@Epic("Register user")
public class RegisterUserWithDifferentLengthPasswordTest{
    static LoginPage user = new LoginPage();
    private final String message;
    private final String email;
    private final String password;
    private final String name;
    private final Boolean expected;

    public RegisterUserWithDifferentLengthPasswordTest(String message, String email, String password, String name, Boolean expected) {
        this.message = message;
        this.email =  email;
        this.password = password;
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{0}: {1}, {2}, {3}") // добавили аннотацию
    public static Object[][] getRegisterUserData() {
        return new Object[][] {
                { "Проверяем регистрацию, с паролем из 5 символов", user.registerUserWithRandomData().get("email"),
                        user.registerUserWithRandomData().get("password").substring(5), user.registerUserWithRandomData().get("name"), true},
                { "Проверяем регистрацию, с паролем из 6 символов", user.registerUserWithRandomData().get("email"),
                        user.registerUserWithRandomData().get("password").substring(6), user.registerUserWithRandomData().get("name"), false},
                { "Проверяем регистрацию, с паролем из 7 символов", user.registerUserWithRandomData().get("email"),
                        user.registerUserWithRandomData().get("password").substring(7), user.registerUserWithRandomData().get("name"), false},
        };
    }

    @Test
    public void addUserDataWithHeaderMainPage () {
        LoginPage addUser= open(MainPage.URL,
                LoginPage.class);
        addUser.registerUser(email, password, name);
        LoginPage newPage = page(LoginPage.class);
        assertTrue(message,newPage.isVisibleErrorTextEnterPassword());
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
