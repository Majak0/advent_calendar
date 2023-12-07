<?php
/*
$file = fopen("2021/inputs/day1.txt", "r");
if ($file) {
    $level = $largerMeasurements = 0;
    while (($line = fgets($file)) !== false) {
        if ($line > $level) $largerMeasurements++;
        $level = $line;
    }
    echo($largerMeasurements-1);
    fclose($file);
}
*/

// ====================== day 1 : part 2 ====================== \\

$file = fopen("inputs/day1.txt", "r");

if ($file) {
  $largerMeasurements = 0;
  $answer = $previous = $current = 0;
  $tempDepths = [];

  while (($depth = fgets($file)) !== false) {
    $depth = (int) $depth;
    $tempDepths[] = $depth;
  }

  for ($i = 0; $i < count($tempDepths) - 3; $i++) {
    $previous = $tempDepths[$i] + $tempDepths[$i + 1] + $tempDepths[$i + 2];
    $current = $tempDepths[$i + 1] + $tempDepths[$i + 2] + $tempDepths[$i + 3];

    if ($current > $previous) {
      $answer++;
    }
  }
  echo $answer;
}