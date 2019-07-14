package workorder.transition;

import workorder.WorkOrder;

import java.util.List;

public class PossibleTransitions {
    private WorkOrder workOrder;
    private List<WorkOrderTransition> possibleTransitions;

    PossibleTransitions(WorkOrder workOrder, List<WorkOrderTransition> possibleTransitions) {
        this.workOrder = workOrder;
        this.possibleTransitions = possibleTransitions;
    }

    public int size() {
        return possibleTransitions.size();
    }

    public WorkOrder execute(String transitionName, String userId) {
        WorkOrderTransition selectedTransition = possibleTransitions.stream()
                .filter(workOrderTransition -> workOrderTransition.getName().equals(transitionName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid transition selected."));
        //TODO this means some invariants are covered by other objects and makes WorkOrder a mere data holder
        if (!selectedTransition.isValid(workOrder, userId)) {
            throw new IllegalStateException("Invalid transition selected.");
        }
        //TODO what about extra required date when a transition is performed?
        selectedTransition.execute(workOrder);
        return workOrder;
    }
}
