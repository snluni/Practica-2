package es.urjc.code.daw.library.lineBreaker;

public class LineBreaker {
	public static final char NEXTLINE = '\n';
	public static final char SPACE = ' ';
	public static final char HYPHEN = '-';
	
	public String breakText(String text, int lineLength) {
		text.trim();
		if (text.length() <= lineLength) {return text;}
		StringBuilder textAux = new StringBuilder(text);
		int index = searchNearestSpace(textAux, lineLength);
		if(index > 0) {
			textAux.setCharAt(index, NEXTLINE);
			deleteRightSpaces(textAux,index+1);
			deleteLeftSpaces(textAux,index-1);
		}
		else {
			textAux.insert(lineLength-1,NEXTLINE);
			textAux.insert(lineLength-1,HYPHEN);
		}
		return textAux.toString();
	}
	
	private int searchNearestSpace(
		StringBuilder text, int startingIndex
	) {
		int index = startingIndex;
		char charAtIndex = text.charAt(index);
		while (index > 0 && charAtIndex != ' ') {
			index--;
			charAtIndex = text.charAt(index);
		}
		return index;
	}
	
	private void deleteRightSpaces(StringBuilder text, int startingIndex) {
		char charAux = text.charAt(startingIndex);
		while (startingIndex < text.length() && charAux == SPACE) {
			text.deleteCharAt(startingIndex);
			charAux = text.charAt(startingIndex);
		}
	}
	private void deleteLeftSpaces(StringBuilder text, int startingIndex) {
		char charAux = text.charAt(startingIndex);
		while (startingIndex >= 0 && charAux == SPACE) {
			text.deleteCharAt(startingIndex);
			startingIndex--;
			charAux = text.charAt(startingIndex);
		}
	}
}
