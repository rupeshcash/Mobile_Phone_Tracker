
public class MobilePhone {
	  private int number;
	  private Boolean Swiitch;
	 //private Exchange x =new Exchange(0);
	  
	  //constructor
	 public MobilePhone(int number){
		 this.number=number;
		 Swiitch=true;
	 }
	 
	 
	 
	 public int number(){
		 return number;
	 }
	 
	 public Boolean status(){
		 return Swiitch;
	 }
	 
	 public void switchOn(){
		 this.Swiitch = true;
	 }
	 
	 public void switchoff(){
		 this.Swiitch=false;
	 }
	 
	}
