import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

public class RunnersTagsWDM {

    @Before
    public void test(){
        String navegador = SystemEnvironmentVariables.createEnvironmentVariables().getProperty("webdriver.driver");

        if ("chrome".equals(navegador)) {
            WebDriverManager.chromedriver().setup();
        } else {
            WebDriverManager.firefoxdriver().setup();
        }
    }

    @Test
    public void testRunner(){
        JUnitCore.runClasses(CRunnerPedido.class);
    }

    @RunWith(CucumberWithSerenity.class)
    @CucumberOptions(
            features = "src/test/resources/features/register.feature",
//            tags = "@RegisterParaBank",
            tags = "@ExistingRecord",
            glue = "co.com.test.definitions",
            snippets = SnippetType.CAMELCASE
    )

    public class CRunnerPedido{}
}
