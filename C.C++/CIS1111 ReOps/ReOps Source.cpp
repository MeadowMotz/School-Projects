/* - Ben Motz
 - 6/15/23
 - Relational Operators Assignment
 - For this assignment, you will be writing a sweepstakes program that allows the user to 
enter to win one of the three grand sweepstake prizes. However, their price guess must be within a 
certain percent of the actual price of the prize */
#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

int main()
{
	unsigned ch;
	double guess;
	string name;
	const double price1(99.99), price2(150.00), price3(549.99), price4(1349.58);
	cout << "~~~~~~~~~~~  Welcome to the Whimsical Wager Sweepstakes!  ~~~~~~~~~~~" << endl << endl
		<< "Prizes:" << endl
		<< "1. 1 Pair of Apple Earholes\n"
		<< "2. 5 tickets to the Obscene Opera\n"
		<< "3. A ditch-the-kids Alaskan cruise\n"
		<< "4. One week at the 5-star Cat-tastrophe Resort in Antarctica" << endl << endl
		<< "Please enter the number for your desired prize: ";
	cin >> ch;
	cout << endl << endl << setprecision(2) << fixed << showpoint;
	if (ch==1||ch==2||ch==3||ch==4)
	{
		name =
			(
				(ch == 1) ? "pair of Apple Earholes" :
				((ch == 2) ? "tickets to the Obscene Opera" :
					((ch == 3) ? "ditch-the-kids Alaskan cruise" :
						((ch == 4) ? "5-star Cat-tastrophe Resort" : "[Error]")))
			);
		cout << "Without using a $ sign or commas, what is your price guess for the " << name << "? ";
		cin >> guess;
		cout << endl << endl;
		if (guess > 0 && isfinite(guess))
		{
			switch (ch)
			{
			case 1:
			{
				if (guess == price1)
					cout << "Congratulations! You guessed it right on the money! You WIN!" << endl;
				else if (guess >= (price1 * .88) && guess <= (price1 * 1.12))
				{
					cout << "Congratulations! Your guess was close enough!\n"
						<< "The actual price of the " << name << " was: $" << price1 << "\n"
						<< "You WIN!!" << endl << endl;
				}
				else
				{
					cout << "Sorry, your guess was not close enough.\n"
						<< "The actual price of the " << name << " was: $" << price1 << "\n"
						<< "Better luck next time!" << endl << endl;
				}
				return 0;
			}
			case 2:
			{
				if (guess == price2)
					cout << "Congratulations! You guessed it right on the money! You WIN!" << endl << endl;
				else if (guess >= (price2 * .9) && guess <= (price2 * 1.1))
				{
					cout << "Congratulations! Your guess was close enough!\n"
						<< "The actual price of the " << name << " was: $" << price2 << "\n"
						<< "You WIN!!" << endl << endl;
				}
				else
				{
					cout << "Sorry, your guess was not close enough.\n"
						<< "The actual price of the " << name << " was: $" << price2 << "\n"
						<< "Better luck next time!" << endl << endl;
				}
				return 0;
			}
			case 3:
			{
				if (guess == price3)
					cout << "Congratulations! You guessed it right on the money! You WIN!" << endl << endl;
				else if (guess >= (price3 * .95) && guess <= (price3 * 1.05))
				{
					cout << "Congratulations! Your guess was close enough!\n"
						<< "The actual price of the " << name << " was: $" << price3 << "\n"
						<< "You WIN!!" << endl << endl;
				}
				else
				{
					cout << "Sorry, your guess was not close enough.\n"
						<< "The actual price of the " << name << " was: $" << price3 << "\n"
						<< "Better luck next time!" << endl << endl;
				}
				return 0;
			}
			case 4:
			{
				if (guess == price4)
					cout << "Congratulations! You guessed it right on the money! You WIN!" << endl << endl;
				else
				{
					cout << "Sorry, your guess was incorrect. \n"
						<< "The actual price of the " << name << " was: $" << price4 << "\n"
						<< "Better luck next time!" << endl << endl;
				}
				return 0;
			}
			}// End switch
		}
		else // Error for guess
		{
			cout << "You entered an invalid response. Please re-run the program and try again." << endl << endl;
			return 0;
		}
	}
	else // Error for prize choice
	{
		cout << "You entered an invalid response. Please re-run the program and try again." << endl << endl;
		return 0;
	}
}			