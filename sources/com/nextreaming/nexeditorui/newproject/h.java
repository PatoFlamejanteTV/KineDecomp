package com.nextreaming.nexeditorui.newproject;

import android.widget.HorizontalScrollView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewProjectActivity.java */
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HorizontalScrollView f4689a;
    final /* synthetic */ NewProjectActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NewProjectActivity newProjectActivity, HorizontalScrollView horizontalScrollView) {
        this.b = newProjectActivity;
        this.f4689a = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4689a.fullScroll(66);
    }
}
