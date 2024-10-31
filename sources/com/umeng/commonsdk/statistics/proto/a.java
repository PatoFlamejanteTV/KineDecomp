package com.umeng.commonsdk.statistics.proto;

import com.umeng.commonsdk.proguard.ac;
import com.umeng.commonsdk.proguard.ad;
import com.umeng.commonsdk.proguard.ai;
import com.umeng.commonsdk.proguard.aj;
import com.umeng.commonsdk.proguard.al;
import com.umeng.commonsdk.proguard.an;
import com.umeng.commonsdk.proguard.ao;
import com.umeng.commonsdk.proguard.aq;
import com.umeng.commonsdk.proguard.ar;
import com.umeng.commonsdk.proguard.as;
import com.umeng.commonsdk.proguard.at;
import com.umeng.commonsdk.proguard.au;
import com.umeng.commonsdk.proguard.g;
import com.umeng.commonsdk.proguard.j;
import com.umeng.commonsdk.proguard.p;
import com.umeng.commonsdk.proguard.q;
import com.umeng.commonsdk.proguard.v;
import com.umeng.commonsdk.proguard.w;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IdJournal.java */
/* loaded from: classes3.dex */
public class a implements j<a, e>, Serializable, Cloneable {

    /* renamed from: e, reason: collision with root package name */
    public static final Map<e, v> f26470e;

    /* renamed from: f, reason: collision with root package name */
    private static final long f26471f = 9132678615281394583L;

    /* renamed from: g, reason: collision with root package name */
    private static final an f26472g = new an("IdJournal");

    /* renamed from: h, reason: collision with root package name */
    private static final ad f26473h = new ad("domain", (byte) 11, 1);
    private static final ad i = new ad("old_id", (byte) 11, 2);
    private static final ad j = new ad("new_id", (byte) 11, 3);
    private static final ad k = new ad("ts", (byte) 10, 4);
    private static final Map<Class<? extends aq>, ar> l = new HashMap();
    private static final int m = 0;

    /* renamed from: a, reason: collision with root package name */
    public String f26474a;

    /* renamed from: b, reason: collision with root package name */
    public String f26475b;

    /* renamed from: c, reason: collision with root package name */
    public String f26476c;

