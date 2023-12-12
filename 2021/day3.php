<?php
$file = fopen("inputs/day3.txt", "r");
// if ($file) {
//     $countOfOnes = [];
//     $totalLines = 0;
//     while (($line = fgets($file)) !== false) {
//         $index = 0;
//         $digits = str_split($line);
//         foreach($digits as $digit){
//             $countOfOnes[$index]+=intval($digit);
//             $index++;
//         }
//         $totalLines++;
//     }
//     $gamma = $epsilon = '';
//     for($index=0; $index<=count($countOfOnes)-3; $index++){
//         $gamma .= $countOfOnes[$index] > $totalLines-$countOfOnes[$index] ? '1' : '0';
//         $epsilon .= $countOfOnes[$index] < $totalLines-$countOfOnes[$index] ? '1' : '0';
//     }
//     echo(bindec($gamma)*bindec($epsilon));
//     fclose($file);
// }

// ====================== day 3 : part 2 ====================== \\

if ($file) {
    $datas = [];
    while (($line = fgets($file)) !== false) {
        $datas[] = $line;
    }
    fclose($file);

    $fewerValues = $moreValues = $datas;
    $tempFewer = $tempMore = [];
    $index = 0;
    while(count($moreValues)>1 && count($fewerValues)>1){
        foreach($moreValues as $value){
            if($value[0][$index]=='1') $tempMore[] = array_fill(0,1,  $value[0]);
            else $tempFewer[] = array_fill(0,1,  $value[0]);
        }

        $moreValues = count($tempMore)>=count($tempFewer) ? $tempMore : $tempFewer;

        echo $value," - ",$value[0][$index]," : ",$index;

        foreach($fewerValues as $value){
            if($value[0][$index]=='1') $tempMore = array_fill(0,1,  $value[0]);
            else $tempFewer[] = array_fill(0,1,  $value[0]);
        }

        $fewerValues = count($tempFewer)<count($tempMore) ? $tempFewer : $tempMore;
        $index++;
        $tempFewer = $tempMore = [];
    }
}