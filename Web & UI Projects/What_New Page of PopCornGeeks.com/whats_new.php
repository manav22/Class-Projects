<?php
$apikey = 'kvemceqq4swkzk9am5w7h6p9';
 // make sure to url encode an query parameters

// construct the query with our apikey and the query we want to make

$endpoint = 'http://api.rottentomatoes.com/api/public/v1.0/lists/movies/in_theaters.json?page_limit=16&page=1&country=us&apikey='. $apikey;

// setup curl to make a call to the endpoint
$session = curl_init($endpoint);

// indicates that we want the response back
curl_setopt($session, CURLOPT_RETURNTRANSFER, true);

// exec curl and get the data back
$data = curl_exec($session);

// remember to close the curl session once we are finished retrieveing the data
curl_close($session);
//print_r($data);
// decode the json data to make it easier to parse the php
$search_results = json_decode($data);
if ($search_results === NULL) die('Error parsing json');


// play with the data!
$movies = $search_results->movies;


echo '<h2 style="text-align:center;">Now in Theatres</h2>';
foreach ($movies as $movie) {
	
	echo '<div style="margin:15px;">';
	echo "<hr>";
	
echo '<div style="float:left; border:0.5px solid black;"><a href="'.$movie->links->alternate.'" target="_blank"><img src="'.$movie->posters->original.'"></a></div>';
	
  
  echo '<div style="float:left;margin-left:20px;"><a href="' . $movie->links->alternate . '" target="_blank">' . $movie->title . " (" . $movie->year . ")</a></div>";

 
	echo "<br>";
	
	
	echo "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	echo "Critics Score: ".$movie->ratings->critics_score;
	echo "<br>";
	echo "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	echo "Audience Score: ".$movie->ratings->audience_score;
	echo "<br>";
	echo "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	echo "MPAA Rating : ".$movie->mpaa_rating;	
	
	echo "<br>";
		
	echo '</div>';

}




?>
