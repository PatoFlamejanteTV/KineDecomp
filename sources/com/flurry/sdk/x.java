package com.flurry.sdk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends bc {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f497a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.f497a = wVar;
    }

    @Override // com.flurry.sdk.bc
    public void a() {
        boolean z;
        z = this.f497a.l;
        if (!z) {
            this.f497a.d(ad.a().b());
        }
        this.f497a.a(ad.a().b());
    }
}
