package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXSyncGroupMonitor.java */
/* loaded from: classes.dex */
public class Wa implements vb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.b f4259a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.b f4260b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ya f4261c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Lock f4262d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Sa f4263e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Condition f4264f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ Ya f4265g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Wa(Ya ya, com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar2, Ya ya2, Lock lock, Sa sa, Condition condition) {
        this.f4265g = ya;
        this.f4259a = bVar;
        this.f4260b = bVar2;
        this.f4261c = ya2;
        this.f4262d = lock;
        this.f4263e = sa;
        this.f4264f = condition;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0036  */
    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.vb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f r4, com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException r5) {
        /*
            r3 = this;
            r0 = 1
            if (r4 == 0) goto L2b
            if (r5 != 0) goto L2b
            java.lang.String r5 = r4.f6613e
            com.adobe.creativesdk.foundation.internal.storage.model.resources.b r1 = r3.f4259a
            java.lang.String r1 = r1.f6613e
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L22
            com.adobe.creativesdk.foundation.internal.storage.model.resources.b r5 = r3.f4260b
            java.lang.String r4 = r4.f6613e
            r5.f6613e = r4
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ya r4 = r3.f4265g
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wb r4 = r4.f4282d
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ya r1 = r3.f4261c
            r4.c(r5, r1)
            r4 = 1
            goto L34
        L22:
            com.adobe.creativesdk.foundation.internal.storage.model.resources.b r4 = r3.f4260b
            com.adobe.creativesdk.foundation.internal.storage.model.resources.b r5 = r3.f4259a
            java.lang.String r5 = r5.f6613e
            r4.f6613e = r5
            goto L33
        L2b:
            com.adobe.creativesdk.foundation.internal.storage.model.resources.b r4 = r3.f4260b
            com.adobe.creativesdk.foundation.internal.storage.model.resources.b r5 = r3.f4259a
            java.lang.String r5 = r5.f6613e
            r4.f6613e = r5
        L33:
            r4 = 0
        L34:
            if (r4 != 0) goto L51
            com.adobe.creativesdk.foundation.internal.storage.model.resources.b r4 = r3.f4259a
            com.adobe.creativesdk.foundation.storage.AdobeCollaborationType r5 = r4.k
            com.adobe.creativesdk.foundation.internal.storage.model.resources.b r1 = r3.f4260b
            com.adobe.creativesdk.foundation.storage.AdobeCollaborationType r2 = r1.k
            if (r5 != r2) goto L46
            com.adobe.creativesdk.foundation.storage.AdobeCollaborationRoleType r5 = r1.l
            com.adobe.creativesdk.foundation.storage.AdobeCollaborationRoleType r4 = r4.l
            if (r5 == r4) goto L51
        L46:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ya r4 = r3.f4265g
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wb r4 = r4.f4282d
            com.adobe.creativesdk.foundation.internal.storage.model.resources.b r5 = r3.f4260b
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ya r1 = r3.f4261c
            r4.c(r5, r1)
        L51:
            java.util.concurrent.locks.Lock r4 = r3.f4262d
            r4.lock()
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Sa r4 = r3.f4263e
            int r5 = r4.f4234a
            int r5 = r5 - r0
            r4.f4234a = r5
            if (r5 != 0) goto L64
            java.util.concurrent.locks.Condition r4 = r3.f4264f
            r4.signal()
        L64:
            java.util.concurrent.locks.Lock r4 = r3.f4262d
            r4.unlock()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Wa.a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f, com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException):void");
    }
}
