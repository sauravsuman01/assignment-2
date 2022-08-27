package com.test;

public class getSet implements Comparable<getSet>{
    private int id;
    private String name;
    private int matchPlayed;
    private int totalRuns;
    private int wicketsTaken;
    private int numberOfDucks;
    private String playerType;
    private int avg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchPlayed() {
        return matchPlayed;
    }

    public void setMatchPlayed(int matchPlayed) {
        this.matchPlayed = matchPlayed;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        wicketsTaken = wicketsTaken;
    }

    public int getNumberOfDucks() {
        return numberOfDucks;
    }

    public void setNumberOfDucks(int numberOfDucks) {
        this.numberOfDucks = numberOfDucks;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public getSet(int id, String name, int matchPlayed, int totalRuns, int wicketsTaken, int numberOfDucks, String playerType, int avg){
        this.id = id;
        this.name = name;
        this.matchPlayed = matchPlayed;
        this.totalRuns = totalRuns;
        this.wicketsTaken = wicketsTaken;
        this.numberOfDucks = numberOfDucks;
        this.playerType = playerType;
        this.avg = avg;
    }

    @Override
    public int compareTo(getSet gS) {
        return (int) (this.avg - gS.getAvg());
    }
}
