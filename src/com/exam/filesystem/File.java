package com.exam.filesystem;

public class File extends FileSystemElement {

	public File(String fileName) {
		super(fileName);
		this.elementType = ElementType.TYPE_FILE;
	}

}
