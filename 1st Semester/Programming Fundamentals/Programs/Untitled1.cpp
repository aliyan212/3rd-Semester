#include<iostream>
using namespace std;
int main(){
	int arr[10];
	int pos=0;
	int neg=0;
	for(int i=0;i<10;i++){
		cout<<"Enter number "<<i+1<<endl;
		cin>>arr[i];
		if(arr[i]>=0){
			pos++;
		} else{
			neg=neg+1;
		}
	}
	int posArray[pos];
	int negArray[pos];
	int pt=0;
	int ng=0;
	for(int i=0;i<10;i++){
		if(arr[i]>=0){
			posArray[pt]=arr[i];
			pt++;
		} else{
			negArray[ng]=arr[i];
			ng++;
		}
	}
	cout<<"Do you want to see positive numbers or negative numbers?"<<endl;
	int choice;
	cin>>choice;
	if(choice==1){
		for(int i=0; i<pos;i++){
		cout<<posArray[i]<<endl;
	}
	} else if(choice==2){
		for(int i=0; i<neg;i++){
		cout<<negArray[i]<<endl;
	}
	}
	
	return 0;
}
