package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.storage.AdobeAssetFileInternal;
import com.adobe.creativesdk.foundation.internal.storage.C0512k;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFolder.java */
/* loaded from: classes.dex */
public class W implements com.adobe.creativesdk.foundation.internal.storage.a.b.ta {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ qd f7152a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0578la f7153b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public W(C0578la c0578la, qd qdVar) {
        this.f7153b = c0578la;
        this.f7152a = qdVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ta
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar) {
        if (eVar != null) {
            C0578la c0578la = this.f7153b;
            c0578la.f7328a = eVar;
            c0578la.f7329b = true;
            ArrayList<C0533a> arrayList = new ArrayList<>();
            ArrayList<com.adobe.creativesdk.foundation.internal.storage.model.resources.b> d2 = eVar.d();
            if (d2 != null) {
                Iterator<com.adobe.creativesdk.foundation.internal.storage.model.resources.b> it = d2.iterator();
                while (it.hasNext()) {
                    com.adobe.creativesdk.foundation.internal.storage.model.resources.b next = it.next();
                    if (next instanceof com.adobe.creativesdk.foundation.internal.storage.model.resources.e) {
                        arrayList.add(new C0512k((com.adobe.creativesdk.foundation.internal.storage.model.resources.e) next, this.f7153b.f7328a));
                    } else if (next instanceof com.adobe.creativesdk.foundation.internal.storage.model.resources.f) {
                        com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar = (com.adobe.creativesdk.foundation.internal.storage.model.resources.f) next;
                        if (fVar.f6612d.equals(AdobeAssetMimeTypes.MIMETYPE_PHOTOSHOP.getMimeType())) {
                            arrayList.add(new AdobeAssetPSDFile(fVar, this.f7153b.f7328a));
                        } else {
                            arrayList.add(new AdobeAssetFileInternal(fVar, this.f7153b.f7328a));
                        }
                    }
                }
            }
            this.f7152a.a(arrayList, eVar.h());
        }
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        if (adobeAssetException != null) {
            this.f7152a.a(adobeAssetException);
        }
    }
}
