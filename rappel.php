<?php
    $question=readline("Voulez vous encodeer un IMC ?");
    while ($question!='non')
    {
        if ($question=='oui')
    {
        $taille=readline("Quel est votre taille ?");
        $masse=readline("Quel est votre masse ?");
        $calcul=($masse/($taille*$taille));
        echo "Votre IMC = ".$calcul;
       

        if  ($calcul<18.5)
        {
            echo "\n Aller voir un médecin";
        }
    
        if($calcul>18.5 && $calcul<25)
        {
            echo "\n corpulence normal";
        }  
        
        $question=readline(" \n Voulez vous encore encodeer un IMC ?");
    
    }

    else
    {
        $question=readline(" \n Dites-moi oui ou non \n Voulez vous encore encodeer un IMC ?");

    }

   
    }
     


    
    echo "Merci et aurevoir";



?>