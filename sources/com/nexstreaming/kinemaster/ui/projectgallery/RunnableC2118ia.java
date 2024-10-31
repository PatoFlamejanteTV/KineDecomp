package com.nexstreaming.kinemaster.ui.projectgallery;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.ia, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC2118ia implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f22932a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2134oa f22933b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2118ia(C2134oa c2134oa, String str) {
        this.f22933b = c2134oa;
        this.f22932a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22933b.f22963a.e(this.f22932a);
    }
}
