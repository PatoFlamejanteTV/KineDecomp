package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: OptionMenuFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.pd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1980pd extends Xc {
    private void Aa() {
        VideoLayer videoLayer;
        NexTimelineItem Y = Y();
        if (Y == null) {
            return;
        }
        NexVideoClipItem nexVideoClipItem = null;
        if (Y instanceof NexVideoClipItem) {
            nexVideoClipItem = (NexVideoClipItem) Y;
            videoLayer = null;
        } else {
            videoLayer = Y instanceof VideoLayer ? (VideoLayer) Y : null;
        }
        if (nexVideoClipItem != null) {
            NexAudioClipItem a2 = da().a(nexVideoClipItem.getAbsStartTime() - nexVideoClipItem.getTrimTimeStart(), nexVideoClipItem.getMediaPath(), false);
            nexVideoClipItem.setMuteAudio(true);
            da().c(nexVideoClipItem);
            a2.trimClip(nexVideoClipItem.getAbsStartTime(), nexVideoClipItem.getAbsEndTime() - 1);
            b(a2);
            return;
        }
        if (videoLayer != null) {
            NexAudioClipItem a3 = da().a(videoLayer.getAbsStartTime() - videoLayer.getStartTrim(), videoLayer.getMediaPath(), false);
            videoLayer.setMuteAudio(true);
            da().c((NexTimelineItem) videoLayer);
            a3.trimClip(videoLayer.getAbsStartTime(), videoLayer.getAbsEndTime() - 1);
            b(a3);
        }
    }

    private void a(NexVideoClipItem nexVideoClipItem) {
        MediaInfo.a(nexVideoClipItem.getMediaPath()).a(800, 450, 0, 1000, 15, 0, new C1962nd(this)).onFailure(new C1953md(this)).onComplete(new C1944ld(this));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1976p
    public boolean h(int i) {
        if (i == R.id.action_play_pause) {
            da().D();
            return true;
        }
        if (i != R.id.action_test) {
            return false;
        }
        NexTimelineItem Y = Y();
        if (Y != null && (Y instanceof NexVideoClipItem)) {
            a((NexVideoClipItem) Y);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        if (Y() instanceof NexVideoClipItem) {
            Fragment findFragmentById = getFragmentManager() != null ? getFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder) : null;
            if (findFragmentById != null && (findFragmentById instanceof com.nexstreaming.kinemaster.ui.assetbrowser.i) && findFragmentById.isAdded()) {
                return;
            }
            o(R.id.editmode_trim);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if (Y() instanceof NexVideoClipItem) {
            o(R.id.editmode_trim);
        } else {
            o(0);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        NexTimelineItem Y = Y();
        View findViewById = onCreateView.findViewById(R.id.descTitleSm);
        if (findViewById != null && (Y instanceof NexVideoClipItem)) {
            String mediaPath = ((NexVideoClipItem) Y).getMediaPath();
            findViewById.setLongClickable(true);
            findViewById.setOnClickListener(new ViewOnClickListenerC1971od(this, mediaPath));
        }
        return onCreateView;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean q(int i) {
        return Y().isOptionApplied(i);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean r(int i) {
        if (i == R.id.opt_extract_audio) {
            Aa();
            return true;
        }
        if (i != R.id.opt_reverse) {
            return false;
        }
        e(Y());
        return true;
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
        NexTimelineItem Y = Y();
        String descriptiveTitle = Y.getDescriptiveTitle(xa());
        String descriptiveSubtitle = Y.getDescriptiveSubtitle(xa());
        if (descriptiveTitle == null && descriptiveSubtitle == null) {
            return Y.getClass().getSimpleName();
        }
        return (descriptiveSubtitle != null) & (descriptiveTitle == null) ? descriptiveSubtitle : descriptiveTitle;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.C1935kd.a
    public void a(int i) {
        super.a(i);
    }
}
