package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @Author Robbe Delarbre r0803569 en Lorenzo Catalano r0790963
 */

public class HomePage extends Page {

    @FindBy(id="userId")
    private WebElement userIdField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(id="signUp")
    private WebElement loginButton;

    @FindBy(css = "#content-wrap > header > nav > ul > li:nth-child(5) > a")
    private WebElement logoutButton;

    public HomePage (WebDriver driver) {
        super(driver);
        this.driver.get(path+"?command=Home");
    }

    public void setUserId(String userId) {
        userIdField.clear();
        userIdField.sendKeys(userId);
    }

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void submitForm() {
        loginButton.click();
    }

    public boolean isLoggedIn(String userId) {
        return driver.findElement(By.xpath("/html/body/div/div/main/p")).getText().equals("Welcome, " + userId + "!");
    }

    public boolean hasErrorMessage(String errorMessage) {
        return driver.findElement(By.cssSelector("#content-wrap > main > div")).getText().equals(errorMessage);
    }

    public boolean hasSuccesMessage(String succesMessage) {
        return driver.findElement(By.cssSelector("#content-wrap > main > p")).getText().equals(succesMessage);
    }

    public void loginAsUser() {
        setUserId("t");
        setPassword("t");
        submitForm();
    }

    public void loginAsAdmin() {
        setUserId("admin");
        setPassword("admin");
        submitForm();
    }

    public void logout() {
        logoutButton.click();
    }

    public boolean loginButtonIsPresent(){
        try {
            driver.findElement(By.id("login"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean logoutButtonIsPresent(){
        try {
            driver.findElement(By.id("logout"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}