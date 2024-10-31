package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.internal.storage.asset.AdobeAssetPSMixPage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AdobeAssetPSMixFile.java */
/* loaded from: classes.dex */
public class Ta implements vd {

    /* renamed from: a */
    final /* synthetic */ Ua f7124a;

    /* renamed from: b */
    final /* synthetic */ vd f7125b;

    /* renamed from: c */
    final /* synthetic */ Ua f7126c;

    public Ta(Ua ua, Ua ua2, vd vdVar) {
        this.f7126c = ua;
        this.f7124a = ua2;
        this.f7125b = vdVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.vd
    public void a() {
        C0225c c0225c;
        Map<String, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha> a2 = this.f7124a.h() != null ? this.f7124a.h().a() : null;
        ArrayList<AdobeAssetFile> arrayList = new ArrayList<>();
        if (a2 != null) {
            ArrayList arrayList2 = new ArrayList(a2.keySet());
            Collections.sort(arrayList2, new Sa(this, a2));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha = a2.get((String) it.next());
                Iterator<C0225c> it2 = this.f7124a.h().d(ha).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        c0225c = null;
                        break;
                    }
                    c0225c = it2.next();
                    if (c0225c.l() != null && ((c0225c.l().equals("primary") && this.f7126c.k().contains(c0225c.n())) || c0225c.l().equals("rendition"))) {
                        break;
                    }
                }
                if (c0225c != null) {
                    AdobeAssetPSMixPage adobeAssetPSMixPage = new AdobeAssetPSMixPage(ha.f(), ((int) ha.a()) + 1, c0225c, this.f7124a);
                    if (ha.l()) {
                        arrayList.add(0, adobeAssetPSMixPage);
                    } else {
                        arrayList.add(adobeAssetPSMixPage);
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.f7124a.s = arrayList;
        }
        vd vdVar = this.f7125b;
        if (vdVar != null) {
            vdVar.a();
        }
    }
}
