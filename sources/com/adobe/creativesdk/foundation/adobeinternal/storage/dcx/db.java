package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class db {

    /* renamed from: a, reason: collision with root package name */
    hb f4346a;

    /* renamed from: b, reason: collision with root package name */
    Handler f4347b;

    /* renamed from: c, reason: collision with root package name */
    C0324c f4348c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(zb zbVar, C0324c c0324c) {
        this.f4346a = zbVar.b();
        this.f4347b = zbVar.a();
        this.f4348c = c0324c;
    }

    public void a(Runnable runnable) {
        Handler handler = this.f4347b;
        if (handler != null) {
            handler.post(runnable);
            return;
        }
        try {
            runnable.run();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "ComponentManagerWrapper", "Error::ComponentManager method invocation : " + e2.getMessage(), e2);
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CompMgeWrapper:StackTrace:", stackTraceElement.toString());
            }
        }
    }

    public void a(C0225c c0225c, C0231f c0231f, String str, tb tbVar, C0324c.a aVar) {
        a(new _a(this, aVar, c0225c, c0231f, str, tbVar));
    }

    public void a(C0225c c0225c, C0231f c0231f, String str, AdobeCSDKException adobeCSDKException) {
        a(new RunnableC0222ab(this, c0225c, c0231f, str, adobeCSDKException));
    }

    public void a(C0225c c0225c, C0231f c0231f, String str, ub ubVar, C0324c.a aVar) {
        a(new bb(this, aVar, c0225c, c0231f, str, ubVar));
    }

    public void a(C0225c c0225c, C0231f c0231f, String str, String str2, AdobeCSDKException adobeCSDKException) {
        a(new cb(this, c0225c, c0231f, str, str2, adobeCSDKException));
    }
}
