package com.umeng.commonsdk.statistics.proto;

import com.facebook.internal.ServerProtocol;
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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IdSnapshot.java */
/* loaded from: classes3.dex */
public class b implements j<b, e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<e, v> f26486d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f26487e = -6496538196005191531L;

    /* renamed from: f, reason: collision with root package name */
    private static final an f26488f = new an("IdSnapshot");

    /* renamed from: g, reason: collision with root package name */
    private static final ad f26489g = new ad("identity", (byte) 11, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final ad f26490h = new ad("ts", (byte) 10, 2);
    private static final ad i = new ad(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, (byte) 8, 3);
    private static final Map<Class<? extends aq>, ar> j = new HashMap();
    private static final int k = 0;
    private static final int l = 1;

    /* renamed from: a, reason: collision with root package name */
    public String f26491a;

    /* renamed from: b, reason: collision with root package name */
    public long f26492b;

    /* renamed from: c, reason: collision with root package name */
    public int f26493c;
    private byte m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdSnapshot.java */
    /* loaded from: classes3.dex */
    public static class a extends as<b> {
        private a() {
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ai aiVar, b bVar) throws p {
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
                            al.a(aiVar, b2);
                        } else if (b2 == 8) {
                            bVar.f26493c = aiVar.w();
                            bVar.c(true);
                        } else {
                            al.a(aiVar, b2);
                        }
                    } else if (b2 == 10) {
                        bVar.f26492b = aiVar.x();
                        bVar.b(true);
                    } else {
                        al.a(aiVar, b2);
                    }
                } else if (b2 == 11) {
                    bVar.f26491a = aiVar.z();
                    bVar.a(true);
                } else {
                    al.a(aiVar, b2);
                }
                aiVar.m();
            }
            aiVar.k();
            if (bVar.g()) {
                if (bVar.j()) {
                    bVar.k();
                    return;
                }
                throw new aj("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
            throw new aj("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ai aiVar, b bVar) throws p {
            bVar.k();
            aiVar.a(b.f26488f);
            if (bVar.f26491a != null) {
                aiVar.a(b.f26489g);
                aiVar.a(bVar.f26491a);
                aiVar.c();
            }
            aiVar.a(b.f26490h);
            aiVar.a(bVar.f26492b);
            aiVar.c();
            aiVar.a(b.i);
            aiVar.a(bVar.f26493c);
            aiVar.c();
            aiVar.d();
            aiVar.b();
        }
    }

    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0147b implements ar {
        private C0147b() {
        }

        @Override // com.umeng.commonsdk.proguard.ar
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdSnapshot.java */
    /* loaded from: classes3.dex */
    public static class c extends at<b> {
        private c() {
        }

        @Override // com.umeng.commonsdk.proguard.aq
        public void a(ai aiVar, b bVar) throws p {
            ao aoVar = (ao) aiVar;
            aoVar.a(bVar.f26491a);
            aoVar.a(bVar.f26492b);
            aoVar.a(bVar.f26493c);
        }

        @Override // com.umeng.commonsdk.proguard.aq
        public void b(ai aiVar, b bVar) throws p {
            ao aoVar = (ao) aiVar;
            bVar.f26491a = aoVar.z();
            bVar.a(true);
            bVar.f26492b = aoVar.x();
            bVar.b(true);
            bVar.f26493c = aoVar.w();
            bVar.c(true);
        }
    }

    /* compiled from: IdSnapshot.java */
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
        j.put(as.class, new C0147b());
        j.put(at.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.IDENTITY, (e) new v("identity", (byte) 1, new w((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new v("ts", (byte) 1, new w((byte) 10)));
        enumMap.put((EnumMap) e.VERSION, (e) new v(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, (byte) 1, new w((byte) 8)));
        f26486d = Collections.unmodifiableMap(enumMap);
        v.a(b.class, f26486d);
    }

    public b() {
        this.m = (byte) 0;
    }

    @Override // com.umeng.commonsdk.proguard.j
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.f26491a;
    }

    public void c() {
        this.f26491a = null;
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void clear() {
        this.f26491a = null;
        b(false);
        this.f26492b = 0L;
        c(false);
        this.f26493c = 0;
    }

    public boolean d() {
        return this.f26491a != null;
    }

    public long e() {
        return this.f26492b;
    }

    public void f() {
        this.m = g.b(this.m, 0);
    }

    public boolean g() {
        return g.a(this.m, 0);
    }

    public int h() {
        return this.f26493c;
    }

    public void i() {
        this.m = g.b(this.m, 1);
    }

    public boolean j() {
        return g.a(this.m, 1);
    }

    public void k() throws p {
        if (this.f26491a != null) {
            return;
        }
        throw new aj("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void read(ai aiVar) throws p {
        j.get(aiVar.D()).b().b(aiVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.f26491a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f26492b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f26493c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void write(ai aiVar) throws p {
        j.get(aiVar.D()).b().a(aiVar, this);
    }

    /* compiled from: IdSnapshot.java */
    /* loaded from: classes3.dex */
    public enum e implements q {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f26497d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f26499e;

        /* renamed from: f, reason: collision with root package name */
        private final String f26500f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f26497d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f26499e = s;
            this.f26500f = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return IDENTITY;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return VERSION;
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
            return this.f26500f;
        }

        public static e a(String str) {
            return f26497d.get(str);
        }

        @Override // com.umeng.commonsdk.proguard.q
        public short a() {
            return this.f26499e;
        }
    }

    public b a(String str) {
        this.f26491a = str;
        return this;
    }

    public void b(boolean z) {
        this.m = g.a(this.m, 0, z);
    }

    public void c(boolean z) {
        this.m = g.a(this.m, 1, z);
    }

    public b(String str, long j2, int i2) {
        this();
        this.f26491a = str;
        this.f26492b = j2;
        b(true);
        this.f26493c = i2;
        c(true);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f26491a = null;
    }

    @Override // com.umeng.commonsdk.proguard.j
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public b a(long j2) {
        this.f26492b = j2;
        b(true);
        return this;
    }

    public b a(int i2) {
        this.f26493c = i2;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new ac(new au(objectOutputStream)));
        } catch (p e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public b(b bVar) {
        this.m = (byte) 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.f26491a = bVar.f26491a;
        }
        this.f26492b = bVar.f26492b;
        this.f26493c = bVar.f26493c;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.m = (byte) 0;
            read(new ac(new au(objectInputStream)));
        } catch (p e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
