package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionRotateFragmentForHW.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.we, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC2066we implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2074xe f22754a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2066we(C2074xe c2074xe) {
        this.f22754a = c2074xe;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem.s sVar = this.f22754a.l;
        if (sVar == null) {
            return;
        }
        sVar.setRotation(90);
        this.f22754a.G();
    }
}