package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.io.IOException;
import java.util.Iterator;

@GwtCompatible
/* loaded from: classes.dex */
public class Joiner {

    /* renamed from: a, reason: collision with root package name */
    private final String f2501a;

    /* loaded from: classes.dex */
    public static final class MapJoiner {
    }

    public static Joiner a(char c) {
        return new Joiner(String.valueOf(c));
    }

    private Joiner(String str) {
        this.f2501a = (String) Preconditions.a(str);
    }

    public <A extends Appendable> A a(A a2, Iterator<?> it) throws IOException {
        Preconditions.a(a2);
        if (it.hasNext()) {
            a2.append(a(it.next()));
            while (it.hasNext()) {
                a2.append(this.f2501a);
                a2.append(a(it.next()));
            }
        }
        return a2;
    }

    public final StringBuilder a(StringBuilder sb, Iterator<?> it) {
        try {
            a((Joiner) sb, it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final String a(Iterable<?> iterable) {
        return a(iterable.iterator());
    }

    public final String a(Iterator<?> it) {
        return a(new StringBuilder(), it).toString();
    }

    CharSequence a(Object obj) {
        Preconditions.a(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
