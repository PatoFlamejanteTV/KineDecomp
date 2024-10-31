package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* compiled from: BaseTransientBottomBar.java */
/* renamed from: android.support.design.widget.h */
/* loaded from: classes.dex */
class C0182h extends FrameLayout {

    /* renamed from: a */
    private InterfaceC0181g f471a;

    /* renamed from: b */
    private InterfaceC0180f f472b;

    public C0182h(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        InterfaceC0180f interfaceC0180f = this.f472b;
        if (interfaceC0180f != null) {
            interfaceC0180f.onViewAttachedToWindow(this);
        }
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC0180f interfaceC0180f = this.f472b;
        if (interfaceC0180f != null) {
            interfaceC0180f.onViewDetachedFromWindow(this);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        InterfaceC0181g interfaceC0181g = this.f471a;
        if (interfaceC0181g != null) {
            interfaceC0181g.a(this, i, i2, i3, i4);
        }
    }

    void setOnAttachStateChangeListener(InterfaceC0180f interfaceC0180f) {
        this.f472b = interfaceC0180f;
    }

    void setOnLayoutChangeListener(InterfaceC0181g interfaceC0181g) {
        this.f471a = interfaceC0181g;
    }

    public C0182h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.d.i.SnackbarLayout);
        if (obtainStyledAttributes.hasValue(b.b.d.i.SnackbarLayout_elevation)) {
            ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(b.b.d.i.SnackbarLayout_elevation, 0));
        }
        obtainStyledAttributes.recycle();
        setClickable(true);
    }
}
