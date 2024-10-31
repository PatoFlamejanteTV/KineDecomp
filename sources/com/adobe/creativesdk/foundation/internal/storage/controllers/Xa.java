package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;

/* compiled from: AssetViewFragment.java */
/* loaded from: classes.dex */
/* synthetic */ class Xa {

    /* renamed from: a */
    static final /* synthetic */ int[] f5886a = new int[AdobeNetworkReachability.AdobeNetworkStatusCode.values().length];

    static {
        try {
            f5886a[AdobeNetworkReachability.AdobeNetworkStatusCode.AdobeNetworkReachableNonMetered.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f5886a[AdobeNetworkReachability.AdobeNetworkStatusCode.AdobeNetworkReachableMetered.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f5886a[AdobeNetworkReachability.AdobeNetworkStatusCode.AdobeNetworkNotReachable.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
