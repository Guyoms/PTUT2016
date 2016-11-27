package Model;

import java.util.ArrayList;
import java.util.Collection;


/*
 * Contient toutes les cases non rangées, sert principalement à mélanger sans perdre le contenu
 */

public class Grid {
	private Collection<Element> content;
	private int height;
	private int length;
	
	public Grid(int height, int length){
		this.height=height;
		this.length=length;
		this.content = new ArrayList<Element>();
	}
}
