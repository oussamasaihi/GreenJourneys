package com.greenjourneys.services;

import com.greenjourneys.entities.Reaction;

import java.io.Serializable;
import java.util.List;

public interface IReactionService extends Serializable {
    public Reaction  AddReaction (Reaction  reaction );
    public void removeReaction (Long id);
    public Reaction  updateReaction (Reaction  reaction );
    public List<Reaction > GetAllReaction ();
    public Reaction  GetReaction (Long id);
}
