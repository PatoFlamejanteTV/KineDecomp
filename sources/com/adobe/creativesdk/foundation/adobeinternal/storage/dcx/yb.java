package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: IAdobeDCXTransferSessionProtocol.java */
/* loaded from: classes.dex */
public interface yb {
    Handler a();

    Fa a(Fa fa, C0231f c0231f) throws AdobeDCXException, AdobeCSDKException;

    com.adobe.creativesdk.foundation.internal.net.E a(C0225c c0225c, C0231f c0231f, String str, ib ibVar, Handler handler);

    com.adobe.creativesdk.foundation.internal.net.E a(C0231f c0231f, vb vbVar, Handler handler);

    com.adobe.creativesdk.foundation.internal.net.E a(String str, C0225c c0225c, C0231f c0231f, String str2, ib ibVar, Handler handler);

    boolean a(C0231f c0231f) throws AdobeCSDKException;

    hb b();

    boolean b(C0231f c0231f) throws AdobeCSDKException;
}
