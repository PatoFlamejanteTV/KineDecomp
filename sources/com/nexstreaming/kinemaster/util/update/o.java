package com.nexstreaming.kinemaster.util.update;

import android.widget.ProgressBar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetUpdateActivity.java */
/* loaded from: classes2.dex */
public class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AssetUpdateActivity f23968a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AssetUpdateActivity assetUpdateActivity) {
        this.f23968a = assetUpdateActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        boolean z;
        int i3;
        if (this.f23968a.isFinishing()) {
            return;
        }
        int progress = this.f23968a.H().z.getProgress() + 1;
        i = this.f23968a.L;
        i2 = this.f23968a.K;
        int i4 = (i * 100) / i2;
        if (progress > i4) {
            progress = i4;
        }
        this.f23968a.H().z.setProgress(progress);
        z = this.f23968a.M;
        if (z) {
            return;
        }
        ProgressBar progressBar = this.f23968a.H().z;
        i3 = this.f23968a.L;
        progressBar.postOnAnimationDelayed(this, ((i3 % 2) + 1) * 20);
    }
}
