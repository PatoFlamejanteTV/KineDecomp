package com.nexstreaming.kinemaster.codeccaps.ui;

/* compiled from: CapabilityTestIntroActivity.java */
/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f20121a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ CapabilityTestIntroActivity f20122b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CapabilityTestIntroActivity capabilityTestIntroActivity, boolean z) {
        this.f20122b = capabilityTestIntroActivity;
        this.f20121a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String stringExtra = this.f20122b.getIntent() != null ? this.f20122b.getIntent().getStringExtra("device_id") : null;
        CapabilityTestIntroActivity capabilityTestIntroActivity = this.f20122b;
        capabilityTestIntroActivity.startActivity(CapabilityTestRunnerActivity.a(capabilityTestIntroActivity, stringExtra, this.f20121a));
    }
}
