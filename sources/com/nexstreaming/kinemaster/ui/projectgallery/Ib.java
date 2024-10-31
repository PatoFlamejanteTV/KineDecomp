package com.nexstreaming.kinemaster.ui.projectgallery;

/* compiled from: ProjectGalleryAdapter.kt */
/* loaded from: classes2.dex */
final class Ib implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Eb f22842a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ib(Eb eb) {
        this.f22842a = eb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Eb eb = this.f22842a;
        eb.notifyItemChanged(eb.i());
    }
}
