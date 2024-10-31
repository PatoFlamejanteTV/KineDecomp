package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class AppCompatImageHelper {

    /* renamed from: a, reason: collision with root package name */
    private final ImageView f2637a;

    /* renamed from: b, reason: collision with root package name */
    private TintInfo f2638b;

    /* renamed from: c, reason: collision with root package name */
    private TintInfo f2639c;

    /* renamed from: d, reason: collision with root package name */
    private TintInfo f2640d;

    public AppCompatImageHelper(ImageView imageView) {
        this.f2637a = imageView;
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f2638b != null : i == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.f2639c == null) {
            this.f2639c = new TintInfo();
        }
        TintInfo tintInfo = this.f2639c;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        TintInfo tintInfo = this.f2639c;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        TintInfo tintInfo = this.f2639c;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return Build.VERSION.SDK_INT < 21 || !(this.f2637a.getBackground() instanceof RippleDrawable);
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f2637a.getContext(), attributeSet, R.styleable.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f2637a.getDrawable();
            if (drawable == null && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = AppCompatResources.getDrawable(this.f2637a.getContext(), resourceId)) != null) {
                this.f2637a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.a(drawable);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.AppCompatImageView_tint)) {
                ImageViewCompat.setImageTintList(this.f2637a, obtainStyledAttributes.getColorStateList(R.styleable.AppCompatImageView_tint));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.AppCompatImageView_tintMode)) {
                ImageViewCompat.setImageTintMode(this.f2637a, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setImageResource(int i) {
        if (i != 0) {
            Drawable drawable = AppCompatResources.getDrawable(this.f2637a.getContext(), i);
            if (drawable != null) {
                DrawableUtils.a(drawable);
            }
            this.f2637a.setImageDrawable(drawable);
        } else {
            this.f2637a.setImageDrawable(null);
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.f2639c == null) {
            this.f2639c = new TintInfo();
        }
        TintInfo tintInfo = this.f2639c;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Drawable drawable = this.f2637a.getDrawable();
        if (drawable != null) {
            DrawableUtils.a(drawable);
        }
        if (drawable != null) {
            if (e() && a(drawable)) {
                return;
            }
            TintInfo tintInfo = this.f2639c;
            if (tintInfo != null) {
                AppCompatDrawableManager.a(drawable, tintInfo, this.f2637a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f2638b;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.a(drawable, tintInfo2, this.f2637a.getDrawableState());
            }
        }
    }

    private boolean a(Drawable drawable) {
        if (this.f2640d == null) {
            this.f2640d = new TintInfo();
        }
        TintInfo tintInfo = this.f2640d;
        tintInfo.a();
        ColorStateList imageTintList = ImageViewCompat.getImageTintList(this.f2637a);
        if (imageTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = imageTintList;
        }
        PorterDuff.Mode imageTintMode = ImageViewCompat.getImageTintMode(this.f2637a);
        if (imageTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = imageTintMode;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            return false;
        }
        AppCompatDrawableManager.a(drawable, tintInfo, this.f2637a.getDrawableState());
        return true;
    }
}
