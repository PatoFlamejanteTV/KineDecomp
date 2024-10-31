package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.qa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0254qa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Aa f4435a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ nb f4436b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Aa f4437c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0254qa(Aa aa, Aa aa2, nb nbVar) {
        this.f4437c = aa;
        this.f4435a = aa2;
        this.f4436b = nbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map map;
        boolean z;
        AdobeDCXControllerMode adobeDCXControllerMode;
        Map map2;
        Object runnableC0244la;
        map = this.f4435a.f4115h;
        ArrayList arrayList = new ArrayList(map.size());
        synchronized (this.f4435a) {
            z = this.f4435a.j;
            if (z) {
                adobeDCXControllerMode = this.f4435a.f4113f;
                if (adobeDCXControllerMode == AdobeDCXControllerMode.AdobeDCXControllerSyncing) {
                    map2 = this.f4435a.f4115h;
                    Iterator it = map2.entrySet().iterator();
                    while (it.hasNext()) {
                        eb ebVar = (eb) ((Map.Entry) it.next()).getValue();
                        if (!ebVar.f4358d && !ebVar.j) {
                            if (ebVar.f4360f != null) {
                                this.f4435a.d(ebVar);
                                this.f4435a.g();
                            } else {
                                int i = C0238ia.f4393b[ebVar.f4357c.ordinal()];
                                if (i == 1) {
                                    runnableC0244la = new RunnableC0244la(this, ebVar);
                                } else if (i == 2) {
                                    runnableC0244la = new RunnableC0246ma(this, ebVar);
                                } else if (i == 3) {
                                    runnableC0244la = new RunnableC0248na(this, ebVar);
                                } else if (i != 4) {
                                    runnableC0244la = i != 5 ? null : new RunnableC0252pa(this, ebVar);
                                } else {
                                    runnableC0244la = new RunnableC0250oa(this, ebVar);
                                }
                                ebVar.f4361g = null;
                                if (runnableC0244la != null && !ebVar.k) {
                                    ebVar.j = true;
                                    arrayList.add(runnableC0244la);
                                }
                            }
                        }
                    }
                    if (arrayList.size() == 0) {
                        this.f4435a.g();
                        return;
                    }
                    this.f4435a.h();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        this.f4435a.a((Runnable) it2.next());
                    }
                }
            }
        }
    }
}
