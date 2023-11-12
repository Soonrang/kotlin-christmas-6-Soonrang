package christmas.model;

public enum Badge {
    STAR("별",5000),
    TREE("트리",10000),
    SANTA("산타",20000);

    private String badgeType;
    private int requiredAmount;

    Badge(String badgeType, int requiredAmount) {
        this.badgeType = badgeType;
        this.requiredAmount = requiredAmount;
    }

    public static String presentBadge(int benefitAmount) {
        if (benefitAmount >= SANTA.requiredAmount) {
            return SANTA.badgeType;
        } else if (benefitAmount >= TREE.requiredAmount) {
            return TREE.badgeType;
        } else if (benefitAmount >= STAR.requiredAmount) {
            return STAR.badgeType;
        }
        return null;
    }
}
