package Model;

public class GenerateGridBehavior4Columns implements GenerateGridBehavior{

	//Will try to generate à 4 columns grid, adding empty buttons if necessary
	public int generateNbButtons(int nbButtons){
		if(nbButtons % 4 == 0 ){
			return nbButtons;
		}
		else{
			return nbButtons+2;
		}
	}
	
	@Override
	public int generateNbLines(int nbButtons) {
		return nbButtons / 4;
	}

	@Override
	public int generateNbColumns() {
		return 4;
	}
	
	@Override
	public void toPrint() {
		System.out.println("I am a GenerateGridBehavior for 4 Columns !");
		
	}



}
