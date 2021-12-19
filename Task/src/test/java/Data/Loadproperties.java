package Data;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class Loadproperties {
	//Load Data From Properties file
		public static Properties userData=LoadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\Data.properties");
		public static Properties LoadProperties(String path) {
			
			Properties pro=new Properties();
			
			try {
				FileInputStream stream=new FileInputStream(path);
				pro.load(stream);
			}
				 catch (FileNotFoundException e) {
				System.out.println("error occured" + e.getMessage());
			}
				 catch (IOException e) {
					 
					 System.out.println("error occured" + e.getMessage());
				 }
			
			return pro;
						
					
			
			
			
		}

}
