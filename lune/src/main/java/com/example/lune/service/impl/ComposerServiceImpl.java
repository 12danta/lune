package com.example.lune.service.impl;

import com.example.lune.domain.Composer;
import com.example.lune.mapper.ComposerMapper;
import com.example.lune.service.ComposerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComposerServiceImpl implements ComposerService {

    @Autowired
    ComposerMapper composerMapper;

    @Override
    public Boolean insert(Composer composer) {
        return composerMapper.insert(composer) > 0;
    }

    @Override
    public Boolean insertSelective(Composer composer) {
        return composerMapper.insertSelective(composer) > 0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return composerMapper.deleteById(id) > 0;
    }

    @Override
    public List<Composer> allComposer() {
        return composerMapper.allComposer();
    }

    @Override
    public List<Composer> composerOfPeriod(String period) {
        return composerMapper.composerOfPeriod(period);
    }

    @Override
    public Composer composerOfId(Integer id) {
        return composerMapper.composerOfId(id);
    }

    @Override
    public Composer composerOfName(String name) {
        return composerMapper.composerOfName(name);
    }

    @Override
    public Boolean update(Composer composer) {
        return composerMapper.update(composer) > 0;
    }
}
