package chat.view;
import javax.swing.JFrame;
import chat.view.ChatPanel;
import chat.controller.ChatController;
import java.awt.Dimension;
public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel ChatPanel;
	public ChatFrame(ChatController baseController)
	{
		super();
		this.baseController= baseController;
		this.ChatPanel = new ChatPanel(baseController);
		
		
		this.setupFrame();
	}
	private void setupFrame()
	{
		this.setContentPane(ChatPanel);
		this.setTitle("haha long boy");
		this.setSize(new Dimension(800,800));
		this.setVisible(true);
	}
	public ChatPanel getChatPanel()
	{
		return this.ChatPanel;
	}
}
