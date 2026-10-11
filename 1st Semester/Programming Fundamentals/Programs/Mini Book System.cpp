#include<iostream>
using namespace std;
int totalIssued(int books[3][3]) {
	int issued=0;;
	for(int i=0;i<3;i++){
		issued=issued+books[i][2];
		}
	return issued;
	}
void issueBook(int books[3][3], int id){
		for(int i=0;i<3;i++){
			if(id==books[i][0]){
				if(books[i][1]>0){
					books[i][2]=books[i][2]+1;
					books[i][1]=books[i][1]-1;
				}
				else{
					cout<<"Not Enough"<<endl;
				}	
			}
		}
	}
void printArr(int books[3][3]){
	cout<<"ID";
	cout<<"\t     Available";
	cout<<"\t     Issued"<<endl;
	for(int i=0;i<3;i++){
	for(int j=0; j<3;j++){
            cout<<books[i][j]<<"\t\t";
			}
        cout<<endl;
		}
	}
int main(){
	int books[3][3]={
	{2445,10,0},
	{2446,10,0},
	{2447,10,0}
	};
	int fines[3] = {0, 0, 0};
	issueBook(books, 2445);
	printArr(books);
	int total=totalIssued(books);
	cout<<"Total Books Issued: "<<total;
}
