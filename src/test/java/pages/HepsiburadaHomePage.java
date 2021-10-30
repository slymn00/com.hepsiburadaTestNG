package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiburadaHomePage {
    public HepsiburadaHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@id='myAccount']")
    public WebElement homePageGirisYap;

    @FindBy(xpath = "//a[@id='login']")
    public WebElement loginButonuDropDown;

    @FindBy(xpath = "//input[@id='txtUserName']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement password;

    @FindBy(xpath = "//button[@id='btnLogin']")
    public WebElement loginButonu;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement searchBox;

    @FindBy(xpath = "//div[text()='ARA']")
    public WebElement ara;

    @FindBy(xpath = "//div[text()='Telefon']")
    public WebElement telefonDropdown;

    @FindBy(xpath = "//div[text()='Cep Telefonu']")
    public WebElement ceptelefonu;

    @FindBy(xpath = "//div[@class='searchResultSummaryBar-mainText']")
    public WebElement samsungDogrulama;

    @FindBy(xpath = "(//div[@data-test-id='product-card-container'])[26]")
    public WebElement yirmiAltinciUrun;

    @FindBy(xpath = "(//div[@data-test-id='product-image-right-bar-container'])[26]")
    public WebElement begenButonu;

    @FindBy(xpath = "//div[@id='myAccount']")
    public WebElement hesabim;

    @FindBy(xpath = "//a[@title='Beğendiklerim']")
    public WebElement begendiklerimButonu;

    @FindBy(xpath = "//h3[@type='comfort']")
    public WebElement secilenUrunBegendiklerim;

    @FindBy(xpath = "//div[text()='Sepete ekle']")
    public WebElement sepeteEkle;

    @FindBy(xpath = "//div[@class='hb-toast-text']")
    public WebElement sepeteEklendiPopUp;

    @FindBy(xpath = "//span[text()='Sepetim']")
    public WebElement sepetimButonu;

    @FindBy(xpath = "//a[@class='delete_product_3DFC0']")
    public WebElement kaldirButonu;

    @FindBy(xpath = "(//button[@kind='primary'])[2]")
    public WebElement secilenleriKaldir;

    @FindBy(xpath = "//a[@aria-label='Ürünü Kaldır']")
    public WebElement urunuKaldirSon;

    @FindBy(xpath = "//div[@class='action_container_2xURc']/span")
    public WebElement urununSilindiginiDogrulama;

    @FindBy(xpath = "//a[@class='sf-Header-26esO']")
    public WebElement hepsiBuradaLogosuSepet;

    @FindBy(xpath = "//a[@class='sf-OldHeader-1NFKi']")
    public WebElement hepsiBuradaLogosuAnasayfa;

    @FindBy(xpath = "//a[@class='solution-center-phone']")
    public WebElement cagriMerkeziNo;

    @FindBy(xpath = "//span[text()='Başa dön']")
    public WebElement basaDonButonu;

    @FindBy(xpath = "//div[@id='myAccount']")
    public WebElement hesabimAlani;

    @FindBy(xpath = "//a[text()='Çıkış Yap']")
    public WebElement cikisYap;


}
