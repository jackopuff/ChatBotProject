package chat.view;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import chat.controller.ChatController;
public class ChatPanel extends JPanel
{

	private ChatController baseController;
	private SpringLayout baseLayout;
	private SpringLayout baseLayout_1;
	private JTextArea chatDisplay;
	private JButton chatButton;
	private JTextField chatField;
	public ChatPanel(ChatController baseController)
	{
		super();
		this.baseController =baseController;
		this.baseLayout = new SpringLayout();
		baseLayout_1 = new SpringLayout();
		chatDisplay = new JTextArea(5,25);

		chatField = new JTextField(25);

		chatButton = new JButton("Chat with the bot");

		setupPanel();
		setupLayout();
		setupListeners();
		setupChatDisplay();
	}
	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setEnabled(false);
		chatDisplay.setLineWrap(true);
		chatDisplay.setWrapStyleWord(true);
		chatDisplay.setVisible(true);
	}
	private void setupPanel()
	{
		this.setLayout(baseLayout_1);
		this.setBackground(Color.GREEN);
		this.add(chatDisplay);
		this.add(chatButton);
		this.add(chatField);
	}
	private void setupLayout()
	{
		baseLayout_1.putConstraint(SpringLayout.NORTH, chatButton, 39, SpringLayout.SOUTH, chatField);
		baseLayout_1.putConstraint(SpringLayout.WEST, chatButton, 148, SpringLayout.WEST, this);
		baseLayout_1.putConstraint(SpringLayout.NORTH, chatField, 20, SpringLayout.SOUTH, chatDisplay);
		baseLayout_1.putConstraint(SpringLayout.WEST, chatField, 68, SpringLayout.WEST, this);
		baseLayout_1.putConstraint(SpringLayout.NORTH, chatDisplay, 36, SpringLayout.NORTH, this);
		baseLayout_1.putConstraint(SpringLayout.WEST, chatDisplay, 75, SpringLayout.WEST, this);
	}
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userWords = chatField.getText();
				String botResponse = baseController.useChatbotCheckers(userWords);
				
				chatDisplay.setText("You said: "+ userWords + "\n" + "Chatbot said: " +botResponse);
				chatField.setText("");
			}
		});
	}
	
}
