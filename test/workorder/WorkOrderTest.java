package workorder;

import org.junit.jupiter.api.Test;
import workorder.transition.WorkOrderTransition;
import workorder.transition.WorkOrderTransitions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkOrderTest {

    @Test
    void newWorkOrderShouldBeInDraft() {
        WorkOrder workOrder = new WorkOrder("me");
        assertEquals(WorkOrderStatus.DRAFT, workOrder.getStatus());
    }

    @Test
    void ownerCanSubmitAWorkOrder() {
        WorkOrder workOrder = new WorkOrder("me");
        List<WorkOrderTransition> possibleTransitions =
                WorkOrderTransitions.INSTANCE.getPossibleTransitionsFor(workOrder, "me");
        assertEquals(1, possibleTransitions.size());
    }

    @Test
    void otherUserCannotSubmitAWorkOrder() {
        WorkOrder workOrder = new WorkOrder("me");
        List<WorkOrderTransition> possibleTransitions =
                WorkOrderTransitions.INSTANCE.getPossibleTransitionsFor(workOrder, "other");
        assertEquals(0, possibleTransitions.size());
    }
}