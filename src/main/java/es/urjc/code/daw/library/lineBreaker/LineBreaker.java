package es.urjc.code.daw.library.lineBreaker;

public class LineBreaker {
	public static final char NEXTLINE = '\n';
	public static final char SPACE = ' ';
	
	public String breakText(String text, int lineLength) {
		if (text.length() <= lineLength) {return text;}
		StringBuilder textAux = new StringBuilder(text);
		int index = searchNearestSpace(textAux, lineLength);
		textAux.setCharAt(index, NEXTLINE);
		deleteSpaces(textAux, index + 1);
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

	private StringBuilder deleteSpaces(
		StringBuilder text, int index) {
		char charAux = text.charAt(index);
		while (index < text.length() && charAux == SPACE) {
			text.deleteCharAt(index);
			charAux = text.charAt(index);
		}
		return text;
	}
}
