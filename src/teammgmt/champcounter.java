package teammgmt;

public class champcounter {
int counter = 0;


public void plus(){
	counter = counter + 1;
}


public void minus (){
	counter--;
}

public int getcounter(){
	
	final int ting = counter;
	return ting;
}


}
