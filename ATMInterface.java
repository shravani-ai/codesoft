package TestCode;
import java.util.Scanner;
class BankAccount {
    String name;
    String username;
    String password;
    String AccountNo;
    int transactions = 0;
    float balance= 10000f;
    String transactionhistory = "";
     
    public void register() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("\n Enter your name :");
    	this.name = sc.nextLine();
    	System.out.println("\n Enter your username :");
    	this.username = sc.nextLine();
    	System.out.println("\n Enter your password :");
    	this.password = sc.nextLine();
    	System.out.println("\n Enter your Account Number :");
    	this.AccountNo = sc.nextLine();
    	System.out.println("\n Registration Sccessful.\n Please login to your Bank Account .");
    	
    	
    }
    public boolean login() {
    	boolean isLogin = false;
    	Scanner sc = new Scanner(System.in);
    	  while(!isLogin) {
    		  System.out.println("\n Enter your Username: ");
    		  String userName =  sc.nextLine();
    		  if( userName.equals(username)) {
    			  while(!isLogin) {
    				  System.out.println("\n Enter your Password");
    				  String Password = sc.nextLine();
    				  if(Password.equals(password)) {
    					  System.out.println("Login Successfully .");
    					  isLogin = true;
    				  }
    				  else {
    					  System.out.println("\n Incorrect Password :");
    				  }
    			  }
    		  }else {
    			  System.out.println("\n Username not fount !");
    		  }
    	  }
    	  return  isLogin;
    }
    public void withdraw() {
    	 System.out.println("\n Enter Amount to withdraw :");
    	 Scanner sc = new Scanner(System.in);
    	 float amount = sc.nextFloat();
    	 try {
    		 if(balance >= amount) {
    			 transactions++;
    			 balance -= amount;
    			 System.out.println("\n withdrawal Successful .");
    			 String str= amount + "Rs Withdrawn \n";
    			 transactionhistory = transactionhistory.concat(str);
    		 }
    		 else {
    			 System.out.println("\n Insufficient Balance.");
    		 }
    	 }catch(Exception e) {
    		 
    	 }
    	 
    }
    public void deposite() {
   	 System.out.println("\n Enter Amount to Deposite :");
   	 Scanner sc = new Scanner(System.in);
   	 float amount = sc.nextFloat();
   	 try {
   		 if(amount <= 10000f) {
   			 transactions ++;
   			 balance += amount;
   			 System.out.println("\n Deposited Successful .");
   			 String str= amount + "Rs Deposited \n";
   			 transactionhistory = transactionhistory.concat(str);
   		 }
   		 else {
   			 System.out.println("\n Sorry! The limit if 10000f.");
   		 }
   	 }catch(Exception e) {
   		 
   	 }
   	 
   }
    public void transfer() {
    	Scanner sc = new Scanner(System.in);
   	 System.out.println("\n Enter Receipents Name :");
   	 String receipents = sc.nextLine();
   	 System.out.println("\n Enter Amount to transfer");
   	 
   	 float amount = sc.nextFloat();
   	 try {
   		 if(balance >= amount) {
   			 if(amount <= 50000f) {
   			 transactions++;
   			 balance -= amount;
   			 System.out.println("\n Successfully Transfered to " + receipents);
   			 String str= amount + "Rs transferred to "+ receipents +"\n";
   			 transactionhistory = transactionhistory.concat(str);
   		 }
   		 else {
   			 System.out.println("\n Sorry ! The limit if 50000.");
   		 }
   		 } else {
   		     System.out.println("\n Insufficient Balance .");	  
   		 } }catch(Exception e) {
   		 }
   		 
   	 }
   	 public void checkbalance() {
   		 System.out.println("\n "+ balance +"Rs");
   	 }
    
    public void TransactionHistory() {
    	if(transactions == 0) {
    		System.out.println("\n No transaction Happen .");
    		
    	}else {
    		System.out.println("\n " + transactionhistory );
    	}
    }
    
}
public class ATMInterface {
	public static int takenIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while(!flag) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if( flag && input>limit || input<1) {
					System.out.println("Choose the number between 1 to "+limit);
					flag = false;
					
				}
			}catch(Exception e) {
				System.out.println("Enter only integer value.");
				flag = false;
			}
		}
		return input;
	}
	public static void main(String args[]) {
		System.out.println("\n **** Welcome To Indian ATM Interface **** ");
		System.out.println("\n 1. Register \n 2.Exit");
		System.out.println("Choose one Option: ");
		int choose = takenIntegerInput(2);
		
		if(choose == 1) {
			BankAccount b= new BankAccount();
			b.register();
			while(true) {
				System.out.println("\n 1.Login \n 2.Exit");
				System.out.println("Enter  your Choice: ");
				int ch = takenIntegerInput(2);
				if(ch==1) {
					if(b.login()) {
						System.out.println("\n **** Welcome Back " +b.name+ " **** ");
						boolean isFinished = true;
						while(isFinished) {
							System.out.println("\n 1.withdraw \n 2.Deposite \n 3.Transfer \n 4.Check Balance \n 5.Transaction History \n 6.Exit");
							System.out.println("Enter  your Choice: ");
							int c = takenIntegerInput(6);
							switch(c) {
							case 1:
								b.withdraw();
								break;
							case 2:
								b.deposite();
								break;
							case 3:
								b.transfer();
								break;
							case 4:
								b.checkbalance();
								break;
							case 5:
								b.TransactionHistory();
								break;
							case 6:
								isFinished = true;
								break;
								
							}
						}
					}
				}else {
					System.exit(0);
				}
			}
		}else {
			System.exit(0);
		}
		
		
	}
}
