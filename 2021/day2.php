<?php
// $file = fopen("inputs/day2.txt", "r");
// if ($file) {
//     $horizontal = $depth = 0;
//     while (($line = fgets($file)) !== false) {
//         $data = explode(" ", $line);
//         switch($data[0]){
//             case 'up':
//                 $depth-=$data[1];
//                 break;
//             case 'down':
//                 $depth+=$data[1];
//                 break;
//             default :
//                 $horizontal+=$data[1];
//         }
//     }
//     echo($horizontal*$depth);
//     fclose($file);
// }

// ====================== day 2 : part 2 ====================== \\

$file = fopen("inputs/day2.txt", "r");
if ($file) {
    $depth = $horizontal = $aim = 0;
    while (($line = fgets($file)) !== false) {
        $data = explode(" ", $line);
        switch($data[0]){
            case 'up':
                $aim-=$data[1];
                break;
            case 'down':
                $aim+=$data[1];
                break;
            default :
                $horizontal+=$data[1];
                $depth+=$aim*$data[1];
        }
    }
    echo($horizontal*$depth);
    fclose($file);
}
