package exact;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.asynchttpclient.proxy.ProxyServer;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.core.har.HarResponse;

public class SeleniumHarParser {

    public static void main(String[] args) throws IOException, WebDriverException {
        
        // Setup BrowserMob Proxy
        ProxyServer server = new ProxyServer(0);
        server.start();
        
        // Get the Selenium proxy from the BrowserMob Proxy server
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(server);
        
        // Set Chrome options to use the proxy
        ChromeOptions options = new ChromeOptions();
        options.setProxy(seleniumProxy);
        
        // Setup WebDriver
        WebDriver driver = new ChromeDriver(options);
        
        // Start capturing the network traffic
        server.newHar("exactspace.co");
        
        try {
            // Navigate to the website
            driver.get("https://exactspace.co/");
            
            // Wait for the page to load (you can adjust the condition as needed)
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
            
            // Save the HAR file
            Har har = server.getHar();
            File harFile = new File("exactspace.har");
            har.writeTo(harFile);
            System.out.println("HAR file saved to: " + harFile.getAbsolutePath());
            
            // Parse the HAR file
            parseHarFile(har);
            
        } finally {
            // Stop the BrowserMob Proxy server
            server.stop();
            
            // Close the WebDriver
            driver.quit();
        }
    }

    // Method to parse the HAR file and count status codes
    private static void parseHarFile(Har har) {
        int totalCount = 0;
        int count2xx = 0;
        int count4xx = 0;
        int count5xx = 0;
        
        List<HarEntry> entries = har.getLog().getEntries();
        
        // Iterate over the HAR entries and categorize the status codes
        for (HarEntry entry : entries) {
            HarResponse response = entry.getResponse();
            int statusCode = response.getStatus();
            
            totalCount++;
            
            if (statusCode >= 200 && statusCode < 300) {
                count2xx++;
            } else if (statusCode >= 400 && statusCode < 500) {
                count4xx++;
            } else if (statusCode >= 500 && statusCode < 600) {
                count5xx++;
            }
        }

        // Display the results
        System.out.println("Total HTTP requests: " + totalCount);
        System.out.println("Total 2XX status codes: " + count2xx);
        System.out.println("Total 4XX status codes: " + count4xx);
        System.out.println("Total 5XX status codes: " + count5xx);
    }
}
