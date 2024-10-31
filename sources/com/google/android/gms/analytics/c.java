package com.google.android.gms.analytics;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzg f10341a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzk f10342b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(zzk zzkVar, zzg zzgVar) {
        this.f10342b = zzkVar;
        this.f10341a = zzgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        this.f10341a.h().a(this.f10341a);
        list = this.f10342b.f10376c;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzn) it.next()).a(this.f10341a);
        }
        zzk zzkVar = this.f10342b;
        zzk.b(this.f10341a);
    }
}
