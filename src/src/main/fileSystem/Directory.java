package src.main.fileSystem;

import java.util.HashMap;
import java.util.Iterator;

public class Directory extends FileSystemElement {
	HashMap<String, FileSystemElement> files;
	private Directory parent;

	public Directory(String fileName, Directory parent) {
		super(fileName);
		this.parent = parent;
		this.elementType = ElementType.TYPE_DIR;

		this.files = new HashMap<String, FileSystemElement>();
	}

	public Directory getParent() {
		return parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}

	public void addElement(FileSystemElement element) {
		this.files.put(element.getName(), element);
	}

	public Directory getChildDir(String dirName) throws Exception {
		FileSystemElement element = this.files.get(dirName);

		if (element == null || element.getElementType() != ElementType.TYPE_DIR) {
			throw new Exception("El directorio solicitado no existe");
		}

		return (Directory) element;
	}

	public File getElement(String fileName) throws Exception {
		FileSystemElement element = this.files.get(fileName);

		if (element == null || element.getElementType() != ElementType.TYPE_FILE) {
			throw new Exception("El archivo solicitado no existe");
		}

		return (File) element;
	}

	public String listContents(boolean recursive) {
		return this.listContents(recursive, "");
	}

	public String listContents(boolean recursive, String leadingSpaces) {
		String contents = "";

		Iterator<HashMap.Entry<String, FileSystemElement>> iterator;
		iterator = this.files.entrySet().iterator();

		while (iterator.hasNext()) {
			HashMap.Entry<String, FileSystemElement> entry = iterator.next();

			contents += leadingSpaces;
			contents += entry.getValue().getName();
			contents += "\n";

			if (recursive && entry.getValue().getElementType() == ElementType.TYPE_DIR) {
				contents += ((Directory) entry.getValue()).listContents(true, leadingSpaces + "  ");
			}
		}

		return contents;
	}
}
