package com.social.theplatform.Services;

import com.social.theplatform.models.Follow;
import com.social.theplatform.models.User;
import com.social.theplatform.repositories.IRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
   private final IRepository<User> userRepository;
   private final IRepository<Follow> followRepository;

    public UserService(IRepository<User> userRepository, IRepository<Follow> followRepository) {
        this.userRepository = userRepository;
        this.followRepository = followRepository;
    }

    public List<User> getAll(){
        var response = userRepository.findAll();
        return response;
    }
    public User getResponseById(int id){
        User response = userRepository.findById(id).orElse(null);
        return response;
    }


    public List<Follow> getUserFollowing(int userId){
        return followRepository.findAllByUser_Id(userId);
    }

    public boolean isFollowing(int userId,int followingId){
       Optional<Follow> follow = followRepository.findByUser_IdAndFollowing_Id(userId,followingId);
       return follow.isPresent();
    }

    public User getById(int id){
        return userRepository.findById(id).get();
    }
    public void add(User userAddRequest){
        userRepository.save(userAddRequest);
    }

    public void delete(int id){
        userRepository.deleteById(id);
    }
}
