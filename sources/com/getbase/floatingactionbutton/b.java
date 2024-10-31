package com.getbase.floatingactionbutton;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;

/* compiled from: AddFloatingActionButton.java */
/* loaded from: classes.dex */
public class b extends FloatingActionButton {
    int m;

    public b(Context context) {
        this(context, null);
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionButton
    public void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.AddFloatingActionButton, 0, 0);
        this.m = obtainStyledAttributes.getColor(j.AddFloatingActionButton_fab_plusIconColor, a(R.color.white));
        obtainStyledAttributes.recycle();
        super.a(context, attributeSet);
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionButton
    public Drawable getIconDrawable() {
        float b2 = b(g.fab_icon_size);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new a(this, (b2 - b(g.fab_plus_icon_size)) / 2.0f, b2 / 2.0f, b(g.fab_plus_icon_stroke) / 2.0f, b2));
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(this.m);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        return shapeDrawable;
    }

    public int getPlusColor() {
        return this.m;
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionButton
    public void setIcon(int i) {
        throw new UnsupportedOperationException("Use FloatingActionButton if you want to use custom icon");
    }

    public void setPlusColor(int i) {
        if (this.m != i) {
            this.m = i;
            a();
        }
    }

    public void setPlusColorResId(int i) {
        setPlusColor(a(i));
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
