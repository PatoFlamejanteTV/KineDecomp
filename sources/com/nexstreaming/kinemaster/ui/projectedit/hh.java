package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.CompoundButton;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeAndBalanceFragment.java */
/* loaded from: classes.dex */
class hh implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ hf f3952a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hh(hf hfVar) {
        this.f3952a = hfVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        NexTimelineItem.d dVar;
        NexTimelineItem.d dVar2;
        NexTimelineItem.d dVar3;
        dVar = this.f3952a.f3950a;
        if (dVar != null) {
            dVar2 = this.f3952a.f3950a;
            if (dVar2.isCheckedAudioCompressor() != z) {
                dVar3 = this.f3952a.f3950a;
                dVar3.setAudioCompressor(z);
                this.f3952a.d();
            }
        }
    }
}
