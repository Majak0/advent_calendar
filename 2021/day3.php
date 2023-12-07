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
    $countOfOnes = [];
    while (($line = fgets($file)) !== false) {
        $index = 0;
        $digits = str_split($line);
        foreach($digits as $digit){
            $countOfOnes[$index]+=intval($digit);
            $index++;
        }
    }
    $gamma = $epsilon = '';
    for($index=0; $index<=count($countOfOnes)-3; $index++){
        $gamma .= $countOfOnes[$index] > 1000-$countOfOnes[$index] ? '1' : '0';
        $epsilon .= $countOfOnes[$index] < 1000-$countOfOnes[$index] ? '1' : '0';
    }
    echo(bindec($gamma)*bindec($epsilon));
    fclose($file);
}