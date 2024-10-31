package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.Gb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: AdobeLibraryManager.java */
/* loaded from: classes.dex */
public class Db implements Gb.a<Object> {

    /* renamed from: a */
    final /* synthetic */ C0614ub f6949a;

    /* renamed from: b */
    final /* synthetic */ Gb f6950b;

    public Db(Gb gb, C0614ub c0614ub) {
        this.f6950b = gb;
        this.f6949a = c0614ub;
    }

    @Override // com.adobe.creativesdk.foundation.storage.Gb.a
    public boolean b(Object obj) {
        if (obj == null) {
            return true;
        }
        C0614ub d2 = this.f6950b.d((String) obj);
        if (d2 == null || d2.q()) {
            return true;
        }
        this.f6949a.s();
        ArrayList arrayList = new ArrayList();
        List<C0225c> a2 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.H.a(this.f6949a.f7444g);
        if (a2 != null) {
            Iterator<C0225c> it = a2.iterator();
            while (it.hasNext()) {
                arrayList.add(this.f6949a.i().p().a(it.next()).e());
            }
        }
        ArrayList arrayList2 = new ArrayList();
        com.adobe.creativesdk.foundation.adobeinternal.storage.library.H.a(this.f6949a.i(), this.f6949a.i().p(), this.f6949a.i().i(), new Cb(this, arrayList, arrayList2), this.f6950b.f6988b);
        this.f6949a.u();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            try {
                d2.a(this.f6949a.c((String) it2.next()), this.f6949a);
            } catch (AdobeLibraryException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Gb.class.getSimpleName(), null, e2);
            }
        }
        this.f6949a.a((Handler) null, (c.a.a.a.b<Void>) null, (c.a.a.a.c<AdobeLibraryException>) null);
        return false;
    }
}
