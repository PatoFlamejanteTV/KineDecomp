package kotlin.text;

import java.util.Collection;
import java.util.Iterator;
import java.util.regex.MatchResult;
import kotlin.collections.AbstractC2531a;

/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class k extends AbstractC2531a<g> implements i {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f28567a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(l lVar) {
        this.f28567a = lVar;
    }

    public /* bridge */ boolean a(g gVar) {
        return super.contains(gVar);
    }

    @Override // kotlin.collections.AbstractC2531a, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj != null ? obj instanceof g : true) {
            return a((g) obj);
        }
        return false;
    }

    public g get(int i) {
        MatchResult b2;
        kotlin.c.d b3;
        MatchResult b4;
        b2 = this.f28567a.b();
        b3 = m.b(b2, i);
        if (b3.f().intValue() < 0) {
            return null;
        }
        b4 = this.f28567a.b();
        String group = b4.group(i);
        kotlin.jvm.internal.h.a((Object) group, "matchResult.group(index)");
        return new g(group, b3);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<g> iterator() {
        kotlin.c.d a2;
        kotlin.d.c a3;
        kotlin.d.c a4;
        a2 = kotlin.collections.k.a((Collection<?>) this);
        a3 = kotlin.collections.t.a((Iterable) a2);
        a4 = kotlin.d.i.a(a3, new kotlin.jvm.a.b<Integer, g>() { // from class: kotlin.text.MatcherMatchResult$groups$1$iterator$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.a.b
            public /* bridge */ /* synthetic */ g invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final g invoke(int i) {
                return k.this.get(i);
            }
        });
        return a4.iterator();
    }

    @Override // kotlin.collections.AbstractC2531a
    public int a() {
        MatchResult b2;
        b2 = this.f28567a.b();
        return b2.groupCount() + 1;
    }
}
