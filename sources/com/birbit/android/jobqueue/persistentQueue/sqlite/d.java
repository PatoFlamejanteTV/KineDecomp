package com.birbit.android.jobqueue.persistentQueue.sqlite;

import android.support.v4.util.LruCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WhereQueryCache.java */
/* loaded from: classes.dex */
public class d extends LruCache<Long, c> {

    /* renamed from: a */
    final /* synthetic */ e f8299a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, int i) {
        super(i);
        this.f8299a = eVar;
    }

    @Override // android.support.v4.util.LruCache
    /* renamed from: a */
    public void entryRemoved(boolean z, Long l, c cVar, c cVar2) {
        cVar.a();
    }
}
