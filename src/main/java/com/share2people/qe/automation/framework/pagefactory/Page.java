package com.share2people.qe.automation.framework.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jcabi.aspects.Loggable;
import com.share2people.automation.framework.TestSession;

/**
 *
 * @author nimit.jain
 */
@Loggable(Loggable.DEBUG)
public class Page {
    
    public static TestSession session;
    public YamlPage pageUI;
    public String pageYamlFile;
    public Boolean hasContext;
        
    public Page(TestSession session, String pageYamlFile) throws Exception{
        this.session = session;
        this.pageYamlFile = pageYamlFile;
        this.pageUI = new YamlPage(
                session.config.get("page_spec_file_root").toString()
                , pageYamlFile);
        this.hasContext = false;
        if(pageUI.context!=null){
            this.hasContext = true;
        }
    }
    
    public WebElement element(String name){
        YamlElement yamlElement = pageUI.element(name);
        if(yamlElement.container != null){
            WebElement container = findElement(yamlElement.container);
            return (new WebDriverWait(session.driver, pageUI.timeout))
                .until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                        container, findBy(yamlElement)));
        }else{
            return findElement(yamlElement);
        }
    }

    public WebElement element(WebElement element, String name){
        YamlElement yamlElement = pageUI.element(name);
        return (new WebDriverWait(session.driver, pageUI.timeout))
            .until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                    element, findBy(yamlElement)));
    }
    
    public List<WebElement> elements(String name){
        YamlElement yamlElement = pageUI.element(name);
        if(yamlElement.container != null){
            return (new WebDriverWait(session.driver, pageUI.timeout))
                .until(ExpectedConditions.presenceOfNestedElementsLocatedBy(
                        findBy(yamlElement.container), findBy(yamlElement)));
        }
        return findElements(yamlElement);
    }
    
    public List<WebElement> elements(String containerElementName, String name){
        YamlElement yamlElement = pageUI.element(name);
        return (new WebDriverWait(session.driver, pageUI.timeout))
            .until(ExpectedConditions.presenceOfNestedElementsLocatedBy(
                    findBy(yamlElement.container), findBy(yamlElement)));
    }    
    
    public WebElement visibleElement(String name){
        YamlElement yamlElement = pageUI.element(name);
        if(yamlElement.container != null){
            WebElement container = findElement(yamlElement);
            return (new WebDriverWait(session.driver, pageUI.timeout))
                .until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(
                        container, findBy(yamlElement))).get(0);
        }
        return findVisibleElement(yamlElement);
    }
    
    public List<WebElement> visibleElements(String name){
        YamlElement yamlElement = pageUI.element(name);
        if(yamlElement.container != null){
            WebElement container = findElement(yamlElement);
            return (new WebDriverWait(session.driver, pageUI.timeout))
                .until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(
                        container, findBy(yamlElement)));
        }
        return findVisibleElements(yamlElement);
    }
    
    protected WebElement findElement(YamlElement yamlElement){
        if(pageUI.timeout > 0){
            return (new WebDriverWait(session.driver, pageUI.timeout))
                .until(ExpectedConditions.presenceOfElementLocated(
                        findBy(yamlElement)));
        }
        return session.driver.findElement(findBy(yamlElement));
    }
    
    public WebElement findElementWithoutWait(YamlElement yamlElement){
        return session.driver.findElement(findBy(yamlElement));
    }
    
    private List<WebElement> findElements(YamlElement yamlElement){
        if(pageUI.timeout > 0){
            return (new WebDriverWait(session.driver, pageUI.timeout))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        findBy(yamlElement)));
        }
        return session.driver.findElements(findBy(yamlElement));
    }
    
    public List<WebElement> findElementsWithoutWait(YamlElement yamlElement){
        return session.driver.findElements(findBy(yamlElement));
    }
    
    private WebElement findVisibleElement(YamlElement yamlElement){
        if(pageUI.timeout > 0){
            return (new WebDriverWait(session.driver, pageUI.timeout))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        findBy(yamlElement)));
        }
        return session.driver.findElement(findBy(yamlElement));
    }
    
    private List<WebElement> findVisibleElements(YamlElement yamlElement){
        if(pageUI.timeout > 0){
            return (new WebDriverWait(session.driver, pageUI.timeout))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        findBy(yamlElement)));
        }
        return session.driver.findElements(findBy(yamlElement));
    }
    
    public By findBy(YamlElement yamlElement){
        switch(yamlElement.findBy){
            case("id"):
                return By.id(yamlElement.locator);
            case("name"):
                return By.name(yamlElement.locator);
            case("css"):
                return By.cssSelector(yamlElement.locator);
            case("cssSelector"):
                return By.cssSelector(yamlElement.locator);
            case("linkText"):
                return By.linkText(yamlElement.locator);
            case("partialLinkText"):
                return By.partialLinkText(yamlElement.locator);
            case("xpath"):
                return By.xpath(yamlElement.locator);
            case("class"):
                return By.className(yamlElement.locator);
            case("className"):
                return By.className(yamlElement.locator);
        }
        return By.cssSelector(yamlElement.locator);
    }
    
    /**
     * 
     * @param elementName from yaml spec file
     * @return 
     */
    public By findBy(String elementName){
        YamlElement yamlElement = pageUI.element(elementName);
        return findBy(yamlElement);
    }
    
    @Loggable(Loggable.INFO)
    public Boolean hasExpectedTitle(){
        return session.driver.getTitle().equals(pageUI.expectedTitle);
    }

    
    /**
     * check all expected elements are displayed
     * 
     * @return 
     * @throws Exception 
     */
    @Loggable(Loggable.INFO)
    public Boolean isDisplayed() throws Exception{
        System.out.println("#isDisplayed()?");
        for(YamlElement yamlElement:pageUI.expectedElements()){
        	System.out.println("checking expectedElement : " + yamlElement);
            if(!findElement(yamlElement).isDisplayed()){
                return false;
            }
        }
        return true;
    }
    
    public void waitForElementToBeClickable(WebElement el, Integer timeout){
        WebDriverWait wait = new WebDriverWait(session.driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }
    
    public void waitForPageToLoad(){
        WebDriverWait wait = new WebDriverWait(session.driver, 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
    }

}