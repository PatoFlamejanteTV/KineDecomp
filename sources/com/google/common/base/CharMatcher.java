package com.google.common.base;

import com.facebook.internal.NativeProtocol;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class CharMatcher implements Predicate<Character> {

    /* renamed from: a, reason: collision with root package name */
    public static final CharMatcher f2574a = a((CharSequence) "\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000").b(a((char) 8192, (char) 8198)).b(a((char) 8200, (char) 8202)).a("CharMatcher.BREAKING_WHITESPACE").b();
    public static final CharMatcher b = a(0, 127, "CharMatcher.ASCII");
    public static final CharMatcher c;
    public static final CharMatcher d;
    public static final CharMatcher e;
    public static final CharMatcher f;
    public static final CharMatcher g;
    public static final CharMatcher h;
    public static final CharMatcher i;
    public static final CharMatcher j;
    public static final CharMatcher k;
    public static final CharMatcher l;
    public static final CharMatcher m;
    public static final CharMatcher o;
    final String n;

    public abstract boolean c(char c2);

    static {
        CharMatcher a2 = a('0', '9');
        CharMatcher charMatcher = a2;
        for (char c2 : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            charMatcher = charMatcher.b(a(c2, (char) (c2 + '\t')));
        }
        c = charMatcher.a("CharMatcher.DIGIT").b();
        d = new com.google.common.base.a("CharMatcher.JAVA_DIGIT");
        e = new h("CharMatcher.JAVA_LETTER");
        f = new i("CharMatcher.JAVA_LETTER_OR_DIGIT");
        g = new j("CharMatcher.JAVA_UPPER_CASE");
        h = new k("CharMatcher.JAVA_LOWER_CASE");
        i = a((char) 0, (char) 31).b(a((char) 127, (char) 159)).a("CharMatcher.JAVA_ISO_CONTROL");
        j = a((char) 0, ' ').b(a((char) 127, (char) 160)).b(a((char) 173)).b(a((char) 1536, (char) 1540)).b(a((CharSequence) "\u06dd\u070f\u1680\u180e")).b(a((char) 8192, (char) 8207)).b(a((char) 8232, (char) 8239)).b(a((char) 8287, (char) 8292)).b(a((char) 8298, (char) 8303)).b(a((char) 12288)).b(a((char) 55296, (char) 63743)).b(a((CharSequence) "\ufeff\ufff9\ufffa\ufffb")).a("CharMatcher.INVISIBLE").b();
        k = a((char) 0, (char) 1273).b(a((char) 1470)).b(a((char) 1488, (char) 1514)).b(a((char) 1523)).b(a((char) 1524)).b(a((char) 1536, (char) 1791)).b(a((char) 1872, (char) 1919)).b(a((char) 3584, (char) 3711)).b(a((char) 7680, (char) 8367)).b(a((char) 8448, (char) 8506)).b(a((char) 64336, (char) 65023)).b(a((char) 65136, (char) 65279)).b(a((char) 65377, (char) 65500)).a("CharMatcher.SINGLE_WIDTH").b();
        l = new l("CharMatcher.ANY");
        m = new m("CharMatcher.NONE");
        o = new g("CharMatcher.WHITESPACE");
    }

    public static CharMatcher a(char c2) {
        return new n("CharMatcher.is(" + Integer.toHexString(c2) + ")", c2);
    }

    public static CharMatcher b(char c2) {
        return new o("CharMatcher.isNot(" + Integer.toHexString(c2) + ")", c2);
    }

    public static CharMatcher a(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return m;
            case 1:
                return a(charSequence.charAt(0));
            case 2:
                return new com.google.common.base.b("CharMatcher.anyOf(\"" + charSequence + "\")", charSequence.charAt(0), charSequence.charAt(1));
            default:
                char[] charArray = charSequence.toString().toCharArray();
                Arrays.sort(charArray);
                return new com.google.common.base.c("CharMatcher.anyOf(\"" + charArray + "\")", charArray);
        }
    }

    public static CharMatcher b(CharSequence charSequence) {
        return a(charSequence).a();
    }

    public static CharMatcher a(char c2, char c3) {
        Preconditions.a(c3 >= c2);
        return a(c2, c3, "CharMatcher.inRange(" + Integer.toHexString(c2) + ", " + Integer.toHexString(c3) + ")");
    }

    static CharMatcher a(char c2, char c3, String str) {
        return new d(str, c2, c3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharMatcher(String str) {
        this.n = str;
    }

    protected CharMatcher() {
        this.n = "UnknownCharMatcher";
    }

    public CharMatcher a() {
        return new e(this, this + ".negate()", this);
    }

    public CharMatcher a(CharMatcher charMatcher) {
        return new a(this, (CharMatcher) Preconditions.a(charMatcher));
    }

    /* loaded from: classes2.dex */
    private static class a extends CharMatcher {
        final CharMatcher p;
        final CharMatcher q;

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        a(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this(charMatcher, charMatcher2, "CharMatcher.and(" + charMatcher + ", " + charMatcher2 + ")");
        }

        a(CharMatcher charMatcher, CharMatcher charMatcher2, String str) {
            super(str);
            this.p = (CharMatcher) Preconditions.a(charMatcher);
            this.q = (CharMatcher) Preconditions.a(charMatcher2);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher a(CharMatcher charMatcher) {
            return new a(this, charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean c(char c) {
            return this.p.c(c) && this.q.c(c);
        }

        @Override // com.google.common.base.CharMatcher
        CharMatcher a(String str) {
            return new a(this.p, this.q, str);
        }
    }

    public CharMatcher b(CharMatcher charMatcher) {
        return new c(this, (CharMatcher) Preconditions.a(charMatcher));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c extends CharMatcher {
        final CharMatcher p;
        final CharMatcher q;

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        c(CharMatcher charMatcher, CharMatcher charMatcher2, String str) {
            super(str);
            this.p = (CharMatcher) Preconditions.a(charMatcher);
            this.q = (CharMatcher) Preconditions.a(charMatcher2);
        }

        c(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this(charMatcher, charMatcher2, "CharMatcher.or(" + charMatcher + ", " + charMatcher2 + ")");
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher b(CharMatcher charMatcher) {
            return new c(this, (CharMatcher) Preconditions.a(charMatcher));
        }

        @Override // com.google.common.base.CharMatcher
        public boolean c(char c) {
            return this.p.c(c) || this.q.c(c);
        }

        @Override // com.google.common.base.CharMatcher
        CharMatcher a(String str) {
            return new c(this.p, this.q, str);
        }
    }

    public CharMatcher b() {
        return t.a(this);
    }

    char[] c() {
        int i2;
        char[] cArr = new char[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];
        int i3 = 0;
        int i4 = 0;
        while (i3 <= 65535) {
            if (c((char) i3)) {
                i2 = i4 + 1;
                cArr[i4] = (char) i3;
            } else {
                i2 = i4;
            }
            i3++;
            i4 = i2;
        }
        char[] cArr2 = new char[i4];
        System.arraycopy(cArr, 0, cArr2, 0, i4);
        return cArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharMatcher d() {
        char[] c2 = c();
        int length = c2.length;
        if (length == 0) {
            return m;
        }
        if (length == 1) {
            return a(c2[0]);
        }
        if (length < 63) {
            return v.a(c2, toString());
        }
        if (length < 1023) {
            return q.a(c2, toString());
        }
        b bVar = new b(null);
        a(bVar);
        return new f(this, toString(), bVar);
    }

    CharMatcher a(String str) {
        throw new UnsupportedOperationException();
    }

    void a(b bVar) {
        char c2 = 0;
        while (true) {
            if (c(c2)) {
                bVar.a(c2);
            }
            char c3 = (char) (c2 + 1);
            if (c2 == 65535) {
                return;
            } else {
                c2 = c3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        int[] f2575a;

        private b() {
            this.f2575a = new int[2048];
        }

        /* synthetic */ b(com.google.common.base.a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(char c) {
            int[] iArr = this.f2575a;
            int i = c >> 5;
            iArr[i] = iArr[i] | (1 << c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b(char c) {
            return (this.f2575a[c >> 5] & (1 << c)) != 0;
        }
    }

    public boolean c(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!c(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean d(CharSequence charSequence) {
        return e(charSequence) == -1;
    }

    public int e(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (c(charSequence.charAt(i2))) {
                return i2;
            }
        }
        return -1;
    }

    public int a(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        Preconditions.b(i2, length);
        for (int i3 = i2; i3 < length; i3++) {
            if (c(charSequence.charAt(i3))) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.common.base.Predicate
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean apply(Character ch) {
        return c(ch.charValue());
    }

    public String toString() {
        return this.n;
    }
}
