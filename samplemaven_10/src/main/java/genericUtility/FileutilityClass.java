package genericUtility;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	/**
	 * 
	 * @author Randeep
	 *
	 */

	public class FileutilityClass {
		/**
		 * This method is used to Capture common data from property file
		 * @param key
		 * @return String value
		 * @throws IOException
		 */
		public String getDataFromProperty(String key) throws IOException {
			FileInputStream fis= new FileInputStream("./src/test/resources/TestData/commondata.properties");
			Properties prop= new Properties();
			prop.load(fis);
			return prop.getProperty(key);
		}

}
