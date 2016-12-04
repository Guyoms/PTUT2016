package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class TestGrille {

	public static void main(String[] args) {
		String deb = "Start";
		Scanner sc = new Scanner(System.in);
		String prem = null;
		int taille, nbMot;
		int i = 0;
		ArrayList<String> arL = new ArrayList<>();
		LinkedHashMap<String, String> tab; 
		
		
		System.out.println("Combien de mots voulez vous entrer ? Entrez 0 si vous ne savez pas.");
		nbMot = sc.nextInt();
		
		if (nbMot == 0){
			// Valeur temporaire, plus tard = maximum taille
			tab = new LinkedHashMap<>(20);
			taille = 20;
		}else {
			// taille de la Map (+1 premi�re case)
			tab = new LinkedHashMap<>((nbMot/2)+1);
			taille = nbMot;
		}
		
		// Ajout du premier mot dans l'ArrayList
		System.out.println("Premier mot : ");
		prem = sc.next();
		arL.add(prem);
		

		
		
		// On remplit l'ArrayList
		while (i<taille-1){
			System.out.println("Entrez le mot suivant (stop pour finir) : " );
			prem = sc.next();

			if (prem.equals("stop")){
				break;
			}else{
				arL.add(prem);
				i++;
			}
		}
		
		//Shuffle de l'array 
		Collections.shuffle(arL);

		
		// On remplit la LinkedHashMap
		for (int j = 0; j <= i; j++){
			if (j==0){
				tab.put(deb, arL.get(0));
			}else{
				tab.put(arL.get(j-1),arL.get(j));
			}
		}
			// Affichage test de la LinkedHashMap
			System.out.println(tab);
	}

}
