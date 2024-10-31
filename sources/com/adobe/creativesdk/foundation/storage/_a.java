package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.internal.storage.asset.AdobeAssetSharedPage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: AdobeAssetSharedProject.java */
/* loaded from: classes.dex */
public class _a implements vd {

    /* renamed from: a */
    final /* synthetic */ C0535ab f7191a;

    /* renamed from: b */
    final /* synthetic */ vd f7192b;

    /* renamed from: c */
    final /* synthetic */ C0535ab f7193c;

    public _a(C0535ab c0535ab, C0535ab c0535ab2, vd vdVar) {
        this.f7193c = c0535ab;
        this.f7191a = c0535ab2;
        this.f7192b = vdVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.vd
    public void a() {
        C0225c c0225c;
        C0225c c0225c2;
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa h2 = this.f7191a.h();
        List<C0225c> f2 = h2 != null ? h2.f() : new ArrayList<>();
        List<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha> c2 = h2 != null ? h2.c() : new ArrayList<>();
        ArrayList<AdobeAssetFile> arrayList = new ArrayList<>();
        Iterator<C0225c> it = f2.iterator();
        while (true) {
            if (!it.hasNext()) {
                c0225c = null;
                break;
            }
            c0225c = it.next();
            if (c0225c.l() != null && ((c0225c.l().equals("primary") && this.f7193c.k().contains(c0225c.n())) || (c0225c.l().equals("rendition") && c0225c.j().equals(AdobePhotoAsset.AdobePhotoAssetRenditionImagePreview)))) {
                break;
            }
        }
        if (c0225c != null) {
            arrayList.add(new AdobeAssetSharedPage(h2.p() != null ? h2.p() : "Creation", 0, c0225c, this.f7191a));
        }
        Collections.sort(c2, new Za(this));
        for (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha : c2) {
            Iterator<C0225c> it2 = h2.d(ha).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    c0225c2 = null;
                    break;
                }
                c0225c2 = it2.next();
                if (c0225c2.l() != null && ((c0225c2.l().equals("primary") && this.f7193c.k().contains(c0225c2.n())) || c0225c2.l().equals("rendition"))) {
                    break;
                }
            }
            if (c0225c2 != null) {
                arrayList.add(new AdobeAssetSharedPage(ha.j() != null ? ha.j() : "Creation", ((int) ha.a()) + 1, c0225c2, this.f7191a));
            }
        }
        if (!arrayList.isEmpty()) {
            this.f7191a.s = arrayList;
        }
        vd vdVar = this.f7192b;
        if (vdVar != null) {
            vdVar.a();
        }
    }
}
