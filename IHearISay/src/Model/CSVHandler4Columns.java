package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVHandler4Columns implements CSVHandler{
	private int nbColumns = 4;

	@Override
	public boolean exportGridToCsv(File file, ArrayList<String> alString) {
		boolean exportSuccesful = true;
		FileWriter myFileWriter = null;
		BufferedWriter myBufferedWriter = null;
		
		//Copy alString, but with each word doubled
		
		ArrayList<String> alStringDoubled = new ArrayList<String>();
		int iteratorAlStringDoubled = 0;
		for (int i=0; i<alString.size(); i++){
			alStringDoubled.add(alString.get(i));
			alStringDoubled.add(alString.get(i));
		}
		
		try{
			myFileWriter = new FileWriter(file.getAbsolutePath());
			myBufferedWriter = new BufferedWriter(myFileWriter);
			
			//Initialization : will write "I hear I say" this.nbColumns time
			for(int i=0; i<this.nbColumns; i++){
				myBufferedWriter.append("I hear;I say;");
			}
			myBufferedWriter.newLine();
			
			//Number of word left to write on the csv
			int remainingNbWordToWrite = alStringDoubled.size();
			
			//Will copy alString in the csv to a this.nbColumns rows grid
			for(int i=0; i<alStringDoubled.size()+2; i+=this.nbColumns){	
				int remainingNbWordOnLine = this.nbColumns;
				String nextLineToWrite = "";
					
				//if at the beginning of the list
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
