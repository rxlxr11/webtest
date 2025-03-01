package yb.service;

import yb.pojo.Games;

import java.util.List;

public interface IGamesService {
    List<Games> queryByCondition(Games game);
    int queryByName(String name);
    int addGame(Games game);
}
