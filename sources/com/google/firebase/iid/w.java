package com.google.firebase.iid;

import android.content.Intent;

/* loaded from: classes2.dex */
final class w implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Intent f17392a;

    /* renamed from: b */
    private final /* synthetic */ Intent f17393b;

    /* renamed from: c */
    private final /* synthetic */ zzb f17394c;

    public w(zzb zzbVar, Intent intent, Intent intent2) {
        this.f17394c = zzbVar;
        this.f17392a = intent;
        this.f17393b = intent2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17394c.c(this.f17392a);
        this.f17394c.d(this.f17393b);
    }
}
