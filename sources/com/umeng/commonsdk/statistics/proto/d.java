package com.umeng.commonsdk.statistics.proto;

import com.facebook.internal.ServerProtocol;
import com.umeng.commonsdk.proguard.aa;
import com.umeng.commonsdk.proguard.ac;
import com.umeng.commonsdk.proguard.ad;
import com.umeng.commonsdk.proguard.af;
import com.umeng.commonsdk.proguard.ai;
import com.umeng.commonsdk.proguard.aj;
import com.umeng.commonsdk.proguard.al;
import com.umeng.commonsdk.proguard.an;
import com.umeng.commonsdk.proguard.ao;
import com.umeng.commonsdk.proguard.ap;
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
import com.umeng.commonsdk.proguard.y;
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

/* compiled from: Imprint.java */
/* loaded from: classes3.dex */
public class d implements j<d, e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<e, v> f26516d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f26517e = 2846460275012375038L;

    /* renamed from: f, reason: collision with root package name */
    private static final an f26518f = new an("Imprint");

    /* renamed from: g, reason: collision with root package name */
    private static final ad f26519g = new ad("property", ap.k, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final ad f26520h = new ad(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, (byte) 8, 2);
    private static final ad i = new ad("checksum", (byte) 11, 3);
    private static final Map<Class<? extends aq>, ar> j = new HashMap();
    private static final int k = 0;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.e> f26521a;

    /* renamed from: b, reason: collision with root package name */
    public int f26522b;

    /* renamed from: c, reason: collision with root package name */
    public String f26523c;
    private byte l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Imprint.java */
    /* loaded from: classes3.dex */
    public static class a extends as<d> {
        private a() {
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ai aiVar, d dVar) throws p {
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
                        } else if (b2 == 11) {
                            dVar.f26523c = aiVar.z();
                            dVar.c(true);
                        } else {
                            al.a(aiVar, b2);
                        }
                    } else if (b2 == 8) {
                        dVar.f26522b = aiVar.w();
                        dVar.b(true);
                    } else {
                        al.a(aiVar, b2);
                    }
                } else if (b2 == 13) {
                    af n = aiVar.n();
                    dVar.f26521a = new HashMap(n.f26178c * 2);
                    for (int i = 0; i < n.f26178c; i++) {
                        String z = aiVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(aiVar);
                        dVar.f26521a.put(z, eVar);
                    }
                    aiVar.o();
                    dVar.a(true);
                } else {
                    al.a(aiVar, b2);
                }
                aiVar.m();
            }
            aiVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new aj("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ai aiVar, d dVar) throws p {
            dVar.l();
            aiVar.a(d.f26518f);
            if (dVar.f26521a != null) {
                aiVar.a(d.f26519g);
                aiVar.a(new af((byte) 11, (byte) 12, dVar.f26521a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f26521a.entrySet()) {
                    aiVar.a(entry.getKey());
                    entry.getValue().write(aiVar);
                }
                aiVar.e();
                aiVar.c();
            }
            aiVar.a(d.f26520h);
            aiVar.a(dVar.f26522b);
            aiVar.c();
            if (dVar.f26523c != null) {
                aiVar.a(d.i);
                aiVar.a(dVar.f26523c);
                aiVar.c();
            }
            aiVar.d();
            aiVar.b();
        }
    }

    /* compiled from: Imprint.java */
    /* loaded from: classes3.dex */
    private static class b implements ar {
        private b() {
        }

        @Override // com.umeng.commonsdk.proguard.ar
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Imprint.java */
    /* loaded from: classes3.dex */
    public static class c extends at<d> {
        private c() {
        }

        @Override // com.umeng.commonsdk.proguard.aq
        public void a(ai aiVar, d dVar) throws p {
            ao aoVar = (ao) aiVar;
            aoVar.a(dVar.f26521a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f26521a.entrySet()) {
                aoVar.a(entry.getKey());
                entry.getValue().write(aoVar);
            }
            aoVar.a(dVar.f26522b);
            aoVar.a(dVar.f26523c);
        }

        @Override // com.umeng.commonsdk.proguard.aq
        public void b(ai aiVar, d dVar) throws p {
            ao aoVar = (ao) aiVar;
            af afVar = new af((byte) 11, (byte) 12, aoVar.w());
            dVar.f26521a = new HashMap(afVar.f26178c * 2);
            for (int i = 0; i < afVar.f26178c; i++) {
                String z = aoVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(aoVar);
                dVar.f26521a.put(z, eVar);
            }
            dVar.a(true);
            dVar.f26522b = aoVar.w();
            dVar.b(true);
            dVar.f26523c = aoVar.z();
            dVar.c(true);
        }
    }

    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0149d implements ar {
        private C0149d() {
        }

        @Override // com.umeng.commonsdk.proguard.ar
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        j.put(as.class, new b());
        j.put(at.class, new C0149d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.PROPERTY, (e) new v("property", (byte) 1, new y(ap.k, new w((byte) 11), new aa((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put((EnumMap) e.VERSION, (e) new v(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, (byte) 1, new w((byte) 8)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new v("checksum", (byte) 1, new w((byte) 11)));
        f26516d = Collections.unmodifiableMap(enumMap);
        v.a(d.class, f26516d);
    }

    public d() {
        this.l = (byte) 0;
    }

    @Override // com.umeng.commonsdk.proguard.j
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f26521a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.f26521a;
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void clear() {
        this.f26521a = null;
        b(false);
        this.f26522b = 0;
        this.f26523c = null;
    }

    public void d() {
        this.f26521a = null;
    }

    public boolean e() {
        return this.f26521a != null;
    }

    public int f() {
        return this.f26522b;
    }

    public void g() {
        this.l = g.b(this.l, 0);
    }

    public boolean h() {
        return g.a(this.l, 0);
    }

    public String i() {
        return this.f26523c;
    }

    public void j() {
        this.f26523c = null;
    }

    public boolean k() {
        return this.f26523c != null;
    }

    public void l() throws p {
        if (this.f26521a != null) {
            if (this.f26523c != null) {
                return;
            }
            throw new aj("Required field 'checksum' was not present! Struct: " + toString());
        }
        throw new aj("Required field 'property' was not present! Struct: " + toString());
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void read(ai aiVar) throws p {
        j.get(aiVar.D()).b().b(aiVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f26521a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f26522b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f26523c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void write(ai aiVar) throws p {
        j.get(aiVar.D()).b().a(aiVar, this);
    }

    /* compiled from: Imprint.java */
    /* loaded from: classes3.dex */
    public enum e implements q {
        PROPERTY(1, "property"),
        VERSION(2, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION),
        CHECKSUM(3, "checksum");


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f26527d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f26529e;

        /* renamed from: f, reason: collision with root package name */
        private final String f26530f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f26527d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f26529e = s;
            this.f26530f = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return PROPERTY;
            }
            if (i == 2) {
                return VERSION;
            }
            if (i != 3) {
                return null;
            }
            return CHECKSUM;
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
            return this.f26530f;
        }

        public static e a(String str) {
            return f26527d.get(str);
        }

        @Override // com.umeng.commonsdk.proguard.q
        public short a() {
            return this.f26529e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.f26521a == null) {
            this.f26521a = new HashMap();
        }
        this.f26521a.put(str, eVar);
    }

    public void b(boolean z) {
        this.l = g.a(this.l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f26523c = null;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.f26521a = map;
        this.f26522b = i2;
        b(true);
        this.f26523c = str;
    }

    @Override // com.umeng.commonsdk.proguard.j
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.f26521a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f26521a = null;
    }

    public d a(int i2) {
        this.f26522b = i2;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.l = (byte) 0;
        this.l = dVar.l;
        if (dVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f26521a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.f26521a = hashMap;
        }
        this.f26522b = dVar.f26522b;
        if (dVar.k()) {
            this.f26523c = dVar.f26523c;
        }
    }

    public d a(String str) {
        this.f26523c = str;
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new ac(new au(objectOutputStream)));
        } catch (p e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.l = (byte) 0;
            read(new ac(new au(objectInputStream)));
        } catch (p e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
