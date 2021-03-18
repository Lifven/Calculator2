package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
//import io.cucumber.java.After;

public class StepDefinitions {

    WebDriver driver;

    @Before
    public void init() {
    }

    @Given("I have navigated to the calculator")
    public void iHaveNavigatedToTheCalculator() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver(); // Starta chrome

        driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php"); // Navigera till google.com
        driver.manage().window().maximize(); // Gör fönstret stort
        Thread.sleep(1000);  // Let the user actually see something! Väntar 5 sek.
    }

    @Given("I have entered {int} into the calculator")
    public void i_have_entered_into_the_calculator(int firstNumber) throws InterruptedException {

        WebElement searchBox = driver.findElement(By.name("n01")); // Hitta sökfältet "q"
        searchBox.sendKeys(Integer.toString(firstNumber)); // Skriver in chromedriver i sökfältet

        //   searchBox.sendKeys(Keys.ENTER);
        //searchBox.submit(); // Skickar data som finns i sökfältet
    }

    @Given("I have also entered {int} into the calculator")
    public void i_have_also_entered_into_the_calculator(int secondNumber) throws InterruptedException {

        WebElement searchBox = driver.findElement(By.name("n02")); // Hitta sökfältet "q"
        searchBox.sendKeys(Integer.toString(secondNumber)); // Skriver in chromedriver i sökfältet
        Thread.sleep(1000);
        //   searchBox.sendKeys(Keys.ENTER);
    }

    @When("I press add")
    public void i_press_add() throws InterruptedException {

        WebElement enterBox = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[4]/input"));
        //  enterBox.submit();
        enterBox.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    @Then("the result should be {int} on the screen")
    public void the_result_should_be_on_the_screen(int result) throws InterruptedException {

        WebElement answer = driver.findElement(By.name("answer"));
        Assert.assertEquals(result, Integer.parseInt(answer.getAttribute("value")));
       // Thread.sleep(1000);  // Let the user actually see something!
        driver.quit();
    }

}
