package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: AudioLevelMeterFragment.java */
/* loaded from: classes2.dex */
class F implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f21835a;

    /* renamed from: b */
    final /* synthetic */ int f21836b;

    /* renamed from: c */
    final /* synthetic */ AudioLevelMeterFragment f21837c;

    public F(AudioLevelMeterFragment audioLevelMeterFragment, int i, int i2) {
        this.f21837c = audioLevelMeterFragment;
        this.f21835a = i;
        this.f21836b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21837c.c(this.f21835a, this.f21836b);
    }
}
