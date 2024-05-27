import java.util.Formatter;
import javax.swing.JOptionPane;

public class Temperature_calc {

    public static void main(String[] args) {

        //deklaracja zmiennych
        String first_name = fname_validation();
        String second_name = sname_validation();
        double temp_C = temp_validation();
        double temp_F = fahrenheit(temp_C);
        double temp_K = kelvin(temp_C);

        //wywołanie metody "show_data"
        show_data(first_name, second_name, temp_C, temp_F, temp_K);
    }

    //metoda dla wprowadzenia i sprawdzenia imienia
    public static String fname_validation() {
        while (true) {
            String fname = JOptionPane.showInputDialog("Podaj imię: ");
            if (fname.matches("[\\p{L}'\\- ]+") && fname.trim().length() >= 2) {
                return fname;
            } else {
                JOptionPane.showMessageDialog(null, "Imię musi składać się z co najmniej dwóch znaków i nie może zawierać cyfr.");
            }
        }
    }

    //metoda dla wprowadzenia i sprawdzenia nazwiska
    public static String sname_validation() {
        while (true) {
            String sname = JOptionPane.showInputDialog("Podaj nazwisko: ");

            if (sname.matches("[\\p{L}'\\- ]+") && sname.trim().length()>=2) {
                return sname;
            } else {
                JOptionPane.showMessageDialog(null, "Nazwisko musi składać się z co najmniej dwóch znaków i nie może zawierać cyfr.");
            }
        }
    }

    //metoda dla wprowadzenia i sprawdzenia stopni Celsjusza
    public static double temp_validation() {
        while (true) {
            try {
                String cels = JOptionPane.showInputDialog("Podaj temperaturę (°C): ");
                return Double.parseDouble(cels);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Należy wpisać liczbę.");
            }
        }
    }

    //metoda dla przeliczania temperatury ze stopni Celsjusza na stopnie Fahrenheita
    private static double fahrenheit(double temp_celcius) {
        double temp_fahrenheit;

        temp_fahrenheit = ((temp_celcius*9.0)/5.0) + 32.0;

        return temp_fahrenheit;
    }

    //metoda dla przeliczania temperatury ze stopni Celsjusza na stopnie Kalvina
    private static double kelvin(double temp_celcius) {
        double temp_kelvin;

        temp_kelvin = temp_celcius + 273.15;

        return temp_kelvin;
    }

    //metoda dla wyświetlania wyników
    private static void show_data(String first_name, String second_name, double temp_c, double temp_f, double temp_k) {
        String result;

        //tworzenie obiektu do formatowania zmiennych
        Formatter formatting = new Formatter();
        formatting.format("<html><body><table><tr>Twoje imię i nazwisko: %s %s </tr><tr>Twoja temperatura wynosi: </tr>", first_name, second_name);
        formatting.format("<tr>- w stopniach Celsjusza: %s °C </tr>", temp_c);
        formatting.format("<tr>- w stopniach Fahrenheita: %s °F </tr>", temp_f);
        formatting.format("<tr>- w stopniach Kelvina: %s K </tr><table></body></html>", temp_k);
        result = formatting.toString();

        JOptionPane.showMessageDialog(null, result);

        formatting.close();
    }
}