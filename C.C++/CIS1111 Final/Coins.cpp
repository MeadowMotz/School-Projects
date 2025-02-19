/* - Ben Motz
- 7/26/23
- Final Project: Coins Calculator for Hypixel Skyblock
- [description in project documentation] */
#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <ctime>
#include <iomanip>
using namespace std;

void avg_income(time_t&, time_t&, vector<double>&);


int main()
{
	char ch;

	time_t start_time(0), end_time(0); // Avg income variables (Accessible anytime)
	vector<double> totals;


	do
	{
		cout << "Enter the number of your choice: \n"
			<< "______________\n"
			<< "1. Income Tracker\n"
			<< "2. Shut Down\n"
			<< "______________\n"
			<< "\t -> ";
		cin.get(ch);
		cout << endl;


		if (ch == '1') // case '1':
		{
			avg_income(start_time, end_time, totals);
		}
		else
		{
			if (ch == '2') // case '2':
				break;
			else             // default: error
				cout << "\nInvalid entry. Please try again.\n\n";
		}
	} while (ch != '2');

	return 0;
}


void avg_income(time_t& start_time, time_t& end_time, vector<double>& totals)
{
	char ch_avg;
	cout << fixed << setprecision(1);
	do
	{
		cout << "Enter the letter of your choice: \n"
			<< "> Time elapsed: ";
		{
			if (start_time > 0)
			{
				time_t timer;
				time(&timer); // Take time
				int temp = difftime(timer, start_time); // Convert to # of seconds since [whatever that date was] as an int
				int hr = temp / 3600,
					min = (temp % 3600) / 60,
					s = temp % 60;

				cout << setfill('0') << right // Convert to ##:##:##
					<< setw(2) << hr << ":" << setw(2) << min << ":" << setw(2) << s << endl << setfill(' ') << left;
			}
			else
				cout << "00:00:00";
		}
		cout << "\n______________\n"
			<< "a. Start Tracking\n"
			<< "b. Stop Tracking\n"
			<< "c. Gains Entry\n"
			<< "d. Leave\n"
			<< "______________\n"
			<< "\t -> ";
		cin.ignore();
		cin.get(ch_avg);


		if (ch_avg != 'a' && ch_avg != 'b' && ch_avg != 'c' && ch_avg != 'd')
			cout << "\nInvalid Entry. Please try again.\n\n"; // INVALID CHOICE - Error

	} while (ch_avg != 'a' && ch_avg != 'b' && ch_avg != 'c' && ch_avg != 'd');

	switch (ch_avg)
	{
	case 'a': // START TRACKING
	{
		if (time(NULL) > 0)
		{
			start_time = time(NULL); // Log start time
			end_time = 0; // Reset end time
			cout << "\n[SYSTEM MSG] Start success.\n\n"
				<< "Please enter your title for this run: ";
			string title;
			cin.ignore();
			getline(cin, title);
			ofstream history("Temp Storage.txt", std::ios_base::app);
			history << "____" << title << "____\n" // Write to temporary storage
				<< setw(15) << left << "Price" << setw(30) << "Item x Amount" << "Total\n";
			cout << endl;
			history.close();
		}
		else
			cout << "[SYSTEM MSG] Start fail.\n\n"; // Start Error

		break;
	}
	case 'b': // END TRACKING
	{
		if (start_time > 0)
		{
			if (time(NULL) > 0)
			{
				end_time = time(NULL); // Log end time
				cout << "\n[SYSTEM MSG] End success.\n\n";

				// Compiling report from file to display in console
				ifstream history("Temp Storage.txt");

				// Following taken as a template from internet to read a block of data from a file and print it to console
				// ---------------------
				history.seekg(0, history.end);
				int length = history.tellg();
				history.seekg(0, history.beg);

				// allocate memory:
				char* buffer = new char[length];

				// read data as a block:
				history.read(buffer, length);

				history.close();

				// print content:
				cout.write(buffer, length);
				// ----------------------
				// End template

				// Calculating & display time elapsed in console report
				time_t timer;
				time(&timer); // Take time
				int temp = difftime(timer, start_time); // Convert to # of seconds since [whatever that date was] as an int
				int hr = temp / 3600,
					min = (temp % 3600) / 60,
					s = temp % 60;

				cout << "\nTime elapsed: ";
				cout << setfill('0') << right // Convert to ##:##:##
					<< setw(2) << hr << ":" << setw(2) << min << ":" << setw(2) << s << endl << setfill(' ') << left;

				// Total gains
				double total_gains = 0;
				for (int cc = 0; cc < totals.size(); cc++)
					total_gains += totals[cc];
				cout << "Total gains: " << total_gains << " coins\n";

				// Average gains
				double average_gains = total_gains / (static_cast<double>(temp) / 3600);
				cout << "Average gains: " << average_gains << " coins/hr\n";

				// Log report to permanent files
				{
					ofstream history("Program History.txt", std::ios_base::app);

					history.write(buffer, length);
					history << endl << "Time elapsed: " << fixed // Time elapsed in ##:##:##
						<< setfill('0') << right << setw(2) << hr << ":" << setw(2) << min << ":" << setw(2) << s << endl << setfill(' ') << left
						<< "Total gains: " << setprecision(1) << total_gains << " coins\n" // Stats
						<< "Average gains: " << setprecision(1) << average_gains << " coins/hr\n\n\n\n";
					history.close();
				}
				cout << endl;
				system("pause");
				cout << endl;


				cout << "Clearing temporary storage . . . \n";
				if (remove("Temp Storage.txt") != 0)
					cout << "File deletion failed.\n\n\n"; // Storage clear error
				else
				{
					remove("Temp Storage.txt");
					cout << "File deletion successful.\n\n\n";
				}
			} // End [if end tracking successful]
			else
				cout << "[SYSTEM MSG] End fail.\n\n\n"; // End tracking error
		}
		else
			cout << "\n[SYSTEM MSG] Error: Tracking not started\n\n"; // End tracking error - not started, cannot end
		break;
	}
	case 'c': // GAINS ENTRY
	{
		cout << "\nEnter 0 for name to exit:\n";
		double price;
		string name;
		int amount;
		do
		{
			// Entries
			cout << "Name: ";
			cin.ignore();
			getline(cin, name);
			if (name == "0") // '0' to leave entry interface
				break;

			cout << "Amount: ";
			cin >> amount;

			cout << "Price: ";
			cin >> price;
			cout << endl << endl;

			// Log to program history "coins |name x amount |total"
			double TOTAL = price * amount;
			totals.push_back(TOTAL);

			{
				ofstream history("Temp Storage.txt", std::ios_base::app);

				history << left << setw(12) << fixed << setprecision(1) << price << " | "; // Price

				string work = name + " x " + to_string(amount); // Item x amount
				history << setw(27) << work;

				history << " | " << TOTAL << endl; // Total

				history.close();
			}

		} while (name != "0");
		cout << endl;
		break;
	}
	case 'd': // LEAVE
	{
		cout << endl << endl;
		break;
	}
	} // End switch
	cin.ignore();
}