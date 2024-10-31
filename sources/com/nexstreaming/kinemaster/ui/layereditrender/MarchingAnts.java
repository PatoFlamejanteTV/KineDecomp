package com.nexstreaming.kinemaster.ui.layereditrender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* loaded from: classes.dex */
public class MarchingAnts implements VideoEditor.b {
    private int C;
    private int D;
    private Interpolator H;
    private boolean I;
    private int e;
    private int f;
    private int g;
    private int h;
    private float i;
    private float j;
    private float k;
    private boolean n;
    private boolean o;
    private boolean p;
    private Bitmap q;
    private Bitmap r;
    private Bitmap s;
    private Bitmap t;
    private Bitmap u;
    private Bitmap v;
    private Bitmap w;

    /* renamed from: a, reason: collision with root package name */
    private Object f3711a = new Object();
    private Rect b = new Rect();
    private Rect c = new Rect();
    private Handler d = new Handler();
    private boolean l = false;
    private boolean m = false;
    private VideoEditor x = null;
    private NexLayerItem.b y = new NexLayerItem.b();
    private boolean z = false;
    private boolean A = false;
    private boolean B = false;
    private boolean E = true;
    private boolean F = true;
    private long G = -1;
    private Runnable J = new b(this);

    /* loaded from: classes.dex */
    public enum Feature {
        SIZE_HANDLE,
        ROTATE_HANDLE,
        SPLIT_HANDLE
    }

