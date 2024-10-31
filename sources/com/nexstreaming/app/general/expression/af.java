package com.nexstreaming.app.general.expression;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Tokenizer.java */
/* loaded from: classes.dex */
public class af<T, C> {
    public static final f b = new ah();
    public static final f c = new ai();
    public static final f d = new aj();
    public static final f e = new d();
    public static final f f = new ak();
    private List<Pair<f, e<T, C>>> g = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public final e<T, C> f3135a = new ag(this);

    /* compiled from: Tokenizer.java */
    /* loaded from: classes.dex */
    public interface e<T, C> {
        T a(String str, C c);
    }

    /* compiled from: Tokenizer.java */
    /* loaded from: classes.dex */
    public interface f {
        int a(String str);
    }

    public void a(f fVar, e<T, C> eVar) {
        this.g.add(new Pair<>(fVar, eVar));
    }

    /* compiled from: Tokenizer.java */
    /* loaded from: classes.dex */
    public static class c implements f {

        /* renamed from: a, reason: collision with root package name */
        private final String f3138a;

        public c(String str) {
            this.f3138a = str;
        }

        @Override // com.nexstreaming.app.general.expression.af.f
        public int a(String str) {
            if (str.startsWith(this.f3138a)) {
                return this.f3138a.length();
            }
            return 0;
        }
    }

    /* compiled from: Tokenizer.java */
    /* loaded from: classes.dex */
    public static class b implements f {

        /* renamed from: a, reason: collision with root package name */
        private final char f3137a;
        private final char b;

        public b(char c, char c2) {
            this.f3137a = c;
            this.b = c2;
        }

        @Override // com.nexstreaming.app.general.expression.af.f
        public int a(String str) {
            int length = str.length();
            if (length < 2 || str.charAt(0) != this.f3137a) {
                return 0;
            }
            int i = 1;
            while (i < length) {
                char charAt = str.charAt(i);
                if (charAt == this.f3137a) {
                    if (this.f3137a == this.b && i + 1 < length && str.charAt(i + 1) == this.f3137a) {
                        i++;
                    } else {
                        return i + 1;
                    }
                } else if (this.b != 0 && charAt == this.b) {
                    i++;
                }
                i++;
            }
            return 0;
        }
    }

    /* compiled from: Tokenizer.java */
    /* loaded from: classes.dex */
    public static class a implements f {

        /* renamed from: a, reason: collision with root package name */
        private final char f3136a;

        public a(char c) {
            this.f3136a = c;
        }

        @Override // com.nexstreaming.app.general.expression.af.f
        public int a(String str) {
            return (str.length() <= 0 || str.charAt(0) != this.f3136a) ? 0 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(char c2) {
        return (c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z') || c2 == '_';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(char c2) {
        return (c2 >= '0' && c2 <= '9') || c(c2);
    }

    /* compiled from: Tokenizer.java */
    /* loaded from: classes.dex */
    public static class d implements f {

        /* renamed from: a, reason: collision with root package name */
        private final String f3139a;
        private final int b;

        public d() {
            this.f3139a = null;
            this.b = 0;
        }

        public d(String str) {
            this.f3139a = str;
            this.b = str.length();
        }

        @Override // com.nexstreaming.app.general.expression.af.f
        public int a(String str) {
            if (this.f3139a == null || this.b < 1) {
                int length = str.length();
                if (length < 1 || !af.c(str.charAt(0))) {
                    return 0;
                }
                for (int i = 1; i < length; i++) {
                    if (!af.d(str.charAt(i))) {
                        return i;
                    }
                }
                return length;
            }
            if (!str.startsWith(this.f3139a)) {
                return 0;
            }
            if (str.length() == this.b || !af.d(str.charAt(this.b))) {
                return this.b;
            }
            return 0;
        }
    }

    public List<T> a(String str, C c2) throws TokenNotMatchedException {
        boolean z;
        String str2;
        ArrayList arrayList = new ArrayList();
        String str3 = str;
        while (str3.length() > 0) {
            Iterator<Pair<f, e<T, C>>> it = this.g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    str2 = str3;
                    break;
                }
                Pair<f, e<T, C>> next = it.next();
                int a2 = ((f) next.first).a(str3);
                if (a2 > 0) {
                    Object a3 = ((e) next.second).a(str3.substring(0, a2), c2);
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                    String substring = str3.substring(a2);
                    z = true;
                    str2 = substring;
                }
            }
            if (!z) {
                throw new TokenNotMatchedException(str.length() - str2.length());
            }
            str3 = str2;
        }
        return arrayList;
    }
}
