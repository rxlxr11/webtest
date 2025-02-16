package yb.jsptest3.pojo;

import java.util.Objects;

public class Games {
    private Long gameId;
    private String gameName;
    private String gameType;
    private String gameCompany;
    private Integer gameYear;

    public Games() {
    }

    public Games(Long gameId, String gameName, String gameType, String gameCompany, Integer gameYear) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.gameType = gameType;
        this.gameCompany = gameCompany;
        this.gameYear = gameYear;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGameCompany() {
        return gameCompany;
    }

    public void setGameCompany(String gameCompany) {
        this.gameCompany = gameCompany;
    }

    public Integer getGameYear() {
        return gameYear;
    }

    public void setGameYear(Integer gameYear) {
        this.gameYear = gameYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Games games = (Games) o;
        return Objects.equals(gameId, games.gameId) && Objects.equals(gameName, games.gameName) && Objects.equals(gameType, games.gameType) && Objects.equals(gameCompany, games.gameCompany) && Objects.equals(gameYear, games.gameYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, gameName, gameType, gameCompany, gameYear);
    }

    @Override
    public String toString() {
        return "Games{" +
                "gameId=" + gameId +
                ", gameName='" + gameName + '\'' +
                ", gameType='" + gameType + '\'' +
                ", gameCompany='" + gameCompany + '\'' +
                ", gameYear=" + gameYear +
                '}';
    }
}
