// autor : Norman & César 2018-2019
package ctrl;

import model.Matches;
import model.MatchesList;
import model.TournoiList;

public class Ctrl {
    private final MatchesList matchesList;
    private final TournoiList tournoiList;
    
    public Ctrl(TournoiList tournamentList, MatchesList mL){
        this.tournoiList = tournamentList;
        this.matchesList = mL;
    }
    
    public void tournamentSelection(int numTournament){
        if (numTournament >= 0 && numTournament < tournoiList.nbTournois())
            tournoiList.select(numTournament);
        else
            tournoiList.unselect();
    }

    public void addMatch(Matches match){
        matchesList.addMatch(match);
    }
    

    
    public void matchSelection(int numMatch){
        if (numMatch >= 0 && numMatch < matchesList.nbMatch())
            matchesList.select(numMatch);
        else
            matchesList.unselect();
    }
    
    public void updateMatch(Matches match){
        matchesList.updateSelectedMatch(match);
    }
    
    public void deleteMatch(){
        matchesList.deleteSelectedMatch();
    }
}
