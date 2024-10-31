package com.nexstreaming.kinemaster.ui.projectgallery;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.ea, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC2106ea implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2109fa f22916a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2106ea(C2109fa c2109fa) {
        this.f22916a = c2109fa;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f22916a.f22919a.isFinishing()) {
            return;
        }
        this.f22916a.f22919a.ia();
    }
}
