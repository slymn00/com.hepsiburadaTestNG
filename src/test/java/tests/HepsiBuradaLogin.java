package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HepsiburadaHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class HepsiBuradaLogin extends TestBaseRapor {


    @Test
    public void LoginTest(){
        HepsiburadaHomePage hepsiburadaHomePage=new HepsiburadaHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburada_url"));

        System.out.println(Driver.getDriver().getCurrentUrl());
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigReader.getProperty("expected_url"));

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hepsiburadaHomePage.homePageGirisYap).perform();
        ReusableMethods.waitFor(3);
        actions.click(hepsiburadaHomePage.loginButonuDropDown).perform();

        ReusableMethods.waitFor(3);
        hepsiburadaHomePage.email.sendKeys(ConfigReader.getProperty("hepsiburada_mail"));

        hepsiburadaHomePage.password.sendKeys(ConfigReader.getProperty("hepsiburada_sifre"));

        ReusableMethods.waitFor(3);
        hepsiburadaHomePage.loginButonu.click();

    }

    @Test
    public void searchBoxTest(){
        extentTest=extentReports.createTest("Urun begenip sepete ekledinten sonra sepetten ve siteden cikma testi","Belirlenen urun begenildikten sonra begendiklerime girilip sepete ekledikten sonra sepetten cikarip ardindan siteden cikmak");
        HepsiburadaHomePage hepsiburadaHomePage=new HepsiburadaHomePage();
        LoginTest();
        extentTest.info("Login yapildi");

        ReusableMethods.waitFor(2);
        hepsiburadaHomePage.searchBox.sendKeys(ConfigReader.getProperty("aranan_kelime"));
        extentTest.info("Aranmasi belirlenen kelime searchbox'ta arandi");
        ReusableMethods.waitFor(1);
        hepsiburadaHomePage.ara.click();
        extentTest.info("Ara butonuna basildi");
        hepsiburadaHomePage.telefonDropdown.click();
        extentTest.info("Soldaki menuden telefon secildi");
        ReusableMethods.waitFor(3);
        hepsiburadaHomePage.ceptelefonu.click();
        extentTest.info("Soldaki menuden cep telefonu secildi");
        System.out.println(hepsiburadaHomePage.samsungDogrulama.getText());
        Assert.assertTrue(hepsiburadaHomePage.samsungDogrulama.getText().contains("samsung"));
        extentTest.info("Expected result ile actual result karsilastirildi");
        ReusableMethods.waitFor(3);
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();
        ReusableMethods.waitFor(2);
        actions.moveToElement(hepsiburadaHomePage.yirmiAltinciUrun).perform();
        extentTest.info("Yirmi altinci urunun uzerine gelindi");
        ReusableMethods.waitFor(2);
        hepsiburadaHomePage.begenButonu.click();
        extentTest.info("Urun detayindaki begen butonuna tiklandi");
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.HOME).perform();
        ReusableMethods.waitFor(1);
        actions.moveToElement(hepsiburadaHomePage.hesabim).perform();
        ReusableMethods.waitFor(2);
        hepsiburadaHomePage.begendiklerimButonu.click();
        extentTest.info("Begendiklerim sayfasina gecis yapildi");
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .perform();
        String begendiklerimUrunAdi=hepsiburadaHomePage.secilenUrunBegendiklerim.getText();
        System.out.println(begendiklerimUrunAdi);
        Assert.assertTrue(begendiklerimUrunAdi.contains("Samsung"));
        extentTest.info("Belirlenen urunun begendiklerimde oldugu test edildi");
        ReusableMethods.waitFor(2);

        actions.moveToElement(hepsiburadaHomePage.secilenUrunBegendiklerim).perform();
        ReusableMethods.waitFor(1);
        actions.click(hepsiburadaHomePage.sepeteEkle).perform();
        extentTest.info("Begenilen urun sepete eklendi");
        ReusableMethods.waitFor(1);

        Assert.assertTrue(hepsiburadaHomePage.sepeteEklendiPopUp.isEnabled());
        extentTest.info("Begenilen urunun sepete eklendigi pop-up'nın kullanıcıya gosterildigi assert edildi");

        actions.sendKeys(Keys.HOME).perform();
        ReusableMethods.waitFor(1);
        hepsiburadaHomePage.sepetimButonu.click();
        ReusableMethods.waitFor(4);
        extentTest.info("Sepete gidildi");

        ReusableMethods.waitFor(2);
        hepsiburadaHomePage.kaldirButonu.click();
        ReusableMethods.waitFor(2);
        hepsiburadaHomePage.secilenleriKaldir.click();
        ReusableMethods.waitFor(2);
        hepsiburadaHomePage.urunuKaldirSon.click();
        extentTest.info("Sepette bulunan urun sepetten cikarildi");

        ReusableMethods.waitFor(2);
        String urununSilindiginiDogrula=hepsiburadaHomePage.urununSilindiginiDogrulama.getText();
        System.out.println(urununSilindiginiDogrula);
        Assert.assertTrue(urununSilindiginiDogrula.contains("silin"));
        extentTest.info("Sepetin bos olduguna dair assert yapildi");

        ReusableMethods.waitFor(2);
        hepsiburadaHomePage.hepsiBuradaLogosuSepet.click();
        ReusableMethods.waitFor(2);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),(ConfigReader.getProperty("hepsiburada_url")));
        extentTest.info("Anasayfaya gecis saglandi");

        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.END).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(1);
        String cagriNo=hepsiburadaHomePage.cagriMerkeziNo.getText();
        Assert.assertEquals(cagriNo,ConfigReader.getProperty("cagri_merkezi_no"));
        extentTest.info("Sayfanin sonuna dogru inip cagri merkezi numarasini kontrol etti");

        ReusableMethods.waitFor(2);
        hepsiburadaHomePage.basaDonButonu.click();
        extentTest.info("Sayfanin basina donuldu");

        ReusableMethods.waitFor(1);
        Assert.assertTrue(hepsiburadaHomePage.hepsiBuradaLogosuAnasayfa.isDisplayed());
        extentTest.info("Hepsiburada logosu gorundu");

        ReusableMethods.waitFor(2);
        actions.moveToElement(hepsiburadaHomePage.hesabimAlani).perform();
        ReusableMethods.waitFor(1);
        actions.click(hepsiburadaHomePage.cikisYap).perform();
        extentTest.info("Cikis yapildi");

        ReusableMethods.waitFor(3);
        Assert.assertTrue(hepsiburadaHomePage.homePageGirisYap.isDisplayed());
        extentTest.info("Cikis yapildigi kontrol edildi");









    }



}
