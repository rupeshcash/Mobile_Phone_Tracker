
public class RoutingMapTree {
	Exchange root;
	private Exchange node;
	private Exchange node1;
	private int x=0;
	private int xx;
	private Exchange node2;
	
	public  RoutingMapTree()
	{
		root = new Exchange(0);
		node1 = root;
		node2 = root;
	}
	
	public Exchange lowestRouter(Exchange a, Exchange b)
	{
		try{
		if(givenode(givenode(a).parent()).idreturn()!=givenode(givenode(b).parent()).idreturn())
		{
			
		//	System.out.println(givenode(a).idreturn() +"  "+givenode(b).idreturn());
			
			return lowestRouter(givenode(a).parent(),givenode(b).parent());
			
		}
		else
		{
			return givenode(givenode(a).parent());
		}
		
	}
		catch(Exception e){}
		return null;
		
		//lowestRouter(givenode(a).parent,givenode(b).parent)
		}
	
	
	
	public Exchange findPhone(MobilePhone aa)
	{
		setnode2();
		xx =-1;
		findPhone1(aa);
		try{
		Exchange i=new Exchange(xx);
		if(xx!= -1)
		return i;
		
		}
		
		catch(Exception e){
			System.out.print(" phone not present in the system");
		}
		
		return null;
	}
	public void findPhone1(MobilePhone m)
	{
		Exchange temp;
		temp = node2;	
		for(int i=1;i<= temp.numChildren();	i++)
		{
			
			
			node2=temp.child(i);
			
			if(node2.numChildren()==0)
			{
				
				if(node2.mp.contains(m.number()))
				{
					xx = node2.idreturn();
					break;
				
					
				}
				
			}
			
				findPhone1(m);
				//System.out.println(node2.idreturn());
		}		
	}
	
	//adds exchange with identifier b into child list of a
	public void addExchange(int a,int b) throws Exception
	{
		   Exchange dee = new Exchange(a);
		   Exchange e2 = new Exchange (b);
		   givenode(dee).children.e.addLast(e2);
		   givenode(e2).setparent(a);
		 // System.out.println(givenode(e2).parent().idreturn());
	}
	
	
	//returns the node in the tree with the identifier same as "a"
	public Exchange givenode(Exchange a) throws Exception{
		Exchange node =root ;
		Exchange temp=null;
		if(node.idreturn()==a.idreturn()) return node;
		
		if(node.numChildren()!=0){
			for(int i=1;i<=node.numChildren();i++)
			{
				if(node.child(i).idreturn()==a.idreturn()) return node.child(i);
				temp=node.child(i);
				for(int k=1;k<=temp.numChildren();k++){
					Exchange d = temp.subtree(k).givenode(a);
					if(d!=null) return d;
					}
			}
		}
	return null;
	}
	public void setnode2()
	{
		node2 = root;
	}
	//tells if node with identifier of a is present in the tree or not
	public boolean containnode(Exchange a)
	{
		Exchange temp = new Exchange(0);
		temp = node;	
		for(int i=1;i<= temp.numChildren();i++)
		{
			//System.out.println(temp.child(1).idreturn());
			if(a.idreturn()  == temp.child(i).idreturn() || a.idreturn() == temp.idreturn() )
			return true;
			node=temp.child(i);
			
			containnode(temp.child(i));
			
		}
		return false;
		
	}
	
	
	public void movePhone(MobilePhone mm, Exchange b) throws Exception
	{
		
		Exchange rrr = findPhone(mm);
		
		MobilePhone s = givenode(rrr).mp.retmobile(mm.number());
		if(s.status()==true)
		{
			givenode(b).mp.m.addLast(s);
			
			givenode(rrr).mp.m.Delete(s);
			
		}
		
	}
	
	
	public ExchangeList routeCall(MobilePhone a, MobilePhone b)
	{
		
		ExchangeList el = new ExchangeList();
		try{
			Exchange l1 = findPhone(a);
			
		Exchange l2 = findPhone(b);
		
		Exchange l3 = l1;
		Exchange c =  lowestRouter(l1,l2);
		
		while(givenode(l3)!= c)
		{
		
			el.e.addLast(l3);
			l3= givenode(l3).parent();
		
		}
		el.e.addLast(l3);
		Exchange l4 = l2;
		ExchangeList tt=new ExchangeList();
	
			while(givenode(l4)!= c)
			{
			//	System.out.println(l4.idreturn());
			tt.e.addLast(l4);
			l4=givenode(l4).parent();
	}
			for(int i=0;i<tt.e.size();i++)
			{
				int ff = tt.e.size();
				el.e.addLast(tt.e.getnode(ff-i));
			}
		}
		catch(Exception e){}
		return el;
		
	}
	
	
	
