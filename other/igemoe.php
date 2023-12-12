<?php

$file = fopen("datas/in", "r");
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

$output = [];
foreach($itinerairesID as $id => $filename){
    if (!file_exists($filename)) $output[] = $id;
}

print_r($output);