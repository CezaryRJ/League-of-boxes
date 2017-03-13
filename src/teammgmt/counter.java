package teammgmt;

public class counter {
int counter = -1;

public void plus(){
	counter++;
}
public void minus(){
	counter--;
}

public int getcounter(){
	return counter;
}
public void reset(){
	counter = 0;
}

public void setcounter(int a){
	counter = a;
	
}
}
