

public class MobilePhoneSet {
	Myset<MobilePhone> m = new Myset<MobilePhone>();

	
	//returns true if the mobilephone with constructor is in set or not 
	public boolean contains(int y)
	{
		
		if (m.isEmpty())
		return false;
		
	   for(int i=1;i<=m.size();i++)
	   {
	      if(m.getnode(i).number()==y) return true;
	      
	   }
	   return false;
	}

	//returns the mobilephone if the mobilephone with constructor is in set or not 
	public MobilePhone retmobile(int x)
	{
		 for(int i=1;i<=m.size();i++)
		   {
		      if(m.getnode(i).number() == x) return m.getnode(i);
		   }
		 throw new IllegalArgumentException("not found");
		    	  
	}

	//prints the list
	public void print(){
		if(!m.isEmpty())
		{for(int i=1;i<=m.size();i++){
			System.out.print(m.getnode(i).number()+"  ");
		}
		System.out.print("\n");
		}
		else
			System.out.println("empty");
	}
	
}
