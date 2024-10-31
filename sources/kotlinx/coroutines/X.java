package kotlinx.coroutines;

import kotlinx.coroutines.internal.k;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes3.dex */
public final class X extends k.a {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ kotlinx.coroutines.internal.k f28609d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ W f28610e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Object f28611f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(kotlinx.coroutines.internal.k kVar, kotlinx.coroutines.internal.k kVar2, W w, Object obj) {
        super(kVar2);
        this.f28609d = kVar;
        this.f28610e = w;
        this.f28611f = obj;
    }

    @Override // kotlinx.coroutines.internal.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object b(kotlinx.coroutines.internal.k kVar) {
        kotlin.jvm.internal.h.b(kVar, "affected");
        if (this.f28610e.g() == this.f28611f) {
            return null;
        }
        return kotlinx.coroutines.internal.j.a();
    }
}
