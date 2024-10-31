package com.adobe.creativesdk.foundation.internal.cache;

/* loaded from: classes.dex */
public enum AdobeCommonCachePolicies {
    AdobeCommonCachePolicyUnset(0),
    AdobeCommonCacheEvictionLRU(1),
    AdobeCommonCacheEvictionFIFO(2),
    AdobeCommonCacheEvictionLSF(4),
    AdobeCommonCacheAllowOfflineUse(8);

    private int value;

    AdobeCommonCachePolicies(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }
}
