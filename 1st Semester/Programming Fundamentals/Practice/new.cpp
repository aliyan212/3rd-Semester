#include<iostream>
#include<string>
using namespace std;
struct Student{
    string name;
    int id;
};
void checkShortage(Student students[5], int attendance[5][7]){
    for(int i=0; i<5;i++){
        int totAttend=0;
        for(int j=0;j<7;j++){
            totAttend=totAttend+attendance[i][j];
        }
        if(totAttend<5){
            cout<<"Student: "<<students[i].name<<endl;
            cout<<"Shortage of Attendance"<<endl;
        }
    }
}