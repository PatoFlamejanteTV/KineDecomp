package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.internal.widget.o;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements o {

    /* renamed from: a, reason: collision with root package name */
    private o.a f152a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(o.a aVar) {
        this.f152a = aVar;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (this.f152a != null) {
            this.f152a.a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
