

public class Exchange {
	
	
	MobilePhoneSet a= new MobilePhoneSet();
   private int id;
   private int parent=-1;
   public ExchangeList children;
   public MobilePhoneSet mp;
   private int index;
   private Exchange p;
   
   //adds mobile to this.mp in the last
   public void addmobile(MobilePhone a){
	   mp.m.addLast(a);
   }
   
   //sets this exchange  parent of children
  /* public void setitparent()
   {
	   int i =1;
	   while(this.children.e.isEmpty()==false && i<=children.e.size())
	   {
		 
		
		   this.children.e.getnode(i).parent=this;
		   //System.out.println("rupee");
		   i++;
	   }
   }*/
   public void setparent(int yy)
   {
	   
	   this.parent= yy;
   
   }
   //main constructor
   public Exchange(int number){
	   id=number;
	   p = this;
       children = new ExchangeList();
       mp=new MobilePhoneSet();
       index = -1;
   }

   
   
   //returns parent
   public Exchange parent(){
	   Exchange rrr= new Exchange(parent);
	   return rrr;
   }
  
   //returns id
   public int idreturn()
   {
	   return id;
   }
   
   //returns number of children
   public int numChildren(){
	   return children.e.size();
   }
   
   //returns ith child of this
   public Exchange child(int i){
	   return children.e.getnode(i);
   }
  

   public Boolean isRoot(){
	   return parent==-1;
   }
   
   public void setid(int x)
   {id=x;}
   //tree with this as node
   public RoutingMapTree subtree(int i) throws Exception
   {
	   try
	   {
		   RoutingMapTree sub = new RoutingMapTree();
		   sub.root=this.child(i);
		   return sub;
	   }
	   catch(Exception en){
		   throw new Exception("error in subtree");
	   }
   }
   
   //sets value of p back to this
   public void setp()
   {
	   p = this;
	   a=new MobilePhoneSet();
   }

   
   //resident set
   public MobilePhoneSet residentSet(){
	   Exchange temp;
	   temp=p;
	 
		{if(temp.numChildren()==0){
			
			for(int m =1 ;m<=temp.mp.m.size(); m++)
			{
							if(!this.a.contains(temp.mp.m.getnode(m).number()) && temp.mp.m.getnode(m).status()==true)
					
					this.a.m.addLast(temp.mp.m.getnode(m));
				}
		}
		else
		{
					for(int i=1;i<= temp.numChildren();i++)
		{
			p=temp.child(i);
			residentSet();
			}
		}}
		return a;
		}  
}
