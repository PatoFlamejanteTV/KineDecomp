package io.reactivex.internal.operators.flowable;

/* loaded from: classes3.dex */
public enum FlowableInternalHelper$RequestMax implements io.reactivex.c.e<g.b.c> {
    INSTANCE;

    @Override // io.reactivex.c.e
    public void accept(g.b.c cVar) throws Exception {
        cVar.request(Long.MAX_VALUE);
    }
}
