package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class zzip {

    /* loaded from: classes.dex */
    public interface zza<D, R> {
        R zze(D d);
    }

    public static <A, B> zziq<B> zza(zziq<A> zziqVar, zza<A, B> zzaVar) {
        zzin zzinVar = new zzin();
        zziqVar.zzc(new ec(zzinVar, zzaVar, zziqVar));
        return zzinVar;
    }

    public static <V> zziq<List<V>> zzh(List<zziq<V>> list) {
        zzin zzinVar = new zzin();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<zziq<V>> it = list.iterator();
        while (it.hasNext()) {
            it.next().zzc(new ed(atomicInteger, size, zzinVar, list));
        }
        return zzinVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <V> List<V> zzi(List<zziq<V>> list) throws ExecutionException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        Iterator<zziq<V>> it = list.iterator();
        while (it.hasNext()) {
            V v = it.next().get();
            if (v != null) {
                arrayList.add(v);
            }
        }
        return arrayList;
    }
}
