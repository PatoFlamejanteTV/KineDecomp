package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionMaskFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.cd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1864cd implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1891fd f22299a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1864cd(C1891fd c1891fd) {
        this.f22299a = c1891fd;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        NexTimelineItem.o oVar;
        SwitchCompat switchCompat;
        NexTimelineItem.o oVar2;
        SwitchCompat switchCompat2;
        oVar = this.f22299a.r;
        if (oVar != null) {
            switchCompat = this.f22299a.o;
            if (switchCompat != null) {
                oVar2 = this.f22299a.r;
                switchCompat2 = this.f22299a.o;
                oVar2.setLayerMaskEnabled(switchCompat2.isChecked());
                this.f22299a.G();
                this.f22299a.na();
            }
        }
    }
}
