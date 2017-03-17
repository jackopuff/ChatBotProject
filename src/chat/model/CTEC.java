package chat.model;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import chat.controller.ChatController;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;
public class CTEC 
{
	private ChatController baseController;
	private Twitter twitterBot;
	private List<Status> allTheTweets;
	private List<String> tweetedWords;
	
	public CTEC(ChatController baseController)
	{
		this.baseController = baseController;
		allTheTweets = new ArrayList<Status>();
		tweetedWords = new ArrayList<String>();
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
	private String calculateTopWord()
	{
		String results = "";
		String topWord = "";
		int mostPopularIndex = 0;
		int popularCount = 0;
		
		for(int index = 0; index < tweetedWords.size(); index++)
		for (int searched = index+1; searched < tweetedWords.size(); searched++)
		{
			int currentPopularity = 0;
			if (tweetedWords.get(index).equalsIgnoreCase(tweetedWords.get(searched)))
			{
				currentPopularity++;
			}
			if(currentPopularity>popularCount)
			{
				popularCount = currentPopularity;
				mostPopularIndex = index;
				topWord = tweetedWords.get(mostPopularIndex);
			}
		}
		results += " the most popular word was " + topWord + ", and it occured " + popularCount + " times.";
		results += "\nThat means it has a percentage of " + ((double)popularCount)/tweetedWords.size() + "%";
		
		return results;
	}
	private void removeEmptyText()
	{
		for(int index = tweetedWords.size() - 1; index >=0; index--)
		{
			
			
		}
		
	}
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,?!:;\"){}^[]<>-";
		
		String scrubbedString = "";
		for(int i = 0; i < currentString.length(); i++)
		{
			
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
	
	private String calculatePopularWordCount()
	{
		String information = "";
		String mostPopular ="";
		int popularIndex =-1;
		int popularCount = 0;
		
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			int currentPopularity = 0;
			for(int searched = index + 1; searched < tweetedWords.size(); searched++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(tweetedWords.get(searched)) && !tweetedWords.get(index).equals(mostPopular))
				{
					
				}
			}
		}
		return information;
	}
	private String [] createIgnoredWordArray()
	{
		String[] boringWords;
		int wordCount = 0;
		
		Scanner boringWordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		while(boringWordScanner.hasNextLine())
		{
			boringWordScanner.nextLine();
			wordCount++;
		}
		boringWordScanner.close();
		
		boringWords = new String [wordCount];
		
		boringWordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		
		for(int index = 0; index < boringWords.length; index++)
		{
			boringWords[index] = boringWordScanner.next();
		}
		boringWordScanner.close();
		return boringWords;
	}
	private void gatherTheTweets(String user)
	{
		tweetedWords.clear();
		allTheTweets.clear();
		int pageCount = 1;
		
		Paging statusPage = new Paging(1,200);
		
		while(pageCount <= 10)
		{
			try
			{
			allTheTweets.addAll(twitterBot.getUserTimeline(user, statusPage));
			}
			catch(TwitterException twitterError)
			{
				baseController.handleErrors(twitterError);
			}
			pageCount++;
		}
	}
	
	public String getMostPopularWord(String username)
	{
		removeBlankWords();
		turnTweetsToWords();
		removeBoringWords();
		String information = "The tweetcount is ";
		return information;
	}
	private void removeBoringWords()
	{
		String [] boringWords = createIgnoredWordArray();
		
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			for(int boringIndex = 0; boringIndex < boringWords.length; boringIndex++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(boringWords[boringIndex]))
				{
					tweetedWords.remove(index);
					index--;
					boringIndex = boringWords.length;
				}
			}
		}
	}
	private void turnTweetsToWords()
	{
		for(Status currentTweet : allTheTweets)
		{
			String text = currentTweet.getText();
			String [] tweetWords = text.split(" ");
			for(String word : tweetWords)
			{
				tweetedWords.add(word);
			}
		}
	}
	private void removeBlankWords()
	{
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			if(tweetedWords.get(index).trim().equals(""))
				{
					tweetedWords.remove(index);
					index--;
				}
		}
	}
}
