package com.cricBlog.cricBlog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricBlog.cricBlog.Models.Teams;

public interface TeamRepository extends JpaRepository<Teams, Long>{
}
