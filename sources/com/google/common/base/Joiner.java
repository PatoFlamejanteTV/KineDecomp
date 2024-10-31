package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckReturnValue;

@GwtCompatible
/* loaded from: classes.dex */
public class Joiner {

    /* renamed from: a, reason: collision with root package name */
    private final String f2580a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ Joiner(Joiner joiner, p pVar) {
        this(joiner);
    }

    public static Joiner a(String str) {
        return new Joiner(str);
    }

    public static Joiner a(char c) {
        return new Joiner(String.valueOf(c));
    }

    private Joiner(String str) {
        this.f2580a = (String) Preconditions.a(str);
    }

    private Joiner(Joiner joiner) {
        this.f2580a = joiner.f2580a;
    }

    public <A extends Appendable> A a(A a2, Iterator<?> it) throws IOException {
        Preconditions.a(a2);
        if (it.hasNext()) {
            a2.append(a(it.next()));
            while (it.hasNext()) {
                a2.append(this.f2580a);
                a2.append(a(it.next()));
            }
        }
        return a2;
    }

    public final StringBuilder a(StringBuilder sb, Iterable<?> iterable) {
        return a(sb, iterable.iterator());
    }

    public final StringBuilder a(StringBuilder sb, Iterator<?> it) {
        try {
            a((Joiner) sb, it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final StringBuilder a(StringBuilder sb, Object[] objArr) {
        return a(sb, Arrays.asList(objArr));
    }

    public final String a(Iterable<?> iterable) {
        return a(iterable.iterator());
    }

    public final String a(Iterator<?> it) {
        return a(new StringBuilder(), it).toString();
    }

    public final String a(Object[] objArr) {
        return a((Iterable<?>) Arrays.asList(objArr));
    }

    @CheckReturnValue
    public Joiner b(String str) {
        Preconditions.a(str);
        return new p(this, this, str);
    }

    @CheckReturnValue
    public MapJoiner c(String str) {
        return new MapJoiner(this, str, null);
    }

    /* loaded from: classes2.dex */
    public static final class MapJoiner {

        /* renamed from: a, reason: collision with root package name */
        private final Joiner f2581a;
        private final String b;

        /* synthetic */ MapJoiner(Joiner joiner, String str, p pVar) {
            this(joiner, str);
        }

        private MapJoiner(Joiner joiner, String str) {
            this.f2581a = joiner;
            this.b = (String) Preconditions.a(str);
        }

        public StringBuilder a(StringBuilder sb, Map<?, ?> map) {
            return a(sb, map.entrySet());
        }

        @Beta
        public <A extends Appendable> A a(A a2, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
            Preconditions.a(a2);
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                a2.append(this.f2581a.a(next.getKey()));
                a2.append(this.b);
                a2.append(this.f2581a.a(next.getValue()));
                while (it.hasNext()) {
                    a2.append(this.f2581a.f2580a);
                    Map.Entry<?, ?> next2 = it.next();
                    a2.append(this.f2581a.a(next2.getKey()));
                    a2.append(this.b);
                    a2.append(this.f2581a.a(next2.getValue()));
                }
            }
            return a2;
        }

        @Beta
        public StringBuilder a(StringBuilder sb, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return a(sb, iterable.iterator());
        }

        @Beta
        public StringBuilder a(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                a((MapJoiner) sb, it);
                return sb;
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence a(Object obj) {
        Preconditions.a(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
