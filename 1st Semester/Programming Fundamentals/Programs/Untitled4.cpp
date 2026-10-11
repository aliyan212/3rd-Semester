#include <iostream>

using namespace std;

int main() {
    char choice = 'y';
    int quant;
    int bill = 0;
    while (choice == 'y') {
        cout << "Press 1 for Recharge of Rs. 100" << endl;
        cout << "Press 2 for Recharge of Rs. 300" << endl;
        cout << "Press 3 for Recharge of Rs.500" << endl;
        cout << "Press 4 for Total Amount Recharged" << endl;
        cout << "Press 5 to Exit" << endl;
        int shopchoice;
        cin >> shopchoice;
        if (shopchoice == 1) {
            bill = bill + 100;
        } else if (shopchoice == 2) {
            bill = bill + 300;
        } else if (shopchoice == 3) {
            bill = bill + 500;
        } else if (shopchoice == 4) {
            cout << "Total Amount Recharged: " <<bill<< endl;
        } else if (shopchoice == 5) {
            choice='n';
        } else{
        	cout<<"Invalid choice"<<endl;
		}
    }
    return 0;
}

