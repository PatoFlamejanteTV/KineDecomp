package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nextreaming.nexeditorui.NexTimeline;

/* compiled from: TimelineItemDecoration.java */
/* loaded from: classes2.dex */
public class A extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    private static final String f22546a = "A";

    /* renamed from: b, reason: collision with root package name */
    private final Context f22547b;

    /* renamed from: c, reason: collision with root package name */
    private final UniformTimelineView f22548c;

    /* renamed from: d, reason: collision with root package name */
    private final float f22549d;

    /* renamed from: e, reason: collision with root package name */
    private final int f22550e;

    /* renamed from: f, reason: collision with root package name */
    private final a f22551f;

    /* renamed from: g, reason: collision with root package name */
    private int f22552g;

    /* renamed from: h, reason: collision with root package name */
    private int f22553h;
    private UniformTimelineLayoutManager i;
    private T j;
    private boolean k;

    /* compiled from: TimelineItemDecoration.java */
    /* loaded from: classes2.dex */
    private final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f22554a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f22555b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f22556c;

        a(int i) {
            this.f22554a = (i & 1) == 1;
            this.f22555b = (i & 2) == 2;
            Log.d(A.f22546a, "[ScrollHandler] vertical: " + this.f22554a + ", horizontal: " + this.f22555b);
        }

        public void b() {
            if (this.f22556c) {
                return;
            }
            A.this.n().postOnAnimation(this);
            this.f22556c = true;
            Log.d(A.f22546a, "[ScrollHandler] start");
        }

        public void c() {
            if (this.f22556c) {
                A.this.n().removeCallbacks(this);
                this.f22556c = false;
                Log.d(A.f22546a, "[ScrollHandler] stop");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            if (this.f22556c) {
                int i2 = 0;
                if (this.f22555b) {
                    float width = (A.this.f22552g * (1.0f / A.this.n().getWidth())) - 0.5f;
                    i = ((int) Math.signum(width)) * ((int) ((A.this.e() * 25.0f * Math.max(0.0f, 0.3f - ((0.5f - Math.abs(width)) * 3.3333333f))) + 0.5f));
                } else {
                    i = 0;
                }
                if (this.f22554a) {
                    float height = (A.this.f22553h * (1.0f / A.this.n().getHeight())) - 0.5f;
                    i2 = ((int) Math.signum(height)) * ((int) ((A.this.e() * 25.0f * Math.max(0.0f, 0.3f - ((0.5f - Math.abs(height)) * 3.3333333f))) + 0.5f));
                }
                Log.d(A.f22546a, "[ScrollHandler] dx: " + i + ", dy: " + i2 + ", pos(" + A.this.f22552g + ", " + A.this.f22553h + ")");
                if (i != 0 || i2 != 0) {
                    A.this.n().scrollBy(i, i2);
                    A.this.r();
                }
                A.this.n().postOnAnimation(this);
            }
        }
    }

    public A(UniformTimelineView uniformTimelineView) {
        this(uniformTimelineView, false);
    }

    public final T c() {
        T t = this.j;
        if (t != null) {
            return t;
        }
        if (this.f22548c.getAdapter() instanceof T) {
            this.j = (T) this.f22548c.getAdapter();
            return this.j;
        }
        throw new RuntimeException("Unsupported operation");
    }

    public final Context d() {
        return this.f22547b;
    }

    public final float e() {
        return this.f22549d;
    }

    public final DisplayMetrics f() {
        return j().getDisplayMetrics();
    }

    public final LayoutInflater g() {
        return LayoutInflater.from(this.f22547b);
    }

    public final UniformTimelineLayoutManager h() {
        UniformTimelineLayoutManager uniformTimelineLayoutManager = this.i;
        if (uniformTimelineLayoutManager != null) {
            return uniformTimelineLayoutManager;
        }
        if (this.f22548c.getLayoutManager() instanceof UniformTimelineLayoutManager) {
            this.i = (UniformTimelineLayoutManager) this.f22548c.getLayoutManager();
            return this.i;
        }
        throw new RuntimeException("Unsupported operation");
    }

    public final int i() {
        return this.f22550e;
    }

    public final Resources j() {
        return this.f22547b.getResources();
    }

    public float k() {
        return h().f();
    }

    protected int l() {
        return 3;
    }

    public NexTimeline m() {
        return this.f22548c.getTimeline();
    }

    public final UniformTimelineView n() {
        return this.f22548c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int o() {
        return this.f22552g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int p() {
        return this.f22553h;
    }

    public boolean q() {
        return this.k;
    }

    protected void r() {
        n().postInvalidateOnAnimation();
    }

    public A(UniformTimelineView uniformTimelineView, boolean z) {
        this.f22547b = uniformTimelineView.getContext().getApplicationContext();
        this.f22548c = uniformTimelineView;
        this.k = z;
        this.f22549d = j().getDisplayMetrics().density;
        this.f22550e = new Canvas().getMaximumBitmapWidth() / 8;
        this.f22551f = new a(l());
    }

    public Drawable b(int i) {
        return ResourcesCompat.getDrawable(j(), i, null);
    }

    protected X a(int i) {
        return (X) n().findViewHolderForAdapterPosition(i);
    }

    public void b() {
        this.k = false;
        this.f22551f.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public X a(Fa fa) {
        int a2 = c().a(fa);
        if (a2 != -1) {
            return a(a2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        this.k = z;
    }

    public int a(float f2) {
        return (int) TypedValue.applyDimension(1, f2, j().getDisplayMetrics());
    }

    public void a(MotionEvent motionEvent) {
        this.f22552g = (int) (motionEvent.getX() + 0.5f);
        this.f22553h = (int) (motionEvent.getY() + 0.5f);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f22551f.b();
        } else if (actionMasked == 1 || actionMasked == 3 || actionMasked == 4) {
            this.f22551f.c();
        }
    }
}
