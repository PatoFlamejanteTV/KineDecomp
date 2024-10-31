package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;

/* compiled from: AdobeLibraryAnalyticsError.java */
/* loaded from: classes.dex */
public class r extends C0289s {
    public r(String str, C0614ub c0614ub, C0622wb c0622wb, String str2) {
        super(str, c0614ub, c0622wb, str2);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.C0289s
    public void a(AdobeCSDKException adobeCSDKException) {
        if (adobeCSDKException == null) {
            this.f4660f = false;
        }
        super.a(adobeCSDKException);
    }
}
