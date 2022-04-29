<div align="center" id="top">
    <h3>Created by: Tony Teets and Skylar Nguyen</h3>
    <img src="https://cdn.iconscout.com/icon/free/png-256/sword-1777408-1512000.png" width="128px" alt="Swords crossed">
    <h1 align="center">Battle Simulator</h1>
    
</div>
<details open="open" id="toc">
    <summary>Table of Contents</summary>
    <ol>
        <li>
            <a href="#about-the-project">About the project</a>
            <ul>
                <li>
                    <a href="#features">Features</a>
                </li>
                <li>
                    <a href="#built-with">Built With </a>
                </li>
            </ul>
        </li>
        <li>
            <a href="#getting-started">Getting Started</a>
            <ul>
                <li>
                    <a href="#installing">Installing</a>
                </li>
                <li>
                    <a href="#running">Executing Program</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="#usage">Usage</a>
        </li>
    </ol>
</details>

## About The Project

<h3 align="center"><u>Welcome to the battle simulator!</u><br></h3>
<p>In this game you will be playing as a warrior that is battling monsters 
and leveling up as you go. You will be able to attack enemies and heal
yourself when you start getting low. Make sure you keep that health up!</p>

### Features
<ul>
    <li>{number tbd} different types of enemies</li>
    <li>Health potions</li>
    <li>Damage upgrades through leveling</li>
    <li>Health upgrades through leveling</li>
    <li>Being able to save your progress</li>
    <li>Load from a previous save file</li>
</ul>

### Built With
* [Java](https://java.com)

## Getting Started

### Installing

<p>When wanting to use this game you will want to get the files for it.
Well you might be wondering. Well how might I do that? Well I am going
to tell you.</p>

<p>First you are going to want to clone the repo. To do this you will use
the command:</p>

<pre>
HTTPS users: 
git clone https://gitlab.cs.uno.edu/tmteets/battle_simulator.git

SSH users:
git clone git@gitlab.cs.uno.edu:tmteets/battle_simulator.git
</pre>

<p>After this you will want to compile all the java files from the repo that 
you just cloned. To do this you will use the command:</p>

<pre>javac *.java ./Entities/*.java ./Game/*.java ./StandardIO/*.java</pre>

<p>After you finish this last step, congratulations! You have completed the installation of 
your brand-new battle simulator game.</p>

### Running

<p>Now that you have completed the installation of the game you are probably wondering how to
even start the game since there is not an .exe file. Well you are in luck because I will give you the answer
to that as well!</p>

<p>To start running your new game you will want to run the command:</p>

<pre>
java Main
</pre>

## Usage

<p> Now that you are running the game it will first ask you to enter a name for your character. All names are required to be 10 or less characters and the program will be sure that the name you enter is just that.</p>
    
<p> Now that you have entered a name IT IS TIME TO PLAYYYY!. There are 4 actions you can do: </p>

| Actions   | Explanation                                                              |
| :-------- | :----------------------------------------------------------------------- |
| a: attack | This will allow you to attack the enemy                                  |
| h: heal   | If you have enough health potions this will allow yout character to heal |
| s: save   | This will allow you to save the game in its current state                |
| l: load   | If you have a save file then you can load that game back up              |


