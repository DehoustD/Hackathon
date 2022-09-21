import java.text.DecimalFormat;

public class salaryFunction {

    public static void main(String[] args) {

        if(args[0].equals("SalaireBrutVersNet")){
            float value = Float.parseFloat(args[1]);
            SalaireBrutVersNet(value);
        }

        if(args[0].equals("SalaireNetVersBrut")){

        } else {
            System.err.println("Fonction "+args[0]+" inconnue.");
        }
    }

    static void SalaireBrutVersNet(float _value){

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
                        "</br>\nImpôt sur le revenu (" + (int)_taxRevenuPercent + "%) : -" + _taxRevenu +
                        "</br>\nTaxe communale (" + _taxCommunalePercent + "%) : -" + _taxCommunale +
                        "<br/>\nCSSS (Cotisation Spéciale á la Sécurité Sociale) : -" + _taxCSSS +
                        "<br/>\nImpôt total = -" + (_taxONSS + _taxRevenu + _taxCommunale + _taxCSSS) +
                        "<br/>\n\nSalaire net : " + _decimalFormatA.format(_result));
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