package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: IAdobeDCXControllerDelegate.java */
/* loaded from: classes.dex */
public interface nb {
    void a(Aa aa);

    void a(Aa aa, long j);

    void a(Aa aa, AdobeNetworkReachability.AdobeNetworkStatusCode adobeNetworkStatusCode);

    void a(Aa aa, AdobeCSDKException adobeCSDKException);

    void a(Aa aa, AdobeCSDKException adobeCSDKException, String str, AdobeDCXSyncPhase adobeDCXSyncPhase, boolean z);

    void a(Aa aa, String str);

    void a(Aa aa, String str, String str2);

    void b(Aa aa);

    void b(Aa aa, AdobeNetworkReachability.AdobeNetworkStatusCode adobeNetworkStatusCode);

    void b(Aa aa, String str);

    void c(Aa aa, String str);

    void d(Aa aa, String str);

    long e(Aa aa, String str);
}
