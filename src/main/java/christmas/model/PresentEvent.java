package christmas.model;

public class PresentEvent {

    private boolean presentChampagne = false;

    public int priceBeforeDiscount = 0;

    public PresentEvent(int priceBeforeDiscount) {
        if (priceBeforeDiscount >= 120000) {
            presentChampagne = true;
        }
    }

    public boolean isPresentChampagne() {
        return presentChampagne;
    }
}
