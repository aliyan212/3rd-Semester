#include <iostream>

using namespace std;

int main() {
    char choice = 'y';
    int quant;
    int bill = 0;
    while (choice == 'y') {
    	cout<<"---- City Bookstore ----"<<endl;
        cout << "Press 1 for Novel Rs. 500" << endl;
        cout << "Press 2 for Magazine Rs. 200" << endl;
        cout << "Press 3 for Notebook Rs.100" << endl;
        cout << "Press 4 for Bill" << endl;
        cout << "Press 5 to Exit" << endl;
        int shopchoice;
        cin >> shopchoice;
        if (shopchoice == 1) {
            cout << "Enter quantity" << endl;
            cin >> quant;
            bill = bill + (quant * 500);
        } else if (shopchoice == 2) {
            cout << "Enter quantity" << endl;
            cin >> quant;
            bill = bill + (quant * 200);
        } else if (shopchoice == 3) {
            cout << "Enter quantity" << endl;
            cin >> quant;
            bill = bill + (quant * 100);
        } else if (shopchoice == 4) {
            cout << "Bill: " <<bill<< endl;
        } else if (shopchoice == 5) {
            choice='n';
        } else{
        	cout<<"Invalid choice"<<endl;
		}
    }
    return 0;
}

