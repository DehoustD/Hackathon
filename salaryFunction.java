import java.text.DecimalFormat;

public class salaryFunction {

    public static void main(String[] args) {

        // args[0] doit etre égal à un nom de fonction.
        // args[1] peut etre le salaire.

        // déclaration des variables

        float input = Float.parseFloat(args[1]);

        boolean bool1 = false;

        float taxONSSPercent = 5.67f;
        float taxONSS = 0.0f;

        float taxRevenuPercent = 0.0f;
        float taxRevenu = 0.0f;

        float taxCommunalePercent = 6.59f;
        float taxCommunale = 0.0f;

        float taxCSSS = 8.04f;

        //float parsedArgs0 = Float.parseFloat(args[0]);

        // choix du nombre de chiffres après la virgule.
        DecimalFormat decimalFormatA = new DecimalFormat("#.#");
        DecimalFormat decimalFormatB = new DecimalFormat("#.##");
        DecimalFormat decimalFormatC = new DecimalFormat("#.###");
        // POST-IT : System.out.println(decimalFormatA.format(float1));

        // execution du programme.

        //if (args.length > 0) {

            // taxRevenuPercent = TaxPercentCalc(parsedArgs0);
            // taxRevenu = Percent(parsedArgs0, taxRevenuPercent);
            // taxONSS = Percent(parsedArgs0, taxONSSPercent);
            // taxCommunale = Percent(parsedArgs0, taxCommunalePercent);

            // System.out.println("\nONSS (Office National Sécurité Sociale) (" + taxONSSPercent + "%) : - " + decimalFormatA.format(taxONSS));

            // System.out.println("Impôt sur le revenu (" + (int)taxRevenuPercent + "%) : - " + taxRevenu);

            // System.out.println("Taxe communale (" + taxCommunalePercent + "%) : - " + taxCommunale);

            // System.out.println("CSSS (Cotisation Spéciale á la Sécurité Sociale) : - " + taxCSSS);

            // System.out.println("Impôt total = - " + (taxONSS + taxRevenu + taxCommunale + taxCSSS));

            // System.out.println("\nSalaire net : " + (parsedArgs0 - (taxONSS + taxRevenu + taxCommunale + taxCSSS)));

        //} else {
            //System.err.println("Vous devez fournir un nombre comme paramètre !");
        //}

        SalaireBrutVersNet(input);

    }

    static float SalaireBrutVersNet(float _value){

        float _taxONSSPercent = 5.67f;
        float _taxONSS = 0.0f;

        float _taxRevenuPercent = 0.0f;
        float _taxRevenu = 0.0f;

        float _taxCommunalePercent = 6.59f;
        float _taxCommunale = 0.0f;

        float _taxCSSS = 8.04f;

        float _result = 0.0f;

        DecimalFormat _decimalFormatA = new DecimalFormat("#.#");

        _taxRevenuPercent = TaxPercentCalc(_value);

        _taxONSS = Percent(_value, _taxONSSPercent);
        _taxRevenu = Percent(_value, _taxRevenuPercent);
        _taxCommunale = Percent(_value, _taxCommunalePercent);

        _result = _value - (_taxONSS + _taxRevenu + _taxCommunale + _taxCSSS);

        System.out.println("\nONSS (Office National Sécurité Sociale) (" + _taxONSSPercent + "%) : -" + _decimalFormatA.format(_taxONSS) +
                        "\nImpôt sur le revenu (" + (int)_taxRevenuPercent + "%) : -" + _taxRevenu +
                        "\nTaxe communale (" + _taxCommunalePercent + "%) : -" + _taxCommunale +
                        "\nCSSS (Cotisation Spéciale á la Sécurité Sociale) : -" + _taxCSSS +
                        "\nImpôt total = -" + (_taxONSS + _taxRevenu + _taxCommunale + _taxCSSS) +
                        "\n\nSalaire net : " + _result);
        return _result;
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
    static float Percent(float _value, float _percent){
        return _value / 100 * _percent;
    }
}