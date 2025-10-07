package code.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testing.qaautomationlabs.com/checkbox.php");
        Thread.sleep(2000);

        // Single Checkbox Demo
        WebElement singleCheckbox = driver.findElement(By.id("myCheckbox"));
        singleCheckbox.click();
        System.out.println("Single Checkbox selected: " + singleCheckbox.isSelected());
        Thread.sleep(1000);

// Check if the checkbox with id 'chk3' is disabled and
// Finds the checkbox by its id.
//Checks if it is enabled (isEnabled() returns false for disabled).
//Prints the result.
        WebElement chk3 = driver.findElement(By.id("chk3"));
        boolean isEnabled = chk3.isEnabled();
        System.out.println("Checkbox 'chk3' enabled: " + isEnabled);
        Thread.sleep(1000);

        /*
        // Multiple Checkbox Demo
        for (int i = 1; i <= 4; i++) {
            WebElement multiCheckbox = driver.findElement(By.xpath("//input[@class='cb1-element'][" + i + "]"));
            multiCheckbox.click();
            System.out.println("Multiple Checkbox " + i + " selected: " + multiCheckbox.isSelected());
            Thread.sleep(500);
        }

        driver.quit();

*/

// Select all checkboxes
        for (int i = 1; i <= 4; i++) {
            WebElement checkbox = driver.findElement(By.id("multichk" + i));
            checkbox.click();
            System.out.println("Checkbox " + i + " selected: " + checkbox.isSelected());
            Thread.sleep(500);
        }

// Click the toggle button to uncheck all
        WebElement toggleBtn = driver.findElement(By.id("toggleBtn"));
        toggleBtn.click();
        System.out.println("Clicked 'Uncheck All' button");
        Thread.sleep(1000);

// Click the toggle button to check all
        WebElement toggleBtn1 = driver.findElement(By.id("toggleBtn"));
        toggleBtn1.click();
        System.out.println("Clicked 'Check All' button");
        Thread.sleep(1000);

// Verify all checkboxes are unchecked
        for (int i = 1; i <= 4; i++) {
            WebElement checkbox = driver.findElement(By.id("multichk" + i));
            System.out.println("Checkbox " + i + " selected after toggle: " + checkbox.isSelected());
            Thread.sleep(500);
            System.out.println("All checkboxes are unchecked");
        }

        driver.quit();


    }
}
