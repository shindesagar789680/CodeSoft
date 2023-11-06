/*
TASK 4
ATM INTERFACE

1.Create a class to represent the ATM machine.

2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
checking the balance.

3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
checkBalance().

4. Create a class to represent the user's bank account, which stores the account balance.

5. Connect the ATM class with the user's bank account class to access and modify the account
balance.

6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).

7. Display appropriate messages to the user based on their chosen options and the success or failure
of their transactions.


*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class ATM extends JFrame {
	
	int balance = 2000;
	String[] inputSequence = new String[4];
	String[] transactionHist = new String[100];
	int inputSequenceIndex = 0;
	int transactionIndex = 0;
	boolean readyToEnter = false;
	
	public ATM(){
		super("ATM");
		for(int i =0; i <= 3; i++){
			inputSequence[i] = "";
		}
		setResizable(false);
		setLocationRelativeTo(null);
		buildApp();
		pack();
		setSize(600, 350);
		setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	protected void buildApp(){
		
		JLabel displayArea = new JLabel("<html>WELCOME TO THE ATM: <br> Please select a function from the buttons below  </html>");
		displayArea.setOpaque(true);
		displayArea.setBackground(Color.white);
		displayArea.setPreferredSize(new Dimension(100, 100));
		JPanel bottomArea = new JPanel();
		bottomArea.setLayout(new BorderLayout(0,0));
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout(0,0));
		JLabel inputDisplay = new JLabel("Input Area:");
		inputDisplay.setBorder(BorderFactory.createLineBorder(Color.black));
		bottomArea.add(inputDisplay, BorderLayout.NORTH);
		
	
		GridBagLayout buttonGrid = new GridBagLayout();
		buttonPanel.setLayout(buttonGrid);
		GridBagConstraints bPConst = new GridBagConstraints();
	
	
		bPConst.weightx= 0.1;
		bPConst.weighty= 0.1;
		
		JButton withDraw1 = new JButton("Withdraw \u00A3500");
		bPConst.gridx = 0;
		bPConst.gridy = 0;	
		bPConst.insets = new Insets(0, 0, 5, 5);
		withDraw1.setSize(new Dimension(200, 30));
		buttonPanel.add(withDraw1, bPConst);
		
		JButton deposit = new JButton("Deposit \u00A3");
		bPConst.gridx = 0;
		bPConst.gridy = 1;
		deposit.setSize(new Dimension(200, 30));
		buttonPanel.add(deposit, bPConst);
		
		JButton withDraw2 = new JButton("Check Bal \u00A3");
		bPConst.gridx = 0;
		bPConst.gridy = 2;
		withDraw2.setSize(new Dimension(200, 30));
		buttonPanel.add(withDraw2, bPConst);
		
		JButton quit = new JButton("Quit");
		bPConst.gridx = 0;
		bPConst.gridy = 3;
		bPConst.anchor = GridBagConstraints.PAGE_END;
		quit.setSize(new Dimension(200, 30));
		buttonPanel.add(quit, bPConst);
		
		JButton number1 = new JButton("1");
		bPConst.gridx = 1;
		bPConst.gridy = 0;
		number1.setSize(new Dimension(200, 30));
		buttonPanel.add(number1, bPConst);
		
		JButton number2 = new JButton("2");
		bPConst.gridx = 2;
		bPConst.gridy = 0;
		number2.setSize(new Dimension(200, 30));
		buttonPanel.add(number2, bPConst);
		
		JButton number3 = new JButton("3");
		bPConst.gridx = 3;
		bPConst.gridy = 0;
		number3.setSize(new Dimension(200, 30));
		buttonPanel.add(number3, bPConst);
		
		JButton number4 = new JButton("4");
		bPConst.gridx = 1;
		bPConst.gridy = 1;
		number4.setSize(new Dimension(200, 30));
		buttonPanel.add(number4, bPConst);
		
		JButton number5 = new JButton("5");
		bPConst.gridx = 2;
		bPConst.gridy = 1;
		number5.setSize(new Dimension(200, 30));
		buttonPanel.add(number5, bPConst);
		
		JButton number6 = new JButton("6");
		bPConst.gridx = 3;
		bPConst.gridy = 1;
		number6.setSize(new Dimension(200, 30));
		buttonPanel.add(number6, bPConst);
		
		JButton number7 = new JButton("7");
		bPConst.gridx = 1;
		bPConst.gridy = 2;
		number7.setSize(new Dimension(200, 30));
		buttonPanel.add(number7, bPConst);
		
		JButton number8 = new JButton("8");
		bPConst.gridx = 2;
		bPConst.gridy = 2;
		number8.setSize(new Dimension(200, 30));
		buttonPanel.add(number8, bPConst);
		
		JButton number9 = new JButton("9");
		bPConst.gridx = 3;
		bPConst.gridy = 2;
		number9.setSize(new Dimension(200, 30));
		buttonPanel.add(number9, bPConst);
		JButton number0 = new JButton("0");
		bPConst.gridx = 1;
		bPConst.gridy = 3;
		number0.setSize(new Dimension(200, 30));
		buttonPanel.add(number0, bPConst);
		
		JButton clear = new JButton("Clear");
		bPConst.gridx = 2;
		bPConst.gridy = 3;
		clear.setSize(new Dimension(200, 30));
		buttonPanel.add(clear, bPConst);
		
		JButton enter = new JButton("Enter");
		bPConst.gridx = 3;
		bPConst.gridy = 3;
		enter.setSize(new Dimension(200, 30));
		
		buttonPanel.add(enter, bPConst);
		bottomArea.add(buttonPanel, BorderLayout.CENTER);
		add(displayArea,  BorderLayout.NORTH);
		add(bottomArea, BorderLayout.CENTER);
		
	
		withDraw2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				displayArea.setText("<html> Current Balance: \u00A3" + balance + "</html>");
				}
		});
		
		
		
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Your Receipt: \n" + printReceipt());
			 dispose();
			}	
		});
		
		
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Input Display: ");
				displayArea.setText("<html>Input Area Cleared! <br><br>" 
				+ finishedTransaction() +"</html>");
				clearInput();
				readyToEnter = false;
			}	
		});
		
		number1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Input Display: " + updateInput("1"));
			}	
		});
		
		number2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Input Display: " + updateInput("2"));
			}	
		});
		
		number3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Input Display: " + updateInput("3"));
			}	
		});
		
		number4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Input Display: " + updateInput("4"));
			}	
		});
		
		number5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Input Display: " + updateInput("5"));
			}	
		});
		number6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Input Display: " + updateInput("6"));
			}	
		});
		
		number7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Input Display: " + updateInput("7"));
			}	
		});
		
		number8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Input Display: " + updateInput("8"));
			}	
		});
		
		number9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Input Display: " + updateInput("9"));
			}	
		});
		
		number0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				inputDisplay.setText("Input Display: " + updateInput("0"));
			}	
		});
		
		withDraw1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				if(balance >= 500){
					balance = balance - 500;
					displayArea.setText("<html>\u00A3500 Withrawn! <br><br>" + finishedTransaction() + "</html>");
					readyToEnter = false;
					System.out.println("User Has Withdrawn \u00A3500");
					updateTransactionHist("User Has Withdrawn \u00A3500");
				} else {
					displayArea.setText("<html> Your Balance is below \u00A3500. Unable to Withdraw!! <br><br>" 
					+ finishedTransaction() + "</html>");
				}
			}	
		});
		
		
		
		deposit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
					displayArea.setText("<html> Deposit Selected! <br> Please input an amout and click enter! <br><br>" 
					+ finishedTransaction() + "</html>" );
					readyToEnter = true;
					
			}	
		});
		
		
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				
				   updateBalance(Integer.parseInt(getInputSequence()));
				   displayArea.setText("<html> You have deposited \u00A3" + getInputSequence() 
					 	+ "! <br><br>" + finishedTransaction() + "</html>");
						System.out.println("User Has Deposited \u00A3" + getInputSequence());
						updateTransactionHist("User Has Deposited \u00A3" + getInputSequence());
						clearInput();
						inputDisplay.setText("Input Display: ");
			}
			
		});	
	}
	
	 void clearInput(){
		for(int i =0; i <= 3; i++){
			inputSequence[i] = "";	
		 }
		 inputSequenceIndex = 0;
	 }

	 String updateInput(String n){
		if(inputSequenceIndex <= 3){
			inputSequence[inputSequenceIndex] = n;
			inputSequenceIndex++;
		
			StringBuilder strBuilder = new StringBuilder();
			for (int i = 0; i < inputSequence.length; i++) {
				strBuilder.append(inputSequence[i]);
			}
			String newString = strBuilder.toString();
			return newString;
		} else{
			StringBuilder strBuilder = new StringBuilder();
			for (int i = 0; i <= 3; i++) {
				strBuilder.append(inputSequence[i]);
			}
			String newString = strBuilder.toString();
			return newString;
		}
	 }
	 

	
	 String getInputSequence(){
		StringBuilder strBuilder = new StringBuilder();
		if(inputSequence[0] == ""){
			return "0000";
		} else {
			for (int i = 0; i < inputSequence.length; i++) {
				strBuilder.append(inputSequence[i]);
			}
			String newString = strBuilder.toString();
			return newString;
		}
	 }

	 void updateBalance(int l){
		balance += l;
	 }
	
	   void updateTransactionHist(String t){
		 transactionHist[transactionIndex] = t;
		 transactionIndex++;
	 }
	
	 String printReceipt(){
		if(inputSequence[0].equals(null)){
			return "No Transactions Made!";
		} else{
			StringBuilder strBuilder = new StringBuilder();
			for (int i = 0; i < transactionIndex; i++) {
				strBuilder.append(transactionHist[i] + "\n");
			}
			String newString = strBuilder.toString();
			return newString;
		}
	 }
	}
class Task04{
	public static void main (String[] args){
		new ATM();	
	}
}
