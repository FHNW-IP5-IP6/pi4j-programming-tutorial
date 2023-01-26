$markdowns = New-Object -TypeName "System.Collections.ArrayList"
$anchors = New-Object -TypeName "System.Collections.ArrayList"
$links = New-Object -TypeName "System.Collections.ArrayList"

$orLesson = get-content "$PSScriptRoot\Tutorial\section-info.yaml" -Encoding UTF8 | Select-Object -Skip 1

foreach($lesson in $orLesson){
    $lessonname = $lesson.Substring(2, $lesson.Length-2)
    $lessonpath = "$PSScriptRoot\Tutorial\$lessonname"
    $orTasks = get-content "$lessonpath\lesson-info.yaml" -Encoding UTF8 | Select-Object -Skip 1

    foreach($task in $orTasks){
        $taskname = $task.Substring(2, $task.Length-2)
        $taskpath = "$lessonpath\$taskname"

        $marktext = Get-Content "$taskpath\task.md" -Encoding UTF8 -Raw
        $oneliner = $marktext.Replace("`n","\n").Replace("'","")
        $anchor = $lessonname + "-" + $taskname

        $markdowns.add("document.getElementById('$anchor').innerHTML = marked.parse('$oneliner')")
        $anchors.Add("<div id='$anchor' class='chapter'></div><hr />")
        $links.Add("<li><a href='#$anchor'>$anchor</a></li>")
    }
}

$html = '<!doctype html>
<html>
<head>
  <meta charset="utf-8"/>
  <title>Leitfaden Report</title>
  <style>
  .chapter{
    background-color: #eeeeee;
    border: 2px solid black;
    padding: 20px;
    margin: 5px;
  }
  </style>
</head>
<body>
  <ul>
  '+$($links -join [Environment]::NewLine)+'
  </ul>
  <hr />
  '+$($anchors -join [Environment]::NewLine)+'
  <script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
  <script>
    '+$($markdowns -join [Environment]::NewLine)+'
  </script>
</body>
</html>'

$outputfolder = "$PSScriptRoot/Report"
mkdir $outputfolder -Force

$pics = Get-ChildItem -Path $PSScriptRoot -Recurse -File | Where-Object { $_ -match ".png" -or $_ -match ".jpg"} | select -Property FullName
foreach($pic in $pics){
    Copy-Item $pic.FullName -Destination $outputfolder
}

$html | Out-File "$outputfolder/report.html"
