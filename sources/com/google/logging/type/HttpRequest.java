package com.google.logging.type;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class HttpRequest extends GeneratedMessageLite<HttpRequest, Builder> implements HttpRequestOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final HttpRequest f18332d = new HttpRequest();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<HttpRequest> f18333e;

    /* renamed from: h, reason: collision with root package name */
    private long f18336h;
    private int i;
    private long j;
    private Duration o;
    private boolean p;
    private boolean q;
    private boolean r;
    private long s;

    /* renamed from: f, reason: collision with root package name */
    private String f18334f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f18335g = "";
    private String k = "";
    private String l = "";
    private String m = "";
    private String n = "";
    private String t = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<HttpRequest, Builder> implements HttpRequestOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        private Builder() {
            super(HttpRequest.f18332d);
        }
    }

    static {
        f18332d.l();
    }

    private HttpRequest() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18334f.isEmpty()) {
            codedOutputStream.b(1, r());
        }
        if (!this.f18335g.isEmpty()) {
            codedOutputStream.b(2, s());
        }
        long j = this.f18336h;
        if (j != 0) {
            codedOutputStream.e(3, j);
        }
        int i = this.i;
        if (i != 0) {
            codedOutputStream.g(4, i);
        }
        long j2 = this.j;
        if (j2 != 0) {
            codedOutputStream.e(5, j2);
        }
        if (!this.k.isEmpty()) {
            codedOutputStream.b(6, u());
        }
        if (!this.l.isEmpty()) {
            codedOutputStream.b(7, q());
        }
        if (!this.n.isEmpty()) {
            codedOutputStream.b(8, p());
        }
        boolean z = this.q;
        if (z) {
            codedOutputStream.b(9, z);
        }
        boolean z2 = this.r;
        if (z2) {
            codedOutputStream.b(10, z2);
        }
        boolean z3 = this.p;
        if (z3) {
            codedOutputStream.b(11, z3);
        }
        long j3 = this.s;
        if (j3 != 0) {
            codedOutputStream.e(12, j3);
        }
        if (!this.m.isEmpty()) {
            codedOutputStream.b(13, t());
        }
        if (this.o != null) {
            codedOutputStream.c(14, n());
        }
        if (this.t.isEmpty()) {
            return;
        }
        codedOutputStream.b(15, o());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18334f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, r());
        if (!this.f18335g.isEmpty()) {
            a2 += CodedOutputStream.a(2, s());
        }
        long j = this.f18336h;
        if (j != 0) {
            a2 += CodedOutputStream.b(3, j);
        }
        int i2 = this.i;
        if (i2 != 0) {
            a2 += CodedOutputStream.c(4, i2);
        }
        long j2 = this.j;
        if (j2 != 0) {
            a2 += CodedOutputStream.b(5, j2);
        }
        if (!this.k.isEmpty()) {
            a2 += CodedOutputStream.a(6, u());
        }
        if (!this.l.isEmpty()) {
            a2 += CodedOutputStream.a(7, q());
        }
        if (!this.n.isEmpty()) {
            a2 += CodedOutputStream.a(8, p());
        }
        boolean z = this.q;
        if (z) {
            a2 += CodedOutputStream.a(9, z);
        }
        boolean z2 = this.r;
        if (z2) {
            a2 += CodedOutputStream.a(10, z2);
        }
        boolean z3 = this.p;
        if (z3) {
            a2 += CodedOutputStream.a(11, z3);
        }
        long j3 = this.s;
        if (j3 != 0) {
            a2 += CodedOutputStream.b(12, j3);
        }
        if (!this.m.isEmpty()) {
            a2 += CodedOutputStream.a(13, t());
        }
        if (this.o != null) {
            a2 += CodedOutputStream.a(14, n());
        }
        if (!this.t.isEmpty()) {
            a2 += CodedOutputStream.a(15, o());
        }
        this.f18584c = a2;
        return a2;
    }

    public Duration n() {
        Duration duration = this.o;
        return duration == null ? Duration.n() : duration;
    }

    public String o() {
        return this.t;
    }

    public String p() {
        return this.n;
    }

    public String q() {
        return this.l;
    }

    public String r() {
        return this.f18334f;
    }

    public String s() {
        return this.f18335g;
    }

    public String t() {
        return this.m;
    }

    public String u() {
        return this.k;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a aVar = null;
        boolean z = false;
        switch (a.f18337a[methodToInvoke.ordinal()]) {
            case 1:
                return new HttpRequest();
            case 2:
                return f18332d;
            case 3:
                return null;
            case 4:
                return new Builder(aVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                HttpRequest httpRequest = (HttpRequest) obj2;
                this.f18334f = visitor.a(!this.f18334f.isEmpty(), this.f18334f, !httpRequest.f18334f.isEmpty(), httpRequest.f18334f);
                this.f18335g = visitor.a(!this.f18335g.isEmpty(), this.f18335g, !httpRequest.f18335g.isEmpty(), httpRequest.f18335g);
                this.f18336h = visitor.a(this.f18336h != 0, this.f18336h, httpRequest.f18336h != 0, httpRequest.f18336h);
                this.i = visitor.a(this.i != 0, this.i, httpRequest.i != 0, httpRequest.i);
                this.j = visitor.a(this.j != 0, this.j, httpRequest.j != 0, httpRequest.j);
                this.k = visitor.a(!this.k.isEmpty(), this.k, !httpRequest.k.isEmpty(), httpRequest.k);
                this.l = visitor.a(!this.l.isEmpty(), this.l, !httpRequest.l.isEmpty(), httpRequest.l);
                this.m = visitor.a(!this.m.isEmpty(), this.m, !httpRequest.m.isEmpty(), httpRequest.m);
                this.n = visitor.a(!this.n.isEmpty(), this.n, !httpRequest.n.isEmpty(), httpRequest.n);
                this.o = (Duration) visitor.a(this.o, httpRequest.o);
                boolean z2 = this.p;
                boolean z3 = httpRequest.p;
                this.p = visitor.a(z2, z2, z3, z3);
                boolean z4 = this.q;
                boolean z5 = httpRequest.q;
                this.q = visitor.a(z4, z4, z5, z5);
                boolean z6 = this.r;
                boolean z7 = httpRequest.r;
                this.r = visitor.a(z6, z6, z7, z7);
                this.s = visitor.a(this.s != 0, this.s, httpRequest.s != 0, httpRequest.s);
                this.t = visitor.a(!this.t.isEmpty(), this.t, !httpRequest.t.isEmpty(), httpRequest.t);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        try {
                            int x = codedInputStream.x();
                            switch (x) {
                                case 0:
                                    z = true;
                                case 10:
                                    this.f18334f = codedInputStream.w();
                                case 18:
                                    this.f18335g = codedInputStream.w();
                                case 24:
                                    this.f18336h = codedInputStream.k();
                                case 32:
                                    this.i = codedInputStream.j();
                                case 40:
                                    this.j = codedInputStream.k();
                                case 50:
                                    this.k = codedInputStream.w();
                                case 58:
                                    this.l = codedInputStream.w();
                                case 66:
                                    this.n = codedInputStream.w();
                                case 72:
                                    this.q = codedInputStream.c();
                                case 80:
                                    this.r = codedInputStream.c();
                                case 88:
                                    this.p = codedInputStream.c();
                                case 96:
                                    this.s = codedInputStream.k();
                                case 106:
                                    this.m = codedInputStream.w();
                                case 114:
                                    Duration.Builder b2 = this.o != null ? this.o.b() : null;
                                    this.o = (Duration) codedInputStream.a(Duration.o(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((Duration.Builder) this.o);
                                        this.o = b2.T();
                                    }
                                case 122:
                                    this.t = codedInputStream.w();
                                default:
                                    if (!codedInputStream.f(x)) {
                                        z = true;
                                    }
                            }
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw new RuntimeException(e3.setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f18333e == null) {
                    synchronized (HttpRequest.class) {
                        if (f18333e == null) {
                            f18333e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18332d);
                        }
                    }
                }
                return f18333e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18332d;
    }
}
