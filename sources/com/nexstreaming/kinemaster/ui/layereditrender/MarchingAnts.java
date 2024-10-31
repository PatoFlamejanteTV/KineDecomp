package com.nexstreaming.kinemaster.ui.layereditrender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.view.animation.Interpolator;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import java.util.List;

/* loaded from: classes.dex */
public class MarchingAnts implements VideoEditor.b {
    private int H;
    private int I;
    private Interpolator M;
    private boolean N;

    /* renamed from: e */
    private int f21627e;

    /* renamed from: f */
    private int f21628f;

    /* renamed from: g */
    private int f21629g;

    /* renamed from: h */
    private int f21630h;
    private float i;
    private float j;
    private float k;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private Bitmap r;
    private Bitmap s;
    private Bitmap t;
    private Bitmap u;
    private Bitmap v;
    private Bitmap w;
    private Bitmap x;
    private Bitmap y;
    private Bitmap z;

    /* renamed from: a */
    private Object f21623a = new Object();

    /* renamed from: b */
    private RectF f21624b = new RectF();

    /* renamed from: c */
    private RectF f21625c = new RectF();

    /* renamed from: d */
    private Handler f21626d = new Handler();
    private boolean l = false;
    private boolean m = false;
    private VideoEditor A = null;
    private NexLayerItem.b B = new NexLayerItem.b();
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private boolean J = true;
    private boolean K = true;
    private long L = -1;
    private List<NexLayerItem.b> O = null;
    private Runnable P = new d(this);

    /* loaded from: classes.dex */
    public enum Feature {
        SIZE_HANDLE,
        ROTATE_HANDLE,
        SPLIT_HANDLE,
        CROP_HANDLES
    }

    public MarchingAnts(Feature... featureArr) {
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        for (Feature feature : featureArr) {
            int i = e.f21635a[feature.ordinal()];
            if (i == 1) {
                this.n = true;
            } else if (i == 2) {
                this.o = true;
            } else if (i == 3) {
                this.p = true;
            } else if (i == 4) {
                this.q = true;
            }
        }
    }

    private void l() {
        if (this.m && this.l) {
            this.m = false;
            b(this.f21625c);
        }
    }

    public void h() {
        this.G = true;
    }

    public void i() {
        this.f21626d.removeCallbacks(this.P);
        this.f21626d.post(this.P);
    }

    public void j() {
        this.L = System.nanoTime();
    }

    public void k() {
        this.f21626d.removeCallbacks(this.P);
    }

    public void b() {
        this.L = 0L;
    }

    public void c() {
        this.F = false;
        this.G = false;
        this.C = false;
        this.D = false;
        this.E = false;
    }

    public void d() {
        this.C = true;
    }

    public void e() {
        this.D = true;
    }

    public void f() {
        this.E = true;
    }

    public void g() {
        this.F = true;
    }

    private void b(float f2, float f3, float f4, float f5) {
        synchronized (this.f21623a) {
            this.f21624b.set(f2, f3, f4, f5);
        }
    }

    public void a(int i, int i2) {
        this.f21627e = i;
        this.f21628f = i2;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a(Context context, VideoEditor videoEditor, boolean z) {
        this.f21629g = context.getResources().getColor(R.color.marching_ants_bg);
        this.f21630h = context.getResources().getColor(R.color.marching_ants_fg);
        this.i = context.getResources().getDimension(R.dimen.marchingAnts_dashSize);
        this.j = context.getResources().getDimension(R.dimen.marchingAnts_width);
        this.H = context.getResources().getDimensionPixelSize(R.dimen.layer_splitScreen_guide_thick);
        this.I = context.getResources().getDimensionPixelSize(R.dimen.layer_splitScreen_guide_thin);
        this.k = context.getResources().getDimension(R.dimen.marchingAnts_handle_size);
        this.A = videoEditor;
        this.l = true;
        if (this.n) {
            this.r = BitmapFactory.decodeResource(context.getResources(), R.drawable.layer_rotate);
        }
        if (this.o) {
            this.t = BitmapFactory.decodeResource(context.getResources(), R.drawable.layer_scale);
            this.u = BitmapFactory.decodeResource(context.getResources(), R.drawable.handler_layer_scale_free);
        }
        if (this.q) {
            this.s = BitmapFactory.decodeResource(context.getResources(), R.drawable.layer_crop);
        }
        if (this.p) {
            this.v = BitmapFactory.decodeResource(context.getResources(), R.drawable.layer_splitsize);
        }
        this.y = BitmapFactory.decodeResource(context.getResources(), R.drawable.gesture_scale);
        this.z = BitmapFactory.decodeResource(context.getResources(), R.drawable.gesture_move);
        this.w = Bitmap.createBitmap(16, 16, Bitmap.Config.ARGB_8888);
        new Canvas(this.w).drawColor(this.f21629g);
        this.x = Bitmap.createBitmap(16, 16, Bitmap.Config.ARGB_8888);
        new Canvas(this.x).drawColor(this.f21630h);
        l();
        i();
    }

    private void b(RectF rectF) {
        b(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0175 A[Catch: all -> 0x0632, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000f, B:9:0x001b, B:11:0x0030, B:22:0x009c, B:26:0x00f0, B:28:0x00f4, B:30:0x00f8, B:32:0x00fc, B:33:0x0103, B:35:0x0112, B:38:0x011c, B:40:0x013a, B:43:0x012d, B:45:0x0115, B:46:0x0164, B:52:0x0170, B:54:0x0175, B:55:0x017c, B:56:0x019e, B:60:0x0058, B:62:0x0063, B:63:0x0073, B:64:0x0084, B:66:0x01a0, B:68:0x0211, B:70:0x0215, B:72:0x0259, B:73:0x02a8, B:75:0x02b1, B:76:0x02f3, B:78:0x02f7, B:79:0x0335, B:82:0x0390, B:89:0x03a7, B:88:0x03c7, B:93:0x03ce, B:96:0x03da, B:103:0x03f1, B:102:0x0411, B:107:0x0418, B:108:0x0422, B:110:0x042f, B:112:0x0439, B:113:0x0478, B:115:0x047c, B:117:0x0480, B:118:0x0549, B:120:0x054d, B:122:0x0551, B:123:0x0580, B:125:0x0584, B:127:0x0588, B:129:0x05a0, B:130:0x05cb, B:131:0x05b6, B:132:0x05ce, B:134:0x05d5, B:135:0x0601, B:137:0x0605, B:138:0x0630), top: B:3:0x0009 }] */
    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.nexstreaming.kinemaster.editorwrapper.NexLayerItem r32, com.nextreaming.nexvideoeditor.LayerRenderer r33) {
        /*
            Method dump skipped, instructions count: 1591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts.a(com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexvideoeditor.LayerRenderer):void");
    }

    private RectF a(RectF rectF, int i) {
        return (i == 90 || i == 270) ? new RectF(rectF.top, rectF.left, rectF.bottom, rectF.right) : rectF;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a() {
        this.l = false;
        this.A = null;
        synchronized (this.f21623a) {
            this.r = null;
            this.t = null;
            this.u = null;
            this.v = null;
            this.w = null;
            this.x = null;
        }
        k();
    }

    public void a(float f2, float f3, float f4, float f5) {
        this.f21625c.set(f2, f3, f4, f5);
        this.m = true;
        l();
    }

    public void a(Rect rect) {
        a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void a(RectF rectF) {
        a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public void a(List<NexLayerItem.b> list) {
        this.O = list;
    }
}
