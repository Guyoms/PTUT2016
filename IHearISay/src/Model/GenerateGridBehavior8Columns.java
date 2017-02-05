package Model;

public class GenerateGridBehavior8Columns implements GenerateGridBehavior{

	@Override
	public int generateNbButtons(int nbButtons) {
		if (nbButtons % 8 == 0){
			return nbButtons;
		}
		else if ((nbButtons + 2) % 8 == 0){
			return nbButtons+2;
		}
		else if ((nbButtons + 4) % 8 == 0){
			return nbButtons+4;
		}
		else{
			return nbButtons+6;
		}
	}

	@Override
	public int generateNbLines(int nbButtons) {
		return nbButtons/8;
	}

	@Override
	public int generateNbColumns() {
		return 8;
	}

	@Override
	public void toPrint() {
		System.out.println("I am a GenerateGridBehavior for 8 Columns !");
		
	}
	

}
