package com.nexstreaming.kinemaster.ui.projectgallery;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f4127a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.f4127a = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        x xVar;
        x xVar2;
        xVar = this.f4127a.f4227a.g;
        if (xVar != null) {
            xVar2 = this.f4127a.f4227a.g;
            xVar2.notifyDataSetChanged();
        }
    }
}
