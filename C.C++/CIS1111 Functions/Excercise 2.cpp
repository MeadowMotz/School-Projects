/* - Ben Motz
- 6/29/23
- Functions: Excercise 2
- For this assignment, you will be simulating an online ordering platform for your user by 
displaying a menu and allowing them to continuously add food to their order until they 
choose to “cash out”. The menu must be called from a function. When the user cashes out, 
send their order to anotherfunction that will calculate their bill and display it to them – 
including a 20% tip! The menu items and prices are up to you, but you must offer at 
least 3 items. */
/*
- >= 3 items
- any price
- 20% tip
- menu function
- cash out function 
- enable multiple ordering 
please enter your selection
how many?
your bill
food total
tip
final bill */
#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

double sum(int amm[], double price[])
{
	double total = 0;
	for (int cc = 0; cc < 6; cc++)
	{
		if (amm[cc] > 0)
		{
			total += price[cc] * amm[cc];
		}
	}
	return total;
}

void menu()
{
	cout << "1. Eda-mame\n"
		<< "2. Luz-ious Linguine\n"
		<< "3. King-sized Kabobs\n"
		<< "4. Hunter's Hayashi Rice\n"
		<< "5. Belos Brat\n"
		<< "6. Hooty's Signature Hotcakes\n\n";
	return;
}

void cash(int amm[], double price[], string food[])
{
	double total = sum(amm, price);
	string line;
	cout << setw(10) << " " << "~~~~~Your Bill~~~~~" << endl
		<< fixed << setprecision(2) << showpoint;
	for (int cc = 0; cc < 6; cc++)
	{
		if (amm[cc] > 0)
		{
			line = "(" + to_string(amm[cc]) + ") ";
			cout << setw(5) << line << setw(30) << food[cc] 
				<< "$" << amm[cc] * price[cc] << endl;
		}
	}
	cout << setw(35) << "Subtotal: ";
	cout << "$" << total << endl << endl
		<< "Enter your tip amount as a XX%: ";
	double tip;
	cin >> tip;
	total *= (1 + tip);
	cout << endl << endl
		<< setw(35) << "Your total: ";
	cout << "$" << (sum(amm, price)*(1+tip/100))
		<< endl << endl << endl
		<< "Thank You!" << "\n\n\n\n";
}

int main()
{
	string food[6]{ "Eda-mame", "Luz-ious Linguine", "King-sized Kabobs", 
		"Hunter's Hayashi Rice", "Belos Brat", "Hooty's Signature Hotcakes" };
	double price[6]{ 2.22, 13.32, 8.88, 11.10, 6.66, 4.44 };
	int amm[6]{ 0,0,0,0,0,0 };
	char ch;

	cout << left << "Welcome to Hooty's Homecooked Meals!\n"
		<< "Here's our menu:\n\n";

			menu();

	cout << "Enter the number for the food you wish to order: \n"
		<< "When done ordering, press 0 to cash out.\n"
		<< "-> ";
	do
	{
		cin.get(ch);
		cout << endl << endl;
		if (ch=='1' || ch=='2' || ch=='3' || ch=='4' || ch=='5' || ch=='6')
			switch (ch)
			{
			case '1':
			{
				cout << "How many? ";
				cin >> amm[0];
				cout << "\n\n" << "-> ";
				cin.ignore();
				break;
			}
			case '2':
			{
				cout << "How many? ";
				cin >> amm[1];
				cout << "\n\n" << "-> ";
				cin.ignore();
				break;
			}
			case '3':
			{
				cout << "How many? ";
				cin >> amm[2];
				cout << "\n\n" << "-> ";
				cin.ignore();
				break;
			}
			case '4':
			{
				cout << "How many? ";
				cin >> amm[3];
				cout << "\n\n" << "-> ";
				cin.ignore();
				break;
			}
			case '5':
			{
				cout << "How many? ";
				cin >> amm[4];
				cout << "\n\n" << "-> ";
				cin.ignore();
				break;
			}
			case '6':
			{
				cout << "How many? ";
				cin >> amm[5];
				cout << "\n\n" << "-> ";
				cin.ignore();
				break;
			}
			default:
			{
				cout << "Invalid entry. Please try again:" << endl
					<< "-> ";
			}
			} // End switch
	} while (ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6');

	cash(amm, price, food);
	return 0;
}