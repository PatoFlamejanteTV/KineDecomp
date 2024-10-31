package com.nexstreaming.kinemaster.ui.previewplay;

/* compiled from: PreviewPlayActivity.java */
/* loaded from: classes.dex */
class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PreviewPlayActivity f3730a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PreviewPlayActivity previewPlayActivity) {
        this.f3730a = previewPlayActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.f3730a.f;
        if (z) {
            this.f3730a.d();
        }
    }
}
