package com.topuploan.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.istack.logging.Logger;
import com.topuploan.dao.FeedBackRepository;
import com.topuploan.entity.FeedBackModule;

import java.util.List;

@Service
public class FeedBackService {
	
	private static Logger log = Logger.getLogger(FeedBackService.class);

    @Autowired
    private FeedBackRepository repository ;

    public FeedBackModule saveDetails(FeedBackModule module){
    	log.info("Feedback added successfully");
        return repository.save(module);
    }
    public List<FeedBackModule> getAll (){
        return repository.findAll();
    }
}
