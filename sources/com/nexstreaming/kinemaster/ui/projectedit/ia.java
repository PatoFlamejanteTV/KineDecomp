package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
class ia implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f3971a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ia(ProjectEditActivity projectEditActivity) {
        this.f3971a = projectEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TimelineView timelineView;
        TimelineView timelineView2;
        TimelineView timelineView3;
        TimelineView timelineView4;
        timelineView = this.f3971a.k;
        int currentTime = timelineView.getCurrentTime();
        timelineView2 = this.f3971a.k;
        if (currentTime <= timelineView2.getTimeline().getTotalTime()) {
            timelineView3 = this.f3971a.k;
            boolean z = timelineView3.getTimeline().toggleBookmark(currentTime);
            this.f3971a.p().l();
            timelineView4 = this.f3971a.k;
            timelineView4.invalidate();
            KMUsage kMUsage = KMUsage.EditScreen_Bookmark;
            String[] strArr = new String[2];
            strArr[0] = NativeProtocol.WEB_DIALOG_ACTION;
            strArr[1] = z ? "set" : "clear";
            kMUsage.logEvent(strArr);
            if (z) {
                KMAppUsage.a(this.f3971a).a(KMAppUsage.KMMetric.AddBookmarkWhilePaused);
            }
        }
    }
}
