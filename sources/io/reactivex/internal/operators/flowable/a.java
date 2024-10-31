package io.reactivex.internal.operators.flowable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractFlowableWithUpstream.java */
/* loaded from: classes3.dex */
public abstract class a<T, R> extends io.reactivex.e<R> implements io.reactivex.d.b.h<T> {

    /* renamed from: b, reason: collision with root package name */
    protected final io.reactivex.e<T> f28211b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(io.reactivex.e<T> eVar) {
        io.reactivex.d.a.b.a(eVar, "source is null");
        this.f28211b = eVar;
    }
}
