package strategies;

public class FactoryHeuristic {
    public static Heuristic getHeuristic(String heuristicName) {
        Heuristic heuristic = null;
        if(heuristicName.equalsIgnoreCase("StorageDiff")) {
            heuristic = new StorageDiff();
        }

        return heuristic;
    }
}
