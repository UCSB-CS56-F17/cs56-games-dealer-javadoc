cs56-games-dealer
=================

project history
===============
```
 W14 | jcneally 4pm | acantor | Application to shuffle a deck of 52 playing cards and deal them to the use

 W16 | ttstarck kellybielaski 5pm | Added GUI and multiple hand functionality
 
 F16 | eric-xiao8 kpoon1 5 pm | Added main menu and Blackjack game
 
```

What is this?
=============

This is an interface with classes such as card, deck, and hand that can be used to make card games. 
Dealer itself is an application to shuffle a deck of 52 playing cards and deal them to the user using command lines. 


How To Run
==========

In the directory of where the build.xml is located 


    Type `ant run` - runs terminal
    Type 'ant runGUI' - runs GUI


 Other Ant Targets

 
    compile - compiles code
    linenumbers - creates file containing all source files with line numbers (doesn't work)
    clean - deletes javadoc, .jar, download, temp, and .class files
    javadoc - creates javadoc
    jar - creates a jar file
    download - old JWS target
    publish - old JWS target
    test - runs a JUnitTest
    
    
How does the application work?
==============================
Command Line:
The user is asked many hands the user wants to be dealt, then if the user wants the deck to be shuffled. The user is asked for a number to be dealt for each hand. The inputted numbers of cards are dealt to the player's hands and removed from the deck. The user is asked if they want to draw again until there are no more cards left in the deck. The user must input an integer from 0 to 52. Otherwise, the user will be dealt a default hand and the application will end. In the case of the deck being empty, the application will prompt the user to either reset with an empty hand and new deck or exit. The shuffle is done by using the shuffle function in the Collections class by using a RandomSecure seed.

GUI:
The user is prompted how many hands they want and if they don't want the deck to be shuffled, only shuffled once, or before each player draws. Then a panel is displayed that contains the textfields where the user can input how many cards they want for each hand. Then click the display cards button which replaces that panel with a new panel containing the textarea that displays the cards dealt for each hand and the remaining cards in the deck. The user can choose to continue drawing or reset the deck.

F16 final remarks:
===================
The dealer interface has been updated to include card images and the game Blackjack has been created. Both console and GUI versions exist which can be run with 'ant run' and 'ant runGUI'. The code for the main menu is located in 'MainGui.java' and here additional games that are created can be added. One thing that can be improved for the Blackjack game is that when the player wins or loses, the continue button pushes the other GUI components to the left. This can be fixed so that they remain stationary instead. Also, the card class can be refactored. At the moment there are methods in the card class that are used specifically for Blackjack such as the rankValue method. These methods can be refactored into the Blackjack game so that Card remains generalized for other games.   

