package com.google.common.base;

import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class CharMatcher implements Predicate<Character> {

    /* renamed from: a */
    @Deprecated
    public static final CharMatcher f15068a = o();

    /* renamed from: b */
    @Deprecated
    public static final CharMatcher f15069b = c();

    /* renamed from: c */
    @Deprecated
    public static final CharMatcher f15070c = b();

    /* renamed from: d */
    @Deprecated
    public static final CharMatcher f15071d = d();

    /* renamed from: e */
    @Deprecated
    public static final CharMatcher f15072e = f();

    /* renamed from: f */
    @Deprecated
    public static final CharMatcher f15073f = h();

    /* renamed from: g */
    @Deprecated
    public static final CharMatcher f15074g = i();

    /* renamed from: h */
    @Deprecated
    public static final CharMatcher f15075h = k();

    @Deprecated
    public static final CharMatcher i = j();

    @Deprecated
    public static final CharMatcher j = g();

    @Deprecated
    public static final CharMatcher k = e();

    @Deprecated
    public static final CharMatcher l = n();

    @Deprecated
    public static final CharMatcher m = a();

    @Deprecated
    public static final CharMatcher n = m();

    /* loaded from: classes2.dex */
    public static final class a extends CharMatcher {
        final CharMatcher o;
        final CharMatcher p;

        a(CharMatcher charMatcher, CharMatcher charMatcher2) {
            Preconditions.a(charMatcher);
            this.o = charMatcher;
            Preconditions.a(charMatcher2);
            this.p = charMatcher2;
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return this.o.d(c2) && this.p.d(c2);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.and(" + this.o + ", " + this.p + ")";
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends s {
        static final b p = new b();

        private b() {
            super("CharMatcher.any()");
        }

        @Override // com.google.common.base.CharMatcher
        public int a(CharSequence charSequence, int i) {
            int length = charSequence.length();
            Preconditions.b(i, length);
            if (i == length) {
                return -1;
            }
            return i;
        }

        @Override // com.google.common.base.CharMatcher
        public int b(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean c(CharSequence charSequence) {
            Preconditions.a(charSequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher.g, com.google.common.base.CharMatcher
        public CharMatcher l() {
            return CharMatcher.m();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher b(CharMatcher charMatcher) {
            Preconditions.a(charMatcher);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher a(CharMatcher charMatcher) {
            Preconditions.a(charMatcher);
            return charMatcher;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends CharMatcher {
        private final char[] o;

        public c(CharSequence charSequence) {
            this.o = charSequence.toString().toCharArray();
            Arrays.sort(this.o);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return Arrays.binarySearch(this.o, c2) >= 0;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c2 : this.o) {
                sb.append(CharMatcher.e(c2));
            }
            sb.append("\")");
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    public static final class d extends s {
        static final d p = new d();

        d() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return c2 <= 127;
        }
    }

    /* loaded from: classes2.dex */
    public static final class e extends CharMatcher {
        static final CharMatcher o = new e();

        private e() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            if (c2 != ' ' && c2 != 133 && c2 != 5760) {
                if (c2 == 8199) {
                    return false;
                }
                if (c2 != 8287 && c2 != 12288 && c2 != 8232 && c2 != 8233) {
                    switch (c2) {
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                            break;
                        default:
                            return c2 >= 8192 && c2 <= 8202;
                    }
                }
            }
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    /* loaded from: classes2.dex */
    public static final class f extends x {
        static final f r = new f();

        private f() {
            super("CharMatcher.digit()", q(), p());
        }

        private static char[] p() {
            char[] cArr = new char[31];
            for (int i = 0; i < 31; i++) {
                cArr[i] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".charAt(i) + '\t');
            }
            return cArr;
        }

        private static char[] q() {
            return "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class g extends CharMatcher {
        g() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher l() {
            return new u(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class h extends g {
        private final char o;
        private final char p;

        h(char c2, char c3) {
            Preconditions.a(c3 >= c2);
            this.o = c2;
            this.p = c3;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return this.o <= c2 && c2 <= this.p;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.inRange('" + CharMatcher.e(this.o) + "', '" + CharMatcher.e(this.p) + "')";
        }
    }

    /* loaded from: classes2.dex */
    public static final class i extends x {
        static final i r = new i();

        private i() {
            super("CharMatcher.invisible()", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u1680\u180e\u2000\u2028\u205f\u2066\u2067\u2068\u2069\u206a\u3000\ud800\ufeff\ufff9\ufffa".toCharArray(), "  \u00ad\u0604\u061c\u06dd\u070f\u1680\u180e\u200f \u2064\u2066\u2067\u2068\u2069\u206f\u3000\uf8ff\ufeff\ufff9\ufffb".toCharArray());
        }
    }

    /* loaded from: classes2.dex */
    public static final class j extends g {
        private final char o;

        j(char c2) {
            this.o = c2;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher a(CharMatcher charMatcher) {
            return charMatcher.d(this.o) ? this : CharMatcher.m();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher b(CharMatcher charMatcher) {
            return charMatcher.d(this.o) ? charMatcher : super.b(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return c2 == this.o;
        }

        @Override // com.google.common.base.CharMatcher.g, com.google.common.base.CharMatcher
        public CharMatcher l() {
            return CharMatcher.c(this.o);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.is('" + CharMatcher.e(this.o) + "')";
        }
    }

    /* loaded from: classes2.dex */
    public static final class k extends g {
        private final char o;
        private final char p;

        k(char c2, char c3) {
            this.o = c2;
            this.p = c3;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return c2 == this.o || c2 == this.p;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.anyOf(\"" + CharMatcher.e(this.o) + CharMatcher.e(this.p) + "\")";
        }
    }

    /* loaded from: classes2.dex */
    public static final class l extends g {
        private final char o;

        l(char c2) {
            this.o = c2;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher a(CharMatcher charMatcher) {
            return charMatcher.d(this.o) ? super.a(charMatcher) : charMatcher;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher b(CharMatcher charMatcher) {
            return charMatcher.d(this.o) ? CharMatcher.a() : this;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return c2 != this.o;
        }

        @Override // com.google.common.base.CharMatcher.g, com.google.common.base.CharMatcher
        public CharMatcher l() {
            return CharMatcher.b(this.o);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.isNot('" + CharMatcher.e(this.o) + "')";
        }
    }

    /* loaded from: classes2.dex */
    public static final class m extends CharMatcher {
        static final m o = new m();

        private m() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return Character.isDigit(c2);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    /* loaded from: classes2.dex */
    public static final class n extends s {
        static final n p = new n();

        private n() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return c2 <= 31 || (c2 >= 127 && c2 <= 159);
        }
    }

    /* loaded from: classes2.dex */
    public static final class o extends CharMatcher {
        static final o o = new o();

        private o() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return Character.isLetter(c2);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    /* loaded from: classes2.dex */
    public static final class p extends CharMatcher {
        static final p o = new p();

        private p() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return Character.isLetterOrDigit(c2);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    /* loaded from: classes2.dex */
    public static final class q extends CharMatcher {
        static final q o = new q();

        private q() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return Character.isLowerCase(c2);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    /* loaded from: classes2.dex */
    public static final class r extends CharMatcher {
        static final r o = new r();

        private r() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return Character.isUpperCase(c2);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class s extends g {
        private final String o;

        s(String str) {
            Preconditions.a(str);
            this.o = str;
        }

        @Override // com.google.common.base.CharMatcher
        public final String toString() {
            return this.o;
        }
    }

    /* loaded from: classes2.dex */
    public static class t extends CharMatcher {
        final CharMatcher o;

        t(CharMatcher charMatcher) {
            Preconditions.a(charMatcher);
            this.o = charMatcher;
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean c(CharSequence charSequence) {
            return this.o.d(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return !this.o.d(c2);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher l() {
            return this.o;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.o + ".negate()";
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(CharSequence charSequence) {
            return this.o.c(charSequence);
        }
    }

    /* loaded from: classes2.dex */
    static class u extends t {
        u(CharMatcher charMatcher) {
            super(charMatcher);
        }
    }

    /* loaded from: classes2.dex */
    public static final class v extends s {
        static final v p = new v();

        private v() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.CharMatcher
        public int a(CharSequence charSequence, int i) {
            Preconditions.b(i, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public int b(CharSequence charSequence) {
            Preconditions.a(charSequence);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean c(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(CharSequence charSequence) {
            Preconditions.a(charSequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public String f(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher.g, com.google.common.base.CharMatcher
        public CharMatcher l() {
            return CharMatcher.a();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher b(CharMatcher charMatcher) {
            Preconditions.a(charMatcher);
            return charMatcher;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher a(CharMatcher charMatcher) {
            Preconditions.a(charMatcher);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class w extends CharMatcher {
        final CharMatcher o;
        final CharMatcher p;

        w(CharMatcher charMatcher, CharMatcher charMatcher2) {
            Preconditions.a(charMatcher);
            this.o = charMatcher;
            Preconditions.a(charMatcher2);
            this.p = charMatcher2;
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return this.o.d(c2) || this.p.d(c2);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.or(" + this.o + ", " + this.p + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class x extends CharMatcher {
        private final String o;
        private final char[] p;
        private final char[] q;

        x(String str, char[] cArr, char[] cArr2) {
            this.o = str;
            this.p = cArr;
            this.q = cArr2;
            Preconditions.a(cArr.length == cArr2.length);
            int i = 0;
            while (i < cArr.length) {
                Preconditions.a(cArr[i] <= cArr2[i]);
                int i2 = i + 1;
                if (i2 < cArr.length) {
                    Preconditions.a(cArr2[i] < cArr[i2]);
                }
                i = i2;
            }
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            int binarySearch = Arrays.binarySearch(this.p, c2);
            if (binarySearch >= 0) {
                return true;
            }
            int i = (binarySearch ^ (-1)) - 1;
            return i >= 0 && c2 <= this.q[i];
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.o;
        }
    }

    /* loaded from: classes2.dex */
    public static final class y extends x {
        static final y r = new y();

        private y() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class z extends s {
        static final int p = Integer.numberOfLeadingZeros(31);
        static final z q = new z();

        z() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean d(char c2) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c2) >>> p) == c2;
        }
    }

    public static CharMatcher b() {
        return d.p;
    }

    public static CharMatcher c() {
        return e.o;
    }

    public static CharMatcher d() {
        return f.r;
    }

    public static CharMatcher e() {
        return i.r;
    }

    public static CharMatcher f() {
        return m.o;
    }

    public static CharMatcher g() {
        return n.p;
    }

    public static CharMatcher h() {
        return o.o;
    }

    public static CharMatcher i() {
        return p.o;
    }

    public static CharMatcher j() {
        return q.o;
    }

    public static CharMatcher k() {
        return r.o;
    }

    public static CharMatcher m() {
        return v.p;
    }

    public static CharMatcher n() {
        return y.r;
    }

    public static CharMatcher o() {
        return z.q;
    }

    public abstract boolean d(char c2);

    public CharMatcher l() {
        return new t(this);
    }

    public String toString() {
        return super.toString();
    }

    public static CharMatcher a() {
        return b.p;
    }

    public static CharMatcher b(char c2) {
        return new j(c2);
    }

    public static CharMatcher c(char c2) {
        return new l(c2);
    }

    public static CharMatcher e(CharSequence charSequence) {
        return a(charSequence).l();
    }

    public boolean d(CharSequence charSequence) {
        return b(charSequence) == -1;
    }

    public String f(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!d(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    public static CharMatcher a(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return m();
        }
        if (length == 1) {
            return b(charSequence.charAt(0));
        }
        if (length != 2) {
            return new c(charSequence);
        }
        return b(charSequence.charAt(0), charSequence.charAt(1));
    }

    public static String e(char c2) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public CharMatcher b(CharMatcher charMatcher) {
        return new w(this, charMatcher);
    }

    public boolean c(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!d(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public int b(CharSequence charSequence) {
        return a(charSequence, 0);
    }

    private static k b(char c2, char c3) {
        return new k(c2, c3);
    }

    public static CharMatcher a(char c2, char c3) {
        return new h(c2, c3);
    }

    public CharMatcher a(CharMatcher charMatcher) {
        return new a(this, charMatcher);
    }

    public int a(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        Preconditions.b(i2, length);
        while (i2 < length) {
            if (d(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    /* renamed from: a */
    public boolean apply(Character ch) {
        return d(ch.charValue());
    }
}
