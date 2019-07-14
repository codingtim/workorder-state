package workorder.transition;

import workorder.WorkOrder;

public interface WorkOrderTransition {

    boolean isValid(WorkOrder workOrder, String userId);

    String getName();

    void execute(WorkOrder workOrder);
}
