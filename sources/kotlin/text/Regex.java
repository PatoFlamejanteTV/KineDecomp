package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class Regex implements Serializable {
    public static final a Companion = new a(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    /* compiled from: Regex.kt */
    /* loaded from: classes3.dex */
    private static final class Serialized implements Serializable {
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* compiled from: Regex.kt */
        /* loaded from: classes3.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        public Serialized(String str, int i) {
            kotlin.jvm.internal.h.b(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            kotlin.jvm.internal.h.a((Object) compile, "Pattern.compile(pattern, flags)");
            return new Regex(compile);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }
    }

    /* compiled from: Regex.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int a(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public Regex(Pattern pattern) {
        kotlin.jvm.internal.h.b(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ j find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public static /* synthetic */ kotlin.d.c findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.h.a((Object) pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence charSequence) {
        kotlin.jvm.internal.h.b(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    public final j find(CharSequence charSequence, int i) {
        j b2;
        kotlin.jvm.internal.h.b(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        kotlin.jvm.internal.h.a((Object) matcher, "nativePattern.matcher(input)");
        b2 = m.b(matcher, i, charSequence);
        return b2;
    }

    public final kotlin.d.c<j> findAll(final CharSequence charSequence, final int i) {
        kotlin.d.c<j> a2;
        kotlin.jvm.internal.h.b(charSequence, "input");
        a2 = kotlin.d.g.a(new kotlin.jvm.a.a<j>() { // from class: kotlin.text.Regex$findAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            public final j invoke() {
                return Regex.this.find(charSequence, i);
            }
        }, Regex$findAll$2.INSTANCE);
        return a2;
    }

    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        final int flags = this.nativePattern.flags();
        EnumSet allOf = EnumSet.allOf(RegexOption.class);
        kotlin.collections.p.a(allOf, new kotlin.jvm.a.b<T, Boolean>() { // from class: kotlin.text.Regex$fromInt$$inlined$apply$lambda$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.a.b
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return Boolean.valueOf(invoke((Enum) obj));
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            /* JADX WARN: Multi-variable type inference failed */
            public final boolean invoke(Enum r3) {
                f fVar = (f) r3;
                return (flags & fVar.getMask()) == fVar.getValue();
            }
        });
        Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        kotlin.jvm.internal.h.a((Object) unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.h.a((Object) pattern, "nativePattern.pattern()");
        return pattern;
    }

    public final j matchEntire(CharSequence charSequence) {
        j b2;
        kotlin.jvm.internal.h.b(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        kotlin.jvm.internal.h.a((Object) matcher, "nativePattern.matcher(input)");
        b2 = m.b(matcher, charSequence);
        return b2;
    }

    public final boolean matches(CharSequence charSequence) {
        kotlin.jvm.internal.h.b(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final String replace(CharSequence charSequence, String str) {
        kotlin.jvm.internal.h.b(charSequence, "input");
        kotlin.jvm.internal.h.b(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        kotlin.jvm.internal.h.a((Object) replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final String replaceFirst(CharSequence charSequence, String str) {
        kotlin.jvm.internal.h.b(charSequence, "input");
        kotlin.jvm.internal.h.b(str, "replacement");
        String replaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        kotlin.jvm.internal.h.a((Object) replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    public final List<String> split(CharSequence charSequence, int i) {
        List<String> a2;
        kotlin.jvm.internal.h.b(charSequence, "input");
        int i2 = 0;
        if (i >= 0) {
            Matcher matcher = this.nativePattern.matcher(charSequence);
            if (matcher.find() && i != 1) {
                ArrayList arrayList = new ArrayList(i > 0 ? kotlin.c.h.b(i, 10) : 10);
                int i3 = i - 1;
                do {
                    arrayList.add(charSequence.subSequence(i2, matcher.start()).toString());
                    i2 = matcher.end();
                    if (i3 >= 0 && arrayList.size() == i3) {
                        break;
                    }
                } while (matcher.find());
                arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
                return arrayList;
            }
            a2 = kotlin.collections.j.a(charSequence.toString());
            return a2;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        kotlin.jvm.internal.h.a((Object) pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.h.b(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            kotlin.jvm.internal.h.a(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    public final String replace(CharSequence charSequence, kotlin.jvm.a.b<? super j, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.h.b(charSequence, "input");
        kotlin.jvm.internal.h.b(bVar, "transform");
        int i = 0;
        j find$default = find$default(this, charSequence, 0, 2, null);
        if (find$default != null) {
            int length = charSequence.length();
            StringBuilder sb = new StringBuilder(length);
            while (find$default != null) {
                sb.append(charSequence, i, find$default.a().f().intValue());
                sb.append(bVar.invoke(find$default));
                i = find$default.a().e().intValue() + 1;
                find$default = find$default.next();
                if (i >= length || find$default == null) {
                    if (i < length) {
                        sb.append(charSequence, i, length);
                    }
                    String sb2 = sb.toString();
                    kotlin.jvm.internal.h.a((Object) sb2, "sb.toString()");
                    return sb2;
                }
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        return charSequence.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(java.lang.String r2, kotlin.text.RegexOption r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.h.b(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.h.b(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = r3.getValue()
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…nicodeCase(option.value))"
            kotlin.jvm.internal.h.a(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(java.lang.String r2, java.util.Set<? extends kotlin.text.RegexOption> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.h.b(r2, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.h.b(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = kotlin.text.m.a(r3)
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…odeCase(options.toInt()))"
            kotlin.jvm.internal.h.a(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }
}
