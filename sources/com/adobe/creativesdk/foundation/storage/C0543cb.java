package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.internal.storage.asset.AdobeAssetSketchbookPage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AdobeAssetSketchbook.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.cb */
/* loaded from: classes.dex */
public class C0543cb implements vd {

    /* renamed from: a */
    final /* synthetic */ C0547db f7219a;

    /* renamed from: b */
    final /* synthetic */ vd f7220b;

    /* renamed from: c */
    final /* synthetic */ C0547db f7221c;

    public C0543cb(C0547db c0547db, C0547db c0547db2, vd vdVar) {
        this.f7221c = c0547db;
        this.f7219a = c0547db2;
        this.f7220b = vdVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.vd
    public void a() {
        C0225c c0225c;
        Map<String, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha> a2 = this.f7219a.h() != null ? this.f7219a.h().a() : null;
        ArrayList<AdobeAssetFile> arrayList = new ArrayList<>();
        if (a2 != null) {
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.La t = this.f7219a.h().t();
            ArrayList arrayList2 = new ArrayList(a2.keySet());
            Collections.sort(arrayList2, new C0539bb(this, a2));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha = a2.get((String) it.next());
                if (!ha.g().equals(t.g())) {
                    Iterator<C0225c> it2 = this.f7219a.h().d(ha).iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            c0225c = null;
                            break;
                        }
                        c0225c = it2.next();
                        if (c0225c.l() != null && ((c0225c.l().equals("primary") && this.f7221c.k().contains(c0225c.n())) || c0225c.l().equals("rendition"))) {
                            break;
                        }
                    }
                    if (c0225c != null) {
                        arrayList.add(new AdobeAssetSketchbookPage(ha.f(), ((int) ha.a()) + 1, c0225c, this.f7219a));
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.f7219a.s = arrayList;
        }
        vd vdVar = this.f7220b;
        if (vdVar != null) {
            vdVar.a();
        }
    }
}
