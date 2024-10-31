package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.FXGripDrawingView;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: FXGripDrawingView.java */
/* renamed from: com.nexstreaming.kinemaster.ui.widget.c */
/* loaded from: classes2.dex */
public class C2295c extends View {

    /* renamed from: a */
    final /* synthetic */ int f23855a;

    /* renamed from: b */
    final /* synthetic */ FXGripDrawingView f23856b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2295c(FXGripDrawingView fXGripDrawingView, Context context, int i) {
        super(context);
        this.f23856b = fXGripDrawingView;
        this.f23855a = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        FXGripDrawingView.GripType gripType;
        FXGripDrawingView.GripType gripType2;
        String str;
        int i6;
        int i7;
        int i8;
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        i = this.f23856b.s;
        path.lineTo(i, 0.0f);
        i2 = this.f23856b.s;
        path.lineTo(i2, this.f23855a / 2);
        i3 = this.f23856b.s;
        path.lineTo((i3 / 5) * 3, this.f23855a / 2);
        i4 = this.f23856b.s;
        path.lineTo(i4 / 2, (this.f23855a / 5) * 4);
        i5 = this.f23856b.s;
        path.lineTo((i5 / 5) * 2, this.f23855a / 2);
        path.lineTo(0.0f, this.f23855a / 2);
        paint.setColor(-1);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        canvas.drawPath(path, paint);
        gripType = this.f23856b.i;
        if (gripType != FXGripDrawingView.GripType.START) {
            gripType2 = this.f23856b.i;
            if (gripType2 == FXGripDrawingView.GripType.END) {
                Resources resources = getResources();
                i6 = this.f23856b.f23751b;
                str = resources.getString(R.string.video_drag_fxend, EditorGlobal.a(i6));
            } else {
                str = "";
            }
        } else {
            Resources resources2 = getResources();
            i8 = this.f23856b.f23750a;
            str = resources2.getString(R.string.video_drag_fxstart, EditorGlobal.a(i8));
        }
        paint.reset();
        paint.setFlags(1);
        paint.setTextSize(getResources().getDimensionPixelSize(R.dimen.custom_drag_text_size));
        paint.setColor(getResources().getColor(R.color.custom_drag_text_color));
        int i9 = this.f23855a / 2;
        paint.getTextBounds(str, 0, str.length(), new Rect());
        i7 = this.f23856b.s;
        canvas.drawText(str, (i7 / 2) - (r3.right / 2), i9 + (r3.top / 2), paint);
        super.onDraw(canvas);
    }
}
