package workorder.transition;

import workorder.WorkOrder;
import workorder.WorkOrderStatus;

class Submit implements WorkOrderTransition {

    @Override
    public boolean isValid(WorkOrder workOrder, String userId) {
        return workOrder.getStatus() == WorkOrderStatus.DRAFT
                && workOrder.getOwnerId().equals(userId);
    }
}