	public void queryNthChild(Exchange a,int b) throws Exception{
		if(b<= givenode(a).numChildren())
		{System.out.println(givenode(a).child(b+1).idreturn());}
		else
			System.out.println("no such child is present");
		
	
	}
	
	
	
	
	public void queryMobilePhoneSet(Exchange b) throws Exception{
		
		givenode(b).setp();
		
		givenode(b).residentSet().print();
	
		
	}
	
	
	
	public void SwitchOff(MobilePhone f) throws Exception
	{
		if(findPhone(f)!= null && givenode(findPhone(f)).mp.contains(f.number()) == true)
		givenode(findPhone(f)).mp.retmobile(f.number()).switchoff();
		else
			System.out.println("phone not available");
	}
	
	
	
    public void switchOn(MobilePhone a, Exchange b) throws Exception{
    	
    	if(givenode(b).mp.contains(a.number()) )
    		{
    			givenode(b).mp.retmobile(a.number()).switchOn();
    		}
    		else
    		{
    			givenode(b).addmobile(a);
    			
    		}
    }
    
    
    
	public void performAction(String b ) throws Exception
	{
		String r[]=b.split("\\W+");
		if(r[0].equals("addExchange"))
		{
			Exchange rer = new Exchange(Integer.parseInt(r[1]));
			if(givenode( rer)!=null)
			addExchange(Integer.parseInt(r[1]),Integer.parseInt(r[2]));
			else
			System.out.println("error");
			
		}
		if(r[0].equals("switchOnMobile"))
		{
	
			MobilePhone aaa = new MobilePhone(Integer.parseInt(r[1]));
			Exchange a1= new Exchange(Integer.parseInt(r[2]));
			
			if(givenode(a1)!= null)
				switchOn(aaa,a1);
			else
				System.out.println("no such exchange node present");
			
		}
		if(r[0].equals("switchOffMobile"))
		{
			MobilePhone a = new MobilePhone(Integer.parseInt(r[1]));
			
			SwitchOff(a);
			
			//System.out.println("no such exchange node present");
		//	System.out.print(givenode(findPhone(a)).mp.retmobile(a.number()).status());
		}
		if(r[0].equals("queryNthChild"))
				{
			if(Integer.parseInt(r[2])>=0)
			{
			Exchange a1= new Exchange(Integer.parseInt(r[1]));
			if(givenode(a1).numChildren()!=0)
			queryNthChild(a1,Integer.parseInt(r[2]));
			else
				System.out.println("error");
			}
				}
		if(r[0].equals("queryMobilePhoneSet"))
		{
			
			Exchange a1= new Exchange(Integer.parseInt(r[1]));
			
		try{
			queryMobilePhoneSet(a1);
		}
		catch (Exception e){
			System.out.println("no such exchange node present");
		}
		}
		if(r[0].equals("findPhone"))
		{
			//System.out.println("k");
			
			MobilePhone a1= new MobilePhone(Integer.parseInt(r[1]));
			
			if(findPhone(a1)!=null)
				{
			System.out.println(this.findPhone(a1).idreturn());
		}
			else
				System.out.println("not in the network system");
			}
		if(r[0].equals("queryLowestRouter"))
		{
			Exchange vv=new Exchange(Integer.parseInt(r[1]));
			Exchange bb=new Exchange(Integer.parseInt(r[2]));
			if(givenode(vv)!= null && givenode(bb)!=null)
			{if(givenode(vv).numChildren()==0 && givenode(bb).numChildren()==0)
			{
				
			if(vv.idreturn()==bb.idreturn())
			System.out.println(vv.idreturn());
			
			if(lowestRouter(vv,bb)!=null && vv.idreturn()!=bb.idreturn())
			System.out.println(lowestRouter(vv,bb).idreturn());
			
			
			}
			else
			{
				System.out.println(" error :  input stations are not '0' level station");
			}}
			else
				System.out.println(" error :  input stations are not present in the system");
		}
		if(r[0].equals("findCallPath"))
		{
			//System.out.println("");
			MobilePhone x1= new MobilePhone(Integer.parseInt(r[1]));
			MobilePhone bv1= new MobilePhone(Integer.parseInt(r[2]));
			
				
			
			//findPhone(bv1);
			if( findPhone(x1)!=null  &&  findPhone(bv1)!=null)
			{
			if(givenode(findPhone(bv1)).mp.retmobile(bv1.number()).status()==false)
					System.out.println("the number you are trying to call is switched off");
			else
			 routeCall(x1, bv1).print();
			}
			else
				System.out.println("input phone(s) dont exist");
	}
		if(r[0].equals("movePhone"))
		{
			MobilePhone qq = new MobilePhone(Integer.parseInt(r[1]));
			Exchange ww = new Exchange (Integer.parseInt(r[2]));
			try{
			movePhone(qq,ww);
			}
			catch(Exception E){
				System.out.println("erroneous input");
				//givenode(ww).mp.print();
			}
		}
		}

}
