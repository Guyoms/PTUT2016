package Model;

import java.io.File;
import java.util.ArrayList;

public class CSVHandler4Columns extends BasicCSVHandler implements CSVHandler{
	//This variable will override the number of columns used in exportGridToCSV
	private int newNbCol = 4;
	@Override
	public boolean exportGridToCsv(File file, ArrayList<String> alString) {
		return super.exportGridToCsv(file, alString);
	}
	
	public void updateNbCol(){
		super.setNbColumns(newNbCol);
	}

}
