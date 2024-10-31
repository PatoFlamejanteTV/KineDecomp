package kotlin.text;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class l implements j {

    /* renamed from: a */
    private final h f28568a;

    /* renamed from: b */
    private final Matcher f28569b;

    /* renamed from: c */
    private final CharSequence f28570c;

    public l(Matcher matcher, CharSequence charSequence) {
        kotlin.jvm.internal.h.b(matcher, "matcher");
        kotlin.jvm.internal.h.b(charSequence, "input");
        this.f28569b = matcher;
        this.f28570c = charSequence;
        this.f28568a = new k(this);
    }

    public final MatchResult b() {
        return this.f28569b;
    }

    @Override // kotlin.text.j
    public j next() {
        j b2;
        int end = b().end() + (b().end() == b().start() ? 1 : 0);
        if (end > this.f28570c.length()) {
            return null;
        }
        Matcher matcher = this.f28569b.pattern().matcher(this.f28570c);
        kotlin.jvm.internal.h.a((Object) matcher, "matcher.pattern().matcher(input)");
        b2 = m.b(matcher, end, this.f28570c);
        return b2;
    }

    @Override // kotlin.text.j
    public kotlin.c.d a() {
        kotlin.c.d b2;
        b2 = m.b(b());
        return b2;
    }
}
