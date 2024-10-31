package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionRotateFragmentForHW.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ve, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC2057ve implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2074xe f22741a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2057ve(C2074xe c2074xe) {
        this.f22741a = c2074xe;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem.s sVar = this.f22741a.l;
        if (sVar == null) {
            return;
        }
        sVar.setRotation(-90);
        this.f22741a.G();
    }
}
