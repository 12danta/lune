package com.example.lune.service.impl;

import com.example.lune.domain.Performer;
import com.example.lune.mapper.PerformerMapper;
import com.example.lune.service.PerformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformerServiceImpl implements PerformerService {

    @Autowired
    PerformerMapper performerMapper;

    @Override
    public Boolean insert(Performer performer) {
        return performerMapper.insert(performer) > 0;
    }

    @Override
    public Boolean insertSelective(Performer performer) {
        return performerMapper.insertSelective(performer) > 0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return performerMapper.deleteById(id) > 0;
    }

    @Override
    public List<Performer> allPerformer() {
        return performerMapper.allPerformer();
    }

    @Override
    public Performer performerOfId(Integer id) {
        return performerMapper.performerOfId(id);
    }

    @Override
    public List<Performer> performerOfType(String type) {
        return performerMapper.performerOfType(type);
    }

    @Override
    public Performer performerOfName(String name) {
        return performerMapper.performerOfName(name);
    }

    @Override
    public Boolean update(Performer performer) {
        return performerMapper.update(performer) > 0;
    }
}
