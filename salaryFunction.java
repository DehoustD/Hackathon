import java.text.DecimalFormat;

public class salaryFunction {

    public static void main(String[] args) {

        // déclaration des variables
        boolean bool1 = false;

        //float taxPercent = 0.0f;
        float taxONSS = 5.67f;
        float taxRevenu = 0.0f;
        float taxCommunale = 0.0f;
        float parsedArgs0 = Float.parseFloat(args[0]);

        // choix du nombre de chiffres après la virgule.
        DecimalFormat decimalFormatA = new DecimalFormat("#.#");
        DecimalFormat decimalFormatB = new DecimalFormat("#.##");
        DecimalFormat decimalFormatC = new DecimalFormat("#.###");
        // POST-IT : System.out.println(decimalFormatA.format(float1));

        // execution du programme.

        if (args.length > 0) {

            taxRevenu = TaxPercentCalc(parsedArgs0);
            System.out.println("taxe : " + taxRevenu + "%" + "\ncalcul : " + (parsedArgs0 - TaxCalculation(parsedArgs0, taxRevenu)));

        } else {
            //System.err.println("Vous devez fournir au moins un paramètre, c'est à dire le nom d'une fonction !");
            System.err.println("Vous devez fournir un nombre comme paramètre !");
        }

    }

    // fonction qui calcul la taxe en pourcantage.
    static float TaxPercentCalc(float _value) {
        float _taxPercent = 0.0f;
        if (_value < 13440) {
            _taxPercent = 25;
        } else if (_value < 23720) {
            _taxPercent = 40;
        } else if (_value < 41060) {
            _taxPercent = 45;
        } else {
            _taxPercent = 50;
        }
        return _taxPercent;
    }

    // fonction qui applique le pourcentage à la valeur entrée.
    static float TaxCalculation(float _value, float _taxPercent) {
        return (_value / 100) * _taxPercent;
    }
}