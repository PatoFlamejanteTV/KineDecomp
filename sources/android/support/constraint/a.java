package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;

/* compiled from: Barrier.java */
/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: g */
    private int f179g;

    /* renamed from: h */
    private int f180h;
    private android.support.constraint.solver.widgets.b i;

    public a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.support.constraint.b
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.i = new android.support.constraint.solver.widgets.b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == h.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == h.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.i.c(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f184d = this.i;
        a();
    }

    public int getType() {
        return this.f179g;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.i.c(z);
    }

    public void setType(int i) {
        this.f179g = i;
        this.f180h = i;
        if (Build.VERSION.SDK_INT < 17) {
            int i2 = this.f179g;
            if (i2 == 5) {
                this.f180h = 0;
            } else if (i2 == 6) {
                this.f180h = 1;
            }
        } else {
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                int i3 = this.f179g;
                if (i3 == 5) {
                    this.f180h = 1;
                } else if (i3 == 6) {
                    this.f180h = 0;
                }
            } else {
                int i4 = this.f179g;
                if (i4 == 5) {
                    this.f180h = 0;
                } else if (i4 == 6) {
                    this.f180h = 1;
                }
            }
        }
        this.i.t(this.f180h);
    }
}
