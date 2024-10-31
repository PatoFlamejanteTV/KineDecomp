package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* loaded from: classes.dex */
public class AppCompatButton extends Button implements TintableBackgroundView, AutoSizeableTextView {

    /* renamed from: a, reason: collision with root package name */
    private final AppCompatBackgroundHelper f2614a;

    /* renamed from: b, reason: collision with root package name */
    private final AppCompatTextHelper f2615b;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2614a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a();
        }
        AppCompatTextHelper appCompatTextHelper = this.f2615b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.a();
        }
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public int getAutoSizeMaxTextSize() {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeMaxTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.f2615b;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.c();
        }
        return -1;
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public int getAutoSizeMinTextSize() {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeMinTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.f2615b;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.d();
        }
        return -1;
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public int getAutoSizeStepGranularity() {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeStepGranularity();
        }
        AppCompatTextHelper appCompatTextHelper = this.f2615b;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.e();
        }
        return -1;
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeTextAvailableSizes();
        }
        AppCompatTextHelper appCompatTextHelper = this.f2615b;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.f();
        }
        return new int[0];
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public int getAutoSizeTextType() {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        AppCompatTextHelper appCompatTextHelper = this.f2615b;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.g();
        }
        return 0;
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2614a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.b();
        }
        return null;
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2614a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        AppCompatTextHelper appCompatTextHelper = this.f2615b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.a(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        AppCompatTextHelper appCompatTextHelper = this.f2615b;
        if (appCompatTextHelper == null || AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE || !appCompatTextHelper.h()) {
            return;
        }
        this.f2615b.b();
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f2615b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f2615b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.a(iArr, i);
        }
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f2615b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2614a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2614a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a(i);
        }
    }

    public void setSupportAllCaps(boolean z) {
        AppCompatTextHelper appCompatTextHelper = this.f2615b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.a(z);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2614a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b(colorStateList);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2614a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        AppCompatTextHelper appCompatTextHelper = this.f2615b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.a(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f2) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setTextSize(i, f2);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f2615b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.a(i, f2);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        this.f2614a = new AppCompatBackgroundHelper(this);
        this.f2614a.a(attributeSet, i);
        this.f2615b = AppCompatTextHelper.a(this);
        this.f2615b.a(attributeSet, i);
        this.f2615b.a();
    }
}