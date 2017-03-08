package chat.view;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import chat.controller.ChatController;
import chat.controller.FileController;
public class ChatPanel extends JPanel
{

	private ChatPanel ChatPanel;
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatDisplay;
	private JButton twitterButton;
	private JButton tweetButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton chatButton;
	private JTextField chatField;
	public ChatPanel(ChatController baseController)
	{
		super();
		this.baseController =baseController;
		this.baseLayout = new SpringLayout();
		baseLayout = new SpringLayout();
		chatDisplay = new JTextArea(5,25);

		chatField = new JTextField(25);

		chatButton = new JButton("Chat with the bot");
		twitterButton = new JButton("search twitter");
		tweetButton = new JButton("send a tweet");
		saveButton = new JButton("save");
		loadButton = new JButton("load");

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
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(chatDisplay);
		this.add(chatButton);
		this.add(chatField);
	}
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 39, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 148, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 20, SpringLayout.SOUTH, chatDisplay);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 68, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatDisplay, 36, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatDisplay, 75, SpringLayout.WEST, this);
	}
	public void showMessage (String message)
	{
		chatDisplay.setText(message);
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
		saveButton.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent click)
				{
					String fileName = chatField.getText();
					
					FileController.saveFile(baseController, fileName.trim(),chatDisplay.getText());
				}
				});
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
			
		});
		twitterButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						String username = chatField.getText();
						chatDisplay.append(baseController.searchTwitter(username));
					}
			
				});
	}

	
}
