package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.persistentQueue.sqlite.SqliteJobQueue;

/* compiled from: DefaultQueueFactory.java */
/* loaded from: classes.dex */
public class m implements x {

    /* renamed from: a, reason: collision with root package name */
    SqliteJobQueue.b f8193a = new SqliteJobQueue.a();

    @Override // com.birbit.android.jobqueue.x
    public v a(com.birbit.android.jobqueue.c.b bVar, long j) {
        return new com.birbit.android.jobqueue.a.a(new com.birbit.android.jobqueue.e.b(bVar, j));
    }

    @Override // com.birbit.android.jobqueue.x
    public v b(com.birbit.android.jobqueue.c.b bVar, long j) {
        return new com.birbit.android.jobqueue.a.a(new SqliteJobQueue(bVar, j, this.f8193a));
    }
}
