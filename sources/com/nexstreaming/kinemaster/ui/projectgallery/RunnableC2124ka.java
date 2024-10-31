package com.nexstreaming.kinemaster.ui.projectgallery;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.ka, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC2124ka implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f22943a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f22944b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C2134oa f22945c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2124ka(C2134oa c2134oa, int i, int i2) {
        this.f22945c = c2134oa;
        this.f22943a = i;
        this.f22944b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.nexstreaming.kinemaster.ui.a.r rVar;
        com.nexstreaming.kinemaster.ui.a.r rVar2;
        com.nexstreaming.kinemaster.ui.a.r rVar3;
        com.nexstreaming.kinemaster.ui.a.r rVar4;
        rVar = this.f22945c.f22963a.za;
        if (rVar != null) {
            rVar2 = this.f22945c.f22963a.za;
            if (rVar2.isShowing()) {
                rVar3 = this.f22945c.f22963a.za;
                rVar3.j(this.f22943a);
                rVar4 = this.f22945c.f22963a.za;
                rVar4.i(this.f22944b);
            }
        }
    }
}
