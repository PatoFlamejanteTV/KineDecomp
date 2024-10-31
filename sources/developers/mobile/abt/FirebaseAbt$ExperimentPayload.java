package developers.mobile.abt;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes3.dex */
public final class FirebaseAbt$ExperimentPayload extends GeneratedMessageLite<FirebaseAbt$ExperimentPayload, a> implements e {

    /* renamed from: d */
    private static final FirebaseAbt$ExperimentPayload f26723d = new FirebaseAbt$ExperimentPayload();

    /* renamed from: e */
    private static volatile Parser<FirebaseAbt$ExperimentPayload> f26724e;

    /* renamed from: f */
    private int f26725f;
    private long i;
    private long k;
    private long l;
    private int r;

    /* renamed from: g */
    private String f26726g = "";

    /* renamed from: h */
    private String f26727h = "";
    private String j = "";
    private String m = "";
    private String n = "";
    private String o = "";
    private String p = "";
    private String q = "";
    private Internal.ProtobufList<b> s = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes3.dex */
    public enum ExperimentOverflowPolicy implements Internal.EnumLite {
        POLICY_UNSPECIFIED(0),
        DISCARD_OLDEST(1),
        IGNORE_NEWEST(2),
        UNRECOGNIZED(-1);

        public static final int DISCARD_OLDEST_VALUE = 1;
        public static final int IGNORE_NEWEST_VALUE = 2;
        public static final int POLICY_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<ExperimentOverflowPolicy> internalValueMap = new d();
        private final int value;

        ExperimentOverflowPolicy(int i) {
            this.value = i;
        }

        public static ExperimentOverflowPolicy forNumber(int i) {
            if (i == 0) {
                return POLICY_UNSPECIFIED;
            }
            if (i == 1) {
                return DISCARD_OLDEST;
            }
            if (i != 2) {
                return null;
            }
            return IGNORE_NEWEST;
        }

