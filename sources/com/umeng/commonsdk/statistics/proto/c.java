package com.umeng.commonsdk.statistics.proto;

import com.umeng.commonsdk.proguard.aa;
import com.umeng.commonsdk.proguard.ac;
import com.umeng.commonsdk.proguard.ad;
import com.umeng.commonsdk.proguard.ae;
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
import com.umeng.commonsdk.proguard.j;
import com.umeng.commonsdk.proguard.p;
import com.umeng.commonsdk.proguard.q;
import com.umeng.commonsdk.proguard.v;
import com.umeng.commonsdk.proguard.w;
import com.umeng.commonsdk.proguard.x;
import com.umeng.commonsdk.proguard.y;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: IdTracking.java */
/* loaded from: classes3.dex */
public class c implements j<c, e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<e, v> f26501d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f26502e = -5764118265293965743L;

    /* renamed from: f, reason: collision with root package name */
    private static final an f26503f = new an("IdTracking");

    /* renamed from: g, reason: collision with root package name */
    private static final ad f26504g = new ad("snapshots", ap.k, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final ad f26505h = new ad("journals", ap.m, 2);
    private static final ad i = new ad("checksum", (byte) 11, 3);
    private static final Map<Class<? extends aq>, ar> j = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.b> f26506a;

    /* renamed from: b, reason: collision with root package name */
    public List<com.umeng.commonsdk.statistics.proto.a> f26507b;

    /* renamed from: c, reason: collision with root package name */
    public String f26508c;
    private e[] k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdTracking.java */
    /* loaded from: classes3.dex */
    public static class a extends as<c> {
        private a() {
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ai aiVar, c cVar) throws p {
            aiVar.j();
            while (true) {
                ad l = aiVar.l();
                byte b2 = l.f26172b;
                if (b2 == 0) {
                    aiVar.k();
                    cVar.n();
                    return;
                }
                short s = l.f26173c;
                int i = 0;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            al.a(aiVar, b2);
                        } else if (b2 == 11) {
                            cVar.f26508c = aiVar.z();
                            cVar.c(true);
                        } else {
                            al.a(aiVar, b2);
                        }
                    } else if (b2 == 15) {
                        ae p = aiVar.p();
                        cVar.f26507b = new ArrayList(p.f26175b);
                        while (i < p.f26175b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(aiVar);
                            cVar.f26507b.add(aVar);
                            i++;
                        }
                        aiVar.q();
                        cVar.b(true);
                    } else {
                        al.a(aiVar, b2);
                    }
                } else if (b2 == 13) {
                    af n = aiVar.n();
                    cVar.f26506a = new HashMap(n.f26178c * 2);
                    while (i < n.f26178c) {
                        String z = aiVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(aiVar);
                        cVar.f26506a.put(z, bVar);
                        i++;
                    }
                    aiVar.o();
                    cVar.a(true);
                } else {
                    al.a(aiVar, b2);
                }
                aiVar.m();
            }
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ai aiVar, c cVar) throws p {
            cVar.n();
            aiVar.a(c.f26503f);
            if (cVar.f26506a != null) {
                aiVar.a(c.f26504g);
                aiVar.a(new af((byte) 11, (byte) 12, cVar.f26506a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f26506a.entrySet()) {
                    aiVar.a(entry.getKey());
                    entry.getValue().write(aiVar);
                }
                aiVar.e();
                aiVar.c();
            }
            if (cVar.f26507b != null && cVar.j()) {
                aiVar.a(c.f26505h);
                aiVar.a(new ae((byte) 12, cVar.f26507b.size()));
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f26507b.iterator();
                while (it.hasNext()) {
                    it.next().write(aiVar);
                }
                aiVar.f();
                aiVar.c();
            }
            if (cVar.f26508c != null && cVar.m()) {
                aiVar.a(c.i);
                aiVar.a(cVar.f26508c);
                aiVar.c();
            }
            aiVar.d();
            aiVar.b();
        }
    }

    /* compiled from: IdTracking.java */
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
    /* compiled from: IdTracking.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0148c extends at<c> {
        private C0148c() {
        }

        @Override // com.umeng.commonsdk.proguard.aq
        public void a(ai aiVar, c cVar) throws p {
            ao aoVar = (ao) aiVar;
            aoVar.a(cVar.f26506a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f26506a.entrySet()) {
                aoVar.a(entry.getKey());
                entry.getValue().write(aoVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            aoVar.a(bitSet, 2);
            if (cVar.j()) {
                aoVar.a(cVar.f26507b.size());
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f26507b.iterator();
                while (it.hasNext()) {
                    it.next().write(aoVar);
                }
            }
            if (cVar.m()) {
                aoVar.a(cVar.f26508c);
            }
        }

        @Override // com.umeng.commonsdk.proguard.aq
        public void b(ai aiVar, c cVar) throws p {
            ao aoVar = (ao) aiVar;
            af afVar = new af((byte) 11, (byte) 12, aoVar.w());
            cVar.f26506a = new HashMap(afVar.f26178c * 2);
            for (int i = 0; i < afVar.f26178c; i++) {
                String z = aoVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(aoVar);
                cVar.f26506a.put(z, bVar);
            }
            cVar.a(true);
            BitSet b2 = aoVar.b(2);
            if (b2.get(0)) {
                ae aeVar = new ae((byte) 12, aoVar.w());
                cVar.f26507b = new ArrayList(aeVar.f26175b);
                for (int i2 = 0; i2 < aeVar.f26175b; i2++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(aoVar);
                    cVar.f26507b.add(aVar);
                }
                cVar.b(true);
            }
            if (b2.get(1)) {
                cVar.f26508c = aoVar.z();
                cVar.c(true);
            }
        }
    }

    /* compiled from: IdTracking.java */
    /* loaded from: classes3.dex */
    private static class d implements ar {
        private d() {
        }

        @Override // com.umeng.commonsdk.proguard.ar
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0148c b() {
            return new C0148c();
        }
    }

    static {
        j.put(as.class, new b());
        j.put(at.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.SNAPSHOTS, (e) new v("snapshots", (byte) 1, new y(ap.k, new w((byte) 11), new aa((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put((EnumMap) e.JOURNALS, (e) new v("journals", (byte) 2, new x(ap.m, new aa((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new v("checksum", (byte) 2, new w((byte) 11)));
        f26501d = Collections.unmodifiableMap(enumMap);
        v.a(c.class, f26501d);
    }

    public c() {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.commonsdk.proguard.j
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f26506a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.f26506a;
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void clear() {
        this.f26506a = null;
        this.f26507b = null;
        this.f26508c = null;
    }

    public void d() {
        this.f26506a = null;
    }

    public boolean e() {
        return this.f26506a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f26507b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f26507b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.f26507b;
    }

    public void i() {
        this.f26507b = null;
    }

    public boolean j() {
        return this.f26507b != null;
    }

    public String k() {
        return this.f26508c;
    }

    public void l() {
        this.f26508c = null;
    }

    public boolean m() {
        return this.f26508c != null;
    }

    public void n() throws p {
        if (this.f26506a != null) {
            return;
        }
        throw new aj("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void read(ai aiVar) throws p {
        j.get(aiVar.D()).b().b(aiVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f26506a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.f26507b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f26508c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void write(ai aiVar) throws p {
        j.get(aiVar.D()).b().a(aiVar, this);
    }

    /* compiled from: IdTracking.java */
    /* loaded from: classes3.dex */
    public enum e implements q {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f26512d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f26514e;

        /* renamed from: f, reason: collision with root package name */
        private final String f26515f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f26512d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f26514e = s;
            this.f26515f = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return SNAPSHOTS;
            }
            if (i == 2) {
                return JOURNALS;
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
            return this.f26515f;
        }

        public static e a(String str) {
            return f26512d.get(str);
        }

        @Override // com.umeng.commonsdk.proguard.q
        public short a() {
            return this.f26514e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.f26506a == null) {
            this.f26506a = new HashMap();
        }
        this.f26506a.put(str, bVar);
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.f26507b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f26508c = null;
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.f26506a = map;
    }

    public c(c cVar) {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f26506a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.f26506a = hashMap;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f26507b.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it.next()));
            }
            this.f26507b = arrayList;
        }
        if (cVar.m()) {
            this.f26508c = cVar.f26508c;
        }
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.f26506a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f26506a = null;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.f26507b == null) {
            this.f26507b = new ArrayList();
        }
        this.f26507b.add(aVar);
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f26507b = list;
        return this;
    }

    public c a(String str) {
        this.f26508c = str;
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

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            read(new ac(new au(objectInputStream)));
        } catch (p e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
