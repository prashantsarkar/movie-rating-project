package com.prashant.movieinfoservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.prashant.movieinfoservice.models.Movie;
import com.prashant.movieinfoservice.models.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Value("${api.key}")
	private String apiKey;

	@Value("${api.uri}")
	private String apiUri;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		MovieSummary movieSummary = webClientBuilder.build().get().uri(apiUri + movieId + "?api_key=" + apiKey)
				.retrieve().bodyToMono(MovieSummary.class).block();
		
		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
	}

}