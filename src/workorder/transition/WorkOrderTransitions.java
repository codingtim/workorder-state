package workorder.transition;

import workorder.WorkOrder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum WorkOrderTransitions {

    INSTANCE;

    private final List<WorkOrderTransition> workOrderTransitions = Arrays.asList(
            new Submit()
    );

    public List<WorkOrderTransition> getPossibleTransitionsFor(WorkOrder workOrder, String userId) {
        return workOrderTransitions.stream()
                .filter(workOrderTransition -> workOrderTransition.isValid(workOrder, userId))
                .collect(Collectors.toList());
    }
}
