
import java.time.Duration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ColaboradorTest {


    @Test
    public void Colaborador() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        
        driver.get("http://novotechneart.ipt.pt/tecnart/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        
        //Clicar no "botao" equipa
        WebElement menu = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/ul/li[3]/a/span"));
        actions.moveToElement(menu).perform();
        
        //Clicar no "botao" colaborador
        WebElement colaborador = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/ul/li[3]/div/a[2]"));
        colaborador.click();
        
        
        //Clicar na pagina 4 da paginaçao
        WebElement paginacao = driver.findElement(By.xpath("/html/body/section[2]/div[2]/div/div[2]/a[4]"));
        paginacao.click();
        
        
        //Localizar barra de pesquisa e escrever lá Ana do Carmo
        WebElement pesquisa = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/form/div/input"));
        pesquisa.sendKeys("ANA DO CARMO");
        
        
        //clicar no botao que tem a lupa
        WebElement button = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/form/div/button"));
        button.click();
        
        
        //Se aparece a Card contendo CARMO entao ta tudo ok
        WebElement titulo = driver.findElement(By.xpath("/html/body/section[2]/div[2]/div/div[1]/div/a/div"));
        String nome = titulo.getText();
        assertTrue(nome.contains("CARMO"));
        
        
        
        driver.quit();
    }

}
