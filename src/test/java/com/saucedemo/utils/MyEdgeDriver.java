package com.saucedemo.utils;

import net.thucydides.core.webdriver.DriverSource;      // <--- IMPORT CORRECTA AQUÍ
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.nio.file.Paths;

public class MyEdgeDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        String driverPath = Paths.get("src","test","resources","drivers","msedgedriver.exe")
                .toAbsolutePath().toString();
        System.setProperty("webdriver.edge.driver", driverPath);

        EdgeOptions options = new EdgeOptions();
        // options.addArguments("--disable-extensions","--ignore-certificate-errors","--disable-popup-blocking");
        return new EdgeDriver(options);
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
