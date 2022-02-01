package genericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/***
 * 
 * @author Adi rama venkata manoj
 *
 */


public class ExcelLibrary {
	
	
	public static String exPath="./src/test/resources/vTigerTestData.xlsx";
	
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	
	
	public static String readStringData(String sheetName, int rowNum, int cellNum) {
		Workbook workbook= null;

		try {
			File absPath= new File(exPath);
			FileInputStream fis = new FileInputStream(absPath);
			workbook=WorkbookFactory.create(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();

	}
}
