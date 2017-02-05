package Model;

public class GenerateGridBehavior6Columns implements GenerateGridBehavior{

	//Will try to generate à 6 columns grid, adding empty buttons if necessary
	
	@Override
	public int generateNbButtons(int nbButtons) {
		if (nbButtons % 6 == 0){
			return nbButtons;
		}
		else if ((nbButtons + 2) % 6 == 0){
			return nbButtons+2;
		}
		else{
			return nbButtons+4;
		}
	}

	@Override
	public int generateNbLines(int nbButtons) {
		return nbButtons/6;
	}

	@Override
	public int generateNbColumns() {
		return 6;
	}
	
	@Override
	public void toPrint() {
		System.out.println("I am a GenerateGridBehavior for 6 Columns !");
		
	}

	

}
