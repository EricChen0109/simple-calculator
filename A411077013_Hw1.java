package test;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class A411077013_Hw1 extends JFrame {
	JPanel upPan = new JPanel();
	JPanel downPan = new JPanel();
	JTextField tfDisplay = new JTextField();
	JButton btnReset = new JButton("Reset");
	JButton btn0 = new JButton("0");
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	JButton btn4 = new JButton("4");
	JButton btn5 = new JButton("5");
	JButton btn6 = new JButton("6");
	JButton btn7 = new JButton("7");
	JButton btn8 = new JButton("8");
	JButton btn9 = new JButton("9");
	JButton btnPlus = new JButton("+");
	JButton btnMinus = new JButton("-");
	JButton btnMultiply = new JButton("*");
	JButton btnDivide = new JButton("/");
	JButton btnPoint = new JButton(".");
	JButton btnEqual = new JButton("=");
	//String num1 = "";
	//String num2 = "";
	double receive ;//接收第一個數字
	double answer ;//儲存當前答案
	boolean isFirst = true;
	boolean pointAdded = false;//判斷是否輸入運算子
	int operation = -1;
	int erro = 0;//檢查有沒有除以0
	

	A411077013_Hw1() {
		setLayout(new BorderLayout());
		upPan.setLayout(new GridLayout(2, 1));
		upPan.add(tfDisplay);
		upPan.add(btnReset);
		add(upPan, BorderLayout.NORTH);

		downPan.setLayout(new GridLayout(4, 4));
		downPan.add(btn1);
		downPan.add(btn2);
		downPan.add(btn3);
		downPan.add(btnPlus);

		downPan.add(btn4);
		downPan.add(btn5);
		downPan.add(btn6);
		downPan.add(btnMinus);

		downPan.add(btn7);
		downPan.add(btn8);
		downPan.add(btn9);
		downPan.add(btnMultiply);

		downPan.add(btn0);
		downPan.add(btnPoint);
		downPan.add(btnDivide);
		downPan.add(btnEqual);
		add(downPan, BorderLayout.CENTER);

		Lis lis = new Lis();
		btn1.addActionListener(lis);
		btn2.addActionListener(lis);
		btn3.addActionListener(lis);
		btn4.addActionListener(lis);
		btn5.addActionListener(lis);
		btn6.addActionListener(lis);
		btn7.addActionListener(lis);
		btn8.addActionListener(lis);
		btn9.addActionListener(lis);
		btn0.addActionListener(lis);
		btnPoint.addActionListener(lis);
		btnPlus.addActionListener(lis);
		btnMinus.addActionListener(lis);
		btnMultiply.addActionListener(lis);
		btnDivide.addActionListener(lis);
		btnEqual.addActionListener(lis);
		btnReset.addActionListener(lis);

	}

    //Inner class
	class Lis implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JButton press = (JButton) arg0.getSource();
			if(press==btn0||press==btn1||press==btn2||press==btn3||press==btn4||
					press==btn5||press==btn6||press==btn7||press==btn8||press==btn9||press== btnPoint) {
				if(pointAdded == false) {
					tfDisplay.setText("");//清空之前輸入的東西，在第一次輸入後都維持true，所以能接收一個多位數，按下運算子後清空
					pointAdded = true;
				}
				output(press);//顯示在表格中
			}
			else if(press == btnPlus) {//+
				operation = 1;
				pointAdded = false;
				receive = Double.parseDouble(tfDisplay.getText());
				answer = receive + answer;
			}
			else if (press == btnMinus) {//-
				operation = 2;
				pointAdded = false;
				receive = Double.parseDouble(tfDisplay.getText());
				answer = receive - answer;
			} 
			else if (press == btnMultiply) {//*
				operation = 3;
				pointAdded = false;
				receive = Double.parseDouble(tfDisplay.getText());
				answer = receive * answer;
			}
			else if (press == btnDivide) {//除
				operation = 4;
				pointAdded = false;
				receive = Double.parseDouble(tfDisplay.getText());
				if(answer!=0) {
					answer = receive / answer;
					answer = Math.round(answer*100.0)/100.0;//只顯示到小數點後兩位
				}
				
				
				
			} 
			else if (press == btnReset) {//清空
				operation = -1;
				tfDisplay.setText("");
				pointAdded = false;
			}
			else if (press == btnEqual) {//輸出答案
				pointAdded = false;
				answer = Double.parseDouble(tfDisplay.getText());
				switch (operation) {
				case 1:
					answer = receive+answer;
					break;
				case 2:
					answer = receive-answer;
					break;
				case 3:
					answer = receive*answer;
					break;
				case 4:
					if(answer == 0.0){
						erro = 1;//若除以0，輸出錯誤
					}else{
						answer = receive/answer;
						answer = Math.round(answer*100.0)/100.0;
						
					}
					
					break;
					default:
						break;
				}
				if( erro ==1 ) {
					tfDisplay.setText("erro");
					erro = 0;
				}
				else {
					tfDisplay.setText(String.valueOf(answer));//輸出結果
				}
			}
		}
		private void output(JButton btn) {//顯示到表格的函式
			tfDisplay.setText((tfDisplay.getText()+ btn.getText()));
		}
	}
	
	public static void main(String[] args){
		A411077013_Hw1 calculator = new A411077013_Hw1();
		calculator.setSize(350, 350);
		calculator.setTitle("A411077013_Hw1: Calculator");
		calculator.setVisible(true);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

