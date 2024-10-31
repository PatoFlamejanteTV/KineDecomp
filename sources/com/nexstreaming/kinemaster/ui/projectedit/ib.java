package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.NexTimeline;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class ib implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f3972a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ib(ProjectEditActivity projectEditActivity) {
        this.f3972a = projectEditActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        TimelineView timelineView;
        TimelineView timelineView2;
        TimelineView timelineView3;
        Activity D;
        View view2;
        boolean z;
        int i;
        KMAppUsage.a(this.f3972a).a(KMAppUsage.KMMetric.BookmarkLongPressMenu);
        KMUsage.EditScreen_Bookmark.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "menu");
        timelineView = this.f3972a.k;
        NexTimeline timeline = timelineView.getTimeline();
        this.f3972a.p().p();
        timelineView2 = this.f3972a.k;
        int currentTime = timelineView2.getCurrentTime();
        timelineView3 = this.f3972a.k;
        if (currentTime <= timelineView3.getTimeline().getTotalTime()) {
            int[] bookmarks = timeline.getBookmarks();
            D = this.f3972a.D();
            com.nexstreaming.kinemaster.ui.widget.g gVar = new com.nexstreaming.kinemaster.ui.widget.g(D, true);
            if (bookmarks.length > 0) {
                gVar.a(-1, R.string.bookmark_clear_all);
            }
            Arrays.sort(bookmarks);
            int length = bookmarks.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = bookmarks[i2];
                if (i4 > timeline.getTotalTime()) {
                    i = i3;
                } else {
                    String str = "";
                    if (timeline.isSameBookmark(i4, currentTime)) {
                        str = "✓";
                    }
                    gVar.a(bookmarks[i3], str + com.nexstreaming.kinemaster.h.e.c(i4));
                    i = i3 + 1;
                }
                i2++;
                i3 = i;
            }
            gVar.a(-2, timeline.isBookmark(currentTime) ? R.string.bookmark_remove : R.string.bookmark_add);
            view2 = this.f3972a.N;
            z = this.f3972a.r;
            gVar.a(view2, z ? 80 : 48);
            gVar.a(new ic(this, currentTime));
        }
        return false;
    }
}
