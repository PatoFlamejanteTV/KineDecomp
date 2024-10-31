package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ff, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC1893ff implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22336a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1893ff(ProjectEditActivity projectEditActivity) {
        this.f22336a = projectEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC2025f interfaceC2025f;
        InterfaceC2025f interfaceC2025f2;
        InterfaceC2025f interfaceC2025f3;
        TimelineView.d dVar;
        InterfaceC2025f interfaceC2025f4;
        interfaceC2025f = this.f22336a.T;
        int currentTime = interfaceC2025f.getCurrentTime();
        interfaceC2025f2 = this.f22336a.T;
        if (currentTime > interfaceC2025f2.getTimeline().getTotalTime()) {
            return;
        }
        interfaceC2025f3 = this.f22336a.T;
        interfaceC2025f3.getTimeline().toggleBookmark(currentTime);
        this.f22336a.ja().J();
        dVar = this.f22336a.jb;
        dVar.a(currentTime, true);
        interfaceC2025f4 = this.f22336a.T;
        interfaceC2025f4.invalidate();
    }
}
