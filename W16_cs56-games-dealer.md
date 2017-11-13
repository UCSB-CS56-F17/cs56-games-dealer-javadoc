a) This project is a Card dealer program, deals a deck to one hand, can shuffle the deck, and prints out the current cards in the hand and deck.

b) As a card player, I can say how many cards I want to draw and then the program will give me the number of cards I asked for.
As a card player, I can say that I want the deck shuffled before I draw any cards, and then the program will shuffle the deck.
As a card player, I can draw cards and then see what cards are in my hand.
As a card player, I can see what cards are left in the deck once I am done playing.

c) The program runs without error. When you run the program, a prompt appears on the terminal asking whether you want to shuffle the deck or not. After giving your input, the program prompts you to input how many cards you want to draw. After you input how many cards you want, the program displays your current hand. Then the program prompts you to input whether you want to continue or not. If you continue, the program starts over with asking whether you would like to shuffle the deck. If you don't continue, the remaining cards in the deck are displayed and the program says goodbye.

d) As a card player, I would like to have GUI functionality so that it is a more friendly experience using the program.
As a card player, I would like to be able to deal multiple hands so that I can play in a group.
As a card player, I would like to have cards displayed as images rather than text.
As a card player, I would like to hear sounds while the deck shuffles, and when cards are being dealt.
As a card player, I would like to be able to shuffle the deck after each player draws.

e) README.md is very minimal, it just contains the project history, a brief description of the program, how to run the program, and a brief description of how the program works. Adding a list and description of Ant targets would help make it easier to read and understand the build.xml file. Screenshots of the program in action would be useful to show what the program looks like before running it.

f) There are several targets that don't have descriptions: These include clean, javadoc, jar, download, and publish. The download and publish targets appear to be legacy JWS stuff that needs to be removed. Linenumber target doesn't work.

g) Current issues include: implement a GUI, implement multiple hands functionality, implement sounds when shuffling, and include images of cards instead of just text when displaying the cards. Completing all of these issues would be enough to reach 1000 points . Yes all of the issues are very clear in how to resolve them.

h)
Issue #12: https://github.com/UCSB-CS56-Projects/cs56-games-dealer/issues/12

Issue #13: https://github.com/UCSB-CS56-Projects/cs56-games-dealer/issues/13

Issue #14: https://github.com/UCSB-CS56-Projects/cs56-games-dealer/issues/14

i) The three classes that are currently used by the program are the Deck, Hand, and dealer classes. The purpose of each class is very clear, including their methods. The dealer class uses one instance of a Deck and one instance of a Hand to run. The dealer is the command line prompter and handles the inputs of the user accordingly. The code is pretty easy to understand, especially with the comments that explain it. 

Hand.java: Contains an array member variable that holds the cards in a player's hand. It also has an addToHand method which adds each card that the player is dealt to their hand.

Deck.java: Contains an array member variable which holds all the cards of a deck of cards. It has a shuffle deck method as well as a remove card method for when a player takes a card from the deck and adds it to their hand.

dealer.java: The dealer class connects the command line inputs to the methods needed to shuffle a deck, removes cards for a deck, and deal them to a player.

j.) There are no tests or JUnit tests. None of the project is covered by testing. There are opportunities to expand test coverage. One would go about doing this by adding tests for drawing any number of cards from the in between the bounds 0-52 as well as adding tests for the bounds cases. One would also want to add tests for what happens if you draw a negative number of cards or a number greater than 52. We would also want to look at the behavior when the user wants to continue drawing. Are the cards added to the hand? What about when the deck is empty, what happens? Does resetting the deck work?
