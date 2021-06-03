/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whowantstobeamillionaire.gui;

/**
 *
 * @author Sasha Buskin
 */

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GameDB {//Class to control and retrieve database data for game funtions

    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;

    
    public GameDB() {        
        dbManager = new DBManager();      
        conn = dbManager.getConnection();

    }
    //Method to create contestants table in the database 
    public void createContestantTable() {
        try {
           
            this.statement = conn.createStatement();
           // this.checkExistedTable("CONTESTANTS");
            this.statement.addBatch("CREATE TABLE CONTESTANTS (NAME VARCHAR(20), WINNINGS INT, DATE VARCHAR(20))");
            
            this.statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    //Method to insert row into contestants table
    public void addContestantToDB(Contestant contestant) throws SQLException{
        String name = contestant.name;
        int winnings = contestant.money;
        String date = contestant.date;
        String qry = "INSERT INTO CONTESTANTS VALUES ('"+name+"', "+winnings+", '"+date+"')";
        try {
          
        this.statement = conn.createStatement();
        this.statement.executeUpdate(qry);
       
      } catch (SQLException ex) {
            System.out.println(ex.getNextException());
        }
    } 
    public void dropQuestionTable() throws SQLException{
        this.statement = conn.createStatement();
        this.statement.executeUpdate("DROP TABLE CONTESTANTS");
    }
   //Method to retrieve contestant details from database, use details to create contestant objects and return a list of said objects 
   public List<Contestant> getContestantList() throws SQLException{
       Contestant contestantObj;
       List<Contestant> contestantList = new ArrayList(); 
       
        this.statement = conn.createStatement();
        ResultSet rs = this.statement.executeQuery("SELECT * FROM CONTESTANTS");
       
        while (rs.next()) {
            String name = rs.getString("NAME");
            int money = rs.getInt("WINNINGS");
            String date = rs.getString("DATE");
            
            contestantObj = new Contestant(name, money, date);
            
            contestantList.add(contestantObj);
        }
        return contestantList;
   }
   
   //Method to return list of question objects, constructed from data retrieved in this method from the database questions table, input is question level 
    public List<Question> getQuestionSet(int lvl) throws SQLException {
       
        Question questionObj;
        List<Question> questionList = new ArrayList();
         
        this.statement = conn.createStatement();
        ResultSet rs = this.statement.executeQuery("SELECT * FROM QUESTIONS WHERE QUESTIONS.LEVEL = "+lvl);
       
        while (rs.next()) {
        int level = rs.getInt("LEVEL");
        String question = rs.getString("QUESTION");
        String wrong1 = rs.getString("WRONG1");
        String wrong2 = rs.getString("WRONG2");
        String wrong3 = rs.getString("WRONG3");
        String correct = rs.getString("CORRECT");
        String hint = rs.getString("HINT");
        questionObj = new Question(question, level, wrong1, wrong2, wrong3, correct, hint);

        questionList.add(questionObj);
        }
        
        return questionList;

    }
    
    
//Method to check existance of table    
boolean tableExists(String tableName) throws SQLException {
    DatabaseMetaData meta = this.conn.getMetaData();
    ResultSet resultSet = meta.getTables(null, null, tableName, new String[] {"TABLE"});

    return resultSet.next();
}    
 
    //Method to construct and populate question table
    public void createQuestionTable() {
        try {
            this.statement = conn.createStatement();
            //this.checkExistedTable("QUESTIONS");
            this.statement.addBatch("CREATE TABLE QUESTIONS  (QUESTION VARCHAR(200), LEVEL INT, WRONG1 VARCHAR(40), WRONG2 VARCHAR(40), WRONG3 VARCHAR(40), CORRECT VARCHAR(40), HINT VARCHAR(40))");
            this.statement.addBatch("INSERT INTO QUESTIONS VALUES ('Galileo was the citizen of which country?', 1, 'pasta', 'meat', 'hungry', 'Italy', 'YES'),\n"
                                    
                                    +"('What is the only metal that is a liquid at normal atmospheric pressure and temperature?', 1, 'Iron', 'Steel', 'Gold', 'Mercury', 'Planetary'), \n"
                                    +"('Nepal is located on which continent?', 1, 'Europe', 'South America', 'Africa', 'Asia', 'Pandas'),\n"
                                    +"('Which boxer was known as “The Greatest” and “The People’s Champion”?', 1, 'Brad Pitt', 'Jackie Chan', 'Chuck Norris', 'Muhammad Ali', 'Butterfly'),\n"
                                    +"('What part of the atom has no electric charge?', 1, 'Neutral', 'Neutroid', 'Proton', 'Neutron', 'Ask Jimmy'),\n"
                                    +"('What’s the shortcut for the “copy” function on most computers?', 1, 'copy', 'enter', 'space', 'ctrl c', 'v'),\n"
                                    +"('What is the common name for dried plums?', 1, 'Chocolate', 'Broccoli', 'Choccoli', 'Prunes', 'Grapes'), \n"
                                    +"('Which kind of alcohol is Russia known for?', 1, 'Whiskey', 'Moonshine', 'Wine', 'Vodka', 'Cyka'), \n"
                                    +"('Which organ has four chambers?', 1, 'Liver', 'Skin', 'Lungs', 'Heart', 'Pumping'),\n"
                                    +"('Which element is said to keep bones strong?', 1, 'Diamonds', 'Bone Juice', 'Salt', 'Calcium', 'Milkies'),\n"
                                    
                                    +"('Which chess piece can only move diagonally?', 2, 'Knight', 'Queen', 'King', 'Bishop', 'Holy'),\n"
                                    +"('What character did Michael J. Fox play in ‘Back to the Future’?', 2, 'Doc Brown', 'Hannibal', 'Legolas', 'Marty McFly', 'Bzzzz'),\n"
                                    +"('Europe is separated from Africa by which sea?', 2, 'Pacific', 'Atlantic', 'Dead', 'Mediterranean', 'Cuisine'),\n"
                                    +"('Canberra is the capital city of which country?', 2, 'Ethiopia', 'Canada', 'Morocco', 'Australia', 'Crikey'),\n"
                                    +"('What particle in an atom has a positive charge?', 2, 'Molecule', 'Electron', 'Nucleus', 'Proton', 'Jimmy'),\n"
                                    +"('What is the biggest artery in the human body?', 2, 'God Tube', 'Polmonary', 'Hose', 'Aorta', 'Heart'),\n"
                                    +"('Zurich is the largest city in what country?', 2, 'Zambia', 'Germany', 'Austria', 'Switzerland', 'Skiing'),\n"
                                    +"('What’s the hardest rock?', 2, 'Granite', 'Marble', 'Ruby', 'Diamond', 'Bling'),\n"
                                    +"('Groups of lions are known as what?', 2, 'Batches', 'Groupies', 'Bands', 'Prides', 'Character'),\n"
                                    +"('Name the world’s largest ocean.', 2, 'Atlantic', 'Arctic', 'Indian', 'Pacific', 'Nz'),\n"
                                   
                                    +"('What substance are nails made out of?', 3, 'Salt', 'Enamel', 'Dead Skin', 'Keratin', 'Hair'),\n"
                                    +"('How many signs are there in the Zodiac?', 3, '3', '4', '8', '12', 'Monthly'),\n"
                                    +"('What is the first element on the Periodic Table?', 3, 'Oxygen', 'Platinum', 'Helium', 'Hydrogen', 'Water'),\n"
                                    +"('Who was the only US President to resign?', 3, 'Donald J. Trump', 'Michael Scott', 'Jimmy Carter', 'Richard M. Nixon', 'Vietnam'),\n"
                                    +"('What country has the most vending machines per capita?', 3, 'India', 'South Korea', 'China', 'Japan', 'Nippon'),\n"
                                    +"('What is the most populous city in the United States?', 3, 'Houston', 'Los Angeles', 'Boston', 'New York', 'Italian Mobsters'),\n"
                                    +"('Which fruit floats because 25% of its volume is air?', 3, 'Orange', 'Banana', 'Tomato', 'Apple', 'Adam'),\n"
                                    +"('What has a gravitational pull so strong that even light cannot escape it?', 3, 'Pluto', 'Mily Way', 'The Sun', 'Black Hole', 'Darkness'),\n"
                                    +"('What were the two sides in World War II known as?', 3, 'Arsenal and Tottenham', 'Confederate and Union', 'Good and Evil', 'Allies and Axis', 'AA'),\n"
                                    +"('What vitamin does the sun’s ultraviolet rays help the skin produce?', 3, 'Vitamin A', 'Vitamin C', 'Vitamin J', 'Vitamin D', 'Greens'),\n"
                                    
                                    +"('In which city did Hitler commit suicide?', 4, 'London', 'Munich', 'Cologne', 'Berlin', 'Wall'),\n"
                                    +"('What was the first Disney animated film based on the life of a real person?', 4, 'Mickey Mouse', 'Cindarella', 'Mulan', 'Pocahontas', 'America'),\n"
                                    +"('What does a seismologist study?', 4, 'Aliens', 'Housing', 'Games', 'Earthquakes', 'Richter Scale'),\n"
                                    +"('Which sea is located in Israel and Jordan?', 4, 'Red Sea', 'Black Sea', 'Salt Sea', 'Dead Sea', 'Nothing Grows'),\n"
                                    +"('What is the name of Jordan’s capital city?', 4, 'Baghdad', 'Paris', 'Cairo', 'Amman', 'Man'),\n"
                                    +"('What is Harry Potter’s Patronus?', 4, 'Dog', 'Otter', 'Reindeer', 'Stag', 'Dad'),\n"
                                    +"('The tuba is the largest member of which musical family?', 4, 'Tubes', 'Strings', 'Ovals', 'Brass', 'Trumpets'),\n"
                                    +"('The video game “Happy Feet” features what animals?', 4, 'Dogs', 'Rabbits', 'Birds', 'Penguins', 'Cold'),\n"
                                    +"('Which is the main substance used to make a crayon?', 4, 'Soap', 'Plastic', 'Colour', 'Wax', 'Candles'),\n"
                                    +"('What object of Dwight’s did Jim put in Jell-O on the TV show “The Office”?', 4, 'Desk', 'Phone', 'Wallet', 'Stapler', 'Paper'),\n"
                                   
                                    +"('What was the predecessor to the United Nations?', 5, 'Mr Bean', 'Nations United', 'Nothing', 'League of Nations', 'L'),\n"
                                    +"('What are the bones in the fingers called?', 5, 'Finger Bones', 'Femurs', 'Ribs', 'Philanges', 'Small'),\n"
                                    +"('“You’re gonna need a bigger boat” originated in what movie?', 5, 'Alien', 'IT', 'Goodfellas', 'Jaws', 'Sharks'),\n"
                                    +"('What does the “R” stand for on the rating of a movie?', 5, 'Rated', 'Really good', 'Raunchy', 'Restricted', 'Stop'),\n"
                                    +"('What grows from an acorn?', 5, 'Acorn Tree', 'Pine Tree', 'Apple Tree', 'Oak Tree', 'Oaky'),\n"
                                    +"('What major movie actor’s first role was in “A Nightmare On Elm Street”?', 5, 'Brad Pitt', 'Severus Snape', 'Al Pacino', 'Johnny Depp', 'Donnie Brasko'),\n"
                                    +"('What is the most populous city in Canada?', 5, 'Calgary', 'Minnesota', 'Quebec', 'Toronto', 'T'),\n" 
                                    +"('Islamabad is the capital of which country?', 5, 'Egypt', 'India', 'Iran', 'Pakistan', 'poop'),\n"
                                    +"('Which country invented tea?', 5, 'England', 'India', 'Estonia', 'China', 'Gunpowder'),\n"
                                    +"('Which Jamaican runner is an 11-time world champion and holds the record in the 100 and 200-meter race?', 5, 'Asafa Powell', 'Roger Federer', 'Rafael Nadal', 'Usain Bolt', 'Lightning fast'),\n"
                                    
                                    +"('What is Japanese sake made from?', 6, 'Wine', 'Potato', 'Celery', 'Rice', 'Common'),\n"
                                    +"('Which country is the largest producer of vanilla?', 6, 'Colombia', 'Venezuela', 'Congo', 'Madagascar', 'Lemurs'),\n"
                                    +"('What is the only fruit that has its seeds on the outside?', 6, 'Apples', 'Prickly Pears', 'Raspberries', 'Strawberries', 'Spotty'),\n"
                                    +"('What gas makes soda bubbly?', 6, 'Oxygen', 'Helium', 'Hydrogen', 'Carbon Dioxide', 'CO2'),\n"
                                    +"('Which country has a red flag with a star in the middle?', 6, 'China', 'Australia', 'Georgia', 'Morocco', 'Spicy'),\n"
                                    +"('What is the currency of Poland?', 6, 'Dollars', 'Euros', 'Shekels', 'Zloty', 'Obscure'),\n"
                                    +"('How many pairs of wings does a bee have?', 6, 'Three', 'One', 'Four', 'Two', 'poop'),\n"
                                    +"('Which country produces the most coffee in the world?', 6, 'Morocco', 'Canada', 'South Korea', 'Brazil', 'Salsa'),\n"
                                    +"('Ludwig Van Beethoven was born in 1770 in which city?', 6, 'London', 'Amsterdam', 'Madrid', 'Berlin', 'Guten Tag'),\n"
                                    +"('What is the name of Batman’s butler?', 6, 'Robin', 'Falcon', 'Larry', 'Alfred', 'Fettuccine'),\n"
                                    
                                    +"('What is the largest lizard?', 7, 'Dragon', 'Bassilisk', 'Geko', 'Komodo dragon', 'Type of Dragon'),\n"
                                    +"('Which artist painted “Guernica”?', 7, 'Van Gogh', 'Freidrich Sinner', 'Joe Gallo', 'Pablo Picasso', 'Blue Period'),\n"
                                    +"('Which type of fruit juice did Dole sell first?', 7, 'Orange', 'Banana', 'Mango', 'Pineapple', 'Spiky'),\n"
                                    +"('What is the main ingredient in a falafel?', 7, 'Hummus', 'Flour', 'Beef', 'Chickpea', 'Peas'),\n"
                                    +"('What currency is used in South Africa?', 7, 'Won', 'Zloty', 'Dollar', 'Rand', 'Randy'),\n"
                                    +"('Where is the uvula located?', 7, 'Stomach', 'Kidney', 'Face', 'Throat', 'Swallow'),\n"
                                    +"('The Da Vinci Code opens with a murder in which famous museum?', 7, 'British Museum', 'Eiffel Tower', 'Notre Dame', 'Le Louvre', 'Glass Pyramid'),\n"
                                    +"('What is the worlds most expensive spice by weight?', 7, 'Pepper', 'Coriander', 'Gara Masala', 'Saffron', 'Red'),\n" 
                                    +"('What alcoholic drink is mainly made from juniper berries?', 7, 'Whisky', 'Wine', 'Vodka', 'Gin', 'Pirates'),\n"
                                    +"('Pure water has a pH level of around?', 7, 'Eight', 'Three', 'Five', 'Seven', '4+3x0+3'),\n"
                                   
                                    +"('What color dresses do Chinese women traditionally wear on their wedding day?', 8, 'Blue', 'Orange', 'Black', 'Red', 'Dragon'),\n"
                                    +"('What country is bordered by Germany, the Czech Republic, Slovakia, and Ukraine?', 8, 'Lithuania', 'Estonia', 'Austria', 'Poland', 'North/South'),\n"
                                    +"('What colors are the Norwegian flag? ', 8, 'Green and blue', 'Black and red', 'Orange, white, and purple', 'Red, white, and blue', 'Rule Brittania'),\n"
                                    +"('Which is the highest waterfall in the world?', 8, 'Niagra Falls', 'Super Falls', 'Ultimate Falls', 'Angel Falls', 'Godly'),\n"
                                    +"('Who is Green Lantern’s nemesis?', 8, 'Kryptonite', 'Lex Luthor', 'Ultron', 'Sinestro', 'S'),\n"
                                    +"('Which American state is the largest (by area)?', 8, 'New York', 'Florida', 'Texas', 'Alaska', 'Cold'),\n"
                                    +"('What is the smallest country in the world?', 8, 'Estonia', 'New Zealand', 'Singapore', 'Vatican City', 'Holy'),\n"
                                    +"('Which city in India would you find the Taj Mahal in?', 8, 'New Delhi', 'Bombay', 'Mumbai', 'Agra', 'Aqua'),\n"
                                    +"('What holiday is called “turkey day”?', 8, 'Christmas', 'Independance Day', 'New Years', 'Thanksgiving Day', 'Thank you'),\n"
                                    +"('Which country did AC/DC originate in?', 8, 'U.S.A.', 'England', 'Pakistan', 'Australia', 'Struth'),\n"
                                   
                                    +"('In which of Britney’s video does she appear as a stewardess?', 9, 'Womanizer', 'Llama', 'Despacito', 'Toxic', 'Poisonous'),\n"
                                    +"('Carrots are a good source of which vitamin?', 9, 'Vitamin B', 'Vitamin C', 'Vitamin X', 'Vitamin A', 'A'),\n"
                                    +"('What is the driest continent?', 9, 'Africa', 'South America', 'Europe', 'Antarctica', 'Cold Desert'),\n"
                                    +"('A flamboyance is a group of what animals?', 9, 'Otters', 'Crows', 'Magpies', 'Flamingos', 'Same letter'),\n"
                                    +"('New York City comprises how many boroughs?', 9, '1', '3', '6', '5', '4+8x0+1'),\n"
                                    +"('Where did the pineapple plant originate?', 9, 'Africa', 'Europe', 'Antarctica', 'South America', 'Amazon'),\n"
                                    +"('What country won the very first FIFA World Cup in 1930?', 9, 'Brazil', 'England', 'Ireland', 'Uruguay', 'Small'),\n"
                                    +"('Which racer holds the record for the most Grand Prix wins?', 9, 'Lewish Hamilton', 'Al Gore', 'Novak Djokovic', 'Michael Schumacher', 'German'),\n"
                                    +"('Which name is rapper Sean Combs better known by?', 9, '50 Cent', 'Lil Wayne', 'Tupac', 'P. Diddy', 'Least popular'),\n" 
                                    +"('Which British girl group had a member by the name of Mel B?', 9, 'The Beatles', 'Little Mix', 'One Direction', 'Spice Girls', 'Beckham'),\n"
                                  
                                    +"('What or who is the Ford Mustang named after?', 10, 'Boat', 'Race Horse', 'Gun', 'Fighter plane', 'Combat'),\n"
                                    +"('How many parts (screws and bolts included) does the average car have?', 10, '50,000', '1,000,000', '5000', '30,000', 'Think harder'),\n"
                                    +"('What does the acronym AIDS stand for?', 10, 'Actual Imune Decrease Sydrome', 'Health AID', 'And It Dont Stop', 'Acquired Immune Deficiency Syndrome', 'Immunity'),\n"
                                    +"('What animal is on Levi’s logo?', 10, 'Dog', 'Snake', 'Rabbit', 'Horse', 'Neigh'),\n"
                                    +"('Who is the writer of “Merchant of Venice”?', 10, 'J.k. Rowling', 'J.R.R. Tolkien', 'C.S. Lewis', 'William Shakespeare', 'Old'),\n"
                                    +"('“Adventure of Sherlock Holmes” was written by which writer?', 10, 'Albert Einsein', 'William Shakespeare', 'Charlie Higgins', 'Arthur Conan Doyle', '3'),\n"
                                    +"('Which country is Aesop’s Fables believed to originate in?', 10, 'Israel', 'Turkey', 'England', 'Greece', 'Gyros'),\n"
                                    +"('How many films did Sean Connery play James Bond in?', 10, '5', '4', '0', '7', '10-3+4x0'),\n"
                                    +"('Which Indiana Jones movie was released back in 1984?', 10, 'Lost Compass', 'Two Towers', 'Rairers of the Lost Ark', 'Temple of Doom', 'Doom'),\n"
                                    +"('Tanks were used in battle for the first time in which conflict?', 10, 'Crusades', 'World War 2', 'Desert Storm', 'World War 1', 'Earlyish'),\n"
                                  
                                    +"('Who wrote songs for The Lion King?', 11, 'Hans Zimmer', 'John Lennon', 'Bob Dylan', 'Elton John', 'English'),\n"
                                    +"('What U.S. newspaper is nicknamed “the Gray Lady”?', 11, 'Washington Post', 'Daily Caller', 'CNN', 'The New York Times', 'A big city'),\n"
                                    +"('As what type of beans are chickpeas, also known as?', 11, 'Green', 'Pod', 'Quesedilla', 'Garbanzo', 'Spanish'),\n"
                                    +"('In what year was the first episode of South Park aired?', 11, '2001', '2004', '1994', '1997', 'Pre-9/11'),\n"
                                    +"('Which actor appeared in films “Face Off” and “Ghost Rider”?', 11, 'Brad Pitt', 'Al Pacino', 'Tobey McGuire', 'Nicholas Cage', 'National Treasure'),\n"
                                    +"('Which actress won the Oscar for Best Actress in 2003?', 11, 'Angelina Jolie', 'Meryll Streep', 'Madonna', 'Nicole Kidman', 'Austrlian'),\n"
                                    +"('Who has been the longest-serving monarch of the United Kingdom?', 11, 'Queen Elizabeth I', 'Queen Victoria II', 'King Hengy VIII', 'Queen Elizabeth II', 'Current'),\n"                                    
                                    +"('World War I began with the death of Archduke Franz Ferdinand, of which country?', 11, 'Germany', 'Belgium', 'Hungary', 'Austria', 'Mountainous'),\n"
                                    +"('What’s the scientific name of a wolf?', 11, 'Equus caballus', 'Acinonyx jubatus', 'Ajaja ajaja', 'Canis lupus', 'Remus Lupin'),\n" 
                                    +"('Which warrior’s weakness was their heel?', 11, 'alien', 'cry', 'game', 'Achilles', 'poop'),\n"
                                    
                                    +"('In ancient Greece, throwing an apple at someone was a declaration of what?', 12, 'War', 'Hatred', 'Peace', 'Love', 'Romantic'),\n"
                                    +"('Which insect can indicate the air temperature?', 12, 'Frog', 'Cockroach', 'Wasp', 'Cricket', 'Wickets'),\n"
                                    +"('Blueberries are native to which continent?', 12, 'Africa', 'Europe', 'Oceania', 'North America', 'Cherokee'),\n"
                                    +"('In what year was McDonalds founded?', 12, '1960', '1959', '1963', '1955', 'After War'),\n"
                                    +"('What was the original name of the search engine Google?', 12, 'Alien', 'GoGo', 'Bing', 'BackRub', 'Rub'),\n"
                                    +"('What did the Crocodile swallow in Peter Pan?', 12, 'Bullet', 'Bomb', 'Cat', 'Alarm clock', 'Tick Tock'),\n"
                                    +"('How many hearts does an octopus have?', 12, 'Four', 'Eight', 'One', 'Three', '3x'),\n"
                                    +"('How many eyes does a bee have?', 12, 'Three', 'Four', 'One', 'Five', 'Most'),\n"
                                    +"('Which mammal has no vocal cords?', 12, 'Zebra', 'Lion', 'Gibbon', 'Giraffe', 'Tall'),\n"
                                    +"('How many notes are there on a standard grand piano?', 12, '65', '23', '120', '88', '8x11'),\n"
                                    
                                    +"('The largest political party in South Africa, the ANC, stands for what?', 13, 'African Nations Congress', 'African Nations Combined', 'African Natural Conserve', 'African National Congress', 'ANC'),\n"
                                    +"('Before the laws were changed in 2000, how long was a French president’s term?', 13, 'Two years', 'Three years', 'Ten years', 'Seven years', '7'),\n"
                                    +"('How many phases of the moon are there?', 13, 'Four', 'Two', 'One', 'Eight', 'Many'),\n"
                                    +"('What did Queen Anne die of?', 13, 'Cancer', 'Murder', 'Drowning', 'A stroke', 'Soft'),\n"
                                    +"('What year was Queen Elizabeth II born?', 13, '1930', '1945', '1900', '1926', '95 now'),\n"
                                    +"('What is the Hawaiian name for yellowfin tuna?', 13, 'Tuna', 'Blue', 'Honolulu', 'Ahi', 'Ahi'),\n"
                                    +"('The traditional Wimbledon colors are green, and what?', 13, 'Orange', 'Yellow', 'Blue', 'Purple', 'Royal'),\n"
                                    +"('Robin Williams won a best supporting actor Oscar for what film?', 13, 'Flubber', 'Troy', 'iRobot', 'Good Will Hunting', 'Scholarly'),\n"
                                    +"('What is the romanized Arabic word for moon?', 13, 'Allah', 'Hamza', 'Kufar', 'Qamar', 'Q'),\n"
                                    +"('What is the name of the home of the Greek Gods?', 13, 'Athens', 'Heaven', 'Elusium', 'Olympus', 'Olympics'),\n" 
                                 
                                    +"('What is the last letter of the Greek alphabet?', 14, 'Beta', 'Delta', 'Sigma', 'Omega', 'Fish Oil'),\n"
                                    +"('What country produced the most strawberries in 2016?', 14, 'Mexico', 'Uruguay', 'Russia', 'China', 'Production'),\n"
                                    +"('What candy was used to lure E.T. in the 1982 movie “E.T.: The Extra-Terrestrial”?', 14, 'Space Raiders', 'Chocolate', 'Sherbert', 'Reeces Pieces', 'Peanut'),\n"
                                    +"('In what American state is it illegal to dress up like a priest or a nun?', 14, 'Texas', 'Oklahoma', 'Florida', 'Alabama', 'South'),\n"
                                    +"('In what country did carving jack o’ lanterns originate?', 14, 'Ghana', 'England', 'Russia', 'Ireland', 'Clover'),\n"
                                    +"('Which nuts are used to make marzipan?', 14, 'Brazil', 'Hazelnuts', 'Peanuts', 'Almonds', 'Eye-Shaped'),\n"
                                    +"('What is the most abundant metal in the Earth’s crust?', 14, 'Iron', 'Bronze', 'Gold', 'Aluminium', 'Airplanes'),\n"
                                    +"('What blood type qualifies as a universal donor?', 14, 'O positive', 'B negative', 'A positive', 'O negative', 'O-'),\n"
                                    +"('Which US state has the longest cave system in the world?', 14, 'Alabama', 'California', 'South Dakota', 'Kentucky', 'Fried chicken'),\n"
                                    +"('The Eiffel Tower was originally intended for what city?', 14, 'Rome', 'London', 'Athens', 'Barcelona', 'Paella'),\n"
                                  
                                    +"('What’s the brightest star in the sky?', 15, 'Northern', 'Aquarius', 'Asparagus', 'Sirius', 'Black'),\n"
                                    +"('Squab is a name given to the young of which bird?', 15, 'Crow', 'Magpie', 'Sparrow', 'Pigeon', 'London'),\n"
                                    +"('If a male donkey is a jack, what is the female called?', 15, 'Jane', 'Jill', 'James', 'Jenny', 'Jenny'),\n"
                                    +"('What is “jaggery” used in Indian cooking?', 15, 'Butter', 'Onion', 'Salt', 'Sugar', 'Honey'),\n"
                                    +"('What TV show won the most Emmys in 2018?', 15, 'Walking Dead', 'Breaking Bad', 'Ozark', 'Game of Thrones', 'Fantasy'),\n"
                                    +"('What did the first vending machine dispense?', 15, 'Condoms', 'Fruit', 'Deodorant', 'Holy water', 'Priests'),\n"
                                    +"('What U.S. President coined the phrase “Good to the last drop,” referring to coffee?', 15, 'Donald J. Trump', 'George Bush', 'John F. Kennedy', 'Theodore Roosevelt', 'Teddy'),\n"
                                    +"('On every continent, there is a city named what?', 15, 'London', 'Athens', 'Milan', 'Rome', 'Caesar'),\n"
                                    +"('Which name are the Sandwich Islands, better known as?', 15, 'New Zealand', 'Mauritius', 'Haiti', 'Hawaii', 'Aloha'),\n"
                                    +"('Which fashion designer was shot dead in the summer of 1997?', 15, 'Tom Ford', 'Louis Vuitton', 'Herbert Supreme', 'Gianni Versace', 'Italiano')"
            
            );
            this.statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getNextException());
        }
    }
    public void closeConnection() {
        this.dbManager.closeConnections();
    }

}
