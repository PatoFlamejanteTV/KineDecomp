package com.nexstreaming.kinemaster.ui.projectgallery;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.jb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC2122jb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f22940a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2125kb f22941b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2122jb(C2125kb c2125kb, int i) {
        this.f22941b = c2125kb;
        this.f22940a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView recyclerView;
        Eb eb;
        ImageView imageView;
        RecyclerView recyclerView2;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        View view;
        int[] iArr4;
        int[] iArr5;
        int[] iArr6;
        recyclerView = this.f22941b.f22947b.sa;
        recyclerView.scrollToPosition(this.f22940a);
        eb = this.f22941b.f22947b.ua;
        Bitmap a2 = eb.a(this.f22941b.f22947b, this.f22940a);
        com.bumptech.glide.h<Drawable> a3 = com.bumptech.glide.c.a((FragmentActivity) this.f22941b.f22947b).a(a2);
        imageView = this.f22941b.f22947b.ga;
        a3.a(imageView);
        recyclerView2 = this.f22941b.f22947b.sa;
        View findViewByPosition = recyclerView2.getLayoutManager().findViewByPosition(this.f22940a);
        iArr = this.f22941b.f22947b.P;
        findViewByPosition.getLocationOnScreen(iArr);
        iArr2 = this.f22941b.f22947b.P;
        int i = iArr2[0];
        iArr3 = this.f22941b.f22947b.P;
        int i2 = iArr3[1];
        float width = findViewByPosition.getWidth();
        float height = findViewByPosition.getHeight();
        view = this.f22941b.f22947b.Y;
        iArr4 = this.f22941b.f22947b.P;
        view.getLocationOnScreen(iArr4);
        iArr5 = this.f22941b.f22947b.P;
        int i3 = iArr5[0];
        iArr6 = this.f22941b.f22947b.P;
        int i4 = iArr6[1];
        float width2 = a2.getWidth();
        this.f22941b.f22947b.R = i - i3;
        this.f22941b.f22947b.S = i2 - i4;
        this.f22941b.f22947b.T = width / width2;
        this.f22941b.f22947b.U = height / a2.getHeight();
    }
}
