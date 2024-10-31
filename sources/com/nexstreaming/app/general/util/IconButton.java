package com.nexstreaming.app.general.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;

/* loaded from: classes2.dex */
public class IconButton extends AppCompatImageButton {

    /* renamed from: c */
    private ColorStateList f19825c;

    /* renamed from: d */
    private ColorStateList f19826d;

    /* renamed from: e */
    int f19827e;

    public IconButton(Context context) {
        super(context);
        this.f19827e = 0;
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        this.f19825c = getContext().getTheme().obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.IconButton, 0, 0).getColorStateList(0);
    }

    @Override // android.support.v7.widget.AppCompatImageButton, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f19825c;
        if (colorStateList != null) {
            drawable.setColorFilter(colorStateList.getColorForState(getDrawableState(), 0), PorterDuff.Mode.SRC_IN);
        } else {
            int i = this.f19827e;
            if (i != 0) {
                drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            }
        }
        ColorStateList colorStateList2 = this.f19826d;
        if (colorStateList2 != null) {
            setBackgroundColor(colorStateList2.getColorForState(getDrawableState(), 0));
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setBackgroundColorStateList(int i) {
        if (i == 0) {
            this.f19826d = null;
        } else {
            this.f19826d = getResources().getColorStateList(i);
        }
        ColorStateList colorStateList = this.f19826d;
        if (colorStateList != null) {
            setBackgroundColor(colorStateList.getColorForState(getDrawableState(), 0));
            invalidate();
        }
    }

    public void setIconColor(int i) {
        int i2;
        this.f19827e = i;
        this.f19825c = null;
        Drawable drawable = getDrawable();
        if (drawable != null && (i2 = this.f19827e) != 0) {
            drawable.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
        }
        invalidate();
    }

    public void setIconColorStateList(int i) {
        ColorStateList colorStateList;
        if (i == 0) {
            this.f19825c = null;
        } else {
            this.f19825c = getResources().getColorStateList(i);
        }
        Drawable drawable = getDrawable();
        if (drawable == null || (colorStateList = this.f19825c) == null) {
            return;
        }
        drawable.setColorFilter(colorStateList.getColorForState(getDrawableState(), 0), PorterDuff.Mode.SRC_IN);
        invalidate();
    }

    public IconButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19827e = 0;
        a(attributeSet);
    }

    public IconButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19827e = 0;
        a(attributeSet);
    }
}
