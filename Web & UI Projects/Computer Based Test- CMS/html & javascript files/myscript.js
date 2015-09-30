		var videocount=0;
		var englishcount=0;
		var mathscount=0;
		var iterationcount=0;
	function loginFunction() 
	{
		var username = document.forms["login"]["username"].value;
		var password = document.forms["login"]["passwd"].value;
	   if (username=="manav" && password=="cmpe")
	   {
			window.location= 'firstquestion.html';
		}
		else
		{
			alert("Username or Password does not match. Please re-enter!");
			window.location= 'login.html';
		}
	}

	function checkAnswer() 
	{
		iterationcount=localStorage.getItem("iterationcount");
		if(iterationcount>0)
		{
		mathscount=localStorage.getItem("mathscount");
		englishcount=localStorage.getItem("englishcount");
		videocount=localStorage.getItem("videocount");
		}
		var data = document.getElementById('1');	
		var answer = data.getAttribute('data');
		var questiontype=data.getAttribute('data-type');
		if(document.getElementById(answer).checked)
		{
			if(questiontype=="video")
			{
				videocount++;
			}
			else if(questiontype=="english")
			{
				englishcount++;
			}
			else if(questiontype=="maths")
			{
				mathscount++;
			}
			
		}
		iterationcount++;
		localStorage.setItem("videocount", videocount);
		localStorage.setItem("englishcount", englishcount);
		localStorage.setItem("mathscount", mathscount);
		localStorage.setItem("iterationcount", iterationcount);
		
	}
	
	function scoreCalculator()
	{
		mathscount=localStorage.getItem("mathscount");
		englishcount=localStorage.getItem("englishcount");
		videocount=localStorage.getItem("videocount");
		document.getElementById("textbox1").value= mathscount;
		document.getElementById("textbox2").value= englishcount;
		document.getElementById("textbox3").value= videocount;
    } 
	
	function markFunction()
	{
		var i;
		for(i=1;i<=6;i++)
		{
		if(document.getElementById(i).checked)
		{
			var data = document.getElementById(i);	
		    var answer = data.getAttribute('data_value');
		    var marktype = data.getAttribute('data_marktype');
			
			if(marktype=="mark1")
				document.getElementById('mark1').innerHTML=" $"+answer+" " ;
			else if(marktype=="mark2")
				document.getElementById('mark2').innerHTML=" "+answer+" " ;
		}
		}
	}
	
	function finish()
	{
		localStorage.clear();
	
	}
	
 
 
