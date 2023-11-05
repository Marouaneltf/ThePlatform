package com.social.theplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface IRepository<Entity> extends JpaRepository<Entity, Integer> {

    List<Entity> findAllByUser_Id(int userId);

    Optional<Entity> findByUser_IdAndFollowing_Id(int userId, int followingId);
}