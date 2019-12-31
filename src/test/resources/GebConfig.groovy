import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.testcontainers.containers.BrowserWebDriverContainer

waiting {
    timeout = 2
}
autoClearCookies = true
atCheckWaiting = true

environments {
    //run test with chrome browser
    chrome {
        driver = {
            new ChromeDriver()
        }
    }
    //run test with docker chrome browser
    dockerchrome {
        driver = {
            ChromeOptions options = new ChromeOptions()
            options.addArguments("-window-size=1920,1080")
            BrowserWebDriverContainer chrome =
                    new BrowserWebDriverContainer()
                            .withCapabilities(options);
            chrome.start()
            chrome.getWebDriver()
        }
    }
}
baseUrl = "http://gebish.org"

reportsDir = 'target/geb-spock-reports'
