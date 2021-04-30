# CS464 Project

## Description
With more and more teaching being done via technology, e-Learning is on the rise. Whether it’s a teacher looking for online materials to supplement their lessons or people who are seeking out whole education programs online via websites like Udemy and Codecademy, there is a high demand for interactive learning software. We propose a project that would create a prototype of an interactive learning application that would teach the user how to execute various beginner terminal functions. While using the terminal is a valuable computer science skill, teaching computer science students how to use it sometimes slips through the cracks, leaving students to have to learn how to use it on their own. This application would attempt to provide a fun and interactive way to learn how to execute some of the most common tasks using the terminal.

## Technology
This project was inspired by the MIT game [Terminus](https://web.mit.edu/mprat/Public/web/Terminus/Web/main.html), a text adventure game designed to teach terminal commands to new users. We will be creating a similar text adventure game centered around the metaphor of a detective searching for clues, which will teach subjects a predetermined set of common Bash commands. We will create a simulated Bash environment using Java, which will allow us to introduce new commands incrementally to the user. In addition we will create a simple written tutorial which covers the same set of commands, either in print or using HTML. This tutorial will be the baseline against which the text adventure game is compared. Test subjects will be split randomly into two groups, will spend a predetermined amount of time learning the Bash commands using either the game or the written tutorial, depending on which group they are assigned to. Subjects will then be given a series of tasks to complete from the command line in order for us to assess how much they have learned. Depending on whether testing is done remotely or in person, the assessment may be done directly in the command line or in a second simulated Bash environment. In this case, the assessment environment may be created by modifying [bash-emulator](https://github.com/trybash/bash-emulator/blob/gh-pages/index.html) or similar software, or it may be an existing online Linux terminal such as [JSLinux](https://bellard.org/jslinux/) or similar. A Bash script will be created to store each subject's assessment results and reset the environment for the next subject.


## Motivation
The demand for interactive learning tools is at an all time high. Now more than ever students and teachers alike are relying on well designed interactive learning software. The motivation behind this project is to determine what makes interactive learning software engaging and effective. We will speficially be focusing on creating a murder mystery story to teach people how to use various terminal commands using our interactive software. By linking terminal commands to events like finding a clue or storing evidence, we hope to make a fun and effective teaching tool that increases retention and engagement. Various studies have been conducted on the effects of educational games and simulations on learning. In a study by SRI Education conducted on K-12 grade students, researchers found that students who used simulations as part of their learning process often had a better outcome than those who didn't (SRI Education, 2014). In another study on game-based learning, researchers studied the effects of an educational game adapted from the popular game Minecraft on second year college students. Their results determined that game-based learning increases student motivation and engagement (Cozar, Saez-Lopez, 2016). We believe that by creating a game geared towards teaching terminal skills, we will develop a more engaging and more effective way to learn.  

## Deliverables
Our only deliverable will be a link one of two webpages. The webpages will contain a download link for either the .jar file of the Bash game or the file containing the written tutorial. Both webpages will also contain a link to the Bash assessment environment, a demographic form for each user to fill out, and the instructions for the study.

## End Goals
By the end of this project, we hope to have a jar executable file that runs a text adventure game aimed at teaching the user how to use basic terminal commands. The user will have an introduction to the commands and be launched into a step-by-step text adventure in which they will have to solve the murder mystery by finding clues located in different files that must be accessed by using the correct terminal commands. We hope to create an engaging and effective learning tool that can aid in the users’ understanding of how to use terminal commands and gain confidence in their new skills.  

## Resources
Conrad, Shawn, Michaela LaVan, Michele Pratusevich, Emma Tolley, and David Zou. (2011). Terminus: A Text Adventure Game To Promote Learning About Terminal Command Line Interfaces. 11.127/252/CMS.590.   web.mit.edu/mprat/Public/web/Terminus/Java/CMS.590Game2FinalReport.pdf. 

Cózar, Ramón & Sáez-López, José-Manuel. (2016). Game-based learning and gamification in initial teacher training in the social sciences: an experiment with MinecraftEdu. International Journal of Educational Technology in Higher Education. 13. 10.1186/s41239-016-0003-4. 

D’Angelo, C., D. Rutstein, C. Harris, R. Bernard, E. Borokhovski, and G. Haertel (2014). Simulations for STEM Learning:
Systematic Review and Meta-Analysis. Menlo Park, CA: SRI International
