package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.mb;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class T implements mb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4550a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0614ub f4551b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ha f4552c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(ha haVar, String str, C0614ub c0614ub) {
        this.f4552c = haVar;
        this.f4550a = str;
        this.f4551b = c0614ub;
    }

    private void b(AdobeCSDKException adobeCSDKException) {
        G g2;
        D d2;
        boolean a2;
        G g3;
        boolean z = false;
        if (adobeCSDKException != null) {
            ArrayList arrayList = new ArrayList();
            a2 = this.f4552c.a(adobeCSDKException, this.f4550a, (ArrayList<AdobeCSDKException>) arrayList);
            if (!a2) {
                g3 = this.f4552c.f4625a;
                g3.a("onSyncError", this.f4551b, (AdobeCSDKException) arrayList.get(0));
            } else {
                this.f4552c.w.lock();
                try {
                    this.f4552c.f4631g.add(this.f4550a);
                    return;
                } finally {
                    this.f4552c.w.unlock();
                }
            }
        }
        AdobeLibraryException e2 = null;
        try {
            d2 = this.f4552c.C;
            z = d2.a(this.f4551b, (Boolean) false);
        } catch (AdobeLibraryException e3) {
            e2 = e3;
        }
        if (z) {
            return;
        }
        g2 = this.f4552c.f4625a;
        g2.a("onSyncError", this.f4551b, e2);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.mb
    public void a(C0231f c0231f) {
        b(null);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.mb
    public void a(AdobeCSDKException adobeCSDKException) {
        b(adobeCSDKException);
    }
}
