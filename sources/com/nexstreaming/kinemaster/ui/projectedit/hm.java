package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.widget.ImageButton;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.general.tracelog.AppUsage;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeAndBalanceFragment.java */
/* loaded from: classes.dex */
class hm implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ hf f3957a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hm(hf hfVar) {
        this.f3957a = hfVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem.d dVar;
        NexTimelineItem.d dVar2;
        ImageButton imageButton;
        NexTimelineItem.d dVar3;
        NexTimelineItem.d dVar4;
        ImageButton imageButton2;
        NexTimelineItem.d dVar5;
        NexTimelineItem.d dVar6;
        NexTimelineItem.d dVar7;
        ImageButton imageButton3;
        dVar = this.f3957a.f3950a;
        dVar2 = this.f3957a.f3950a;
        dVar.setMuteAudio(!dVar2.getMuteAudio());
        imageButton = this.f3957a.c;
        dVar3 = this.f3957a.f3950a;
        imageButton.setSelected(dVar3.getMuteAudio());
        dVar4 = this.f3957a.f3950a;
        if (dVar4.getMuteAudio()) {
            imageButton3 = this.f3957a.c;
            imageButton3.setImageDrawable(this.f3957a.getResources().getDrawable(R.drawable.vol_mute_btn));
        } else {
            imageButton2 = this.f3957a.c;
            imageButton2.setImageDrawable(this.f3957a.getResources().getDrawable(R.drawable.vol_sound_btn));
        }
        this.f3957a.d();
        KMUsage kMUsage = KMUsage.EditScreen_AdjustVolume;
        String[] strArr = new String[6];
        strArr[0] = NativeProtocol.WEB_DIALOG_ACTION;
        strArr[1] = "mute";
        strArr[2] = "level";
        dVar5 = this.f3957a.f3950a;
        strArr[3] = KMUsage.bucketParam0to200(dVar5.getClipVolume());
        strArr[4] = "mute";
        dVar6 = this.f3957a.f3950a;
        strArr[5] = dVar6.getMuteAudio() ? "on" : "off";
        kMUsage.logEvent(strArr);
        AppUsage a2 = KMAppUsage.a(this.f3957a.getActivity());
        KMAppUsage.KMMetric kMMetric = KMAppUsage.KMMetric.VideoMute;
        dVar7 = this.f3957a.f3950a;
        a2.a(kMMetric, dVar7.getMuteAudio() ? "mute-on" : "mute-off");
    }
}
