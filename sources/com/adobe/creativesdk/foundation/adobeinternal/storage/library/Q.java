package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qb;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.Gb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class Q implements qb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4542a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0231f f4543b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f4544c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ha f4545d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(ha haVar, int i, C0231f c0231f, String str) {
        this.f4545d = haVar;
        this.f4542a = i;
        this.f4543b = c0231f;
        this.f4544c = str;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qb
    public void a(C0233g c0233g) {
        int i;
        int i2 = this.f4542a;
        i = this.f4545d.G;
        if (i2 != i) {
            return;
        }
        try {
            this.f4545d.a(this.f4543b, this.f4544c, c0233g, (AdobeCSDKException) null);
        } catch (AdobeCSDKException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, Gb.class.getSimpleName(), "", e2);
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qb
    public void a(C0233g c0233g, AdobeCSDKException adobeCSDKException) {
        int i;
        int i2 = this.f4542a;
        i = this.f4545d.G;
        if (i2 != i) {
            return;
        }
        try {
            this.f4545d.a(this.f4543b, this.f4544c, c0233g, adobeCSDKException);
        } catch (AdobeCSDKException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, Gb.class.getSimpleName(), "", e2);
        }
    }
}
