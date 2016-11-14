package chat.controller;
import chat.view.*;
import chat.model.Chatbot;
import chat.view.ChatViewer;
public class ChatController
{
		private Chatbot stupidBot;
		private ChatViewer chatView;
		private ChatPanel appFrame;
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
		private String useChatbotCheckers(String input)
		{
			String answer= "";
			if(stupidBot.contentChecker(input))
			{
				answer += "\nYou know my special secret\n";
			}
			if(stupidBot.memeChecker(input))
			{
				answer +="\nMeme machine\n";
			}
			if(input.length() == 0)
			{
				answer +="Sorry, I don't  about "+ input;
			}
			
			return answer;		
		}

}
