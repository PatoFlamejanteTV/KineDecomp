package com.nexstreaming.kinemaster.ui.store.controller;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetDetailFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.store.controller.wa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2286wa implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2290ya f23628a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2286wa(C2290ya c2290ya) {
        this.f23628a = c2290ya;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        progressBar = this.f23628a.q;
        progressBar.setVisibility(0);
        textView = this.f23628a.n;
        textView.setVisibility(4);
        textView2 = this.f23628a.o;
        textView2.setVisibility(4);
        progressBar2 = this.f23628a.q;
        progressBar2.setProgress(i);
        progressBar3 = this.f23628a.q;
        progressBar3.setMax(i2);
    }
}
