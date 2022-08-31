package synkduputilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readconfig {

	Properties pro;

	public readconfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");

		return url;
	}

}
