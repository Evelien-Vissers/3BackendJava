import java.util.HashMap;

//4. Maak een nieuwe Translator class aan.
public class Translator {
    //5. Maak in de Translator class een HashMap<Integer, String> variabele genaamd 'numericAlpha'
    private final HashMap<Integer, String> numericAlpha; //Deze HashMap zal de numerieke waarden aan hun stringrepresentaties koppelen
//NB: hierboven "private FINAL" ervan gemaakt vanwege melding 'Field 'numericAlpha' may be 'final'. Zie regel

//6. Maak in de Translator class een constructor die de volgende parameters krijgt: (String[] alphabetic, Integer[] numeric).
    //Hiermee initialiseren we de HashMap met de gegeven arrays.
    public Translator(String[] alphabetic, Integer[] numeric) {
        numericAlpha = new HashMap<>();
//7. Schrijf in de constructor een for-loop die begint bij 0 en doorgaat tot de lengte van de numeric/alphabetic array (het maakt niet uit welke, ze zijn even lang).
        for (int i = 0; i < alphabetic.length; i++) {
//8. Voeg in de body van de for-loop een nieuwe entry toe aan de HashMap met de correcte waardes uit numeric en alphabetic.
// Gebruik de i variabele uit je for-loop om de correcte waardes uit de array te halen.
            numericAlpha.put(numeric[i], alphabetic[i]);
        }
    }
//10. Maak in de Translator class een nieuwe methode genaamd 'translate (integer number) die een String returnt.
    public String translate(int number) {
//11. In de body van de translate methode return je de waarde (value) uit de numericAlpha HashMap die hoort bij de sleutel (key) van 'number'.
//In deze methode wordt de 'getOrDefault' methode van de HashMap gebruikt om de waarde op te halen die overeenkomst met de sleutel 'number'.
//Als de sleutel niet bestaat in de map, wordt "onbekend nummer" geretourneerd als standaardwaarde.
        return numericAlpha.getOrDefault(number, "Onbekend nummer");
    }
}
