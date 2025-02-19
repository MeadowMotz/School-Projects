/* - Ben Motz
- 6/28/23
- Functions: Excercise 1
- : For this assignment, you will be building a calculator program. Your program 
must allow the user to enter two numbers. Next, allow them to choose a mathematical 
function from a menu to be performed on the two numbers. Perform the calculation in 
a function and display the result to the user*/
#include <iostream>
#include <string>
using namespace std;

void add(int num1, int num2, string op)
{
	cout << "The " << op << " of your two numbers is: " << num1 + num2;
	return;
}

void subtract(int num1, int num2, string op)
{
	cout << "The " << op << " of your two numbers is: " << num1 - num2;
	return;
}

void multiply(int num1, int num2, string op)
{
	cout << "The " << op << " of your two numbers is: " << num1 * num2;
	return;
}

void divide(int num1, int num2, string op)
{
	if (num2 != 0)
		cout << "The " << op << " of your two numbers is: " << num1 / num2;
	else
		cout << "Cannot divide by zero. Please restart the program and try again.";
	return;
}

int main()
{
	int num1, num2;
	char ch;
	cout << "Please enter a number: ";
	cin >> num1;
	cout << "\nPlease enter a second number: ";
	cin >> num2;
	cout << endl
		<< "1. Add\n"
		<< "2. Subtract\n"
		<< "3. Multiply\n"
		<< "4. Divide\n\n"
		<< "Please enter the number of the function you wish to perform: ";
	cin.ignore();
	cin.get(ch);
	string op = ch == '1' ? "sum" :
				(ch == '2' ? "difference" :
				(ch == '3' ? "product" :
				(ch == '4' ? "quotient" : "ERROR")));
	cout << endl;
	switch (ch)
	{
	case '1':
	{
		add(num1, num2, op);
		break;
	}
	case '2':
	{
		subtract(num1, num2, op);
		break;
	}
	case '3':
	{
		multiply(num1, num2, op);
		break;
	}
	case '4':
	{
		divide(num1, num2, op);
		break;
	}
	default:
	{
		cout << "Invalid entry. Please restart the program and try again.";
		break;
	}
	} // End switch
	cout << "\n\n\n";
	return 0;
}