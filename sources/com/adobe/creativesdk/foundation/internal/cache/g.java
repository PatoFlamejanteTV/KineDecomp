package com.adobe.creativesdk.foundation.internal.cache;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCommonCacheInstance.java */
/* loaded from: classes.dex */
public /* synthetic */ class g {

    /* renamed from: a */
    static final /* synthetic */ int[] f4963a = new int[AdobeCommonCachePolicies.values().length];

    static {
        try {
            f4963a[AdobeCommonCachePolicies.AdobeCommonCacheEvictionLSF.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f4963a[AdobeCommonCachePolicies.AdobeCommonCacheEvictionLRU.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
