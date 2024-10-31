package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppCompatCompoundButtonHelper {

    /* renamed from: a */
    private final CompoundButton f2619a;

    /* renamed from: b */
    private ColorStateList f2620b = null;

    /* renamed from: c */
    private PorterDuff.Mode f2621c = null;

    /* renamed from: d */
    private boolean f2622d = false;

    /* renamed from: e */
    private boolean f2623e = false;

    /* renamed from: f */
    private boolean f2624f;

    /* loaded from: classes.dex */
    interface DirectSetButtonDrawableInterface {
        void setButtonDrawable(Drawable drawable);
    }

    public AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.f2619a = compoundButton;
    }

    public void a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f2619a.getContext().obtainStyledAttributes(attributeSet, R.styleable.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_android_button) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.CompoundButton_android_button, 0)) != 0) {
                this.f2619a.setButtonDrawable(AppCompatResources.getDrawable(this.f2619a.getContext(), resourceId));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
                CompoundButtonCompat.setButtonTintList(this.f2619a, obtainStyledAttributes.getColorStateList(R.styleable.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
                CompoundButtonCompat.setButtonTintMode(this.f2619a, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public ColorStateList b() {
        return this.f2620b;
    }

    public PorterDuff.Mode c() {
        return this.f2621c;
    }

    public void d() {
        if (this.f2624f) {
            this.f2624f = false;
        } else {
            this.f2624f = true;
            a();
        }
    }

    public void a(ColorStateList colorStateList) {
        this.f2620b = colorStateList;
        this.f2622d = true;
        a();
    }

    public void a(PorterDuff.Mode mode) {
        this.f2621c = mode;
        this.f2623e = true;
        a();
    }

    void a() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.f2619a);
        if (buttonDrawable != null) {
            if (this.f2622d || this.f2623e) {
                Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
                if (this.f2622d) {
                    DrawableCompat.setTintList(mutate, this.f2620b);
                }
                if (this.f2623e) {
                    DrawableCompat.setTintMode(mutate, this.f2621c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f2619a.getDrawableState());
                }
                this.f2619a.setButtonDrawable(mutate);
            }
        }
    }

    public int a(int i) {
        Drawable buttonDrawable;
        return (Build.VERSION.SDK_INT >= 17 || (buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.f2619a)) == null) ? i : i + buttonDrawable.getIntrinsicWidth();
    }
}
