import java.util.Random;


public class PasswordCreation {

	public static void main(String[] args) {
		//Welcome to the password generator game
		//This program was created on Friday, November 1st
		//This program will randomly select 3 words from the text that is presented as an array, and create 10000 passwords that would fit all the requirements needed
		//The purpose of this program is to be able to manipulate an array and do different complicated tasks with nested loops and have a good logic to get the wanted output
		//This is a 3 dimensional array which represents the page, the paragraph and the line and its name is book
		// http://www.gutenberg.org/cache/epub/19033/pg19033.txt
		final String[][][] book = {
				{
					{"ALICE was beginning to get very tired of sitting by her sister on the\n",
						"bank, and of having nothing to do. Once or twice she had peeped into the\n",
						"book her sister was reading, but it had no pictures or conversations in\n",
						"it, \"and what is the use of a book,\" thought Alice, \"without pictures or\n",
					"conversations?\"\n"},

					{"So she was considering in her OWN mind (as well as she could, for the\n",
						"day made her feel very sleepy and stupid), whether the pleasure of\n",
						"making a daisy-chain would be worth the trouble of getting up and\n",
						"picking the daisies, when suddenly a White Rabbit with pink eyes ran\n",
					"close by her.\n"},

					{"There was nothing so very remarkable in that, nor did Alice think it so\n",
						"very much out of the way to hear the Rabbit say to itself, \"Oh dear! Oh\n",
						"dear! I shall be too late!\" But when the Rabbit actually took a watch\n",
						"out of its waistcoat-pocket and looked at it and then hurried on, Alice\n",
						"started to her feet, for it flashed across her mind that she had never\n",
						"before seen a rabbit with either a waistcoat-pocket, or a watch to take\n",
						"out of it, and, burning with curiosity, she ran across the field after\n",
						"it and was just in time to see it pop down a large rabbit-hole, under\n",
					"the hedge. In another moment, down went Alice after it!"}
				},
				{

					{"\"WHAT a curious feeling!\" said Alice. \"I must be shutting up like a\n",
					"telescope!\"\n"},

					{"And so it was indeed! She was now only ten inches high, and her face\n",		
						"brightened up at the thought that she was now the right size for going\n",
					"through the little door into that lovely garden.\n"},

					{"After awhile, finding that nothing more happened, she decided on going\n",
						"into the garden at once; but, alas for poor Alice! When she got to the\n",
						"door, she found she had forgotten the little golden key, and when she\n",
						"went back to the table for it, she found she could not possibly reach\n",
						"it: she could see it quite plainly through the glass and she tried her\n",
						"best to climb up one of the legs of the table, but it was too slippery,\n",
						"and when she had tired herself out with trying, the poor little thing\n",
					"sat down and cried.\n"},

					{"\"Come, there's no use in crying like that!\" said Alice to herself rather\n",},

					{"sharply. \"I advise you to leave off this minute!\" She generally gave\n",
						"herself very good advice (though she very seldom followed it), and\n",
						"sometimes she scolded herself so severely as to bring tears into her\n",
					"eyes.\n"},

					{"Soon her eye fell on a little glass box that was lying under the table:\n",
						"she opened it and found in it a very small cake, on which the words \"EAT\n",
						"ME\" were beautifully marked in currants. \"Well, I'll eat it,\" said\n",
						"Alice, \"and if it makes me grow larger, I CAN reach the key; and if it\n",
						"makes me grow smaller, I can creep under the door: so either way I'll\n",
					"get into the garden, and I don't care which happens!\"\n"},

					{"She ate a little bit and said anxiously to herself, \"Which way? Which\n",
						"way?\" holding her hand on the top of her head to feel which way she was\n",
						"growing; and she was quite surprised to find that she remained the same\n",
					"size. So she set to work and very soon finished off the cake."}
				},
				{

					{"The King and Queen of Hearts were seated on their throne when they\n",
						"arrived, with a great crowd assembled about them--all sorts of little\n",
						"birds and beasts, as well as the whole pack of cards: the Knave was\n",
						"standing before them, in chains, with a soldier on each side to guard\n",
						"him; and near the King was the White Rabbit, with a trumpet in one hand\n",
						"and a scroll of parchment in the other. In the very middle of the court\n",
						"was a table, with a large DISH of tarts upon it. \"I wish they'd get the\n",
					"trial done,\" Alice thought, \"and hand 'round the refreshments!\"\n"},

					{"The judge, by the way, was the King and he wore his crown over his great\n",
						"wig. \"That's the jury-box,\" thought Alice; \"and those twelve creatures\n",
					"(some were animals and some were birds) I suppose they are the jurors.\"\n"},

					{"Just then the White Rabbit cried out \"Silence in the court!\"\n"},
					{"\"HERALD! read the accusation!\" said the King."}
				} 
		};
		//Display a welcome message
		System.out.println("Welcome to the password generator game!\n");
		//The random function starts here in order to be able to choose 3 random words
		//randomChoice is the name of the assigned random feature
		Random randomChoice = new Random();
		//numberOfPages is the number of pages in the book array
		int numberOfPages = book.length;
		//passwordCound represents the count of the correct passwords that meet all the conditions
		int passwordCount=0;
		//count also represents the count of the correct passwords that meet all the conditions, but this one starts at 1, so that it can allow us to exist the second loop when we have a correct password
		int count = 1;
		//the first loop starts here and it allows us to generate exactly 10000 passwords
		for (int j = 0; j < 10000; j++) 
		{
			//all the values here will be reinitialized each time we get a correct password that meets all the requirements
			//The upperCase boolean value is to determine if the password has an upper case, which will return true, or not
			boolean upperCase = false;
			//The lowerCase boolean value is to determine if the password has a lower case, which will return true, or not
			boolean lowerCase = false;
			//The special boolean value is to determine if the password has any special characters, which will return true, or not
			boolean special = false;
			//newLineCount counts how many words chosen randomly had a new line (\n) in them before getting to the right password
			int newLineCount = 0;
			//singleCount counts how many words chosen randomly were made of a single character before getting the right password
			int singleCount = 0;
			//equalCount counts how many time a password with two or more identical words in them were found before getting the right password
			int equalCount = 0;
			//lengthCount counts how many times a password not respecting the length limit was found before getting the right password
			int lengthCount = 0;
			//upperCount counts how many passwords were found with no upper case before finding the right password
			int upperCount = 0;
			//lowerCount counts how many passwords were found with no lower case before finding the right password
			int lowerCount = 0;
			//specialCount counts how many passwords were found with no special characters before finding the right password
			int specialCount = 0;
			//a while loop starts here in order to fins the right password
			//the count of passwords starts at 0, so as long as the passwordCount is not 1, it will not be equal to Count, which starts at 1, and when we get a right password they will be equal and we will exit the loop and the make a count++ and the same thing happens all over again
			while (passwordCount!= count)
			{
				//specialsInOnePassword counts how many special characters there is in one password in order to be able to only have one special character in the password
				int specialsInOnePassword = 0;
				//randomPage is the page chosen randomly with the random function
				int randomPage = randomChoice.nextInt(numberOfPages);
				//numberOfparagraphs finds the length of the page chosen randomly and find how many paragraphs the random page has
				int numberOfparagraphs = book[randomPage].length;
				//randomParagraph is the paragraph chosen randomly in the page that was recently chosen randomly too
				int randomparagraph = randomChoice.nextInt(numberOfparagraphs);
				//numberOfLine finds the length of the paragraph that was chosen randomly in the random page and find how many lines are in that paragraph
				int numberOfLines = book[randomPage][randomparagraph].length;
				//randomLine chooses a random line in the random paragraph and page 
				int randomLine = randomChoice.nextInt(numberOfLines);
				//line is the line that was chosen randomly put in a string
				String line = book[randomPage][randomparagraph][randomLine];
				//words separates the line into different words with the split() function
				String[] words = line.split(" ");
				//word1, word2 and word3 are 3 random words that are chosen randomly in the random line
				String word1 = words[randomChoice.nextInt(words.length)];
				String word2 = words[randomChoice.nextInt(words.length)];
				String word3 = words[randomChoice.nextInt(words.length)];
				//if any of the 3 words contain a new line (\n), then we should restart
				if (word1.contains("\n")||word2.contains("\n")||word3.contains("\n"))
				{
					//count the new line to display after
					newLineCount++;
					//back to the beginning of this loop
					continue;
				}
				//if any of the words is only made of one single character, then we should restart
				else if(word1.length() == 1||word2.length() == 1||word3.length() == 1)
				{
					//count the single character to display after
					singleCount++;
					//back to the beginning of the loop
					continue;
				}
				//if one of the words are identical then we should restart
				if(word1.compareTo(word2)==0||word1.compareTo(word3)==0||word2.compareTo(word3)==0)
				{
					//count the equal words in order to display after
					equalCount++;
					//back to the beginning of the loop
					continue;
				}
				//once the 3 words have passed the 3 conditions above, put them all together to create a password
				String wordsConcat = word1 + word2 + word3;
				//if the word is shorter than 8 letters and longer than 16, then we should restart
				if(wordsConcat.length() < 8||wordsConcat.length() >= 16)
				{
					//count how many times the length was not good to display after
					lengthCount++;
					//back to the beginning of the loop
					continue;
				}
				//make a loop in order to test that the password has at least one upper case character
				for(int s = 0; s< wordsConcat.length();s++)
				{
					//upperCase is the condition to see if the password has any upper cases
					upperCase =( wordsConcat.charAt(s)>=65&& wordsConcat.charAt(s)<=90);
					//as soon as the program finds one upper case, it gets out of the loop
					if(upperCase)
					{
						break;
					}
				}
				//if the password does not have any upper cases, we should restart
				if (!upperCase)
				{
					//count how many passwords didn't have any upper cases to display after
					upperCount++;
					//back to the beginning of the loop
					continue;
				}
				//make a loop in order to test the password has at least one lower case character
				for(int i = 0; i< wordsConcat.length();i++)
				{
					//lowerCase is the condition to see if the password has any lower cases
					lowerCase =( wordsConcat.charAt(i)>=97&& wordsConcat.charAt(i)<=122);
					//as soon as the program finds one lower case, it will get out of this loop
					if(lowerCase)
					{
						break;
					}
				}
				//if the password does not have any lower cases, we should restart, find a corect password and then stop the whole thing even if we didn't yet find 10,000 words
				if (!lowerCase)
				{
					//count it 
					lowerCount++;
					//get out of the whole loop
					continue;
				}
				//make a loop in order to test if the password has at least one special character
				for(int i = 0; i< wordsConcat.length();i++)
				{
					//special is the condition to see if the password has any special characters
					special =( (wordsConcat.charAt(i)>=33 && wordsConcat.charAt(i)<=64)||(wordsConcat.charAt(i)>=91&& wordsConcat.charAt(i)<=96)||(wordsConcat.charAt(i)>=123&& wordsConcat.charAt(i)<=126));
					//if the password has a special character count it, and count all that comes next to see how many special characters the password has
					if(special)
					{
						specialsInOnePassword++;
					}
					//if the specials in the password are more than one, then get out of the program, the password is already not accepted
					if (specialsInOnePassword>1)
					{
						//go back to the beginning of the loop
						break;
					}
				}
				//if the password does not have exactly one special character, then we should restart
				if(specialsInOnePassword!=1)
				{
					//count how many times this condition was not respected before getting to the right password to isplay after
					specialCount++;
					//go back to the beginning of the loop
					continue;
				}
				//display all the passwords in a formated way for the user to see
				System.out.println(String.format("%s = %-15s %15s = %-8s %8s = %-8s %8s = %-8s %8s = %-8s %8s = %-8s %8s = %-8s %8s = %-8s","Password", wordsConcat,"Newline",newLineCount,"Single", singleCount,"Equal",equalCount,"Length",lengthCount,"Upper",upperCount,"Lower",lowerCount,"Special",specialCount) );
				//count the password that got this far, because it is a correct password that meets all the conditions
				passwordCount++;
				//if the password does not have any lower cases, then get out of the loop
			}
			//make count+1 in order for the while loop to work
			count++;
			//if one of the generated passwords does not have any lower cases, then get out of the loop and stop the whole thing
			if (lowerCount != 0)
			{
				//get out of this loop
				break;
			}
		}
		//display how many passwords were generated and a thank you/goodbye message
		System.out.println("\nTotal passwords generated: " + passwordCount + "\n\nThanks for using the password generator game. Good bye.");
		//Thank you for using this password generator game
	}

}
