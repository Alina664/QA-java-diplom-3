import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegisterUserWithDifferentLenghtPasswordTest extends BaseTest{

    private final String message;
    private final String email;
    private final String password;
    private final String name;
    private final Boolean expected;
    String token;

    public RegisterUserWithDifferentLenghtPasswordTest(String message, String email, String password, String name, Boolean expected) {
        this.message = message;
        this.email = email;
        this.password = password;
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getRegisterUserData() {
        return new Object[][] {
                { "Проверяем, что после регистрации перешли на страницу входа", "alina22222@yandex.ru", "12345678", "alina324323", true},
                { "Успешная регистрация", "alina22222@yandex.ru", "12345678", "alina324323", true},
                { "Успешная регистрация", "alina22222@yandex.ru", "12345678", "alina324323", true},
        };
    }

    @Test
    public void addUserDataWithHeaderMainPage () {
        LoginPage addUser= open(MainPage.URL,
                LoginPage.class);
        addUser.registerUser(email, password, name);
        LoginPage newPage = page(LoginPage.class);
        token = localStorage().getItem("accessToken");
        assertTrue(message,newPage.isVisibleTextOnPage("Вход"));
    }

    @After
    public void tearDown() {
        deleteUser(token);
        closeWebDriver();
    }
}
