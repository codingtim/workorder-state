package workorder;

public class WorkOrder {

    private WorkOrderStatus status;
    private String ownerId;

    public WorkOrder(String ownerId) {
        this.ownerId = ownerId;
        status = WorkOrderStatus.DRAFT;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public WorkOrderStatus getStatus() {
        return status;
    }

}
