package kotlin.collections;

import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: _Collections.kt */
/* loaded from: classes3.dex */
public class t extends r {
    public static final <T, C extends Collection<? super T>> C a(Iterable<? extends T> iterable, C c2) {
        kotlin.jvm.internal.h.b(iterable, "$this$toCollection");
        kotlin.jvm.internal.h.b(c2, ShareConstants.DESTINATION);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }

    public static final <T> T b(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.h.b(iterable, "$this$first");
        if (iterable instanceof List) {
            return (T) d((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T c(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.h.b(iterable, "$this$single");
        if (iterable instanceof List) {
            return (T) e((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                throw new IllegalArgumentException("Collection has more than one element.");
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T d(List<? extends T> list) {
        kotlin.jvm.internal.h.b(list, "$this$first");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T e(List<? extends T> list) {
        kotlin.jvm.internal.h.b(list, "$this$single");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static final <T> List<T> f(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.h.b(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return b((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        a(iterable, arrayList);
        return arrayList;
    }

    public static final <T, A extends Appendable> A a(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.h.b(iterable, "$this$joinTo");
        kotlin.jvm.internal.h.b(a2, "buffer");
        kotlin.jvm.internal.h.b(charSequence, "separator");
        kotlin.jvm.internal.h.b(charSequence2, "prefix");
        kotlin.jvm.internal.h.b(charSequence3, "postfix");
        kotlin.jvm.internal.h.b(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : iterable) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            kotlin.text.s.a(a2, t, bVar);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static int d(Iterable<Integer> iterable) {
        kotlin.jvm.internal.h.b(iterable, "$this$sum");
        Iterator<Integer> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().intValue();
        }
        return i;
    }

    public static <T> List<T> e(Iterable<? extends T> iterable) {
        List<T> a2;
        List<T> a3;
        kotlin.jvm.internal.h.b(iterable, "$this$toList");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                a2 = k.a();
                return a2;
            }
            if (size != 1) {
                return b(collection);
            }
            a3 = j.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            return a3;
        }
        return k.b(f(iterable));
    }

    public static <T> List<T> b(Iterable<? extends T> iterable, int i) {
        List<T> a2;
        List<T> e2;
        List<T> a3;
        kotlin.jvm.internal.h.b(iterable, "$this$take");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            a3 = k.a();
            return a3;
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                e2 = e(iterable);
                return e2;
            }
            if (i == 1) {
                a2 = j.a(b(iterable));
                return a2;
            }
        }
        ArrayList arrayList = new ArrayList(i);
        for (T t : iterable) {
            int i3 = i2 + 1;
            if (i2 == i) {
                break;
            }
            arrayList.add(t);
            i2 = i3;
        }
        return k.b(arrayList);
    }

    public static /* synthetic */ String a(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b bVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            bVar = null;
        }
        return a(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, bVar);
    }

    public static final <T> String a(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.h.b(iterable, "$this$joinToString");
        kotlin.jvm.internal.h.b(charSequence, "separator");
        kotlin.jvm.internal.h.b(charSequence2, "prefix");
        kotlin.jvm.internal.h.b(charSequence3, "postfix");
        kotlin.jvm.internal.h.b(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        a(iterable, sb, charSequence, charSequence2, charSequence3, i, charSequence4, bVar);
        String sb2 = sb.toString();
        kotlin.jvm.internal.h.a((Object) sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static <T> kotlin.d.c<T> a(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.h.b(iterable, "$this$asSequence");
        return new s(iterable);
    }

    public static final <T> List<T> b(Collection<? extends T> collection) {
        kotlin.jvm.internal.h.b(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }
}