        public static Internal.EnumLiteMap<ExperimentOverflowPolicy> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ExperimentOverflowPolicy valueOf(int i) {
            return forNumber(i);
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes3.dex */
    public static final class a extends GeneratedMessageLite.Builder<FirebaseAbt$ExperimentPayload, a> implements e {
        /* synthetic */ a(developers.mobile.abt.a aVar) {
            this();
        }

        private a() {
            super(FirebaseAbt$ExperimentPayload.f26723d);
        }
    }

    static {
        f26723d.l();
    }

    private FirebaseAbt$ExperimentPayload() {
    }

    public static FirebaseAbt$ExperimentPayload p() {
        return f26723d;
    }

    public static Parser<FirebaseAbt$ExperimentPayload> w() {
        return f26723d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f26726g.isEmpty()) {
            codedOutputStream.b(1, q());
        }
        if (!this.f26727h.isEmpty()) {
            codedOutputStream.b(2, v());
        }
        long j = this.i;
        if (j != 0) {
            codedOutputStream.e(3, j);
        }
        if (!this.j.isEmpty()) {
            codedOutputStream.b(4, t());
        }
        long j2 = this.k;
        if (j2 != 0) {
            codedOutputStream.e(5, j2);
        }
        long j3 = this.l;
        if (j3 != 0) {
            codedOutputStream.e(6, j3);
        }
        if (!this.m.isEmpty()) {
            codedOutputStream.b(7, r());
        }
        if (!this.n.isEmpty()) {
            codedOutputStream.b(8, n());
        }
        if (!this.o.isEmpty()) {
            codedOutputStream.b(9, o());
        }
        if (!this.p.isEmpty()) {
            codedOutputStream.b(10, s());
        }
        if (!this.q.isEmpty()) {
            codedOutputStream.b(11, u());
        }
        if (this.r != ExperimentOverflowPolicy.POLICY_UNSPECIFIED.getNumber()) {
            codedOutputStream.e(12, this.r);
        }
        for (int i = 0; i < this.s.size(); i++) {
            codedOutputStream.c(13, this.s.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f26726g.isEmpty() ? CodedOutputStream.a(1, q()) + 0 : 0;
        if (!this.f26727h.isEmpty()) {
            a2 += CodedOutputStream.a(2, v());
        }
        long j = this.i;
        if (j != 0) {
            a2 += CodedOutputStream.b(3, j);
        }
        if (!this.j.isEmpty()) {
            a2 += CodedOutputStream.a(4, t());
        }
        long j2 = this.k;
        if (j2 != 0) {
            a2 += CodedOutputStream.b(5, j2);
        }
        long j3 = this.l;
        if (j3 != 0) {
            a2 += CodedOutputStream.b(6, j3);
        }
        if (!this.m.isEmpty()) {
            a2 += CodedOutputStream.a(7, r());
        }
        if (!this.n.isEmpty()) {
            a2 += CodedOutputStream.a(8, n());
        }
        if (!this.o.isEmpty()) {
            a2 += CodedOutputStream.a(9, o());
        }
        if (!this.p.isEmpty()) {
            a2 += CodedOutputStream.a(10, s());
        }
        if (!this.q.isEmpty()) {
            a2 += CodedOutputStream.a(11, u());
        }
        if (this.r != ExperimentOverflowPolicy.POLICY_UNSPECIFIED.getNumber()) {
            a2 += CodedOutputStream.a(12, this.r);
        }
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            a2 += CodedOutputStream.a(13, this.s.get(i2));
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.n;
    }

    public String o() {
        return this.o;
    }

    public String q() {
        return this.f26726g;
    }

    public String r() {
        return this.m;
    }

    public String s() {
        return this.p;
    }

    public String t() {
        return this.j;
    }

    public String u() {
        return this.q;
    }

    public String v() {
        return this.f26727h;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (developers.mobile.abt.a.f26728a[methodToInvoke.ordinal()]) {
            case 1:
                return new FirebaseAbt$ExperimentPayload();
            case 2:
                return f26723d;
            case 3:
                this.s.L();
                return null;
            case 4:
                return new a(null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                FirebaseAbt$ExperimentPayload firebaseAbt$ExperimentPayload = (FirebaseAbt$ExperimentPayload) obj2;
                this.f26726g = visitor.a(!this.f26726g.isEmpty(), this.f26726g, !firebaseAbt$ExperimentPayload.f26726g.isEmpty(), firebaseAbt$ExperimentPayload.f26726g);
                this.f26727h = visitor.a(!this.f26727h.isEmpty(), this.f26727h, !firebaseAbt$ExperimentPayload.f26727h.isEmpty(), firebaseAbt$ExperimentPayload.f26727h);
                this.i = visitor.a(this.i != 0, this.i, firebaseAbt$ExperimentPayload.i != 0, firebaseAbt$ExperimentPayload.i);
                this.j = visitor.a(!this.j.isEmpty(), this.j, !firebaseAbt$ExperimentPayload.j.isEmpty(), firebaseAbt$ExperimentPayload.j);
                this.k = visitor.a(this.k != 0, this.k, firebaseAbt$ExperimentPayload.k != 0, firebaseAbt$ExperimentPayload.k);
                this.l = visitor.a(this.l != 0, this.l, firebaseAbt$ExperimentPayload.l != 0, firebaseAbt$ExperimentPayload.l);
                this.m = visitor.a(!this.m.isEmpty(), this.m, !firebaseAbt$ExperimentPayload.m.isEmpty(), firebaseAbt$ExperimentPayload.m);
                this.n = visitor.a(!this.n.isEmpty(), this.n, !firebaseAbt$ExperimentPayload.n.isEmpty(), firebaseAbt$ExperimentPayload.n);
                this.o = visitor.a(!this.o.isEmpty(), this.o, !firebaseAbt$ExperimentPayload.o.isEmpty(), firebaseAbt$ExperimentPayload.o);
                this.p = visitor.a(!this.p.isEmpty(), this.p, !firebaseAbt$ExperimentPayload.p.isEmpty(), firebaseAbt$ExperimentPayload.p);
                this.q = visitor.a(!this.q.isEmpty(), this.q, !firebaseAbt$ExperimentPayload.q.isEmpty(), firebaseAbt$ExperimentPayload.q);
                this.r = visitor.a(this.r != 0, this.r, firebaseAbt$ExperimentPayload.r != 0, firebaseAbt$ExperimentPayload.r);
                this.s = visitor.a(this.s, firebaseAbt$ExperimentPayload.s);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f26725f |= firebaseAbt$ExperimentPayload.f26725f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        switch (x) {
                            case 0:
                                r1 = true;
                            case 10:
                                this.f26726g = codedInputStream.w();
                            case 18:
                                this.f26727h = codedInputStream.w();
                            case 24:
                                this.i = codedInputStream.k();
                            case 34:
                                this.j = codedInputStream.w();
                            case 40:
                                this.k = codedInputStream.k();
                            case 48:
                                this.l = codedInputStream.k();
                            case 58:
                                this.m = codedInputStream.w();
                            case 66:
                                this.n = codedInputStream.w();
                            case 74:
                                this.o = codedInputStream.w();
                            case 82:
                                this.p = codedInputStream.w();
                            case 90:
                                this.q = codedInputStream.w();
                            case 96:
                                this.r = codedInputStream.f();
                            case 106:
                                if (!this.s.M()) {
                                    this.s = GeneratedMessageLite.a(this.s);
                                }
                                this.s.add((b) codedInputStream.a(b.o(), extensionRegistryLite));
                            default:
                                if (!codedInputStream.f(x)) {
                                    r1 = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw new RuntimeException(e2.setUnfinishedMessage(this));
                    } catch (IOException e3) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f26724e == null) {
                    synchronized (FirebaseAbt$ExperimentPayload.class) {
                        if (f26724e == null) {
                            f26724e = new GeneratedMessageLite.DefaultInstanceBasedParser(f26723d);
                        }
                    }
                }
                return f26724e;
            default:
                throw new UnsupportedOperationException();
        }
        return f26723d;
    }
}
