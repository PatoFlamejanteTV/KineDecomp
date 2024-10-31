package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* compiled from: OptionPanelAddTaskMedia.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.yd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC2081yd implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ad f22791a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2081yd(Ad ad) {
        this.f22791a = ad;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MediaPrepManager N = this.f22791a.N();
        MediaStoreItemId mediaMSID = this.f22791a.Y().getMediaMSID();
        if (mediaMSID == null || N == null) {
            return;
        }
        N.a(mediaMSID);
        N.a(this.f22791a.Y().getTimeline());
        this.f22791a.na();
    }
}
