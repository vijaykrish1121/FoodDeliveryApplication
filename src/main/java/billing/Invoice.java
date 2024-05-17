package billing;
import java.io.IOException;

import foodApp.foodDeliveryApp.ConstValues;
import foodApp.foodDeliveryApp.Foods;
public class Invoice extends Foods implements ConstValues {

	//      double gstAmount;
//	public void findGst(double amount) {
//	 	gstAmount=(amount/100)*18;
//	}
	public static  void calculateTotalPrice (double amount1,double quantity) {
	double amount=amount1*quantity;
		if(amount>0 && quantity>0) {
		double discountPercent=0;
		if(amount>=200 && amount<500)
		{
			discountPercent=5;
		}
		else if(amount>=500 && amount<700)
		{
		discountPercent=7;	
		}
		else if(amount>=700)
		{
			discountPercent=10;
		}
		double gstAmount=(amount/100)*gstPercent;
		double discountAmount=amount/100*discountPercent;
		double finalPrice=amount+gstAmount-discountAmount;
		System.out.println("food Price "+amount1);
		System.out.println("amount *"+quantity+"=" +amount);
		System.out.println("you got"+ discountPercent + "% Discount =" +discountAmount);
		System.out.println("gst 18% ="+gstAmount);
		System.out.println("final price ="+finalPrice);
	}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//       Scanner sc=new Scanner (System.in);
//       System.out.println("enter Amount");
//       int amount=sc.nextInt();
//       Invoice iv=new Invoice();
//       iv.calculateToalPrice(amount);
      
	}


}
