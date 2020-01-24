package com.datacore.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.datacore.moviecatalogservice.models.CatalogItem;
import com.datacore.moviecatalogservice.models.Movie;
import com.datacore.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuider;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		// get all rated movie IDs
		List <Rating> ratings = Arrays.asList(
				new Rating("12334", 4),
				new Rating("56782", 2)
		);
		
		return ratings.stream().map(rating -> {
			// Call external Rest API via restTemplate (deprecated)
			//Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			
			// Call external Rest API via webClientBuider
			Movie movie = webClientBuider.build()
			.get()
			.uri("http://localhost:8082/movies/" + rating.getMovieId())
			.retrieve()
			.bodyToMono(Movie.class)
			.block();
			
			return new CatalogItem(movie.getName(), "Test", rating.getRating());
		})
		.collect(Collectors.toList());

	}
}
