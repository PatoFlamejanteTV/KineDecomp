package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.InterfaceC0179e;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.b.d.d;
import b.b.d.i;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements InterfaceC0179e {

    /* renamed from: a */
    private TextView f301a;

    /* renamed from: b */
    private Button f302b;

    /* renamed from: c */
    private int f303c;

    /* renamed from: d */
    private int f304d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    private boolean a(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.f301a.getPaddingTop() == i2 && this.f301a.getPaddingBottom() == i3) {
            return z;
        }
        a(this.f301a, i2, i3);
        return true;
    }

    public Button getActionView() {
        return this.f302b;
    }

    public TextView getMessageView() {
        return this.f301a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f301a = (TextView) findViewById(d.snackbar_text);
        this.f302b = (Button) findViewById(d.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:            if (a(1, r0, r0 - r1) != false) goto L56;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:            r4 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:            if (a(0, r0, r0) != false) goto L56;     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.f303c
            if (r0 <= 0) goto L18
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.f303c
            if (r0 <= r1) goto L18
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L18:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = b.b.d.b.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = b.b.d.b.design_snackbar_padding_vertical
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f301a
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L3c
            r2 = 1
            goto L3d
        L3c:
            r2 = 0
        L3d:
            if (r2 == 0) goto L56
            int r5 = r7.f304d
            if (r5 <= 0) goto L56
            android.widget.Button r5 = r7.f302b
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f304d
            if (r5 <= r6) goto L56
            int r1 = r0 - r1
            boolean r0 = r7.a(r4, r0, r1)
            if (r0 == 0) goto L61
            goto L62
        L56:
            if (r2 == 0) goto L59
            goto L5a
        L59:
            r0 = r1
        L5a:
            boolean r0 = r7.a(r3, r0, r0)
            if (r0 == 0) goto L61
            goto L62
        L61:
            r4 = 0
        L62:
            if (r4 == 0) goto L67
            super.onMeasure(r8, r9)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.internal.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.SnackbarLayout);
        this.f303c = obtainStyledAttributes.getDimensionPixelSize(i.SnackbarLayout_android_maxWidth, -1);
        this.f304d = obtainStyledAttributes.getDimensionPixelSize(i.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    private static void a(View view, int i, int i2) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i, ViewCompat.getPaddingEnd(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }
}
