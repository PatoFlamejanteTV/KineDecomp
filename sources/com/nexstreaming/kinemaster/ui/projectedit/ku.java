package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Slider.java */
/* loaded from: classes.dex */
public class ku extends TextView {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Slider f4045a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ku(Slider slider, Context context) {
        super(context);
        this.f4045a = slider;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint;
        Paint paint2;
        Paint paint3;
        Paint paint4;
        int i;
        int i2;
        Paint paint5;
        Paint paint6;
        float b;
        int i3;
        int i4;
        float f;
        Paint paint7;
        Paint paint8;
        Paint paint9;
        int i5;
        int i6;
        Paint paint10;
        Paint paint11;
        Paint paint12;
        Paint paint13;
        Paint paint14;
        int color = getResources().getColor(R.color.slider_dark_value_tab_outside);
        int color2 = getResources().getColor(R.color.slider_dark_value_tab_inside);
        paint = this.f4045a.c;
        paint.reset();
        paint2 = this.f4045a.c;
        paint2.setFlags(1);
        paint3 = this.f4045a.c;
        paint3.setShader(new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, color, color2, Shader.TileMode.MIRROR));
        paint4 = this.f4045a.c;
        paint4.setStyle(Paint.Style.FILL);
        Path path = new Path();
        i = this.f4045a.f3744a;
        if (i != 1) {
            i2 = this.f4045a.f3744a;
            if (i2 == 0) {
                path.moveTo(0.0f, 0.0f);
                path.lineTo(getWidth(), 0.0f);
                path.lineTo(getWidth(), (getHeight() / 4) * 3);
                path.lineTo(getWidth() / 2, getHeight());
                path.lineTo(0.0f, (getHeight() / 4) * 3);
                paint5 = this.f4045a.c;
                canvas.drawPath(path, paint5);
            }
        } else {
            path.moveTo(0.0f, 0.0f);
            path.lineTo((getWidth() / 5) * 4, 0.0f);
            path.lineTo(getWidth(), getHeight() / 2);
            path.lineTo((getWidth() / 5) * 4, getHeight());
            path.lineTo(0.0f, getHeight());
            paint14 = this.f4045a.c;
            canvas.drawPath(path, paint14);
        }
        paint6 = this.f4045a.c;
        paint6.reset();
        b = this.f4045a.b(10.0f);
        i3 = this.f4045a.f3744a;
        if (i3 != 1) {
            i4 = this.f4045a.f3744a;
            if (i4 == 0) {
                b = getResources().getDimensionPixelSize(R.dimen.slider_valuetab_text_size_horizontal);
            }
        } else {
            b = getResources().getDimensionPixelSize(R.dimen.slider_valuetab_text_size_vertical);
        }
        Slider slider = this.f4045a;
        f = this.f4045a.f;
        String a2 = slider.a(f);
        while (b > 5.0f) {
            paint12 = this.f4045a.c;
            paint12.setTextSize(b);
            paint13 = this.f4045a.c;
            if (paint13.measureText(a2) < (getWidth() / 5) * 4) {
                break;
            } else {
                b = (float) (b - 0.5d);
            }
        }
        paint7 = this.f4045a.c;
        paint7.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        paint8 = this.f4045a.c;
        paint8.setColor(getResources().getColor(R.color.slider_dark_value_tab_text));
        Rect rect = new Rect();
        paint9 = this.f4045a.c;
        paint9.getTextBounds(a2, 0, a2.length(), rect);
        i5 = this.f4045a.f3744a;
        if (i5 != 1) {
            i6 = this.f4045a.f3744a;
            if (i6 == 0) {
                float width = ((getWidth() / 2) - (rect.width() / 2)) / 2;
                float height = (rect.height() + ((getHeight() / 4) * 3)) / 2;
                paint10 = this.f4045a.c;
                canvas.drawText(a2, width, height, paint10);
            }
        } else {
            float height2 = (rect.height() + getHeight()) / 2;
            paint11 = this.f4045a.c;
            canvas.drawText(a2, 0.0f, height2, paint11);
        }
        super.onDraw(canvas);
    }
}
