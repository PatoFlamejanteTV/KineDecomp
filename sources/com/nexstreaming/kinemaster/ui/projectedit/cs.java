package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionChromaKeyFragment.java */
/* loaded from: classes.dex */
class cs implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cr f3826a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cr crVar) {
        this.f3826a = crVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        NexTimelineItem.c cVar;
        SwitchCompat switchCompat;
        NexTimelineItem.c cVar2;
        SwitchCompat switchCompat2;
        cVar = this.f3826a.l;
        if (cVar != null) {
            switchCompat = this.f3826a.f3825a;
            if (switchCompat != null) {
                cVar2 = this.f3826a.l;
                switchCompat2 = this.f3826a.f3825a;
                cVar2.setChromaKeyEnabled(switchCompat2.isChecked());
                this.f3826a.d();
                this.f3826a.f();
            }
        }
    }
}
