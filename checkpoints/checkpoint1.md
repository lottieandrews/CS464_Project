# CS464 Project

## Description
With more and more teaching being done via technology, e-Learning is on the rise. Whether it’s a teacher looking for online materials to supplement their lessons or people who are seeking out whole education programs online via websites like Udemy and Codecademy, there is a high demand for interactive learning software. We propose a project that would create a prototype of an interactive learning application that would teach the user how to execute various beginner terminal functions. While using the terminal is a valuable computer science skill, teaching computer science students how to use it sometimes slips through the cracks, leaving students to have to learn how to use it on their own. This application would attempt to provide a fun and interactive way to learn how to execute some of the most common tasks using the terminal.

## Technology
This project was inspired by the MIT game [Terminus](https://web.mit.edu/mprat/Public/web/Terminus/Web/main.html), a text adventure game designed to teach terminal commands to new users. We will be creating a similar text adventure game centered around the metaphor of a detective searching for clues, which will teach subjects a predetermined set of common Bash commands. We will create a simulated Bash environment using Java, which will allow us to introduce new commands incrementally to the user. In addition we will create a simple written tutorial which covers the same set of commands, either in print or using HTML. This tutorial will be the baseline against which the text adventure game is compared. Test subjects will be split randomly into two groups, will spend a predetermined amount of time learning the Bash commands using either the game or the written tutorial, depending on which group they are assigned to. Subjects will then be given a series of tasks to complete from the command line in order for us to assess how much they have learned. Depending on whether testing is done remotely or in person, the assessment may be done directly in the command line or in a second simulated Bash environment. In this case, the assessment environment may be created by modifying [bash-emulator](https://github.com/trybash/bash-emulator/blob/gh-pages/index.html) or similar software, or it may be an existing online Linux terminal such as [JSLinux](https://bellard.org/jslinux/) or similar. A Bash script will be created to store each subject's assessment results and reset the environment for the next subject.


## Motivation
The demand for interactive learning tools is at an all time high. Now more than ever students and teachers alike are relying on well designed interactive learning software. The motivation behind this project is to determine what makes interactive learning software intuitive and easy to use. When it comes to e-learning, researchers have been studying the effects of various input and output devices to improve upon e-learning applications. Input devices currently being researched include time stamping (determine time delays between user responses and use this to judge the difficulty level of the question or the interest level of the user), three-dimensional pointing and manipulation, facial expression recognition, and voice. Output devices include better graphics resolution, touchable three-dimensional displays, non-speech audio output for ‘visualizing data’, and color (Gawande, Virendra, 2010). The goal of this project will be to implement at least one of these input/output devices and create an experiment around our prototype to determine if the presence of these devices has any meaningful impact on how effective the e-learning software was at teaching the user how to use the terminal. 
Gawande, Virendra. (2010). Effective Use of HCI in e-Learning. 14. 17-18.

## Deliverables

## End Goals

## Resources

[Terminus Study](http://web.mit.edu/mprat/Public/web/Terminus/Java/CMS.590Game2FinalReport.pdf) //Cite properly later
