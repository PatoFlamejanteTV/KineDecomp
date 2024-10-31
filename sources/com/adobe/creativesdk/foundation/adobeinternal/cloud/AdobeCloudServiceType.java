package com.adobe.creativesdk.foundation.adobeinternal.cloud;

/* loaded from: classes.dex */
public enum AdobeCloudServiceType {
    AdobeCloudServiceTypeUnknown(0),
    AdobeCloudServiceTypeImage(1),
    AdobeCloudServiceTypeMarket(2),
    AdobeCloudServiceTypePhoto(3),
    AdobeCloudServiceTypeStorage(4),
    AdobeCloudServiceTypeEntitlement(5),
    AdobeCloudServiceTypeNotification(6),
    AdobeCloudServiceTypeClipBoard(7),
    AdobeCloudServiceTypeCommunity(8);

    private int _val;

    AdobeCloudServiceType(int i) {
        this._val = i;
    }

    public int getValue() {
        return this._val;
    }
}
