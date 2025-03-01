package yb.mapper;

import yb.pojo.Games;

import java.util.List;

public interface GamesMapper {
    List<Games> queryByCondition(Games game);
    List<Games> queryByName(String name);
    int addGame(Games game);
}
