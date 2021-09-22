package serie_a;

public class Team {
    String id, name;
    int points;
    int goalsScored;
    int goalsConceded;
    Player[] players;

    public Team(String id, String name, Player[] players) {
        this.id = id;
        this.name = name;
        this.points = 0;
        this.goalsScored = 0;
        this.goalsConceded = 0;
        this.players = players;
    }

    public String getId() {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public void win() {
        points += 3;
    }

    public void draw() {
        points += 1;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void addGoalsScored(int goals) {
        goalsScored += goals;
    }

    public void addGoalsConceded(int goals) {
        goalsConceded += goals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id.equals(team.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
