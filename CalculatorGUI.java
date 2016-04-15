
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

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
	private JLabel lbl_operation;
	private JLabel lbl_result;
	private JButton btn_0;
	private JButton btn_dot;
	private JButton btn_del;
	private JPanel p_south_innerP;
	private JLabel lbl_signature;

	private double left;
	private double right;
	private String operator;
	private String check;
	private JMenuBar menuBar;
	private JMenu me_file;
	private JMenuItem mi_exit;
	private JSeparator separator;
	private JMenuItem mi_info;
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
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 386, 560);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				windowClose();
			}
		});
		
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		me_file = new JMenu("File");
		me_file.setMnemonic('F');
		me_file.setMnemonic(KeyEvent.VK_F);
		menuBar.add(me_file);
		
		mi_exit = new JMenuItem("Exit");
		mi_exit.addActionListener(this);
		
		mi_info = new JMenuItem("Info");
		mi_info.addActionListener(this);
		me_file.add(mi_info);
		
		separator = new JSeparator();
		me_file.add(separator);
		mi_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		me_file.add(mi_exit);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setForeground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 10));
		setContentPane(contentPane);

		p_north = new JPanel();
		p_north.setBackground(new Color(224, 255, 255));
		p_north.setForeground(Color.ORANGE);
		FlowLayout flowLayout = (FlowLayout) p_north.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		p_north.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(p_north, BorderLayout.NORTH);

		lbl_operation = new JLabel();
		p_north.add(lbl_operation);

		lbl_result = new JLabel("0");
		lbl_result.setForeground(new Color(0, 0, 0));
		lbl_result.setBackground(new Color(255, 0, 0));
		lbl_result.setHorizontalTextPosition(SwingConstants.RIGHT);
		lbl_result.setMaximumSize(new Dimension(0, 0));
		lbl_result.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lbl_result.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_result.setPreferredSize(new Dimension(350, 80));
		p_north.add(lbl_result);

		p_center = new JPanel();
		p_center.setBackground(new Color(224, 255, 255));
		p_center.setForeground(Color.RED);
		contentPane.add(p_center, BorderLayout.CENTER);
		p_center.setLayout(new GridLayout(3, 5, 10, 10));

		btn_1 = new JButton("1");
		btn_1.setForeground(Color.BLACK);
		btn_1.addActionListener(this);
		btn_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		btn_1.setPreferredSize(new Dimension(30, 30));
		p_center.add(btn_1);

		btn_2 = new JButton("2");
		btn_2.addActionListener(this);
		btn_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_center.add(btn_2);

		btn_3 = new JButton("3");
		btn_3.addActionListener(this);
		btn_3.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_center.add(btn_3);

		btn_add = new JButton("+");
		btn_add.addActionListener(this);
		btn_add.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_center.add(btn_add);

		btn_sub = new JButton("-");
		btn_sub.addActionListener(this);
		btn_sub.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_center.add(btn_sub);

		btn_4 = new JButton("4");
		btn_4.addActionListener(this);
		btn_4.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_center.add(btn_4);

		btn_5 = new JButton("5");
		btn_5.addActionListener(this);
		btn_5.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_center.add(btn_5);

		btn_6 = new JButton("6");
		btn_6.addActionListener(this);
		btn_6.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_center.add(btn_6);

		btn_mul = new JButton("*");
		btn_mul.addActionListener(this);
		btn_mul.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_center.add(btn_mul);

		btn_div = new JButton("/");
		btn_div.addActionListener(this);
		btn_div.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_center.add(btn_div);

		btn_7 = new JButton("7");
		btn_7.addActionListener(this);
		btn_7.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_center.add(btn_7);

		btn_8 = new JButton("8");
		btn_8.addActionListener(this);
		btn_8.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_center.add(btn_8);

		btn_9 = new JButton("9");
		btn_9.addActionListener(this);
		btn_9.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_center.add(btn_9);

		btn_dot = new JButton(".");
		btn_dot.addActionListener(this);
		btn_dot.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_center.add(btn_dot);
		btn_dot.setPreferredSize(new Dimension(20, 20));

		btn_clear = new JButton("C");
		btn_clear.addActionListener(this);
		btn_clear.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_center.add(btn_clear);

		p_south = new JPanel();
		p_south.setBackground(new Color(224, 255, 255));
		p_south.setForeground(Color.RED);
		contentPane.add(p_south, BorderLayout.SOUTH);
		p_south.setLayout(new BorderLayout(5, 5));

		btn_0 = new JButton("0");
		btn_0.addActionListener(this);
		btn_0.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_south.add(btn_0, BorderLayout.CENTER);
		btn_0.setPreferredSize(new Dimension(50, 50));

		p_south_innerP = new JPanel();
		p_south_innerP.setBackground(new Color(224, 255, 255));
		p_south.add(p_south_innerP, BorderLayout.EAST);
		p_south_innerP.setLayout(new GridLayout(0, 2, 9, 0));

		btn_del = new JButton("del");
		btn_del.addActionListener(this);
		btn_del.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_south_innerP.add(btn_del);

		btn_calc = new JButton("=");
		btn_calc.addActionListener(this);
		btn_calc.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		p_south_innerP.add(btn_calc);

		lbl_signature = new JLabel("\uAE40\uC131\uD6C8 \uACC4\uC0B0\uAE30\u314E\u314E");
		lbl_signature.setHorizontalAlignment(SwingConstants.CENTER);
		p_south.add(lbl_signature, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		String cmdValue = e.getActionCommand();

		if(cmdValue.equals("+") || cmdValue.equals("-") || cmdValue.equals("*") || cmdValue.equals("/")){		//사칙연산
			check = "wow";
			if(lbl_operation.getText().length() < 1){
				left = Double.parseDouble(lbl_result.getText());
				operator = cmdValue;
				lbl_operation.setText(lbl_result.getText() + cmdValue);
			}else {
					lbl_operation.setText(lbl_operation.getText() +lbl_result.getText() + cmdValue);
					right = Double.parseDouble(lbl_result.getText());
					operation(operator);
					operator = cmdValue;
					lbl_result.setText(Double.toString(left));
			}
		}else if (cmdValue.equals("C")){		//C버튼
			lbl_operation.setText("");
			lbl_result.setText("0");
			operator = null;
		}else if(cmdValue.equals("=")){
			right = Double.parseDouble(lbl_result.getText());
			lbl_operation.setText("");
			operation(operator);
			lbl_result.setText(Double.toString(left));
			operator = null;
			check = "wow";
		}else if(cmdValue.equals("del")){
			String a = lbl_result.getText();
			if(a.length() == 1){
				lbl_result.setText("0");
			}else {
				lbl_result.setText(a.substring(0, a.length()-1));
			}
		}
		

		if(lbl_result.getText().equals("0") || check != null){		//처음이 0이거나 화면에는 숫자가 있지만 연산자를 입력했기에 새로 시작해야 하는 경우
			check = null;
			if(source == btn_1){
				lbl_result.setText("1");
			}else if(source == btn_2){
				lbl_result.setText("2");
			}else if(source == btn_3){
				lbl_result.setText("3");
			}else if(source == btn_4){
				lbl_result.setText("4");
			}else if(source == btn_5){
				lbl_result.setText("5");
			}else if(source == btn_6){
				lbl_result.setText("6");
			}else if(source == btn_7){
				lbl_result.setText("7");
			}else if(source == btn_8){
				lbl_result.setText("8");
			}else if(source == btn_9){
				lbl_result.setText("9");
			}else if(source == btn_0){
				lbl_result.setText("0");
			}else if(source == btn_dot){
				lbl_result.setText("0.");
			}
		}else if(check == null){										//처음이 0이 아니거나 숫자를 입력중인 경우
			if(source == btn_1){
				lbl_result.setText(lbl_result.getText() + "1");
			}else if(source == btn_2){
				lbl_result.setText(lbl_result.getText() + "2");
			}else if(source == btn_3){
				lbl_result.setText(lbl_result.getText() + "3");
			}else if(source == btn_4){
				lbl_result.setText(lbl_result.getText() + "4");
			}else if(source == btn_5){
				lbl_result.setText(lbl_result.getText() + "5");
			}else if(source == btn_6){
				lbl_result.setText(lbl_result.getText() + "6");
			}else if(source == btn_7){
				lbl_result.setText(lbl_result.getText() + "7");
			}else if(source == btn_8){
				lbl_result.setText(lbl_result.getText() + "8");
			}else if(source == btn_9){
				lbl_result.setText(lbl_result.getText() + "9");
			}else if(source == btn_0){
				lbl_result.setText(lbl_result.getText() + "0");
			}else if(source == btn_dot){
				char[] arr =lbl_result.getText().toCharArray();
				for(int i = 0; i < arr.length; i++){
					if(arr[i] == '.')	return;
				}//for
				lbl_result.setText(lbl_result.getText() + ".");
			}
		}// 숫자 입력 끝
		
		
		
		
		
		
		if(source == mi_exit){
			windowClose();
		}
		
		if(source == mi_info){
			JOptionPane.showMessageDialog(this, String.format("만든 사람 : 김성훈%n만든 날짜 : 2016년 4월"), "Info", JOptionPane.PLAIN_MESSAGE);
		}
		
	}// actionPerformed()
	
	public void windowClose(){
		int s = JOptionPane.showConfirmDialog(this, "진심?", "설마 종료?", JOptionPane.OK_CANCEL_OPTION);
		if(s == JOptionPane.OK_OPTION){
			System.exit(0);
		}
	}

	public void operation(String operator){
		if(operator.equals("+")){
			left += right;
		}else if (operator.equals("-")){
			left -= right;
		}else if(operator.equals("*")){
			left *= right;
		}else if(operator.equals("/")){
			left /= right;
		}
	}//operation()

}//class
