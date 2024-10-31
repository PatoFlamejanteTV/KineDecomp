package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.project.TimelineResourceUsage;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: AudioMenuListFragment.java */
/* loaded from: classes.dex */
public class e extends ed implements VideoEditor.f, VideoEditor.g {

    /* renamed from: a, reason: collision with root package name */
    private NexAudioClipItem f3862a = null;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private int e = 0;

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        f();
        return onCreateView;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        super.onActivityCreated(bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, com.nexstreaming.kinemaster.ui.projectedit.a
    public boolean a(int i) {
        switch (i) {
            case R.id.action_play_pause /* 2131820570 */:
                o().r();
                return true;
            default:
                return false;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected String a() {
        if (i() == null) {
            return null;
        }
        NexTimelineItem m = m();
        String descriptiveTitle = m.getDescriptiveTitle(i());
        String descriptiveSubtitle = m.getDescriptiveSubtitle(i());
        if (descriptiveTitle == null && descriptiveSubtitle == null) {
            return m.getClass().getSimpleName();
        }
        return !((descriptiveSubtitle != null) & (descriptiveTitle == null)) ? descriptiveTitle : descriptiveSubtitle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    public String j_() {
        NexTimelineItem m = m();
        String descriptiveTitle = m.getDescriptiveTitle(i());
        String descriptiveSubtitle = m.getDescriptiveSubtitle(i());
        if (descriptiveTitle == null && descriptiveSubtitle == null) {
            m.getClass().getSimpleName();
            return descriptiveSubtitle;
        }
        if ((descriptiveSubtitle != null) & (descriptiveTitle == null)) {
            return null;
        }
        return descriptiveSubtitle;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected int[] c() {
        return m().getOptionMenuItems();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected boolean b(int i) {
        return m().isOptionApplied(i);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, com.nexstreaming.kinemaster.ui.projectedit.ep.a
    public void a(int i, boolean z) {
        if (i == R.id.opt_background) {
            new Handler().post(new f(this));
        }
        super.a(i, z);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ep.a
    public void c(int i) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected boolean d(int i) {
        switch (i) {
            case R.id.opt_background /* 2131820636 */:
                a(R.id.opt_background, m().getSwitchOption(R.id.opt_background) ? false : true);
                return true;
            case R.id.opt_extend_to_end /* 2131820652 */:
                a(R.id.opt_extend_to_end, m().getSwitchOption(R.id.opt_extend_to_end) ? false : true);
                return true;
            case R.id.opt_loop /* 2131820660 */:
                a(R.id.opt_loop, m().getSwitchOption(R.id.opt_loop) ? false : true);
                return true;
            case R.id.opt_voicerec_review /* 2131820690 */:
                if (this.f3862a == null) {
                    return true;
                }
                h();
                return true;
            default:
                return false;
        }
    }

    private void h() {
        if (this.c) {
            if (!this.d) {
                o().p().onComplete(new g(this));
                return;
            }
            return;
        }
        this.c = true;
        this.d = true;
        c(R.id.opt_voicerec_review, this.c);
        e(this.f3862a.getAbsStartTime(), false);
        this.e = -1;
        VideoEditor o = o();
        o.a(this.f3862a.getAbsStartTime(), true).onComplete(new i(this, o)).onFailure(new h(this));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, android.app.Fragment
    public void onAttach(Activity activity) {
        if (o() != null) {
            o().a((VideoEditor.g) this);
            o().a((VideoEditor.f) this);
        }
        super.onAttach(activity);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        o().b((VideoEditor.g) this);
        o().b((VideoEditor.f) this);
        super.onDetach();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, android.app.Fragment
    public void onDestroyView() {
        this.c = false;
        c(R.id.opt_voicerec_review, this.c);
        super.onDestroyView();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        if (this.c && !this.d && this.f3862a.getAbsEndTime() < i2) {
            o().p();
            this.c = false;
            c(R.id.opt_voicerec_review, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        NexTimelineItem m = m();
        if (m != null && (m instanceof NexAudioClipItem)) {
            this.f3862a = (NexAudioClipItem) m();
            VideoEditor o = o();
            if (!this.b && this.f3862a.getOverLimit() && o != null && o.f() != null) {
                this.b = true;
                if (o().f().a().getResourceUsage().a(this.f3862a).a(TimelineResourceUsage.Limit.AudioTrackCount)) {
                    com.nexstreaming.kinemaster.ui.a.a.a(getActivity()).f(R.string.tllimit_max_audio_title).a(R.string.tllimit_max_audio_text).a().show();
                }
            }
            if (this.f3862a.getAudioType() == NexAudioClipItem.AudioType.VoiceRecording) {
                g(0);
            } else {
                g(R.id.editmode_trim);
            }
            b(R.id.opt_extend_to_end, m.getSwitchOption(R.id.opt_loop));
            b(R.id.opt_split_trim, (m.getSwitchOption(R.id.opt_loop) && m.getSwitchOption(R.id.opt_extend_to_end)) ? false : true);
            if (this.f3862a.getIsVoiceRecording()) {
                e(true);
            }
        }
        super.f();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected boolean e() {
        return true;
    }

    @Override // android.app.Fragment
    public void onPause() {
        if (this.c) {
            o().p().onComplete(new l(this));
        }
        super.onPause();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.f
    public void a(VideoEditor.State state) {
        switch (state) {
            case Playing:
                a(false);
                return;
            case Idle:
                a(true);
                H();
                return;
            default:
                return;
        }
    }

    public void a(boolean z) {
        i(z);
        k(z);
        j(z);
    }

    private void H() {
        if (o() != null && o().u() < this.f3862a.getAbsEndTime() && o().u() > this.f3862a.getAbsStartTime()) {
            this.c = false;
            c(R.id.opt_voicerec_review, this.c);
        }
    }
}
