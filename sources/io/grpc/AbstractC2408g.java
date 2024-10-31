package io.grpc;

import javax.annotation.Nullable;

/* compiled from: ClientCall.java */
/* renamed from: io.grpc.g */
/* loaded from: classes3.dex */
public abstract class AbstractC2408g<ReqT, RespT> {

    /* compiled from: ClientCall.java */
    /* renamed from: io.grpc.g$a */
    /* loaded from: classes3.dex */
    public static abstract class a<T> {
        public void a() {
        }

        public void a(P p) {
        }

        public void a(Status status, P p) {
        }

        public void a(T t) {
        }
    }

    public abstract void a();

    public abstract void a(int i);

    public abstract void a(a<RespT> aVar, P p);

    public abstract void a(ReqT reqt);

    public abstract void a(@Nullable String str, @Nullable Throwable th);
}
