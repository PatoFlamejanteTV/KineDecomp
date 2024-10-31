package com.nexstreaming.kinemaster.ui.settings;

/* compiled from: SettingsActivity.java */
/* loaded from: classes2.dex */
class ab implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f23117a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SettingsActivity f23118b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SettingsActivity settingsActivity, boolean z) {
        this.f23118b = settingsActivity;
        this.f23117a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f23118b.isFinishing()) {
            return;
        }
        this.f23118b.g(this.f23117a);
    }
}
