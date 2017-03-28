
public class Myset<a>{
	
private static class node<a>{
	private a value;
	private node<a> next;
	
	
	public node(a value , node<a> next)
	{
		this.value=value;
		this.next=next;
	}
}


public node<a> head=null;
private int size=0;
private node<a> tail=null;


public int size(){
	return size;
}


//returns node at ith position
public a getnode(int i){
	node<a> temp;
	temp=head;
	for(int j=1;j<i && temp.next!=null;j++ )
	{
		temp=temp.next;
	}
	return temp.value;
}





//inserts a node @front
public void Insert(a value){
	head = new node<>(value,head);
	size++;
}




//inserts a node at last
public void addLast(a item)
{
   if( head == null)
      Insert(item);
   else
   {
      node<a> tmp = head;
      while(tmp.next != null) tmp = tmp.next;
      tmp.next = new node<a>(item, null);
      size++;
   }
  
}
public a returnlast()
{
	return getnode(size);
}





public void Delete(a value){
	if(head == null) throw new RuntimeException("can't delete");
	node<a> current =head;
	
	
	node<a> prev = null;
	while(current != null){
			prev=current;
		
		
		if(current.value == value){
			head=head.next;
		//	System.out.println("ss");
		return;
		}
		current=current.next;
	}
	if(current==null) throw new RuntimeException("can't delete");
	prev.next=current.next;
}


//returns true if Myset is empty
public Boolean isEmpty(){
	if( head==null && tail==null)
		return true;
	return false;
}



public Myset<a> union(Myset<a> b){
	node<a> temp3=b.head;
	if(this.head==null){
	while(temp3!=null)
	{
		this.addLast(temp3.value);
		temp3=temp3.next;
		//System.out.println("fgfgf");
	}
	}
	else{
	node<a> temp1=this.head;
	node<a> temp2=b.head;
	while(temp2!=null)
	{
		int x=0;
		while(temp1!=null){
			if(temp2.value==temp1.value)
				x++;
			temp1=temp1.next;
		}
		temp1=this.head;
		if(x==0){
			this.addLast(temp2.value);
		}
		temp2=temp2.next;
	}
	}
	return this;
}




public Myset<a> intersection(Myset<a> b)
{
	Myset<a> c=new Myset<>();
	node<a> temp3=b.head;
	while(temp3!=null)
	{
		c.Insert(temp3.value);
		temp3=temp3.next;
	}
	node<a> temp1=c.head;
	node<a> temp2=this.head;
	while(temp2!=null)
	{
		while(temp1!=null){
			if(temp2.value==temp1.value)
			c.Insert(temp2.value);
			temp2=temp2.next;
		}
		temp1=temp1.next;
	}
	return c;
}
}
