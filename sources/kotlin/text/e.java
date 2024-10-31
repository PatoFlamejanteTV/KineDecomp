package kotlin.text;

import java.util.Iterator;
import kotlin.Pair;

/* compiled from: Strings.kt */
/* loaded from: classes3.dex */
public final class e implements kotlin.d.c<kotlin.c.d> {

    /* renamed from: a */
    private final CharSequence f28561a;

    /* renamed from: b */
    private final int f28562b;

    /* renamed from: c */
    private final int f28563c;

    /* renamed from: d */
    private final kotlin.jvm.a.c<CharSequence, Integer, Pair<Integer, Integer>> f28564d;

    /* JADX WARN: Multi-variable type inference failed */
    public e(CharSequence charSequence, int i, int i2, kotlin.jvm.a.c<? super CharSequence, ? super Integer, Pair<Integer, Integer>> cVar) {
        kotlin.jvm.internal.h.b(charSequence, "input");
        kotlin.jvm.internal.h.b(cVar, "getNextMatch");
        this.f28561a = charSequence;
        this.f28562b = i;
        this.f28563c = i2;
        this.f28564d = cVar;
    }

    @Override // kotlin.d.c
    public Iterator<kotlin.c.d> iterator() {
        return new d(this);
    }
}
