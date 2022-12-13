package com.example.simpledatingservice.service;

import com.example.simpledatingservice.entities.Tag;
import com.example.simpledatingservice.entities.User;
import com.example.simpledatingservice.repository.TagRepository;
import com.example.simpledatingservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
public class TagService {

    private TagRepository tagRepository;
    @Autowired
    public TagService(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }

    @Transactional
    public List<Tag> getTags(){
        List<Tag> result = new ArrayList<Tag>();
        Iterable<Tag> iterable = tagRepository.findAll();
        iterable.forEach(result::add);
        return result;
    }

    @Transactional
    public List<Tag> getNonSelectedTags(){
        Long id = new Long(0);
        return tagRepository.findByIdNotIn(id);
    }

}
