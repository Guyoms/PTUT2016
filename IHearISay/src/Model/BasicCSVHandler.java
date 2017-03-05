package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//This class is just the basic structure of the csvHandler and ultimately not desired in the final program. Consider it as a sketch rather than a functioning class.
//Several variation will be needed with specified numbers of columns to import/export (cf : gridGenerator)
public class BasicCSVHandler implements CSVHandler{
	boolean exportSuccesful = true;
	FileWriter myFileWriter = null;
	BufferedWriter myBufferedWriter = null;
	
	//Copy alString, but with each word doubled
	ArrayList<String> alStringDoubled = new ArrayList<String>();
	int iteratorAlStringDoubled = 0;
	
	int remainingNbWordToWrite = 0;
	
	int remainingNbWordOnLine = 0;
	
	String nextLineToWrite = "";

	@Override
	public boolean exportGridToCsv(File file, ArrayList<String> alString) {
		
		
		for (int i=0; i<alString.size(); i++){
			alStringDoubled.add(alString.get(i));
			alStringDoubled.add(alString.get(i));
		}
		
		try{
			myFileWriter = new FileWriter(file.getAbsolutePath());
			myBufferedWriter = new BufferedWriter(myFileWriter);
			
			myBufferedWriter.append("I hear;I say;I hear;I say");
			myBufferedWriter.newLine();
						
			//Number of word left to write on the csv
			remainingNbWordToWrite = alStringDoubled.size();
			
			//Will copy alString in the csv to a 4 rows grid
			for(int i=0; i<alStringDoubled.size()+2; i+=4){	
				remainingNbWordOnLine = 4;
				nextLineToWrite = "";
					
				//if at the begining of the list
				if(i==0){
					nextLineToWrite = "Start;";
					remainingNbWordOnLine--;
				}
				
				//if at the end of the list
				else if (remainingNbWordToWrite==0 && remainingNbWordOnLine==1) {
					nextLineToWrite += "End";
					remainingNbWordOnLine--;
					
				}
				
				while(remainingNbWordOnLine>0){
					if (remainingNbWordToWrite==0 && remainingNbWordOnLine==1) {
						nextLineToWrite += "End";
						remainingNbWordOnLine--;
						
					}
					//If there is still some word to write, write them
					if(remainingNbWordToWrite>0){
						nextLineToWrite += alStringDoubled.get(iteratorAlStringDoubled) + ";";
						iteratorAlStringDoubled++;
						remainingNbWordToWrite--;
					}
					//else add blank text (the empty space seems to be required)
					else{
						nextLineToWrite += " ;";
					}
					remainingNbWordOnLine--;
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
