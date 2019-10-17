package com.exam.filesystem;

public abstract class FileSystemElement {

	protected String name;
	protected int elementType;

	public FileSystemElement(String elementName) {
		this.name = elementName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getElementType() {
		return this.elementType;
	}
}
