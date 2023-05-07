package com.greenjourneys.services;

import com.greenjourneys.entities.Reaction;
import com.greenjourneys.repositories.IReaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReactionService implements IReactionService {
    private final IReaction reactionRepository;
    @Override
    public Reaction AddReaction(Reaction reaction) {
        return reactionRepository.save(reaction);
    }

    @Override
    public void removeReaction(Long id) {
        reactionRepository.deleteById(id);

    }

    @Override
    public Reaction updateReaction(Reaction reaction) {
        return reactionRepository.save(reaction);
    }

    @Override
    public List<Reaction> GetAllReaction() {
        return reactionRepository.findAll();
    }

    @Override
    public Reaction GetReaction(Long id) {
        return reactionRepository.findById(id).get();
    }
}
