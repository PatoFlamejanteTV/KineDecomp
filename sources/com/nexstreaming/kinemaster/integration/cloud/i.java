package com.nexstreaming.kinemaster.integration.cloud;

import com.adobe.creativesdk.foundation.internal.storage.AdobeAssetFileInternal;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.qd;
import com.nexstreaming.kinemaster.integration.cloud.KMCloud;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: KMCreativeCloud.java */
/* loaded from: classes.dex */
class i implements qd {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f20437a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f20438b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(p pVar, c cVar) {
        this.f20438b = pVar;
        this.f20437a = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.qd
    public void a(ArrayList<C0533a> arrayList, int i) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<C0533a> it = arrayList.iterator();
        while (it.hasNext()) {
            C0533a next = it.next();
            if (next instanceof AdobeAssetFileInternal) {
                AdobeAssetFileInternal adobeAssetFileInternal = (AdobeAssetFileInternal) next;
                arrayList2.add(new KMCloud.a(next.getHref().toString(), next.getName(), adobeAssetFileInternal.getType(), next.getCreationDate(), adobeAssetFileInternal.getFileSize()));
            }
        }
        this.f20437a.a(arrayList2);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        this.f20437a.onFailure();
    }
}
