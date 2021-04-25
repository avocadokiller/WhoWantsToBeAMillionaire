/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whowantstobeamillionaire.gui;

import whowantstobeamillionaire.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author Sasha Buskin
 */  
public class WhoWantsToBeAMillionaire {

  
    Contestant a =  new Contestant(" ");
    FileController fc = new FileController(); 
    
    Integer lvl = Integer.valueOf(1);
    Question q = new Question();
    /*public static void main(String[] args) throws FileNotFoundException, IOException {
  
        
    
    fc.newQuestionFiles();
    fc.writeQuestionFiles(); 
    
    List<Contestant> contestants = new ArrayList();
    
    File f = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\WhoWantsToBeAMillionaire\\ContestantRecord.txt");
    if(!f.exists()) { 
    fc.newContestantFile();
    }
    
    String input = " ";    
    
    for(;;){
        System.out.println("WHO WANTS TO BE A MILLIONAIRE\n\nMAIN MENU\n\nPress:\n1 to play.\n2 to view previous games.\n3 to view Hall of Fame Millionaire Winner List™");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        if(input.equals("1")){
           
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            a =  new Contestant(name);

                if(QuestionEngine(randomQuestion(1), a)){
                    a.money += 100;
                    System.out.println("\nYou have: $"+a.money+"\n");

                    if(QuestionEngine(randomQuestion(2), a)){
                        a.money += 100;
                        System.out.println("\nYou have: $"+a.money+"\n"); 

                        if(QuestionEngine(randomQuestion(3), a)){
                            a.money += 100;
                            System.out.println("\nYou have: $"+a.money+"\n"); 

                            if(QuestionEngine(randomQuestion(4), a)){
                                a.money += 200;
                                System.out.println("\nYou have: $"+a.money+"\n"); 

                                if(QuestionEngine(randomQuestion(5), a)){
                                    a.money *= 2;
                                    System.out.println("\nYou have: $"+a.money+"\n"); 

                                    if(QuestionEngine(randomQuestion(6), a)){
                                        a.money *= 2;
                                        System.out.println("\nYou have: $"+a.money+"\n");

                                        if(QuestionEngine(randomQuestion(7), a)){
                                            a.money *= 2;
                                            System.out.println("\nYou have: $"+a.money+"\n"); 

                                            if(QuestionEngine(randomQuestion(8), a)){
                                                a.money *= 2;
                                                System.out.println("\nYou have: $"+a.money+"\n"); 

                                                if(QuestionEngine(randomQuestion(9), a)){
                                                    a.money *= 2;
                                                    System.out.println("\nYou have: $"+a.money+"\n"); 

                                                    if(QuestionEngine(randomQuestion(10), a)){
                                                        a.money *= 2;
                                                        System.out.println("\nYou have: $"+a.money+"\n"); 

                                                        if(QuestionEngine(randomQuestion(11), a)){
                                                            a.money *= 2;
                                                            System.out.println("\nYou have: $"+a.money+"\n");

                                                            if(QuestionEngine(randomQuestion(12), a)){
                                                                a.money += 61000;
                                                                System.out.println("\nYou have: $"+a.money+"\n"); 

                                                                if(QuestionEngine(randomQuestion(13), a)){
                                                                    a.money *= 2;
                                                                    System.out.println("\nYou have: $"+a.money+"\n"); 

                                                                    if(QuestionEngine(randomQuestion(14), a)){
                                                                        a.money *= 2;
                                                                        System.out.println("\nYou have: $"+a.money+"\n"); 

                                                                        if(QuestionEngine(randomQuestion(15), a)){
                                                                            a.money *= 2;
                                                                            System.out.println("\nYou have: $"+a.money+"\n"); 
                                                                                }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                        System.out.println("Congratulations, you finished with: $"+a.money);
                        fc.addContestantToFile(a);
                        System.out.println("\nPress enter to return to main.");
                        scanner.nextLine();
            }            
            
            if(input.equals("2")){
                
                System.out.println("\n---------------------GAME HISTORY--------------------");
              
                contestants = fc.FetchContestantList();
                
                if (contestants.isEmpty()){
                    System.out.println("No games yet!");
                }
                 
                else{
                     
                    String leftAlignFormat = "| %-15s | %-10s | %-10s |%n";

                        System.out.format("+-----------------+------------+---------------------+%n");
                        System.out.format("| Name            | Winnings   | Date & Time         |%n");
                        System.out.format("+-----------------+------------+---------------------+%n");
                        for (int i = 0; i < contestants.size(); i++) {
                            System.out.format(leftAlignFormat,contestants.get(i).name, contestants.get(i).money, contestants.get(i).date);
                        }
                        System.out.format("+-----------------+------------+---------------------+%n");
                    
                    
                    
                   // for (int i = 0; i < contestants.size(); i++) {
                    // System.out.println(contestants.get(i).name+" $"+contestants.get(i).money+" "+contestants.get(i).date);
                    // }
                 }
                System.out.println("\nPress enter to return to main.");
                scanner.nextLine();
            }
            
            if(input.equals("3")){
                
                System.out.println("\n -$-$-$-Hall of Fame Millionaire Winner List™-$-$-$-");
                List<Contestant> winners = new ArrayList();
                contestants = fc.FetchContestantList();
               
                for (int i = 0; i < contestants.size(); i++) {
                     if(contestants.get(i).money == 1000000){
                         winners.add(contestants.get(i));
                        }
                }
                if (winners.isEmpty()){
                    System.out.println("No winners yet!");
                }
                
                else{
               
                    String MillionaireListFormat = "$| %-24s | %-12s   |$%n";

                        System.out.format("$+--------------------------+-----------------------+$%n");
                        System.out.format("$| Winner                   | Date & Time           |$%n");
                        System.out.format("$+--------------------------+-----------------------+$%n");
                        for (int i = 0; i < winners.size(); i++) {
                            System.out.format(MillionaireListFormat,contestants.get(i).name, contestants.get(i).date);
                        }
                        System.out.format("$+--------------------------+-----------------------+$%n");
                        System.out.format(" -$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-$-%n");
                        //for (int i = 0; i < winners.size(); i++) {
                                                              
                      //  System.out.println(winners.get(i).name+" $"+winners.get(i).money+" "+winners.get(i).date);
                    //}
                }    
                
                System.out.println("\nPress enter to return to main.");
                scanner.nextLine();
            } 
    
            else if(!input.equals("1") && !input.equals("2") && !input.equals("3")){
                System.out.println("\nINVALID INPUT\n");
            }
                
        }
        }*/
                                                  
     
    public void UpdateQuestion(){
    
        if(this.lvl <= 15){
        this.q = randomQuestion();
        }
        
        
    }
public void addWinnings(){
        if(this.a.money == 0){
            this.a.money += 100;
        }
        else if(this.a.money == 200){
            this.a.money += 100;
        }
        else if(this.a.money == 300){
            this.a.money += 200;
        }
        else if(this.a.money == 64000){
            this.a.money += 61000;
        }
        else if(this.a.money == 1000000){
            
        }
        else{
            this.a.money *=  2;
        }
    }
public Question randomQuestion(){
        
        ObjectInputStream ois = null;
	//Integer lvl = new Integer(level);
        FileController fc = new FileController(); 
        List<Question> a = fc.FetchQuestionList(this.lvl);
        
        int randomNum = ThreadLocalRandom.current().nextInt(0, a.size());
        
        Question q = new Question();
        q = a.get(randomNum);       
                
        return q;
        
    } 
        
public static void InputQuestionToSystem() throws IOException{
        
         String question;
         int level;
         String wrong1, wrong2, wrong3, correct;
         String hint;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Question level /(1-15/):");
        level = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Question:");
        question = scanner.nextLine();
        System.out.println("Enter wrong answer 1:");
        wrong1 = scanner.nextLine();
        System.out.println("Enter wrong answer 2:");
        wrong2 = scanner.nextLine();
        System.out.println("Enter wrong answer 3:");
        wrong3 = scanner.nextLine();
        System.out.println("Enter correct answer:");
        correct = scanner.nextLine();
        System.out.println("Enter hint:");
        hint = scanner.nextLine();
        
        Question qq = new Question(question, level, wrong1, wrong2, wrong3, correct, hint);
        FileController a = new FileController();
        a.addQuestionToFile(qq, level);
        
    }
    
public static boolean QuestionEngine(Question a, Contestant b){
        
        String input;
        String[] answers = new String[]{a.correct,a.wrong1, a.wrong2, a.wrong3};
        ArrayList toShuffle = new ArrayList<>(Arrays.asList(answers));
        Collections.shuffle(toShuffle);
     
        System.out.println("+--------------------------------------------------------------------------------------------------------+");
        String title = "| Winnings: %-10d                    Name: %-20sLifelines: (50/50: "+b.fiftyFifty+"/1)  (Hint: "+b.hint+"/1) |%n";        
        System.out.format(title,b.money,b.name);
//System.out.println("| Winnings: $%15d                        Name: %15s                     Lifelines: 50/50: "+b.fiftyFifty+" Hint: "+b.hint+" |" b.money, b.name);
        questionPrinter(toShuffle, a);
        System.out.println("Enter \"50/50\", \"hint\" for respective lifelines.");
        
        Scanner scanner = new Scanner(System.in);
        
        for(;;){
            
            input = scanner.nextLine();
            
            if (input.equals("50/50")) {
                if( b.fiftyFifty == 1){
                
                LifeLine lifeline = new LifeLine();
                
                lifeline.fiftyFifty(toShuffle, a, b);
                
                input = scanner.nextLine();
            }
                else{
                           System.out.println("No 50/50 lifeline left!");
                input = scanner.nextLine();        
                }
            
            
             
            }
            if (input.toLowerCase().equals("hint")){
                if  (b.hint == 1){
                
                LifeLine lifeline = new LifeLine();
                
                lifeline.Hint(a, b);
                
                input = scanner.nextLine();
                }
                else{
                    System.out.println("No hint lifeline left!");
                    input = scanner.nextLine();
                }
            }
            
            
            if(input.equals("a") && toShuffle.get(0).equals(a.correct)){                
                    return true;
                }
            if(input.equals("b") && toShuffle.get(1).equals(a.correct)){                
                    return true;
                }
            if(input.equals("c") && toShuffle.get(2).equals(a.correct)){                
                    return true;
                }
            if(input.equals("d") && toShuffle.get(3).equals(a.correct)){                
                    return true;
                }
            else if (input.equals("d") || input.equals("b") || input.equals("c") || input.equals("a")){ 
                 return false;
            }
            else{
                System.out.println("INVALID INPUT. TRY AGAIN");   
             }
        }  
}
public static void questionPrinter(ArrayList toShuffle, Question a){ 
        String Table = "| %-50s| %-50s |%n";
        String QuestionFormat = "|  %-102s|%n";
        String QuestionNumberFormat = "|                                               %-57s|%n";              
                        System.out.format("+--------------------------------------------------------------------------------------------------------+%n");
                        System.out.format(QuestionNumberFormat,"Question "+a.level);
                        System.out.format("+--------------------------------------------------------------------------------------------------------+%n");
                        System.out.format(QuestionFormat,a.question);
                        System.out.format("+--------------------------------------------------------------------------------------------------------+%n");
                        
                        System.out.format(Table,"a. "+ toShuffle.get(0), "b. "+ toShuffle.get(1));
                        System.out.format(Table,"c. "+ toShuffle.get(2), "d. "+ toShuffle.get(3));
                        System.out.format("+--------------------------------------------------------------------------------------------------------+%n");
}
}

