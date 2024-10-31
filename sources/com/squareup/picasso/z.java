package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PicassoDrawable.java */
/* loaded from: classes3.dex */
public final class z extends BitmapDrawable {

    /* renamed from: a, reason: collision with root package name */
    private static final Paint f25680a = new Paint();

    /* renamed from: b, reason: collision with root package name */
    private final boolean f25681b;

    /* renamed from: c, reason: collision with root package name */
    private final float f25682c;

    /* renamed from: d, reason: collision with root package name */
    private final Picasso.LoadedFrom f25683d;

    /* renamed from: e, reason: collision with root package name */
    Drawable f25684e;

    /* renamed from: f, reason: collision with root package name */
    long f25685f;

    /* renamed from: g, reason: collision with root package name */
    boolean f25686g;

    /* renamed from: h, reason: collision with root package name */
    int f25687h;

    z(Context context, Bitmap bitmap, Drawable drawable, Picasso.LoadedFrom loadedFrom, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f25687h = 255;
        this.f25681b = z2;
        this.f25682c = context.getResources().getDisplayMetrics().density;
        this.f25683d = loadedFrom;
        if ((loadedFrom == Picasso.LoadedFrom.MEMORY || z) ? false : true) {
            this.f25684e = drawable;
            this.f25686g = true;
            this.f25685f = SystemClock.uptimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ImageView imageView, Context context, Bitmap bitmap, Picasso.LoadedFrom loadedFrom, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new z(context, bitmap, drawable, loadedFrom, z, z2));
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.f25686g) {
            super.draw(canvas);
        } else {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f25685f)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f25686g = false;
                this.f25684e = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.f25684e;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (this.f25687h * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f25687h);
                if (Build.VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        }
        if (this.f25681b) {
            a(canvas);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f25684e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f25687h = i;
        Drawable drawable = this.f25684e;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        super.setAlpha(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f25684e;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    private void a(Canvas canvas) {
        f25680a.setColor(-1);
        canvas.drawPath(a(new Point(0, 0), (int) (this.f25682c * 16.0f)), f25680a);
        f25680a.setColor(this.f25683d.debugColor);
        canvas.drawPath(a(new Point(0, 0), (int) (this.f25682c * 15.0f)), f25680a);
    }

    private static Path a(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo(point.x, point.y);
        path.lineTo(point2.x, point2.y);
        path.lineTo(point3.x, point3.y);
        return path;
    }
}
