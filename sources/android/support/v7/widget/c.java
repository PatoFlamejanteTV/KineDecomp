package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a;
import android.support.v7.internal.widget.aa;
import android.support.v7.internal.widget.ab;
import android.support.v7.internal.widget.ac;
import android.support.v7.internal.widget.z;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

/* compiled from: AppCompatAutoCompleteTextView.java */
/* loaded from: classes.dex */
public class c extends AutoCompleteTextView {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f213a = {R.attr.background, R.attr.popupBackground};
    private aa b;
    private aa c;
    private ab d;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0016a.autoCompleteTextViewStyle);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(z.a(context), attributeSet, i);
        ColorStateList c;
        if (ab.f162a) {
            ac a2 = ac.a(getContext(), attributeSet, f213a, i, 0);
            this.d = a2.c();
            if (a2.d(0) && (c = a2.c().c(a2.f(0, -1))) != null) {
                setInternalBackgroundTint(c);
            }
            if (a2.d(1)) {
                setDropDownBackgroundDrawable(a2.a(1));
            }
            a2.b();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        setInternalBackgroundTint(this.d != null ? this.d.c(i) : null);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        setInternalBackgroundTint(null);
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(this.d.a(i));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new aa();
        }
        this.c.f161a = colorStateList;
        this.c.d = true;
        a();
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.c != null) {
            return this.c.f161a;
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new aa();
        }
        this.c.b = mode;
        this.c.c = true;
        a();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.c != null) {
            return this.c.b;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        a();
    }

    private void a() {
        if (getBackground() != null) {
            if (this.c != null) {
                ab.a(this, this.c);
            } else if (this.b != null) {
                ab.a(this, this.b);
            }
        }
    }

    private void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.b == null) {
                this.b = new aa();
            }
            this.b.f161a = colorStateList;
            this.b.d = true;
        } else {
            this.b = null;
        }
        a();
    }
}
