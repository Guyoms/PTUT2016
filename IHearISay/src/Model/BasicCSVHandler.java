package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//This class is just the basic structure of the csvHandler and ultimately not desired in the final program. Consider it as a sketch rather than a functioning class.
//Several variation will be needed with specified numbers of columns to import/export (cf : gridGenerator)
public class BasicCSVHandler implements CSVHandler{
	
	//This variable represent the number of columns desired in the final csv file.
	//It will therefore vary on the several implementations of this class to match the grid created by the user
	private int nbColumns = 2;
	
	private FileWriter myFileWriter = null;
	private BufferedWriter myBufferedWriter = null;

	@Override
	public boolean exportGridToCsv(File file, ArrayList<String> alString) {
		//Return value used to verify if the export worked properly
		boolean exportSuccesful = true;
		
		
		//Copy of alString, but with each word doubled
		ArrayList<String> alStringDoubled = new ArrayList<String>();
		int iteratorAlStringDoubled = 0;
		for (int i=0; i<alString.size(); i++){
			alStringDoubled.add(alString.get(i));
			alStringDoubled.add(alString.get(i));
		}
		
		try{
			this.myFileWriter = new FileWriter(file.getAbsolutePath());
			this.myBufferedWriter = new BufferedWriter(this.myFileWriter);
			
			//Initialization : will write "I hear I say" this.nbColumns time
			for(int i=0; i<this.nbColumns; i+=2){
				this.myBufferedWriter.append("I hear;I say;");
			}
			this.myBufferedWriter.newLine();
			
			//Number of word left to write on the csv
			int remainingNbWordToWrite = alStringDoubled.size();
			
			//Will copy alString in the csv to a this.nbColumns rows grid
			for(int i=0; i<alStringDoubled.size()+2; i+=this.nbColumns){	
				
				//Number of word left to write on the selected line
				int remainingNbWordOnLine = this.nbColumns;
				
				//String containing the text to be written : each cell's content of line, separated by ";"
				String nextLineToWrite = "";
					
				//if at the beginning of the list, add "Start"
				if(i==0){
					nextLineToWrite = "Start;";
					remainingNbWordOnLine--;
				}
				
				//if at the end of the list, add "End"
				else if (remainingNbWordToWrite==0 && remainingNbWordOnLine==1) {
					nextLineToWrite += "End";
					remainingNbWordOnLine--;
					
				}
				
				while(remainingNbWordOnLine>0){
					//if at the end of the list, add "End"
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
				
				//Write nextLineToWrite in the csv, and go to the next line
				this.myBufferedWriter.append(nextLineToWrite);
				this.myBufferedWriter.newLine();
				
			}
			
		}
		catch(IOException exception){
			exportSuccesful = false;
			exception.printStackTrace();
		}
		finally {
			try {
				this.myBufferedWriter.flush();
				this.myBufferedWriter.close();
				this.myFileWriter.close();
			} catch (IOException e) {
				exportSuccesful = false;
				e.printStackTrace();
			}
			
		}
		return exportSuccesful;
	}
	
	public int getNbColumns() {
		return this.nbColumns;
	}
	
	public void setNbColumns(int newNbCol){
		this.nbColumns = newNbCol;
	}

	//This method should not be used in this class !
	@Override
	public void updateNbCol() {
		return;
	}
		
}
