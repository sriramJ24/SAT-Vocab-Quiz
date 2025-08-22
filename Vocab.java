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
        System.out.println("You will be given 10 SAT words to define.");
        System.out.println("Type your definition and press Enter.");
        System.out.println();
        
        int score = 0;
        int counter = (int) (Math.random() * 10);

        for (int i = 0; i < wordList.length; i++) 
        {
            System.out.println("Question " + (i + 1) + ": What is the definition of '" + wordList[i] + "'?");
            System.out.print("Your answer: ");
            String userAnswer = input.nextLine();
            
            System.out.println("Correct definition: " + definitionList[i]);
            
            // Simple matching (case-insensitive)
            if (userAnswer.toLowerCase().contains("correct") || definitionList[i].toLowerCase().contains(userAnswer.toLowerCase()) || userAnswer.toLowerCase().contains(definitionList[i].toLowerCase().split(" ")[0]))
            {
                System.out.println("✓ Correct!");
                score++;
            } 
            else 
            {
                System.out.println("✗ Incorrect!");
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
    }
}