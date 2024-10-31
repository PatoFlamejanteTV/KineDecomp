package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.mb;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class G implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ mb f5305a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.j f5306b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f f5307c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ArrayList f5308d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0231f f5309e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ ra f5310f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(ra raVar, mb mbVar, com.adobe.creativesdk.foundation.internal.net.j jVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, ArrayList arrayList, C0231f c0231f) {
        this.f5310f = raVar;
        this.f5305a = mbVar;
        this.f5306b = jVar;
        this.f5307c = fVar;
        this.f5308d = arrayList;
        this.f5309e = c0231f;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        if (adobeNetworkException.getData() != null) {
            com.adobe.creativesdk.foundation.internal.net.l lVar = (com.adobe.creativesdk.foundation.internal.net.l) adobeNetworkException.getData().get("Response");
            if (lVar != null) {
                a(lVar);
                return;
            } else {
                this.f5305a.a(adobeNetworkException);
                return;
            }
        }
        this.f5305a.a(ra.a(adobeNetworkException));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:            if (((com.adobe.creativesdk.foundation.internal.net.E) r0.get(r11.f5306b)).c() == false) goto L69;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cd, code lost:            if (((com.adobe.creativesdk.foundation.internal.net.E) r5.get(r11.f5306b)).c() == false) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010f, code lost:            if (((com.adobe.creativesdk.foundation.internal.net.E) r0.get(r11.f5306b)).c() == false) goto L57;     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0159  */
    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.adobe.creativesdk.foundation.internal.net.l r12) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.a.b.G.a(com.adobe.creativesdk.foundation.internal.net.l):void");
    }
}
