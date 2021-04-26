- pwd
- ls
- more
- cd
- rm
- mkdir
- mv
- grep
- .
- ..
- man

# Bash Tutorial

## What is the command line?
[An overview to what this tutorial is about]

## How to access the command line
[Tutorial setup instructions]

## Tutorial
### `pwd`
The **`pwd`** (print working directory) command tells you where you are within a filesystem.

	> pwd
	/Users/guest/Documents
	
In the example above, `/Users/guest` refers to the user's _home directory_. The user is currently located in the `Documents` folder. In the terminal used in this tutorial, the `pwd` command used will show only the name of the folder you are currently located in. The rest of the file path will be hidden.
#### Command #1
Type the **`pwd`** command to find out your current location within your filesystem. Whenever you are finished typing a command, press the Enter key to execute it. If you have completed the startup instructions correctly, you should be located inside of the `Start` folder. In this tutorial, the `Start` folder can be thought of as your home directory.

### `ls`
The **`ls`** (list) command lists the names of all of the files and subfolders inside of the current directory.

	> ls
	English
	History
	Science
	classSchedule
	
This user's `Documents` folder contains three directories: `English`, `History`, and `Science`, and one file: `classSchedule`. In this tutorial, directories (folders) always begin with a capital letter, and text files always begin with a lowercase letter.
#### Command #2
Type the **`ls`** command to see what is contained in the `Start` folder.

You can also use the `ls` command followed by the name of a folder inside your current directory to view what is inside of that directory without changing your location within the file system.

	> ls English
	BookReports
	Poetry
	readingList
	> pwd
	/Users/guests/Documents
	
As you can see from the example above, the user has viewed the contents of the `English` folder but is still located inside of the `Documents` folder.
#### Command #3
Type the **`ls`** command followed by the name of a folder inside your current directory in order to view its contents.


