package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.AssetLayer;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class LayerTransformTouchHandler implements ScaleGestureDetector.OnScaleGestureListener {

    /* renamed from: a */
    private static int f21934a = 10;
    private WeakReference<View> J;

    /* renamed from: b */
    private NexLayerItem f21935b;

    /* renamed from: c */
    private VideoEditor f21936c;

    /* renamed from: e */
    private NexLayerItem.b f21938e;

    /* renamed from: g */
    private ScaleGestureDetector f21940g;

    /* renamed from: h */
    private float f21941h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private DragMode o;
    private int p;
    private int q;
    private boolean u;
    private long v;
    private float w;
    private float x;
    private float y;
    private float z;

    /* renamed from: d */
    private NexLayerItem.b f21937d = new NexLayerItem.b();

    /* renamed from: f */
    private NexLayerItem.b f21939f = new NexLayerItem.b();
    private float[] r = {0.0f, 0.0f};
    private Matrix s = new Matrix();
    private Rect t = new Rect();
    private RectF A = new RectF();
    private RectF B = new RectF();
    private RectF C = new RectF();
    private RectF D = new RectF();
    private RectF E = new RectF();
    private RectF F = new RectF();
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    private boolean K = true;
    private Runnable L = new RunnableC2054vb(this);

    /* loaded from: classes2.dex */
    public enum DragMode {
        Scale,
        Rotate,
        Move,
        PinchGesture,
        Split,
        CropSW,
        CropNW,
        CropSE,
        CropNE
    }

    public LayerTransformTouchHandler(Context context, NexLayerItem nexLayerItem, VideoEditor videoEditor) {
        this.p = context.getResources().getDimensionPixelOffset(R.dimen.layer_anim_thumb_width);
        this.q = context.getResources().getDimensionPixelSize(R.dimen.marchingAnts_handle_touch_zone_size);
        this.f21940g = new ScaleGestureDetector(context, this);
        this.f21935b = nexLayerItem;
        this.f21936c = videoEditor;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h(float r1, float r2, float r3, float r4, boolean r5, com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts r6) {
        /*
            r0 = this;
            int[] r3 = com.nexstreaming.kinemaster.ui.projectedit.C2063wb.f22749a
            com.nexstreaming.kinemaster.editorwrapper.NexLayerItem r4 = r0.f21935b
            com.nexstreaming.kinemaster.layer.SplitScreenType r4 = r4.getSplitScreenType()
            int r4 = r4.ordinal()
            r3 = r3[r4]
            r4 = 2
            if (r3 == r4) goto L3a
            r4 = 3
            if (r3 == r4) goto L30
            r4 = 4
            if (r3 == r4) goto L26
            r1 = 5
            if (r3 == r1) goto L1c
            r1 = 0
            goto L43
        L1c:
            float r1 = r0.n
            float r1 = r1 + r2
            r0.n = r1
            int r1 = com.nextreaming.nexeditorui.EditorGlobal.m()
            goto L43
        L26:
            float r2 = r0.n
            float r2 = r2 - r1
            r0.n = r2
            int r1 = com.nextreaming.nexeditorui.EditorGlobal.n()
            goto L43
        L30:
            float r1 = r0.n
            float r1 = r1 - r2
            r0.n = r1
            int r1 = com.nextreaming.nexeditorui.EditorGlobal.m()
            goto L43
        L3a:
            float r2 = r0.n
            float r2 = r2 + r1
            r0.n = r2
            int r1 = com.nextreaming.nexeditorui.EditorGlobal.n()
        L43:
            if (r1 <= 0) goto L5b
            float r2 = r0.n
            int r3 = r1 / 2
            float r4 = (float) r3
            float r2 = r2 - r4
            float r2 = java.lang.Math.abs(r2)
            r4 = 1092616192(0x41200000, float:10.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L5b
            com.nexstreaming.kinemaster.editorwrapper.NexLayerItem r1 = r0.f21935b
            r1.setSplitScreenSize(r3)
            goto L70
        L5b:
            com.nexstreaming.kinemaster.editorwrapper.NexLayerItem r2 = r0.f21935b
            r3 = 1103626240(0x41c80000, float:25.0)
            float r4 = r0.n
            float r3 = java.lang.Math.max(r3, r4)
            int r1 = r1 + (-25)
            float r1 = (float) r1
            float r1 = java.lang.Math.min(r3, r1)
            int r1 = (int) r1
            r2.setSplitScreenSize(r1)
        L70:
            com.nexstreaming.kinemaster.editorwrapper.NexLayerItem r1 = r0.f21935b
            com.nexstreaming.kinemaster.editorwrapper.NexLayerItem$b r2 = r0.f21938e
            r1.fitKeyframeToSplitscreenRect(r2)
            if (r6 == 0) goto L7c
            r6.b()
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.LayerTransformTouchHandler.h(float, float, float, float, boolean, com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts):void");
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        MarchingAnts marchingAnts;
        VideoEditor.b q = this.f21936c.q();
        Log.d("LayerXfmTouchHandler", "onScale: " + scaleGestureDetector);
        if (q == null || !(q instanceof MarchingAnts)) {
            marchingAnts = null;
        } else {
            marchingAnts = (MarchingAnts) q;
            marchingAnts.c();
        }
        if (this.o != DragMode.PinchGesture) {
            return true;
        }
        if (this.G) {
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            float f2 = focusX - this.w;
            float f3 = focusY - this.x;
            this.w = focusX;
            this.x = focusY;
            float f4 = -f2;
            float f5 = -f3;
            double d2 = -(this.f21937d.f20234e * 0.017453292f);
            float cos = (float) Math.cos(d2);
            float sin = (float) Math.sin(d2);
            float f6 = (f4 * cos) + ((-sin) * f5);
            float f7 = (f4 * sin) + (f5 * cos);
            float scaleFactor = this.f21937d.f20231b * scaleGestureDetector.getScaleFactor();
            float f8 = scaleFactor >= 0.01f ? scaleFactor : 0.01f;
            NexLayerItem.b bVar = this.f21937d;
            float f9 = bVar.f20231b;
            float f10 = f8 / f9;
            if (f10 != 0.0f) {
                float f11 = bVar.f20232c;
                float f12 = focusX - f11;
                float f13 = bVar.f20233d;
                float f14 = focusY - f13;
                RectF rectF = this.A;
                rectF.right += f6 / f9;
                rectF.bottom += f7 / f9;
                rectF.left += f6 / f9;
                rectF.top += f7 / f9;
                bVar.f20232c = f11 - (f6 / f9);
                bVar.f20233d = f13 - (f7 / f9);
                rectF.offset((-f12) / f9, (-f14) / f9);
                RectF rectF2 = this.A;
                rectF2.left /= f10;
                rectF2.top /= f10;
                rectF2.right /= f10;
                rectF2.bottom /= f10;
                NexLayerItem.b bVar2 = this.f21937d;
                bVar2.f20231b = f8;
                float f15 = bVar2.f20231b;
                rectF2.offset(f12 / f15, f14 / f15);
            }
            if (this.A.height() > this.t.height()) {
                float height = (this.t.height() - 0.5f) / this.A.height();
                this.f21937d.f20231b /= height;
                a(this.A, height);
            }
            if (this.A.width() > this.t.width()) {
                float width = (this.t.width() - 0.5f) / this.A.width();
                this.f21937d.f20231b /= width;
                a(this.A, width);
            }
            RectF rectF3 = this.A;
            float f16 = rectF3.right;
            float f17 = this.F.right;
            if (f16 > f17) {
                rectF3.left -= f16 - f17;
                rectF3.right = f17;
            }
            RectF rectF4 = this.A;
            float f18 = rectF4.bottom;
            float f19 = this.F.bottom;
            if (f18 > f19) {
                rectF4.top -= f18 - f19;
                rectF4.bottom = f19;
            }
            RectF rectF5 = this.A;
            float f20 = rectF5.left;
            float f21 = this.F.left;
            if (f20 < f21) {
                rectF5.right += f21 - f20;
                rectF5.left = f21;
            }
            RectF rectF6 = this.A;
            float f22 = rectF6.top;
            float f23 = this.F.top;
            if (f22 < f23) {
                rectF6.bottom += f23 - f22;
                rectF6.top = f23;
            }
            this.D.set(this.C);
            a(this.D, this.f21939f.f20231b);
            RectF rectF7 = this.D;
            NexLayerItem.b bVar3 = this.f21939f;
            rectF7.offset(bVar3.f20232c, bVar3.f20233d);
            this.E.set(this.A);
            a(this.E, this.f21937d.f20231b);
            RectF rectF8 = this.E;
            NexLayerItem.b bVar4 = this.f21937d;
            rectF8.offset(bVar4.f20232c, bVar4.f20233d);
            float centerX = this.D.centerX() - this.E.centerX();
            float centerY = this.D.centerY() - this.E.centerY();
            NexLayerItem.b bVar5 = this.f21937d;
            bVar5.f20232c += centerX;
            bVar5.f20233d += centerY;
            this.f21935b.setCropBounds(this.A);
            this.B.set(this.A);
            NexLayerItem.b bVar6 = this.f21937d;
            float f24 = bVar6.f20231b;
            bVar6.f20236g = f24;
            bVar6.f20237h = f24;
            this.f21938e.b(bVar6);
            if (marchingAnts == null) {
                return true;
            }
            marchingAnts.a(this.A);
            return true;
        }
        float focusX2 = scaleGestureDetector.getFocusX();
        float focusY2 = scaleGestureDetector.getFocusY();
        float f25 = focusX2 - this.w;
        float f26 = focusY2 - this.x;
        this.f21937d.f20231b *= scaleGestureDetector.getScaleFactor();
        NexLayerItem.b bVar7 = this.f21937d;
        float f27 = bVar7.f20231b;
        bVar7.f20236g = f27;
        bVar7.f20237h = f27;
        bVar7.f20232c += f25;
        bVar7.f20233d += f26;
        b();
        this.f21938e.b(this.f21937d);
        this.f21935b.fitKeyframeToSplitscreenRect(this.f21938e);
        this.w = focusX2;
        this.x = focusY2;
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        DragMode dragMode = this.o;
        if (dragMode == DragMode.PinchGesture) {
            return true;
        }
        if (dragMode != null) {
            this.f21938e.b(this.f21939f);
            this.o = null;
        }
        NexLayerItem.b bVar = this.f21938e;
        if (bVar == null) {
            return true;
        }
        this.f21937d.b(bVar);
        this.o = DragMode.PinchGesture;
        this.w = scaleGestureDetector.getFocusX();
        this.x = scaleGestureDetector.getFocusY();
        this.f21939f.b(this.f21938e);
        this.f21935b.getBounds(this.t);
        this.F.set(this.t);
        if (!this.f21935b.getCropBounds(this.A)) {
            this.A.set(this.t);
        }
        this.C.set(this.A);
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    private void b() {
        NexLayerItem.b bVar = this.f21937d;
        if (bVar.f20231b < 0.01f) {
            bVar.f20231b = 0.01f;
        }
        NexLayerItem.b bVar2 = this.f21937d;
        if (bVar2.f20236g < 0.01f) {
            bVar2.f20236g = 0.01f;
        }
        NexLayerItem.b bVar3 = this.f21937d;
        if (bVar3.f20237h < 0.01f) {
            bVar3.f20237h = 0.01f;
        }
        NexLayerItem nexLayerItem = this.f21935b;
        if (nexLayerItem == null || !(nexLayerItem instanceof AssetLayer) || ((AssetLayer) nexLayerItem).getLayerType() != AssetLayer.AssetLayerType.EFFECT_LAYER) {
            return;
        }
        while (true) {
            if (this.A.width() * this.f21937d.f20231b <= 4096.0f && this.A.height() * this.f21937d.f20231b <= 4096.0f) {
                break;
            }
            this.f21937d.f20231b *= 0.99f;
        }
        while (true) {
            float width = this.A.width();
            NexLayerItem.b bVar4 = this.f21937d;
            float f2 = bVar4.f20236g;
            if (width * f2 <= 4096.0f) {
                break;
            } else {
                bVar4.f20236g = f2 * 0.99f;
            }
        }
        while (true) {
            float height = this.A.height();
            NexLayerItem.b bVar5 = this.f21937d;
            float f3 = bVar5.f20237h;
            if (height * f3 <= 4096.0f) {
                return;
            } else {
                bVar5.f20237h = f3 * 0.99f;
            }
        }
    }

    private void c(float f2, float f3, float f4, float f5, boolean z, MarchingAnts marchingAnts) {
        RectF a2 = a(this.A, this.f21935b.getOrientation());
        RectF a3 = a(this.F, this.f21935b.getOrientation());
        double d2 = -((this.f21937d.f20234e + this.f21935b.getOrientation()) * 0.017453292f);
        float cos = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        float f6 = (f2 * cos) + ((-sin) * f3);
        float f7 = (f2 * sin) + (f3 * cos);
        float f8 = a2.right;
        float f9 = this.f21937d.f20231b;
        a2.right = f8 + (f6 / f9);
        a2.bottom += f7 / f9;
        float f10 = a2.right;
        float f11 = a2.left;
        int i = f21934a;
        if (f10 < i + f11) {
            a2.right = f11 + i;
        }
        float f12 = a2.bottom;
        float f13 = a2.top;
        int i2 = f21934a;
        if (f12 < i2 + f13) {
            a2.bottom = f13 + i2;
        }
        float f14 = a2.right;
        float f15 = a3.right;
        if (f14 > f15) {
            a2.right = f15;
        }
        float f16 = a2.bottom;
        float f17 = a3.bottom;
        if (f16 > f17) {
            a2.bottom = f17;
        }
        this.A.set(a(a2, this.f21935b.getOrientation()));
        this.B.set(this.A);
        RectF a4 = a(this.B, this.f21935b.getOrientation());
        float abs = Math.abs(a4.width() - a4.height()) / 1.41421f;
        if (abs < 40.0f) {
            this.H = true;
            if (a4.width() > a4.height()) {
                a4.right = a4.left + a4.height();
            } else {
                a4.bottom = a4.top + a4.width();
            }
            if (marchingAnts != null) {
                marchingAnts.f();
            }
        } else if (abs < 60.0f) {
            this.I = true;
        }
        this.B.set(a(a4, this.f21935b.getOrientation()));
        this.f21935b.setCropBounds(this.B);
    }

    private void d(float f2, float f3, float f4, float f5, boolean z, MarchingAnts marchingAnts) {
        RectF a2 = a(this.A, this.f21935b.getOrientation());
        RectF a3 = a(this.F, this.f21935b.getOrientation());
        double d2 = -((this.f21937d.f20234e + this.f21935b.getOrientation()) * 0.017453292f);
        float cos = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        float f6 = (f2 * cos) + ((-sin) * f3);
        float f7 = (f2 * sin) + (f3 * cos);
        float f8 = a2.left;
        float f9 = this.f21937d.f20231b;
        a2.left = f8 + (f6 / f9);
        a2.bottom += f7 / f9;
        float f10 = a2.left;
        float f11 = a2.right;
        int i = f21934a;
        if (f10 > f11 - i) {
            a2.left = f11 - i;
        }
        float f12 = a2.bottom;
        float f13 = a2.top;
        int i2 = f21934a;
        if (f12 < i2 + f13) {
            a2.bottom = f13 + i2;
        }
        float f14 = a2.left;
        float f15 = a3.left;
        if (f14 < f15) {
            a2.left = f15;
        }
        float f16 = a2.bottom;
        float f17 = a3.bottom;
        if (f16 > f17) {
            a2.bottom = f17;
        }
        this.A.set(a(a2, this.f21935b.getOrientation()));
        this.B.set(this.A);
        RectF a4 = a(this.B, this.f21935b.getOrientation());
        float abs = Math.abs(a4.width() - a4.height()) / 1.41421f;
        if (abs < 40.0f) {
            this.H = true;
            if (a4.width() > a4.height()) {
                a4.left = a4.right - a4.height();
            } else {
                a4.bottom = a4.top + a4.width();
            }
            if (marchingAnts != null) {
                marchingAnts.e();
            }
        } else if (abs < 60.0f) {
            this.I = true;
        }
        this.B.set(a(a4, this.f21935b.getOrientation()));
        this.f21935b.setCropBounds(this.B);
    }

    private void e(float f2, float f3, float f4, float f5, boolean z, MarchingAnts marchingAnts) {
        NexLayerItem.b bVar = this.f21937d;
        bVar.f20232c += f2;
        bVar.f20233d += f3;
        this.f21938e.b(bVar);
        if (Math.abs(this.f21938e.f20232c - (EditorGlobal.n() / 2)) < 10.0f) {
            float f6 = this.y;
            if (f6 == 0.0f) {
                this.y = this.f21938e.f20233d;
            } else if (Math.abs(this.f21938e.f20233d - f6) > 10.0f) {
                this.y = 0.0f;
                this.v = 0L;
            }
            this.H = true;
            this.f21938e.f20232c = EditorGlobal.n() / 2;
            if (marchingAnts != null) {
                marchingAnts.g();
            }
        } else if (Math.abs(this.f21938e.f20232c - (EditorGlobal.n() / 2)) < 20.0f) {
            this.I = true;
        }
        if (Math.abs(this.f21938e.f20233d - (EditorGlobal.m() / 2)) < 10.0f) {
            float f7 = this.z;
            if (f7 == 0.0f) {
                this.z = this.f21938e.f20232c;
            } else if (Math.abs(this.f21938e.f20232c - f7) > 10.0f) {
                this.z = 0.0f;
                this.v = 0L;
            }
            this.H = true;
            this.f21938e.f20233d = EditorGlobal.m() / 2;
            if (marchingAnts != null) {
                marchingAnts.h();
            }
        } else if (Math.abs(this.f21938e.f20233d - (EditorGlobal.m() / 2)) < 20.0f) {
            this.I = true;
        }
        this.f21935b.fitKeyframeToSplitscreenRect(this.f21938e);
    }

    private void f(float f2, float f3, float f4, float f5, boolean z, MarchingAnts marchingAnts) {
        RectF a2 = a(this.A, this.f21935b.getOrientation());
        RectF a3 = a(this.F, this.f21935b.getOrientation());
        double d2 = (-(this.f21937d.f20234e + this.f21935b.getOrientation())) * 0.017453292f;
        double cos = Math.cos(d2);
        double sin = Math.sin(d2);
        double d3 = -f2;
        Double.isNaN(d3);
        double d4 = -f3;
        Double.isNaN(d4);
        double d5 = (d3 * cos) + ((-sin) * d4);
        Double.isNaN(d3);
        Double.isNaN(d4);
        double d6 = (d3 * sin) + (d4 * cos);
        float f6 = a2.right;
        float f7 = (float) d5;
        float f8 = this.f21937d.f20231b;
        a2.right = f6 + (f7 / f8);
        float f9 = (float) d6;
        a2.bottom += f9 / f8;
        a2.left += f7 / f8;
        a2.top += f9 / f8;
        float f10 = a2.right;
        float f11 = a3.right;
        if (f10 > f11) {
            a2.left -= f10 - f11;
            a2.right = f11;
        }
        float f12 = a2.bottom;
        float f13 = a3.bottom;
        if (f12 > f13) {
            a2.top -= f12 - f13;
            a2.bottom = f13;
        }
        float f14 = a2.left;
        float f15 = a3.left;
        if (f14 < f15) {
            a2.right += f15 - f14;
            a2.left = f15;
        }
        float f16 = a2.top;
        float f17 = a3.top;
        if (f16 < f17) {
            a2.bottom += f17 - f16;
            a2.top = f17;
        }
        this.A.set(a(a2, this.f21935b.getOrientation()));
        this.f21935b.setCropBounds(this.A);
        this.B.set(this.A);
        RectF a4 = a(this.C, this.f21935b.getOrientation());
        float centerX = a2.centerX() - a4.centerX();
        float centerY = a2.centerY() - a4.centerY();
        double orientation = (this.f21937d.f20234e + this.f21935b.getOrientation()) * 0.017453292f;
        double cos2 = Math.cos(orientation);
        double sin2 = Math.sin(orientation);
        double d7 = centerX;
        Double.isNaN(d7);
        double d8 = centerY;
        Double.isNaN(d8);
        double d9 = (d7 * cos2) + ((-sin2) * d8);
        Double.isNaN(d7);
        Double.isNaN(d8);
        double d10 = (d7 * sin2) + (d8 * cos2);
        NexLayerItem.b bVar = this.f21937d;
        NexLayerItem.b bVar2 = this.f21939f;
        float f18 = bVar2.f20232c;
        float f19 = bVar2.f20231b;
        bVar.f20232c = f18 - (((float) d9) * f19);
        bVar.f20233d = bVar2.f20233d - (((float) d10) * f19);
        this.f21938e.b(bVar);
    }

    private void g(float f2, float f3, float f4, float f5, boolean z, MarchingAnts marchingAnts) {
        NexLayerItem.b bVar = this.f21937d;
        bVar.f20234e = ((bVar.f20234e + f4) + 360.0f) % 360.0f;
        this.f21938e.b(bVar);
        NexLayerItem.b bVar2 = this.f21938e;
        float f6 = bVar2.f20234e;
        float f7 = f6 % 45.0f;
        if (f7 < 4.5f) {
            this.H = true;
            bVar2.f20234e = f6 - f7;
            if (marchingAnts != null) {
                marchingAnts.d();
                return;
            }
            return;
        }
        if (f7 >= 40.5f) {
            this.H = true;
            bVar2.f20234e = f6 + (45.0f - f7);
            if (marchingAnts != null) {
                marchingAnts.d();
                return;
            }
            return;
        }
        if (f7 < 9.0f) {
            this.I = true;
        } else if (f7 >= 36.0f) {
            this.I = true;
        }
    }

    private static void a(RectF rectF, float f2) {
        rectF.left *= f2;
        rectF.top *= f2;
        rectF.right *= f2;
        rectF.bottom *= f2;
    }

    public void a(boolean z) {
        this.G = z;
    }

    public void a(NexLayerItem nexLayerItem) {
        this.f21935b = nexLayerItem;
        NexLayerItem nexLayerItem2 = this.f21935b;
        if (nexLayerItem2 instanceof AssetLayer) {
            this.K = ((AssetLayer) nexLayerItem2).isSyncXYScale();
        }
    }

    public NexLayerItem a() {
        return this.f21935b;
    }

    private void a(Runnable runnable, long j) {
        View view;
        WeakReference<View> weakReference = this.J;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        view.postDelayed(runnable, j);
    }

    public void a(Runnable runnable) {
        View view;
        WeakReference<View> weakReference = this.J;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        view.removeCallbacks(runnable);
    }

    private void b(float f2, float f3, float f4, float f5, boolean z, MarchingAnts marchingAnts) {
        RectF a2 = a(this.A, this.f21935b.getOrientation());
        RectF a3 = a(this.F, this.f21935b.getOrientation());
        double d2 = -((this.f21937d.f20234e + this.f21935b.getOrientation()) * 0.017453292f);
        float cos = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        float f6 = (f2 * cos) + ((-sin) * f3);
        float f7 = (f2 * sin) + (f3 * cos);
        float f8 = a2.left;
        float f9 = this.f21937d.f20231b;
        a2.left = f8 + (f6 / f9);
        a2.top += f7 / f9;
        float f10 = a2.left;
        float f11 = a2.right;
        int i = f21934a;
        if (f10 > f11 - i) {
            a2.left = f11 - i;
        }
        float f12 = a2.top;
        float f13 = a2.bottom;
        int i2 = f21934a;
        if (f12 > f13 - i2) {
            a2.top = f13 - i2;
        }
        float f14 = a2.left;
        float f15 = a3.left;
        if (f14 < f15) {
            a2.left = f15;
        }
        float f16 = a2.top;
        float f17 = a3.top;
        if (f16 < f17) {
            a2.top = f17;
        }
        this.A.set(a(a2, this.f21935b.getOrientation()));
        this.B.set(this.A);
        RectF a4 = a(this.B, this.f21935b.getOrientation());
        float abs = Math.abs(this.B.width() - this.B.height()) / 1.41421f;
        if (abs < 40.0f) {
            this.H = true;
            if (this.B.width() > this.B.height()) {
                RectF rectF = this.B;
                rectF.left = rectF.right - rectF.height();
            } else {
                RectF rectF2 = this.B;
                rectF2.top = rectF2.bottom - rectF2.width();
            }
            if (marchingAnts != null) {
                marchingAnts.f();
            }
        } else if (abs < 60.0f) {
            this.I = true;
        }
        this.B.set(a(a4, this.f21935b.getOrientation()));
        this.f21935b.setCropBounds(this.B);
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02d0 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.view.View r19, android.view.MotionEvent r20) {
        /*
            Method dump skipped, instructions count: 845
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.LayerTransformTouchHandler.a(android.view.View, android.view.MotionEvent):boolean");
    }

    private RectF a(RectF rectF, int i) {
        return (i == 90 || i == 270) ? new RectF(rectF.top, rectF.left, rectF.bottom, rectF.right) : rectF;
    }

    private void a(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, MarchingAnts marchingAnts) {
        NexLayerItem.b bVar = this.f21937d;
        bVar.f20231b *= f5;
        bVar.f20236g *= f6;
        bVar.f20237h *= f7;
        b();
        if (this.K) {
            NexLayerItem.b bVar2 = this.f21937d;
            float f8 = bVar2.f20231b;
            bVar2.f20236g = f8;
            bVar2.f20237h = f8;
        }
        this.f21938e.b(this.f21937d);
    }

    private void a(float f2, float f3, float f4, float f5, boolean z, MarchingAnts marchingAnts) {
        RectF a2 = a(this.A, this.f21935b.getOrientation());
        RectF a3 = a(this.F, this.f21935b.getOrientation());
        double d2 = -((this.f21937d.f20234e + this.f21935b.getOrientation()) * 0.017453292f);
        float cos = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        float f6 = (f2 * cos) + ((-sin) * f3);
        float f7 = (f2 * sin) + (f3 * cos);
        float f8 = a2.right;
        float f9 = this.f21937d.f20231b;
        a2.right = f8 + (f6 / f9);
        a2.top += f7 / f9;
        float f10 = a2.right;
        float f11 = a2.left;
        int i = f21934a;
        if (f10 < i + f11) {
            a2.right = f11 + i;
        }
        float f12 = a2.top;
        float f13 = a2.bottom;
        int i2 = f21934a;
        if (f12 > f13 - i2) {
            a2.top = f13 - i2;
        }
        float f14 = a2.right;
        float f15 = a3.right;
        if (f14 > f15) {
            a2.right = f15;
        }
        float f16 = a2.top;
        float f17 = a3.top;
        if (f16 < f17) {
            a2.top = f17;
        }
        this.A.set(a(a2, this.f21935b.getOrientation()));
        this.B.set(this.A);
        RectF a4 = a(this.B, this.f21935b.getOrientation());
        float abs = Math.abs(this.B.width() - this.B.height()) / 1.41421f;
        if (abs < 40.0f) {
            this.H = true;
            if (a4.width() > a4.height()) {
                a4.right = a4.left + a4.height();
            } else {
                a4.top = a4.bottom - a4.width();
            }
            if (marchingAnts != null) {
                marchingAnts.e();
            }
        } else if (abs < 60.0f) {
            this.I = true;
        }
        this.B.set(a(a4, this.f21935b.getOrientation()));
        this.f21935b.setCropBounds(this.B);
    }

    private void a(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        MarchingAnts marchingAnts;
        VideoEditor.b q = this.f21936c.q();
        this.H = false;
        this.I = false;
        if (q == null || !(q instanceof MarchingAnts)) {
            marchingAnts = null;
        } else {
            marchingAnts = (MarchingAnts) q;
            marchingAnts.c();
        }
        MarchingAnts marchingAnts2 = marchingAnts;
        this.B.set(this.A);
        switch (C2063wb.f22750b[this.o.ordinal()]) {
            case 1:
                h(f2, f3, f4, f5, z, marchingAnts2);
                break;
            case 2:
                if (this.G) {
                    f(f2, f3, f4, f5, z, marchingAnts2);
                    break;
                } else {
                    e(f2, f3, f4, f5, z, marchingAnts2);
                    break;
                }
            case 3:
                g(f2, f3, f4, f5, z, marchingAnts2);
                break;
            case 4:
                a(f2, f3, f4, f5, f6, f7, z, marchingAnts2);
                if (this.f21935b.needRendererReawakeOnEditResize()) {
                    this.f21936c.c(this.f21935b);
                    break;
                }
                break;
            case 5:
                a(f2, f3, f4, f5, z, marchingAnts2);
                break;
            case 6:
                b(f2, f3, f4, f5, z, marchingAnts2);
                break;
            case 7:
                c(f2, f3, f4, f5, z, marchingAnts2);
                break;
            case 8:
                d(f2, f3, f4, f5, z, marchingAnts2);
                break;
        }
        if (this.H) {
            if (this.v == 0) {
                this.v = System.nanoTime();
                a(this.L, 2300L);
            } else {
                this.L.run();
            }
        } else if (!this.I) {
            this.v = 0L;
            a(this.L);
        }
        if (marchingAnts2 != null) {
            marchingAnts2.a(this.B);
        }
        if (marchingAnts2 != null && z) {
            marchingAnts2.c();
        }
        this.f21936c.a(NexEditor.FastPreviewOption.normal, 0, true);
    }
}
