package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@RestController
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

	private String createLog(String message, String testName, Date now) {
		return String.format(message + " TestName:" + testName + " Date: " + now);
	}

	@RequestMapping("/")
	public String home(@RequestParam(name = "name", defaultValue = "") String name) {
		Date now = new Date();

		logger.debug(createLog("Debug log test", name, now));
		logger.info(createLog("Info log test", name, now));
		logger.warn(createLog("Warn log test", name, now));
		logger.error(createLog("Error log test", name, now));

		return "Hello Docker World<br>" + now + "<br>" + name;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
