package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

/* loaded from: classes.dex */
public final class zzls extends Drawable implements Drawable.Callback {
    private int mFrom;
    private long zzNY;
    private boolean zzaea;
    private int zzaeh;
    private int zzaei;
    private int zzaej;
    private int zzaek;
    private int zzael;
    private boolean zzaem;
    private b zzaen;
    private Drawable zzaeo;
    private Drawable zzaep;
    private boolean zzaeq;
    private boolean zzaer;
    private boolean zzaes;
    private int zzaet;

    /* loaded from: classes.dex */
    private static final class a extends Drawable {

        /* renamed from: a, reason: collision with root package name */
        private static final a f1765a = new a();
        private static final C0036a b = new C0036a();

        /* renamed from: com.google.android.gms.internal.zzls$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static final class C0036a extends Drawable.ConstantState {
            private C0036a() {
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public int getChangingConfigurations() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public Drawable newDrawable() {
                return a.f1765a;
            }
        }

        private a() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public Drawable.ConstantState getConstantState() {
            return b;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        int f1766a;
        int b;

        b(b bVar) {
            if (bVar != null) {
                this.f1766a = bVar.f1766a;
                this.b = bVar.b;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1766a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new zzls(this);
        }
    }

    public zzls(Drawable drawable, Drawable drawable2) {
        this(null);
        drawable = drawable == null ? a.f1765a : drawable;
        this.zzaeo = drawable;
        drawable.setCallback(this);
        this.zzaen.b |= drawable.getChangingConfigurations();
        drawable2 = drawable2 == null ? a.f1765a : drawable2;
        this.zzaep = drawable2;
        drawable2.setCallback(this);
        this.zzaen.b |= drawable2.getChangingConfigurations();
    }

    zzls(b bVar) {
        this.zzaeh = 0;
        this.zzaej = 255;
        this.zzael = 0;
        this.zzaea = true;
        this.zzaen = new b(bVar);
    }

    public boolean canConstantState() {
        if (!this.zzaeq) {
            this.zzaer = (this.zzaeo.getConstantState() == null || this.zzaep.getConstantState() == null) ? false : true;
            this.zzaeq = true;
        }
        return this.zzaer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = false;
        switch (this.zzaeh) {
            case 1:
                this.zzNY = SystemClock.uptimeMillis();
                this.zzaeh = 2;
                break;
            case 2:
                if (this.zzNY >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zzNY)) / this.zzaek;
                    r1 = uptimeMillis >= 1.0f;
                    if (r1) {
                        this.zzaeh = 0;
                    }
                    this.zzael = (int) ((Math.min(uptimeMillis, 1.0f) * (this.zzaei - this.mFrom)) + this.mFrom);
                }
            default:
                z = r1;
                break;
        }
        int i = this.zzael;
        boolean z2 = this.zzaea;
        Drawable drawable = this.zzaeo;
        Drawable drawable2 = this.zzaep;
        if (z) {
            if (!z2 || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.zzaej) {
                drawable2.setAlpha(this.zzaej);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z2) {
            drawable.setAlpha(this.zzaej - i);
        }
        drawable.draw(canvas);
        if (z2) {
            drawable.setAlpha(this.zzaej);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zzaej);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.zzaen.f1766a | this.zzaen.b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.zzaen.f1766a = getChangingConfigurations();
        return this.zzaen;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.zzaeo.getIntrinsicHeight(), this.zzaep.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.zzaeo.getIntrinsicWidth(), this.zzaep.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (!this.zzaes) {
            this.zzaet = Drawable.resolveOpacity(this.zzaeo.getOpacity(), this.zzaep.getOpacity());
            this.zzaes = true;
        }
        return this.zzaet;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback;
        if (!zzmx.zzqu() || (callback = getCallback()) == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.zzaem && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.zzaeo.mutate();
            this.zzaep.mutate();
            this.zzaem = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.zzaeo.setBounds(rect);
        this.zzaep.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback;
        if (!zzmx.zzqu() || (callback = getCallback()) == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.zzael == this.zzaej) {
            this.zzael = i;
        }
        this.zzaej = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.zzaeo.setColorFilter(colorFilter);
        this.zzaep.setColorFilter(colorFilter);
    }

    public void startTransition(int i) {
        this.mFrom = 0;
        this.zzaei = this.zzaej;
        this.zzael = 0;
        this.zzaek = i;
        this.zzaeh = 1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback;
        if (!zzmx.zzqu() || (callback = getCallback()) == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public Drawable zzoF() {
        return this.zzaep;
    }
}
