package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private TypedValue f151a;
    private TypedValue b;
    private TypedValue c;
    private TypedValue d;
    private TypedValue e;
    private TypedValue f;
    private final Rect g;

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new Rect();
    }

    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e5  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r13, int r14) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public TypedValue getMinWidthMajor() {
        if (this.f151a == null) {
            this.f151a = new TypedValue();
        }
        return this.f151a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.b == null) {
            this.b = new TypedValue();
        }
        return this.b;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return this.c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.d == null) {
            this.d = new TypedValue();
        }
        return this.d;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        return this.e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f == null) {
            this.f = new TypedValue();
        }
        return this.f;
    }
}
