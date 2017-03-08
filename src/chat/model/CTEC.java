package chat.model;

import java.util.ArrayList;
import java.util.List;

import chat.controller.ChatController;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;
public class CTEC 
{
	private ChatController baseController;
	private Twitter twitterBot;
	private List<Status> searchedTweets;
	private List<String> ignoredWords;
	
	public CTEC(ChatController baseController)
	{
		this.baseController = baseController;
		searchedTweets = new ArrayList<Status>();
		ignoredWords = new ArrayList<String>();
		this.twitterBot = TwitterFactory.getSingleton();
	}
	
	public void sendTweet(String textToTweet)
	{
		try
		{
			twitterBot.updateStatus(textToTweet + "@chatbotctec");
			
		}
		catch(TwitterException tweetError)
		{
			baseController.handleErrors(tweetError);
		}
		catch(Exception otherError)
		{
			baseController.handleErrors(otherError);
		}
	}
	private void createIgnoredWordList()
	{
		
	}
	private void collectTweets(String username)
	{
		
	}
	
	public String getMostPopularWord(String username)
	{
		return "";
	}
}
