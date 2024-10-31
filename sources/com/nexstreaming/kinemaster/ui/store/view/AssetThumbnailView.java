package com.nexstreaming.kinemaster.ui.store.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.h;
import com.bumptech.glide.j;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;

/* loaded from: classes2.dex */
public class AssetThumbnailView extends AppCompatImageView {

    /* renamed from: c, reason: collision with root package name */
    private int f23659c;

    /* renamed from: d, reason: collision with root package name */
    private int f23660d;

    /* renamed from: e, reason: collision with root package name */
    private int f23661e;

    /* renamed from: f, reason: collision with root package name */
    private int f23662f;

    /* renamed from: g, reason: collision with root package name */
    private int f23663g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f23664h;
    private RoundedBitmapDrawable i;
    private int j;
    private Paint k;
    private Paint l;
    private j m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        int f23665a;

        /* renamed from: b, reason: collision with root package name */
        int f23666b;

        a(int i, int i2) {
            this.f23665a = i;
            this.f23666b = i2;
        }

        public String toString() {
            return this.f23665a + FragmentC2201x.f23219a + this.f23666b;
        }
    }

    public AssetThumbnailView(Context context) {
        super(context);
        this.f23659c = -1;
    }

    private a a(a aVar, float f2, float f3) {
        if (this.f23660d == 0) {
            aVar.f23666b = (int) (aVar.f23665a * (f3 / f2));
        } else {
            aVar.f23665a = (int) (aVar.f23666b * (f2 / f3));
        }
        return aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        RoundedBitmapDrawable roundedBitmapDrawable;
        if (this.j > 0 && (roundedBitmapDrawable = this.i) != null) {
            roundedBitmapDrawable.setBounds(0, 0, getWidth(), getHeight());
            this.i.draw(canvas);
        } else {
            if (getDrawable() == null && (drawable = this.f23664h) != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.f23664h.getIntrinsicHeight();
                int width = (getWidth() - intrinsicWidth) / 2;
                int height = (getHeight() - intrinsicHeight) / 2;
                this.f23664h.setBounds(width, height, intrinsicWidth + width, intrinsicHeight + height);
                this.f23664h.draw(canvas);
            }
            super.onDraw(canvas);
        }
        if (this.f23663g > 0) {
            if (this.k == null) {
                this.k = new Paint(1);
                this.k.setStyle(Paint.Style.STROKE);
                this.k.setStrokeWidth(this.f23663g);
                this.k.setColor(Color.argb(80, 128, 128, 128));
            }
            float f2 = this.f23663g / 2.0f;
            RectF rectF = new RectF(f2, f2, getWidth() - f2, getHeight() - f2);
            int i = this.j;
            canvas.drawRoundRect(rectF, i, i, this.k);
        }
        if (!a() || this.f23661e <= 0 || this.f23662f <= 0) {
            return;
        }
        if (this.l == null) {
            this.l = new Paint(1);
            if (this.f23661e == 1) {
                this.l.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.f23662f, ViewCompat.MEASURED_STATE_MASK, 0, Shader.TileMode.CLAMP));
            } else {
                this.l.setShader(new LinearGradient(0.0f, getHeight() - this.f23662f, 0.0f, getHeight(), 0, ViewCompat.MEASURED_STATE_MASK, Shader.TileMode.CLAMP));
            }
        }
        int i2 = this.f23661e;
        if (i2 == 1) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.f23662f, this.l);
        } else if (i2 == 2) {
            canvas.drawRect(0.0f, getHeight() - this.f23662f, getWidth(), getHeight(), this.l);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f23659c < 0) {
            super.onMeasure(i, i2);
            return;
        }
        a aVar = new a(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        int i3 = this.f23659c;
        if (i3 == 0) {
            a(aVar, 16.0f, 9.0f);
        } else if (i3 == 1) {
            a(aVar, 9.0f, 16.0f);
        } else if (i3 == 2) {
            a(aVar, 1.0f, 1.0f);
        } else if (i3 == 3) {
            a(aVar, 4.0f, 3.0f);
        }
        setMeasuredDimension(aVar.f23665a, aVar.f23666b);
    }

    public void setGlideRequestManager(j jVar) {
        this.m = jVar;
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.j > 0) {
            Bitmap a2 = a(drawable);
            if (a2 != null) {
                this.i = RoundedBitmapDrawableFactory.create(getResources(), a2);
                this.i.setCornerRadius(this.j);
            } else {
                this.i = null;
            }
        }
        super.setImageDrawable(drawable);
    }

    public void setImageUrl(String str) {
        j jVar = this.m;
        if (jVar != null) {
            h<Drawable> a2 = jVar.a(str);
            a2.b(0.1f);
            a2.a((ImageView) this);
        }
    }

    public AssetThumbnailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AssetThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23659c = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.AssetThumbnailView);
        if (obtainStyledAttributes != null) {
            this.f23659c = obtainStyledAttributes.getInteger(0, -1);
            this.f23660d = obtainStyledAttributes.getInteger(2, 0);
            this.j = obtainStyledAttributes.getDimensionPixelSize(6, 0);
            this.f23661e = obtainStyledAttributes.getInteger(3, 0);
            this.f23662f = obtainStyledAttributes.getDimensionPixelSize(4, 0);
            this.f23663g = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.f23664h = obtainStyledAttributes.getDrawable(5);
            obtainStyledAttributes.recycle();
        }
    }

    private static Bitmap a(Drawable drawable) {
        int intrinsicWidth;
        int intrinsicHeight;
        Bitmap bitmap = null;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof TransitionDrawable) {
                drawable = ((TransitionDrawable) drawable).getDrawable(((TransitionDrawable) drawable).getNumberOfLayers() - 1);
            }
            intrinsicWidth = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
        }
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            if (bitmap != null) {
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                drawable.draw(canvas);
            }
            return bitmap;
        }
        return null;
    }

    private boolean a() {
        return getDrawable() != null && getDrawable().getIntrinsicWidth() > 0 && getDrawable().getIntrinsicHeight() > 0;
    }
}
