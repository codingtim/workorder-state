package workorder;

import org.junit.jupiter.api.Test;
import workorder.transition.PossibleTransitions;
import workorder.transition.WorkOrderTransitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkOrderTest {

    @Test
    void newWorkOrderShouldBeInDraft() {
        WorkOrder workOrder = new WorkOrder("me");
        assertEquals(WorkOrderStatus.DRAFT, workOrder.getStatus());
    }

    @Test
    void ownerCanSubmitAWorkOrder() {
        WorkOrder workOrder = new WorkOrder("me");
        PossibleTransitions possibleTransitions =
                WorkOrderTransitions.INSTANCE.getPossibleTransitionsFor(workOrder, "me");
        assertEquals(1, possibleTransitions.size());

        WorkOrder executedWorkOrder = possibleTransitions.execute("submit", "me");
        assertEquals(WorkOrderStatus.SUBMITTED, executedWorkOrder.getStatus());
    }

    @Test
    void otherUserCannotSubmitAWorkOrder() {
        WorkOrder workOrder = new WorkOrder("me");
        PossibleTransitions possibleTransitions =
                WorkOrderTransitions.INSTANCE.getPossibleTransitionsFor(workOrder, "other");
        assertEquals(0, possibleTransitions.size());
    }
}