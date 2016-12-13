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
				answer = "goodbye!";
				System.exit(0);
			}
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
			if(stupidBot.inputHTMLChecker(input))
			{
				answer += "\nThat's a spicy HTML\n";
			}
			if(stupidBot.keyboardMashChecker(input))
			{
				answer += "\ndon't mash the keyboard that's rude\n";
			}
			if(stupidBot.twitterChecker(input))
			{
				answer += "\nNice tweet my dude\n";
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
			else
			{
				chatView.displayMessage("Thank you for chatting with me :D");
			}
			return answer;		
		}
		
		private String randomTopicGenerator()
		{
			String randomTopic = "";
			int random = (int) (Math.random() * 7);
			
			switch (random)
			{
			case 0:
				randomTopic = "\nDota 2 is a game about do damage.\n";
			case 1:
				randomTopic = "\nWoah, hey guys. Welcome to EB Games.\n";
			case 2:
				randomTopic = "\nWhat do you think about Death Grips?\n";
			case 3:
				randomTopic = "\nWhat did you have for breakfast?\n";
			case 4:
				randomTopic = "\nNice Timbs my guy\n";
			case 5:
				randomTopic = "\nMy favorite meme is DatBoi. What's yours?\n";
			case 6:
				randomTopic = "\nWhat's your social security number?\n";
			}
			return randomTopic;
		}

		public ChatFrame getBaseFrame() 
		{
			return baseFrame;
		}
		
		public Chatbot getChatbot()
		{
			return this.stupidBot;
		}
}
