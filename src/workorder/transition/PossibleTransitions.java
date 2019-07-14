package workorder.transition;

import java.util.List;

public class PossibleTransitions {
    private List<WorkOrderTransition> possibleTransitions;

    PossibleTransitions(List<WorkOrderTransition> possibleTransitions) {
        this.possibleTransitions = possibleTransitions;
    }

    public int size() {
        return possibleTransitions.size();
    }
}
