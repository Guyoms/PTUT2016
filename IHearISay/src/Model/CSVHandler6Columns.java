package Model;

import java.io.File;
import java.util.ArrayList;

public class CSVHandler6Columns extends BasicCSVHandler implements CSVHandler{
	//This variable will override the number of columns used in exportGridToCSV
		private int newNbCol = 6;
		@Override
		public boolean exportGridToCsv(File file, ArrayList<String> alString) {
			return super.exportGridToCsv(file, alString);
		}
		
		public void updateNbCol(){
			super.setNbColumns(newNbCol);
		}

		@Override
		public ArrayList<String> importCsv(File file) {
			// TODO Auto-generated method stub
			return super.importCsv(file);
		}

}
