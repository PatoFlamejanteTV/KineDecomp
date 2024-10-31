package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a */
    private TypedValue f2716a;

    /* renamed from: b */
    private TypedValue f2717b;

    /* renamed from: c */
    private TypedValue f2718c;

    /* renamed from: d */
    private TypedValue f2719d;

    /* renamed from: e */
    private TypedValue f2720e;

    /* renamed from: f */
    private TypedValue f2721f;

    /* renamed from: g */
    private final Rect f2722g;

    /* renamed from: h */
    private OnAttachListener f2723h;

    /* loaded from: classes.dex */
    public interface OnAttachListener {
        void onAttachedFromWindow();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void dispatchFitSystemWindows(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f2720e == null) {
            this.f2720e = new TypedValue();
        }
        return this.f2720e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f2721f == null) {
            this.f2721f = new TypedValue();
        }
        return this.f2721f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f2718c == null) {
            this.f2718c = new TypedValue();
        }
        return this.f2718c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f2719d == null) {
            this.f2719d = new TypedValue();
        }
        return this.f2719d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f2716a == null) {
            this.f2716a = new TypedValue();
        }
        return this.f2716a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f2717b == null) {
            this.f2717b = new TypedValue();
        }
        return this.f2717b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener onAttachListener = this.f2723h;
        if (onAttachListener != null) {
            onAttachListener.onAttachedFromWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener onAttachListener = this.f2723h;
        if (onAttachListener != null) {
            onAttachListener.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b0  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
        this.f2723h = onAttachListener;
    }

    public void setDecorPadding(int i, int i2, int i3, int i4) {
        this.f2722g.set(i, i2, i3, i4);
        if (ViewCompat.isLaidOut(this)) {
            requestLayout();
        }
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2722g = new Rect();
    }
}
