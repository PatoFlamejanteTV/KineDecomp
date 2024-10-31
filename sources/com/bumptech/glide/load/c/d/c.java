package com.bumptech.glide.load.c.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import b.b.e.a.b;
import com.bumptech.glide.g.l;
import com.bumptech.glide.load.c.d.g;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: GifDrawable.java */
/* loaded from: classes.dex */
public class c extends Drawable implements g.b, Animatable, b.b.e.a.b {

    /* renamed from: a */
    private final a f8695a;

    /* renamed from: b */
    private boolean f8696b;

    /* renamed from: c */
    private boolean f8697c;

    /* renamed from: d */
    private boolean f8698d;

    /* renamed from: e */
    private boolean f8699e;

    /* renamed from: f */
    private int f8700f;

    /* renamed from: g */
    private int f8701g;

    /* renamed from: h */
    private boolean f8702h;
    private Paint i;
    private Rect j;
    private List<b.a> k;

    /* compiled from: GifDrawable.java */
    /* loaded from: classes.dex */
    public static final class a extends Drawable.ConstantState {

        /* renamed from: a */
        final g f8703a;

        a(g gVar) {
            this.f8703a = gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new c(this);
        }
    }

    public c(Context context, com.bumptech.glide.b.a aVar, com.bumptech.glide.load.j<Bitmap> jVar, int i, int i2, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.c.a(context), aVar, i, i2, jVar, bitmap)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback h() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect i() {
        if (this.j == null) {
            this.j = new Rect();
        }
        return this.j;
    }

    private Paint j() {
        if (this.i == null) {
            this.i = new Paint(2);
        }
        return this.i;
    }

    private void k() {
        List<b.a> list = this.k;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.k.get(i).a(this);
            }
        }
    }

    private void l() {
        this.f8700f = 0;
    }

    private void m() {
        l.a(!this.f8698d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f8695a.f8703a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.f8696b) {
                return;
            }
            this.f8696b = true;
            this.f8695a.f8703a.a(this);
            invalidateSelf();
        }
    }

    private void n() {
        this.f8696b = false;
        this.f8695a.f8703a.b(this);
    }

    public void a(com.bumptech.glide.load.j<Bitmap> jVar, Bitmap bitmap) {
        this.f8695a.f8703a.a(jVar, bitmap);
    }

    public ByteBuffer b() {
        return this.f8695a.f8703a.b();
    }

    public Bitmap c() {
        return this.f8695a.f8703a.e();
    }

    public int d() {
        return this.f8695a.f8703a.f();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f8698d) {
            return;
        }
        if (this.f8702h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), i());
            this.f8702h = false;
        }
        canvas.drawBitmap(this.f8695a.f8703a.c(), (Rect) null, i(), j());
    }

    public int e() {
        return this.f8695a.f8703a.d();
    }

    public int f() {
        return this.f8695a.f8703a.h();
    }

    public void g() {
        this.f8698d = true;
        this.f8695a.f8703a.a();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f8695a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f8695a.f8703a.g();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f8695a.f8703a.i();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f8696b;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f8702h = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        j().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        j().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        l.a(!this.f8698d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f8699e = z;
        if (!z) {
            n();
        } else if (this.f8697c) {
            m();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f8697c = true;
        l();
        if (this.f8699e) {
            m();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f8697c = false;
        n();
    }

    @Override // com.bumptech.glide.load.c.d.g.b
    public void a() {
        if (h() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (e() == d() - 1) {
            this.f8700f++;
        }
        int i = this.f8701g;
        if (i == -1 || this.f8700f < i) {
            return;
        }
        k();
        stop();
    }

    c(a aVar) {
        this.f8699e = true;
        this.f8701g = -1;
        l.a(aVar);
        this.f8695a = aVar;
    }
}
