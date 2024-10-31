package com.nexstreaming.app.general.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.b;

/* loaded from: classes.dex */
public class IconView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private ColorStateList f3221a;
    private ColorStateList b;
    private int c;

    public IconView(Context context) {
        super(context);
        this.c = 0;
        a(null);
    }

    public IconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        a(attributeSet);
    }

    public IconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0;
        a(attributeSet);
    }

    @TargetApi(21)
    public IconView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.c = 0;
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            this.f3221a = getContext().getTheme().obtainStyledAttributes(attributeSet, b.a.IconView, 0, 0).getColorStateList(0);
        }
    }

    public void setIconColorStateList(int i) {
        if (i == 0) {
            this.f3221a = null;
        } else {
            this.f3221a = getResources().getColorStateList(i);
        }
    }

    public void setBackgroundColorStateList(int i) {
        if (i == 0) {
            this.b = null;
        } else {
            this.b = getResources().getColorStateList(i);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        if (this.f3221a != null) {
            Drawable drawable2 = getDrawable();
            if (drawable2 != null) {
                drawable2.setColorFilter(this.f3221a.getColorForState(getDrawableState(), 0), PorterDuff.Mode.SRC_IN);
            }
        } else if (this.c != 0 && (drawable = getDrawable()) != null) {
            drawable.setColorFilter(this.c, PorterDuff.Mode.SRC_IN);
        }
        if (this.b != null) {
            setBackgroundColor(this.b.getColorForState(getDrawableState(), 0));
        }
        super.onDraw(canvas);
    }

    public void setIconColor(int i) {
        this.c = i;
        this.f3221a = null;
        invalidate();
    }

    public int getIconColor() {
        return this.f3221a != null ? this.f3221a.getColorForState(getDrawableState(), 0) : this.c;
    }
}
