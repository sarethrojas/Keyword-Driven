package com.testerfabrik.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Properties;

public class UIOperations {
    WebDriver driver;

    public UIOperations(WebDriver driver){
        this.driver = driver;
    }

    private WebElement getObject(Properties p, String objName, String locatorType) throws Exception {
        switch (locatorType.toLowerCase()){
            case "id":
                return driver.findElement(By.id(p.getProperty(objName)));
            case "xpath":
                return driver.findElement(By.xpath(p.getProperty(objName)));
            case "name":
                return driver.findElement(By.name(p.getProperty(objName)));
            case "link":
                return driver.findElement(By.linkText(p.getProperty(objName)));
            case "partiallink":
                return driver.findElement(By.partialLinkText(p.getProperty(objName)));
            case "css":
                return driver.findElement(By.cssSelector(p.getProperty(objName)));
            case "class":
                return driver.findElement(By.className(p.getProperty(objName)));
            case "tagname":
                return driver.findElement(By.tagName(p.getProperty(objName)));
            default:
                throw new Exception("Wrong locator type");
        }
    }

    public void perform(Properties p, String operation, String objName, String locatorType, String value) throws Exception {
        switch(operation.toLowerCase()){
            case "click":
                this.getObject(p,objName, locatorType).click();
                break;
            case "settext":
                this.getObject(p,objName, locatorType).sendKeys(value);
                break;
            case "gotourl":
                driver.get(p.getProperty(value));
                break;
            case "gettext":
                this.getObject(p,objName, locatorType).getText();
                break;
            case "selectbytext":
                new Select(this.getObject(p,objName, locatorType)).selectByVisibleText(value);
                break;
            case "close":
                driver.quit();
                break;
            default:
                throw new Exception("Wrong action keyword!");
        }

    }
}
