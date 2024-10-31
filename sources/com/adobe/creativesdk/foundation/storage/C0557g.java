package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.internal.storage.asset.AdobeAssetDrawPage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AdobeAssetDrawFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.g */
/* loaded from: classes.dex */
public class C0557g implements vd {

    /* renamed from: a */
    final /* synthetic */ C0561h f7256a;

    /* renamed from: b */
    final /* synthetic */ vd f7257b;

    /* renamed from: c */
    final /* synthetic */ C0561h f7258c;

    public C0557g(C0561h c0561h, C0561h c0561h2, vd vdVar) {
        this.f7258c = c0561h;
        this.f7256a = c0561h2;
        this.f7257b = vdVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.vd
    public void a() {
        C0225c c0225c;
        Map<String, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha> a2 = this.f7256a.h() != null ? this.f7256a.h().a() : null;
        ArrayList<AdobeAssetFile> arrayList = new ArrayList<>();
        if (a2 != null) {
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.La t = this.f7256a.h().t();
            ArrayList arrayList2 = new ArrayList(a2.keySet());
            Collections.sort(arrayList2, new C0553f(this, a2));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha = a2.get((String) it.next());
                if (!ha.g().equals(t.g())) {
                    Iterator<C0225c> it2 = this.f7256a.h().d(ha).iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            c0225c = null;
                            break;
                        }
                        c0225c = it2.next();
                        if (c0225c.l() != null && ((c0225c.l().equals("primary") && this.f7258c.k().contains(c0225c.n())) || c0225c.l().equals("rendition"))) {
                            break;
                        }
                    }
                    if (c0225c != null) {
                        arrayList.add(new AdobeAssetDrawPage(ha.f(), ((int) ha.a()) + 1, c0225c, this.f7256a));
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.f7256a.s = arrayList;
        }
        vd vdVar = this.f7257b;
        if (vdVar != null) {
            vdVar.a();
        }
    }
}
