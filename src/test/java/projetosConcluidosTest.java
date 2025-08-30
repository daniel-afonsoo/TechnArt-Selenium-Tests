
import java.time.Duration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class projetosConcluidosTest {


    @Test
    public void testProjetosConcluidos() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        
        driver.get("http://novotechneart.ipt.pt/tecnart/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement menu = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/ul/li[2]/a/span"));
        actions.moveToElement(menu).perform();

        WebElement projetosConcluidos = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/ul/li[2]/div/a[2]"));
        projetosConcluidos.click();
        
        WebElement paginacao = driver.findElement(By.xpath("/html/body/section[2]/div[2]/div/div[2]/a[2]/span"));
        paginacao.click();
        
        WebElement barraPesquisa = driver.findElement(By.xpath("//*[@id=\"example-search-input\"]"));
        barraPesquisa.sendKeys("NATBIO");
        
        WebElement botaoBarraPesquisa = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/form/div/button"));
        botaoBarraPesquisa.click();
        
        WebElement projeto = driver.findElement(By.xpath("/html/body/section[2]/div[2]/div/div[1]/div/a/div"));
        String nome = projeto.getText();
        assertTrue(nome.contains("NATBIO"));

        
        driver.quit();
    }

}
