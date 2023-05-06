import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

import java.io.IOException;

import static co.com.test.utilidades.datatofeature.DataToFeature.overrideFeatureFiles;


public class RunnerExternalData {
    @Before
    public void test() throws IOException, InvalidFormatException {
        switch (SystemEnvironmentVariables.createEnvironmentVariables().getProperty("webdriver.driver")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                break;
        }
        //Metodo Lee Datos de Excel
        overrideFeatureFiles("./src/test/resources/features/register.feature");

    }

    @Test
    public void testRunner(){
        JUnitCore.runClasses(CRunnerPedido.class);
    }

    @RunWith(CucumberWithSerenity.class)
    @CucumberOptions(
            features = "src/test/resources/features/register.feature",
            tags = "@RegisterParabankDatadriven",
            glue = "co.com.test.definitions",
            snippets = SnippetType.CAMELCASE
    )

    public class CRunnerPedido{}
}