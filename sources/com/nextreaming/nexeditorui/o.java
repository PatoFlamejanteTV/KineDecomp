package com.nextreaming.nexeditorui;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KineMasterBaseActivity.kt */
/* loaded from: classes.dex */
public final class O implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f24156a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(I i) {
        this.f24156a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        z = this.f24156a.z;
        if (z || !this.f24156a.y().d(this.f24156a)) {
            return;
        }
        this.f24156a.z = true;
    }
}
