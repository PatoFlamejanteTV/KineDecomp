package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class m {
    public static final j b(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new l(matcher, charSequence);
        }
        return null;
    }

    public static final j b(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new l(matcher, charSequence);
        }
        return null;
    }

    public static final kotlin.c.d b(MatchResult matchResult) {
        kotlin.c.d d2;
        d2 = kotlin.c.h.d(matchResult.start(), matchResult.end());
        return d2;
    }

    public static final kotlin.c.d b(MatchResult matchResult, int i) {
        kotlin.c.d d2;
        d2 = kotlin.c.h.d(matchResult.start(i), matchResult.end(i));
        return d2;
    }

    public static final int b(Iterable<? extends f> iterable) {
        Iterator<? extends f> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i |= it.next().getValue();
        }
        return i;
    }
}