    /* renamed from: d, reason: collision with root package name */
    public long f26477d;
    private byte n;
    private e[] o;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdJournal.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0146a extends as<a> {
        private C0146a() {
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ai aiVar, a aVar) throws p {
            aiVar.j();
            while (true) {
                ad l = aiVar.l();
                byte b2 = l.f26172b;
                if (b2 == 0) {
                    break;
                }
                short s = l.f26173c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            if (s != 4) {
                                al.a(aiVar, b2);
                            } else if (b2 == 10) {
                                aVar.f26477d = aiVar.x();
                                aVar.d(true);
                            } else {
                                al.a(aiVar, b2);
                            }
                        } else if (b2 == 11) {
                            aVar.f26476c = aiVar.z();
                            aVar.c(true);
                        } else {
                            al.a(aiVar, b2);
                        }
                    } else if (b2 == 11) {
                        aVar.f26475b = aiVar.z();
                        aVar.b(true);
                    } else {
                        al.a(aiVar, b2);
                    }
                } else if (b2 == 11) {
                    aVar.f26474a = aiVar.z();
                    aVar.a(true);
                } else {
                    al.a(aiVar, b2);
                }
                aiVar.m();
            }
            aiVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new aj("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ai aiVar, a aVar) throws p {
            aVar.n();
            aiVar.a(a.f26472g);
            if (aVar.f26474a != null) {
                aiVar.a(a.f26473h);
                aiVar.a(aVar.f26474a);
                aiVar.c();
            }
            if (aVar.f26475b != null && aVar.g()) {
                aiVar.a(a.i);
                aiVar.a(aVar.f26475b);
                aiVar.c();
            }
            if (aVar.f26476c != null) {
                aiVar.a(a.j);
                aiVar.a(aVar.f26476c);
                aiVar.c();
            }
            aiVar.a(a.k);
            aiVar.a(aVar.f26477d);
            aiVar.c();
            aiVar.d();
            aiVar.b();
        }
    }

    /* compiled from: IdJournal.java */
    /* loaded from: classes3.dex */
    private static class b implements ar {
        private b() {
        }

        @Override // com.umeng.commonsdk.proguard.ar
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0146a b() {
            return new C0146a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdJournal.java */
    /* loaded from: classes3.dex */
    public static class c extends at<a> {
        private c() {
        }

        @Override // com.umeng.commonsdk.proguard.aq
        public void a(ai aiVar, a aVar) throws p {
            ao aoVar = (ao) aiVar;
            aoVar.a(aVar.f26474a);
            aoVar.a(aVar.f26476c);
            aoVar.a(aVar.f26477d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            aoVar.a(bitSet, 1);
            if (aVar.g()) {
                aoVar.a(aVar.f26475b);
            }
        }

        @Override // com.umeng.commonsdk.proguard.aq
        public void b(ai aiVar, a aVar) throws p {
            ao aoVar = (ao) aiVar;
            aVar.f26474a = aoVar.z();
            aVar.a(true);
            aVar.f26476c = aoVar.z();
            aVar.c(true);
            aVar.f26477d = aoVar.x();
            aVar.d(true);
            if (aoVar.b(1).get(0)) {
                aVar.f26475b = aoVar.z();
                aVar.b(true);
            }
        }
    }

    /* compiled from: IdJournal.java */
    /* loaded from: classes3.dex */
    private static class d implements ar {
        private d() {
        }

        @Override // com.umeng.commonsdk.proguard.ar
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        l.put(as.class, new b());
        l.put(at.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.DOMAIN, (e) new v("domain", (byte) 1, new w((byte) 11)));
        enumMap.put((EnumMap) e.OLD_ID, (e) new v("old_id", (byte) 2, new w((byte) 11)));
        enumMap.put((EnumMap) e.NEW_ID, (e) new v("new_id", (byte) 1, new w((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new v("ts", (byte) 1, new w((byte) 10)));
        f26470e = Collections.unmodifiableMap(enumMap);
        v.a(a.class, f26470e);
    }

    public a() {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.commonsdk.proguard.j
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a deepCopy() {
        return new a(this);
    }

    public String b() {
        return this.f26474a;
    }

    public void c() {
        this.f26474a = null;
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void clear() {
        this.f26474a = null;
        this.f26475b = null;
        this.f26476c = null;
        d(false);
        this.f26477d = 0L;
    }

    public boolean d() {
        return this.f26474a != null;
    }

    public String e() {
        return this.f26475b;
    }

    public void f() {
        this.f26475b = null;
    }

    public boolean g() {
        return this.f26475b != null;
    }

    public String h() {
        return this.f26476c;
    }

    public void i() {
        this.f26476c = null;
    }

    public boolean j() {
        return this.f26476c != null;
    }

    public long k() {
        return this.f26477d;
    }

    public void l() {
        this.n = g.b(this.n, 0);
    }

    public boolean m() {
        return g.a(this.n, 0);
    }

    public void n() throws p {
        if (this.f26474a != null) {
            if (this.f26476c != null) {
                return;
            }
            throw new aj("Required field 'new_id' was not present! Struct: " + toString());
        }
        throw new aj("Required field 'domain' was not present! Struct: " + toString());
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void read(ai aiVar) throws p {
        l.get(aiVar.D()).b().b(aiVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.f26474a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.f26475b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f26476c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f26477d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void write(ai aiVar) throws p {
        l.get(aiVar.D()).b().a(aiVar, this);
    }

    /* compiled from: IdJournal.java */
    /* loaded from: classes3.dex */
    public enum e implements q {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");


        /* renamed from: e, reason: collision with root package name */
        private static final Map<String, e> f26482e = new HashMap();

        /* renamed from: f, reason: collision with root package name */
        private final short f26484f;

        /* renamed from: g, reason: collision with root package name */
        private final String f26485g;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f26482e.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f26484f = s;
            this.f26485g = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return DOMAIN;
            }
            if (i == 2) {
                return OLD_ID;
            }
            if (i == 3) {
                return NEW_ID;
            }
            if (i != 4) {
                return null;
            }
            return TS;
        }

        public static e b(int i) {
            e a2 = a(i);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.commonsdk.proguard.q
        public String b() {
            return this.f26485g;
        }

        public static e a(String str) {
            return f26482e.get(str);
        }

        @Override // com.umeng.commonsdk.proguard.q
        public short a() {
            return this.f26484f;
        }
    }

    public a a(String str) {
        this.f26474a = str;
        return this;
    }

    public a b(String str) {
        this.f26475b = str;
        return this;
    }

    public a c(String str) {
        this.f26476c = str;
        return this;
    }

    public void d(boolean z) {
        this.n = g.a(this.n, 0, z);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f26474a = null;
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.f26475b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f26476c = null;
    }

    public a(String str, String str2, long j2) {
        this();
        this.f26474a = str;
        this.f26476c = str2;
        this.f26477d = j2;
        d(true);
    }

    public a a(long j2) {
        this.f26477d = j2;
        d(true);
        return this;
    }

    @Override // com.umeng.commonsdk.proguard.j
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new ac(new au(objectOutputStream)));
        } catch (p e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public a(a aVar) {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.f26474a = aVar.f26474a;
        }
        if (aVar.g()) {
            this.f26475b = aVar.f26475b;
        }
        if (aVar.j()) {
            this.f26476c = aVar.f26476c;
        }
        this.f26477d = aVar.f26477d;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.n = (byte) 0;
            read(new ac(new au(objectInputStream)));
        } catch (p e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
