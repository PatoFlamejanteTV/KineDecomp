package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.List;

/* compiled from: LayerAnimationFragment.java */
/* loaded from: classes.dex */
public class az extends kp implements VideoEditor.g, ht {

    /* renamed from: a, reason: collision with root package name */
    private NexLayerItem f3779a;
    private IconButton b;
    private IconButton c;
    private IconButton d;
    private IconButton e;
    private float f;
    private int g;
    private LayerTransformTouchHandler h;
    private MarchingAnts i = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
    private View.OnLayoutChangeListener j = new be(this);
    private ViewTreeObserver.OnGlobalLayoutListener k = new bf(this);

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layer_anim_fragment, viewGroup, false);
        b(inflate);
        f(R.string.layer_animation_panel_title);
        d(true);
        if (m() != null && (m() instanceof NexLayerItem)) {
            this.f3779a = (NexLayerItem) m();
        }
        g(R.id.editmode_layer_anim);
        this.b = (IconButton) inflate.findViewById(R.id.keyframeAddBtn);
        this.c = (IconButton) inflate.findViewById(R.id.keyframeRemoveBtn);
        this.d = (IconButton) inflate.findViewById(R.id.keyframeNextBtn);
        this.e = (IconButton) inflate.findViewById(R.id.keyframePrevBtn);
        this.g = getResources().getDimensionPixelSize(R.dimen.layer_anim_thumb_width);
        b(o().u());
        this.b.setOnClickListener(new ba(this));
        this.c.setOnClickListener(new bb(this));
        this.d.setOnClickListener(new bc(this));
        this.e.setOnClickListener(new bd(this));
        if (o() != null) {
            o().a(this);
        }
        this.h = new LayerTransformTouchHandler(getActivity(), this.f3779a, o());
        if (this.i == null) {
            this.i = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
        }
        Rect rect = new Rect();
        this.f3779a.getBounds(rect);
        this.i.a(rect);
        if (w() != null) {
            w().addOnLayoutChangeListener(this.j);
            w().getViewTreeObserver().addOnGlobalLayoutListener(this.k);
        }
        return inflate;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.h = null;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onStop() {
        this.i = null;
        o().a((NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.f3779a != null && this.f3779a.getKeyFrames() != null) {
            float duration = this.f3779a.getDuration() * (this.g / e(this.f3779a));
            NexLayerItem.b closestKeyframe = this.f3779a.getClosestKeyframe(this.f3779a.getScaledTime(i));
            float f = closestKeyframe.f3299a;
            float scaledTime = this.f3779a.getScaledTime(i) - f;
            float abs = Math.abs(scaledTime);
            List<NexLayerItem.b> keyFrames = this.f3779a.getKeyFrames();
            int size = keyFrames.size();
            boolean z = size > 1;
            if (abs * this.f3779a.getDuration() >= duration) {
                this.c.setEnabled(false);
                this.b.setEnabled(true);
                if (z) {
                    if (keyFrames.indexOf(closestKeyframe) == size - 1 && scaledTime > 0.0f) {
                        this.d.setEnabled(false);
                    } else {
                        this.d.setEnabled(true);
                    }
                } else {
                    this.d.setEnabled(false);
                }
                this.e.setEnabled(true);
                return;
            }
            if (f == 0.0f) {
                this.c.setEnabled(false);
                this.b.setEnabled(false);
                if (z) {
                    this.d.setEnabled(true);
                } else {
                    this.d.setEnabled(false);
                }
                this.e.setEnabled(false);
                return;
            }
            this.f = f;
            this.c.setEnabled(true);
            this.b.setEnabled(false);
            if (keyFrames.indexOf(closestKeyframe) == size - 1) {
                this.d.setEnabled(false);
            } else {
                this.d.setEnabled(true);
            }
            this.e.setEnabled(true);
            return;
        }
        this.c.setEnabled(false);
        this.b.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        super.f();
        if (m() != null && (m() instanceof NexLayerItem)) {
            this.f3779a = (NexLayerItem) m();
        }
        if (this.h != null && this.f3779a != null && this.f3779a != this.h.a()) {
            this.h.a(this.f3779a);
        }
        if (this.i == null) {
            this.i = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
        }
        Rect rect = new Rect();
        this.f3779a.getBounds(rect);
        this.i.a(rect);
        if (w() != null) {
            w().addOnLayoutChangeListener(this.j);
            w().getViewTreeObserver().addOnGlobalLayoutListener(this.k);
        }
        g(R.id.editmode_layer_anim);
        b(o().u());
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ht
    public boolean a(View view, MotionEvent motionEvent) {
        if (!isAdded() || this.f3779a == null || this.h == null) {
            return false;
        }
        if (!this.f3779a.isSplitScreenEnabled() && this.b.isEnabled() && o() != null) {
            NexLayerItem.b interpolatedKeyframe = this.f3779a.getInterpolatedKeyframe(this.f3779a.getScaledTime(o().u()));
            float[] fArr = {0.0f, 0.0f};
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.postScale(1280.0f / view.getWidth(), 720.0f / view.getHeight());
            matrix.postTranslate(-interpolatedKeyframe.c, -interpolatedKeyframe.d);
            matrix.postScale(1.0f / interpolatedKeyframe.b, 1.0f / interpolatedKeyframe.b);
            matrix.postRotate(-interpolatedKeyframe.e, 0.0f, 0.0f);
            fArr[0] = motionEvent.getX();
            fArr[1] = motionEvent.getY();
            matrix.mapPoints(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
            int dimensionPixelSize = (int) ((1.0f / interpolatedKeyframe.b) * (((getResources().getDimensionPixelSize(R.dimen.marchingAnts_handle_touch_zone_size) * 1280) / view.getWidth()) / 2));
            this.f3779a.getBounds(new Rect());
            if (f >= r3.right - dimensionPixelSize && f <= r3.right + dimensionPixelSize && f2 >= r3.bottom - dimensionPixelSize && f2 <= r3.bottom + dimensionPixelSize) {
                c();
            } else if (f >= r3.right - dimensionPixelSize && f <= r3.right + dimensionPixelSize && f2 >= r3.top - dimensionPixelSize && f2 <= dimensionPixelSize + r3.top) {
                c();
            } else if (f >= r3.left && f <= r3.right && f2 >= r3.top && f2 <= r3.bottom) {
                c();
            }
        }
        return this.h.a(view, motionEvent);
    }

    private void c() {
        if (this.f3779a != null) {
            e();
            b(o().u());
            o().a((NexTimelineItem) this.f3779a);
            o().n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KMUsage.EditScreen_Animation_Action.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "AddKeyframe");
        this.f = this.f3779a.addKeyframe(this.f3779a.getScaledTime(o().u())).f3299a;
    }
}
