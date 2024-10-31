package com.nexstreaming.kinemaster.integration.cloud;

import com.adobe.creativesdk.foundation.internal.storage.C0512k;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0578la;
import com.adobe.creativesdk.foundation.storage.qd;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KMCreativeCloud.java */
/* loaded from: classes.dex */
public class h implements qd {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f20434a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f20435b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ p f20436c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(p pVar, String str, b bVar) {
        this.f20436c = pVar;
        this.f20434a = str;
        this.f20435b = bVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.qd
    public void a(ArrayList<C0533a> arrayList, int i) {
        boolean z;
        Iterator<C0533a> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            C0533a next = it.next();
            if ((next instanceof C0512k) && next.getName().equals(this.f20434a)) {
                z = true;
                this.f20436c.k = (C0578la) next;
                break;
            }
        }
        this.f20435b.a(Boolean.valueOf(z));
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        this.f20435b.onFailure();
    }
}
