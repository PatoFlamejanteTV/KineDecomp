package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.internal.storage.asset.AdobeAssetPSFixPage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AdobeAssetPSFixFile.java */
/* loaded from: classes.dex */
public class Qa implements vd {

    /* renamed from: a */
    final /* synthetic */ Ra f7095a;

    /* renamed from: b */
    final /* synthetic */ vd f7096b;

    /* renamed from: c */
    final /* synthetic */ Ra f7097c;

    public Qa(Ra ra, Ra ra2, vd vdVar) {
        this.f7097c = ra;
        this.f7095a = ra2;
        this.f7096b = vdVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.vd
    public void a() {
        C0225c c0225c;
        Map<String, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha> a2 = this.f7095a.h() != null ? this.f7095a.h().a() : null;
        ArrayList<AdobeAssetFile> arrayList = new ArrayList<>();
        if (a2 != null) {
            ArrayList arrayList2 = new ArrayList(a2.keySet());
            Collections.sort(arrayList2, new Pa(this, a2));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha = a2.get((String) it.next());
                Iterator<C0225c> it2 = this.f7095a.h().d(ha).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        c0225c = null;
                        break;
                    }
                    c0225c = it2.next();
                    if (c0225c.l() != null && ((c0225c.l().equals("primary") && this.f7097c.k().contains(c0225c.n())) || c0225c.l().equals("rendition"))) {
                        break;
                    }
                }
                if (c0225c != null) {
                    AdobeAssetPSFixPage adobeAssetPSFixPage = new AdobeAssetPSFixPage(ha.f(), ((int) ha.a()) + 1, c0225c, this.f7095a);
                    if (ha.l()) {
                        arrayList.add(0, adobeAssetPSFixPage);
                    } else {
                        arrayList.add(adobeAssetPSFixPage);
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.f7095a.s = arrayList;
        }
        vd vdVar = this.f7096b;
        if (vdVar != null) {
            vdVar.a();
        }
    }
}
