package kotlin.text;

import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
/* loaded from: classes.dex */
public class w extends v {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, String> b(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Object obj;
        Object obj2;
        if (!z && collection.size() == 1) {
            String str = (String) kotlin.collections.i.c(collection);
            int a2 = !z2 ? a(charSequence, str, i, false, 4, (Object) null) : n.b(charSequence, str, i, false, 4, null);
            if (a2 < 0) {
                return null;
            }
            return kotlin.i.a(Integer.valueOf(a2), str);
        }
        kotlin.c.b dVar = !z2 ? new kotlin.c.d(kotlin.c.e.a(i, 0), charSequence.length()) : kotlin.c.e.c(kotlin.c.e.b(i, a(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = dVar.getFirst();
            int last = dVar.getLast();
            int a3 = dVar.a();
            if (a3 < 0 ? first >= last : first <= last) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (v.a(str2, 0, (String) charSequence, first, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (first == last) {
                            break;
                        }
                        first += a3;
                    } else {
                        return kotlin.i.a(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = dVar.getFirst();
            int last2 = dVar.getLast();
            int a4 = dVar.a();
            if (a4 < 0 ? first2 >= last2 : first2 <= last2) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (a(str4, 0, charSequence, first2, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += a4;
                    } else {
                        return kotlin.i.a(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static final int a(CharSequence charSequence) {
        kotlin.jvm.internal.h.b(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final String a(CharSequence charSequence, kotlin.c.d dVar) {
        kotlin.jvm.internal.h.b(charSequence, "$this$substring");
        kotlin.jvm.internal.h.b(dVar, "range");
        return charSequence.subSequence(dVar.f().intValue(), dVar.e().intValue() + 1).toString();
    }

    public static final boolean a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        kotlin.jvm.internal.h.b(charSequence, "$this$regionMatchesImpl");
        kotlin.jvm.internal.h.b(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!b.a(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final int a(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        kotlin.jvm.internal.h.b(charSequence, "$this$indexOfAny");
        kotlin.jvm.internal.h.b(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kotlin.collections.c.a(cArr), i);
        }
        int a2 = kotlin.c.e.a(i, 0);
        int a3 = a(charSequence);
        if (a2 > a3) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(a2);
            int length = cArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                }
                if (b.a(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return a2;
            }
            if (a2 == a3) {
                return -1;
            }
            a2++;
        }
    }

    static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        kotlin.c.b c2;
        if (!z2) {
            c2 = new kotlin.c.d(kotlin.c.e.a(i, 0), kotlin.c.e.b(i2, charSequence.length()));
        } else {
            c2 = kotlin.c.e.c(kotlin.c.e.b(i, a(charSequence)), kotlin.c.e.a(i2, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = c2.getFirst();
            int last = c2.getLast();
            int a2 = c2.a();
            if (a2 >= 0) {
                if (first > last) {
                    return -1;
                }
            } else if (first < last) {
                return -1;
            }
            while (!v.a((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z)) {
                if (first == last) {
                    return -1;
                }
                first += a2;
            }
            return first;
        }
        int first2 = c2.getFirst();
        int last2 = c2.getLast();
        int a3 = c2.a();
        if (a3 >= 0) {
            if (first2 > last2) {
                return -1;
            }
        } else if (first2 < last2) {
            return -1;
        }
        while (!a(charSequence2, 0, charSequence, first2, charSequence2.length(), z)) {
            if (first2 == last2) {
                return -1;
            }
            first2 += a3;
        }
        return first2;
    }

    public static /* synthetic */ int b(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = a(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return b(charSequence, str, i, z);
    }

    public static final int b(CharSequence charSequence, String str, int i, boolean z) {
        kotlin.jvm.internal.h.b(charSequence, "$this$lastIndexOf");
        kotlin.jvm.internal.h.b(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i);
        }
        return a(charSequence, (CharSequence) str, i, 0, z, true);
    }

    public static CharSequence b(CharSequence charSequence) {
        kotlin.jvm.internal.h.b(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean a2 = a.a(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!a2) {
                    break;
                }
                length--;
            } else if (a2) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(charSequence, c2, i, z);
    }

    public static final int a(CharSequence charSequence, char c2, int i, boolean z) {
        kotlin.jvm.internal.h.b(charSequence, "$this$indexOf");
        return (z || !(charSequence instanceof String)) ? a(charSequence, new char[]{c2}, i, z) : ((String) charSequence).indexOf(c2, i);
    }

    public static /* synthetic */ int a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(charSequence, str, i, z);
    }

    public static final int a(CharSequence charSequence, String str, int i, boolean z) {
        kotlin.jvm.internal.h.b(charSequence, "$this$indexOf");
        kotlin.jvm.internal.h.b(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return a(charSequence, str, i, charSequence.length(), z, false, 16, null);
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return n.a(charSequence, charSequence2, z);
    }

    public static boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        kotlin.jvm.internal.h.b(charSequence, "$this$contains");
        kotlin.jvm.internal.h.b(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        if (charSequence2 instanceof String) {
            if (a(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else if (a(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a(charSequence, c2, z);
    }

    public static final boolean a(CharSequence charSequence, char c2, boolean z) {
        kotlin.jvm.internal.h.b(charSequence, "$this$contains");
        return n.a(charSequence, c2, 0, z, 2, (Object) null) >= 0;
    }

    static /* synthetic */ kotlin.d.c a(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return a(charSequence, cArr, i, z, i2);
    }

    private static final kotlin.d.c<kotlin.c.d> a(CharSequence charSequence, final char[] cArr, int i, final boolean z, int i2) {
        if (i2 >= 0) {
            return new e(charSequence, i, i2, new kotlin.jvm.a.c<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.a.c
                public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                    return invoke(charSequence2, num.intValue());
                }

                public final Pair<Integer, Integer> invoke(CharSequence charSequence2, int i3) {
                    kotlin.jvm.internal.h.b(charSequence2, "$receiver");
                    int a2 = w.a(charSequence2, cArr, i3, z);
                    if (a2 < 0) {
                        return null;
                    }
                    return kotlin.i.a(Integer.valueOf(a2), 1);
                }
            });
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    static /* synthetic */ kotlin.d.c a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return a(charSequence, strArr, i, z, i2);
    }

    private static final kotlin.d.c<kotlin.c.d> a(CharSequence charSequence, String[] strArr, int i, final boolean z, int i2) {
        if (i2 >= 0) {
            final List a2 = kotlin.collections.c.a(strArr);
            return new e(charSequence, i, i2, new kotlin.jvm.a.c<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.a.c
                public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                    return invoke(charSequence2, num.intValue());
                }

                public final Pair<Integer, Integer> invoke(CharSequence charSequence2, int i3) {
                    Pair b2;
                    kotlin.jvm.internal.h.b(charSequence2, "$receiver");
                    b2 = w.b(charSequence2, (Collection<String>) a2, i3, z, false);
                    if (b2 != null) {
                        return kotlin.i.a(b2.getFirst(), Integer.valueOf(((String) b2.getSecond()).length()));
                    }
                    return null;
                }
            });
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public static /* synthetic */ kotlin.d.c a(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return a(charSequence, strArr, z, i);
    }

    public static final kotlin.d.c<String> a(final CharSequence charSequence, String[] strArr, boolean z, int i) {
        kotlin.jvm.internal.h.b(charSequence, "$this$splitToSequence");
        kotlin.jvm.internal.h.b(strArr, "delimiters");
        return kotlin.d.d.a(a(charSequence, strArr, 0, z, i, 2, (Object) null), new kotlin.jvm.a.b<kotlin.c.d, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.a.b
            public final String invoke(kotlin.c.d dVar) {
                kotlin.jvm.internal.h.b(dVar, "it");
                return w.a(charSequence, dVar);
            }
        });
    }

    public static /* synthetic */ kotlin.d.c a(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return a(charSequence, cArr, z, i);
    }

    public static final kotlin.d.c<String> a(final CharSequence charSequence, char[] cArr, boolean z, int i) {
        kotlin.jvm.internal.h.b(charSequence, "$this$splitToSequence");
        kotlin.jvm.internal.h.b(cArr, "delimiters");
        return kotlin.d.d.a(a(charSequence, cArr, 0, z, i, 2, (Object) null), new kotlin.jvm.a.b<kotlin.c.d, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.a.b
            public final String invoke(kotlin.c.d dVar) {
                kotlin.jvm.internal.h.b(dVar, "it");
                return w.a(charSequence, dVar);
            }
        });
    }
}
