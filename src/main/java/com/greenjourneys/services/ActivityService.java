package com.greenjourneys.services;

import com.greenjourneys.entities.Activity;
import com.greenjourneys.generic.IGenericServiceImp;
import com.greenjourneys.repositories.IActivity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ActivityService extends IGenericServiceImp<Activity,Long> implements IActivityService  {
    private final IActivity iActivity ;
    @Override
    public Activity retrieveById(Long aLong) {return super.retrieveById(aLong);}

    @Override
    public List<Activity> retrieveAll() {return super.retrieveAll();}

    @Override
    public Activity update(Activity entity) {return super.update(entity);}

    @Override
    public Activity add(Activity entity) {return super.add(entity);}

    @Override
    public Boolean delete(Long aLong) {return super.delete(aLong);}
}
