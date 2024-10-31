package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zze {

    /* renamed from: a, reason: collision with root package name */
    public static final zze f1004a = a("\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000 \u180e ").a(a(8192, 8202));
    public static final zze b = a("\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000").a(a(8192, 8198)).a(a(8200, 8202));
    public static final zze c = a(0, 127);
    public static final zze d;
    public static final zze e;
    public static final zze f;
    public static final zze g;
    public static final zze h;
    public static final zze i;
    public static final zze j;
    public static final zze k;
    public static final zze l;
    public static final zze m;
    public static final zze n;
    public static final zze o;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends zze {
        List<zze> p;

        a(List<zze> list) {
            this.p = list;
        }

        @Override // com.google.android.gms.common.internal.zze
        public zze a(zze zzeVar) {
            ArrayList arrayList = new ArrayList(this.p);
            arrayList.add(zzx.a(zzeVar));
            return new a(arrayList);
        }

        @Override // com.google.android.gms.common.internal.zze
        public boolean b(char c) {
            Iterator<zze> it = this.p.iterator();
            while (it.hasNext()) {
                if (it.next().b(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        zze a2 = a('0', '9');
        zze zzeVar = a2;
        for (char c2 : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            zzeVar = zzeVar.a(a(c2, (char) (c2 + '\t')));
        }
        d = zzeVar;
        e = a('\t', '\r').a(a((char) 28, ' ')).a(a((char) 5760)).a(a((char) 6158)).a(a((char) 8192, (char) 8198)).a(a((char) 8200, (char) 8203)).a(a((char) 8232, (char) 8233)).a(a((char) 8287)).a(a((char) 12288));
        f = new b();
        g = new h();
        h = new i();
        i = new j();
        j = new k();
        k = a((char) 0, (char) 31).a(a((char) 127, (char) 159));
        l = a((char) 0, ' ').a(a((char) 127, (char) 160)).a(a((char) 173)).a(a((char) 1536, (char) 1539)).a(a("\u06dd\u070f\u1680឴឵\u180e")).a(a((char) 8192, (char) 8207)).a(a((char) 8232, (char) 8239)).a(a((char) 8287, (char) 8292)).a(a((char) 8298, (char) 8303)).a(a((char) 12288)).a(a((char) 55296, (char) 63743)).a(a("\ufeff\ufff9\ufffa\ufffb"));
        m = a((char) 0, (char) 1273).a(a((char) 1470)).a(a((char) 1488, (char) 1514)).a(a((char) 1523)).a(a((char) 1524)).a(a((char) 1536, (char) 1791)).a(a((char) 1872, (char) 1919)).a(a((char) 3584, (char) 3711)).a(a((char) 7680, (char) 8367)).a(a((char) 8448, (char) 8506)).a(a((char) 64336, (char) 65023)).a(a((char) 65136, (char) 65279)).a(a((char) 65377, (char) 65500));
        n = new l();
        o = new c();
    }

    public static zze a(char c2) {
        return new d(c2);
    }

    public static zze a(char c2, char c3) {
        zzx.b(c3 >= c2);
        return new g(c2, c3);
    }

    public static zze a(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return o;
            case 1:
                return a(charSequence.charAt(0));
            case 2:
                return new e(charSequence.charAt(0), charSequence.charAt(1));
            default:
                char[] charArray = charSequence.toString().toCharArray();
                Arrays.sort(charArray);
                return new f(charArray);
        }
    }

    public zze a(zze zzeVar) {
        return new a(Arrays.asList(this, (zze) zzx.a(zzeVar)));
    }

    public abstract boolean b(char c2);

    public boolean b(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!b(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
