package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.internal.storage.asset.AdobeAssetCompPage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AdobeAssetCompFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.c */
/* loaded from: classes.dex */
public class C0541c implements vd {

    /* renamed from: a */
    final /* synthetic */ C0545d f7215a;

    /* renamed from: b */
    final /* synthetic */ vd f7216b;

    /* renamed from: c */
    final /* synthetic */ C0545d f7217c;

    public C0541c(C0545d c0545d, C0545d c0545d2, vd vdVar) {
        this.f7217c = c0545d;
        this.f7215a = c0545d2;
        this.f7216b = vdVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.vd
    public void a() {
        C0225c c0225c;
        Map<String, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha> a2 = this.f7215a.h() != null ? this.f7215a.h().a() : null;
        ArrayList<AdobeAssetFile> arrayList = new ArrayList<>();
        if (a2 != null) {
            ArrayList arrayList2 = new ArrayList(a2.keySet());
            Collections.sort(arrayList2, new C0537b(this, a2));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha = a2.get((String) it.next());
                Iterator<C0225c> it2 = this.f7215a.h().d(ha).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        c0225c = null;
                        break;
                    }
                    c0225c = it2.next();
                    if (c0225c.l() != null && ((c0225c.l().equals("primary") && this.f7217c.k().contains(c0225c.n())) || c0225c.l().equals("rendition"))) {
                        break;
                    }
                }
                if (c0225c != null) {
                    AdobeAssetCompPage adobeAssetCompPage = new AdobeAssetCompPage(ha.f(), ((int) ha.a()) + 1, c0225c, this.f7215a);
                    if (ha.l()) {
                        arrayList.add(0, adobeAssetCompPage);
                    } else {
                        arrayList.add(adobeAssetCompPage);
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.f7215a.s = arrayList;
        }
        vd vdVar = this.f7216b;
        if (vdVar != null) {
            vdVar.a();
        }
    }
}
