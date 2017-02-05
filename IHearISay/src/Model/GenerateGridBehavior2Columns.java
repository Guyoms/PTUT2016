package Model;

public class GenerateGridBehavior2Columns implements GenerateGridBehavior{

	//Will try to generate à 2 columns grid
	
	@Override
	public int generateNbButtons(int nbButtons) {
		return nbButtons;
	}
	
	@Override
	public int generateNbLines(int nbButtons) {
		return nbButtons / 2;
	}

	@Override
	public int generateNbColumns() {
		return 2;
	}

	@Override
	public void toPrint() {
		System.out.println("I am a GenerateGridBehavior for 2 Columns !");
		
	}
}
