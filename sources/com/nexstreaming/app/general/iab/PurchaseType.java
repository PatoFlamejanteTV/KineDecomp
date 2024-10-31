package com.nexstreaming.app.general.iab;

/* loaded from: classes2.dex */
public enum PurchaseType {
    SubMonthly(100, 2),
    SubAnnual(101, 2),
    SubUnknown(102, 1),
    OneTimeValid(103, 2),
    OneTimeExpired(104, 1),
    Promocode(105, 2),
    None(106, 1),
    Partner(107, 2),
    Team(108, 2),
    Standard(109, 2);

    private final int id;
    private final int level;

    PurchaseType(int i, int i2) {
        this.id = i;
        this.level = i2;
    }

    public static PurchaseType fromId(int i) {
        for (PurchaseType purchaseType : values()) {
            if (purchaseType.id == i) {
                return purchaseType;
            }
        }
        return null;
    }

    public static PurchaseType fromLevel(int i) {
        for (PurchaseType purchaseType : values()) {
            if (purchaseType.level == i) {
                return purchaseType;
            }
        }
        return null;
    }

    public static int getPermissionLevel(String str) {
        return (str == null || str.equalsIgnoreCase("free")) ? 1 : 2;
    }

    public int getId() {
        return this.id;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean isActivePurchaseOrPromocode() {
        return (this == None || this == OneTimeExpired) ? false : true;
    }
}
