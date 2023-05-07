package com.greenjourneys.services;

import com.greenjourneys.entities.Interest;
import com.greenjourneys.entities.User;
import com.greenjourneys.repositories.IInterest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class InterestService implements IInterestService {
    public final IInterest iInterest;
    @Override
    public Interest getInterstById(long id) {
        return iInterest.getReferenceById(id);
    }

    @Override
    public Interest addInterest(Interest i) {
        return iInterest.save(i);
    }

    @Override
    public List<Interest> getAllInterest() {
        return iInterest.findAll();
    }

    @Override
    public void deleteInterest(long idInterest) {
        iInterest.deleteById(idInterest);

    }

    @Override
    public Interest updateInterest(Interest interest) {
        return iInterest.save(interest);
    }

    @Override
    public List<User> getUsersByInterest(Interest interest) {
        return iInterest.getUsersByInterest(interest);
    }
}
