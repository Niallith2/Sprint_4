package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    //Локатор кнопки заказа в шапке сайта
    private By orderButtonInHeadderLocator = By.cssSelector(".Header_Nav__AGCXC > button.Button_Button__ra12g");
    //Локатор кнопки заказа в теле сайта
    private By orderButtonInRoadmapLocator = By.className("Button_Button__ra12g Button_UltraBig__UU3Lp");
    //Локатор кнопки статуса заказа
    private By orderStatusButtonLocator = By.cssSelector(".Header_Link__1TAG7");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public OrderPage clickOnOrderButtonInHeadder(){
        driver.findElement(orderButtonInHeadderLocator).click();
        return new OrderPage(driver);
    }

    public OrderPage clickOnOrderButtonInRoadmap(){
        driver.findElement(orderButtonInRoadmapLocator).click();
        return new OrderPage(driver);
    }

}
