package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.internal.widget.o;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements o {

    /* renamed from: a, reason: collision with root package name */
    private o.a f153a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(o.a aVar) {
        this.f153a = aVar;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (this.f153a != null) {
            this.f153a.a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
