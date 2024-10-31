package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexeditorui.ba;

/* compiled from: OptionSplitFragment.java */
/* loaded from: classes.dex */
public class go extends ed implements cd, ba.a {

    /* renamed from: a */
    private NexTimelineItem.s f3932a;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Object m = m();
        if (m != null && (m instanceof NexVideoClipItem)) {
            this.f3932a = (NexTimelineItem.s) m;
            this.b = true;
            this.c = ((NexVideoClipItem) m).isImage();
        } else if (m != null && (m instanceof NexAudioClipItem)) {
            this.f3932a = (NexTimelineItem.s) m;
            this.b = false;
        } else if (m != null && (m instanceof NexLayerItem)) {
            this.f3932a = (NexTimelineItem.s) m;
            this.b = false;
        }
        g(R.id.editmode_trim);
        a((cd) this);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if ((m() instanceof NexVideoClipItem) && ((NexVideoClipItem) m()).isVideo() && Build.VERSION.SDK_INT >= 18) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else if (m() instanceof NexPrimaryTimelineItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else if (m() instanceof TextLayer) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip, R.id.action_align_center_horizontal, R.string.action_center_horizontal, R.id.action_align_center_vertical, R.string.action_center_vertical);
        } else if (m() instanceof NexLayerItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected String a() {
        return getResources().getString(R.string.split_panel_title);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected int[] c() {
        if (this.c) {
            return new int[]{R.id.split_to_left, R.id.split_to_right, R.id.split_at_playhead, R.id.split_freezeframe};
        }
        if (this.b) {
            return new int[]{R.id.split_to_left, R.id.split_to_right, R.id.split_at_playhead, R.id.split_extract_audio, R.id.split_freezeframe};
        }
        if (m() != null && (m() instanceof VideoLayer)) {
            return new int[]{R.id.split_to_left, R.id.split_to_right, R.id.split_at_playhead, R.id.split_extract_audio};
        }
        return new int[]{R.id.split_to_left, R.id.split_to_right, R.id.split_at_playhead};
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected boolean d(int i) {
        if (this.d) {
            return false;
        }
        switch (i) {
            case R.id.split_at_playhead /* 2131820711 */:
                this.d = true;
                o().a((NexTimelineItem) this.f3932a, q(), p());
                if (this.b) {
                    f(false);
                }
                s();
                this.d = false;
                return true;
            case R.id.split_extract_audio /* 2131820712 */:
                this.d = true;
                h();
                this.d = false;
                return true;
            case R.id.split_freezeframe /* 2131820713 */:
                this.d = true;
                i(false);
                k(false);
                j(false);
                l();
                int q = q();
                h(R.string.please_wait_capturing);
                o().a(D()).onResultAvailable(new gr(this, q)).onFailure((Task.OnFailListener) new gp(this));
                return true;
            case R.id.split_to_left /* 2131820714 */:
                this.d = true;
                this.f3932a.trimToLeft(q());
                if (this.b) {
                    f(false);
                    o().a(r());
                }
                s();
                d();
                this.d = false;
                return true;
            case R.id.split_to_right /* 2131820715 */:
                this.d = true;
                this.f3932a.trimToRight(q());
                if (this.b) {
                    g(false);
                }
                s();
                d();
                this.d = false;
                return true;
            default:
                return false;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        super.f();
        Object m = m();
        if (m != null && (m instanceof NexVideoClipItem)) {
            this.f3932a = (NexVideoClipItem) m;
            this.b = true;
        } else if (m != null && (m instanceof NexAudioClipItem)) {
            this.f3932a = (NexAudioClipItem) m;
            this.b = false;
        } else if (m != null && (m instanceof NexLayerItem)) {
            this.f3932a = (NexTimelineItem.s) m;
            this.b = false;
        }
        b(R.id.split_to_left, u());
        b(R.id.split_to_right, v());
        b(R.id.split_at_playhead, t());
        b(R.id.split_freezeframe, t());
        d(true);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.cd
    public void a(boolean z, boolean z2, boolean z3) {
        b(R.id.split_at_playhead, z);
        b(R.id.split_to_left, z2);
        b(R.id.split_to_right, z3);
        b(R.id.split_freezeframe, z3);
    }

    private void h() {
        VideoLayer videoLayer;
        NexVideoClipItem nexVideoClipItem = null;
        if (this.f3932a instanceof NexVideoClipItem) {
            nexVideoClipItem = (NexVideoClipItem) this.f3932a;
            videoLayer = null;
        } else {
            videoLayer = this.f3932a instanceof VideoLayer ? (VideoLayer) this.f3932a : null;
        }
        if (nexVideoClipItem != null) {
            NexAudioClipItem a2 = o().a(nexVideoClipItem.getAbsStartTime() - nexVideoClipItem.getTrimTimeStart(), nexVideoClipItem.getMediaPath(), false);
            nexVideoClipItem.setMuteAudio(true);
            o().a((NexTimelineItem) nexVideoClipItem);
            a2.trimClip(nexVideoClipItem.getAbsStartTime(), nexVideoClipItem.getAbsEndTime() - 1);
            d(a2);
            return;
        }
        if (videoLayer != null) {
            NexAudioClipItem a3 = o().a(videoLayer.getAbsStartTime() - videoLayer.getStartTrim(), videoLayer.getMediaPath(), false);
            videoLayer.setMuteAudio(true);
            o().a((NexTimelineItem) videoLayer);
            a3.trimClip(videoLayer.getAbsStartTime(), videoLayer.getAbsEndTime() - 1);
            d(a3);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ep.a
    public void c(int i) {
    }

    @Override // com.nextreaming.nexeditorui.ba.a
    public boolean l_() {
        return this.d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:            if (r1.e != false) goto L14;     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:            if (getFragmentManager().popBackStackImmediate() != false) goto L19;     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:            super.onResume();     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:            return;     */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, android.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResume() {
        /*
            r1 = this;
            boolean r0 = r1.e
            if (r0 == 0) goto Le
        L4:
            android.app.FragmentManager r0 = r1.getFragmentManager()
            boolean r0 = r0.popBackStackImmediate()
            if (r0 != 0) goto L4
        Le:
            super.onResume()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.go.onResume():void");
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected boolean j() {
        return true;
    }
}
