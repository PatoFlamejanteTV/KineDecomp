package com.adobe.creativesdk.foundation.internal.utils.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* compiled from: PhotoViewAttacher.java */
/* loaded from: classes.dex */
public class g implements com.adobe.creativesdk.foundation.internal.utils.photoview.c, View.OnTouchListener, com.adobe.creativesdk.foundation.internal.utils.photoview.a.f, ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    private static final boolean f6897a = Log.isLoggable("PhotoViewAttacher", 3);

    /* renamed from: b */
    static final Interpolator f6898b = new AccelerateDecelerateInterpolator();
    private int A;
    private b B;
    private boolean D;

    /* renamed from: h */
    private com.adobe.creativesdk.foundation.internal.utils.photoview.d f6904h;
    private WeakReference<ImageView> l;
    private GestureDetector m;
    private com.adobe.creativesdk.foundation.internal.utils.photoview.a.e n;
    private c t;
    private d u;
    private e v;
    private View.OnLongClickListener w;
    private int x;
    private int y;
    private int z;

    /* renamed from: c */
    int f6899c = 200;

    /* renamed from: d */
    private float f6900d = 1.0f;

    /* renamed from: e */
    private float f6901e = 1.75f;

    /* renamed from: f */
    private float f6902f = 3.0f;

    /* renamed from: g */
    private boolean f6903g = true;
    private float i = 1.0f;
    private float j = 0.0f;
    private float k = 0.0f;
    private final Matrix o = new Matrix();
    private final Matrix p = new Matrix();
    private final Matrix q = new Matrix();
    private final RectF r = new RectF();
    private final float[] s = new float[9];
    private int C = 2;
    private ImageView.ScaleType E = ImageView.ScaleType.FIT_CENTER;

    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a */
        private final float f6905a;

        /* renamed from: b */
        private final float f6906b;

        /* renamed from: c */
        private final long f6907c = System.currentTimeMillis();

        /* renamed from: d */
        private final float f6908d;

        /* renamed from: e */
        private final float f6909e;

        public a(float f2, float f3, float f4, float f5) {
            this.f6905a = f4;
            this.f6906b = f5;
            this.f6908d = f2;
            this.f6909e = f3;
        }

        private float b() {
            return g.f6898b.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f6907c)) * 1.0f) / g.this.f6899c));
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView e2 = g.this.e();
            if (e2 == null) {
                return;
            }
            float b2 = b();
            float f2 = this.f6908d;
            float k = (f2 + ((this.f6909e - f2) * b2)) / g.this.k();
            g.this.q.postScale(k, k, this.f6905a, this.f6906b);
            g.this.q();
            if (b2 < 1.0f) {
                com.adobe.creativesdk.foundation.internal.utils.photoview.a.a(e2, this);
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a */
        private final com.adobe.creativesdk.foundation.internal.utils.photoview.c.d f6911a;

        /* renamed from: b */
        private int f6912b;

        /* renamed from: c */
        private int f6913c;

        public b(Context context) {
            this.f6911a = com.adobe.creativesdk.foundation.internal.utils.photoview.c.d.a(context);
        }

        public void a(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF c2 = g.this.c();
            if (c2 == null) {
                return;
            }
            int round = Math.round(-c2.left);
            float f2 = i;
            if (f2 < c2.width()) {
                i6 = Math.round(c2.width() - f2);
                i5 = 0;
            } else {
                i5 = round;
                i6 = i5;
            }
            int round2 = Math.round(-c2.top);
            float f3 = i2;
            if (f3 < c2.height()) {
                i8 = Math.round(c2.height() - f3);
                i7 = 0;
            } else {
                i7 = round2;
                i8 = i7;
            }
            this.f6912b = round;
            this.f6913c = round2;
            if (g.f6897a) {
                com.adobe.creativesdk.foundation.internal.utils.photoview.b.a.a().d("PhotoViewAttacher", "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i6 + " MaxY:" + i8);
            }
            if (round == i6 && round2 == i8) {
                return;
            }
            this.f6911a.a(round, round2, i3, i4, i5, i6, i7, i8, 0, 0);
        }

        public void b() {
            if (g.f6897a) {
                com.adobe.creativesdk.foundation.internal.utils.photoview.b.a.a().d("PhotoViewAttacher", "Cancel Fling");
            }
            this.f6911a.a(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView e2;
            if (this.f6911a.d() || (e2 = g.this.e()) == null || !this.f6911a.a()) {
                return;
            }
            int b2 = this.f6911a.b();
            int c2 = this.f6911a.c();
            if (g.f6897a) {
                com.adobe.creativesdk.foundation.internal.utils.photoview.b.a.a().d("PhotoViewAttacher", "fling run(). CurrentX:" + this.f6912b + " CurrentY:" + this.f6913c + " NewX:" + b2 + " NewY:" + c2);
            }
            g.this.q.postTranslate(this.f6912b - b2, this.f6913c - c2);
            g gVar = g.this;
            gVar.b(gVar.d());
            this.f6912b = b2;
            this.f6913c = c2;
            com.adobe.creativesdk.foundation.internal.utils.photoview.a.a(e2, this);
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(RectF rectF);
    }

    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(View view, float f2, float f3);
    }

    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes.dex */
    public interface e {
        void a(View view, float f2, float f3);
    }

    public g(ImageView imageView) {
        this.l = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        d(imageView);
        if (imageView.isInEditMode()) {
            return;
        }
        this.n = com.adobe.creativesdk.foundation.internal.utils.photoview.a.g.a(imageView.getContext(), this);
        this.m = new GestureDetector(imageView.getContext(), new com.adobe.creativesdk.foundation.internal.utils.photoview.e(this));
        this.m.setOnDoubleTapListener(new com.adobe.creativesdk.foundation.internal.utils.photoview.b(this));
        b(true);
    }

    private static void d(ImageView imageView) {
        if (imageView == null || (imageView instanceof com.adobe.creativesdk.foundation.internal.utils.photoview.c) || ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void p() {
        b bVar = this.B;
        if (bVar != null) {
            bVar.b();
            this.B = null;
        }
    }

    public void q() {
        if (s()) {
            b(d());
        }
    }

    private void r() {
        ImageView e2 = e();
        if (e2 != null && !(e2 instanceof com.adobe.creativesdk.foundation.internal.utils.photoview.c) && !ImageView.ScaleType.MATRIX.equals(e2.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean s() {
        RectF a2;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        ImageView e2 = e();
        if (e2 == null || (a2 = a(d())) == null) {
            return false;
        }
        float height = a2.height();
        float width = a2.width();
        float a3 = a(e2);
        float f8 = 0.0f;
        if (height <= a3) {
            int i = f.f6896a[this.E.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    a3 = (a3 - height) / 2.0f;
                    f3 = a2.top;
                } else {
                    a3 -= height;
                    f3 = a2.top;
                }
                f4 = a3 - f3;
            } else {
                f2 = a2.top;
                f4 = -f2;
            }
        } else {
            f2 = a2.top;
            if (f2 <= 0.0f) {
                f3 = a2.bottom;
                if (f3 >= a3) {
                    f4 = 0.0f;
                }
                f4 = a3 - f3;
            }
            f4 = -f2;
        }
        float b2 = b(e2);
        if (width <= b2) {
            int i2 = f.f6896a[this.E.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f6 = (b2 - width) / 2.0f;
                    f7 = a2.left;
                } else {
                    f6 = b2 - width;
                    f7 = a2.left;
                }
                f5 = f6 - f7;
            } else {
                f5 = -a2.left;
            }
            f8 = f5;
            this.C = 2;
        } else {
            float f9 = a2.left;
            if (f9 > 0.0f) {
                this.C = 0;
                f8 = -f9;
            } else {
                float f10 = a2.right;
                if (f10 < b2) {
                    f8 = b2 - f10;
                    this.C = 1;
                } else {
                    this.C = -1;
                }
            }
        }
        this.q.postTranslate(f8, f4);
        return true;
    }

    private void t() {
        this.q.reset();
        a(this.i, this.j, this.k, false);
        b(d());
        s();
    }

    public void e(float f2) {
        this.q.setRotate(f2 % 360.0f);
        q();
    }

    public float f() {
        return this.f6902f;
    }

    public void g(float f2) {
        this.j = f2;
    }

    public void h(float f2) {
        this.k = f2;
    }

    public d i() {
        return this.u;
    }

    public e j() {
        return this.v;
    }

    public float k() {
        return (float) Math.sqrt(((float) Math.pow(a(this.q, 0), 2.0d)) + ((float) Math.pow(a(this.q, 3), 2.0d)));
    }

    public ImageView.ScaleType l() {
        return this.E;
    }

    public Bitmap m() {
        ImageView e2 = e();
        if (e2 == null) {
            return null;
        }
        return e2.getDrawingCache();
    }

    public com.adobe.creativesdk.foundation.internal.utils.photoview.d n() {
        return this.f6904h;
    }

    public void o() {
        ImageView e2 = e();
        if (e2 != null) {
            if (this.D) {
                d(e2);
                a(e2.getDrawable());
            } else {
                t();
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView e2 = e();
        if (e2 != null) {
            if (this.D) {
                int top = e2.getTop();
                int right = e2.getRight();
                int bottom = e2.getBottom();
                int left = e2.getLeft();
                if (top == this.x && bottom == this.z && left == this.A && right == this.y) {
                    return;
                }
                a(e2.getDrawable());
                this.x = top;
                this.y = right;
                this.z = bottom;
                this.A = left;
                return;
            }
            a(e2.getDrawable());
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        RectF c2;
        boolean z = false;
        if (!this.D || !c((ImageView) view)) {
            return false;
        }
        ViewParent parent = view.getParent();
        int action = motionEvent.getAction();
        if (action == 0) {
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            } else {
                Log.i("PhotoViewAttacher", "onTouch getParent() returned null");
            }
            p();
        } else if ((action == 1 || action == 3) && k() < this.f6900d && (c2 = c()) != null) {
            view.post(new a(k(), this.f6900d, c2.centerX(), c2.centerY()));
            z = true;
        }
        com.adobe.creativesdk.foundation.internal.utils.photoview.a.e eVar = this.n;
        if (eVar != null && eVar.onTouchEvent(motionEvent)) {
            z = true;
        }
        GestureDetector gestureDetector = this.m;
        if (gestureDetector == null || !gestureDetector.onTouchEvent(motionEvent)) {
            return z;
        }
        return true;
    }

    private static void b(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        }
        if (f3 >= f4) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    private static boolean c(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    public void f(float f2) {
        a(f2, false);
    }

    public float g() {
        return this.f6901e;
    }

    public float h() {
        return this.f6900d;
    }

    public RectF c() {
        s();
        return a(d());
    }

    public ImageView e() {
        WeakReference<ImageView> weakReference = this.l;
        ImageView imageView = weakReference != null ? weakReference.get() : null;
        if (imageView == null) {
            b();
            Log.i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    private static boolean b(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (f.f6896a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
    }

    public void a(com.adobe.creativesdk.foundation.internal.utils.photoview.d dVar) {
        this.f6904h = dVar;
    }

    public void d(float f2) {
        this.q.postRotate(f2 % 360.0f);
        q();
    }

    public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.m.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.m.setOnDoubleTapListener(new com.adobe.creativesdk.foundation.internal.utils.photoview.b(this));
        }
    }

    public void c(float f2) {
        b(f2, this.f6901e, this.f6902f);
        this.f6900d = f2;
    }

    public void b() {
        WeakReference<ImageView> weakReference = this.l;
        if (weakReference == null) {
            return;
        }
        ImageView imageView = weakReference.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                if (Build.VERSION.SDK_INT < 16) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                } else {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
            imageView.setOnTouchListener(null);
            p();
        }
        GestureDetector gestureDetector = this.m;
        if (gestureDetector != null) {
            gestureDetector.setOnDoubleTapListener(null);
        }
        this.t = null;
        this.u = null;
        this.v = null;
        this.l = null;
    }

    public Matrix d() {
        this.p.set(this.o);
        this.p.postConcat(this.q);
        return this.p;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.a.f
    public void a(float f2, float f3) {
        if (this.n.a()) {
            return;
        }
        if (f6897a) {
            com.adobe.creativesdk.foundation.internal.utils.photoview.b.a.a().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
        }
        ImageView e2 = e();
        this.q.postTranslate(f2, f3);
        q();
        ViewParent parent = e2.getParent();
        if (!this.f6903g || this.n.a()) {
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
                return;
            }
            return;
        }
        int i = this.C;
        if ((i == 2 || ((i == 0 && f2 >= 1.0f) || (this.C == 1 && f2 <= -1.0f))) && parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
            com.adobe.creativesdk.foundation.internal.utils.photoview.d dVar = this.f6904h;
            if (dVar != null) {
                dVar.a(f2, f3);
            }
        }
    }

    public void b(float f2) {
        b(this.f6900d, f2, this.f6902f);
        this.f6901e = f2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.a.f
    public void a(float f2, float f3, float f4, float f5) {
        if (f6897a) {
            com.adobe.creativesdk.foundation.internal.utils.photoview.b.a.a().d("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView e2 = e();
        this.B = new b(e2.getContext());
        this.B.a(b(e2), a(e2), (int) f4, (int) f5);
        e2.post(this.B);
    }

    public void b(boolean z) {
        this.D = z;
        o();
    }

    public void b(Matrix matrix) {
        RectF a2;
        ImageView e2 = e();
        if (e2 != null) {
            r();
            e2.setImageMatrix(matrix);
            if (this.t == null || (a2 = a(matrix)) == null) {
                return;
            }
            this.t.a(a2);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.a.f
    public void a(float f2, float f3, float f4) {
        Log.d("PhotoView.Scale", String.format("in onScale with scaleFactor %f", Float.valueOf(f2)));
        if (f6897a) {
            com.adobe.creativesdk.foundation.internal.utils.photoview.b.a.a().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (k() < this.f6902f || f2 < 1.0f) {
            this.q.postScale(f2, f2, f3, f4);
            com.adobe.creativesdk.foundation.internal.utils.photoview.d dVar = this.f6904h;
            if (dVar != null) {
                dVar.a(k(), f3, f4);
            }
            q();
        }
    }

    private int b(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public void a(boolean z) {
        this.f6903g = z;
    }

    public void a(float f2) {
        b(this.f6900d, this.f6901e, f2);
        this.f6902f = f2;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.w = onLongClickListener;
    }

    public void a(c cVar) {
        this.t = cVar;
    }

    public void a(d dVar) {
        this.u = dVar;
    }

    public void a(e eVar) {
        this.v = eVar;
    }

    public void a(float f2, boolean z) {
        if (e() != null) {
            a(f2, r0.getRight() / 2, r0.getBottom() / 2, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(float r10, float r11, float r12, boolean r13) {
        /*
            r9 = this;
            android.widget.ImageView r0 = r9.e()
            if (r0 == 0) goto L4b
            float r1 = r9.f6900d
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 < 0) goto L15
            float r1 = r9.f6902f
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 <= 0) goto L13
            goto L15
        L13:
            r6 = r10
            goto L2e
        L15:
            com.adobe.creativesdk.foundation.internal.utils.photoview.b.b r1 = com.adobe.creativesdk.foundation.internal.utils.photoview.b.a.a()
            java.lang.String r2 = "PhotoViewAttacher"
            java.lang.String r3 = "Scale must be within the range of minScale and maxScale"
            r1.a(r2, r3)
            float r1 = r9.f6902f
            int r2 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r2 <= 0) goto L27
            r10 = r1
        L27:
            float r1 = r9.f6900d
            int r2 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r2 >= 0) goto L13
            r6 = r1
        L2e:
            if (r13 == 0) goto L41
            com.adobe.creativesdk.foundation.internal.utils.photoview.g$a r10 = new com.adobe.creativesdk.foundation.internal.utils.photoview.g$a
            float r5 = r9.k()
            r3 = r10
            r4 = r9
            r7 = r11
            r8 = r12
            r3.<init>(r5, r6, r7, r8)
            r0.post(r10)
            goto L4b
        L41:
            android.graphics.Matrix r10 = r9.q
            r10.setScale(r6, r6, r11, r12)
            r9.i = r6
            r9.q()
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.utils.photoview.g.a(float, float, float, boolean):void");
    }

    public void a(ImageView.ScaleType scaleType) {
        if (!b(scaleType) || scaleType == this.E) {
            return;
        }
        this.E = scaleType;
        o();
    }

    private RectF a(Matrix matrix) {
        Drawable drawable;
        ImageView e2 = e();
        if (e2 == null || (drawable = e2.getDrawable()) == null) {
            return null;
        }
        this.r.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.r);
        return this.r;
    }

    public void a(int i) {
        if (i < 0) {
            i = 200;
        }
        this.f6899c = i;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.s);
        return this.s[i];
    }

    private void a(Drawable drawable) {
        ImageView e2 = e();
        if (e2 == null || drawable == null) {
            return;
        }
        float b2 = b(e2);
        float a2 = a(e2);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.o.reset();
        float f2 = intrinsicWidth;
        float f3 = b2 / f2;
        float f4 = intrinsicHeight;
        float f5 = a2 / f4;
        ImageView.ScaleType scaleType = this.E;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.o.postTranslate((b2 - f2) / 2.0f, (a2 - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f3, f5);
            this.o.postScale(max, max);
            this.o.postTranslate((b2 - (f2 * max)) / 2.0f, (a2 - (f4 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f3, f5));
            this.o.postScale(min, min);
            this.o.postTranslate((b2 - (f2 * min)) / 2.0f, (a2 - (f4 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, b2, a2);
            int i = f.f6896a[this.E.ordinal()];
            if (i == 2) {
                this.o.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i == 3) {
                this.o.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i == 4) {
                this.o.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i == 5) {
                this.o.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        t();
    }

    private int a(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }
}
