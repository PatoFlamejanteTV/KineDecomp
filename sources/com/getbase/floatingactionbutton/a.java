package com.getbase.floatingactionbutton;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AddFloatingActionButton.java */
/* loaded from: classes.dex */
public class a extends Shape {

    /* renamed from: a */
    final /* synthetic */ float f9849a;

    /* renamed from: b */
    final /* synthetic */ float f9850b;

    /* renamed from: c */
    final /* synthetic */ float f9851c;

    /* renamed from: d */
    final /* synthetic */ float f9852d;

    /* renamed from: e */
    final /* synthetic */ b f9853e;

    public a(b bVar, float f2, float f3, float f4, float f5) {
        this.f9853e = bVar;
        this.f9849a = f2;
        this.f9850b = f3;
        this.f9851c = f4;
        this.f9852d = f5;
    }

    @Override // android.graphics.drawable.shapes.Shape
    public void draw(Canvas canvas, Paint paint) {
        float f2 = this.f9849a;
        float f3 = this.f9850b;
        float f4 = this.f9851c;
        canvas.drawRect(f2, f3 - f4, this.f9852d - f2, f3 + f4, paint);
        float f5 = this.f9850b;
        float f6 = this.f9851c;
        float f7 = this.f9849a;
        canvas.drawRect(f5 - f6, f7, f5 + f6, this.f9852d - f7, paint);
    }
}
