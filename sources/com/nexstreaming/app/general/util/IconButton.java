package com.nexstreaming.app.general.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.nexstreaming.app.kinemasterfree.b;

/* loaded from: classes.dex */
public class IconButton extends ImageButton {

    /* renamed from: a, reason: collision with root package name */
    int f3220a;
    private ColorStateList b;
    private ColorStateList c;

    public IconButton(Context context) {
        super(context);
        this.f3220a = 0;
        a(null);
    }

    public IconButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3220a = 0;
        a(attributeSet);
    }

    public IconButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3220a = 0;
        a(attributeSet);
    }

    @TargetApi(21)
    public IconButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3220a = 0;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            this.b = getContext().getTheme().obtainStyledAttributes(attributeSet, b.a.IconButton, 0, 0).getColorStateList(0);
        }
    }

    public void setIconColorStateList(int i) {
        if (i == 0) {
            this.b = null;
        } else {
            this.b = getResources().getColorStateList(i);
        }
    }

    public void setBackgroundColorStateList(int i) {
        if (i == 0) {
            this.c = null;
        } else {
            this.c = getResources().getColorStateList(i);
        }
    }

    public void setIconColor(int i) {
        this.f3220a = i;
        this.b = null;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        if (this.b != null) {
            Drawable drawable2 = getDrawable();
            if (drawable2 != null) {
                drawable2.setColorFilter(this.b.getColorForState(getDrawableState(), 0), PorterDuff.Mode.SRC_IN);
            }
        } else if (this.f3220a != 0 && (drawable = getDrawable()) != null) {
            drawable.setColorFilter(this.f3220a, PorterDuff.Mode.SRC_IN);
        }
        if (this.c != null) {
            setBackgroundColor(this.c.getColorForState(getDrawableState(), 0));
        }
        super.onDraw(canvas);
    }
}
