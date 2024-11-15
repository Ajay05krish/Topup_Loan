package com.topuploan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.topuploan.entity.FeedBackModule;
import com.topuploan.service.FeedBackService;

import java.util.List;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class FeedBackController {

    @Autowired
    private FeedBackService service ;

    @PostMapping("/add")
    public FeedBackModule saveData(@RequestBody FeedBackModule module ){
        return service.saveDetails(module);
    }

    @GetMapping("/get")
    public List<FeedBackModule> getModule() {
        return service.getAll();
    }
}
