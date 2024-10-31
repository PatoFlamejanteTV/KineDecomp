package kotlinx.coroutines;

import kotlin.coroutines.e;
import kotlinx.coroutines.fa;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
public final class r extends kotlin.coroutines.a implements fa<String> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f28674b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private final long f28675c;

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes3.dex */
    public static final class a implements e.c<r> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public r(long j) {
        super(f28674b);
        this.f28675c = j;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof r) {
                if (this.f28675c == ((r) obj).f28675c) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.e
    public <R> R fold(R r, kotlin.jvm.a.c<? super R, ? super e.b, ? extends R> cVar) {
        kotlin.jvm.internal.h.b(cVar, "operation");
        return (R) fa.a.a(this, r, cVar);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.e.b, kotlin.coroutines.e
    public <E extends e.b> E get(e.c<E> cVar) {
        kotlin.jvm.internal.h.b(cVar, "key");
        return (E) fa.a.a(this, cVar);
    }

    public int hashCode() {
        long j = this.f28675c;
        return (int) (j ^ (j >>> 32));
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.e
    public kotlin.coroutines.e minusKey(e.c<?> cVar) {
        kotlin.jvm.internal.h.b(cVar, "key");
        return fa.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.e
    public kotlin.coroutines.e plus(kotlin.coroutines.e eVar) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        return fa.a.a(this, eVar);
    }

    public String toString() {
        return "CoroutineId(" + this.f28675c + ')';
    }

    public final long u() {
        return this.f28675c;
    }

    @Override // kotlinx.coroutines.fa
    public String a(kotlin.coroutines.e eVar) {
        String str;
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        C2549s c2549s = (C2549s) eVar.get(C2549s.f28676b);
        if (c2549s == null || (str = c2549s.u()) == null) {
            str = "coroutine";
        }
        Thread currentThread = Thread.currentThread();
        kotlin.jvm.internal.h.a((Object) currentThread, "currentThread");
        String name = currentThread.getName();
        kotlin.jvm.internal.h.a((Object) name, "oldName");
        int b2 = kotlin.text.n.b(name, " @", 0, false, 6, null);
        if (b2 < 0) {
            b2 = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + b2 + 10);
        String substring = name.substring(0, b2);
        kotlin.jvm.internal.h.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(" @");
        sb.append(str);
        sb.append('#');
        sb.append(this.f28675c);
        String sb2 = sb.toString();
        kotlin.jvm.internal.h.a((Object) sb2, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb2);
        return name;
    }

    @Override // kotlinx.coroutines.fa
    public void a(kotlin.coroutines.e eVar, String str) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(str, "oldState");
        Thread currentThread = Thread.currentThread();
        kotlin.jvm.internal.h.a((Object) currentThread, "Thread.currentThread()");
        currentThread.setName(str);
    }
}
