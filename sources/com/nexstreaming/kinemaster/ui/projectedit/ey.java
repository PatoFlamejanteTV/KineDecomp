package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;

/* compiled from: OptionPanelAddTaskMedia.java */
/* loaded from: classes.dex */
class ey implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ex f3887a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ey(ex exVar) {
        this.f3887a = exVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MediaPrepManager B = this.f3887a.B();
        MSID mediaMSID = this.f3887a.m().getMediaMSID();
        if (mediaMSID != null && B != null) {
            B.a(mediaMSID);
            B.a(this.f3887a.m().getTimeline());
            this.f3887a.f();
        }
    }
}
