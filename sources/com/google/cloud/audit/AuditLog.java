package com.google.cloud.audit;

import com.google.cloud.audit.AuthenticationInfo;
import com.google.cloud.audit.RequestMetadata;
import com.google.protobuf.Any;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.rpc.Status;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class AuditLog extends GeneratedMessageLite<AuditLog, Builder> implements AuditLogOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final AuditLog f15045d = new AuditLog();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<AuditLog> f15046e;

    /* renamed from: f, reason: collision with root package name */
    private int f15047f;
    private long j;
    private Status k;
    private AuthenticationInfo l;
    private RequestMetadata n;
    private Struct o;
    private Struct p;
    private Any q;

    /* renamed from: g, reason: collision with root package name */
    private String f15048g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f15049h = "";
    private String i = "";
    private Internal.ProtobufList<AuthorizationInfo> m = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<AuditLog, Builder> implements AuditLogOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        private Builder() {
            super(AuditLog.f15045d);
        }
    }

    static {
        f15045d.l();
    }

    private AuditLog() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.k != null) {
            codedOutputStream.c(2, v());
        }
        if (this.l != null) {
            codedOutputStream.c(3, n());
        }
        if (this.n != null) {
            codedOutputStream.c(4, q());
        }
        if (!this.f15048g.isEmpty()) {
            codedOutputStream.b(7, u());
        }
        if (!this.f15049h.isEmpty()) {
            codedOutputStream.b(8, o());
        }
        for (int i = 0; i < this.m.size(); i++) {
            codedOutputStream.c(9, this.m.get(i));
        }
        if (!this.i.isEmpty()) {
            codedOutputStream.b(11, r());
        }
        long j = this.j;
        if (j != 0) {
            codedOutputStream.e(12, j);
        }
        if (this.q != null) {
            codedOutputStream.c(15, t());
        }
        if (this.o != null) {
            codedOutputStream.c(16, p());
        }
        if (this.p != null) {
            codedOutputStream.c(17, s());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.k != null ? CodedOutputStream.a(2, v()) + 0 : 0;
        if (this.l != null) {
            a2 += CodedOutputStream.a(3, n());
        }
        if (this.n != null) {
            a2 += CodedOutputStream.a(4, q());
        }
        if (!this.f15048g.isEmpty()) {
            a2 += CodedOutputStream.a(7, u());
        }
        if (!this.f15049h.isEmpty()) {
            a2 += CodedOutputStream.a(8, o());
        }
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            a2 += CodedOutputStream.a(9, this.m.get(i2));
        }
        if (!this.i.isEmpty()) {
            a2 += CodedOutputStream.a(11, r());
        }
        long j = this.j;
        if (j != 0) {
            a2 += CodedOutputStream.b(12, j);
        }
        if (this.q != null) {
            a2 += CodedOutputStream.a(15, t());
        }
        if (this.o != null) {
            a2 += CodedOutputStream.a(16, p());
        }
        if (this.p != null) {
            a2 += CodedOutputStream.a(17, s());
        }
        this.f18584c = a2;
        return a2;
    }

    public AuthenticationInfo n() {
        AuthenticationInfo authenticationInfo = this.l;
        return authenticationInfo == null ? AuthenticationInfo.n() : authenticationInfo;
    }

    public String o() {
        return this.f15049h;
    }

    public Struct p() {
        Struct struct = this.o;
        return struct == null ? Struct.n() : struct;
    }

    public RequestMetadata q() {
        RequestMetadata requestMetadata = this.n;
        return requestMetadata == null ? RequestMetadata.p() : requestMetadata;
    }

    public String r() {
        return this.i;
    }

    public Struct s() {
        Struct struct = this.p;
        return struct == null ? Struct.n() : struct;
    }

    public Any t() {
        Any any = this.q;
        return any == null ? Any.n() : any;
    }

    public String u() {
        return this.f15048g;
    }

    public Status v() {
        Status status = this.k;
        return status == null ? Status.n() : status;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        a aVar = null;
        switch (a.f15062a[methodToInvoke.ordinal()]) {
            case 1:
                return new AuditLog();
            case 2:
                return f15045d;
            case 3:
                this.m.L();
                return null;
            case 4:
                return new Builder(aVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                AuditLog auditLog = (AuditLog) obj2;
                this.f15048g = visitor.a(!this.f15048g.isEmpty(), this.f15048g, !auditLog.f15048g.isEmpty(), auditLog.f15048g);
                this.f15049h = visitor.a(!this.f15049h.isEmpty(), this.f15049h, !auditLog.f15049h.isEmpty(), auditLog.f15049h);
                this.i = visitor.a(!this.i.isEmpty(), this.i, !auditLog.i.isEmpty(), auditLog.i);
                this.j = visitor.a(this.j != 0, this.j, auditLog.j != 0, auditLog.j);
                this.k = (Status) visitor.a(this.k, auditLog.k);
                this.l = (AuthenticationInfo) visitor.a(this.l, auditLog.l);
                this.m = visitor.a(this.m, auditLog.m);
                this.n = (RequestMetadata) visitor.a(this.n, auditLog.n);
                this.o = (Struct) visitor.a(this.o, auditLog.o);
                this.p = (Struct) visitor.a(this.p, auditLog.p);
                this.q = (Any) visitor.a(this.q, auditLog.q);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f15047f |= auditLog.f15047f;
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
                                Status.Builder b2 = this.k != null ? this.k.b() : null;
                                this.k = (Status) codedInputStream.a(Status.p(), extensionRegistryLite);
                                if (b2 != null) {
                                    b2.b((Status.Builder) this.k);
                                    this.k = b2.T();
                                }
                            case 26:
                                AuthenticationInfo.Builder b3 = this.l != null ? this.l.b() : null;
                                this.l = (AuthenticationInfo) codedInputStream.a(AuthenticationInfo.p(), extensionRegistryLite);
                                if (b3 != null) {
                                    b3.b((AuthenticationInfo.Builder) this.l);
                                    this.l = b3.T();
                                }
                            case 34:
                                RequestMetadata.Builder b4 = this.n != null ? this.n.b() : null;
                                this.n = (RequestMetadata) codedInputStream.a(RequestMetadata.q(), extensionRegistryLite);
                                if (b4 != null) {
                                    b4.b((RequestMetadata.Builder) this.n);
                                    this.n = b4.T();
                                }
                            case 58:
                                this.f15048g = codedInputStream.w();
                            case 66:
                                this.f15049h = codedInputStream.w();
                            case 74:
                                if (!this.m.M()) {
                                    this.m = GeneratedMessageLite.a(this.m);
                                }
                                this.m.add((AuthorizationInfo) codedInputStream.a(AuthorizationInfo.p(), extensionRegistryLite));
                            case 90:
                                this.i = codedInputStream.w();
                            case 96:
                                this.j = codedInputStream.k();
                            case 122:
                                Any.Builder b5 = this.q != null ? this.q.b() : null;
                                this.q = (Any) codedInputStream.a(Any.p(), extensionRegistryLite);
                                if (b5 != null) {
                                    b5.b((Any.Builder) this.q);
                                    this.q = b5.T();
                                }
                            case 130:
                                Struct.Builder b6 = this.o != null ? this.o.b() : null;
                                this.o = (Struct) codedInputStream.a(Struct.o(), extensionRegistryLite);
                                if (b6 != null) {
                                    b6.b((Struct.Builder) this.o);
                                    this.o = b6.T();
                                }
                            case 138:
                                Struct.Builder b7 = this.p != null ? this.p.b() : null;
                                this.p = (Struct) codedInputStream.a(Struct.o(), extensionRegistryLite);
                                if (b7 != null) {
                                    b7.b((Struct.Builder) this.p);
                                    this.p = b7.T();
                                }
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
                if (f15046e == null) {
                    synchronized (AuditLog.class) {
                        if (f15046e == null) {
                            f15046e = new GeneratedMessageLite.DefaultInstanceBasedParser(f15045d);
                        }
                    }
                }
                return f15046e;
            default:
                throw new UnsupportedOperationException();
        }
        return f15045d;
    }
}
