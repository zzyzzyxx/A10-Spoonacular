package com.sebastianwrobel.a10.web;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.sebastianwrobel.a10.dto.DayResponse;
import com.sebastianwrobel.a10.dto.WeekResponse;

@RestController
public class SpoonFileController {
	
	
	RestTemplate rt = new RestTemplate();
	//53b5b7ffbc4140c88c12f8e9a2e955a5 
	
	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals( Optional<String> numCalories,
													  Optional<String> diet,
													  Optional<String> exclude){
		
		RestTemplate rt = new RestTemplate();
		 URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
		 					 .queryParam("apiKey", "53b5b7ffbc4140c88c12f8e9a2e955a5")
		 					 .queryParamIfPresent("targetCalories", numCalories)
		 					 .queryParam("timeFrame", "week")
		 					 .queryParamIfPresent("diet", diet)
		 					 .queryParamIfPresent("exclude", exclude)
		 					 .build()
		 					 .toUri();
		 
		 ResponseEntity<WeekResponse> forEntity = rt.getForEntity(uri, WeekResponse.class);
		return forEntity;
		}

	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(Optional<String> numCalories, 
												   Optional<String> diet, 
												   Optional<String> exclude){
		RestTemplate rt = new RestTemplate();
		 URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
		 					 .queryParam("apiKey", "53b5b7ffbc4140c88c12f8e9a2e955a5")
		 					 .queryParamIfPresent("targetCalories", numCalories)
		 					 .queryParam("timeFrame", "day")
		 					 .queryParamIfPresent("diet", diet)
		 					 .queryParamIfPresent("exclude", exclude)
		 					 .build()
		 					 .toUri();
		 
		 ResponseEntity<DayResponse> forEntity = rt.getForEntity(uri, DayResponse.class);
		return forEntity;
		}
}
