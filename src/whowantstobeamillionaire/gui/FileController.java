/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whowantstobeamillionaire.gui;

import whowantstobeamillionaire.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FileController {
    
    
    
     
    
     public void newContestantFile() throws FileNotFoundException, IOException{
         ObjectOutputStream oos;
       
       
         oos = new ObjectOutputStream(new FileOutputStream("ContestantRecord.txt"));
         
         List<Contestant> contestants = new ArrayList();
         
         oos.writeObject(contestants);
         oos.close(); 
    }
     
     public List<Contestant> FetchContestantList(){
            List<Contestant> a = new ArrayList();
            
            ObjectInputStream ois = null;
        try {
			ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\WhoWantsToBeAMillionaire\\ContestantRecord.txt"));
			a = (List<Contestant>)ois.readObject();
            }catch (Exception e) {
			System.out.println(e.getMessage());
		}
            finally {
			
            try{
                          ois.close();
				
            } catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
        return a;
}
      public void addContestantToFile(Contestant a) throws IOException{
        
        ObjectInputStream ois = null;
        List<Contestant> qlist = new ArrayList();
		
        try {
			ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\WhoWantsToBeAMillionaire\\ContestantRecord.txt"));
			qlist = (List<Contestant>)ois.readObject();
            }catch (Exception e) {
		//System.out.println(e.getMessage());
		}
            finally {
			
            try{
                          ois.close();
				
            } catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
    
        qlist.add(a);
        
        ObjectOutputStream oos; 
        oos= new ObjectOutputStream(new FileOutputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\WhoWantsToBeAMillionaire\\ContestantRecord.txt"));
        oos.writeObject(qlist);
        oos.close(); 
    
    
    }
     
    public void newQuestionFiles() throws FileNotFoundException, IOException{
         ObjectOutputStream oos;
       
        for (int i = 1; i < 16; i++) {
            
         Integer t = new Integer(i);
         String a = t.toString();
         oos = new ObjectOutputStream(new FileOutputStream("L"+a+"Questions.txt"));
    }
     }
     public List<Question> FetchQuestionList(int level){
            List<Question> a = new ArrayList();
            Integer lvl = new Integer(level);
            ObjectInputStream ois = null;
        try {
			ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\WhoWantsToBeAMillionaire\\L"+lvl.toString()+"Questions.txt"));
			a = (List<Question>)ois.readObject();
            }catch (Exception e) {
			System.out.println(e.getMessage());
		}
            finally {
			
            try{
                          ois.close();
				
            } catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
        return a;
}
    
   
    public void addQuestionToFile(Question a, int level) throws IOException{
        ObjectInputStream ois = null;
	Integer lvl = new Integer(level);
        List<Question> qlist = new ArrayList();
		
        try {
			ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\WhoWantsToBeAMillionaire\\L"+lvl.toString()+"Questions.txt"));
			qlist = (List<Question>)ois.readObject();
            }catch (Exception e) {
		//System.out.println(e.getMessage());
		}
            finally {
			
            try{
                          ois.close();
				
            } catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
    
        qlist.add(a);
        
        ObjectOutputStream oos; 
        oos= new ObjectOutputStream(new FileOutputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\WhoWantsToBeAMillionaire\\L"+lvl.toString()+"Questions.txt"));
        oos.writeObject(qlist);
        oos.close(); 
    
    
    }
    
     public void writeQuestionFiles() throws IOException{
    List<Question> qq = new ArrayList<Question>();
    qq.add(new Question("Galileo was the citizen of which country?", 1, "pasta", "meat", "hungry", "Italy", ""));
    qq.add(new Question("What is the only metal that is a liquid at normal atmospheric pressure and temperature?", 1, "lasanga", "pizza", "olives", "Mercury", ""));
    qq.add(new Question("Nepal is located on which continent?", 1, "alien", "cry", "game", "Asia", "poop"));
    qq.add(new Question("Which boxer was known as “The Greatest” and “The People’s Champion”?", 1, "", "", "", "Muhammad Ali", ""));
    qq.add(new Question("What part of the atom has no electric charge?", 1, "try", "fail", "repeat", "Neutron", ""));
    qq.add(new Question("What’s the shortcut for the “copy” function on most computers?", 1, "holy", "moly", "broli", "ctrl c", ""));
    qq.add(new Question("What is the common name for dried plums?", 1, "chocolate", "broccoli", "choccoli", "Prunes", ""));
    qq.add(new Question("Which kind of alcohol is Russia known for?", 1, "fish", "water", "mudcake", "Vodka", ""));
    qq.add(new Question("Which organ has four chambers?", 1, "harry potter", "chunder", "starbucks", "The heart", ""));
    qq.add(new Question("Which element is said to keep bones strong?", 1, "weak", "bones", "salt", "Calcium", ""));
    
    qq.add(new Question("Which chess piece can only move diagonally?", 2, "dog", "death", "food", "A bishop", "poop"));
    qq.add(new Question("What character did Michael J. Fox play in ‘Back to the Future’?", 2, "alien", "cry", "game", "Marty McFly", "poop"));
    qq.add(new Question("Europe is separated from Africa by which sea?", 2, "alien", "cry", "game", "Mediterranean Sea", "poop"));
    qq.add(new Question("Canberra is the capital city of which country?", 2, "alien", "cry", "game", "Australia", "poop"));
    qq.add(new Question("What particle in an atom has a positive charge?", 2, "alien", "cry", "game", "Proton", "poop"));
    qq.add(new Question("What is the biggest artery in the human body?", 2, "alien", "cry", "game", "Aorta", "poop"));
    qq.add(new Question("Zurich is the largest city in what country?", 2, "alien", "cry", "game", "Switzerland", "poop"));
    qq.add(new Question("What’s the hardest rock?", 2, "alien", "cry", "game", "A diamond", "poop"));
    qq.add(new Question("Groups of lions are known as what?", 2, "alien", "cry", "game", "Prides", "poop"));
    qq.add(new Question("Name the world’s largest ocean.", 2, "alien", "cry", "game", "Pacific", "poop"));
    
    qq.add(new Question("What substance are nails made out of?", 3, "salt", "scissors", "plane", "Keratin", "poop"));
    qq.add(new Question("How many signs are there in the Zodiac?", 3, "alien", "cry", "game", "12", "poop"));
    qq.add(new Question("What is the first element on the Periodic Table?", 3, "alien", "cry", "game", "Hydrogen", "poop"));
    qq.add(new Question("Who was the only US President to resign?", 3, "alien", "cry", "game", "Richard M. Nixon", "poop"));
    qq.add(new Question("What country has the most vending machines per capita?", 3, "alien", "cry", "game", "Japan", "poop"));
    qq.add(new Question("What’s the most populous city in the United States?", 3, "alien", "cry", "game", "New York", "poop"));
    qq.add(new Question("Which fruit floats because 25% of its volume is air?", 3, "alien", "cry", "game", "Apple", "poop"));
    qq.add(new Question("What has a gravitational pull so strong that even light cannot escape it?", 3, "alien", "cry", "game", "Black Hole", "poop"));
    qq.add(new Question("What were the two sides in World War II known as?", 3, "alien", "cry", "game", "Allies and Axis", "poop"));
    qq.add(new Question("What vitamin does the sun’s ultraviolet rays help the skin produce?", 3, "alien", "cry", "game", "Vitamin D", "poop"));
    
    qq.add(new Question("In which city did Hitler commit suicide?", 4, "champage", "fly-spray", "knife", "Berlin", "poop"));
    qq.add(new Question("What was the first Disney animated film based on the life of a real person?", 4, "alien", "cry", "game", "Pocahontas", "poop"));
    qq.add(new Question("What does a seismologist study?", 4, "alien", "cry", "game", "Earthquakes", "poop"));
    qq.add(new Question("Which sea is located in Israel and Jordan?", 4, "alien", "cry", "game", "Dead Sea", "poop"));
    qq.add(new Question("What is the name of Jordan’s capital city?", 4, "alien", "cry", "game", "Amman", "poop"));
    qq.add(new Question("What is Harry Potter’s Patronus?", 4, "alien", "cry", "game", "Stag", "poop"));
    qq.add(new Question("The tuba is the largest member of which musical family?", 4, "alien", "cry", "game", "Brass", "poop"));
    qq.add(new Question("The video game “Happy Feet” features what animals?", 4, "alien", "cry", "game", "Penguins", "poop"));
    qq.add(new Question("Which is the main substance used to make a crayon?", 4, "alien", "cry", "game", "Wax", "poop"));
    qq.add(new Question("What object of Dwight’s did Jim put in Jell-O on the TV show “The Office”?", 4, "alien", "cry", "game", "Stapler", "poop"));
    
    
    qq.add(new Question("What was the predecessor to the United Nations?", 5, "ice-cream", "cream", "pen", "League of Nations", "poop"));
    qq.add(new Question("What are the bones in the fingers called?", 5, "alien", "cry", "game", "Philanges", "poop"));
    qq.add(new Question("“You’re gonna need a bigger boat” originated in what movie?", 5, "alien", "cry", "game", "Jaws", "poop"));
    qq.add(new Question("What does the “R” stand for on the rating of a movie?", 5, "alien", "cry", "game", "Restricted", "poop"));
    qq.add(new Question("What grows from an acorn?", 5, "alien", "cry", "game", "Oak Tree", "poop"));
    qq.add(new Question("What major movie actor’s first role was in “A Nightmare On Elm Street”?", 5, "alien", "cry", "game", "Johnny Depp", "poop"));
    qq.add(new Question("What is the most populous city in Canada?", 5, "alien", "cry", "game", "Toronto", "poop"));
    qq.add(new Question("Islamabad is the capital of which country?", 5, "alien", "cry", "game", "Pakistan", "poop"));
    qq.add(new Question("Which country invented tea?", 5, "alien", "cry", "game", "China", "poop"));
    qq.add(new Question("Which Jamaican runner is an 11-time world champion and holds the record in the 100 and 200-meter race?", 5, "alien", "cry", "game", "Usain Bolt", "poop"));
    
    qq.add(new Question("What is Japanese sake made from?", 6, "wallet", "keyboard", "No", "Rice", "poop"));
    qq.add(new Question("Which country is the largest producer of vanilla?", 6, "alien", "cry", "game", "Madagascar", "poop"));
    qq.add(new Question("What is the only fruit that has its seeds on the outside?", 6, "alien", "cry", "game", "Strawberries", "poop"));
    qq.add(new Question("What gas makes soda bubbly?", 6, "alien", "cry", "game", "Carbon Dioxide", "poop"));
    qq.add(new Question("Which country has a red flag with a star in the middle?", 6, "alien", "cry", "game", "Morocco", "poop"));
    qq.add(new Question("What is the currency of Poland?", 6, "alien", "cry", "game", "Zloty", "poop"));
    qq.add(new Question("How many pairs of wings does a bee have?", 6, "alien", "cry", "game", "Two", "poop"));
    qq.add(new Question("Which country produces the most coffee in the world?", 6, "alien", "cry", "game", "Brazil", "poop"));
    qq.add(new Question("Ludwig Van Beethoven was born in 1770 in which city?", 6, "alien", "cry", "game", "Berlin", "poop"));
    qq.add(new Question("What is the name of Batman’s butler?", 6, "alien", "cry", "game", "Alfred", "poop"));
    
    qq.add(new Question("What is the largest lizard?", 7, "haha", "why", "hook", "Komodo dragon", "poop"));
    qq.add(new Question("Which artist painted “Guernica”?", 7, "alien", "cry", "game", "Pablo Picasso", "poop"));
    qq.add(new Question("Which type of fruit juice did Dole sell first?", 7, "alien", "cry", "game", "Pineapple", "poop"));
    qq.add(new Question("What is the main ingredient in a falafel?", 7, "alien", "cry", "game", "Chickpea", "poop"));
    qq.add(new Question("What currency is used in South Africa?", 7, "alien", "cry", "game", "Rand", "poop"));
    qq.add(new Question("Where is the uvula located?", 7, "alien", "cry", "game", "Throat", "poop"));
    qq.add(new Question(" The Da Vinci Code opens with a murder in which famous museum?", 7, "alien", "cry", "game", "Le Louvre", "poop"));
    qq.add(new Question("What is the world's most expensive spice by weight?", 7, "alien", "cry", "game", "Saffron", "poop"));
    qq.add(new Question("What alcoholic drink is mainly made from juniper berries?", 7, "alien", "cry", "game", "Gin", "poop"));
    qq.add(new Question("Pure water has a pH level of around?", 7, "alien", "cry", "game", "Seven", "poop"));
    
    qq.add(new Question("What color dresses do Chinese women traditionally wear on their wedding day?", 8, "light", "jesus", "vape", "Red", "poop"));
    qq.add(new Question("What country is bordered by Germany, the Czech Republic, Slovakia, and Ukraine?", 8, "alien", "cry", "game", "Poland", "poop"));
    qq.add(new Question("What colors are the Norwegian flag? ", 8, "alien", "cry", "game", "Red, white, and blue", "poop"));
    qq.add(new Question("Which is the highest waterfall in the world?", 8, "alien", "cry", "game", "Angel Falls, Venezuela", "poop"));
    qq.add(new Question("Who is Green Lantern’s nemesis?", 8, "alien", "cry", "game", "Sinestro", "poop"));
    qq.add(new Question("Which American state is the largest (by area)?", 8, "alien", "cry", "game", "Alaska", "poop"));
    qq.add(new Question("What is the smallest country in the world?", 8, "alien", "cry", "game", "Vatican City", "poop"));
    qq.add(new Question("Which city in India would you find the Taj Mahal in?", 8, "alien", "cry", "game", "Agra", "poop"));
    qq.add(new Question("What holiday is called “turkey day”?", 8, "alien", "cry", "game", "Thanksgiving Day", "poop"));
    qq.add(new Question("Which country did AC/DC originate in?", 8, "alien", "cry", "game", "Australia", "poop"));
    
    qq.add(new Question("In which of Britney’s video does she appear as a stewardess?", 9, "shoe", "llama", "country", "Toxic", "poop"));
    qq.add(new Question("Carrots are a good source of which vitamin?", 9, "alien", "cry", "game", "Vitamin A", "poop"));
    qq.add(new Question("What is the driest continent?", 9, "alien", "cry", "game", "Antarctica", "poop"));
    qq.add(new Question("A flamboyance is a group of what animals?", 9, "alien", "cry", "game", "Flamingos", "poop"));
    qq.add(new Question("New York City comprises how many boroughs?", 9, "alien", "cry", "game", "5", "poop"));
    qq.add(new Question("Where did the pineapple plant originate?", 9, "alien", "cry", "game", "South America", "poop"));
    qq.add(new Question("What country won the very first FIFA World Cup in 1930?", 9, "alien", "cry", "game", "Uruguay", "poop"));
    qq.add(new Question("Which racer holds the record for the most Grand Prix wins?", 9, "alien", "cry", "game", "Michael Schumacher", "poop"));
    qq.add(new Question("Which name is rapper Sean Combs better known by?", 9, "alien", "cry", "game", " P. Diddy", "poop"));
    qq.add(new Question("Which British girl group had a member by the name of Mel B?", 9, "alien", "cry", "game", "Spice Girls", "poop"));
    
    qq.add(new Question("What or who is the Ford Mustang named after?", 10, "boat", "car", "gun", "Fighter plane", "poop"));
    qq.add(new Question("How many parts (screws and bolts included) does the average car have?", 10, "alien", "cry", "game", "30,000", "poop"));
    qq.add(new Question("What does the acronym AIDS stand for?", 10, "alien", "cry", "game", "Acquired Immune Deficiency Syndrome", "poop"));
    qq.add(new Question("What animal is on Levi’s logo?", 10, "alien", "cry", "game", "Horse", "poop"));
    qq.add(new Question("Who is the writer of “Merchant of Venice”?", 10, "alien", "cry", "game", "William Shakespeare", "poop"));
    qq.add(new Question("“Adventure of Sherlock Holmes” was written by which writer?", 10, "alien", "cry", "game", "Arthur Conan Doyle", "poop"));
    qq.add(new Question("Which country is Aesop’s Fables believed to originate in?", 10, "alien", "cry", "game", "Greece", "poop"));
    qq.add(new Question("How many films did Sean Connery play James Bond in?", 10, "alien", "cry", "game", "7", "poop"));
    qq.add(new Question("Which Indiana Jones movie was released back in 1984?", 10, "alien", "cry", "game", "Indiana Jones and the Temple of Doom", "poop"));
    qq.add(new Question("Tanks were used in battle for the first time in which conflict?", 10, "alien", "cry", "game", "World War 1", "poop"));
    
    qq.add(new Question("Who wrote songs for The Lion King?", 11, "anime", "movie", "fish", "Elton John", "poop"));
    qq.add(new Question("What U.S. newspaper is nicknamed “the Gray Lady”?", 11, "alien", "cry", "game", "The New York Times", "poop"));
    qq.add(new Question("As what type of beans are chickpeas, also known as?", 11, "alien", "cry", "game", "Garbanzo", "poop"));
    qq.add(new Question("In what year was the first episode of South Park aired?", 11, "alien", "cry", "game", "1997", "poop"));
    qq.add(new Question("Which actor appeared in films “Face Off” and “Ghost Rider”?", 11, "alien", "cry", "game", "Nicholas Cage", "poop"));
    qq.add(new Question("Which actress won the Oscar for Best Actress in 2003?", 11, "alien", "cry", "game", "Nicole Kidman", "poop"));
    qq.add(new Question("Who has been the longest-serving monarch of the United Kingdom?", 11, "alien", "cry", "game", "Queen Elizabeth II", "poop"));
    qq.add(new Question("World War I began with the death of Archduke Franz Ferdinand, of which country?", 11, "alien", "cry", "game", "Austria", "poop"));
    qq.add(new Question("What’s the scientific name of a wolf?", 11, "alien", "cry", "game", "Canis lupus", "poop"));
    qq.add(new Question("Which warrior’s weakness was their heel?", 11, "alien", "cry", "game", "Achilles", "poop"));
    
    qq.add(new Question("In ancient Greece, throwing an apple at someone was a declaration of what?", 12, "pasta", "chicken", "syrup", "Love", "poop"));
    qq.add(new Question("Which insect can indicate the air temperature?", 12, "alien", "cry", "game", "Cricket", "poop"));
    qq.add(new Question("Blueberries are native to which continent?", 12, "alien", "cry", "game", "North America", "poop"));
    qq.add(new Question("In what year was McDonald's founded?", 12, "alien", "cry", "game", "1955", "poop"));
    qq.add(new Question("What was the original name of the search engine \"Google\"?", 12, "alien", "cry", "game", "BackRub", "poop"));
    qq.add(new Question("What did the Crocodile swallow in Peter Pan?", 12, "alien", "cry", "game", "An alarm clock", "poop"));
    qq.add(new Question("How many hearts does an octopus have?", 12, "alien", "cry", "game", "Three", "poop"));
    qq.add(new Question("How many eyes does a bee have?", 12, "alien", "cry", "game", "Five", "poop"));
    qq.add(new Question("Which mammal has no vocal cords?", 12, "alien", "cry", "game", "Giraffe", "poop"));
    qq.add(new Question("How many notes are there on a standard grand piano?", 12, "alien", "cry", "game", "88", "poop"));
    
    qq.add(new Question("The largest political party in South Africa, the ANC, stands for what?", 13, "wire", "pepper", "cup", "African National Congress", "poop"));
    qq.add(new Question("Before the laws were changed in 2000, how long was a French president’s term?", 13, "alien", "cry", "game", "Seven years", "poop"));
    qq.add(new Question("How many phases of the moon are there?", 13, "alien", "cry", "game", "Eight", "poop"));
    qq.add(new Question("What did Queen Anne die of?", 13, "alien", "cry", "game", "A stroke", "poop"));
    qq.add(new Question("What year was Queen Elizabeth II born?", 13, "alien", "cry", "game", "1926", "poop"));
    qq.add(new Question("What is the Hawaiian name for yellowfin tuna?", 13, "alien", "cry", "game", "Ahi", "poop"));
    qq.add(new Question("The traditional Wimbledon colors are green, and what?", 13, "alien", "cry", "game", "Purple", "poop"));
    qq.add(new Question("Robin Williams won a best supporting actor Oscar for what film?", 13, "alien", "cry", "game", "Good Will Hunting", "poop"));
    qq.add(new Question("What is the romanized Arabic word for \"moon\"?", 13, "alien", "cry", "game", "Qamar", "poop"));
    qq.add(new Question("What is the name of the home of the Greek Gods?", 13, "alien", "cry", "game", "Olympus", "poop"));
    
    qq.add(new Question("What is the last letter of the Greek alphabet?", 14, "demon", "time", "fun", "Omega", "poop"));
    qq.add(new Question("What country produced the most strawberries in 2016?", 14, "alien", "cry", "game", "China", "poop"));
    qq.add(new Question("What candy was used to lure E.T. in the 1982 movie “E.T.: The Extra-Terrestrial”?", 14, "alien", "cry", "game", "Reece's Pieces", "poop"));
    qq.add(new Question("In what American state is it illegal to dress up like a priest or a nun?", 14, "alien", "cry", "game", "Alabama", "poop"));
    qq.add(new Question("In what country did carving jack o’ lanterns originate?", 14, "alien", "cry", "game", "Ireland", "poop"));
    qq.add(new Question("Which nuts are used to make marzipan?", 14, "alien", "cry", "game", "Almonds", "poop"));
    qq.add(new Question("What is the most abundant metal in the Earth’s crust?", 14, "alien", "cry", "game", "Aluminium", "poop"));
    qq.add(new Question("What blood type qualifies as a universal donor?", 14, "alien", "cry", "game", "O negative", "poop"));
    qq.add(new Question("Which US state has the longest cave system in the world?", 14, "alien", "cry", "game", "Kentucky", "poop"));
    qq.add(new Question("The Eiffel Tower was originally intended for what city?", 14, "alien", "cry", "game", "Barcelona", "poop"));
    
    qq.add(new Question("What’s the brightest star in the sky?", 15, "soup", "soup", "soup", "Sirius", "poop"));
    qq.add(new Question("Squab is a name given to the young of which bird?", 15, "alien", "cry", "game", "Pigeon", "poop"));
    qq.add(new Question("If a male donkey is a jack, what is the female called?", 15, "alien", "cry", "game", "Jenny", "poop"));
    qq.add(new Question("What is “jaggery” used in Indian cooking?", 15, "alien", "cry", "game", "Sugar", "poop"));
    qq.add(new Question("What TV show won the most Emmys in 2018?", 15, "alien", "cry", "game", "Game of Thrones", "poop"));
    qq.add(new Question("What did the first vending machine dispense?", 15, "alien", "cry", "game", "Holy water", "poop"));
    qq.add(new Question("What U.S. President coined the phrase “Good to the last drop,” referring to coffee?", 15, "alien", "cry", "game", "Theodore Roosevelt", "poop"));
    qq.add(new Question("On every continent, there is a city named what?", 15, "alien", "cry", "game", "Rome", "poop"));
    qq.add(new Question("Which name are the Sandwich Islands, better known as?", 15, "alien", "cry", "game", "Hawaii", "poop"));
    qq.add(new Question("Which fashion designer was shot dead in the summer of 1997?", 15, "alien", "cry", "game", "Gianni Versace", "poop"));
    
    for (int i = 0; i < qq.size(); i++) {
         addQuestionToFile(qq.get(i), qq.get(i).level);
    }
    
}
}
