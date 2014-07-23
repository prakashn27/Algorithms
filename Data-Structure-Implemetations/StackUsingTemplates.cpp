#include <iostream>
#include <string>
#include <vector>
#include <cstdlib>
#include <stdexcept>

using namespace std;
 
template <class T>
class Stack {
    private:
    vector<T> elem;
    
    public:
    void push(T const&);
    void pop();
    T top();
};
template<class T>
T Stack<T>::top() {
    if (elem.empty()) { 
        throw out_of_range("Stack<>::top(): empty stack"); 
    }
    return elem.back();
}
template<class T>
void Stack<T>::push(T const& element) {
    elem.push_back(element);
}
template<class T>
void Stack<T>::pop(){
    if(elem.empty()) throw out_of_range("Stack<>::pop(): empty stack"); 
    elem.pop_back();
}


int main() {
    try { 
        Stack<int>         intStack;  // stack of ints 
        Stack<string> stringStack;    // stack of strings 

        // manipulate int stack 
        intStack.push(7); 
        cout << intStack.top() <<endl; 

        // manipulate string stack 
        stringStack.push("hello"); 
        stringStack.push("prakash"); 
        cout << stringStack.top() << std::endl; 
        stringStack.pop(); 
        cout << stringStack.top() << std::endl;
        stringStack.pop(); 
        stringStack.pop(); 
    } 
    catch (exception const& ex) { 
        cout  << "Exception: " << ex.what() <<endl; 

    } 
    return 0;
}
