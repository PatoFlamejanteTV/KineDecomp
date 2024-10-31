package kotlin.coroutines.intrinsics;

import kotlin.TypeCastException;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes3.dex */
public class b {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> kotlin.coroutines.b<k> a(final kotlin.jvm.a.b<? super kotlin.coroutines.b<? super T>, ? extends Object> bVar, final kotlin.coroutines.b<? super T> bVar2) {
        h.b(bVar, "$this$createCoroutineUnintercepted");
        h.b(bVar2, "completion");
        e.a(bVar2);
        if (bVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) bVar).create(bVar2);
        }
        final kotlin.coroutines.e context = bVar2.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            if (bVar2 != null) {
                return new RestrictedContinuationImpl(bVar2) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
                    private int label;

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    protected Object invokeSuspend(Object obj) {
                        int i = this.label;
                        if (i != 0) {
                            if (i == 1) {
                                this.label = 2;
                                kotlin.h.a(obj);
                                return obj;
                            }
                            throw new IllegalStateException("This coroutine had already completed");
                        }
                        this.label = 1;
                        kotlin.h.a(obj);
                        kotlin.jvm.a.b bVar3 = bVar;
                        if (bVar3 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        }
                        m.a(bVar3, 1);
                        return bVar3.invoke(this);
                    }
                };
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        if (bVar2 != null) {
            return new ContinuationImpl(bVar2, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            this.label = 2;
                            kotlin.h.a(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed");
                    }
                    this.label = 1;
                    kotlin.h.a(obj);
                    kotlin.jvm.a.b bVar3 = bVar;
                    if (bVar3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                    }
                    m.a(bVar3, 1);
                    return bVar3.invoke(this);
                }
            };
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> kotlin.coroutines.b<k> a(final kotlin.jvm.a.c<? super R, ? super kotlin.coroutines.b<? super T>, ? extends Object> cVar, final R r, final kotlin.coroutines.b<? super T> bVar) {
        h.b(cVar, "$this$createCoroutineUnintercepted");
        h.b(bVar, "completion");
        e.a(bVar);
        if (cVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) cVar).create(r, bVar);
        }
        final kotlin.coroutines.e context = bVar.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            if (bVar != null) {
                return new RestrictedContinuationImpl(bVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
                    private int label;

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    protected Object invokeSuspend(Object obj) {
                        int i = this.label;
                        if (i != 0) {
                            if (i == 1) {
                                this.label = 2;
                                kotlin.h.a(obj);
                                return obj;
                            }
                            throw new IllegalStateException("This coroutine had already completed");
                        }
                        this.label = 1;
                        kotlin.h.a(obj);
                        kotlin.jvm.a.c cVar2 = cVar;
                        if (cVar2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        }
                        m.a(cVar2, 2);
                        return cVar2.invoke(r, this);
                    }
                };
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        if (bVar != null) {
            return new ContinuationImpl(bVar, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            this.label = 2;
                            kotlin.h.a(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed");
                    }
                    this.label = 1;
                    kotlin.h.a(obj);
                    kotlin.jvm.a.c cVar2 = cVar;
                    if (cVar2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                    }
                    m.a(cVar2, 2);
                    return cVar2.invoke(r, this);
                }
            };
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> kotlin.coroutines.b<T> a(kotlin.coroutines.b<? super T> bVar) {
        kotlin.coroutines.b<T> bVar2;
        h.b(bVar, "$this$intercepted");
        ContinuationImpl continuationImpl = !(bVar instanceof ContinuationImpl) ? null : bVar;
        return (continuationImpl == null || (bVar2 = (kotlin.coroutines.b<T>) continuationImpl.intercepted()) == null) ? bVar : bVar2;
    }
}
