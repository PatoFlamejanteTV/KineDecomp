package com.nexstreaming.kinemaster.ui.projectgallery;

/* compiled from: ProjectGalleryAdapter.kt */
/* loaded from: classes2.dex */
final class Hb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Eb f22839a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hb(Eb eb) {
        this.f22839a = eb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Eb eb = this.f22839a;
        eb.notifyItemChanged(eb.i());
    }
}
