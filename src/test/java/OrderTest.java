import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageObjects.MainPage;
import pageObjects.OrderAboutRentPage;
import pageObjects.OrderPage;

import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest{
    private String name;
    private String secondName;
    private String address;
    private String metro;
    private String phone;
    private String rentDate;
    private int rentTermID;
    private int colorID;
    private String courierComment;

    public OrderTest(String name, String secondName, String address, String metro, String phone,
                     String rentDate, int rentTermID, int colorID, String courierComment) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.rentDate = rentDate;
        this.rentTermID = rentTermID;
        this.colorID = colorID;
        this.courierComment = courierComment;
    }

    @Parameterized.Parameters
    public static Object[][] Data() {
        return new Object[][] {
                {"Тест","Тестиков","Тестовая 123","ВДНХ","88005553535","24.04.2024", 0, 0, "Тестовый комментарий"},
                {"Евгений","Тестов","ул.Левая-Правая 45А кв.23","Курская","83479166666","15.10.2024", 1, 1, "Проверка"},

        };
    }

    @Test
    public void scooterOrderTest(){
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = mainPage.clickOnOrderButtonInHeadder();
        OrderAboutRentPage orderAboutRentPage = orderPage.fillOrderDetails(name, secondName,address,metro,phone);
        orderAboutRentPage.order(rentDate, rentTermID,colorID,courierComment);
        Assert.assertTrue(orderAboutRentPage.isOrderProcessed());

    }
}
