# Java Console Application demo
A simple console and file system emulation I built for a coding exam using Java which supports multiple commands.

## Notice
The real exam took repeated line inputs from *stdin* and broke it into separate commands which where then fed to the solution (Console) class.
Since this is just a demo app meant to be run from within a Java IDE, commands are hardcoded into the main file and split with the newline character.

## Supported Commands
### pwd
Shows the current directory where commands will be run.

###  mkdir
Creates a directory with the specified name `mkdir dirName` as long as no file or directory with the same name exists.

### touch
Creates a file with the specified name `touch fileName` as long as no file or directory with the same name exists.

### cd
Allows to change the cursor to a specific child `cd dirname` or the parent `cd ..` of the current directory.

### ls 
Lists a directory contents. If the `-r` flag is added, then contents are listed recursively.

### exit
Ends execution ignoring any further commands.

## Usage
If one wished to create a directory named `foo`, add two files named `bar.txt` and `baz.txt` and finally list the contents of foo, the command sequence would be:

1. `mkdir foo`
2. `cd foo`
3. `touch bar.txt`
4. `touch baz.txt`
5. `cd ..`
6. `ls`
7. `exit`

And the source for the main file would look like:

```Java
String input = "mkdir foo" + "\n"
				+ "cd foo" + "\n"
				+ "touch bar.txt" + "\n"
				+ "touch baz.txt" + "\n"
				+ "cd .." + "\n"
				+ "ls" + "\n"
				+ "exit";
```

Or if one wished to list the contents of the whole File System:

```Java
String input = "mkdir foo" + "\n"
				+ "cd foo" + "\n"
				+ "touch bar.txt" + "\n"
				+ "touch baz.txt" + "\n"
				+ "cd .." + "\n"
				+ "cd .." + "\n"
				+ "ls -r" + "\n"
				+ "exit";
``` 