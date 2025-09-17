package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstLaunch {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testing.qaautomationlabs.com/form.php");
        driver.quit();

    }
}
