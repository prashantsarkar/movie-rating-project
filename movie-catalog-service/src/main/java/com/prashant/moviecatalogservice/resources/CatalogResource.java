package com.prashant.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.prashant.moviecatalogservice.models.CatalogItem;
import com.prashant.moviecatalogservice.models.Movie;
import com.prashant.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@Autowired
	WebClient.Builder webClientBuilder;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRating userRating = webClientBuilder.build().get()
				.uri("http://ratings-data-service/ratingsdata/user/" + userId).retrieve().bodyToMono(UserRating.class)
				.block();

		return userRating.getRatings().stream().map(rating -> {
			Movie movie = webClientBuilder.build().get().uri("http://movie-info-service/movies/" + rating.getMovieId())
					.retrieve().bodyToMono(Movie.class).block();
			return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
		}).collect(Collectors.toList());
	}
}
