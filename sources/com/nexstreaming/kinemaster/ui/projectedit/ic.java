package com.nexstreaming.kinemaster.ui.projectedit;

import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.ui.widget.g;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
class ic implements g.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3973a;
    final /* synthetic */ ib b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ic(ib ibVar, int i) {
        this.b = ibVar;
        this.f3973a = i;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.g.b
    public void a(com.nexstreaming.kinemaster.ui.widget.g gVar, int i) {
        TimelineView timelineView;
        TimelineView timelineView2;
        TimelineView timelineView3;
        TimelineView timelineView4;
        TimelineView timelineView5;
        if (i == -1) {
            KMUsage.EditScreen_Bookmark.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "clear all");
            timelineView4 = this.b.f3972a.k;
            timelineView4.getTimeline().clearAllBookmarks();
            this.b.f3972a.p().l();
            timelineView5 = this.b.f3972a.k;
            timelineView5.invalidate();
            return;
        }
        if (i == -2) {
            KMUsage.EditScreen_Bookmark.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "toggle from menu");
            timelineView2 = this.b.f3972a.k;
            timelineView2.getTimeline().toggleBookmark(this.f3973a);
            this.b.f3972a.p().l();
            timelineView3 = this.b.f3972a.k;
            timelineView3.invalidate();
            return;
        }
        if (i >= 0) {
            KMUsage.EditScreen_Bookmark.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "jump from menu");
            timelineView = this.b.f3972a.k;
            timelineView.a(i, true);
        }
    }
}
