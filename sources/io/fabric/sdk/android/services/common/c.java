package io.fabric.sdk.android.services.common;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvertisingInfoProvider.java */
/* loaded from: classes3.dex */
public class c extends j {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f26887a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f26888b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, b bVar) {
        this.f26888b = dVar;
        this.f26887a = bVar;
    }

    @Override // io.fabric.sdk.android.services.common.j
    public void onRun() {
        b e2;
        e2 = this.f26888b.e();
        if (this.f26887a.equals(e2)) {
            return;
        }
        io.fabric.sdk.android.f.f().d("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
        this.f26888b.c(e2);
    }
}
