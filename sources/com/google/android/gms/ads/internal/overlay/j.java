package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.zzid;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private zzk f599a;
    private boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(zzk zzkVar) {
        this.f599a = zzkVar;
    }

    public void a() {
        this.b = true;
        zzid.zzIE.removeCallbacks(this);
    }

    public void b() {
        zzid.zzIE.postDelayed(this, 250L);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b) {
            return;
        }
        this.f599a.n();
        b();
    }
}
