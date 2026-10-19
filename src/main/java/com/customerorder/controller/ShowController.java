package com.customerorder.controller;

import com.customerorder.tvMaze.TVMazeResponse;
import com.customerorder.tvMaze.TvMazeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    TvMazeService tvMazeService;

    @GetMapping("/{id}")
    TVMazeResponse getTvShowById(@PathVariable Long id) {
        return tvMazeService.getTvShowById(id);
    }
}
