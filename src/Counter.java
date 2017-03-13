public class Counter {

	int counter = 6;
	int usercounter = 86;
	public void plus() {
		if (counter == 6) {

		} else {
			counter++;
			usercounter++;
		}
	}

	public void minus() {
		if (counter == -80) {

		}

		else {
			counter = counter - 1;
			usercounter = usercounter -1;
		}
	}

	public int getcounter() {
		return counter;
	}
	
	public int getusercounter(){
		return usercounter;
	}
	
	public void setcounter(int i){
		if(i <= 6 && i >= -80){
			counter = i;
			usercounter = (80 + i);
			
		}
		
	}
}