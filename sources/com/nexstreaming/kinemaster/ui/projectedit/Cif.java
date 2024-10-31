package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.widget.ImageButton;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.util.HashMap;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.if, reason: invalid class name */
/* loaded from: classes2.dex */
class Cif implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageButton f22394a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22395b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cif(ProjectEditActivity projectEditActivity, ImageButton imageButton) {
        this.f22395b = projectEditActivity;
        this.f22394a = imageButton;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        BannerTimelineView bannerTimelineView;
        BannerTimelineView bannerTimelineView2;
        BannerTimelineView bannerTimelineView3;
        BannerTimelineView bannerTimelineView4;
        z = this.f22395b.gb;
        if (z) {
            return;
        }
        if (view.isSelected()) {
            this.f22395b.Ra = false;
            this.f22394a.setSelected(false);
            bannerTimelineView3 = this.f22395b.U;
            if (bannerTimelineView3 != null) {
                bannerTimelineView4 = this.f22395b.U;
                bannerTimelineView4.setEnabledAdBanner(true);
            }
        } else {
            this.f22395b.Ra = true;
            this.f22394a.setSelected(true);
            bannerTimelineView = this.f22395b.U;
            if (bannerTimelineView != null) {
                bannerTimelineView2 = this.f22395b.U;
                bannerTimelineView2.setEnabledAdBanner(false);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("aspect_ratio", EditorGlobal.l() == 0.5625f ? "9:16" : "1:1");
            KMEvents.EDIT_SET_FULLSCREEN.logEvent(hashMap);
        }
        this.f22395b.ja().M();
        this.f22395b.wa();
    }
}
