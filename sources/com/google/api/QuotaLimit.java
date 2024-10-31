package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class QuotaLimit extends GeneratedMessageLite<QuotaLimit, Builder> implements QuotaLimitOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final QuotaLimit f14533d = new QuotaLimit();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<QuotaLimit> f14534e;

    /* renamed from: f, reason: collision with root package name */
    private int f14535f;
    private long i;
    private long j;
    private long k;
    private MapFieldLite<String, Long> o = MapFieldLite.emptyMapField();

    /* renamed from: g, reason: collision with root package name */
    private String f14536g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f14537h = "";
    private String l = "";
    private String m = "";
    private String n = "";
    private String p = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<QuotaLimit, Builder> implements QuotaLimitOrBuilder {
        /* synthetic */ Builder(P p) {
            this();
        }

        private Builder() {
            super(QuotaLimit.f14533d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final MapEntryLite<String, Long> f14538a = MapEntryLite.a(WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, 0L);
    }

    static {
        f14533d.l();
    }

    private QuotaLimit() {
    }

    public static Parser<QuotaLimit> t() {
        return f14533d.f();
    }

    private MapFieldLite<String, Long> u() {
        return this.o;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14537h.isEmpty()) {
            codedOutputStream.b(2, n());
        }
        long j = this.i;
        if (j != 0) {
            codedOutputStream.e(3, j);
        }
        long j2 = this.j;
        if (j2 != 0) {
            codedOutputStream.e(4, j2);
        }
        if (!this.l.isEmpty()) {
            codedOutputStream.b(5, p());
        }
        if (!this.f14536g.isEmpty()) {
            codedOutputStream.b(6, r());
        }
        long j3 = this.k;
        if (j3 != 0) {
            codedOutputStream.e(7, j3);
        }
        if (!this.m.isEmpty()) {
            codedOutputStream.b(8, q());
        }
        if (!this.n.isEmpty()) {
            codedOutputStream.b(9, s());
        }
        for (Map.Entry<String, Long> entry : u().entrySet()) {
            a.f14538a.a(codedOutputStream, 10, (int) entry.getKey(), (String) entry.getValue());
        }
        if (this.p.isEmpty()) {
            return;
        }
        codedOutputStream.b(12, o());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f14537h.isEmpty() ? 0 : 0 + CodedOutputStream.a(2, n());
        long j = this.i;
        if (j != 0) {
            a2 += CodedOutputStream.b(3, j);
        }
        long j2 = this.j;
        if (j2 != 0) {
            a2 += CodedOutputStream.b(4, j2);
        }
        if (!this.l.isEmpty()) {
            a2 += CodedOutputStream.a(5, p());
        }
        if (!this.f14536g.isEmpty()) {
            a2 += CodedOutputStream.a(6, r());
        }
        long j3 = this.k;
        if (j3 != 0) {
            a2 += CodedOutputStream.b(7, j3);
        }
        if (!this.m.isEmpty()) {
            a2 += CodedOutputStream.a(8, q());
        }
        if (!this.n.isEmpty()) {
            a2 += CodedOutputStream.a(9, s());
        }
        for (Map.Entry<String, Long> entry : u().entrySet()) {
            a2 += a.f14538a.a(10, (int) entry.getKey(), (String) entry.getValue());
        }
        if (!this.p.isEmpty()) {
            a2 += CodedOutputStream.a(12, o());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14537h;
    }

    public String o() {
        return this.p;
    }

    public String p() {
        return this.l;
    }

    public String q() {
        return this.m;
    }

    public String r() {
        return this.f14536g;
    }

    public String s() {
        return this.n;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        P p = null;
        boolean z = false;
        switch (P.f14514a[methodToInvoke.ordinal()]) {
            case 1:
                return new QuotaLimit();
            case 2:
                return f14533d;
            case 3:
                this.o.makeImmutable();
                return null;
            case 4:
                return new Builder(p);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                QuotaLimit quotaLimit = (QuotaLimit) obj2;
                this.f14536g = visitor.a(!this.f14536g.isEmpty(), this.f14536g, !quotaLimit.f14536g.isEmpty(), quotaLimit.f14536g);
                this.f14537h = visitor.a(!this.f14537h.isEmpty(), this.f14537h, !quotaLimit.f14537h.isEmpty(), quotaLimit.f14537h);
                this.i = visitor.a(this.i != 0, this.i, quotaLimit.i != 0, quotaLimit.i);
                this.j = visitor.a(this.j != 0, this.j, quotaLimit.j != 0, quotaLimit.j);
                this.k = visitor.a(this.k != 0, this.k, quotaLimit.k != 0, quotaLimit.k);
                this.l = visitor.a(!this.l.isEmpty(), this.l, !quotaLimit.l.isEmpty(), quotaLimit.l);
                this.m = visitor.a(!this.m.isEmpty(), this.m, !quotaLimit.m.isEmpty(), quotaLimit.m);
                this.n = visitor.a(!this.n.isEmpty(), this.n, !quotaLimit.n.isEmpty(), quotaLimit.n);
                this.o = visitor.a(this.o, quotaLimit.u());
                this.p = visitor.a(!this.p.isEmpty(), this.p, !quotaLimit.p.isEmpty(), quotaLimit.p);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14535f |= quotaLimit.f14535f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        switch (x) {
                            case 0:
                                z = true;
                            case 18:
                                this.f14537h = codedInputStream.w();
                            case 24:
                                this.i = codedInputStream.k();
                            case 32:
                                this.j = codedInputStream.k();
                            case 42:
                                this.l = codedInputStream.w();
                            case 50:
                                this.f14536g = codedInputStream.w();
                            case 56:
                                this.k = codedInputStream.k();
                            case 66:
                                this.m = codedInputStream.w();
                            case 74:
                                this.n = codedInputStream.w();
                            case 82:
                                if (!this.o.isMutable()) {
                                    this.o = this.o.mutableCopy();
                                }
                                a.f14538a.a(this.o, codedInputStream, extensionRegistryLite);
                            case 98:
                                this.p = codedInputStream.w();
                            default:
                                if (!codedInputStream.f(x)) {
                                    z = true;
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
                if (f14534e == null) {
                    synchronized (QuotaLimit.class) {
                        if (f14534e == null) {
                            f14534e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14533d);
                        }
                    }
                }
                return f14534e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14533d;
    }
}
