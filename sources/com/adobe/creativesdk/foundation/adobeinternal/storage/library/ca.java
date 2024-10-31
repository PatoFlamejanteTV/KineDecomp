package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.storage.sd;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class ca implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f4595a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f4596b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ha f4597c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(ha haVar, sd sdVar, ArrayList arrayList) {
        this.f4597c = haVar;
        this.f4595a = sdVar;
        this.f4596b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4595a.a((sd) this.f4596b.get(0));
    }
}
