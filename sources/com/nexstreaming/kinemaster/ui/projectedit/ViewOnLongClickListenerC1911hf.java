package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;
import com.nexstreaming.kinemaster.ui.widget.PopoutBookmarkListMenu;
import com.nextreaming.nexeditorui.NexTimeline;
import java.util.Arrays;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.hf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnLongClickListenerC1911hf implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22369a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnLongClickListenerC1911hf(ProjectEditActivity projectEditActivity) {
        this.f22369a = projectEditActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        InterfaceC2025f interfaceC2025f;
        InterfaceC2025f interfaceC2025f2;
        InterfaceC2025f interfaceC2025f3;
        Activity u;
        View view2;
        boolean z;
        interfaceC2025f = this.f22369a.T;
        NexTimeline timeline = interfaceC2025f.getTimeline();
        this.f22369a.ja().M();
        interfaceC2025f2 = this.f22369a.T;
        int currentTime = interfaceC2025f2.getCurrentTime();
        interfaceC2025f3 = this.f22369a.T;
        if (currentTime > interfaceC2025f3.getTimeline().getTotalTime()) {
            return false;
        }
        int[] bookmarks = timeline.getBookmarks();
        u = this.f22369a.u();
        PopoutBookmarkListMenu popoutBookmarkListMenu = new PopoutBookmarkListMenu(u, true);
        if (bookmarks.length > 0) {
            popoutBookmarkListMenu.a(-1, R.string.bookmark_clear_all);
        }
        Arrays.sort(bookmarks);
        int i = 0;
        for (int i2 : bookmarks) {
            if (i2 <= timeline.getTotalTime()) {
                String str = timeline.isSameBookmark(i2, currentTime) ? "✓" : "";
                popoutBookmarkListMenu.a(bookmarks[i], str + c.d.b.m.o.b(i2));
                i++;
            }
        }
        popoutBookmarkListMenu.a(-2, timeline.isBookmark(currentTime) ? R.string.bookmark_remove : R.string.bookmark_add);
        view2 = this.f22369a.Ba;
        z = this.f22369a.da;
        popoutBookmarkListMenu.a(view2, z ? 80 : 48);
        popoutBookmarkListMenu.a(new C1902gf(this, currentTime));
        return false;
    }
}
