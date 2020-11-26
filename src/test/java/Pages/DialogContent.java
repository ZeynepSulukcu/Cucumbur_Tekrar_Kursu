package Pages;

import cucumber.api.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class DialogContent extends _Parent {
    WebElement myElement;
    List<WebElement> myList;


    //buradaki driver silindi çünkü Parentten geliyor.gerek kalmadı
    public DialogContent() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "mat-input-0")
    private WebElement username;

    @FindBy(id = "mat-input-1")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(linkText = "Got it!")
    private WebElement gotItBtn;
    @FindAll({@FindBy(linkText = "Got it!")})private List<WebElement> gotItBtns;

    @FindBy (xpath = "//span[text()='Dashboard ']")
    private WebElement dashboard;








    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']/input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@id='toast-container']")
    private WebElement msjContainer;
    @FindAll({ @FindBy(css = "div#toast-container") })  private List<WebElement> messageList;

    @FindAll({
            @FindBy(xpath = "//table/tbody/tr/td[2]")
    })
    public List<WebElement> nameList;

    @FindAll({
            @FindBy(xpath = "//ms-delete-button/button")
    })
    public List<WebElement> deleteButtonList;

    @FindAll({
            @FindBy(xpath = "//ms-edit-button/button")
    })
    public List<WebElement> editButtonList;

    @FindBy(xpath = "//span[text()=' Yes ']")
    private WebElement yesButton;




    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']/input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'Error')]")
    private WebElement ErrorMessage;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDialog;

    @FindBy(xpath = "//mat-select[@id='mat-select-40']")
    private WebElement countrycities;
    @FindBy(xpath = "//span[text()=' Italy ']")
    private WebElement butnItaly;


    public void findElementAndClickFunction(String ElementName) {
        /**
         * Buraya tıklanacak butonun adı gönderilecek
         * Burada adından hangi eleman olduğu bulunuyor
         * ve sonra tıklanıyor.
         */

        switch (ElementName) {
            case "loginButton":
                myElement = loginButton;
                break;

            case "gotItBtn":
                // bu eleman yok ise çoklu olarak yinede bulduk
                // eğer gerçekten yok ise size 0 olacağı için
                // bekletmeye düşmesin diye fonksiyonu geri gönderdik.

                if (gotItBtns.size() == 0)
                    return;

                myElement = gotItBtn;
                break;

            case "addButton":
                myElement = addButton;
                break;

            case "saveButton":
                myElement = saveButton;
                break;

            case "yesButton":
                myElement = yesButton;
                break;

            case "closeDialog":
                myElement = closeDialog;
                break;
            case "countrycities":
                myElement = countrycities;
                break;
            case "butnItaly":
                myElement = butnItaly;
                break;
        }

        clickFunction(myElement);
    }


    public void findElementAndSendKeysFunction(String ElementName, String value) {
        /**
         * Buraya tıklanacak butonun adı gönderilecek
         * Burada adından hangi eleman olduğu bulunuyor
         * ve sonra tıklanıyor.
         */

        switch (ElementName) {
            case "username":
                myElement = username;
                break;

            case "password":
                myElement = password;
                break;

            case "nameInput":
                myElement = nameInput;
                break;

            case "codeInput":
                myElement = codeInput;
                break;


        }

        sendKeysFunction(myElement, value);
    }


    public void findElementAndVerifyContainsText(String ElementName, String msg) {
        switch (ElementName) {
            case "dashboard":
                myElement = dashboard;break;
            case "msjContainer":
                myElement = msjContainer;
                break;

            case "ErrorMessage":
                myElement = ErrorMessage;
                break;
        }

        verifyElementContainsText(myElement, msg);
    }
    public void editAndDeleteFunction(String elementName,String editorDelete) {
        if (messageList.size() > 0) {
//            if (message.isDisplayed())
            wait.until(ExpectedConditions.invisibilityOfAllElements(msjContainer));
        }
        switch (editorDelete) {
            case "edit":
                myList = editButtonList;
                break;

            case "delete":
                myList = deleteButtonList;
        }
        for (int i = 0; i < nameList.size(); i++) {

            if (nameList.get(i).getText().equalsIgnoreCase(elementName)) {
                clickFunction(myList.get(i));
                break;
            }

  /*  public void editAndDeleteFunction(String elementName, String editOrDelete) {
        // aşağıda editOrDelete den gelen edit veya delete kelimesine
        // göre hangi buton tipine tıklatılacaksa onun LİST i alınıyor.
        List<WebElement> btnList = new ArrayList<>();

        if (editOrDelete.equalsIgnoreCase("delete"))
            btnList = waitVisibleListAllElement(deleteButtonList);
        else
            btnList = waitVisibleListAllElement(editButtonList);

        // nameList içerisinde (table ın 2 stunundaki isimlerin olduğu
        // liste) ülke adı aranıyor. bulunduğunda o indexteki butona
        // (edit veya delete) tıklanarak. Dialog penceresi açılıyor.
        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.get(i).getText().equalsIgnoreCase(elementName)) {
                clickFunction(btnList.get(i));
            }
        }

        // ekranda tıklandıktan sonra izleyebilmek için kondu
        // waiting(5000);
    }*/


        }
    }
}