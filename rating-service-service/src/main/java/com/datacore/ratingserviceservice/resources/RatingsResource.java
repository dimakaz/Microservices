package com.datacore.ratingserviceservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datacore.ratingserviceservice.model.Rating;
import com.datacore.ratingserviceservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		// get all rated movie IDs
		List <Rating> ratings = Arrays.asList(
				new Rating("545609", 4),
				new Rating("560044", 2)
		);
		
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		
		return  userRating;
	}

}
