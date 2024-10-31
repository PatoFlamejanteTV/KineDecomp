package com.birbit.android.jobqueue.e;

import com.birbit.android.jobqueue.p;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SimpleInMemoryPriorityQueue.java */
/* loaded from: classes.dex */
public class a implements Comparator<p> {

    /* renamed from: a */
    final /* synthetic */ b f8138a;

    public a(b bVar) {
        this.f8138a = bVar;
    }

    private int a(int i, int i2) {
        if (i > i2) {
            return -1;
        }
        return i2 > i ? 1 : 0;
    }

    private int a(long j, long j2) {
        if (j > j2) {
            return -1;
        }
        return j2 > j ? 1 : 0;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(p pVar, p pVar2) {
        if (pVar.g().getId().equals(pVar2.g().getId())) {
            return 0;
        }
        int a2 = a(pVar.h(), pVar2.h());
        if (a2 != 0) {
            return a2;
        }
        int i = -a(pVar.a(), pVar2.a());
        return i != 0 ? i : -a(pVar.f().longValue(), pVar2.f().longValue());
    }
}
