package kotlin.d;

import kotlin.text.s;

/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
public class i extends h {
    public static <T, R> c<R> a(c<? extends T> cVar, kotlin.jvm.a.b<? super T, ? extends R> bVar) {
        kotlin.jvm.internal.h.b(cVar, "$this$map");
        kotlin.jvm.internal.h.b(bVar, "transform");
        return new k(cVar, bVar);
    }

    public static final <T, A extends Appendable> A a(c<? extends T> cVar, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.h.b(cVar, "$this$joinTo");
        kotlin.jvm.internal.h.b(a2, "buffer");
        kotlin.jvm.internal.h.b(charSequence, "separator");
        kotlin.jvm.internal.h.b(charSequence2, "prefix");
        kotlin.jvm.internal.h.b(charSequence3, "postfix");
        kotlin.jvm.internal.h.b(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : cVar) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            s.a(a2, t, bVar);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(c cVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b bVar, int i2, Object obj) {
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
        return a(cVar, charSequence, charSequence5, charSequence6, i3, charSequence7, bVar);
    }

    public static final <T> String a(c<? extends T> cVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.h.b(cVar, "$this$joinToString");
        kotlin.jvm.internal.h.b(charSequence, "separator");
        kotlin.jvm.internal.h.b(charSequence2, "prefix");
        kotlin.jvm.internal.h.b(charSequence3, "postfix");
        kotlin.jvm.internal.h.b(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        a(cVar, sb, charSequence, charSequence2, charSequence3, i, charSequence4, bVar);
        String sb2 = sb.toString();
        kotlin.jvm.internal.h.a((Object) sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }
}
