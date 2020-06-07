package org.openjfx.Calculator;


import java.util.LinkedList;
import java.util.Scanner;
import java.math.RoundingMode;
import java.security.Identity;
import java.text.DecimalFormat;
/*
import javax.swing.border.EmptyBorder;
*/
public class ArithmeticApp {

	private static DecimalFormat df5 = new DecimalFormat("#.#####");
	private static Scanner input;
	private static class item {
		char op;
		double num;
		boolean isnum;

        public void setIsnum(boolean isnum) {
            this.isnum = isnum;
        }

        public void setOp(char op) {
            this.op = op;
        }

        public void setNum(double num) {
            this.num = num;
        }
        
        public boolean getIsNum()
        {
            return isnum;
        }
        
        public char getOp() {
            return op;
        }

        public double getNum() {
            return num;
        }
	}
	public static double  getnum (String op,int index)
    {
        int digits = 1,i = index;
        int digafter = 1;
        double mynum = 0,numafter=0;
        for (i = index;i<op.length() && op.charAt(i) >= '0' && op.charAt(i) <= '9' ;i++)
        {
            if (digits!= 1)
                mynum *= 10;
            digits++;
            mynum += op.charAt(i) - '0';
        }
        if (i<op.length() && op.charAt(i) == '.')
        {
            i++;
            for (;i<op.length() && op.charAt(i) >= '0' && op.charAt(i) <= '9' ;i++)
            {
                if (digafter != 1)
                    numafter*=10;
                digafter++;
                numafter += op.charAt(i) - '0';
            }
        }
        mynum += (numafter/(Math.pow(10,digafter-1)));
        return mynum;
    }
	
    public static int  getdigits (String op,int index)
    {
        int i = index;
        for (i = index;i<op.length() && op.charAt(i) >= '0' && op.charAt(i) <= '9' ;i++)
        {
            ;
        }
        if (i<op.length() && op.charAt(i) == '.')
        {
            i++;
            for (;i<op.length() && op.charAt(i) >= '0' && op.charAt(i) <= '9' ;i++)
            {
                ;
            }
        }
        return i;
    }
    public static void calcwithout(LinkedList<item> linked, int pos,int end) 
      { int count=0;
        double c = 0;
    	for (int i=pos;(i<linked.size())&&(i<end);i++)
        {
    		  if(linked.get(i).getIsNum()==false && ((linked.get(i).getOp() == '*')||(linked.get(i).getOp() == '/'))) {
                if (linked.get(i).getOp() == '*')
                    c = linked.get(i-1).getNum() * linked.get(i+1).getNum();
                if (linked.get(i).getOp() == '/')
                    c = linked.get(i-1).getNum() / linked.get(i+1).getNum();
                linked.get(i).setIsnum(true);
                linked.get(i).setNum(c);
                linked.remove(i-1);
                count++;
                linked.remove(i);
                count++;
                i--; 
    		  }
        }
    	for (int i=pos;(i<linked.size())&&(i<end-count);i++)
        {
    		  if((linked.get(i).getIsNum()==false)&&(linked.get(i).getOp()!='(')&&(linked.get(i).getOp()!=')')) {
                if (linked.get(i).getOp() == '+')
                    c = linked.get(i-1).getNum() + linked.get(i+1).getNum();
                if (linked.get(i).getOp() == '-')
                    c = linked.get(i-1).getNum() - linked.get(i+1).getNum();
                linked.get(i).setIsnum(true);
                linked.get(i).setNum(c);
                linked.remove(i-1);
                count++;
                linked.remove(i);
                count++;
                i--;  
    		  }
        }
    }
    
    
    public static void calc(LinkedList<item> list , int pos) 
    {
    	int i=pos;
    	while (i<list.size()) {
    		
    		if (list.get(i).getIsNum()==false) {
    			if (list.get(i).getOp()=='(') {
    				calc(list, i+1);
    			}else {
    				if (list.get(i).getOp()==')') {
        				calcwithout(list, pos,i-1);
        				list.remove(pos+1);
        				list.remove(pos-1);
        				return;
    			    }
    			}
    	    }
    		i++;
    	    }
    	}  		
    
    
	    public static double startCalc(String str) {

				LinkedList<item> linked = new LinkedList<item>();
				int i;
				double num;
				char op;
				str = str.replaceAll("\\s+", "");
				for(i=0;i<str.length();i++)
				{
					item node= new item();
					if( str.charAt(i)=='*' || str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='/' || str.charAt(i)=='('|| str.charAt(i)==')')
					{
						op=str.charAt(i);
						node.setOp(op);
						node.setNum(0);
						node.setIsnum(false);
						linked.add(node);
					}
				    else if (str.charAt(i)>= '0' && str.charAt(i)<= '9')
				    {
				    	int len;
				    	num=getnum(str,i);
				    	len=getdigits(str,i);
				    	i=len-1;
				    	node.setNum(num);
				    	node.setOp('\0');
				    	node.setIsnum(true);
				    	linked.add(node);
				    }
				}
			
		        for (i=0;i<linked.size();i++)
		        {
		            if (linked.get(i).op == '-')
		            {
		                if (i==0)
		                {
		                    linked.remove(0);
		                    linked.get(0).setNum(-linked.get(0).getNum());
		                }
		                else
		                {
		                    
		                    linked.get(i+1).num = -linked.get(i+1).num;
		                    if (linked.get(i-1).getIsNum()==true)
		                    {  
		                        linked.get(i).setOp('+');
		                      
		                    }
		                    else
		                    {   if((linked.get(i+1).getIsNum()==true))
		                        linked.remove(i);
		                    }
		                }
		            }
		        }
		      
		        for (i=0;i<linked.size()-1;i++)
		        {
		        	if((linked.get(i).getIsNum()==true)&&(linked.get(i+1).getOp()=='('))
		        	{
		        		item node= new item();
		        		node.setOp('*');
						node.setNum(0);
						node.setIsnum(false);
						linked.add(i+1, node);
		        	}
		        }
			    calc(linked,0);
					calcwithout(linked,0,linked.size());
					num=linked.get(0).getNum();
					return num;
					/*
					df5.setRoundingMode(RoundingMode.DOWN);
					df5.setMinimumFractionDigits(5);
					System.out.print("The value of expression "+str+" is: "+df5.format(num));
					*/
		}
  }


