import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/register.feature",
        tags = "@RegisterParaBank",
        glue = "co.com.test.definitions",
        snippets = SnippetType.CAMELCASE
)

public class Runners {}