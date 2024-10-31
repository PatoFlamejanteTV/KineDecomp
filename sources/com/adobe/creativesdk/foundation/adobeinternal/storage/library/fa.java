package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qb;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.Gb;
import com.adobe.creativesdk.foundation.storage.Hb;
import com.adobe.creativesdk.foundation.storage.sd;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class fa implements qb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Gb f4606a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0225c f4607b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f4608c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0231f f4609d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ sd f4610e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f4611f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f4612g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ Hb f4613h;
    final /* synthetic */ ha i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(ha haVar, Gb gb, C0225c c0225c, int i, C0231f c0231f, sd sdVar, String str, String str2, Hb hb) {
        this.i = haVar;
        this.f4606a = gb;
        this.f4607b = c0225c;
        this.f4608c = i;
        this.f4609d = c0231f;
        this.f4610e = sdVar;
        this.f4611f = str;
        this.f4612g = str2;
        this.f4613h = hb;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qb
    public void a(C0233g c0233g) {
        int i;
        com.adobe.creativesdk.foundation.internal.net.k kVar;
        synchronized (this.f4606a) {
            this.i.f4629e.remove(this.f4607b.b());
        }
        int i2 = this.f4608c;
        i = this.i.G;
        if (i2 != i) {
            return;
        }
        try {
            this.f4609d.c();
        } catch (AdobeDCXException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, Gb.class.getSimpleName(), "", e2);
        }
        String str = null;
        try {
            str = this.f4609d.p().c(this.f4607b);
        } catch (AdobeDCXException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, Gb.class.getSimpleName(), "", e3);
        }
        kVar = this.i.F;
        kVar.execute(new da(this, str));
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qb
    public void a(C0233g c0233g, AdobeCSDKException adobeCSDKException) {
        int i;
        boolean a2;
        com.adobe.creativesdk.foundation.internal.net.k kVar;
        synchronized (this.f4606a) {
            this.i.f4629e.remove(this.f4607b.b());
        }
        int i2 = this.f4608c;
        i = this.i.G;
        if (i2 == i && adobeCSDKException != null) {
            ArrayList arrayList = new ArrayList();
            a2 = this.i.a(adobeCSDKException, this.f4611f, this.f4612g, (ArrayList<AdobeCSDKException>) arrayList);
            if (!arrayList.isEmpty()) {
                kVar = this.i.F;
                kVar.execute(new ea(this, adobeCSDKException));
            }
            if (a2) {
                this.i.a(this.f4613h, this.f4611f, this.f4609d, this.f4612g, this.f4610e);
            }
        }
    }
}
