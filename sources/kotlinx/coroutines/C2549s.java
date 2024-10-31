package kotlinx.coroutines;

import kotlin.coroutines.e;

/* compiled from: CoroutineName.kt */
/* renamed from: kotlinx.coroutines.s */
/* loaded from: classes3.dex */
public final class C2549s extends kotlin.coroutines.a {

    /* renamed from: b */
    public static final a f28676b = new a(null);

    /* renamed from: c */
    private final String f28677c;

    /* compiled from: CoroutineName.kt */
    /* renamed from: kotlinx.coroutines.s$a */
    /* loaded from: classes3.dex */
    public static final class a implements e.c<C2549s> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof C2549s) && kotlin.jvm.internal.h.a((Object) this.f28677c, (Object) ((C2549s) obj).f28677c);
        }
        return true;
    }

    public int hashCode() {
        String str = this.f28677c;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CoroutineName(" + this.f28677c + ')';
    }

    public final String u() {
        return this.f28677c;
    }
}
