
import java.time.Duration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvestigadorIntegradoTest {


    @Test
    public void TestInvestigadorIntegrado() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        
        driver.get("http://novotechneart.ipt.pt/tecnart/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        
        //Clicar no "botao" equipa
        WebElement menu = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/ul/li[3]/a/span"));
        actions.moveToElement(menu).perform();
        
        //Clicar no "botao" integrados
        WebElement integrado = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/ul/li[3]/div/a[1]"));
        integrado.click();
        
        //Clicar na pagina 4 da paginaçao
        WebElement paginacao = driver.findElement(By.xpath("/html/body/section[2]/div[2]/div/div[2]/a[4]"));
        paginacao.click();
        
        //Localizar barra de pesquisa e escrever lá ANTÓNIO MANSO
        WebElement pesquisa = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/form/div/input"));
        pesquisa.sendKeys("ANTÓNIO MANSO");
        
        //clicar no botao que tem a lupa
        WebElement button = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/form/div/button"));
        button.click();
        
        //Se aparece a Card contendo MANSO entao ta tudo ok
        WebElement titulo = driver.findElement(By.xpath("/html/body/section[2]/div[2]/div/div[1]/div/a/div"));
        String nome = titulo.getText();
        assertTrue(nome.contains("MANSO"));
        
        
        
        driver.quit();
    }

}
