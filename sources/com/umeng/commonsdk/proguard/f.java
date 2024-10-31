package com.umeng.commonsdk.proguard;

import com.facebook.internal.ServerProtocol;
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

/* compiled from: UMEnvelope.java */
/* loaded from: classes3.dex */
public class f implements j<f, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;
    public static final Map<e, v> k;
    private static final long l = 420342210744516016L;
    private static final an m = new an("UMEnvelope");
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
    public String f26242a;

    /* renamed from: b, reason: collision with root package name */
    public String f26243b;

    /* renamed from: c, reason: collision with root package name */
    public String f26244c;

    /* renamed from: d, reason: collision with root package name */
    public int f26245d;

    /* renamed from: e, reason: collision with root package name */
    public int f26246e;

    /* renamed from: f, reason: collision with root package name */
    public int f26247f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f26248g;

    /* renamed from: h, reason: collision with root package name */
    public String f26249h;
    public String i;
    public int j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UMEnvelope.java */
    /* loaded from: classes3.dex */
    public static class a extends as<f> {
        private a() {
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ai aiVar, f fVar) throws p {
            aiVar.j();
            while (true) {
                ad l = aiVar.l();
                byte b2 = l.f26172b;
                if (b2 == 0) {
                    aiVar.k();
                    if (fVar.m()) {
                        if (fVar.p()) {
                            if (fVar.s()) {
                                fVar.G();
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
                            fVar.f26242a = aiVar.z();
                            fVar.a(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 2:
                        if (b2 == 11) {
                            fVar.f26243b = aiVar.z();
                            fVar.b(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 3:
                        if (b2 == 11) {
                            fVar.f26244c = aiVar.z();
                            fVar.c(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 4:
                        if (b2 == 8) {
                            fVar.f26245d = aiVar.w();
                            fVar.d(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 5:
                        if (b2 == 8) {
                            fVar.f26246e = aiVar.w();
                            fVar.e(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 6:
                        if (b2 == 8) {
                            fVar.f26247f = aiVar.w();
                            fVar.f(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 7:
                        if (b2 == 11) {
                            fVar.f26248g = aiVar.A();
                            fVar.g(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 8:
                        if (b2 == 11) {
                            fVar.f26249h = aiVar.z();
                            fVar.h(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 9:
                        if (b2 == 11) {
                            fVar.i = aiVar.z();
                            fVar.i(true);
                            break;
                        } else {
                            al.a(aiVar, b2);
                            break;
                        }
                    case 10:
                        if (b2 == 8) {
                            fVar.j = aiVar.w();
                            fVar.j(true);
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
        public void a(ai aiVar, f fVar) throws p {
            fVar.G();
            aiVar.a(f.m);
            if (fVar.f26242a != null) {
                aiVar.a(f.n);
                aiVar.a(fVar.f26242a);
                aiVar.c();
            }
            if (fVar.f26243b != null) {
                aiVar.a(f.o);
                aiVar.a(fVar.f26243b);
                aiVar.c();
            }
            if (fVar.f26244c != null) {
                aiVar.a(f.p);
                aiVar.a(fVar.f26244c);
                aiVar.c();
            }
            aiVar.a(f.q);
            aiVar.a(fVar.f26245d);
            aiVar.c();
            aiVar.a(f.r);
            aiVar.a(fVar.f26246e);
            aiVar.c();
            aiVar.a(f.s);
            aiVar.a(fVar.f26247f);
            aiVar.c();
            if (fVar.f26248g != null) {
                aiVar.a(f.t);
                aiVar.a(fVar.f26248g);
                aiVar.c();
            }
            if (fVar.f26249h != null) {
                aiVar.a(f.u);
                aiVar.a(fVar.f26249h);
                aiVar.c();
            }
            if (fVar.i != null) {
                aiVar.a(f.v);
                aiVar.a(fVar.i);
                aiVar.c();
            }
            if (fVar.F()) {
                aiVar.a(f.w);
                aiVar.a(fVar.j);
                aiVar.c();
            }
            aiVar.d();
            aiVar.b();
        }
    }

    /* compiled from: UMEnvelope.java */
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
    /* compiled from: UMEnvelope.java */
    /* loaded from: classes3.dex */
    public static class c extends at<f> {
        private c() {
        }

        @Override // com.umeng.commonsdk.proguard.aq
        public void a(ai aiVar, f fVar) throws p {
            ao aoVar = (ao) aiVar;
            aoVar.a(fVar.f26242a);
            aoVar.a(fVar.f26243b);
            aoVar.a(fVar.f26244c);
            aoVar.a(fVar.f26245d);
            aoVar.a(fVar.f26246e);
            aoVar.a(fVar.f26247f);
            aoVar.a(fVar.f26248g);
            aoVar.a(fVar.f26249h);
            aoVar.a(fVar.i);
            BitSet bitSet = new BitSet();
            if (fVar.F()) {
                bitSet.set(0);
            }
            aoVar.a(bitSet, 1);
            if (fVar.F()) {
                aoVar.a(fVar.j);
            }
        }

        @Override // com.umeng.commonsdk.proguard.aq
        public void b(ai aiVar, f fVar) throws p {
            ao aoVar = (ao) aiVar;
            fVar.f26242a = aoVar.z();
            fVar.a(true);
            fVar.f26243b = aoVar.z();
            fVar.b(true);
            fVar.f26244c = aoVar.z();
            fVar.c(true);
            fVar.f26245d = aoVar.w();
            fVar.d(true);
            fVar.f26246e = aoVar.w();
            fVar.e(true);
            fVar.f26247f = aoVar.w();
            fVar.f(true);
            fVar.f26248g = aoVar.A();
            fVar.g(true);
            fVar.f26249h = aoVar.z();
            fVar.h(true);
            fVar.i = aoVar.z();
            fVar.i(true);
            if (aoVar.b(1).get(0)) {
                fVar.j = aoVar.w();
                fVar.j(true);
            }
        }
    }

    /* compiled from: UMEnvelope.java */
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
        x.put(as.class, new b());
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
        v.a(f.class, k);
    }

    public f() {
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
        if (this.f26242a != null) {
            if (this.f26243b != null) {
                if (this.f26244c != null) {
                    if (this.f26248g != null) {
                        if (this.f26249h != null) {
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
    public f deepCopy() {
        return new f(this);
    }

    public String b() {
        return this.f26242a;
    }

    public void c() {
        this.f26242a = null;
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void clear() {
        this.f26242a = null;
        this.f26243b = null;
        this.f26244c = null;
        d(false);
        this.f26245d = 0;
        e(false);
        this.f26246e = 0;
        f(false);
        this.f26247f = 0;
        this.f26248g = null;
        this.f26249h = null;
        this.i = null;
        j(false);
        this.j = 0;
    }

    public boolean d() {
        return this.f26242a != null;
    }

    public String e() {
        return this.f26243b;
    }

    public void f() {
        this.f26243b = null;
    }

    public boolean g() {
        return this.f26243b != null;
    }

    public String h() {
        return this.f26244c;
    }

    public void i() {
        this.f26244c = null;
    }

    public boolean j() {
        return this.f26244c != null;
    }

    public int k() {
        return this.f26245d;
    }

    public void l() {
        this.C = g.b(this.C, 0);
    }

    public boolean m() {
        return g.a(this.C, 0);
    }

    public int n() {
        return this.f26246e;
    }

    public void o() {
        this.C = g.b(this.C, 1);
    }

    public boolean p() {
        return g.a(this.C, 1);
    }

    public int q() {
        return this.f26247f;
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
        a(k.c(this.f26248g));
        ByteBuffer byteBuffer = this.f26248g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f26242a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f26243b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f26244c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f26245d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f26246e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f26247f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f26248g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            k.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f26249h;
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
        return this.f26248g;
    }

    public void v() {
        this.f26248g = null;
    }

    public boolean w() {
        return this.f26248g != null;
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void write(ai aiVar) throws p {
        x.get(aiVar.D()).b().a(aiVar, this);
    }

    public String x() {
        return this.f26249h;
    }

    public void y() {
        this.f26249h = null;
    }

    public boolean z() {
        return this.f26249h != null;
    }

    /* compiled from: UMEnvelope.java */
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

    public f a(String str) {
        this.f26242a = str;
        return this;
    }

    public f b(String str) {
        this.f26243b = str;
        return this;
    }

    public f c(String str) {
        this.f26244c = str;
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
        this.f26248g = null;
    }

    public void h(boolean z2) {
        if (z2) {
            return;
        }
        this.f26249h = null;
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
        this.f26242a = null;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.f26243b = null;
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.f26244c = null;
    }

    public f d(String str) {
        this.f26249h = str;
        return this;
    }

    public f e(String str) {
        this.i = str;
        return this;
    }

    public f(String str, String str2, String str3, int i, int i2, int i3, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f26242a = str;
        this.f26243b = str2;
        this.f26244c = str3;
        this.f26245d = i;
        d(true);
        this.f26246e = i2;
        e(true);
        this.f26247f = i3;
        f(true);
        this.f26248g = byteBuffer;
        this.f26249h = str4;
        this.i = str5;
    }

    public f a(int i) {
        this.f26245d = i;
        d(true);
        return this;
    }

    public f b(int i) {
        this.f26246e = i;
        e(true);
        return this;
    }

    public f c(int i) {
        this.f26247f = i;
        f(true);
        return this;
    }

    public f d(int i) {
        this.j = i;
        j(true);
        return this;
    }

    @Override // com.umeng.commonsdk.proguard.j
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i) {
        return e.a(i);
    }

    public f a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public f a(ByteBuffer byteBuffer) {
        this.f26248g = byteBuffer;
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

    public f(f fVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = fVar.C;
        if (fVar.d()) {
            this.f26242a = fVar.f26242a;
        }
        if (fVar.g()) {
            this.f26243b = fVar.f26243b;
        }
        if (fVar.j()) {
            this.f26244c = fVar.f26244c;
        }
        this.f26245d = fVar.f26245d;
        this.f26246e = fVar.f26246e;
        this.f26247f = fVar.f26247f;
        if (fVar.w()) {
            this.f26248g = k.d(fVar.f26248g);
        }
        if (fVar.z()) {
            this.f26249h = fVar.f26249h;
        }
        if (fVar.C()) {
            this.i = fVar.i;
        }
        this.j = fVar.j;
    }
}
