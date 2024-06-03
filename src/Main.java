//onderdeel van vraag 12:
import java.util.Scanner;
//Pull request link: https://github.com/Evelien-Vissers/BackendJava3/pull/new/EAVissers
public class Main {
    public static void main(String[] args) {
        //2. Maak een Integer array genaamd 'numeric' en vul deze met nummers:
        Integer[] numeric = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        //3. Maak een String array genaamd 'alphabetic' en vul deze met de stringvarianten van de nummers:
        String[] alphabetic = {"een", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "nul"};

        //Voor opdracht 4 en 5, zie class 'Translator'.

        //9. Maak een translator object met de gegeven arrays
        Translator translator = new Translator(alphabetic, numeric);

        //Maak een nieuwe String array genaamd 'translated' en vul deze met de vertaalde waardes:
        String[] translated = new String[numeric.length];
        for (int i = 0; i < numeric.length; i++) {
            translated[i] = translator.translate(numeric[i]);
        }
        //Print de inhoud van beide arrays om te controleren
        System.out.print("Numeric array");
        for (int num : numeric) {
            System.out.print(num + " ");
        }
        System.out.print("\nAlphabetic array: "); //Met de aanpassing "\n" worden de arrays netjes onder elkaar afgedrukt, wat de uitvoer beter leesbaar maakt.
        for (String str : alphabetic) {
            System.out.print(str + " ");

            System.out.print("\nTranslated array: ");
            for (String translatedStr : translated) { //NB: 'str' aangepast naar 'trnaslatedStr', omdat de variabele 'str' als gedefnieert is in deze scope!
                //In Java kan je geen variabele met dezelfde naam opnieuw defnieren binnen dezelfde scope, daarom deze naam aangepast.
                System.out.print(translatedStr + " ");
            }
        }
        //12. Maak in de main methode van de Main class een boolean variabele genaamd 'play' met de waarde 'true'.
        boolean play = true;
        //12. Maak een String variabele genaamd 'ongeldig' waarin je de String 'ongeldige invoer' zet:
        String ongeldig = "ongeldige invoer";
        //12. Maak een nieuw Scanner object aan
        Scanner scanner = new Scanner(System.in);

        //13. Maak een while-loop die doorgaat zolang play 'true' is:
        while (play) {
            //14. Print in de while-loop "Type 'x' om te stoppen \nType 'v' om te vertalen"
            System.out.println("\nType 'x' om te stoppen");
            System.out.println("Type 'v' om te vertalen");
            //14. Maak een String variabele 'input' waarin je de waarde van 'scanner.nextLine()' opslaat:
            String input = scanner.nextLine();

            int number; //NB: deze toevoeging was nodig om de foutmelding "Cannot resolve symbol 'number'" op te lossen.
            // Hiermee is de declaratie van 'number' buiten de 'if (input.equals("v")'-blok geplaatst, zodat het binnen het hele 'while-blok' beschikbaar is.

            //15. Maak in de body van de while-loop een if/else if else statement:
            if (input.equals("x")) {
                //15(i). if: als de input "x" is, zet 'play' naar false:
                play = false;
            } else if (input.equals("v")) {
                //15(ii). Als de input 'v' is, vraag de gebruiker om een cijfer in te voeren:
                System.out.println("Type een cijfer in van 0 t/m 9:");
                number = scanner.nextInt(); //NB: Declarate van 'int number;' (regel 51) wordt hier toegewezen.
                //NB2: verwijderen van 'int' voor 'number' - want deze variabele is al gedeclareerd binnen dezelfde scope.
                //15(ii). Vervolgens sla je het resultaat van 'scanner.nextLine(); toe op de volgende regel:
                scanner.nextLine();
                //15(ii)Check met een if-statement of
                // (a) if: number < 10, dan sla je de waarde van 'translator.translate(number)' op in 'String result' en print je 'De vertaling van " + number + " is " + result;
                if (number >= 0 && number <= 9) {
                    String result = translator.translate(number);
                    System.out.println("De vertaling van " + number + " is " + result);
                } else {
                    // (b) else: anders dan print je 'ongeldig'
                    System.out.println(ongeldig);
                }
            } else {
                //15(iii) else: als de input iets anders is dan 'x' of 'v', dan print je ongeldig.
                System.out.println(ongeldig);
            }
        }
    }
}