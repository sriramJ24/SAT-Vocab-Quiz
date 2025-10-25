import java.util.Random;
import java.util.Scanner;

public class Vocab {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // SAT Vocabulary words
        String[] wordList = {
            "ubiquitous", "ephemeral", "pragmatic", "eloquent", "diligent",
            "resilient", "concise", "authentic", "profound", "versatile"
        };
        
        // Corresponding definitions
        String[] definitionList = {
            "present, appearing, or found everywhere",
            "lasting for a very short time; transitory",
            "dealing with things sensibly and realistically",
            "fluent or persuasive in speaking or writing",
            "having or showing care and conscientiousness in one's work",
            "able to withstand or recover quickly from difficult conditions",
            "giving a lot of information clearly and in a few words",
            "of undisputed origin and not a copy; genuine",
            "very great or intense; deep",
            "able to adapt or be adapted to many different functions or activities"
        };
        
        System.out.println("=== SAT Vocabulary Quiz ===");
        System.out.println("You will be given 10 SAT word definitions.");
        System.out.println("Type in the word that matches the definition and press Enter.");
        System.out.println();
        
        int score = 0;
        Random random = new Random();
        
        // Create an array to track which questions have been asked
        boolean[] asked = new boolean[wordList.length];
        int questionsAsked = 0;
        
        while (questionsAsked < wordList.length) 
        {
            // Pick a random question that hasn't been asked yet
            int randomIndex;
            do {
                randomIndex = random.nextInt(wordList.length);
            } while (asked[randomIndex]);
            
            asked[randomIndex] = true;
            questionsAsked++;
            System.out.println("Question " + questionsAsked + ": What word matches this definition: '" + definitionList[randomIndex] + "'?");
            System.out.print("Your answer: ");
            String userAnswer = input.nextLine();
            
            System.out.println("Correct word: " + wordList[randomIndex]);
            
            // matching to not be case sensitive
            if (userAnswer.toLowerCase().contains("correct") || wordList[randomIndex].toLowerCase().contains(userAnswer.toLowerCase()) || userAnswer.toLowerCase().contains(wordList[randomIndex].toLowerCase()))
            {
                System.out.println("Correct");
                score++;
            } 
            else 
            {
                System.out.println("Incorrect");
            }
            System.out.println();
        }
        
        System.out.println("=== Quiz Complete ===");
        System.out.println("Your score: " + score + " out of " + wordList.length);
        System.out.println("Percentage: " + (score * 100 / wordList.length) + "%");
        
        if (score >= 8) {
            System.out.println("Excellent! Great job!");
        } else if (score >= 6) {
            System.out.println("Good work! Keep studying!");
        } else {
            System.out.println("Keep practicing! Review the words and try again.");
        }

        for (int i = 0; i  < wordList.length; i++)
        {
            System.out.print(wordList[i]);
            System.out.println("   " + definitionList[i]);
        }

        // Ask if user wants to retake the quiz
        System.out.println();
        System.out.print("Would you like to take the quiz again? (yes/no): ");
        String retakeChoice = input.nextLine().toLowerCase();
        
        if (retakeChoice.equals("yes") || retakeChoice.equals("y")) {
            System.out.println();
            System.out.println("=== Starting Quiz Again ===");
            // Recursive call to restart the quiz
            main(args);
        } else {
            System.out.println("Thank you for taking the SAT Vocabulary Quiz!");
        }

        input.close();
    }
}