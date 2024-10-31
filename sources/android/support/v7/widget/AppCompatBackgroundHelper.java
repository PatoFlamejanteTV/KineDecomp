package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppCompatBackgroundHelper {

    /* renamed from: a, reason: collision with root package name */
    private final View f2608a;

    /* renamed from: d, reason: collision with root package name */
    private TintInfo f2611d;

    /* renamed from: e, reason: collision with root package name */
    private TintInfo f2612e;

    /* renamed from: f, reason: collision with root package name */
    private TintInfo f2613f;

    /* renamed from: c, reason: collision with root package name */
    private int f2610c = -1;

    /* renamed from: b, reason: collision with root package name */
    private final AppCompatDrawableManager f2609b = AppCompatDrawableManager.get();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatBackgroundHelper(View view) {
        this.f2608a = view;
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f2611d != null : i == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f2608a.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_android_background)) {
                this.f2610c = obtainStyledAttributes.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList a2 = this.f2609b.a(this.f2608a.getContext(), this.f2610c);
                if (a2 != null) {
                    a(a2);
                }
            }
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.setBackgroundTintList(this.f2608a, obtainStyledAttributes.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.setBackgroundTintMode(this.f2608a, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (this.f2612e == null) {
            this.f2612e = new TintInfo();
        }
        TintInfo tintInfo = this.f2612e;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        TintInfo tintInfo = this.f2612e;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        TintInfo tintInfo = this.f2612e;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    private boolean b(Drawable drawable) {
        if (this.f2613f == null) {
            this.f2613f = new TintInfo();
        }
        TintInfo tintInfo = this.f2613f;
        tintInfo.a();
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.f2608a);
        if (backgroundTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = backgroundTintList;
        }
        PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.f2608a);
        if (backgroundTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = backgroundTintMode;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            return false;
        }
        AppCompatDrawableManager.a(drawable, tintInfo, this.f2608a.getDrawableState());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.f2610c = i;
        AppCompatDrawableManager appCompatDrawableManager = this.f2609b;
        a(appCompatDrawableManager != null ? appCompatDrawableManager.a(this.f2608a.getContext(), i) : null);
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        this.f2610c = -1;
        a((ColorStateList) null);
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.f2612e == null) {
            this.f2612e = new TintInfo();
        }
        TintInfo tintInfo = this.f2612e;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Drawable background = this.f2608a.getBackground();
        if (background != null) {
            if (d() && b(background)) {
                return;
            }
            TintInfo tintInfo = this.f2612e;
            if (tintInfo != null) {
                AppCompatDrawableManager.a(background, tintInfo, this.f2608a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f2611d;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.a(background, tintInfo2, this.f2608a.getDrawableState());
            }
        }
    }

    void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2611d == null) {
                this.f2611d = new TintInfo();
            }
            TintInfo tintInfo = this.f2611d;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.f2611d = null;
        }
        a();
    }
}
