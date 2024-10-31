package com.nexstreaming.kinemaster.ad;

import com.google.android.gms.tasks.OnSuccessListener;
import com.nexstreaming.kinemaster.ad.f;
import java.io.File;

/* compiled from: LottieBanner.java */
/* loaded from: classes.dex */
class j implements OnSuccessListener<byte[]> {

    /* renamed from: a */
    final /* synthetic */ File f19961a;

    /* renamed from: b */
    final /* synthetic */ f.a f19962b;

    /* renamed from: c */
    final /* synthetic */ l f19963c;

    public j(l lVar, File file, f.a aVar) {
        this.f19963c = lVar;
        this.f19961a = file;
        this.f19962b = aVar;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    /* renamed from: a */
    public void onSuccess(byte[] bArr) {
        l.b(this.f19961a, bArr);
        this.f19963c.a(this.f19961a, this.f19962b);
    }
}
