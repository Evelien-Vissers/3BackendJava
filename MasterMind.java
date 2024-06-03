//Bonusopdracht: Mastermind is een spel waarbij je 4 verschillende random nummers moet raden. Als je een getal goed raadt en deze staat op de juiste plek, krijg je + als feedback.
//Komt het nummer helemaal niet voor, dan krijg je 'X' als feedback.
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Bonus {

    public static void main(String[] args) {

        // Onderstaande code is uitgecommentarieerd. Haal de code uit de comment (delete /* en */) om aan de slag te gaan met de bonus
        // In de code staan op verschillende plekken comments tussen "/*...*/" als hint wat je moet doen


        HashSet<Integer> secretnumber = randomnumbergenerator();
        String stringnumber = setToStringConverter(secretnumber);
        System.out.println(stringnumber);
        feedback(stringnumber);
    }
    //Methode die een HashSet met 4 random nummers returned.
    // --> Deze methode maakt gebruik van de 'Random' klasse om willekeurige getallen tussen 0 en 9 te genereren.
    // De getallen worden dan toegevoegd aan een 'HashSet' totdat de set 4 unieke getallen bevat.
    // De methode retourneert vervolgens deze 'HashSet'.
    /*
        Stappenplan:
        - Maak een nieuwe variabele van type Random. (Tip: Zoek op internet hoe je Random kunt gebruiken)
        - Maak een nieuwe variabele van type HashSet.
        - Schrijf een while-loop om 4 random nummers aan de hashset toe te voegen
        - return de hashset
         */
    public static HashSet<Integer> randomnumbergenerator(){
        Random random = new Random();
        HashSet<Integer> numbers = new HashSet<>();
        while(numbers.size() < 4){
            int number = random.nextInt(10); //--> Genereert een getal tussen 0 en 9
            numbers.add(number);
        }
        return numbers;
    }
    //Methode die een HashSet als parameter inneemt en een string van 4 nummers returned.
    //--> Deze methode neemt een 'HashSet' van 'Integer' als parameter en converteert deze naar een 'String'
    //De methode doorloopt de set en voegt elk getal toe aan een 'StringBuilder'
    //De resulterende string wordt geretourneerd.
    /*Stappenplan:
            - Maak als eerst een String variabele met als waarde een lege String. (of gebruik een StringBuilder)
            - Schrijf vervolgens een for-loop om de items in de hashset een voor een aan de String variabele toe te voegen.
        - Return de (gevulde) String variabele*/
    public static String setToStringConverter(HashSet<Integer> secretnumber){
        StringBuilder result = new StringBuilder();
        for (Integer num : set) {
            result.append(num);
        }
        return result.toString();
    }

//Feedback methode
    //Deze methode neemt de gegenereerde string en vergelijkt deze met de gok van de gebruiker.
    //De feedback wordt opgebouwd en aan de gebruiker getoond obv de overeenkomst tussen de gok en het geheime nummer.
    public static void feedback(String stringnumber) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder feedback = new StringBuilder();
        System.out.println("+ = juiste nummer op de juiste plek, O = juiste nummer verkeerde plek, X = verkeerde nummer");
        System.out.println("Doe een gok, Let op vul 4 getallen in.");
        String guess = scanner.nextLine();
        if (Objects.equals(guess, stringnumber)) {
            System.out.println("gefeliciteerd je hebt het goed");
        } else {
            for (int i = 0; i < 4; i++) {
                if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i + 1))) {
                    feedback.append("+");
                } else if (stringnumber.contains(guess.substring(i, i + 1))) {
                    feedback.append("0");
                } else {
                    feedback.append("X");
                }
            }
        }
        System.out.println(feedback.toString());
    }
}
/*Commentaar: hoewel er een HashSet is gebruikt om 4 unieke nummers te genereren, is het geen goede keuze voor deze opdracht.
Een HashSet zorgt er namelijk voor dat de volgorde van de cijfers willekeurig is, wat problemen kan veroorzaken bij het vergelijken van posities en cijfers.
Een betere keuze zou een ArrayList of een array zijn, waarbij de volgorde van de elementen behouden blijft.
 */
