package java8practice;


public enum Suit {
SPADE(Color.BLACK),HEARTS(Color.RED);
private enum Color{RED,BLACK;}
Suit(Color c){
	color=c;
}
public Color color;
}
