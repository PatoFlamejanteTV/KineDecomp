package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.GroupLayer;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nexstreaming.kinemaster.ui.projectedit.OptionMenuItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GroupEditFragment.java */
/* loaded from: classes2.dex */
public class Pa extends Xc implements InterfaceC1866cf {
    private LayerTransformTouchHandler E;
    private GroupLayer C = null;
    private MarchingAnts D = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
    private Object F = this;
    private VideoEditor.b G = new La(this);
    private List<OptionMenuItem> H = new ArrayList();
    private InterfaceC1997rd I = new Ma(this);
    private View.OnLayoutChangeListener J = new Na(this);
    private ViewTreeObserver.OnGlobalLayoutListener K = new Oa(this);

    /* JADX INFO: Access modifiers changed from: private */
    public GroupLayer Ba() {
        if (Y() instanceof GroupLayer) {
            return (GroupLayer) Y();
        }
        return null;
    }

    private void Ca() {
        GroupLayer groupLayer = this.C;
        if (groupLayer != null) {
            for (NexSecondaryTimelineItem nexSecondaryTimelineItem : groupLayer.getChildList()) {
                if (nexSecondaryTimelineItem instanceof TextLayer) {
                    OptionMenuItem.a a2 = OptionMenuItem.a();
                    a2.k();
                    a2.e(R.string.layer_menu_text);
                    a2.a(((TextLayer) nexSecondaryTimelineItem).getText());
                    a2.a(nexSecondaryTimelineItem);
                    a2.g();
                    OptionMenuItem a3 = a2.a();
                    if (a3 != null) {
                        this.H.add(a3);
                    }
                }
            }
        }
    }

    public void Aa() {
        if (Ba() != null) {
            g(wa());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        if (Y() instanceof GroupLayer) {
            this.C = (GroupLayer) Y();
            a(za());
            Rect rect = new Rect();
            this.C.getBounds(rect);
            if (this.D == null) {
                this.D = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
            }
            this.D.a(rect);
            LayerTransformTouchHandler layerTransformTouchHandler = this.E;
            if (layerTransformTouchHandler != null) {
                layerTransformTouchHandler.a(this.C);
            }
            View Q = Q();
            if (Q != null) {
                Q.addOnLayoutChangeListener(this.J);
                Q.getViewTreeObserver().addOnGlobalLayoutListener(this.K);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.C = Ba();
        Ca();
        this.E = new LayerTransformTouchHandler(onCreateView.getContext(), Ba(), da());
        this.E.a(this.C);
        na();
        return onCreateView;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.E = null;
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        this.D = null;
        da().a(this.F, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean r(int i) {
        if (i != R.id.opt_groupmenu_ungroup) {
            return false;
        }
        GroupLayer groupLayer = this.C;
        if (groupLayer != null) {
            int startTime = groupLayer.getStartTime();
            int trackId = this.C.getTrackId();
            this.C.getBounds(new Rect());
            NexLayerItem.b closestKeyframe = this.C.getClosestKeyframe(0.0f);
            NexTimeline timeline = this.C.getTimeline();
            if (timeline == null) {
                return false;
            }
            for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.C.getChildList()) {
                nexSecondaryTimelineItem.moveClip(nexSecondaryTimelineItem.getAbsStartTime() + startTime);
                nexSecondaryTimelineItem.setTrackId(trackId);
                if (nexSecondaryTimelineItem instanceof NexLayerItem) {
                    for (NexLayerItem.b bVar : ((NexLayerItem) nexSecondaryTimelineItem).getKeyFrames()) {
                        Matrix matrix = new Matrix();
                        matrix.reset();
                        matrix.postTranslate(closestKeyframe.f20232c, closestKeyframe.f20233d);
                        matrix.postRotate(closestKeyframe.f20234e, closestKeyframe.f20232c, closestKeyframe.f20233d);
                        float f2 = closestKeyframe.f20231b;
                        matrix.postScale(f2, f2, closestKeyframe.f20232c, closestKeyframe.f20233d);
                        float[] fArr = {bVar.f20232c, bVar.f20233d};
                        matrix.mapPoints(fArr);
                        bVar.f20232c = fArr[0];
                        bVar.f20233d = fArr[1];
                        bVar.f20234e += closestKeyframe.f20234e;
                        bVar.f20231b *= closestKeyframe.f20231b;
                    }
                }
                timeline.addSecondaryItem(nexSecondaryTimelineItem);
            }
            timeline.deleteSecondaryItem(this.C);
            da().H();
            da().J();
        }
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected int[] ua() {
        int[] iArr = new int[this.H.size() + 5];
        iArr[0] = R.id.opt_groupmenu_ungroup;
        iArr[1] = R.id.opt_in_expression;
        iArr[2] = R.id.opt_overall_expression;
        iArr[3] = R.id.opt_out_expression;
        for (int i = 4; i < iArr.length - 1; i++) {
            iArr[i] = this.H.get(i - 4).f21997c;
        }
        iArr[iArr.length - 1] = R.id.opt_information;
        return iArr;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected String wa() {
        if (Ba() != null) {
            return Ba().getDescriptiveTitle(xa());
        }
        return null;
    }

    public InterfaceC1997rd za() {
        return this.I;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1866cf
    public boolean a(View view, MotionEvent motionEvent) {
        LayerTransformTouchHandler layerTransformTouchHandler;
        if (!isAdded() || Ba() == null || (layerTransformTouchHandler = this.E) == null) {
            return false;
        }
        return layerTransformTouchHandler.a(view, motionEvent);
    }
}
