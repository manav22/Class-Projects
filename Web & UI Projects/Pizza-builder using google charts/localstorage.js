    function save(){
        
        var pepperoni = document.getElementById("pepperoni").checked;
        var italian = document.getElementById("italian_sausage").checked;
        var slicedItalian = document.getElementById("sliced_italian").checked;
        var beef = document.getElementById("beef").checked;
        var phillySteak = document.getElementById("philly_steak").checked;
        var ham = document.getElementById("ham").checked;
        var bacon = document.getElementById("bacon").checked;
        var salami = document.getElementById("salami").checked;
        var chicken = document.getElementById("premium_chicken").checked;
        
        var pep_value = 0;
        var italian_value = 0;
        var sliced_value = 0;
        var beef_value = 0;
        var philly_value = 0;
        var ham_value = 0;
        var bacon_value = 0;
        var salami_value = 0;
        var chicken_value = 0;
        
        
        if(pepperoni){
            pep_value = 1;
        }
        else{
            pep_value = 0;
        }
        
        
        if(italian){
            italian_value = 1;
        }
        else{
            italian_value = 0;
        }
        
        
        if(slicedItalian){
            sliced_value = 1;
        }
        else{
            sliced_value = 0;
        }
        
        
        if(beef){
            beef_value = 1;
        }
        else{
            beef_value = 0;
        }
        
        
        if(phillySteak){
            philly_value = 1;
        }
        else{
            philly_value = 0;
        }
        
        
        if(ham){
            ham_value = 1;
        }
        else{
            ham_value = 0;
        }
        

        if(bacon){
            bacon_value = 1;
        }
        else{
            bacon_value = 0;
        }
        

        if(salami){
            salami_value = 1;
        }
        else{
            salami_value = 0;
        }
        

        if(chicken){
            chicken_value = 1;
        }
        else{
            chicken_value = 0;
        }
        
        var meatToppings = {'pepperoni':pep_value,
                           'italian':italian_value,
                           'slicedItalian':sliced_value,
                           'beef':beef_value,
                           'phillySteak':philly_value,
                           'ham':ham_value,
                           'bacon':bacon_value,
                           'salami':salami_value,
                           'chicken':chicken_value
                          }
        localStorage.setItem('meatToppings', JSON.stringify(meatToppings));
   

    	var cheddar = document.getElementById("cheddar_cheese").checked;
        var feta = document.getElementById("feta_cheese").checked;
        var shreddedParmesan = document.getElementById("shredded_parmesan").checked;
        var shreddedProvolone = document.getElementById("shredded_provolone").checked;
        var banana = document.getElementById("banana_peppers").checked;
        var olives = document.getElementById("black_olives").checked;
        var garlic = document.getElementById("garlic").checked;
        var green = document.getElementById("green_peppers").checked;
        var jalapeno = document.getElementById("jalapeno_peppers").checked;
        var mushrooms = document.getElementById("mushrooms").checked;
        var pineapple = document.getElementById("pineapple").checked;
        var onions = document.getElementById("onions").checked;
        var roasted = document.getElementById("roasted_red").checked;
        var spinach = document.getElementById("spinach").checked;
        var diced = document.getElementById("diced_tomatoes").checked;
        var hot = document.getElementById("hot_sauce").checked; 
        
        
        var cheddar_value = 0;
        var feta_value = 0;
        
        var parmesan_value = 0;
        var provolone_value = 0;
        var banana_value = 0;
        
        var olives_value = 0;
        var garlic_value = 0;
        var green_value = 0;
        var jalapeno_value = 0;
        var mushrooms_value = 0;
        var pineapple_value = 0;
        var onions_value = 0;
        var roasted_value = 0;
        var spinach_value = 0;
        var diced_value = 0;
        var hot_value = 0;
        
        

        if(cheddar){
            cheddar_value = 1;
        }
        else{
            cheddar_value = 0;
        }
        

        if(feta){
            feta_value = 1;
        }
        else{
            feta_value = 0;
        }

        if(shreddedParmesan){
        	parmesan_value = 1;
        	}
        else{
        	parmesan_value = 0;
        	}

        if(shreddedProvolone){
        	provolone_value = 1;
        	}
        else
        	{
        		provolone_value = 0;
        	}
        

        if(banana){
            banana_value = 1;
        }
        else{
            banana_value = 0;
        }
        

        if(olives){
            olives_value = 1;
        }
        else{
            olives_value = 0;
        }
        

        if(garlic){
            garlic_value = 1;
        }
        else{
            garlic_value = 0;
        }
        

        if(green){
            green_value = 1;
        }
        else{
            green_value = 0;
        }
        

        if(jalapeno){
            jalapeno_value = 1;
        }
        else{
            jalapeno_value = 0;
        }
        

        if(mushrooms){
            mushrooms_value = 1;
        }
        else{
            mushrooms_value = 0;
        }
	
    	if(pineapple){
            pineapple_value = 1;
        }
        else{
            pineapple_value = 0;
        }
	
	    if(onions){
            onions_value = 1;
        }
        else{
            onions_value = 0;
        }
        if(roasted){
        	roasted_value = 1;
        	}
        else{
        	roasted_value = 0;
		}


        if(spinach){
            spinach_value = 1;
        }
        else{
            spinach_value = 0;
        }
        
        if(diced){
            diced_value = 1;
        }
        else{
            diced_value = 0;
        }
        
        if(hot){
            hot_value = 1;
        }
        else{
            hot_value = 0;
        }
        
        var nonMeats = {'cheddar':cheddar_value,
                           'feta':feta_value,
                           'parmesan':parmesan_value,
                           'provolone':provolone_value,
                           'banana':banana_value,
                           'olives':olives_value,
                           'garlic':garlic_value,
                           'green':green_value,
                           'jalapeno':jalapeno_value,
                           'mushrooms':mushrooms_value,
                           'pineapple':pineapple_value,
                           'onions':onions_value,
                           'roasted':roasted_value,
                           'spinach':spinach_value,
                           'diced':diced_value,
                           'hot':hot_value
                          }
        localStorage.setItem('nonMeats', JSON.stringify(nonMeats));
    }