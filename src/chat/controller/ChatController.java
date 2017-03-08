package chat.controller;
import chat.view.*;
import chat.model.CTEC;
import chat.view.ChatPanel;
import chat.model.Chatbot;
import chat.view.ChatViewer;
public class ChatController
{
		private Chatbot stupidBot;
		private ChatViewer chatView;
		private ChatFrame ChatFrame;
		private ChatFrame baseFrame;
		private CTEC tweetBot;
		public ChatController()
		{
			ChatFrame = new ChatFrame(this);
			stupidBot = new Chatbot("Andoo Slimer");
			tweetBot = new CTEC(this);
			chatView = new ChatViewer();
		}
		
		public void start()
		{
			chatView.displayMessage("Welcome to ChatBot!");
			ChatFrame.getChatPanel().showMessage(stupidBot.getUserName() + "says: Welcome!");
		}
		
		public String useChatbotCheckers(String input)
		{
			String answer= "";

			if(stupidBot.quitChecker(input))
			{
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
		
		public ChatViewer getPopup()
		{
			return chatView;
		}

		public ChatFrame getBaseFrame() 
		{
			return baseFrame;
		}
		
		public Chatbot getChatbot()
		{
			return this.stupidBot;
		}
		public void useTwitter(String text)
		{
			tweetBot.sendTweet(text);
		}
		
		public void handleErrors(Exception currentException)
		{
			chatView.displayMessage("There has been an error. The newxt window will provide details");
			chatView.displayMessage(currentException.getMessage());
		}
		public String searchTwitter(String name)
		{
			String results = "The top word from user: " + name  + " is: ";
			results +=tweetBot.getMostPopularWord(name);
			
			return results;
		}
}

	
