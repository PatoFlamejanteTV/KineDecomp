package com.google.firebase.inappmessaging.display.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class ResizableImageView extends AppCompatImageView {

    /* renamed from: c */
    private int f17560c;

    /* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        final int f17561a;

        /* renamed from: b */
        final int f17562b;

        /* synthetic */ a(int i, int i2, f fVar) {
            this(i, i2);
        }

        private a(int i, int i2) {
            this.f17561a = i;
            this.f17562b = i2;
        }
    }

    public ResizableImageView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f17560c = (int) (context.getResources().getDisplayMetrics().density * 160.0f);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (Build.VERSION.SDK_INT > 16) {
            Drawable drawable = getDrawable();
            boolean adjustViewBounds = getAdjustViewBounds();
            if (drawable == null || !adjustViewBounds) {
                return;
            }
            a(drawable);
            a();
        }
    }

    public ResizableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a() {
        int max = Math.max(getMinimumWidth(), getSuggestedMinimumWidth());
        int max2 = Math.max(getMinimumHeight(), getSuggestedMinimumHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f2 = max;
        float f3 = max2;
        Logging.a("Image: min width, height", f2, f3);
        float f4 = measuredWidth;
        float f5 = measuredHeight;
        Logging.a("Image: actual width, height", f4, f5);
        float f6 = measuredWidth < max ? f2 / f4 : 1.0f;
        float f7 = measuredHeight < max2 ? f3 / f5 : 1.0f;
        if (f6 <= f7) {
            f6 = f7;
        }
        if (f6 > 1.0d) {
            int ceil = (int) Math.ceil(f4 * f6);
            int ceil2 = (int) Math.ceil(f5 * f6);
            Logging.a("Measured dimension (" + measuredWidth + FragmentC2201x.f23219a + measuredHeight + ") too small.  Resizing to " + ceil + FragmentC2201x.f23219a + ceil2);
            a a2 = a(ceil, ceil2);
            setMeasuredDimension(a2.f17561a, a2.f17562b);
        }
    }

    public ResizableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Drawable drawable) {
        Logging.a("Image: intrinsic width, height", drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        a a2 = a((int) Math.ceil((r0 * this.f17560c) / 160), (int) Math.ceil((r5 * this.f17560c) / 160));
        Logging.a("Image: new target dimensions", a2.f17561a, a2.f17562b);
        setMeasuredDimension(a2.f17561a, a2.f17562b);
    }

    private a a(int i, int i2) {
        int maxWidth = getMaxWidth();
        int maxHeight = getMaxHeight();
        if (i > maxWidth) {
            Logging.a("Image: capping width", maxWidth);
            i2 = (i2 * maxWidth) / i;
            i = maxWidth;
        }
        if (i2 > maxHeight) {
            Logging.a("Image: capping height", maxHeight);
            i = (i * maxHeight) / i2;
            i2 = maxHeight;
        }
        return new a(i, i2);
    }
}
