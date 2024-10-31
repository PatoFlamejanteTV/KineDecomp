package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzpq {
    private boolean isOpen;

    public final synchronized void block() throws InterruptedException {
        while (!this.isOpen) {
            wait();
        }
    }

    public final synchronized boolean zzgz() {
        if (this.isOpen) {
            return false;
        }
        this.isOpen = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean zzha() {
        boolean z;
        z = this.isOpen;
        this.isOpen = false;
        return z;
    }
}
