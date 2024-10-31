package com.google.android.gms.measurement;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzc f2016a;
    final /* synthetic */ zzg b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(zzg zzgVar, zzc zzcVar) {
        this.b = zzgVar;
        this.f2016a = zzcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        this.f2016a.h().a(this.f2016a);
        list = this.b.c;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzh) it.next()).a(this.f2016a);
        }
        this.b.b(this.f2016a);
    }
}
