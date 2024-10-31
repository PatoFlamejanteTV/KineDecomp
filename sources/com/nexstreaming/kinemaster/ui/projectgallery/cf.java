package com.nexstreaming.kinemaster.ui.projectgallery;

import android.widget.GridView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class cf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4186a;
    final /* synthetic */ ce b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(ce ceVar, int i) {
        this.b = ceVar;
        this.f4186a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        GridView gridView2;
        gridView = this.b.b.e;
        gridView.setSelection(this.f4186a);
        gridView2 = this.b.b.e;
        gridView2.post(new cg(this));
    }
}
