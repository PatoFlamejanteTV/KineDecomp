package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.storage.sd;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryBookmarkManager.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0292v implements ja {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0293w f4663a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0292v(C0293w c0293w) {
        this.f4663a = c0293w;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.library.ja
    public void a(ArrayList<C0291u> arrayList) {
        this.f4663a.f4665b.b(arrayList);
        C0293w c0293w = this.f4663a;
        c0293w.f4665b.a(c0293w.f4664a);
    }

    @Override // c.a.a.a.c
    public void a(Object obj) {
        this.f4663a.f4664a.a((sd) obj);
    }
}
