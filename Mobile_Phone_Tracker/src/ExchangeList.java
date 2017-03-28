
public class ExchangeList {
	Myset<Exchange> e = new Myset<Exchange>();
	public void print(){
		if(!e.isEmpty())
			try{
		for(int i=1;i<=e.size();i++){
			System.out.print(e.getnode(i).idreturn()+"  ");
		}
		System.out.print("\n");}
		catch(Exception e){}
		else
		{
			System.out.println("list empty");
		}
		}
		
	}
