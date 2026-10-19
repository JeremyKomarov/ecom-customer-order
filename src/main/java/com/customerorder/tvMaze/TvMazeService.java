package com.customerorder.tvMaze;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "tvMazeService",
        url = "${externalApi.tvMaze.url}"
)
public interface TvMazeService {
    @GetMapping("/shows/{id}")
    TVMazeResponse getTvShowById(@PathVariable Long id);
}
