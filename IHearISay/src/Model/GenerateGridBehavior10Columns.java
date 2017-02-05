package Model;

public class GenerateGridBehavior10Columns implements GenerateGridBehavior{

	@Override
	public int generateNbButtons(int nbButtons) {
		if (nbButtons % 10 == 0){
			return nbButtons;
		}
		else if ((nbButtons + 2) % 10 == 0){
			return nbButtons+2;
		}
		else if ((nbButtons + 4) % 10 == 0){
			return nbButtons+4;
		}
		else if ((nbButtons + 6) % 10 == 0){
			return nbButtons+6;
		}
		else{
			return nbButtons+8;
		}
	}

	@Override
	public int generateNbLines(int nbButtons) {
		return nbButtons / 10;
	}

	@Override
	public int generateNbColumns() {
		return 10;
	}

	@Override
	public void toPrint() {
		System.out.println("I am a GenerateGridBehavior for 10 Columns !");
		
	}

}
