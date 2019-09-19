import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple GUI calculator program
 * It can only calculate value of two integers
 *
 * Todo: 1. Add multiple calculation
 * 		 2. Add keyboard input
 * 
 * Updates: 
 * 2019.9.2:17:40 : First release, works fine with 2 digits
 * 2019.9.2:17:46 : Add sentence to prevent user doing num1 / 0
 * 2019.9.2:18:00 : Bug fixed, release beta version
 * 2019.9.4:10:45 : Built a executable jar file
 * 2019.9.4:10:50 : Add function to adapt different screen sizes
 * 2019.9.4:11:25 : Add a text field so the program can run without cmd
 * @author Jay
 * @version 1.0.0
 * 
 */
public class Calculator extends JFrame {
	private int SCR_WIDTH, SCR_HEIGHT;
	// to be used when needed to be adaptive for different screens

	private String[] operationText = {"+", "-", "x", "/", "="};

	private boolean inputLock = false;
	private String input = "";

	private JButton[] numberButton = new JButton[10]; //Button:  0 1 2 3 4 5 6 7 8 9
	private int tempNumber = 0;
	private int tempId = 0;
	private JButton[] operateButton = new JButton[5]; //Button:  + - * / =
	
	private JButton clearButton = new JButton("C");
	private JTextField textField = new JTextField(null, 30);

	public Calculator()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		SCR_HEIGHT = kit.getScreenSize().height;
		SCR_WIDTH = kit.getScreenSize().width;

		setSize(SCR_WIDTH / 4, SCR_HEIGHT / 2); // Simple adaptation for different screen sizes
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel basePanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel textPanel = new JPanel();
		textPanel.add(textField);

		init(buttonPanel);
		buttonPanel.setLayout(new GridLayout(6, 3, 10, 10));
		basePanel.setLayout(new BorderLayout(10, 5));

		basePanel.add(textPanel, BorderLayout.NORTH);
		basePanel.add(buttonPanel, BorderLayout.CENTER);

		add(basePanel);

		setTitle("Calculaotr");
		setVisible(true);
	}


	/**
	 * Init everything in the gui program
	 * @param panel the panel that contains the buttons and text field
	 */
	private void init(JPanel panel)
	{
		int nextNum = 0;
		int i;
		for(i = 0; i < 10; i++)
		{
			numberButton[i] = new JButton(Integer.toString(nextNum ++));
			numberButton[i].addActionListener(new ActionListener() {
				private int num = tempNumber++;
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(!inputLock)
					{
						input += Integer.toString(num);
						textField.setText(input);
					}
				}
			});
			if(i != 0)
				panel.add(numberButton[i]);
		}

		addOperationListener();
		addClearButtonListener();


		panel.add(operateButton[0]);
		panel.add(numberButton[0]);
		for(i = 1; i < 5; i++)
		{
			panel.add(operateButton[i]);
		}
		panel.add(clearButton);
	}

	/**
	 * Add operation buttons' listener
	 */
	private void addOperationListener()
	{
		int i;
		final String[] optText = {"+", "-", "x", "/", "="};
		for(i = 0; i < 4; i++)
		{
			operateButton[i] = new JButton(optText[i]);
			operateButton[i].addActionListener(new ActionListener() {
				private int id = tempId ++;
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!inputLock)
					{
						input += optText[id];
						textField.setText(input);
					}
				}
			});

		}
		operateButton[4] = new JButton("=");
		operateButton[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				inputLock = true;
				//System.out.println(Core.getResult(input));
				textField.setText(Core.getResult(input));
			}
		});
		
	}



	/**
	 * Add listener to clear button
	 */
	private void addClearButtonListener()
	{
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				inputLock = false;
				input = "";
				textField.setText("");
			}
		});
	}
	
}
