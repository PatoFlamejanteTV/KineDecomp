package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionChromaKeyFragment.java */
/* loaded from: classes2.dex */
class Yb implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1899gc f22179a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Yb(C1899gc c1899gc) {
        this.f22179a = c1899gc;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        NexTimelineItem.d dVar;
        SwitchCompat switchCompat;
        NexTimelineItem.d dVar2;
        SwitchCompat switchCompat2;
        dVar = this.f22179a.w;
        if (dVar != null) {
            switchCompat = this.f22179a.l;
            if (switchCompat != null) {
                dVar2 = this.f22179a.w;
                switchCompat2 = this.f22179a.l;
                dVar2.setChromaKeyEnabled(switchCompat2.isChecked());
                this.f22179a.G();
                this.f22179a.na();
            }
        }
    }
}
