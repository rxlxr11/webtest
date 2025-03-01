package yb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yb.mapper.GamesMapper;
import yb.pojo.Games;
import yb.service.IGamesService;

import java.util.Collections;
import java.util.List;
@Service
@Transactional
public class GamesServiceImpl implements IGamesService {
    @Autowired
    private GamesMapper gamesMapper;
    @Override
    public List<Games> queryByCondition(Games game) {
        return gamesMapper.queryByCondition(game);
    }

    @Override
    public int queryByName(String name) {
        return gamesMapper.queryByName(name).size();
    }

    @Override
    public int addGame(Games game) {
        return gamesMapper.addGame(game);
    }
}
