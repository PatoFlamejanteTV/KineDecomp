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

/* compiled from: ImprintValue.java */
/* loaded from: classes3.dex */
public class e implements j<e, EnumC0150e>, Serializable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<EnumC0150e, v> f26531d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f26532e = 7501688097813630241L;

    /* renamed from: f, reason: collision with root package name */
    private static final an f26533f = new an("ImprintValue");

    /* renamed from: g, reason: collision with root package name */
    private static final ad f26534g = new ad("value", (byte) 11, 1);

    /* renamed from: h, reason: collision with root package name */
    private static final ad f26535h = new ad("ts", (byte) 10, 2);
    private static final ad i = new ad("guid", (byte) 11, 3);
    private static final Map<Class<? extends aq>, ar> j = new HashMap();
    private static final int k = 0;

    /* renamed from: a, reason: collision with root package name */
    public String f26536a;

    /* renamed from: b, reason: collision with root package name */
    public long f26537b;

    /* renamed from: c, reason: collision with root package name */
    public String f26538c;
    private byte l;
    private EnumC0150e[] m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImprintValue.java */
    /* loaded from: classes3.dex */
    public static class a extends as<e> {
        private a() {
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ai aiVar, e eVar) throws p {
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
                            eVar.f26538c = aiVar.z();
                            eVar.c(true);
                        } else {
                            al.a(aiVar, b2);
                        }
                    } else if (b2 == 10) {
                        eVar.f26537b = aiVar.x();
                        eVar.b(true);
                    } else {
                        al.a(aiVar, b2);
                    }
                } else if (b2 == 11) {
                    eVar.f26536a = aiVar.z();
                    eVar.a(true);
                } else {
                    al.a(aiVar, b2);
                }
                aiVar.m();
            }
            aiVar.k();
            if (eVar.g()) {
                eVar.k();
                return;
            }
            throw new aj("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ai aiVar, e eVar) throws p {
            eVar.k();
            aiVar.a(e.f26533f);
            if (eVar.f26536a != null && eVar.d()) {
                aiVar.a(e.f26534g);
                aiVar.a(eVar.f26536a);
                aiVar.c();
            }
            aiVar.a(e.f26535h);
            aiVar.a(eVar.f26537b);
            aiVar.c();
            if (eVar.f26538c != null) {
                aiVar.a(e.i);
                aiVar.a(eVar.f26538c);
                aiVar.c();
            }
            aiVar.d();
            aiVar.b();
        }
    }

    /* compiled from: ImprintValue.java */
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
    /* compiled from: ImprintValue.java */
    /* loaded from: classes3.dex */
    public static class c extends at<e> {
        private c() {
        }

        @Override // com.umeng.commonsdk.proguard.aq
        public void a(ai aiVar, e eVar) throws p {
            ao aoVar = (ao) aiVar;
            aoVar.a(eVar.f26537b);
            aoVar.a(eVar.f26538c);
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            aoVar.a(bitSet, 1);
            if (eVar.d()) {
                aoVar.a(eVar.f26536a);
            }
        }

        @Override // com.umeng.commonsdk.proguard.aq
        public void b(ai aiVar, e eVar) throws p {
            ao aoVar = (ao) aiVar;
            eVar.f26537b = aoVar.x();
            eVar.b(true);
            eVar.f26538c = aoVar.z();
            eVar.c(true);
            if (aoVar.b(1).get(0)) {
                eVar.f26536a = aoVar.z();
                eVar.a(true);
            }
        }
    }

    /* compiled from: ImprintValue.java */
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
        j.put(as.class, new b());
        j.put(at.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0150e.class);
        enumMap.put((EnumMap) EnumC0150e.VALUE, (EnumC0150e) new v("value", (byte) 2, new w((byte) 11)));
        enumMap.put((EnumMap) EnumC0150e.TS, (EnumC0150e) new v("ts", (byte) 1, new w((byte) 10)));
        enumMap.put((EnumMap) EnumC0150e.GUID, (EnumC0150e) new v("guid", (byte) 1, new w((byte) 11)));
        f26531d = Collections.unmodifiableMap(enumMap);
        v.a(e.class, f26531d);
    }

    public e() {
        this.l = (byte) 0;
        this.m = new EnumC0150e[]{EnumC0150e.VALUE};
    }

    @Override // com.umeng.commonsdk.proguard.j
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e deepCopy() {
        return new e(this);
    }

    public String b() {
        return this.f26536a;
    }

    public void c() {
        this.f26536a = null;
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void clear() {
        this.f26536a = null;
        b(false);
        this.f26537b = 0L;
        this.f26538c = null;
    }

    public boolean d() {
        return this.f26536a != null;
    }

    public long e() {
        return this.f26537b;
    }

    public void f() {
        this.l = g.b(this.l, 0);
    }

    public boolean g() {
        return g.a(this.l, 0);
    }

    public String h() {
        return this.f26538c;
    }

    public void i() {
        this.f26538c = null;
    }

    public boolean j() {
        return this.f26538c != null;
    }

    public void k() throws p {
        if (this.f26538c != null) {
            return;
        }
        throw new aj("Required field 'guid' was not present! Struct: " + toString());
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void read(ai aiVar) throws p {
        j.get(aiVar.D()).b().b(aiVar, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.f26536a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f26537b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f26538c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void write(ai aiVar) throws p {
        j.get(aiVar.D()).b().a(aiVar, this);
    }

    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public enum EnumC0150e implements q {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, EnumC0150e> f26542d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f26544e;

        /* renamed from: f, reason: collision with root package name */
        private final String f26545f;

        static {
            Iterator it = EnumSet.allOf(EnumC0150e.class).iterator();
            while (it.hasNext()) {
                EnumC0150e enumC0150e = (EnumC0150e) it.next();
                f26542d.put(enumC0150e.b(), enumC0150e);
            }
        }

        EnumC0150e(short s, String str) {
            this.f26544e = s;
            this.f26545f = str;
        }

        public static EnumC0150e a(int i) {
            if (i == 1) {
                return VALUE;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0150e b(int i) {
            EnumC0150e a2 = a(i);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.commonsdk.proguard.q
        public String b() {
            return this.f26545f;
        }

        public static EnumC0150e a(String str) {
            return f26542d.get(str);
        }

        @Override // com.umeng.commonsdk.proguard.q
        public short a() {
            return this.f26544e;
        }
    }

    public e a(String str) {
        this.f26536a = str;
        return this;
    }

    public void b(boolean z) {
        this.l = g.a(this.l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f26538c = null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f26536a = null;
    }

    public e b(String str) {
        this.f26538c = str;
        return this;
    }

    public e(long j2, String str) {
        this();
        this.f26537b = j2;
        b(true);
        this.f26538c = str;
    }

    public e a(long j2) {
        this.f26537b = j2;
        b(true);
        return this;
    }

    @Override // com.umeng.commonsdk.proguard.j
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC0150e fieldForId(int i2) {
        return EnumC0150e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new ac(new au(objectOutputStream)));
        } catch (p e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public e(e eVar) {
        this.l = (byte) 0;
        this.m = new EnumC0150e[]{EnumC0150e.VALUE};
        this.l = eVar.l;
        if (eVar.d()) {
            this.f26536a = eVar.f26536a;
        }
        this.f26537b = eVar.f26537b;
        if (eVar.j()) {
            this.f26538c = eVar.f26538c;
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
