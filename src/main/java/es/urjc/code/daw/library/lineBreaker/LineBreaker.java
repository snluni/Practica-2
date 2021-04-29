package es.urjc.code.daw.library.lineBreaker;

public class LineBreaker {
	public static final char NEXTLINE = '\n';
	public static final char SPACE = ' ';
	public static final char HYPHEN = '-';
	
	public String breakText(String text, int lineLength) {
		int lineDivider = lineLength;
		StringBuilder textAux = new StringBuilder(text.trim());
		while (lineDivider < textAux.length()) {
			int index = searchNearestSpace(textAux, lineDivider);
			if (index > 0) {
				lineDivider = index;
				textAux.setCharAt(lineDivider, NEXTLINE);
				deleteRightSpaces(textAux, lineDivider + 1);
				deleteLeftSpaces(textAux, lineDivider - 1);
			} else {
				textAux.insert(lineDivider - 1,NEXTLINE);
				textAux.insert(lineDivider - 1,HYPHEN);
			}
			lineDivider = lineDivider + lineLength + 1;
		}
		return textAux.toString();
	}
	
	private int searchNearestSpace(StringBuilder text, int startingIndex) {
		int index = startingIndex;
		char charAtIndex = text.charAt(index);
		while (index > 0 && charAtIndex != SPACE && charAtIndex != NEXTLINE) {
			index--;
			charAtIndex = text.charAt(index);
		}
		if(charAtIndex == NEXTLINE)
			return -1;
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
