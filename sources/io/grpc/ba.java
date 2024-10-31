package io.grpc;

import io.grpc.ca;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServiceProviders.java */
/* loaded from: classes3.dex */
public class ba<T> implements Comparator<T> {

    /* renamed from: a */
    final /* synthetic */ ca.a f27171a;

    public ba(ca.a aVar) {
        this.f27171a = aVar;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        return this.f27171a.b(t) - this.f27171a.b(t2);
    }
}
