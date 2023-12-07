<?php
$file = fopen("2021/inputs/day1.txt", "r");
if ($file) {
    $level = $largerMeasurements = 0;
    while (($line = fgets($file)) !== false) {
        if ($line > $level) $largerMeasurements++;
        $level = $line;
    }
    echo($largerMeasurements-1);
    fclose($handle);
}