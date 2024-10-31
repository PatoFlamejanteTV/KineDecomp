package com.getbase.floatingactionbutton;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;

/* compiled from: FloatingActionButton.java */
/* loaded from: classes.dex */
public class c extends ShapeDrawable.ShaderFactory {

    /* renamed from: a */
    final /* synthetic */ int f9854a;

    /* renamed from: b */
    final /* synthetic */ int f9855b;

    /* renamed from: c */
    final /* synthetic */ int f9856c;

    /* renamed from: d */
    final /* synthetic */ int f9857d;

    /* renamed from: e */
    final /* synthetic */ int f9858e;

    /* renamed from: f */
    final /* synthetic */ FloatingActionButton f9859f;

    public c(FloatingActionButton floatingActionButton, int i, int i2, int i3, int i4, int i5) {
        this.f9859f = floatingActionButton;
        this.f9854a = i;
        this.f9855b = i2;
        this.f9856c = i3;
        this.f9857d = i4;
        this.f9858e = i5;
    }

    @Override // android.graphics.drawable.ShapeDrawable.ShaderFactory
    public Shader resize(int i, int i2) {
        float f2 = i / 2;
        return new LinearGradient(f2, 0.0f, f2, i2, new int[]{this.f9854a, this.f9855b, this.f9856c, this.f9857d, this.f9858e}, new float[]{0.0f, 0.2f, 0.5f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
    }
}
