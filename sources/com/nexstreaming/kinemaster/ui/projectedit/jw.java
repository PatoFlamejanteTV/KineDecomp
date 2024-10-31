package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.util.m;
import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.WhichTimeline;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
class jw extends TimelineView.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f4020a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jw(ProjectEditActivity projectEditActivity) {
        this.f4020a = projectEditActivity;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public boolean a(int i, boolean z) {
        this.f4020a.p().a(i);
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public void a(WhichTimeline whichTimeline, int i, int i2, NexTimelineItem nexTimelineItem) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public boolean a(WhichTimeline whichTimeline, int i, NexTimelineItem nexTimelineItem) {
        boolean G;
        boolean z;
        Runnable runnable;
        boolean z2;
        TimelineView timelineView;
        Runnable runnable2;
        TimelineView timelineView2;
        Runnable runnable3;
        this.f4020a.p().n();
        G = this.f4020a.G();
        if (G) {
            z = this.f4020a.Q;
            if (!z) {
                runnable = this.f4020a.ad;
                if (runnable != null) {
                    timelineView2 = this.f4020a.k;
                    runnable3 = this.f4020a.ad;
                    timelineView2.removeCallbacks(runnable3);
                }
                z2 = this.f4020a.p;
                if (!z2) {
                    this.f4020a.ad = new jx(this, nexTimelineItem);
                    timelineView = this.f4020a.k;
                    runnable2 = this.f4020a.ad;
                    timelineView.post(runnable2);
                }
            }
        }
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public boolean a() {
        this.f4020a.p().p();
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public boolean a(WhichTimeline whichTimeline, int i, NexTimelineItem nexTimelineItem, boolean z) {
        if (z) {
            this.f4020a.p().w().onComplete(new jy(this, nexTimelineItem));
            return true;
        }
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public boolean a(int i, int i2, NexPrimaryTimelineItem nexPrimaryTimelineItem) {
        TimelineView timelineView;
        KMUsage kMUsage = KMUsage.EditScreen_Timeline_MoveVisualClip;
        String[] strArr = new String[2];
        strArr[0] = "timelineExpanded";
        strArr[1] = this.f4020a.o() ? "expanded" : "not expanded";
        kMUsage.logEvent(strArr);
        this.f4020a.p().a(i, i2);
        this.f4020a.p().n();
        timelineView = this.f4020a.k;
        timelineView.invalidate();
        this.f4020a.p().l();
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public boolean a(int i, int i2, NexSecondaryTimelineItem nexSecondaryTimelineItem) {
        TimelineView timelineView;
        TimelineView timelineView2;
        KMUsage kMUsage = KMUsage.EditScreen_Timeline_MoveSecondaryClip;
        String[] strArr = new String[4];
        strArr[0] = "timelineExpanded";
        strArr[1] = this.f4020a.o() ? "expanded" : "not expanded";
        strArr[2] = "clipType";
        strArr[3] = nexSecondaryTimelineItem.getClass().getSimpleName();
        kMUsage.logEvent(strArr);
        nexSecondaryTimelineItem.moveClip(i2);
        this.f4020a.p().a((NexTimelineItem) nexSecondaryTimelineItem);
        this.f4020a.p().n();
        timelineView = this.f4020a.k;
        timelineView.invalidate();
        timelineView2 = this.f4020a.k;
        timelineView2.a((NexTimelineItem) nexSecondaryTimelineItem, true);
        this.f4020a.p().l();
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public void a(boolean z) {
        com.nexstreaming.app.general.util.m mVar;
        this.f4020a.t = z;
        mVar = this.f4020a.A;
        mVar.a((m.a) new jz(this));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public void b(boolean z) {
        com.nexstreaming.app.general.util.m mVar;
        this.f4020a.u = z;
        mVar = this.f4020a.A;
        mVar.a((m.a) new ka(this));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public void c(boolean z) {
        com.nexstreaming.app.general.util.m mVar;
        this.f4020a.v = z;
        mVar = this.f4020a.A;
        mVar.a((m.a) new kb(this));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public void a(int i) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public void b() {
    }
}
