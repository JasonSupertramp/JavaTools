package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class CheckLogin {
	public static boolean isLogin(String userName, String password) throws IOException {
		boolean flag = false;
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src/resources/user.txt");
		//InputStream fis=this.getClass().getClassLoader().getResourceAsStream("src/resources/user.txt");
		prop.load(fis);
		Set<String> set = prop.stringPropertyNames();
		for (String key : set) {
			if ((key.equals(userName) & (password.equals(prop.getProperty(key))))) {
				flag = true;
				return flag;
			}
		}
		return flag;
	}
}
