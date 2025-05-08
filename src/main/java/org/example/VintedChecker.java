import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VintedChecker {
    public static void main(String[] args) {

        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sashi.SASHINIARJUNAN\\Desktop\\seleniumdrivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Start Chrome browser
        WebDriver driver = new ChromeDriver();

        try {
            // Open a Vinted item page
            driver.get("https://www.vinted.de/items/5542811760-sandqvist-bagpack?referrer=catalog");

            // Wait 3 seconds for the page to load
            Thread.sleep(3000);

            // Check if the item is sold (looks for "Verkauft" text)
            WebElement soldTag = driver.findElement(By.xpath("//*[contains(text(),'Verkauft')]"));

            if (soldTag != null && soldTag.isDisplayed()) {
                System.out.println("✅ Item is SOLD!");
            } else {
                System.out.println("❌ Item is NOT sold.");
            }

        } catch (Exception e) {
            System.out.println("❌ Sold tag not found. Item might be unsold.");
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
