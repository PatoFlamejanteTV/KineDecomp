package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.storage.Gb;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryManager.java */
/* loaded from: classes.dex */
public class Eb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f6958a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f6959b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Gb.a f6960c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6961d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Gb f6962e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Eb(Gb gb, String str, String str2, Gb.a aVar, c.a.a.a.b bVar) {
        this.f6962e = gb;
        this.f6958a = str;
        this.f6959b = str2;
        this.f6960c = aVar;
        this.f6961d = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList = new ArrayList(this.f6962e.x.keySet());
        int i = 0;
        while (!arrayList.isEmpty()) {
            AbstractC0618vb abstractC0618vb = (AbstractC0618vb) arrayList.get(i);
            boolean z = true;
            if (abstractC0618vb != null) {
                if ("libraryPreDelete".equals(this.f6958a)) {
                    boolean a2 = abstractC0618vb.a(this.f6959b);
                    Gb.a aVar = this.f6960c;
                    if (aVar != null) {
                        z = aVar.b(Integer.valueOf(a2 ? 1 : 0));
                    }
                }
                if ("libraryPreReadabilityChange".equals(this.f6958a)) {
                    String b2 = abstractC0618vb.b(this.f6959b);
                    Gb.a aVar2 = this.f6960c;
                    if (aVar2 != null) {
                        z = aVar2.b(b2);
                    }
                }
            }
            if (!z) {
                return;
            }
            i++;
            if (i == arrayList.size()) {
                c.a.a.a.b bVar = this.f6961d;
                if (bVar != null) {
                    bVar.b(null);
                    return;
                }
                return;
            }
        }
    }
}
