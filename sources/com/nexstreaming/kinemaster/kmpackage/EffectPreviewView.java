package com.nexstreaming.kinemaster.kmpackage;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import com.nextreaming.nexvideoeditor.NexThemeRenderer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public class EffectPreviewView extends GLSurfaceView {
    private static String b = "NexThemePreviewView";

    /* renamed from: a, reason: collision with root package name */
    public boolean f3420a;
    private float c;
    private boolean d;
    private Handler e;
    private long f;
    private long g;
    private long h;
    private b i;
    private b j;
    private boolean k;
    private String l;
    private String m;
    private Object n;
    private long o;
    private long p;
    private long q;
    private int r;
    private boolean s;
    private EffectLibrary t;
    private NexThemeRenderer u;
    private NexImageLoader.d v;
    private float w;

    static /* synthetic */ float a(EffectPreviewView effectPreviewView, float f) {
        float f2 = effectPreviewView.w + f;
        effectPreviewView.w = f2;
        return f2;
    }

    static /* synthetic */ long a() {
        return b();
    }

    static /* synthetic */ long c(EffectPreviewView effectPreviewView, long j) {
        long j2 = effectPreviewView.g + j;
        effectPreviewView.g = j2;
        return j2;
    }

    static /* synthetic */ long e(EffectPreviewView effectPreviewView, long j) {
        long j2 = effectPreviewView.f + j;
        effectPreviewView.f = j2;
        return j2;
    }

    private static long b() {
        return System.nanoTime() / 1000000;
    }

    public EffectPreviewView(Context context) {
        super(context);
        this.c = 1.7777778f;
        this.d = false;
        this.e = new Handler();
        this.k = false;
        this.l = null;
        this.m = null;
        this.f3420a = false;
        this.n = new Object();
        this.o = 2000L;
        this.p = -1L;
        this.q = 1000L;
        this.r = 0;
        this.u = null;
        this.v = null;
        this.w = 0.0f;
        a(false, 0, 1);
    }

    public EffectPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 1.7777778f;
        this.d = false;
        this.e = new Handler();
        this.k = false;
        this.l = null;
        this.m = null;
        this.f3420a = false;
        this.n = new Object();
        this.o = 2000L;
        this.p = -1L;
        this.q = 1000L;
        this.r = 0;
        this.u = null;
        this.v = null;
        this.w = 0.0f;
        a(false, 0, 1);
    }

    public EffectPreviewView(Context context, boolean z, int i, int i2) {
        super(context);
        this.c = 1.7777778f;
        this.d = false;
        this.e = new Handler();
        this.k = false;
        this.l = null;
        this.m = null;
        this.f3420a = false;
        this.n = new Object();
        this.o = 2000L;
        this.p = -1L;
        this.q = 1000L;
        this.r = 0;
        this.u = null;
        this.v = null;
        this.w = 0.0f;
        a(z, i, 1);
    }

    public void setAspectRatio(float f) {
        this.c = f;
    }

    public float getAspectRatio() {
        return this.c;
    }

    public void setOverlayPathResolver(NexImageLoader.d dVar) {
        this.v = dVar;
    }

    public void setEffectOptions(String str) {
        if (str == null || this.l == null || !str.equals(this.l)) {
            this.l = str;
        }
    }

    public String getEffectOptions() {
        return this.l;
    }

    public void setEffect(String str) {
        this.t.b().onComplete(new v(this, str));
    }

    public void setEffect(b bVar) {
        if (bVar != this.i) {
            this.f = b();
            this.s = bVar instanceof com.nexstreaming.kinemaster.kmpackage.a;
            this.i = bVar;
        }
    }

    public void setEffectTime(int i) {
        if (i != this.o) {
            this.f = b();
            this.o = i;
        }
    }

    public void setPauseTime(int i) {
        this.q = i;
    }

    public int getPauseTime() {
        return (int) this.q;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        c();
        super.onDetachedFromWindow();
    }

    private void c() {
        synchronized (this.n) {
            if (this.u != null) {
                this.u.deinit(true);
                this.u = null;
            }
        }
    }

    private void d() {
        if (this.u == null && !this.f3420a) {
            this.u = new NexThemeRenderer();
            com.nextreaming.nexvideoeditor.a aVar = null;
            if (this.t != null) {
                aVar = this.t.e();
            }
            this.u.init(new NexImageLoader(getContext().getResources(), aVar, this.v, 1440, 810, 1500000));
            if (this.k && !this.s) {
                this.u.setPlaceholders("placeholder2.jpg", "placeholder1.jpg");
            } else {
                this.u.setPlaceholders("placeholder1.jpg", "placeholder2.jpg");
            }
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        d();
        super.onAttachedToWindow();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.c > 0.0f) {
            if (size2 * this.c > size) {
                size2 = (int) (size / this.c);
            } else {
                size = (int) (size2 * this.c);
            }
        }
        setMeasuredDimension(size, size2);
    }

    private void a(boolean z, int i, int i2) {
        this.t = EffectLibrary.a(getContext());
        setEGLContextClientVersion(2);
        setZOrderOnTop(true);
        getHolder().setFormat(1);
        setEGLConfigChooser(new w(this, NexEditorDeviceProfile.getDeviceProfile()));
        setRenderer(new a(this, null));
        setRenderMode(1);
        this.f = b();
    }

    public int getRenderingMode() {
        return getRenderMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements GLSurfaceView.Renderer {
        private a() {
        }

        /* synthetic */ a(EffectPreviewView effectPreviewView, v vVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.opengl.GLSurfaceView.Renderer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onDrawFrame(javax.microedition.khronos.opengles.GL10 r19) {
            /*
                Method dump skipped, instructions count: 760
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.kmpackage.EffectPreviewView.a.onDrawFrame(javax.microedition.khronos.opengles.GL10):void");
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            gl10.glViewport(0, 0, i, i2);
            if (EffectPreviewView.this.u != null) {
                EffectPreviewView.this.u.surfaceChange(i, i2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        }
    }
}
