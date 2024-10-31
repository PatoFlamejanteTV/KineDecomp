package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.tracelog.AppUsage;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: SpeedControlFragment.java */
/* loaded from: classes.dex */
class kw implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ kv f4047a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kw(kv kvVar) {
        this.f4047a = kvVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        NexVideoClipItem nexVideoClipItem;
        nexVideoClipItem = this.f4047a.f4046a;
        nexVideoClipItem.setPlaybackSpeed((int) f);
        this.f4047a.s();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        NexVideoClipItem nexVideoClipItem;
        kv kvVar = this.f4047a;
        nexVideoClipItem = this.f4047a.f4046a;
        kvVar.b = nexVideoClipItem.getPlaybackSpeed();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        NexVideoClipItem nexVideoClipItem;
        NexVideoClipItem nexVideoClipItem2;
        int i;
        NexVideoClipItem nexVideoClipItem3;
        int i2;
        NexVideoClipItem nexVideoClipItem4;
        NexVideoClipItem nexVideoClipItem5;
        nexVideoClipItem = this.f4047a.f4046a;
        nexVideoClipItem2 = this.f4047a.f4046a;
        int effectStartTime = nexVideoClipItem2.getEffectStartTime();
        i = this.f4047a.b;
        int i3 = (effectStartTime * i) / 100;
        nexVideoClipItem3 = this.f4047a.f4046a;
        int effectEndTime = nexVideoClipItem3.getEffectEndTime();
        i2 = this.f4047a.b;
        nexVideoClipItem.checkEffectTime(i3, (effectEndTime * i2) / 100, 3);
        KMUsage kMUsage = KMUsage.EditScreen_SpeedControl;
        nexVideoClipItem4 = this.f4047a.f4046a;
        kMUsage.logEvent("speed_percent", KMUsage.bucketParam0to300(nexVideoClipItem4.getPlaybackSpeed()));
        this.f4047a.e(true);
        this.f4047a.d();
        AppUsage a2 = KMAppUsage.a(this.f4047a.getActivity());
        KMAppUsage.KMMetric kMMetric = KMAppUsage.KMMetric.VideoSpeedControl;
        nexVideoClipItem5 = this.f4047a.f4046a;
        a2.a(kMMetric, nexVideoClipItem5.getPlaybackSpeed());
    }
}
