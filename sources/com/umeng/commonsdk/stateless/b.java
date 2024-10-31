package com.umeng.commonsdk.stateless;

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
import com.umeng.commonsdk.proguard.k;
import com.umeng.commonsdk.proguard.p;
import com.umeng.commonsdk.proguard.q;
import com.umeng.commonsdk.proguard.v;
import com.umeng.commonsdk.proguard.w;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: UMSLEnvelope.java */
/* loaded from: classes3.dex */
public class b implements j<b, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;
    public static final Map<e, v> k;
    private static final long l = 420342210744516016L;
    private static final an m = new an("UMSLEnvelope");
    private static final ad n = new ad(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, (byte) 11, 1);
    private static final ad o = new ad("address", (byte) 11, 2);
    private static final ad p = new ad("signature", (byte) 11, 3);
    private static final ad q = new ad("serial_num", (byte) 8, 4);
    private static final ad r = new ad("ts_secs", (byte) 8, 5);
    private static final ad s = new ad("length", (byte) 8, 6);
    private static final ad t = new ad("entity", (byte) 11, 7);
    private static final ad u = new ad("guid", (byte) 11, 8);
    private static final ad v = new ad("checksum", (byte) 11, 9);
    private static final ad w = new ad("codex", (byte) 8, 10);
    private static final Map<Class<? extends aq>, ar> x = new HashMap();
    private static final int y = 0;
    private static final int z = 1;
    private byte C;
    private e[] D;

    /* renamed from: a, reason: collision with root package name */
    public String f26311a;

    /* renamed from: b, reason: collision with root package name */
    public String f26312b;

    /* renamed from: c, reason: collision with root package name */
    public String f26313c;

    /* renamed from: d, reason: collision with root package name */
    public int f26314d;

    /* renamed from: e, reason: collision with root package name */
    public int f26315e;

    /* renamed from: f, reason: collision with root package name */
    public int f26316f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f26317g;

    /* renamed from: h, reason: collision with root package name */
    public String f26318h;
    public String i;
    public int j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UMSLEnvelope.java */
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
                    aiVar.k();
                    if (bVar.m()) {
                        if (bVar.p()) {
                            if (bVar.s()) {
                                bVar.G();
                                return;
                            }
                            throw new aj("Required field 'length' was not found in serialized data! Struct: " + toString());
                        }
                        throw new aj("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    throw new aj("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                }
                switch (l.f26173c) {
                    case 1:
                        if (b2 == 11) {
                            bVar.f26311a = aiVar.z();
                            bVar.a(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 2:
                        if (b2 == 11) {
                            bVar.f26312b = aiVar.z();
                            bVar.b(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 3:
                        if (b2 == 11) {
                            bVar.f26313c = aiVar.z();
                            bVar.c(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 4:
                        if (b2 == 8) {
                            bVar.f26314d = aiVar.w();
                            bVar.d(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 5:
                        if (b2 == 8) {
                            bVar.f26315e = aiVar.w();
                            bVar.e(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 6:
                        if (b2 == 8) {
                            bVar.f26316f = aiVar.w();
                            bVar.f(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 7:
                        if (b2 == 11) {
                            bVar.f26317g = aiVar.A();
                            bVar.g(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 8:
                        if (b2 == 11) {
                            bVar.f26318h = aiVar.z();
                            bVar.h(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 9:
                        if (b2 == 11) {
                            bVar.i = aiVar.z();
                            bVar.i(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 10:
                        if (b2 == 8) {
                            bVar.j = aiVar.w();
                            bVar.j(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    default:
                        al.a(aiVar, b2);
                        break;
                }
                aiVar.m();
            }
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ai aiVar, b bVar) throws p {
            bVar.G();
            aiVar.a(b.m);
            if (bVar.f26311a != null) {
                aiVar.a(b.n);
                aiVar.a(bVar.f26311a);
                aiVar.c();
            }
            if (bVar.f26312b != null) {
                aiVar.a(b.o);
                aiVar.a(bVar.f26312b);
                aiVar.c();
            }
            if (bVar.f26313c != null) {
                aiVar.a(b.p);
                aiVar.a(bVar.f26313c);
                aiVar.c();
            }
            aiVar.a(b.q);
            aiVar.a(bVar.f26314d);
            aiVar.c();
            aiVar.a(b.r);
            aiVar.a(bVar.f26315e);
            aiVar.c();
            aiVar.a(b.s);
            aiVar.a(bVar.f26316f);
            aiVar.c();
            if (bVar.f26317g != null) {
                aiVar.a(b.t);
                aiVar.a(bVar.f26317g);
                aiVar.c();
            }
            if (bVar.f26318h != null) {
                aiVar.a(b.u);
                aiVar.a(bVar.f26318h);
                aiVar.c();
            }
            if (bVar.i != null) {
                aiVar.a(b.v);
                aiVar.a(bVar.i);
                aiVar.c();
            }
            if (bVar.F()) {
                aiVar.a(b.w);
                aiVar.a(bVar.j);
                aiVar.c();
            }
            aiVar.d();
            aiVar.b();
        }
    }

    /* compiled from: UMSLEnvelope.java */
    /* renamed from: com.umeng.commonsdk.stateless.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0143b implements ar {
        private C0143b() {
        }

        @Override // com.umeng.commonsdk.proguard.ar
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UMSLEnvelope.java */
    /* loaded from: classes3.dex */
    public static class c extends at<b> {
        private c() {
        }

        @Override // com.umeng.commonsdk.proguard.aq
        public void a(ai aiVar, b bVar) throws p {
            ao aoVar = (ao) aiVar;
            aoVar.a(bVar.f26311a);
            aoVar.a(bVar.f26312b);
            aoVar.a(bVar.f26313c);
            aoVar.a(bVar.f26314d);
            aoVar.a(bVar.f26315e);
            aoVar.a(bVar.f26316f);
            aoVar.a(bVar.f26317g);
            aoVar.a(bVar.f26318h);
            aoVar.a(bVar.i);
            BitSet bitSet = new BitSet();
            if (bVar.F()) {
                bitSet.set(0);
            }
            aoVar.a(bitSet, 1);
            if (bVar.F()) {
                aoVar.a(bVar.j);
            }
        }

        @Override // com.umeng.commonsdk.proguard.aq
        public void b(ai aiVar, b bVar) throws p {
            ao aoVar = (ao) aiVar;
            bVar.f26311a = aoVar.z();
            bVar.a(true);
            bVar.f26312b = aoVar.z();
            bVar.b(true);
            bVar.f26313c = aoVar.z();
            bVar.c(true);
            bVar.f26314d = aoVar.w();
            bVar.d(true);
            bVar.f26315e = aoVar.w();
            bVar.e(true);
            bVar.f26316f = aoVar.w();
            bVar.f(true);
            bVar.f26317g = aoVar.A();
            bVar.g(true);
            bVar.f26318h = aoVar.z();
            bVar.h(true);
            bVar.i = aoVar.z();
            bVar.i(true);
            if (aoVar.b(1).get(0)) {
                bVar.j = aoVar.w();
                bVar.j(true);
            }
        }
    }

    /* compiled from: UMSLEnvelope.java */
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
        x.put(as.class, new C0143b());
        x.put(at.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.VERSION, (e) new v(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, (byte) 1, new w((byte) 11)));
        enumMap.put((EnumMap) e.ADDRESS, (e) new v("address", (byte) 1, new w((byte) 11)));
        enumMap.put((EnumMap) e.SIGNATURE, (e) new v("signature", (byte) 1, new w((byte) 11)));
        enumMap.put((EnumMap) e.SERIAL_NUM, (e) new v("serial_num", (byte) 1, new w((byte) 8)));
        enumMap.put((EnumMap) e.TS_SECS, (e) new v("ts_secs", (byte) 1, new w((byte) 8)));
        enumMap.put((EnumMap) e.LENGTH, (e) new v("length", (byte) 1, new w((byte) 8)));
        enumMap.put((EnumMap) e.ENTITY, (e) new v("entity", (byte) 1, new w((byte) 11, true)));
        enumMap.put((EnumMap) e.GUID, (e) new v("guid", (byte) 1, new w((byte) 11)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new v("checksum", (byte) 1, new w((byte) 11)));
        enumMap.put((EnumMap) e.CODEX, (e) new v("codex", (byte) 2, new w((byte) 8)));
        k = Collections.unmodifiableMap(enumMap);
        v.a(b.class, k);
    }

    public b() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public String A() {
        return this.i;
    }

    public void B() {
        this.i = null;
    }

    public boolean C() {
        return this.i != null;
    }

    public int D() {
        return this.j;
    }

    public void E() {
        this.C = g.b(this.C, 3);
    }

    public boolean F() {
        return g.a(this.C, 3);
    }

    public void G() throws p {
        if (this.f26311a != null) {
            if (this.f26312b != null) {
                if (this.f26313c != null) {
                    if (this.f26317g != null) {
                        if (this.f26318h != null) {
                            if (this.i != null) {
                                return;
                            }
                            throw new aj("Required field 'checksum' was not present! Struct: " + toString());
                        }
                        throw new aj("Required field 'guid' was not present! Struct: " + toString());
                    }
                    throw new aj("Required field 'entity' was not present! Struct: " + toString());
                }
                throw new aj("Required field 'signature' was not present! Struct: " + toString());
            }
            throw new aj("Required field 'address' was not present! Struct: " + toString());
        }
        throw new aj("Required field 'version' was not present! Struct: " + toString());
    }

    @Override // com.umeng.commonsdk.proguard.j
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.f26311a;
    }

    public void c() {
        this.f26311a = null;
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void clear() {
        this.f26311a = null;
        this.f26312b = null;
        this.f26313c = null;
        d(false);
        this.f26314d = 0;
        e(false);
        this.f26315e = 0;
        f(false);
        this.f26316f = 0;
        this.f26317g = null;
        this.f26318h = null;
        this.i = null;
        j(false);
        this.j = 0;
    }

    public boolean d() {
        return this.f26311a != null;
    }

    public String e() {
        return this.f26312b;
    }

    public void f() {
        this.f26312b = null;
    }

    public boolean g() {
        return this.f26312b != null;
    }

    public String h() {
        return this.f26313c;
    }

    public void i() {
        this.f26313c = null;
    }

    public boolean j() {
        return this.f26313c != null;
    }

    public int k() {
        return this.f26314d;
    }

    public void l() {
        this.C = g.b(this.C, 0);
    }

    public boolean m() {
        return g.a(this.C, 0);
    }

    public int n() {
        return this.f26315e;
    }

    public void o() {
        this.C = g.b(this.C, 1);
    }

    public boolean p() {
        return g.a(this.C, 1);
    }

    public int q() {
        return this.f26316f;
    }

    public void r() {
        this.C = g.b(this.C, 2);
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void read(ai aiVar) throws p {
        x.get(aiVar.D()).b().b(aiVar, this);
    }

    public boolean s() {
        return g.a(this.C, 2);
    }

    public byte[] t() {
        a(k.c(this.f26317g));
        ByteBuffer byteBuffer = this.f26317g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMSLEnvelope(");
        sb.append("version:");
        String str = this.f26311a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f26312b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f26313c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f26314d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f26315e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f26316f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f26317g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            k.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f26318h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }

    public ByteBuffer u() {
        return this.f26317g;
    }

    public void v() {
        this.f26317g = null;
    }

    public boolean w() {
        return this.f26317g != null;
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void write(ai aiVar) throws p {
        x.get(aiVar.D()).b().a(aiVar, this);
    }

    public String x() {
        return this.f26318h;
    }

    public void y() {
        this.f26318h = null;
    }

    public boolean z() {
        return this.f26318h != null;
    }

    /* compiled from: UMSLEnvelope.java */
    /* loaded from: classes3.dex */
    public enum e implements q {
        VERSION(1, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION),
        ADDRESS(2, "address"),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");

        private static final Map<String, e> k = new HashMap();
        private final short l;
        private final String m;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                k.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.l = s;
            this.m = str;
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
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
            return this.m;
        }

        public static e a(String str) {
            return k.get(str);
        }

        @Override // com.umeng.commonsdk.proguard.q
        public short a() {
            return this.l;
        }
    }

    public b a(String str) {
        this.f26311a = str;
        return this;
    }

    public b b(String str) {
        this.f26312b = str;
        return this;
    }

    public b c(String str) {
        this.f26313c = str;
        return this;
    }

    public void d(boolean z2) {
        this.C = g.a(this.C, 0, z2);
    }

    public void e(boolean z2) {
        this.C = g.a(this.C, 1, z2);
    }

    public void f(boolean z2) {
        this.C = g.a(this.C, 2, z2);
    }

    public void g(boolean z2) {
        if (z2) {
            return;
        }
        this.f26317g = null;
    }

    public void h(boolean z2) {
        if (z2) {
            return;
        }
        this.f26318h = null;
    }

    public void i(boolean z2) {
        if (z2) {
            return;
        }
        this.i = null;
    }

    public void j(boolean z2) {
        this.C = g.a(this.C, 3, z2);
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.f26311a = null;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.f26312b = null;
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.f26313c = null;
    }

    public b d(String str) {
        this.f26318h = str;
        return this;
    }

    public b e(String str) {
        this.i = str;
        return this;
    }

    public b(String str, String str2, String str3, int i, int i2, int i3, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f26311a = str;
        this.f26312b = str2;
        this.f26313c = str3;
        this.f26314d = i;
        d(true);
        this.f26315e = i2;
        e(true);
        this.f26316f = i3;
        f(true);
        this.f26317g = byteBuffer;
        this.f26318h = str4;
        this.i = str5;
    }

    public b a(int i) {
        this.f26314d = i;
        d(true);
        return this;
    }

    public b b(int i) {
        this.f26315e = i;
        e(true);
        return this;
    }

    public b c(int i) {
        this.f26316f = i;
        f(true);
        return this;
    }

    public b d(int i) {
        this.j = i;
        j(true);
        return this;
    }

    @Override // com.umeng.commonsdk.proguard.j
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i) {
        return e.a(i);
    }

    public b a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public b a(ByteBuffer byteBuffer) {
        this.f26317g = byteBuffer;
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
            this.C = (byte) 0;
            read(new ac(new au(objectInputStream)));
        } catch (p e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public b(b bVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = bVar.C;
        if (bVar.d()) {
            this.f26311a = bVar.f26311a;
        }
        if (bVar.g()) {
            this.f26312b = bVar.f26312b;
        }
        if (bVar.j()) {
            this.f26313c = bVar.f26313c;
        }
        this.f26314d = bVar.f26314d;
        this.f26315e = bVar.f26315e;
        this.f26316f = bVar.f26316f;
        if (bVar.w()) {
            this.f26317g = k.d(bVar.f26317g);
        }
        if (bVar.z()) {
            this.f26318h = bVar.f26318h;
        }
        if (bVar.C()) {
            this.i = bVar.i;
        }
        this.j = bVar.j;
    }
}
