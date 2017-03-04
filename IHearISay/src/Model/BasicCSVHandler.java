package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//This class is just the basic structure of the csvHandler and ultimately not desired in the final program. Consider it as a sketch rather than a functioning class.
//Several variation will be needed with specified numbers of columns to import/export (cf : gridGenerator)
public class BasicCSVHandler implements CSVHandler{

	@Override
	public boolean exportGridToCsv(File file, ArrayList<String> alString) {
		boolean exportSuccesful = true;
		FileWriter myFileWriter = null;
		BufferedWriter myBufferedWriter = null;
		
		try{
			myFileWriter = new FileWriter(file.getAbsolutePath());
			myBufferedWriter = new BufferedWriter(myFileWriter);
			
			myBufferedWriter.append("I hear;I say;I hear;I say");
			myBufferedWriter.newLine();
			
			//Will copy alString in the csv to a 4 rows grid
			for(int i=0; i<alString.size(); i+=2){
					
				int remainingNbWordToWrite = alString.size()-i;
				String nextLineToWrite = null;
				if(remainingNbWordToWrite>=2){
					//Each word needs to be written twice since to represent the I hear/I say pair (which is not the case in alString)
					nextLineToWrite = alString.get(i)+ ";" + alString.get(i)+ ";" + alString.get(i+1)+ ";" + alString.get(i+1);
				}
				else{
					for (int j=0; j<remainingNbWordToWrite; j++){
						nextLineToWrite += alString.get(j)+ ";";
					}
				}
				myBufferedWriter.append(nextLineToWrite);
				myBufferedWriter.newLine();
				
			}
			
		}
		catch(IOException exception){
			exportSuccesful = false;
			exception.printStackTrace();
		}
		finally {
			try {
				myBufferedWriter.flush();
				myBufferedWriter.close();
				myFileWriter.close();
			} catch (IOException e) {
				exportSuccesful = false;
				e.printStackTrace();
			}
			
		}
		return exportSuccesful;
	}

}
