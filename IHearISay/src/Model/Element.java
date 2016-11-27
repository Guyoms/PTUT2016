package Model;

public class Element {
	private String content;
	private Element nextElement;
	
	public Element(){
		this.content="";
	}
	
	public Element(String content){
		this.content=content;
	}
}
