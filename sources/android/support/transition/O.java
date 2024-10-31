package android.support.transition;

import android.support.transition.P;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;

/* compiled from: TransitionManager.java */
/* loaded from: classes.dex */
class O extends N {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayMap f550a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ P.a f551b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(P.a aVar, ArrayMap arrayMap) {
        this.f551b = aVar;
        this.f550a = arrayMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.transition.M.c
    public void d(M m) {
        ((ArrayList) this.f550a.get(this.f551b.f556b)).remove(m);
    }
}
