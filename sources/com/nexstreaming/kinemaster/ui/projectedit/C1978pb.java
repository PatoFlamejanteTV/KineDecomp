package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.List;

/* compiled from: LayerAnimationFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.pb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1978pb extends Bg implements VideoEditor.g, InterfaceC1866cf {
    private NexLayerItem l;
    private IconButton m;
    private IconButton n;
    private IconButton o;
    private IconButton p;
    private float q;
    private int r;
    private LayerTransformTouchHandler t;
    private Object s = this;
    private MarchingAnts u = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
    private View.OnLayoutChangeListener v = new ViewOnLayoutChangeListenerC1960nb(this);
    private ViewTreeObserver.OnGlobalLayoutListener w = new ViewTreeObserverOnGlobalLayoutListenerC1969ob(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i) {
        NexLayerItem nexLayerItem = this.l;
        if (nexLayerItem != null && nexLayerItem.getKeyFrames() != null) {
            float c2 = (this.r / c(this.l)) * this.l.getDuration();
            NexLayerItem nexLayerItem2 = this.l;
            NexLayerItem.b closestKeyframe = nexLayerItem2.getClosestKeyframe(nexLayerItem2.getScaledTime(i));
            float f2 = closestKeyframe.f20230a;
            float scaledTime = this.l.getScaledTime(i) - f2;
            float abs = Math.abs(scaledTime);
            List<NexLayerItem.b> keyFrames = this.l.getKeyFrames();
            int size = keyFrames.size();
            boolean z = size > 1;
            if (abs * this.l.getDuration() >= c2) {
                this.n.setEnabled(false);
                this.m.setEnabled(true);
                if (z) {
                    if (keyFrames.indexOf(closestKeyframe) == size - 1 && scaledTime > 0.0f) {
                        this.o.setEnabled(false);
                    } else {
                        this.o.setEnabled(true);
                    }
                } else {
                    this.o.setEnabled(false);
                }
                this.p.setEnabled(true);
                return;
            }
            if (f2 == 0.0f) {
                this.n.setEnabled(false);
                this.m.setEnabled(false);
                if (z) {
                    this.o.setEnabled(true);
                } else {
                    this.o.setEnabled(false);
                }
                this.p.setEnabled(false);
                return;
            }
            this.q = f2;
            this.n.setEnabled(true);
            this.m.setEnabled(false);
            if (keyFrames.indexOf(closestKeyframe) == size - 1) {
                this.o.setEnabled(false);
            } else {
                this.o.setEnabled(true);
            }
            this.p.setEnabled(true);
            return;
        }
        this.n.setEnabled(false);
        this.m.setEnabled(true);
    }

    private void va() {
        if (this.l != null) {
            wa();
            q(da().v());
            da().c((NexTimelineItem) this.l);
            da().H();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa() {
        NexLayerItem nexLayerItem = this.l;
        this.q = nexLayerItem.addKeyframe(nexLayerItem.getScaledTime(da().v())).f20230a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        NexLayerItem nexLayerItem;
        super.na();
        if (Y() != null && (Y() instanceof NexLayerItem)) {
            this.l = (NexLayerItem) Y();
        }
        LayerTransformTouchHandler layerTransformTouchHandler = this.t;
        if (layerTransformTouchHandler != null && (nexLayerItem = this.l) != null && nexLayerItem != layerTransformTouchHandler.a()) {
            this.t.a(this.l);
        }
        if (this.u == null) {
            this.u = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
        }
        Rect rect = new Rect();
        this.l.getBounds(rect);
        this.u.a(rect);
        if (Q() != null) {
            Q().addOnLayoutChangeListener(this.v);
            Q().getViewTreeObserver().addOnGlobalLayoutListener(this.w);
        }
        o(R.id.editmode_layer_anim);
        q(da().v());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layer_anim_fragment, viewGroup, false);
        a(inflate);
        n(R.string.layer_animation_panel_title);
        f(true);
        if (Y() != null && (Y() instanceof NexLayerItem)) {
            this.l = (NexLayerItem) Y();
        }
        o(R.id.editmode_layer_anim);
        this.m = (IconButton) inflate.findViewById(R.id.keyframeAddBtn);
        this.n = (IconButton) inflate.findViewById(R.id.keyframeRemoveBtn);
        this.o = (IconButton) inflate.findViewById(R.id.keyframeNextBtn);
        this.p = (IconButton) inflate.findViewById(R.id.keyframePrevBtn);
        this.r = getResources().getDimensionPixelSize(R.dimen.layer_anim_thumb_width);
        q(da().v());
        this.m.setOnClickListener(new ViewOnClickListenerC1924jb(this));
        this.n.setOnClickListener(new ViewOnClickListenerC1933kb(this));
        this.o.setOnClickListener(new ViewOnClickListenerC1942lb(this));
        this.p.setOnClickListener(new ViewOnClickListenerC1951mb(this));
        if (da() != null) {
            da().a(this);
        }
        this.t = new LayerTransformTouchHandler(getActivity(), this.l, da());
        if (this.u == null) {
            this.u = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
        }
        Rect rect = new Rect();
        this.l.getBounds(rect);
        RectF rectF = new RectF();
        if (this.l.getCropBounds(rectF)) {
            this.u.a(rectF);
        } else {
            this.u.a(rect);
        }
        this.u.a(this.l.getKeyFrames());
        if (Q() != null) {
            Q().addOnLayoutChangeListener(this.v);
            Q().getViewTreeObserver().addOnGlobalLayoutListener(this.w);
        }
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.t = null;
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        this.u = null;
        da().a(this.s, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        q(i);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1866cf
    public boolean a(View view, MotionEvent motionEvent) {
        NexLayerItem nexLayerItem;
        if (!isAdded() || (nexLayerItem = this.l) == null || this.t == null) {
            return false;
        }
        if (!nexLayerItem.isSplitScreenEnabled() && this.m.isEnabled() && da() != null) {
            NexLayerItem nexLayerItem2 = this.l;
            NexLayerItem.b interpolatedKeyframe = nexLayerItem2.getInterpolatedKeyframe(nexLayerItem2.getScaledTime(da().v()));
            int dimensionPixelSize = (int) ((((getResources().getDimensionPixelSize(R.dimen.marchingAnts_handle_touch_zone_size) * 1280) / view.getWidth()) / 2) * (1.0f / interpolatedKeyframe.f20231b));
            float[] fArr = {0.0f, 0.0f};
            float n = EditorGlobal.n();
            float m = EditorGlobal.m();
            float width = view.getWidth();
            float height = view.getHeight();
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.postScale(n / width, m / height);
            matrix.postTranslate(-interpolatedKeyframe.f20232c, -interpolatedKeyframe.f20233d);
            matrix.postRotate(-(interpolatedKeyframe.f20234e + this.l.getOrientation()), 0.0f, 0.0f);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            fArr[0] = x;
            fArr[1] = y;
            matrix.mapPoints(fArr);
            float f2 = fArr[0];
            float f3 = fArr[1];
            Rect rect = new Rect();
            this.l.getBounds(rect);
            RectF rectF = new RectF(rect);
            matrix.reset();
            matrix.postScale(interpolatedKeyframe.f20236g, interpolatedKeyframe.f20237h);
            matrix.mapRect(rectF);
            float f4 = rectF.right;
            float f5 = dimensionPixelSize;
            float f6 = rectF.top;
            RectF rectF2 = new RectF(f4 - f5, f6 - f5, f4 + f5, f6 + f5);
            float f7 = rectF.right;
            float f8 = rectF.bottom;
            RectF rectF3 = new RectF(f7 - f5, f8 - f5, f7 + f5, f8 + f5);
            if (rectF.contains(f2, f3) || rectF2.contains(f2, f3) || rectF3.contains(f2, f3)) {
                va();
            }
        }
        return this.t.a(view, motionEvent);
    }
}
