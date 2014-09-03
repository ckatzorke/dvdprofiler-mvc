package org.dvdprofilermvc.parsing.xml.stax;

public class ParserContext {

	private String previousElement;
	private String currentElement;
	private int currentEventType;

	/**
	 * @return the local name of the previous element
	 */
	public String getPreviousElement() {
		return previousElement;
	}

	/**
	 * set the current element name
	 * @param currentElement
	 */
	public void setCurrentElement(String currentElement) {
		this.previousElement = this.currentElement;
		this.currentElement = currentElement;
	}

	public String getCurrentElement() {
		return currentElement;
	}

	public int getCurrentEventType() {
		return currentEventType;
	}

	public void setCurrentEventType(int currentEventType) {
		this.currentEventType = currentEventType;
	}

}
