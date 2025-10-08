package code.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GenderRadioButtonDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("https://testing.qaautomationlabs.com/radio-button.php");
            driver.manage().window().maximize();

            //1)------------------ Select "Male" radio button by CSS selector------------
            // CSS path = .card-tools label:nth-of-type(2) input
            WebElement maleRadio = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='gender'][value='Male']")));
            maleRadio.click();
            Thread.sleep(1000);

            // Click the "Show Selected Gender" button ----  .card-tools button
            WebElement showBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-primary")));
            showBtn.click();

            // Get and print the result text
            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#result")));
            System.out.println("Result: " + result.getText());
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // Select "Female" radio button by CSS selector & path = .card-tools label:nth-of-type(2) input
        try {
            WebElement FemaleRadio = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".card-tools label:nth-of-type(2) input")));
            FemaleRadio.click();
            Thread.sleep(1000);

            // Click the "Show Selected Gender" button
            WebElement showBtn1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-primary")));
            showBtn1.click();

            // Get and print the result text
            WebElement result1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#result")));
            System.out.println("Result: " + result1.getText());
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        // 2------------------ Select "Radio Button 1" -- input[value='Radio Button 1']----------------

        try{
            WebElement radio1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='gender1'][value='Radio Button 1']")));
            radio1.click();
            System.out.println("Radio Button 1 selected: " + radio1.isSelected());
            Thread.sleep(1000);

            // Select "Radio Button 2" -- input[value='Radio Button 2']
            WebElement radio2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='gender1'][value='Radio Button 2']")));
            radio2.click();
            System.out.println("Radio Button 2 selected: " + radio2.isSelected());
            Thread.sleep(1000);

            // Check if "Disabled Radio Button" is disabled -- input[value='Disabled Radio Button']
            // .card-tools label:nth-of-type(3) input
            WebElement disabledRadio = driver.findElement(By.cssSelector("input[name='gender1'][value='Disabled Radio Button']"));
          // OR------  System.out.println("Disabled Radio Button enabled: " + disabledRadio.isEnabled());
            boolean isEnabled = disabledRadio.isEnabled();
            System.out.println("Disabled Radio Button enabled: " + isEnabled);

            Thread.sleep(1000);

        } catch(Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
              //  finally {
               //     driver.quit();
             //   }

/*
 // 3)---Single Workflow -> "Female" for Gender --- .col-6 label:nth-of-type(2) input[value='Female']
 // "18-35" for Age Group --- .col-6 label:nth-of-type(2) input[value='18-35']

        try {
        WebElement femaleRadio = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='gender1'][value='Female']")));
        femaleRadio.click();
        Thread.sleep(1000);

        // Select "18-35" for Age Group
        WebElement ageRadio = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='age1'][value='18-35']")));
        ageRadio.click();
        Thread.sleep(1000);

        // Click the "Show Selected Values" button
        WebElement showBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-primary")));
        showBtn.click();
        Thread.sleep(1000);

        // Get and print the result text
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#result3")));
        System.out.println("Result: " + result.getText());
        Thread.sleep(1000);

    } catch(Exception e)
    {
        System.out.println("Exception occurred: " + e.getMessage());
                }



// 3)------------------ Iterate through all combinations -----------------------------------
       public class GenderAgeAllCombinationsDemo {
            public static void main(String[] args) {
                WebDriver driver = new ChromeDriver();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        */

      try{

        String[] genders = {"Male", "Female"};
        String[] ages = {"Under 18", "18-35", "35+"};

        // Iterate through all combinations of-----------------------
          // .col-6:nth-of-type(2) label:nth-of-type(1) input  OR---- .col-6:nth-of-type(2) label input
          // .col-6:nth-of-type(2) label:nth-of-type(2) input  --- 18-35
          // .col-6:nth-of-type(2) label:nth-of-type(3) input  --- 35+

            for (String gender : genders) {
                for (String age : ages) {
                    try {
                        // Select gender radio
                        WebElement genderRadio = wait.until(ExpectedConditions.elementToBeClickable(
                                By.cssSelector("input[name='gender1'][value='" + gender + "']")));
                        genderRadio.click();

                        // Select age radio
                        WebElement ageRadio = wait.until(ExpectedConditions.elementToBeClickable(
                                By.cssSelector("input[name='age1'][value='" + age + "']")));
                        ageRadio.click();

                        // Click the button --- .col-12 button[onclick='showSelectedValues()']
                        WebElement showBtn = wait.until(ExpectedConditions.elementToBeClickable(
                                By.cssSelector(".col-12 button[onclick='showSelectedValues()']")));
                        showBtn.click();

                        // Get and print the result
                        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.cssSelector("p#result3")));
                        System.out.println("Selected: Gender = " + gender + ", Age Group = " + age);
                        System.out.println("Result: " + result.getText());
                        Thread.sleep(2000);
                            } catch (Exception e) {
                                System.out.println("Exception for Gender=" + gender + ", Age=" + age + ": " + e.getMessage());
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("General Exception: " + e.getMessage());
                }
        //finally {
         //           driver.quit();
        //        }
            }
        }










