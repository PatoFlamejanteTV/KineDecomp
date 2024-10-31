package com.nexstreaming.kinemaster.ui.projectgallery;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class cg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cf f4187a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(cf cfVar) {
        this.f4187a = cfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        x xVar;
        ImageView imageView;
        View b;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        View view;
        int[] iArr4;
        int[] iArr5;
        int[] iArr6;
        xVar = this.f4187a.b.b.g;
        Bitmap a2 = xVar.a(this.f4187a.b.b, this.f4187a.f4186a);
        imageView = this.f4187a.b.b.n;
        imageView.setImageBitmap(a2);
        b = this.f4187a.b.b.b(this.f4187a.f4186a);
        iArr = this.f4187a.b.b.o;
        b.getLocationOnScreen(iArr);
        iArr2 = this.f4187a.b.b.o;
        int i = iArr2[0];
        iArr3 = this.f4187a.b.b.o;
        int i2 = iArr3[1];
        float width = b.getWidth();
        float height = b.getHeight();
        view = this.f4187a.b.b.j;
        iArr4 = this.f4187a.b.b.o;
        view.getLocationOnScreen(iArr4);
        iArr5 = this.f4187a.b.b.o;
        int i3 = iArr5[0];
        iArr6 = this.f4187a.b.b.o;
        int i4 = iArr6[1];
        float width2 = a2.getWidth();
        this.f4187a.b.b.u = i - i3;
        this.f4187a.b.b.v = i2 - i4;
        this.f4187a.b.b.w = width / width2;
        this.f4187a.b.b.x = height / a2.getHeight();
    }
}
