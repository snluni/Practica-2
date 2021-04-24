package es.urjc.code.daw.library.lineBreaker;

public class LineBreaker {
	public final char NEXTLINE = '\n';
	public String breakText(String text, int lineLength) {
		if(text.length() > lineLength) {
			StringBuilder textAux = new StringBuilder(text);
			textAux.setCharAt(lineLength, NEXTLINE);
			text = textAux.toString();
		}
		return text;
	}
}
