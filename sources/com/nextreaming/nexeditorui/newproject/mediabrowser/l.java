package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.widget.ProgressBar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4734a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(MediaBrowserFragment mediaBrowserFragment) {
        this.f4734a = mediaBrowserFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        ProgressBar progressBar;
        Runnable runnable;
        boolean z;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        progressBar = this.f4734a.p;
        runnable = this.f4734a.G;
        progressBar.removeCallbacks(runnable);
        z = this.f4734a.F;
        if (z) {
            progressBar3 = this.f4734a.p;
            progressBar3.setVisibility(0);
        } else {
            progressBar2 = this.f4734a.p;
            progressBar2.setVisibility(8);
        }
        this.f4734a.F = false;
    }
}
