<?php

echo findSum2020()." | ".findSecondSum2020();

// Part 1 \\
function findSum2020(){
    $file = fopen("inputs/day1.txt", "r");
    if ($file) {
        $datas = [];
        while (($line = fgets($file)) !== false) {
            $datas[] = $line;
        }
        foreach($datas as $firstValue){
            foreach($datas as $secondValue){
                if($firstValue+$secondValue==2020) return $firstValue*$secondValue;
            }
        }
    }
    fclose($file);
}

// Part 2 \\
function findSecondSum2020(){
    $file = fopen("inputs/day1.txt", "r");
    if ($file) {
        $datas = [];
        while (($line = fgets($file)) !== false) {
            $datas[] = $line;
        }
        foreach($datas as $firstValue){
            foreach($datas as $secondValue){
                foreach ($datas as $thirdValue) {
                    if($firstValue+$secondValue+$thirdValue==2020) return $firstValue*$secondValue*$thirdValue;
                }
            }
        }
    }
    fclose($file);
}
