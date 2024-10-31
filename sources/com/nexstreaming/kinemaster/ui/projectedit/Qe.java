package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.CompoundButton;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeAndBalanceFragment.java */
/* loaded from: classes2.dex */
class Qe implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ye f22037a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qe(Ye ye) {
        this.f22037a = ye;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        NexTimelineItem.e eVar;
        NexTimelineItem.e eVar2;
        NexTimelineItem.e eVar3;
        eVar = this.f22037a.l;
        if (eVar != null) {
            eVar2 = this.f22037a.l;
            if (eVar2.isCheckedAudioCompressor() != z) {
                eVar3 = this.f22037a.l;
                eVar3.setAudioCompressor(z);
                this.f22037a.G();
            }
        }
    }
}
