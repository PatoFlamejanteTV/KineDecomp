package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

@GwtCompatible
/* loaded from: classes2.dex */
public class Joiner {

    /* renamed from: a */
    private final String f15091a;

    /* loaded from: classes2.dex */
    public static final class MapJoiner {

        /* renamed from: a */
        private final Joiner f15092a;

        /* renamed from: b */
        private final String f15093b;

        /* synthetic */ MapJoiner(Joiner joiner, String str, f fVar) {
            this(joiner, str);
        }

        @CanIgnoreReturnValue
        public StringBuilder a(StringBuilder sb, Map<?, ?> map) {
            return a(sb, map.entrySet());
        }

        private MapJoiner(Joiner joiner, String str) {
            this.f15092a = joiner;
            Preconditions.a(str);
            this.f15093b = str;
        }

        @CanIgnoreReturnValue
        @Beta
        public <A extends Appendable> A a(A a2, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
            Preconditions.a(a2);
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                a2.append(this.f15092a.a(next.getKey()));
                a2.append(this.f15093b);
                a2.append(this.f15092a.a(next.getValue()));
                while (it.hasNext()) {
                    a2.append(this.f15092a.f15091a);
                    Map.Entry<?, ?> next2 = it.next();
                    a2.append(this.f15092a.a(next2.getKey()));
                    a2.append(this.f15093b);
                    a2.append(this.f15092a.a(next2.getValue()));
                }
            }
            return a2;
        }

        @CanIgnoreReturnValue
        @Beta
        public StringBuilder a(StringBuilder sb, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return a(sb, iterable.iterator());
        }

        @CanIgnoreReturnValue
        @Beta
        public StringBuilder a(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                a((MapJoiner) sb, it);
                return sb;
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public /* synthetic */ Joiner(Joiner joiner, f fVar) {
        this(joiner);
    }

    public Joiner b(String str) {
        Preconditions.a(str);
        return new f(this, this, str);
    }

    public MapJoiner c(String str) {
        return new MapJoiner(this, str, null);
    }

    private Joiner(String str) {
        Preconditions.a(str);
        this.f15091a = str;
    }

    public static Joiner a(String str) {
        return new Joiner(str);
    }

    public static Joiner a(char c2) {
        return new Joiner(String.valueOf(c2));
    }

    private Joiner(Joiner joiner) {
        this.f15091a = joiner.f15091a;
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A a(A a2, Iterator<?> it) throws IOException {
        Preconditions.a(a2);
        if (it.hasNext()) {
            a2.append(a(it.next()));
            while (it.hasNext()) {
                a2.append(this.f15091a);
                a2.append(a(it.next()));
            }
        }
        return a2;
    }

    @CanIgnoreReturnValue
    public final StringBuilder a(StringBuilder sb, Iterable<?> iterable) {
        return a(sb, iterable.iterator());
    }

    @CanIgnoreReturnValue
    public final StringBuilder a(StringBuilder sb, Iterator<?> it) {
        try {
            a((Joiner) sb, it);
            return sb;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
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

    public CharSequence a(Object obj) {
        Preconditions.a(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
