#include<iostream>
using namespace std;
double average(int arr[2][7]){
	int sum=0;
	for(int i=0; i<2;i++){
		for(int j=0; j<7;j++){
			sum=sum+arr[i][j];
		}
	}
	double ave=sum/14;
	return ave;
}
int main(){
	int tempWeek[7];
	int detailedTemp[2][7];
	int cold=0;
	int hot=0;
	for(int i=0; i<7;i++){
		cout<<"Enter temprature for day "<<i+1<<endl;
		cin>>tempWeek[i];
	}
	for(int i=0; i<7;i++){
		if(tempWeek[i]<15){
			cold=cold+1;
		} else if(tempWeek[i]>30){
			hot=hot+1;
		}
	}
	for(int i=0; i<2;i++){
		if(i==0){
			cout<<"Enter the Morning tempratures"<<endl;
		} else{
			cout<<"Enter the Evening tempratures"<<endl;
		}
		for(int j=0; j<7;j++){
			cout<<"Enter temprature for day "<<j+1<<endl;
			cin>>detailedTemp[i][j];
		}
	}
	int hottest=tempWeek[0];
	int coldest=tempWeek[0];
	double aveTemp=average(detailedTemp);
	for(int i=0; i<7;i++){
		if(tempWeek[i]>hottest){
			hottest=tempWeek[i];
		}
	}
	for(int i=0; i<7;i++){
		if(tempWeek[i]<coldest){
			coldest=tempWeek[i];
		}
	}
	cout<<"Hottest Day: "<<hottest<<endl;
	cout<<"Coldest Day: "<<coldest<<endl;
	cout<<"Average :"<<aveTemp;
}
