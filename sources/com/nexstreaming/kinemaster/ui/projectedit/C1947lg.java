package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import com.nexstreaming.app.general.util.u;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.WhichTimeline;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.lg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1947lg extends TimelineView.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22438a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1947lg(ProjectEditActivity projectEditActivity) {
        this.f22438a = projectEditActivity;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public void a(int i) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public void a(WhichTimeline whichTimeline, int i, int i2, NexTimelineItem nexTimelineItem) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public boolean a(int i, boolean z) {
        VideoEditor.State state;
        VideoEditor.State state2;
        VideoEditor.State state3;
        state = this.f22438a._a;
        if (state == VideoEditor.State.Playing) {
            return false;
        }
        state2 = this.f22438a._a;
        if (state2 == VideoEditor.State.ReversePlay) {
            return false;
        }
        state3 = this.f22438a._a;
        if (state3 == VideoEditor.State.Exporting) {
            return false;
        }
        this.f22438a.ja().b(i);
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public void b() {
    }

    public boolean b(WhichTimeline whichTimeline, int i, NexTimelineItem nexTimelineItem) {
        InterfaceC2025f interfaceC2025f;
        Runnable runnable;
        this.f22438a.ib = new RunnableC1885eg(this, nexTimelineItem);
        interfaceC2025f = this.f22438a.T;
        runnable = this.f22438a.ib;
        interfaceC2025f.post(runnable);
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public void c(boolean z) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public boolean c() {
        this.f22438a.ja().M();
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public void d(boolean z) {
        com.nexstreaming.app.general.util.u uVar;
        this.f22438a.fa = z;
        uVar = this.f22438a.oa;
        uVar.a((u.a) new C1920ig(this));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public void a() {
        Runnable runnable;
        InterfaceC2025f interfaceC2025f;
        Runnable runnable2;
        runnable = this.f22438a.ib;
        if (runnable != null) {
            interfaceC2025f = this.f22438a.T;
            runnable2 = this.f22438a.ib;
            interfaceC2025f.removeCallbacks(runnable2);
            this.f22438a.ib = null;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public void b(boolean z) {
        com.nexstreaming.app.general.util.u uVar;
        this.f22438a.ha = z;
        uVar = this.f22438a.oa;
        uVar.a((u.a) new C1938kg(this));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public boolean a(WhichTimeline whichTimeline, int i, NexTimelineItem nexTimelineItem) {
        boolean E;
        boolean z;
        Runnable runnable;
        boolean z2;
        boolean n;
        InterfaceC2025f interfaceC2025f;
        Activity u;
        InterfaceC2025f interfaceC2025f2;
        Runnable runnable2;
        boolean z3;
        this.f22438a.ja().H();
        E = this.f22438a.E();
        if (!E) {
            return false;
        }
        z = this.f22438a.Ga;
        if (z) {
            return false;
        }
        if (nexTimelineItem == null) {
            z3 = this.f22438a.da;
            if (z3) {
                this.f22438a.a(new int[]{R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_play_pause, R.drawable.action_play_pause, R.id.action_expand_preview, R.drawable.action_inset_preview}, (InterfaceC1976p) null);
            } else {
                this.f22438a.a(new int[]{R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_share, R.drawable.action_icon_share, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_settings, R.drawable.action_icon_settings}, (InterfaceC1976p) null);
            }
        }
        runnable = this.f22438a.ib;
        if (runnable != null) {
            interfaceC2025f2 = this.f22438a.T;
            runnable2 = this.f22438a.ib;
            interfaceC2025f2.removeCallbacks(runnable2);
        }
        z2 = this.f22438a.ba;
        if (z2) {
            return false;
        }
        n = this.f22438a.n(nexTimelineItem);
        if (!n) {
            interfaceC2025f = this.f22438a.T;
            if (interfaceC2025f.getSelectedItem() != null) {
                u = this.f22438a.u();
                e.a aVar = new e.a(u);
                aVar.c(R.string.Ratio_mismatch_msg);
                aVar.c(R.string.button_delete, new DialogInterfaceOnClickListenerC1903gg(this, nexTimelineItem, whichTimeline, i));
                aVar.a(R.string.Ratio_mismatch_keep_btn, new DialogInterfaceOnClickListenerC1894fg(this));
                aVar.a().show();
                return false;
            }
        }
        return b(whichTimeline, i, nexTimelineItem);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public boolean a(com.nexstreaming.kinemaster.editorwrapper.Ea ea) {
        boolean E;
        E = this.f22438a.E();
        if (!E) {
            return false;
        }
        this.f22438a.f(true);
        ProjectEditActivity.a(this.f22438a.getSupportFragmentManager().beginTransaction()).replace(this.f22438a.pa() ? R.id.fitOptionPanelHolder : R.id.optionPanelHolder, com.nexstreaming.kinemaster.ui.projectedit.timeline.P.a(ea)).addToBackStack(com.nexstreaming.kinemaster.ui.projectedit.timeline.P.class.getSimpleName()).commit();
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public boolean a(WhichTimeline whichTimeline, int i, NexTimelineItem nexTimelineItem, boolean z) {
        if (!z) {
            return true;
        }
        this.f22438a.ja().p().onComplete(new C1912hg(this, nexTimelineItem));
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public boolean a(int i, int i2, NexPrimaryTimelineItem nexPrimaryTimelineItem) {
        InterfaceC2025f interfaceC2025f;
        this.f22438a.ja().a(i, i2);
        this.f22438a.ja().H();
        interfaceC2025f = this.f22438a.T;
        interfaceC2025f.invalidate();
        this.f22438a.ja().J();
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public boolean a(int i, int i2, NexSecondaryTimelineItem nexSecondaryTimelineItem) {
        InterfaceC2025f interfaceC2025f;
        InterfaceC2025f interfaceC2025f2;
        nexSecondaryTimelineItem.moveClip(i2);
        this.f22438a.ja().c(nexSecondaryTimelineItem);
        this.f22438a.ja().H();
        interfaceC2025f = this.f22438a.T;
        interfaceC2025f.invalidate();
        interfaceC2025f2 = this.f22438a.T;
        interfaceC2025f2.b(nexSecondaryTimelineItem, true);
        this.f22438a.ja().J();
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.d
    public void a(boolean z) {
        com.nexstreaming.app.general.util.u uVar;
        this.f22438a.ga = z;
        uVar = this.f22438a.oa;
        uVar.a((u.a) new C1929jg(this));
    }
}
