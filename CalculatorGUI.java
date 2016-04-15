import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Component;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel p_north;
	private JPanel p_center;
	private JPanel p_south;
	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JButton btn_add;
	private JButton btn_sub;
	private JButton btn_4;
	private JButton btn_5;
	private JButton btn_6;
	private JButton btn_mul;
	private JButton btn_div;
	private JButton btn_7;
	private JButton btn_8;
	private JButton btn_9;
	private JButton btn_clear;
	private JButton btn_calc;
	private JLabel lbl_result;
	private JButton btn_0;
	private JButton btn_dot;
	private JButton btn_del;
	private JPanel p_south_innerP;
	private JLabel lbl_signature;
	
	
	private String operator;
	private String left;
	private String right;
	private double result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI frame = new CalculatorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculatorGUI() {
		setTitle("\uAE40\uC131\uD6C8 \uACC4\uC0B0\uAE30");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 10));
		setContentPane(contentPane);
		
		p_north = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p_north.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		p_north.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(p_north, BorderLayout.NORTH);
		
		lbl_result = new JLabel("0");
		lbl_result.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lbl_result.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_result.setPreferredSize(new Dimension(300, 80));
		p_north.add(lbl_result);
		
		p_center = new JPanel();
		contentPane.add(p_center, BorderLayout.CENTER);
		p_center.setLayout(new GridLayout(3, 5, 10, 10));
		
		btn_1 = new JButton("1");
		btn_1.addActionListener(this);
		btn_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		btn_1.setPreferredSize(new Dimension(30, 30));
		p_center.add(btn_1);
		
		btn_2 = new JButton("2");
		btn_2.addActionListener(this);
		btn_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_center.add(btn_2);
		
		btn_3 = new JButton("3");
		btn_3.addActionListener(this);
		btn_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_center.add(btn_3);
		
		btn_add = new JButton("+");
		btn_add.addActionListener(this);
		btn_add.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_center.add(btn_add);
		
		btn_sub = new JButton("-");
		btn_sub.addActionListener(this);
		btn_sub.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_center.add(btn_sub);
		
		btn_4 = new JButton("4");
		btn_4.addActionListener(this);
		btn_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_center.add(btn_4);
		
		btn_5 = new JButton("5");
		btn_5.addActionListener(this);
		btn_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_center.add(btn_5);
		
		btn_6 = new JButton("6");
		btn_6.addActionListener(this);
		btn_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_center.add(btn_6);
		
		btn_mul = new JButton("*");
		btn_mul.addActionListener(this);
		btn_mul.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_center.add(btn_mul);
		
		btn_div = new JButton("/");
		btn_div.addActionListener(this);
		btn_div.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_center.add(btn_div);
		
		btn_7 = new JButton("7");
		btn_7.addActionListener(this);
		btn_7.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_center.add(btn_7);
		
		btn_8 = new JButton("8");
		btn_8.addActionListener(this);
		btn_8.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_center.add(btn_8);
		
		btn_9 = new JButton("9");
		btn_9.addActionListener(this);
		btn_9.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_center.add(btn_9);
		
		btn_dot = new JButton(".");
		btn_dot.addActionListener(this);
		btn_dot.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_center.add(btn_dot);
		btn_dot.setPreferredSize(new Dimension(20, 20));
		
		btn_clear = new JButton("C");
		btn_clear.addActionListener(this);
		btn_clear.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_center.add(btn_clear);
		
		p_south = new JPanel();
		contentPane.add(p_south, BorderLayout.SOUTH);
		p_south.setLayout(new BorderLayout(5, 5));
		
		btn_0 = new JButton("0");
		btn_0.addActionListener(this);
		btn_0.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_south.add(btn_0, BorderLayout.CENTER);
		btn_0.setPreferredSize(new Dimension(50, 50));
		
		p_south_innerP = new JPanel();
		p_south.add(p_south_innerP, BorderLayout.EAST);
		p_south_innerP.setLayout(new GridLayout(0, 2, 9, 0));
		
		btn_del = new JButton("del");
		btn_del.addActionListener(this);
		btn_del.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_south_innerP.add(btn_del);
		
		btn_calc = new JButton("=");
		btn_calc.addActionListener(this);
		btn_calc.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		p_south_innerP.add(btn_calc);
		
		lbl_signature = new JLabel("\uAE40\uC131\uD6C8 \uACC4\uC0B0\uAE30\u314E\u314E");
		lbl_signature.setHorizontalAlignment(SwingConstants.CENTER);
		p_south.add(lbl_signature, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		String cmdValue = e.getActionCommand();
		if(cmdValue.equals("+") || cmdValue.equals("-") || cmdValue.equals("*") || cmdValue.equals("/")){		//4Ä¢¿¬»ê -> 0À¸·Î ¸ø³ª´©°Ô
			operator = cmdValue;
			left = lbl_result.getText();
			lbl_result.setText("0");
		}else if (cmdValue.equals("del")){		//delÅ° ±¸ÇöÇÔ
			if(lbl_result.getText().length() == 1){
				lbl_result.setText("0");
			}else {
				lbl_result.setText(lbl_result.getText().substring(0, lbl_result.getText().length()-1));
			}
		}else if (cmdValue.equals("C")){		//clearÅ° ±¸ÇöÇÔ
			lbl_result.setText("0");
		}else if (cmdValue.equals("=")){		//=Å° ±¸ÇöÇÔ
			right = lbl_result.getText();
			operation();
			lbl_result.setText(Double.toString(result));
		}else {		//¼ýÀÚ¿Í .Å° -> .À» 1°³¸¸ ÀÔ·ÂÇÏ°Ô²û 
			if(cmdValue.equals(".")){
				char[] c = lbl_result.getText().toCharArray();
				for (char a : c){
					if (a == '.'){
						return;
					}//if
				}//for
				if(lbl_result.getText().equals("0")){
					lbl_result.setText("0.");
					return;
				}
			}// .ÀÌ ÀÔ·ÂµÆÀ»¶§ ½ÇÇàµÇ´Â °Íµé .. ÀÌ ¾Æ·¡´Â ¼ýÀÚ°¡ ÀÔ·ÂµÆÀ»¶§ ½ÇÇàµÇ´Â °Íµé
			
			if(lbl_result.getText().equals("0")){
				lbl_result.setText(cmdValue);
			}else{
				lbl_result.setText(lbl_result.getText() + cmdValue);
			}
		}
	}//actionPerformed()
	
	
	public void operation(){
		if(operator.equals("+")){
			result = Double.parseDouble(left) + Double.parseDouble(right);
		}else if (operator.equals("-")){
			result = Double.parseDouble(left) - Double.parseDouble(right);
		}else if (operator.equals("*")){
			result = Double.parseDouble(left) * Double.parseDouble(right);
		}else if (operator.equals("/")){
			result = Double.parseDouble(left) / Double.parseDouble(right);
		}
	}
}
