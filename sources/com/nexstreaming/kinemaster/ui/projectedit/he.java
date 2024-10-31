package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: OptionSplitFragment.java */
/* loaded from: classes2.dex */
public class He extends Xc implements Tb, I.a, VideoEditor.g {
    private NexTimelineItem.u C;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private Og H;

    private void Aa() {
        VideoLayer videoLayer;
        NexTimelineItem.u uVar = this.C;
        NexVideoClipItem nexVideoClipItem = null;
        if (uVar instanceof NexVideoClipItem) {
            nexVideoClipItem = (NexVideoClipItem) uVar;
            videoLayer = null;
        } else {
            videoLayer = uVar instanceof VideoLayer ? (VideoLayer) uVar : null;
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

    public void g(NexTimelineItem nexTimelineItem) {
        FragmentActivity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return;
        }
        ((ProjectEditActivity) activity).j(nexTimelineItem);
    }

    public void h(NexTimelineItem nexTimelineItem) {
        FragmentActivity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return;
        }
        ((ProjectEditActivity) activity).k(nexTimelineItem);
    }

    public void i(NexTimelineItem nexTimelineItem) {
        FragmentActivity activity = getActivity();
        if (activity == null || !(activity instanceof ProjectEditActivity)) {
            return;
        }
        ((ProjectEditActivity) activity).l(nexTimelineItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        Fa.a Y = Y();
        if (Y != null && (Y instanceof NexVideoClipItem)) {
            this.C = (NexVideoClipItem) Y;
            this.D = true;
        } else if (Y != null && (Y instanceof NexAudioClipItem)) {
            this.C = (NexAudioClipItem) Y;
            this.D = false;
        } else if (Y != null && (Y instanceof NexLayerItem)) {
            this.C = (NexTimelineItem.u) Y;
            this.D = false;
        }
        d(R.id.split_to_left, A());
        d(R.id.split_to_right, B());
        d(R.id.split_at_playhead, C());
        d(R.id.split_freezeframe, C());
        f(true);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, com.nextreaming.nexeditorui.I.a
    public boolean onBackPressed() {
        return this.F;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Fa.a Y = Y();
        if (Y != null && (Y instanceof NexVideoClipItem)) {
            this.C = (NexTimelineItem.u) Y;
            this.D = true;
            this.E = ((NexVideoClipItem) Y).isImage();
        } else if (Y != null && (Y instanceof NexAudioClipItem)) {
            this.C = (NexTimelineItem.u) Y;
            this.D = false;
        } else if (Y != null && (Y instanceof NexLayerItem)) {
            this.C = (NexTimelineItem.u) Y;
            this.D = false;
        }
        o(R.id.editmode_trim);
        a((Tb) this);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:            if (r1.G != false) goto L4;     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:            if (getFragmentManager().popBackStackImmediate() == false) goto L9;     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:            super.onResume();     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:            return;     */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, android.support.v4.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResume() {
        /*
            r1 = this;
            boolean r0 = r1.G
            if (r0 == 0) goto Lf
        L4:
            android.support.v4.app.FragmentManager r0 = r1.getFragmentManager()
            boolean r0 = r0.popBackStackImmediate()
            if (r0 == 0) goto Lf
            goto L4
        Lf:
            super.onResume()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.He.onResume():void");
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean r(int i) {
        if (this.F) {
            return false;
        }
        NexTimelineItem nexTimelineItem = (NexTimelineItem) this.C;
        switch (i) {
            case R.id.split_at_playhead /* 2131363445 */:
                a(nexTimelineItem, "trim");
                this.F = true;
                g(nexTimelineItem);
                this.F = false;
                return true;
            case R.id.split_extract_audio /* 2131363447 */:
                this.F = true;
                Aa();
                this.F = false;
                return true;
            case R.id.split_freezeframe /* 2131363448 */:
                a(nexTimelineItem, "trim_insert_capture");
                this.F = true;
                l(false);
                j(false);
                k(false);
                I();
                int intValue = L().intValue();
                p(R.string.please_wait_capturing);
                da().a(X()).onResultAvailable(new Ge(this, intValue)).onFailure((Task.OnFailListener) new C2090ze(this));
                return true;
            case R.id.split_to_left /* 2131363453 */:
                a(nexTimelineItem, "trim_left");
                this.F = true;
                h(nexTimelineItem);
                this.F = false;
                return true;
            case R.id.split_to_right /* 2131363454 */:
                a(nexTimelineItem, "trim_right");
                this.F = true;
                i(nexTimelineItem);
                this.F = false;
                return true;
            default:
                return false;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean sa() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected int[] ua() {
        if (this.E) {
            return new int[]{R.id.split_to_left, R.id.split_to_right, R.id.split_at_playhead, R.id.split_freezeframe};
        }
        if (this.D) {
            return new int[]{R.id.split_to_left, R.id.split_to_right, R.id.split_at_playhead, R.id.split_freezeframe};
        }
        if (Y() != null && (Y() instanceof VideoLayer)) {
            return new int[]{R.id.split_to_left, R.id.split_to_right, R.id.split_at_playhead};
        }
        return new int[]{R.id.split_to_left, R.id.split_to_right, R.id.split_at_playhead};
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected String wa() {
        return getResources().getString(R.string.split_panel_title);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean ya() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:            if (((com.nextreaming.nexeditorui.NexVideoClipItem) r5).isImage() != false) goto L30;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.nextreaming.nexeditorui.NexTimelineItem r5, java.lang.String r6) {
        /*
            r4 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            boolean r1 = r5 instanceof com.nextreaming.nexeditorui.NexVideoClipItem
            java.lang.String r2 = "image"
            java.lang.String r3 = "video"
            if (r1 == 0) goto L18
            com.nextreaming.nexeditorui.NexVideoClipItem r5 = (com.nextreaming.nexeditorui.NexVideoClipItem) r5
            boolean r5 = r5.isImage()
            if (r5 == 0) goto L16
            goto L4d
        L16:
            r2 = r3
            goto L4d
        L18:
            boolean r1 = r5 instanceof com.nextreaming.nexeditorui.NexAudioClipItem
            if (r1 == 0) goto L1f
            java.lang.String r2 = "audio"
            goto L4d
        L1f:
            boolean r1 = r5 instanceof com.nexstreaming.kinemaster.layer.VideoLayer
            if (r1 == 0) goto L24
            goto L16
        L24:
            boolean r1 = r5 instanceof com.nexstreaming.kinemaster.layer.ImageLayer
            if (r1 == 0) goto L29
            goto L4d
        L29:
            boolean r1 = r5 instanceof com.nexstreaming.kinemaster.layer.HandwritingLayer
            if (r1 == 0) goto L30
            java.lang.String r2 = "handwrite"
            goto L4d
        L30:
            boolean r1 = r5 instanceof com.nexstreaming.kinemaster.layer.TextLayer
            if (r1 == 0) goto L37
            java.lang.String r2 = "text"
            goto L4d
        L37:
            boolean r1 = r5 instanceof com.nexstreaming.kinemaster.layer.AssetLayer
            if (r1 == 0) goto L4b
            com.nexstreaming.kinemaster.layer.AssetLayer r5 = (com.nexstreaming.kinemaster.layer.AssetLayer) r5
            com.nexstreaming.kinemaster.layer.AssetLayer$AssetLayerType r5 = r5.getLayerType()
            com.nexstreaming.kinemaster.layer.AssetLayer$AssetLayerType r1 = com.nexstreaming.kinemaster.layer.AssetLayer.AssetLayerType.EFFECT_LAYER
            if (r5 != r1) goto L48
            java.lang.String r2 = "effect"
            goto L4d
        L48:
            java.lang.String r2 = "overlay"
            goto L4d
        L4b:
            java.lang.String r2 = "UnKnown"
        L4d:
            java.lang.String r5 = "type"
            r0.put(r5, r2)
            java.lang.String r5 = "method"
            r0.put(r5, r6)
            com.nexstreaming.kinemaster.usage.analytics.KMEvents r5 = com.nexstreaming.kinemaster.usage.analytics.KMEvents.EDIT_CUT
            r5.logEvent(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.He.a(com.nextreaming.nexeditorui.NexTimelineItem, java.lang.String):void");
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Tb
    public void a(boolean z, boolean z2, boolean z3) {
        d(R.id.split_at_playhead, z);
        d(R.id.split_to_left, z2);
        d(R.id.split_to_right, z3);
        d(R.id.split_freezeframe, z3);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.C1935kd.a
    public void a(int i) {
        super.a(i);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        Og og = this.H;
        if (og == null) {
            return;
        }
        og.a(i, V().intValue());
        throw null;
    }
}
