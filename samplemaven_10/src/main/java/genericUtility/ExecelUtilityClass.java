package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Randeep
 *
 */

public class ExecelUtilityClass {
	/**
	 * This method will read String data from excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param colIndex
	 * @return String value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getStringDataFromExcel(String sheetName, int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook workbook= WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getStringCellValue();
	}
	
	public LocalDateTime getLocalDataFromExcel(String sheetName, int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook workbook= WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
	}
	
	public boolean getBooleanDataFromExcel(String sheetName, int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook workbook= WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
	}
	
	public double getNumberDataFromExcel(String sheetName, int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook workbook= WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
	}
}
