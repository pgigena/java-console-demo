package src.main;

import src.main.fileSystem.*;

public class Console {

	FileSystemManager fsManager;

	public Console() {
		this.fsManager = new FileSystemManager();
	}

	public void run(String[] input) {
		boolean keepRunning = true;
		String result;

		for (int i = 0; i < input.length && keepRunning; i++) {
			Command command = new Command(input[i]);
			result = null;

			switch (command.getCmdString()) {
				case Command.CMD_CD:
					result = this.fsManager.cd(command.getParameters());
					break;
				case Command.CMD_LS:
					result = this.fsManager.ls(command.getParameters());
					break;
				case Command.CMD_MKDIR:
					this.fsManager.mkdir(command.getParameters());
					break;
				case Command.CMD_PWD:
					result = this.fsManager.pwd();
					break;
				case Command.CMD_TOUCH:
					this.fsManager.touch(command.getParameters());
					break;
				case Command.CMD_EXIT:
					keepRunning = false;
					break;
				default:
					result = "Unrecognized command " + command.getCmdString();
			}

			System.out.println(">" + input[i] + ":");
			if (result != null) {
				System.out.println(result);
			}
		}
	}

}
