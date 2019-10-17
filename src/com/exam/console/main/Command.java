package com.exam.console.main;

public class Command {
	public static final String CMD_CD = "cd";
	public static final String CMD_EXIT = "exit";
	public static final String CMD_LS = "ls";
	public static final String CMD_MKDIR = "mkdir";
	public static final String CMD_PWD = "pwd";
	public static final String CMD_TOUCH = "touch";
	
	public static final String FLAGS_LS_RECURSIVE = "-r";
	public static final String FLAGS_CD_DIR_UP = "..";

	private String parameters;
	private String cmdString;

	public Command(String input) {
		String[] cmdChunks = input.split(" ");

		this.cmdString = cmdChunks[0];

		if (cmdChunks.length > 1) {
			this.parameters = cmdChunks[1];
		}
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getCmdString() {
		return cmdString;
	}

	public void setCmdString(String cmdString) {
		this.cmdString = cmdString;
	}

}
