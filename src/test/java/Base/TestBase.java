package Base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

public class TestBase {

	public static Logger logger;

	@BeforeClass
	public void setup() {

		logger = Logger.getLogger("RestAssured_BDD_Approach");
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\test-output\\log4j.properties");
		logger.setLevel(Level.DEBUG);

	}

}
