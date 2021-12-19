package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static FileInputStream fis = null;

	public FileInputStream getFileInputStream() {


		String FilePath= System.getProperty("user.dir")+"/src/test/java/data/Datasheet.xlsx";
		File SrcFile= new File(FilePath);

		try {
			fis=new FileInputStream(SrcFile);
		} catch (FileNotFoundException e) {
			System.out.println("test file not found" +e.getMessage());

		}
		return fis;





	}

	public ArrayList<String> GetExcelData(  int ColNo) throws IOException{

		fis=getFileInputStream();

		XSSFWorkbook Wb= new XSSFWorkbook(fis);

		XSSFSheet Sheet=Wb.getSheetAt(0);

		int NoOfRows=Sheet.getLastRowNum()+1;
		
		

	
		ArrayList<String> Res = new ArrayList<String>();
		
		

		for (int i = 1; i < NoOfRows; i++) {
		

				XSSFRow row=Sheet.getRow(i); 
				if(row.getCell(ColNo)==null) {
					
					break;
				}
				
				Res.add( row.getCell(ColNo).toString());
			

			}
		
		

		fis.close();

	
		return Res;

	}

	
	



}
