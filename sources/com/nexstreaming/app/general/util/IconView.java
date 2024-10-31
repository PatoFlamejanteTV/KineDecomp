package com.nexstreaming.app.general.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class IconView extends ImageView {

    /* renamed from: a */
    private ColorStateList f19828a;

    /* renamed from: b */
    private ColorStateList f19829b;

    /* renamed from: c */
    private int f19830c;

    public IconView(Context context) {
        super(context);
        this.f19830c = 0;
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.IconView, 0, 0);
        this.f19828a = obtainStyledAttributes.getColorStateList(0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f19828a;
        if (colorStateList != null) {
            drawable.setColorFilter(colorStateList.getColorForState(getDrawableState(), 0), PorterDuff.Mode.SRC_IN);
        } else {
            int i = this.f19830c;
            if (i != 0) {
                drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            }
        }
        ColorStateList colorStateList2 = this.f19829b;
        if (colorStateList2 != null) {
            setBackgroundColor(colorStateList2.getColorForState(getDrawableState(), 0));
        }
        invalidate();
    }

    public int getIconColor() {
        ColorStateList colorStateList = this.f19828a;
        if (colorStateList != null) {
            return colorStateList.getColorForState(getDrawableState(), 0);
        }
        return this.f19830c;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setBackgroundColorStateList(int i) {
        if (i == 0) {
            this.f19829b = null;
        } else {
            this.f19829b = getResources().getColorStateList(i);
        }
        ColorStateList colorStateList = this.f19829b;
        if (colorStateList != null) {
            setBackgroundColor(colorStateList.getColorForState(getDrawableState(), 0));
            invalidate();
        }
    }

    public void setIconColor(int i) {
        int i2;
        this.f19830c = i;
        this.f19828a = null;
        Drawable drawable = getDrawable();
        if (drawable != null && (i2 = this.f19830c) != 0) {
            drawable.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
        }
        invalidate();
    }

    public void setIconColorStateList(int i) {
        ColorStateList colorStateList;
        if (i == 0) {
            this.f19828a = null;
        } else {
            this.f19828a = getResources().getColorStateList(i);
        }
        Drawable drawable = getDrawable();
        if (drawable == null || (colorStateList = this.f19828a) == null) {
            return;
        }
        drawable.setColorFilter(colorStateList.getColorForState(getDrawableState(), 0), PorterDuff.Mode.SRC_IN);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        refreshDrawableState();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        refreshDrawableState();
    }

    public IconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19830c = 0;
        a(attributeSet);
    }

    public IconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19830c = 0;
        a(attributeSet);
    }

    @TargetApi(21)
    public IconView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f19830c = 0;
    }
}
