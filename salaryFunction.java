import java.text.DecimalFormat;

public class salaryFunction {

    public static void main(String[] args) {

        // déclaration des variables
        boolean bool1 = false;

        float taxONSSPercent = 5.67f;
        float taxONSS = 0.0f;

        float taxRevenuPercent = 0.0f;
        float taxRevenu = 0.0f;

        float taxCommunalePercent = 6.59f;
        float taxCommunale = 0.0f;

        float taxCSSS = 8.04f;
        float parsedArgs0 = Float.parseFloat(args[0]);

        // choix du nombre de chiffres après la virgule.
        DecimalFormat decimalFormatA = new DecimalFormat("#.#");
        DecimalFormat decimalFormatB = new DecimalFormat("#.##");
        DecimalFormat decimalFormatC = new DecimalFormat("#.###");
        // POST-IT : System.out.println(decimalFormatA.format(float1));

        // execution du programme.

        //if (args.length > 0) {

            taxRevenuPercent = TaxPercentCalc(parsedArgs0);
            taxRevenu = TaxCalculation(parsedArgs0, taxRevenuPercent);
            taxONSS = Percent(parsedArgs0, taxONSSPercent);
            taxCommunale = Percent(parsedArgs0, taxCommunalePercent);

            System.out.println("\nONSS (Office National Sécurité Sociale) (" + taxONSSPercent + "%) : - " + decimalFormatA.format(taxONSS));

            System.out.println("Impôt sur le revenu (" + (int)taxRevenuPercent + "%) : - " + taxRevenu);

            System.out.println("Taxe communale (" + taxCommunalePercent + "%) : - " + taxCommunale);

            System.out.println("CSSS (Cotisation Spéciale á la Sécurité Sociale) : - " + taxCSSS);

            System.out.println("Impôt total = - " + (taxONSS + taxRevenu + taxCommunale + taxCSSS));

            System.out.println("\nSalaire net : " + (parsedArgs0 - (taxONSS + taxRevenu + taxCommunale + taxCSSS)));

        //} else {
            //System.err.println("Vous devez fournir un nombre comme paramètre !");
        //}

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

    static float Percent(float _value, float _percent){
        return _value / 100 * _percent;
    }
}