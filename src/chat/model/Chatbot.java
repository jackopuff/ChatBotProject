package chat.model;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

/**
 * Base version of the 2016 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Jackson Carter
 * @version 1.0 10/14/16
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> HTMLList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	public String KeyboardMashChecker;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.userName = new String(userName);
		this.content = new String("boi");
		this.politicalTopicList = new ArrayList<String>();
		this.HTMLList = new ArrayList<String>();
		this.buildMemesList();
		buildPoliticalTopicsList();
	}
	private void buildMemesList()
	{
	//fills list of memes
	memesList.add("boi");
	memesList.add("doge");
	memesList.add("doggo");
	memesList.add("Pawn Stars");
	memesList.add("Bee Movie");
	memesList.add("grumpy cat");
	memesList.add("dat boi");
	memesList.add("willy wonka");
	memesList.add("harambe");
	memesList.add("john cena");
	memesList.add("Haha Long Boy");
	memesList.add("Pepe");
	memesList.add("Spell ICUP");
	memesList.add("Haha Long Boy");
	memesList.add("Two number 9's");
	memesList.add("Bad Luck Brian");
	memesList.add("Bionicles");
	memesList.add("Spooky Skeletons");
	memesList.add("Baneposting");
	}
	
	private void buildPoliticalTopicsList()
	{
	//fills list of political topics
	politicalTopicList.add("Democrat");
	politicalTopicList.add("Republican");
	politicalTopicList.add("11/4/16");
	politicalTopicList.add("11/8/16");
	politicalTopicList.add("republican");
	politicalTopicList.add("democrat");				
	politicalTopicList.add("liberal");
	politicalTopicList.add("conservative");
	politicalTopicList.add("Clinton");
	politicalTopicList.add("Trump");
	politicalTopicList.add("Kaine");
	politicalTopicList.add("Pence");
	politicalTopicList.add("Stein");
	politicalTopicList.add("Johnson");
	politicalTopicList.add("Vermin Supreme");
	politicalTopicList.add("Bernie Sanders");
	politicalTopicList.add("Jeb Bush");
	politicalTopicList.add("election");	
	}
		
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength=false;
		
		if (currentInput != null && currentInput.length() > 0)
		{
			hasLength=true;
		}
		
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent=false;
		if (currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPolitics=false;
		
		for (int index = 0; index< politicalTopicList.size(); index++)
		{
			String politics=(politicalTopicList.get(index));
			if (currentInput.contains(politics))
				{
				hasPolitics=true;
				}
		}
		return hasPolitics;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{		
		boolean hasMemes=false;
		
		for (int index = 0; index< memesList.size(); index++)
		{
			String memes=(memesList.get(index));
			if (currentInput.toLowerCase().contains(memes.toLowerCase()))
				{
				hasMemes=true;
				}
		}
		return hasMemes;
	}
	
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return null;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return null;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return null;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		
	}

	public boolean keyboardMashChecker(String currentInput)
	{
		boolean hasKeyboardMash = false;
		if(currentInput.contains("adpjfpda")||currentInput.contains("a2435")||currentInput.contains("adffdppijda"))
		{
			hasKeyboardMash=true;
		}
		return hasKeyboardMash;
	}

	public boolean inputHTMLChecker(String currentInput)
	{
		boolean htmlCheck = false;
		if(currentInput.contains("<P>"))
		{
			htmlCheck = true;
		}
		else if(currentInput.contains ("<A HREF=\""))
		{
			int index = currentInput.indexOf("<A HREF=\"") + 9;
			String sub = currentInput.substring(index);
			
			if(sub.contains("\">"))
			{
				int index2 = sub.indexOf("\">");
				String sub2 = sub.substring(index2);
				
				if(sub2.contains(" </a>"))
				{
					htmlCheck = true;
				}
			}
		}
		else if(currentInput.contains("<"))
		{
			String lower = currentInput.toLowerCase();
			int openIndex1 = lower.indexOf("<") +1;
			String tag = "";
			if(lower.contains(">"))
			{
				int openIndex2 = lower.indexOf(">");
				tag= lower.substring(openIndex1, openIndex1);
				
				String sub = lower.substring(openIndex2 +1);
				
				if(sub.contains("</" + tag + ">"))
				{
					htmlCheck = true;
				}
			}
		}
		return htmlCheck;
	}

	public boolean twitterChecker(String currentInput)
	{
		boolean twitterCheck = false;
		String trimmed = currentInput.replaceAll(" ", "");
		if(trimmed.length() >1 && !currentInput.startsWith(" "))
		{
			twitterCheck = true;
		}
		return twitterCheck;
	}

	public boolean quitChecker(String currentInput)
	{
		boolean didquit = false;
		 
		if(currentInput.equalsIgnoreCase("quit"))
		{
			didquit = true;
		}
		return didquit;
	}
}
