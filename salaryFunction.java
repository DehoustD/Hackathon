import java.text.DecimalFormat;

public class salaryFunction {

    public static void main(String[] args) {

        // args[0] = nom fonction
        // args[1] = salaire
        // args[2] = periode
        // args[3] = commune
        // args[4] = prenom
        // args[5] = nom

        switch (args[0]) {
            case "SalaireBrutVersNet":
                float value = Float.parseFloat(args[1]);
                SalaireBrutVersNet(value, args[3], args[2], args[5], args[4]);
                break;
            case "SalaireNetVersBrut":
                System.err.println("Fonction " + args[0] + " inconnue.");
                break;
            default:
                System.err.println("Fonction " + args[0] + " inconnue.");
                break;
        }
    }

    static float SetCommuneTaxPercent(String _commune) {
        switch (_commune) {
            case "Bruxelles":
                return 6.0f;
            case "Mons":
                return 8.0f;
            case "Anvers":
                return 8.0f;
            default:
            System.err.println("ERREUR -> commune");
                return 0.0f;
        }
    }

    static void SalaireBrutVersNet(float _salary, String _com, String _period, String _name, String _forname) {

        //String _commune = _com;
        String _perdiode = _period; // mensuel ou annuel
        int _perdiodMult = 1;

        switch (_perdiode) {
            case "mensuel":
                _perdiodMult = 1;
                break;
            case "annuel":
                _perdiodMult = 12;
                break;
        }

        float _taxONSSPercent = 5.67f;
        float _taxONSS = 0.0f;

        float _taxRevenuPercent = 0.0f;
        float _taxRevenu = 0.0f;

        float _taxCommunalePercent = 6.59f;
        float _taxCommunale = 0.0f;
        _taxCommunalePercent = SetCommuneTaxPercent(_com);

        float _taxCSSS = 8.04f;

        float _result = 0.0f;

        DecimalFormat _decimalFormatA = new DecimalFormat("#.#");

        _taxRevenuPercent = TaxPercentCalc(_salary);

        _taxONSS = Percent(_salary, _taxONSSPercent);
        _taxRevenu = Percent(_salary, _taxRevenuPercent);
        _taxCommunale = Percent(_salary, _taxCommunalePercent);

        _result = _salary - (_taxONSS + _taxRevenu + _taxCommunale + _taxCSSS);

        System.out.println("Nom : " + _name +
                "<br aria-hidden=\"true\">\nPrénom : " + _forname +
                "<br aria-hidden=\"true\">\nSalaire brut : " + _salary +
                "<br aria-hidden=\"true\">\nCommune : " + _com +
                "<br aria-hidden=\"true\">\nPerdiode : " + _perdiode +
                "<br aria-hidden=\"true\">" +
                "<br aria-hidden=\"true\">\nONSS (Office National Sécurité Sociale) (" + _taxONSSPercent + "%) : -"
                + _decimalFormatA.format(_taxONSS) +
                "<br aria-hidden=\"true\">\nImpôt sur le revenu (" + (int) _taxRevenuPercent + "%) : -" + _taxRevenu +
                "<br aria-hidden=\"true\">\nTaxe communale (" + _taxCommunalePercent + "%) : -" + _taxCommunale +
                "<br aria-hidden=\"true\">\nCSSS (Cotisation Spéciale á la Sécurité Sociale) : -"
                + (_taxCSSS * _perdiodMult) + "<br aria-hidden=\"true\">\nImpôt total = -"
                + (_taxONSS + _taxRevenu + _taxCommunale + (_taxCSSS * _perdiodMult)) +
                "<br aria-hidden=\"true\">\n\nSalaire net : " + _decimalFormatA.format(_result));
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
    static float Percent(float _value, float _percent) {
        return _value / 100 * _percent;
    }
}