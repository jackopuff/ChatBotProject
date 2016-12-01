package chat.controller;
import chat.view.*;
import chat.view.ChatPanel;
import chat.model.Chatbot;
import chat.view.ChatViewer;
public class ChatController
{
		private Chatbot stupidBot;
		private ChatViewer chatView;
		private ChatPanel appFrame;
		private ChatFrame baseFrame;
		public ChatController()
		{
			this.appFrame = new ChatPanel(this);
			stupidBot = new Chatbot("Andoo Slimer");
			chatView = new ChatViewer();
		}
		
		public void start()
		{
			String response = chatView.collectResponse("What do you want to talk about today?");
			
			while(stupidBot.lengthChecker(response))
			{
				chatView.displayMessage(useChatbotCheckers(response));
				response = chatView.collectResponse("Oh, you are interested in "+response);
			}
		}
		public String useChatbotCheckers(String input)
		{
			String answer= "";
			if(!stupidBot.quitChecker(input))
			{
			
			
			if(stupidBot.contentChecker(input))
			{
				answer += "\nYou know my special secret\n";
			}
			if(stupidBot.memeChecker(input))
			{
				answer +="\nMeme machine\n";
			}
			if(stupidBot.politicalTopicChecker(input))
			{
				answer += "\nOh, you're in interested in politics\n";
			}
			if(input.length() == 0)
			{
				answer +="Sorry, I don't  about "+ input;
			}
			int canBeRandom = (int)(Math.random()*7);
			if (canBeRandom % 7 == 0)
			{
				answer += randomTopicGenerator();
			}
			}
			else
			{
				chatView.displayMessage("Thank you for chatting with me :D");
			}
			return answer;		
		}
		
		private String randomTopicGenerator()
		{
			String randomTopic = "";
			return randomTopic;
		}


}
