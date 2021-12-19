package Tests;

import java.io.IOException;
import java.util.ArrayList;

import Data.ExcelReader;

public class TestExcell {
	public static void main(String[] args) throws IOException{
	ExcelReader obj= new ExcelReader();
	ArrayList< String> res;
	res=obj.GetExcelData(3);
	for (int i = 0; i < res.size(); i++) {
		System.out.println(res.get(i));
	}
	
//	String Data[][];
//	Data=(String[][]) obj.GetExcelData2(2);
//	
//	
//System.out.println(Data.length);
//	for (int i = 0; i < Data.length; i++) {
//		
//		for (int j = 0; j < Data[i].length; j++) {
//			
//			if(Data[i][j] ==null) {
//				break;
//			}
//			System.out.println("i  =" +i+ "J  ="+ j);
//			System.out.println(Data[i][j]);
//		}
		
//		
//	}
	}
	
}
