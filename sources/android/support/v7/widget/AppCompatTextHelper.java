package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v7.appcompat.R;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class AppCompatTextHelper {

    /* renamed from: a, reason: collision with root package name */
    final TextView f2675a;

    /* renamed from: b, reason: collision with root package name */
    private TintInfo f2676b;

    /* renamed from: c, reason: collision with root package name */
    private TintInfo f2677c;

    /* renamed from: d, reason: collision with root package name */
    private TintInfo f2678d;

    /* renamed from: e, reason: collision with root package name */
    private TintInfo f2679e;

    /* renamed from: f, reason: collision with root package name */
    private final AppCompatTextViewAutoSizeHelper f2680f;

    /* renamed from: g, reason: collision with root package name */
    private int f2681g = 0;

    /* renamed from: h, reason: collision with root package name */
    private Typeface f2682h;
    private boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatTextHelper(TextView textView) {
        this.f2675a = textView;
        this.f2680f = new AppCompatTextViewAutoSizeHelper(this.f2675a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f2680f.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f2680f.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f2680f.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f2680f.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] f() {
        return this.f2680f.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f2680f.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.f2680f.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AppCompatTextHelper a(TextView textView) {
        if (Build.VERSION.SDK_INT >= 17) {
            return new AppCompatTextHelperV17(textView);
        }
        return new AppCompatTextHelper(textView);
    }

    private void b(int i, float f2) {
        this.f2680f.a(i, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public void a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        boolean z;
        boolean z2;
        Context context = this.f2675a.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.AppCompatTextHelper, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.f2676b = a(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.f2677c = a(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.f2678d = a(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.f2679e = a(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        obtainStyledAttributes.recycle();
        boolean z3 = this.f2675a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z4 = true;
        if (resourceId != -1) {
            TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, resourceId, R.styleable.TextAppearance);
            if (z3 || !obtainStyledAttributes2.hasValue(R.styleable.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = obtainStyledAttributes2.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
                z = true;
            }
            a(context, obtainStyledAttributes2);
            if (Build.VERSION.SDK_INT < 23) {
                ColorStateList colorStateList3 = obtainStyledAttributes2.hasValue(R.styleable.TextAppearance_android_textColor) ? obtainStyledAttributes2.getColorStateList(R.styleable.TextAppearance_android_textColor) : null;
                colorStateList2 = obtainStyledAttributes2.hasValue(R.styleable.TextAppearance_android_textColorHint) ? obtainStyledAttributes2.getColorStateList(R.styleable.TextAppearance_android_textColorHint) : null;
                ColorStateList colorStateList4 = colorStateList3;
                colorStateList = obtainStyledAttributes2.hasValue(R.styleable.TextAppearance_android_textColorLink) ? obtainStyledAttributes2.getColorStateList(R.styleable.TextAppearance_android_textColorLink) : null;
                r7 = colorStateList4;
            } else {
                colorStateList = null;
                colorStateList2 = null;
            }
            obtainStyledAttributes2.recycle();
        } else {
            colorStateList = null;
            colorStateList2 = null;
            z = false;
            z2 = false;
        }
        TintTypedArray obtainStyledAttributes3 = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TextAppearance, i, 0);
        if (z3 || !obtainStyledAttributes3.hasValue(R.styleable.TextAppearance_textAllCaps)) {
            z4 = z;
        } else {
            z2 = obtainStyledAttributes3.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (obtainStyledAttributes3.hasValue(R.styleable.TextAppearance_android_textColor)) {
                r7 = obtainStyledAttributes3.getColorStateList(R.styleable.TextAppearance_android_textColor);
            }
            if (obtainStyledAttributes3.hasValue(R.styleable.TextAppearance_android_textColorHint)) {
                colorStateList2 = obtainStyledAttributes3.getColorStateList(R.styleable.TextAppearance_android_textColorHint);
            }
            if (obtainStyledAttributes3.hasValue(R.styleable.TextAppearance_android_textColorLink)) {
                colorStateList = obtainStyledAttributes3.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
            }
        }
        a(context, obtainStyledAttributes3);
        obtainStyledAttributes3.recycle();
        if (r7 != null) {
            this.f2675a.setTextColor(r7);
        }
        if (colorStateList2 != null) {
            this.f2675a.setHintTextColor(colorStateList2);
        }
        if (colorStateList != null) {
            this.f2675a.setLinkTextColor(colorStateList);
        }
        if (!z3 && z4) {
            a(z2);
        }
        Typeface typeface = this.f2682h;
        if (typeface != null) {
            this.f2675a.setTypeface(typeface, this.f2681g);
        }
        this.f2680f.a(attributeSet, i);
        if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE || this.f2680f.f() == 0) {
            return;
        }
        int[] e2 = this.f2680f.e();
        if (e2.length > 0) {
            if (this.f2675a.getAutoSizeStepGranularity() != -1.0f) {
                this.f2675a.setAutoSizeTextTypeUniformWithConfiguration(this.f2680f.c(), this.f2680f.b(), this.f2680f.d(), 0);
            } else {
                this.f2675a.setAutoSizeTextTypeUniformWithPresetSizes(e2, 0);
            }
        }
    }

    private void a(Context context, TintTypedArray tintTypedArray) {
        String string;
        this.f2681g = tintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.f2681g);
        if (!tintTypedArray.hasValue(R.styleable.TextAppearance_android_fontFamily) && !tintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
            if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_typeface)) {
                this.i = false;
                int i = tintTypedArray.getInt(R.styleable.TextAppearance_android_typeface, 1);
                if (i == 1) {
                    this.f2682h = Typeface.SANS_SERIF;
                    return;
                } else if (i == 2) {
                    this.f2682h = Typeface.SERIF;
                    return;
                } else {
                    if (i != 3) {
                        return;
                    }
                    this.f2682h = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f2682h = null;
        int i2 = tintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily) ? R.styleable.TextAppearance_fontFamily : R.styleable.TextAppearance_android_fontFamily;
        if (!context.isRestricted()) {
            final WeakReference weakReference = new WeakReference(this.f2675a);
            try {
                this.f2682h = tintTypedArray.getFont(i2, this.f2681g, new ResourcesCompat.FontCallback() { // from class: android.support.v7.widget.AppCompatTextHelper.1
                    @Override // android.support.v4.content.res.ResourcesCompat.FontCallback
                    public void onFontRetrievalFailed(int i3) {
                    }

                    @Override // android.support.v4.content.res.ResourcesCompat.FontCallback
                    public void onFontRetrieved(Typeface typeface) {
                        AppCompatTextHelper.this.a((WeakReference<TextView>) weakReference, typeface);
                    }
                });
                this.i = this.f2682h == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f2682h != null || (string = tintTypedArray.getString(i2)) == null) {
            return;
        }
        this.f2682h = Typeface.create(string, this.f2681g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.i) {
            this.f2682h = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f2681g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, int i) {
        ColorStateList colorStateList;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i, R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_textAllCaps)) {
            a(obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColor) && (colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor)) != null) {
            this.f2675a.setTextColor(colorStateList);
        }
        a(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        Typeface typeface = this.f2682h;
        if (typeface != null) {
            this.f2675a.setTypeface(typeface, this.f2681g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f2675a.setAllCaps(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.f2676b == null && this.f2677c == null && this.f2678d == null && this.f2679e == null) {
            return;
        }
        Drawable[] compoundDrawables = this.f2675a.getCompoundDrawables();
        a(compoundDrawables[0], this.f2676b);
        a(compoundDrawables[1], this.f2677c);
        a(compoundDrawables[2], this.f2678d);
        a(compoundDrawables[3], this.f2679e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Drawable drawable, TintInfo tintInfo) {
        if (drawable == null || tintInfo == null) {
            return;
        }
        AppCompatDrawableManager.a(drawable, tintInfo, this.f2675a.getDrawableState());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static TintInfo a(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList a2 = appCompatDrawableManager.a(context, i);
        if (a2 == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = a2;
        return tintInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, int i, int i2, int i3, int i4) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            return;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, float f2) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE || h()) {
            return;
        }
        b(i, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.f2680f.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        this.f2680f.a(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int[] iArr, int i) throws IllegalArgumentException {
        this.f2680f.a(iArr, i);
    }
}
