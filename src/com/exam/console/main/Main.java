package com.exam.console.main;

public class Main {

	public static void main(String[] args) {

		System.out.println("Iniciando");
		String s = "pwd\n"
				+ "mkdir dir1\n"
				+ "mkdir dir2\n"
				+ "touch file1.txt\n"
				+ "ls\n"
				+ "cd dir1\n"
				+ "pwd\n"
				+ "mkdir subdir_1\n"
				+ "touch d1_f1.txt\n"
				+ "touch d1_f2.txt\n"
				+ "ls\n"
				+ "cd subdir_1\n"
				+ "pwd\n"
				+ "touch s1_file1.txt\n"
				+ "cd ..\n"
				+ "pwd\n"
				+ "cd ..\n"
				+ "pwd\n"
				+ "cd fail\n"
				+ "ls -r\n"
				+ "exit";
		
		String [] input = s.split("\n");

		Console myConsole = new Console();
		
		myConsole.run(input);
		System.out.println("Fin");
	}

}
