package serie_a;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class SerieAChart {

    Team[] chart;

    public SerieAChart(Team[] chart) {
        this.chart = chart;
    }

    void matchOutcome(Team team1, int golHome, Team team2, int golAway) {
        if(team1.equals(team2))
            return;
        MatchOutcome outcomeHome = getOutcomeFromGoals(golHome, golAway);
        MatchOutcome outcomeAway = getOutcomeFromGoals(golAway, golHome);
        updateTeamPoints(team1.id, outcomeHome, golHome, golAway);
        updateTeamPoints(team2.id, outcomeAway, golAway, golHome);
    }

    private MatchOutcome getOutcomeFromGoals(int golHome, int golAway) {
        return (golHome == golAway) ? MatchOutcome.draw :
                (golHome < golAway) ? MatchOutcome.loss :
                MatchOutcome.win;
    }

    void updateTeamPoints(String teamId, MatchOutcome outcome, int goalsScored, int goalsConceded) {
        for(Team t : chart) {
            if (t.id.equals(teamId)) {
                if (outcome == MatchOutcome.win)
                    t.win();
                else if (outcome == MatchOutcome.draw)
                    t.draw();

                t.addGoalsScored(goalsScored);
                t.addGoalsConceded(goalsConceded);
            }
        }
        Arrays.sort(chart, Comparator.comparingInt(Team::getPoints)
                .thenComparing(Team::getGoalsScored)
                .thenComparing(Team::hashCode).reversed());
    }

    Team[] getChart() {
        return chart;
    }

    Team getBestAttack() {
        Team bestAttack = chart.length > 0 ? chart[0] : null;
        for(Team team : chart)
            if(bestAttack.goalsScored < team.goalsScored)
                bestAttack = team;
        return bestAttack;
    }

    Team getWorstDefense() {
        Team worstDefense = chart.length > 0 ? chart[0] : null;
        for(Team team : chart)
            if(worstDefense.goalsConceded > team.goalsScored)
                worstDefense = team;
        return worstDefense;
    }

    public static void main(String[] args) {
        Team roma = new Team("1", "as roma", null);
        Team lazio = new Team("2", "ss lazio", null);
        Team juve = new Team("3", "fc rubentus", null);
        Team inter = new Team("4", "fc inter", null);
        Team[] teams = new Team[] {roma, lazio, juve, inter};
        SerieAChart serieAChart = new SerieAChart(teams);
        serieAChart.matchOutcome(roma, 2, lazio, 1);
        serieAChart.matchOutcome(roma, 3, lazio, 1);
        serieAChart.matchOutcome(juve, 2, lazio, 1);
        serieAChart.matchOutcome(juve, 3, lazio, 1);
        Team[] chart = serieAChart.getChart();
        System.out.println(Arrays.toString(chart));
        Team bestAttack = serieAChart.getBestAttack();
        Team worstDefese = serieAChart.getWorstDefense();
        System.out.println(bestAttack.toString());
        System.out.println(worstDefese.toString());
    }

}



