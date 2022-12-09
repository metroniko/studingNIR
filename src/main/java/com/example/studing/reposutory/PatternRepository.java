package com.example.studing.reposutory;

import com.example.studing.entity.Pattern;
import com.example.studing.entity.Strategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatternRepository extends JpaRepository<Pattern, Integer> {
    Pattern findByPatternGUID(String guid);
    Pattern findByPatternName(String name);
}
