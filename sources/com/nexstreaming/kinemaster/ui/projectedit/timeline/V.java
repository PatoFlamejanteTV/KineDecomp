package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.support.v7.widget.RecyclerView;
import android.view.ScaleGestureDetector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UniformTimelineView.java */
/* loaded from: classes2.dex */
public class V implements ScaleGestureDetector.OnScaleGestureListener {

    /* renamed from: a, reason: collision with root package name */
    private int f22659a;

    /* renamed from: b, reason: collision with root package name */
    private int f22660b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ UniformTimelineView f22661c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public V(UniformTimelineView uniformTimelineView) {
        this.f22661c = uniformTimelineView;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        int floor = (int) Math.floor(scaleGestureDetector.getFocusX());
        int floor2 = (int) Math.floor((int) scaleGestureDetector.getFocusY());
        int i = floor - this.f22659a;
        int i2 = this.f22660b;
        RecyclerView.LayoutManager layoutManager = this.f22661c.getLayoutManager();
        if (layoutManager instanceof UniformTimelineLayoutManager) {
            UniformTimelineLayoutManager uniformTimelineLayoutManager = (UniformTimelineLayoutManager) layoutManager;
            float focusX = (scaleGestureDetector.getFocusX() + uniformTimelineLayoutManager.t) / (uniformTimelineLayoutManager.B * uniformTimelineLayoutManager.A);
            uniformTimelineLayoutManager.A *= scaleGestureDetector.getScaleFactor();
            float f2 = uniformTimelineLayoutManager.A;
            if (f2 < 2.0E-4f) {
                uniformTimelineLayoutManager.A = 2.0E-4f;
            } else if (f2 > 0.25f) {
                uniformTimelineLayoutManager.A = 0.25f;
            }
            uniformTimelineLayoutManager.t = ((focusX * (uniformTimelineLayoutManager.B * uniformTimelineLayoutManager.A)) - scaleGestureDetector.getFocusX()) - i;
            uniformTimelineLayoutManager.d();
            float max = Math.max(uniformTimelineLayoutManager.y, uniformTimelineLayoutManager.z);
            if (uniformTimelineLayoutManager.t > max) {
                uniformTimelineLayoutManager.t = max;
            }
            float f3 = uniformTimelineLayoutManager.t;
            float f4 = uniformTimelineLayoutManager.x;
            if (f3 < f4) {
                uniformTimelineLayoutManager.t = f4;
            }
            this.f22661c.requestLayout();
        }
        this.f22659a = floor;
        this.f22660b = floor2;
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.f22661c.Ua = true;
        this.f22659a = (int) Math.floor(scaleGestureDetector.getFocusX());
        this.f22660b = (int) Math.floor((int) scaleGestureDetector.getFocusY());
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.f22661c.Ua = false;
        this.f22661c.Va = true;
    }
}
