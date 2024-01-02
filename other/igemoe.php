<?php
$log = "Ouverture fichier entrée\n";
$file = fopen("datas/in", "r");

$sql = "SELECT lang FROM croisiere2018.lang_translation group by lang;";
//$langs = dataBaseGetAssoc($sql);
$log .= "\nLancement requête SQL\n";

$log .= "\nRécupérations ID sans carte image IGEMOE\n";
if ($file) {
    $lang = 'fr'; // Valeure de test
    $itinerairesID = [];
    $path = "/home/images/cartIgemoe/img/";
    while (($line = fgets($file)) !== false) {
        if(str_contains( $line,'"key":')){
            $line = preg_replace('/[^0-9.]/', '', $line);
            $itinerairesID[$line] = "/home/images/cartIgemoe/img/".$lang."/".$line;
        }
    }
    fclose($file);
}

$log .= "\nSuppression contenu fichier sortie\n";
$path = "datas/out";
$fileOut = fopen($path, "r+");
if ($fileOut !== false) {
    file_put_contents($path,null);
}

$log .= "\nEcriture dans fichier sortie\n";
foreach($itinerairesID as $id => $filename){
    if (!file_exists($filename)) file_put_contents($path,$id."\n", FILE_APPEND);
}
fclose($fileOut);
$log .= "\nFichier de sortie fermé\n";
// foreach($output as $key => $id){
//    UPDATE carte SET img=0 WHERE id_cruise=:id;
//    :id = $id;
//}
echo $log;