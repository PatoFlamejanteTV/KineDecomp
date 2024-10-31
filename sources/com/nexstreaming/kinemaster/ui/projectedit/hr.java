package com.nexstreaming.kinemaster.ui.projectedit;

import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.general.tracelog.AppUsage;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeFragment.java */
/* loaded from: classes.dex */
class hr implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ hp f3962a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hr(hp hpVar) {
        this.f3962a = hpVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        NexTimelineItem.d dVar;
        dVar = this.f3962a.f3960a;
        dVar.setClipVolume((int) f);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        NexTimelineItem.d dVar;
        NexTimelineItem.d dVar2;
        NexTimelineItem.d dVar3;
        this.f3962a.d();
        KMUsage kMUsage = KMUsage.EditScreen_AdjustVolume;
        String[] strArr = new String[6];
        strArr[0] = NativeProtocol.WEB_DIALOG_ACTION;
        strArr[1] = "volume";
        strArr[2] = "level";
        dVar = this.f3962a.f3960a;
        strArr[3] = KMUsage.bucketParam0to200(dVar.getClipVolume());
        strArr[4] = "mute";
        dVar2 = this.f3962a.f3960a;
        strArr[5] = dVar2.getMuteAudio() ? "on" : "off";
        kMUsage.logEvent(strArr);
        AppUsage a2 = KMAppUsage.a(this.f3962a.getActivity());
        KMAppUsage.KMMetric kMMetric = KMAppUsage.KMMetric.VideoVolumeAdj;
        dVar3 = this.f3962a.f3960a;
        a2.a(kMMetric, dVar3.getClipVolume());
    }
}
