package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.zza;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
public class a<T> implements zzf<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zza f1201a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(zza zzaVar) {
        this.f1201a = zzaVar;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    @Override // com.google.android.gms.dynamic.zzf
    public void a(LifecycleDelegate lifecycleDelegate) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LifecycleDelegate lifecycleDelegate2;
        this.f1201a.f1208a = lifecycleDelegate;
        linkedList = this.f1201a.c;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            zza.a aVar = (zza.a) it.next();
            lifecycleDelegate2 = this.f1201a.f1208a;
            aVar.a(lifecycleDelegate2);
        }
        linkedList2 = this.f1201a.c;
        linkedList2.clear();
        this.f1201a.b = null;
    }
}
