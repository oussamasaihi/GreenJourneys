package com.greenjourneys.services;

import com.greenjourneys.entities.Interest;
import com.greenjourneys.entities.User;

import java.util.List;

public interface IInterestService  {
    Interest getInterstById(long id);

    Interest addInterest(Interest i);

    List<Interest> getAllInterest();

    void deleteInterest(long idInterest);

    Interest updateInterest(Interest interest);

    List<User> getUsersByInterest(Interest interest);
}
