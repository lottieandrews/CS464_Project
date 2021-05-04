# Command Line Tutorial

The command line is a powerful tool that allows you to control your computer using only the keyboard. In this tutorial, you will learn several different commands that you can use to navigate your computer's file system. 

## pwd
The **`pwd`** (print working directory) command tells you where you are within a file system. In the example below, `/Users/guest` refers to the user's _home directory_. The user is currently located in the `Documents` folder.

	> pwd
	/Users/guest/Documents
	> 
	
Use this command whenever you are unsure which folder you currently have open. In the terminal used in this tutorial, the `pwd` command will show only the name of the folder you are currently located in. The rest of the file path will be hidden.
### Task #1
- Type the **`pwd`** command to determine your current location within the file system. Whenever you are finished typing a command, press the Enter key to execute it. If you have completed the startup instructions correctly, you should be located inside of the `Start` folder. In this tutorial, the `Start` folder can be thought of as your home directory.


## ls
The **`ls`** (list) command lists the names of all of the files and subfolders inside of the current directory. 

	> ls
	English
	History
	Science
	classSchedule
	> 
	
In this tutorial, directories (folders) always begin with a capital letter, and text files always begin with a lowercase letter.
### Task #2
- Type the **`ls`** command to see what is contained in the `Start` folder.


## cd
The **`cd`** (change directory) command allows you to move from one directory into another. As the example below shows, `cd` followed by the name of a folder within your current directory will move you into that folder.

	> cd History
	> pwd
	/Users/guest/Documents/History
	> 
	
As shown below, typing `cd ..` will move you to the _parent_ of your current directory: in other words, the folder that houses the folder you're currently in. Think of this command as your back button.

	> cd ..
	> pwd
	/Users/guest/Documents
	> 

Typing the `cd ~` command will move you back to your home directory. Think of this command as your home button.

	> cd ~
	> pwd
	/Users/guest
	> 
	
### Task #3
- Use the **`cd`** command to move into the directory labelled `GoHere`. 
- Using the commands you've learned so far:
	- Check to make sure you're in the right place
	- View the contents of the directory.
- Use the **`cd`** command again to move into the directory labelled `KeepGoing`. Check to make sure you're in the right place and view the contents of the directory.
- See the directory labelled `EvenFurther`? You know the drill.
- Great! There are no more directories in this file path. Use the variation of **`cd`** that takes you back to the previous directory. Check that it worked.
- Instead of going back two more times, use the variation of **`cd`** that takes you right back to your home directory. Check that it worked one last time.


## more
The **`more`** command allows you to view the contents of a text file. Typing `more` followed by the name of a file in your current directory will print its contents to the console. In the example below, the user navigates to the directory which contains a file called `myPoem` and prints it contents.

	> cd Documents
	> cd English
	> cd Poetry
	> ls
	Drafts
	myPoem
	> more myPoem
	Shall I compare thee 
	to a summer's day? It's like:
	apples, oranges.
	> 
	
### Task #4
- Use the **`more`** command to view the contents of the file entitled `readMe`.


## grep
The **`grep`** command allows you to search a file to see if it contains a certain word. Typing `grep`, followed by the word you wish to search for, followed by the name of the file you wish to search will print all of the lines in the file which contain your specified word. In the example below, the user searches for the word `apples` in the file `myPoem`.
	
	> grep apples myPoem
	apples, oranges.
	> 
	
### Task #5
- Use the **`grep`** command to search for the word `foobar` in the file `searchMe`.


## mkdir
The **`mkdir`** (make directory) command allows you to create new directories. In the example below, the user creates a directory called `Haikus`. Their current folder now houses the folder they created.

	> mkdir Haikus
	> ls
	Drafts
	Haikus
	myPoem
	>
	
### Task #6
- Use the **`mkdir`** command to create a directory called `NewFolder`. 
- Using the commands you've learned so far, list the contents of your current directory to make sure your new folder was created.


## mv
The **`mv`** (move) command has two functions: renaming files or directories and moving them from one place to another. To rename a file or directory, we type `mv`, followed by the name of the file or directory, followed by what we wish to rename it to. In the exammple below, the user uses the `mv` command to change the name of `myPoem` to `myHaiku`.

	> mv myPoem myHaiku
	> ls
	Drafts
	Haikus
	myHaiku
	>
	
When renaming files in particular, be careful not to choose the name of a file that already exists as your new filename. If you do, that file will be overwritten. The same doesn't apply to directories, as we will learn below.

### Task #7
- Use the **`mv`** command to change the name of the file `renameMe` to `moveMe`. 
- List the contents of your current directory to make sure you exectued the command correctly.


The second function of the `mv` command is to move a file or directory into a different directory. To do this, we type `mv`, followed by the name of the file or directory we wish to move, followed by the name of the directory we wish to move it to. In the example below, the user moves `myHaiku` into the `Haikus` folder.

	> mv myHaiku Haikus
	> ls Haikus
	myHaiku
	>
	
### Task #8
- Use the **`mv`** command to move the file `moveMe` into `NewFolder`. 
- Using the commands you've learned so far:
	- Navigate to `NewFolder`.
	- List the contents of `NewFolder` to be sure it worked.
	- Navigate back to your home directory.
	

## rm
The **`rm`** (remove) command is used to delete files. In the example below, the user navigates into the `Drafts` folder and deletes the file `poemRoughDraft'. Since the `Drafts` folder is now empty, `ls` returns nothing.
	
	> cd Drafts
	> ls
	poemRoughDraft
	> rm poemRoughDraft
	> ls
	> 

### Task #9
Using the commands you've learned so far:
	- Navigate to the directory `DeleteMe`.
	- List the contents of the directory. 
- You should see a file named `removeMe`. Use the **`rm`** command to delete it. 
- List the contents of your current directory again to verify that it is now empty.


## rmdir
The **`rmdir`** (remove directory) command is used to delete empty directories. If the directory you are trying to delete contains any files or subfolders, the command will not work until its contents are deleted. In the example below, the user navigates from the now-empty `Drafts` folder back to its parent directory, then deletes the `Drafts` folder.

	> cd ..
	> ls
	Drafts
	Haikus
	> rmdir Drafts
	> ls
	Haikus
	>

### Task #10
- Navigate back to your home directory.
- Use the **`rmdir`** command to delete the directory `DeleteMe`. 
- List the contents of your current directory to verify that `DeleteMe` no longer exists.


## Congratulations!
You have now completed the tutorial. Type the command `exit` to exit the program and proceed to the next step of this study.
