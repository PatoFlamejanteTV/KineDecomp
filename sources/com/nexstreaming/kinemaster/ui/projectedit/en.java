package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionMaskFragment.java */
/* loaded from: classes.dex */
class en implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ em f3875a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(em emVar) {
        this.f3875a = emVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        NexTimelineItem.m mVar;
        SwitchCompat switchCompat;
        NexTimelineItem.m mVar2;
        SwitchCompat switchCompat2;
        mVar = this.f3875a.d;
        if (mVar != null) {
            switchCompat = this.f3875a.f3873a;
            if (switchCompat != null) {
                mVar2 = this.f3875a.d;
                switchCompat2 = this.f3875a.f3873a;
                mVar2.setLayerMaskEnabled(switchCompat2.isChecked());
                this.f3875a.d();
                this.f3875a.f();
            }
        }
    }
}
