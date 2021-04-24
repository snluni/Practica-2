package es.urjc.code.daw.library.lineBreaker;

public class LineBreaker {
	public static final char NEXTLINE = '\n';
	public String breakText(String text, int lineLength) {
		if(text.length() <= lineLength) {return text;}
		StringBuilder textAux = new StringBuilder(text);
		int index = searchNearestSpace(textAux, lineLength);
		textAux.setCharAt(index, NEXTLINE);
		return textAux.toString();
	}
	private int searchNearestSpace(
		StringBuilder text, int startingIndex
	) {
		int index = startingIndex;
		char charAtIndex = text.charAt(index);
		while (index >= 0 && charAtIndex != ' ') {
			index--;
			charAtIndex = text.charAt(index);
		}
		return index;
	}
}
