package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;

/* compiled from: NudgeFragment.java */
/* loaded from: classes2.dex */
class Rb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Sb f22046a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rb(Sb sb) {
        this.f22046a = sb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexLayerItem nexLayerItem;
        NexLayerItem nexLayerItem2;
        ViewOnLayoutChangeListenerC1995rb viewOnLayoutChangeListenerC1995rb;
        NexLayerItem nexLayerItem3;
        ViewOnLayoutChangeListenerC1995rb viewOnLayoutChangeListenerC1995rb2;
        NexLayerItem nexLayerItem4;
        ViewOnLayoutChangeListenerC1995rb viewOnLayoutChangeListenerC1995rb3;
        NexLayerItem nexLayerItem5;
        ViewOnLayoutChangeListenerC1995rb viewOnLayoutChangeListenerC1995rb4;
        nexLayerItem = this.f22046a.l;
        if (nexLayerItem == null) {
            return;
        }
        int id = view.getId();
        if (id != R.id.nudge_down) {
            switch (id) {
                case R.id.nudge_left /* 2131363066 */:
                    nexLayerItem3 = this.f22046a.l;
                    nexLayerItem3.getKeyFrames().get(0).f20232c -= 10.0f;
                    viewOnLayoutChangeListenerC1995rb2 = this.f22046a.m;
                    viewOnLayoutChangeListenerC1995rb2.b();
                    this.f22046a.n = true;
                    this.f22046a.va();
                    return;
                case R.id.nudge_right /* 2131363067 */:
                    nexLayerItem4 = this.f22046a.l;
                    nexLayerItem4.getKeyFrames().get(0).f20232c += 10.0f;
                    viewOnLayoutChangeListenerC1995rb3 = this.f22046a.m;
                    viewOnLayoutChangeListenerC1995rb3.b();
                    this.f22046a.n = true;
                    this.f22046a.va();
                    return;
                case R.id.nudge_up /* 2131363068 */:
                    nexLayerItem5 = this.f22046a.l;
                    nexLayerItem5.getKeyFrames().get(0).f20233d -= 1.0f;
                    viewOnLayoutChangeListenerC1995rb4 = this.f22046a.m;
                    viewOnLayoutChangeListenerC1995rb4.b();
                    this.f22046a.n = true;
                    this.f22046a.va();
                    return;
                default:
                    return;
            }
        }
        nexLayerItem2 = this.f22046a.l;
        nexLayerItem2.getKeyFrames().get(0).f20233d += 1.0f;
        viewOnLayoutChangeListenerC1995rb = this.f22046a.m;
        viewOnLayoutChangeListenerC1995rb.b();
        this.f22046a.n = true;
        this.f22046a.va();
    }
}
