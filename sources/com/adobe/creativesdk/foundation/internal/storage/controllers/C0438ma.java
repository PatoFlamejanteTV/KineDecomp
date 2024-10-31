package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;

/* compiled from: AdobeUXAssetVideoActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ma */
/* loaded from: classes.dex */
/* synthetic */ class C0438ma {

    /* renamed from: a */
    static final /* synthetic */ int[] f6253a = new int[AdobeNetworkReachability.AdobeNetworkStatusCode.values().length];

    static {
        try {
            f6253a[AdobeNetworkReachability.AdobeNetworkStatusCode.AdobeNetworkReachableNonMetered.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f6253a[AdobeNetworkReachability.AdobeNetworkStatusCode.AdobeNetworkReachableMetered.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f6253a[AdobeNetworkReachability.AdobeNetworkStatusCode.AdobeNetworkNotReachable.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
