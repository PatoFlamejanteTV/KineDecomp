package com.nexstreaming.app.general.iab;

/* loaded from: classes.dex */
public enum PurchaseType {
    SubMonthly(100),
    SubAnnual(101),
    SubUnknown(102),
    OneTimeValid(103),
    OneTimeExpired(104),
    Promocode(105),
    None(106);

    private final int id;

    PurchaseType(int i) {
        this.id = i;
    }

    public boolean isActivePurchaseOrPromocode() {
        return (this == None || this == OneTimeExpired) ? false : true;
    }

    public int getId() {
        return this.id;
    }

    public static PurchaseType fromId(int i) {
        for (PurchaseType purchaseType : values()) {
            if (purchaseType.id == i) {
                return purchaseType;
            }
        }
        return null;
    }
}
