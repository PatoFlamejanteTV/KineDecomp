package android.support.transition;

import android.support.transition.M;
import java.util.ArrayList;

/* compiled from: FragmentTransitionSupport.java */
/* renamed from: android.support.transition.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0214u implements M.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f649a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f650b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f651c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ArrayList f652d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Object f653e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ ArrayList f654f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ FragmentTransitionSupport f655g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0214u(FragmentTransitionSupport fragmentTransitionSupport, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.f655g = fragmentTransitionSupport;
        this.f649a = obj;
        this.f650b = arrayList;
        this.f651c = obj2;
        this.f652d = arrayList2;
        this.f653e = obj3;
        this.f654f = arrayList3;
    }

    @Override // android.support.transition.M.c
    public void a(M m) {
    }

    @Override // android.support.transition.M.c
    public void b(M m) {
    }

    @Override // android.support.transition.M.c
    public void c(M m) {
        Object obj = this.f649a;
        if (obj != null) {
            this.f655g.replaceTargets(obj, this.f650b, null);
        }
        Object obj2 = this.f651c;
        if (obj2 != null) {
            this.f655g.replaceTargets(obj2, this.f652d, null);
        }
        Object obj3 = this.f653e;
        if (obj3 != null) {
            this.f655g.replaceTargets(obj3, this.f654f, null);
        }
    }

    @Override // android.support.transition.M.c
    public void d(M m) {
    }
}
