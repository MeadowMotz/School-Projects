/* - Ben Motz
- 6/21/23
- Midterm Project: Wait times by popularity
- This program will produce the wait times for the rides at an amusement park based on
their popularity and how many guests are in the park .*/
#include <iostream>
#include <string>
#include <random>
#include <iomanip>
#include <cmath>
using namespace std;

int main()
{
	double popularity[7]{ 0.217, 0.082, 0.190, 0.136, 0.109, 0.028, 0.244 }; // Normalized popularities
	const string name[7] = { "The Rattleback", "The Kitten", "Groundseeker",
	"The Spirit", "Brown Water Canyon", "The Juggler", "Jupiter" };
	random_device rand;
	uniform_int_distribution<int> g(500, 5000);
	int guests(g(rand)), waitn[7];
	for (int cc = 0; cc < 7; cc++)
		waitn[cc] = ceil((guests * (popularity[cc])) / 20); // Guests at ride / Guests per ride 
	char ch;
	while (true)
	{
		cout << "Welcome to Queen's Island!\n"
			<< "Select the number of the function you wish to use:\n"
			<< "1. View Wait Times\n"
			<< "2. View # of Guests\n"
			<< "3. View Ride Popularity\n"
			<< "4. Shut Down\n"
			<< "-> ";
		cin.get(ch);
		cout << endl;
		switch (ch)
		{
		case '1': // View Wait Times
		{
			char ch2;
			cout << "Which wait time do you wish to check?\n"
				<< "Press the number of the ride you wish to check:\n"
				<< "1. " << name[0] << endl
				<< "2. " << name[1] << endl
				<< "3. " << name[2] << endl
				<< "4. " << name[3] << endl
				<< "5. " << name[4] << endl
				<< "6. " << name[5] << endl
				<< "7. " << name[6] << endl
				<< "8. All of the above\n"
				<< "-> ";
			cin.ignore();
			cin.get(ch2);
			cout << endl << endl;
			switch (ch2)
			{
			case '1':
			{
				cout << name[0] << ": ";
				if ((waitn[0] / 60) > 1)
					cout << waitn[0] / 60 << "hr ";
				if ((waitn[0] % 60) > 1)
					cout << waitn[0] % 60 << "min\n\n\n\n";

				system("pause");
				cin.ignore();
				cout << endl << endl;
				break;
			}
			case '2':
			{
				cout << name[1] << ": ";
				if ((waitn[1] / 60) > 1)
					cout << waitn[1] / 60 << "hr ";
				if ((waitn[1] % 60) > 1)
					cout << waitn[1] % 60 << "min\n\n\n\n";

				system("pause");
				cin.ignore();
				cout << endl << endl;
				break;
			}
			case '3':
			{
				cout << name[2] << ": ";
				if ((waitn[2] / 60) > 1)
					cout << waitn[2] / 60 << "hr ";
				if ((waitn[2] % 60) > 1)
					cout << waitn[2] % 60 << "min\n\n\n\n";

				system("pause");
				cin.ignore();
				cout << endl << endl;
				break;
			}
			case '4':
			{
				cout << name[3] << ": ";
				if ((waitn[3] / 60) > 1)
					cout << waitn[3] / 60 << "hr ";
				if ((waitn[3] % 60) > 1)
					cout << waitn[3] % 60 << "min\n\n\n\n";

				system("pause");
				cin.ignore();
				cout << endl << endl;
				break;
			}
			case '5':
			{
				cout << name[4] << ": ";
				if ((waitn[4] / 60) > 1)
					cout << waitn[4] / 60 << "hr ";
				if ((waitn[4] % 60) > 1)
					cout << waitn[4] % 60 << "min\n\n\n\n";

				system("pause");
				cin.ignore();
				cout << endl << endl;
				break;
			}
			case '6':
			{
				cout << name[5] << ": ";
				if ((waitn[5] / 60) > 1)
					cout << waitn[6] / 60 << "hr ";
				if ((waitn[5] % 60) > 1)
					cout << waitn[5] % 60 << "min\n\n\n\n";

				system("pause");
				cin.ignore();
				cout << endl << endl;
				break;
			}
			case '7':
			{
				cout << name[6] << ": ";
				if ((waitn[6] / 60) > 1)
					cout << waitn[6] / 60 << "hr ";
				if ((waitn[6] % 60) > 1)
					cout << waitn[6] % 60 << "min\n\n\n\n";

				system("pause");
				cin.ignore();
				cout << endl << endl;
				break;
			}
			case '8':
			{
				for (int cc = 0; cc < 7; cc++)
				{
					cout << setw(20) << left << name[cc];
					if ((waitn[cc] / 60) > 1)
						cout << waitn[cc] / 60 << "hr ";
					if ((waitn[cc] % 60) > 1)
						cout << waitn[cc] % 60 << "min";
					cout << endl << endl;
				}
				cout << endl << endl;

				system("pause");
				cin.ignore();
				cout << endl << endl;
				break;
			}
			default: // Error
			{
				cout << "Invalid entry. ";
				system("pause");
				cin.ignore();

				cout << endl << endl;
			}
			} // End nested switch
			break;
		} // End case 1
		case '2': // View # of Guests
		{
			cout << "Guest Evaluation:\n"
				<< "Guests: " << guests << endl << endl;

			system("pause");
			cin.ignore();
			cout << endl << endl;
			break;
		}
		case '3': // View Ride Popularity
		{
			for (int cc = 0; cc < 7; cc++)
			{
				cout << setw(20) << left << name[cc];
				cout << floor(popularity[cc]*370) << "%\n";
			}
			cout << endl << endl;

			system("pause");
			cin.ignore();
			cout << endl << endl;
			break;
		}
		case '4': // Shut Down
		{
			cout << "Shutting down . . . \n\n\n";
			return 0;
		}
		default: // Error
		{
			cout << "Invalid entry. ";
			system("pause");
			cin.ignore();

			cout << endl << endl;
		}
		} // End switch
	} // Closing brace for infinite repeat block
}