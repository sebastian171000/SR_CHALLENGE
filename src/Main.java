import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
	public static WebDriver driver;
	
	public static void sendText(String label, String selectorType, String selector, String value){
        List<WebElement> elements = driver.findElements(By.tagName("label"));
        elements.add(driver.findElement(By.tagName("textArea")));
        for (WebElement el : elements) {
            if (label.contentEquals(el.getText())) {
            	if(selectorType.contentEquals("css")) driver.findElement(By.cssSelector(selector)).sendKeys(value);
            	if(selectorType.contentEquals("name")) driver.findElement(By.name(selector)).sendKeys(value);
            	if(selectorType.contentEquals("id"))  driver.findElement(By.id(selector)).sendKeys(value);
            	if(selectorType.contentEquals("xpath")) driver.findElement(By.xpath(selector)).sendKeys(value);
                break;
            }
        }
    	
    	
    }
	
	public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/sebastian171000/Documents/seleniumLab/chromedriver");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--kiosk");
        driver = new ChromeDriver(opt);
        driver.get("https://apprater.net/add/");
        //We can not search by id because no input has id for this example
        sendText("Your Name", "name", "user-submitted-name", "Sebastian Pajes");
        sendText("Email Address", "name", "user-submitted-email", "smpl3000@gmail.com");
        sendText("Product Title", "css", "#usp_form > fieldset.usp-title > input", "Gamarra Online");
        sendText("Product URL", "xpath", "//*[@id=\"usp_form\"]/div[4]/fieldset/input", "https://gamarraonlineperu.com/");
        sendText("", "xpath", "//*[@id=\"usp_form\"]/fieldset[2]/textarea", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec et molestie felis. Integer accumsan, nulla in cursus posuere, dolor tellus porttitor enim, et scelerisque dolor justo a metus. Pellentesque ullamcorper mattis mi, at pretium ligula semper nec. Donec est purus, pretium id scelerisque ut, viverra in lacus. Pellentesque turpis leo, pellentesque vel lacinia sit amet, egestas nec arcu. In egestas dui libero, ut euismod odio maximus quis. Aliquam suscipit, orci lobortis efficitur ornare, mi ipsum tincidunt ante, sed posuere odio orci ac ipsum. Cras in tristique massa, non elementum tortor. Nam tristique faucibus turpis in facilisis. Phasellus non ante ac libero tincidunt dapibus vel ac mauris. Aenean egestas ipsum nulla. Sed pellentesque libero sed purus posuere iaculis. Aenean dictum posuere urna, eget dapibus justo efficitur eu. Proin commodo ipsum sit amet scelerisque malesuada. Nunc dui ligula, imperdiet et quam nec, facilisis eleifend magna. Etiam sed tincidunt metus.");

	}
}
