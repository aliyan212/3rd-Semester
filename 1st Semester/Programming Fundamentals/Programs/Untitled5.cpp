#include <iostream>
using namespace std;

int main()
{
    char choice = 'y';
    int bill = 0;
    for (int i = 1; i <= 5; i++) {
    	cout<<"------ Cinema Booking ------"<<endl;
        cout << "Press 1 for Silver Ticket Rs.400" << endl;
        cout << "Press 2 for Gold Ticket Rs.700" << endl;
        cout << "Press 3 for Platinum Ticket Rs.1000" << endl;
        cout << "Press 4 for Checkout" << endl;
        cout << "Press 5 to end" << endl;
        int shopChoice;
        cin >> shopChoice;
        if (shopChoice == 1){
            bill = bill + 400;
        } else if (shopChoice == 2){
            bill = bill + 700;
        } else if (shopChoice == 3){
            bill = bill + 1000;
        } else if (shopChoice == 4){
            cout << "Bill: " << bill << endl;
            i--;
        } else if (shopChoice == 5){
            break;
        }else{
            cout << "Invalid" << endl;
            i--;
        }  
}
cout<<"Total bill: "<<bill<<endl;
return 0;
}
