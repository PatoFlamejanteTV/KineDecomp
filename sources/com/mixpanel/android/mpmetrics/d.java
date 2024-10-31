package com.mixpanel.android.mpmetrics;

import android.app.Activity;
import com.mixpanel.android.mpmetrics.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundCapture.java */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f3027a;
    final /* synthetic */ c.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Activity activity, c.b bVar) {
        this.f3027a = activity;
        this.b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        new c.a(this.f3027a, this.b).execute(new Void[0]);
    }
}