    public void a(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    public void b() {
        this.A = false;
        this.B = false;
        this.z = false;
    }

    public void c() {
        this.z = true;
    }

    public void d() {
        this.A = true;
    }

    public void e() {
        this.B = true;
    }

    public MarchingAnts(Feature... featureArr) {
        this.n = false;
        this.o = false;
        this.p = false;
        int length = featureArr.length;
        for (int i = 0; i < length; i++) {
            switch (featureArr[i]) {
                case ROTATE_HANDLE:
                    this.n = true;
                    break;
                case SIZE_HANDLE:
                    this.o = true;
                    break;
                case SPLIT_HANDLE:
                    this.p = true;
                    break;
            }
        }
    }

    public void f() {
        this.d.removeCallbacks(this.J);
        this.d.post(this.J);
    }

    public void g() {
        this.d.removeCallbacks(this.J);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a(Context context, VideoEditor videoEditor, boolean z) {
        this.g = context.getResources().getColor(R.color.marching_ants_bg);
        this.h = context.getResources().getColor(R.color.marching_ants_fg);
        this.i = context.getResources().getDimension(R.dimen.marchingAnts_dashSize);
        this.j = context.getResources().getDimension(R.dimen.marchingAnts_width);
        this.C = context.getResources().getDimensionPixelSize(R.dimen.layer_splitScreen_guide_thick);
        this.D = context.getResources().getDimensionPixelSize(R.dimen.layer_splitScreen_guide_thin);
        this.k = (context.getResources().getDimension(R.dimen.marchingAnts_handle_size) / this.e) * 1280.0f;
        this.x = videoEditor;
        this.l = true;
        if (this.n) {
            this.q = BitmapFactory.decodeResource(context.getResources(), R.drawable.layer_rotate);
        }
        if (this.o) {
            this.r = BitmapFactory.decodeResource(context.getResources(), R.drawable.layer_scale);
        }
        if (this.p) {
            this.s = BitmapFactory.decodeResource(context.getResources(), R.drawable.layer_splitsize);
            this.v = BitmapFactory.decodeResource(context.getResources(), R.drawable.gesture_scale);
            this.w = BitmapFactory.decodeResource(context.getResources(), R.drawable.gesture_move);
        }
        this.t = Bitmap.createBitmap(16, 16, Bitmap.Config.ARGB_8888);
        new Canvas(this.t).drawColor(this.g);
        this.u = Bitmap.createBitmap(16, 16, Bitmap.Config.ARGB_8888);
        new Canvas(this.u).drawColor(this.h);
        j();
        f();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a(NexLayerItem nexLayerItem, LayerRenderer layerRenderer) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float f;
        Bitmap bitmap;
        float f2;
        synchronized (this.f3711a) {
            if (nexLayerItem.isSplitScreenEnabled()) {
                this.E = false;
                this.F = false;
                if (this.s != null) {
                    int splitScreenSize = nexLayerItem.getSplitScreenSize();
                    switch (nexLayerItem.getSplitScreenType()) {
                        case FULL:
                            i = 720;
                            i2 = 1280;
                            i3 = 0;
                            i4 = 0;
                            i5 = -1;
                            i6 = -1;
                            z = false;
                            break;
                        case LEFT:
                            z = true;
                            i = 720;
                            i2 = splitScreenSize + (this.C / 2);
                            i3 = 0;
                            i4 = 0;
                            i5 = 360;
                            i6 = splitScreenSize;
                            break;
                        case BOTTOM:
                            int i7 = 720 - splitScreenSize;
                            i = 720;
                            i2 = 1280;
                            i3 = i7 - (this.C / 2);
                            i4 = 0;
                            i5 = i7;
                            i6 = 640;
                            z = false;
                            break;
                        case RIGHT:
                            int i8 = 1280 - splitScreenSize;
                            z = true;
                            i = 720;
                            i2 = 1280;
                            i3 = 0;
                            i4 = i8 - (this.C / 2);
                            i5 = 360;
                            i6 = i8;
                            break;
                        case TOP:
                            z = false;
                            i = (this.C / 2) + splitScreenSize;
                            i2 = 1280;
                            i3 = 0;
                            i4 = 0;
                            i5 = splitScreenSize;
                            i6 = 640;
                            break;
                        default:
                            i = -1;
                            i2 = -1;
                            i3 = -1;
                            i4 = -1;
                            i5 = -1;
                            i6 = -1;
                            z = false;
                            break;
                    }
                    if (i2 > i4 && i > i3) {
                        layerRenderer.a(570425344, i4, i3, i2, i, this.C + (this.C / 3));
                        layerRenderer.a(-1, i4, i3, i2, i, this.C);
                        long nanoTime = (System.nanoTime() - this.G) / 1000000;
                        if (this.G > 0 && nanoTime < 4000 && this.v != null && this.w != null) {
                            if (this.H == null) {
                                this.H = new AccelerateDecelerateInterpolator();
                            }
                            this.E = true;
                            this.F = true;
                            float f3 = 2000.0f / 3.0f;
                            if (((float) nanoTime) >= 2000.0f) {
                                f = ((float) nanoTime) - 2000.0f;
                                bitmap = this.v;
                            } else {
                                f = (float) nanoTime;
                                bitmap = this.w;
                            }
                            if (f < f3) {
                                f2 = this.H.getInterpolation(f / f3);
                            } else if (f > 2.0f * f3) {
                                f2 = this.H.getInterpolation(1.0f - ((f - (2.0f * f3)) / f3));
                            } else {
                                f2 = 1.0f;
                            }
                            float f4 = ((i2 - i4) / 2) + i4;
                            float f5 = ((i - i3) / 2) + i3;
                            layerRenderer.l();
                            layerRenderer.d(f2);
                            layerRenderer.a(bitmap, f4 - 120.0f, f5 - 120.0f, f4 + 120.0f, f5 + 120.0f);
                            layerRenderer.m();
                        }
                    }
                    if (i6 > 0 && i5 > 0) {
                        layerRenderer.l();
                        if (z) {
                            layerRenderer.b(90.0f, i6, i5);
                        }
                        layerRenderer.a(this.s, i6 - (this.k / 2.0f), i5 - (this.k / 2.0f), (this.k / 2.0f) + i6, (this.k / 2.0f) + i5);
                        layerRenderer.m();
                    }
                }
                return;
            }
            this.E = true;
            nexLayerItem.getInterpolatedKeyframe(nexLayerItem.getScaledTime(layerRenderer.j()), this.y);
            layerRenderer.l();
            layerRenderer.a(this.y.b, this.y.b, this.y.c, this.y.d);
            layerRenderer.b(this.y.e, this.y.c, this.y.d);
            layerRenderer.a(this.y.c, this.y.d);
            int min = Math.min((((int) ((System.nanoTime() / 1000000) % 500)) * 3) / 500, 2);
            if (this.t != null && this.u != null) {
                layerRenderer.l();
                layerRenderer.b(1.0f / this.y.b, 1.0f / this.y.b);
                float f6 = this.b.left * this.y.b;
                float f7 = this.b.top * this.y.b;
                float f8 = this.b.right * this.y.b;
                float f9 = this.b.bottom * this.y.b;
                float f10 = f7 + ((f9 - f7) / 2.0f);
                if (this.z) {
                    layerRenderer.b(1426063360, f6 - 10000.0f, f10 - 1.5f, f8 + 10000.0f, f10 + 1.5f);
                    layerRenderer.b(-43674, f6 - 10000.0f, f10 - 0.5f, f8 + 10000.0f, f10 + 0.5f);
                }
                layerRenderer.a(this.t, f6, f7, f6 + this.j, f9);
                layerRenderer.a(this.t, f8 - this.j, f7, f8, f9);
                layerRenderer.a(this.t, f6, f7, f8, f7 + this.j);
                layerRenderer.a(this.t, f6, f9 - this.j, f8, f9);
                float f11 = ((this.i * 2.0f) * min) / 3.0f;
                float f12 = f6 - (this.i * 2.0f);
                while (f12 < f8) {
                    float max = Math.max(f6, f12 + f11);
                    float min2 = Math.min(f8, this.i + max);
                    if (min2 >= f6 && max <= f8) {
                        layerRenderer.a(this.u, max, f7, min2, f7 + this.j);
                        layerRenderer.a(this.u, max, f9 - this.j, min2, f9);
                    }
                    f12 = (this.i * 2.0f) + f12;
                }
                float f13 = f7 - (this.i * 2.0f);
                while (f13 < f9) {
                    float max2 = Math.max(f7, f13 + f11);
                    float min3 = Math.min(f9, this.i + max2);
                    if (min3 >= f7 && max2 <= f9) {
                        layerRenderer.a(this.u, f6, max2, f6 + this.j, min3);
                        layerRenderer.a(this.u, f8 - this.j, max2, f8, min3);
                    }
                    f13 = (this.i * 2.0f) + f13;
                }
                layerRenderer.m();
            }
            if (this.n && this.q != null) {
                int i9 = this.b.right;
                int i10 = this.b.top;
                layerRenderer.l();
                layerRenderer.a(1.0f / this.y.b, 1.0f / this.y.b, i9, i10);
                layerRenderer.a(this.q, i9 - (this.k / 2.0f), i10 - (this.k / 2.0f), (this.k / 2.0f) + i9, (this.k / 2.0f) + i10);
                layerRenderer.m();
            }
            if (this.o && this.r != null) {
                int i11 = this.b.right;
                int i12 = this.b.bottom;
                layerRenderer.l();
                layerRenderer.a(1.0f / this.y.b, 1.0f / this.y.b, i11, i12);
                layerRenderer.a(this.r, i11 - (this.k / 2.0f), i12 - (this.k / 2.0f), (this.k / 2.0f) + i11, (this.k / 2.0f) + i12);
                layerRenderer.m();
            }
            layerRenderer.m();
            if (this.A) {
                layerRenderer.b(1426063360, this.y.c - 1.5f, 0.0f, 1.5f + this.y.c, 720.0f);
                layerRenderer.b(-43674, this.y.c - 0.5f, 0.0f, 0.5f + this.y.c, 720.0f);
            }
            if (this.B) {
                layerRenderer.b(1426063360, 0.0f, this.y.d - 1.5f, 1280.0f, 1.5f + this.y.d);
                layerRenderer.b(-43674, 0.0f, this.y.d - 0.5f, 1280.0f, 0.5f + this.y.d);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a() {
        this.l = false;
        this.x = null;
        synchronized (this.f3711a) {
            this.q = null;
            this.r = null;
            this.s = null;
            this.t = null;
            this.u = null;
        }
        g();
    }

    private void j() {
        if (this.m && this.l) {
            this.m = false;
            b(this.c);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        this.c.set(i, i2, i3, i4);
        this.m = true;
        j();
    }

    public void h() {
        this.G = System.nanoTime();
    }

    public void i() {
        this.G = 0L;
    }

    public void a(Rect rect) {
        a(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void b(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        synchronized (this.f3711a) {
            this.b.set(i, i2, i3, i4);
        }
    }

    private void b(Rect rect) {
        b(rect.left, rect.top, rect.right, rect.bottom);
    }
}
