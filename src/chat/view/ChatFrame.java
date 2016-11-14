package chat.view;
import javax.swing.JFrame;
import chat.controller.ChatController;
import java.awt.Dimension;
public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel appPanel;
	public ChatFrame(ChatController baseController)
	{
		super();
		this.baseController= baseController;
		this.appPanel = new ChatPanel(baseController);
		
		
		this.setupFrame();
	}
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("haha long boy");
		this.setSize(new Dimension(800,800));
		this.setVisible(true);
	}
}
