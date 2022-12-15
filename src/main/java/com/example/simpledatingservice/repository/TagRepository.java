package com.example.simpledatingservice.repository;

import com.example.simpledatingservice.entities.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface TagRepository extends CrudRepository<Tag, Long> {
   // @Query(value = "SELECT t FROM Tag t WHERE t.id NOT in  (SELECT u.tags FROM User u WHERE u.id=:userId) ")
    @Query(value = "SELECT alltags FROM User u, Tag alltags JOIN u.tags t WHERE u.id=:userId AND alltags.id NOT IN t.id ")
    List<Tag> findByIdNotIn(@Param("userId") Long userId);

}
