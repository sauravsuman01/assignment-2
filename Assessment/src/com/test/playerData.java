package com.test;

import java.util.*;

// Name Comparator
class NameComparator implements Comparator<getSet>{

    @Override
    public int compare(getSet p1, getSet p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

public class playerData {
    List<String> players = new ArrayList<>();
    List<getSet> l = new ArrayList<getSet>();
    public void add(String name){
        players.add(name);
    }

    //Display Players Name
    public void display(){
        System.out.println("Players List");
        for(int i=0; i<players.size(); i++)
            System.out.println(players.get(i));
        System.out.println("\n");
    }

    //Update Player Details
    public void updateInfo(String name) {

        int flag = 0;
        if (players.contains(name)) {
            System.out.print("Enter Player ID: ");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            System.out.print("Enter no. of matches played: ");
            int mp = sc.nextInt();
            System.out.print("Enter total runs scored: ");
            int tr = sc.nextInt();
            System.out.print("Enter no. of wickets taken: ");
            int wt = sc.nextInt();
            System.out.print("Enter no.of ducks: ");
            int oz = sc.nextInt();
            System.out.print("Enter player type: ");
            String type = sc.next();
            int avg;
            avg = tr / mp;
            l.add(new getSet(id, name, mp, tr, wt, oz, type, avg));
            System.out.println("Player Details Updated");
            flag = 1;
        } else
            System.out.println("Player does not exist");
    }

    //Add Player Informatiom
    public void addInfo(String name){

        int flag = 0;
        if(players.contains(name)){
            System.out.print("Enter Player ID: ");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            System.out.print("Enter no. of matches played: ");
            int mp = sc.nextInt();
            System.out.print("Enter total runs scored: ");
            int tr = sc.nextInt();
            System.out.print("Enter no. of wickets taken: ");
            int wt = sc.nextInt();
            System.out.print("Enter no.of ducks: ");
            int oz = sc.nextInt();
            System.out.print("Enter player type: ");
            String type = sc.next();
            int avg;
            avg = tr/mp;
            l.add(new getSet(id, name, mp, tr, wt, oz,type, avg));
            flag=1;
        }
        else
            System.out.println("Player does not exist");

        if(flag==1){
            Collections.sort(l, new NameComparator());
            Iterator<getSet> it = l.iterator();
            while(it.hasNext()){
                getSet ply = it.next();
                System.out.println("ID: "+ply.getId()+", Name: "+ply.getName()+", Matches Played: "+ply.getMatchPlayed()+", Total Runs: "+ply.getTotalRuns()+", Wickets Taken: "+ply.getWicketsTaken()+", No. of Zero: "+ply.getNumberOfDucks()+", Player Type: "+ply.getPlayerType());
            }
            System.out.println("\n");
        }
    }

    //Final Team
    public void finalTeam(){
        Collections.sort(l);
        List<String> nl = new ArrayList<>();
        int i=0, cBowl=0, cWk=0, bowl=3;

        while(i<7) {
            nl.add(l.get(i).getName());
            i++;
        }
        for (int j=0; j<7; j++)
            if(l.get(j).getPlayerType()=="Bowler") {
                cBowl++;
                cWk++;
            }
        if(cBowl<3){
            int d = bowl-cBowl;
            for(int j=7; j<d+7; j++){
                if(l.get(j).getPlayerType()=="Bowler") {
                    nl.add(l.get(j).getName());
                    cBowl++;
                }
            }
        }
        if(cWk==0){
            if(l.get(11).getPlayerType()=="Wicketkeeper")
                nl.add(l.get(11).getName());
        }
        System.out.println(nl);
    }

    public static void main(String[] args) {
        playerData pd = new playerData();
        int enterYourChoice;
        Scanner sc = new Scanner(System.in);
        for(;;) {
            System.out.println("1. Add Player\t2.Display players\t3.Add Player Information\t4.Update Player Information\t5.Display Team\t6.Exit");
            System.out.print("Enter your choice: ");
            enterYourChoice = sc.nextInt();
            switch (enterYourChoice) {
                case 1: {
                    System.out.print("Enter Player Name: ");
                    String n = sc.next();
                    pd.add(n);
                    break;
                }
                case 2: {
                    pd.display();
                    break;
                }
                case 3: {
                    String name;
                    System.out.print("Enter player whose details sre to be added: ");
                    name = sc.next();
                    pd.addInfo(name);
                    break;
                }
                case 4:{
                    String name;
                    System.out.print("Enter the player to be updated: ");
                    name = sc.next();
                    pd.updateInfo(name);
                    break;
                }
                case 5:
                    pd.finalTeam();
                    break;
                default:
                    System.out.println("Exited");
            }
        }
    }
}
