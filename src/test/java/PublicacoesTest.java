
import java.time.Duration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PublicacoesTest {

    @Test
    public void publicacoesTest() {
        ChromeDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.get("http://novotechneart.ipt.pt/tecnart/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    
        WebElement publicacoes = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/ul/li[5]/a"));
        publicacoes.click();

        WebElement h3 = driver.findElement(By.xpath("/html/body/section/div/div/div/h3"));
        assertTrue(h3.getText().contains("PUBLICAÇÕES"));
        
        
        driver.quit();
    }

}
