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
import com.nexstreaming.kinemaster.ui.a.e;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: AudioMenuListFragment.java */
/* loaded from: classes2.dex */
public class X extends Xc implements VideoEditor.g, VideoEditor.f {
    private NexAudioClipItem C = null;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private int G = 0;

    private void Aa() {
        if (da() != null && da().s().a().getTotalTime() < this.C.getAbsEndTime() && this.E && !this.F) {
            this.E = false;
            e(R.id.opt_voicerec_review, this.E);
        }
    }

    private void Ba() {
        if (this.E) {
            if (this.F) {
                return;
            }
            da().M().onComplete(new P(this));
            return;
        }
        L();
        this.E = true;
        this.F = true;
        e(R.id.opt_voicerec_review, this.E);
        b(this.C.getAbsStartTime(), false);
        this.G = -1;
        VideoEditor da = da();
        da.a(this.C.getAbsStartTime(), true).onComplete(new U(this, da)).onFailure(new Q(this));
    }

    public static /* synthetic */ boolean b(X x, boolean z) {
        x.F = z;
        return z;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.C1935kd.a
    public void a(int i) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1976p
    public boolean h(int i) {
        if (i != R.id.action_play_pause) {
            return false;
        }
        da().D();
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        NexTimelineItem Y = Y();
        if (Y != null && (Y instanceof NexAudioClipItem)) {
            this.C = (NexAudioClipItem) Y();
            VideoEditor da = da();
            if (!this.D && this.C.getOverLimit() && da != null && da.s() != null) {
                this.D = true;
                if (da().s().a().getResourceUsage().a(this.C).a(TimelineResourceUsage.Limit.AudioTrackCount)) {
                    e.a a2 = com.nexstreaming.kinemaster.ui.a.e.a(getActivity());
                    a2.e(R.string.tllimit_max_audio_title);
                    a2.c(R.string.tllimit_max_audio_text);
                    a2.a().show();
                }
            }
            if (this.C.getAudioType() == NexAudioClipItem.AudioType.VoiceRecording) {
                o(0);
            } else {
                o(R.id.editmode_trim);
            }
            d(R.id.opt_extend_to_end, Y.getSwitchOption(R.id.opt_loop));
            d(R.id.opt_split_trim, (Y.getSwitchOption(R.id.opt_loop) && Y.getSwitchOption(R.id.opt_extend_to_end)) ? false : true);
            if (this.C.getIsVoiceRecording()) {
                d(true);
            }
        }
        super.na();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        if (da() != null) {
            da().a((VideoEditor.g) this);
            da().a((VideoEditor.f) this);
        }
        super.onAttach(activity);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        na();
        return onCreateView;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.E = false;
        e(R.id.opt_voicerec_review, this.E);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        da().b((VideoEditor.g) this);
        da().b((VideoEditor.f) this);
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        if (this.E) {
            da().M().onComplete(new V(this));
        }
        super.onPause();
    }

    public void p(boolean z) {
        l(z);
        j(z);
        k(z);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void pa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_expand_preview, R.drawable.action_inset_preview, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean q(int i) {
        return Y().isOptionApplied(i);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean r(int i) {
        switch (i) {
            case R.id.opt_background /* 2131363093 */:
                a(R.id.opt_background, !Y().getSwitchOption(R.id.opt_background));
                return true;
            case R.id.opt_extend_to_end /* 2131363112 */:
                a(R.id.opt_extend_to_end, !Y().getSwitchOption(R.id.opt_extend_to_end));
                return true;
            case R.id.opt_loop /* 2131363128 */:
                a(R.id.opt_loop, !Y().getSwitchOption(R.id.opt_loop));
                return true;
            case R.id.opt_voicerec_review /* 2131363165 */:
                if (this.C != null) {
                    Ba();
                }
                return true;
            default:
                return false;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean ta() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected int[] ua() {
        return Y().getOptionMenuItems();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected String va() {
        NexTimelineItem Y = Y();
        String descriptiveTitle = Y.getDescriptiveTitle(xa());
        String descriptiveSubtitle = Y.getDescriptiveSubtitle(xa());
        if (descriptiveTitle == null && descriptiveSubtitle == null) {
            Y.getClass().getSimpleName();
            return descriptiveSubtitle;
        }
        if ((descriptiveSubtitle != null) && (descriptiveTitle == null)) {
            return null;
        }
        return descriptiveSubtitle;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected String wa() {
        if (xa() == null) {
            return null;
        }
        NexTimelineItem Y = Y();
        String descriptiveTitle = Y.getDescriptiveTitle(xa());
        String descriptiveSubtitle = Y.getDescriptiveSubtitle(xa());
        if (descriptiveTitle == null && descriptiveSubtitle == null) {
            return Y.getClass().getSimpleName();
        }
        return (descriptiveSubtitle != null) & (descriptiveTitle == null) ? descriptiveSubtitle : descriptiveTitle;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.C1935kd.a
    public void a(int i, boolean z) {
        if (this.E && i != R.id.opt_voicerec_rerec) {
            Ba();
        }
        if (i == R.id.opt_background) {
            new Handler().post(new O(this));
        }
        super.a(i, z);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        if (!this.E || this.F || this.C.getAbsEndTime() >= i2) {
            return;
        }
        da().M();
        this.E = false;
        e(R.id.opt_voicerec_review, this.E);
        p(true);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.f
    public void a(VideoEditor.State state) {
        if (getActivity() == null) {
            return;
        }
        int i = W.f22161a[state.ordinal()];
        if (i == 1) {
            p(false);
        } else {
            if (i != 2) {
                return;
            }
            p(true);
            Aa();
        }
    }
}
