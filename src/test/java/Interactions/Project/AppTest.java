package Interactions.Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppTest{
	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(path +
				"\\src\\main\\java\\resources\\Config.properties");
		prop.load(fis);
		String Browser = prop.getProperty("browser");
		System.out.println(Browser);
	}
	
}