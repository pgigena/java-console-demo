package src.main.fileSystem;

import src.main.Command;

public class FileSystemManager {

	private static Directory root;
	private Directory currentDir;

	public FileSystemManager() {
		FileSystemManager.root = new Directory("root", null);
		this.currentDir = FileSystemManager.root;
	}

	public void touch(String fileName) {
		this.currentDir.addElement(new File(fileName));
	}

	public void mkdir(String dirName) {
		this.currentDir.addElement(new Directory(dirName, this.currentDir));
	}

	public String pwd() {
		String fullPath = "";
		Directory currentNode = this.currentDir;

		do {
			fullPath = currentNode.getName() + "/" + fullPath;
			currentNode = currentNode.getParent();
		} while (currentNode != null);

		return fullPath;
	}

	public String cd(String dirName) {
		String response = null;

		if (dirName.equals(Command.FLAGS_CD_DIR_UP) && this.currentDir.getParent() != null) {
			this.currentDir = this.currentDir.getParent();
		} else {
			try {
				this.currentDir = this.currentDir.getChildDir(dirName);
			} catch (Exception ex) {
				response = "Directory " + dirName + " not found";
			}
		}

		return response;
	}

	public String ls(String cmdParameters) {
		boolean recursive = false;

		if (cmdParameters != null && cmdParameters.equals(Command.FLAGS_LS_RECURSIVE)) {
			recursive = true;
		}

		String contents = this.currentDir.listContents(recursive); 
		return contents.substring(0, contents.length() - 1);
	}
}
