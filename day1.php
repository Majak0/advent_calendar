<?php
    $file = fopen("inputs/day1.txt","r") or die('file not founded');
    echo fread($file,filesize("inputs/day1.txt"));