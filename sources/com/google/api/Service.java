package com.google.api;

import com.google.api.Authentication;
import com.google.api.Backend;
import com.google.api.Billing;
import com.google.api.Context;
import com.google.api.Control;
import com.google.api.Documentation;
import com.google.api.Experimental;
import com.google.api.Http;
import com.google.api.Logging;
import com.google.api.Monitoring;
import com.google.api.Quota;
import com.google.api.SourceInfo;
import com.google.api.SystemParameters;
import com.google.api.Usage;
import com.google.protobuf.Api;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Enum;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Type;
import com.google.protobuf.UInt32Value;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Service extends GeneratedMessageLite<Service, Builder> implements ServiceOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Service f14540d = new Service();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Service> f14541e;
    private Billing A;
    private Logging B;
    private Monitoring C;
    private SystemParameters D;
    private SourceInfo E;
    private Experimental F;

    /* renamed from: f, reason: collision with root package name */
    private int f14542f;

    /* renamed from: g, reason: collision with root package name */
    private UInt32Value f14543g;
    private Documentation o;
    private Backend p;
    private Http q;
    private Quota r;
    private Authentication s;
    private Context t;
    private Usage u;
    private Control w;

    /* renamed from: h, reason: collision with root package name */
    private String f14544h = "";
    private String i = "";
    private String j = "";
    private String k = "";
    private Internal.ProtobufList<Api> l = GeneratedMessageLite.k();
    private Internal.ProtobufList<Type> m = GeneratedMessageLite.k();
    private Internal.ProtobufList<Enum> n = GeneratedMessageLite.k();
    private Internal.ProtobufList<Endpoint> v = GeneratedMessageLite.k();
    private Internal.ProtobufList<LogDescriptor> x = GeneratedMessageLite.k();
    private Internal.ProtobufList<MetricDescriptor> y = GeneratedMessageLite.k();
    private Internal.ProtobufList<MonitoredResourceDescriptor> z = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Service, Builder> implements ServiceOrBuilder {
        /* synthetic */ Builder(Q q) {
            this();
        }

        private Builder() {
            super(Service.f14540d);
        }
    }

    static {
        f14540d.l();
    }

    private Service() {
    }

    public String A() {
        return this.k;
    }

    public Quota B() {
        Quota quota = this.r;
        return quota == null ? Quota.n() : quota;
    }

    public SourceInfo C() {
        SourceInfo sourceInfo = this.E;
        return sourceInfo == null ? SourceInfo.n() : sourceInfo;
    }

    public SystemParameters D() {
        SystemParameters systemParameters = this.D;
        return systemParameters == null ? SystemParameters.n() : systemParameters;
    }

    public String E() {
        return this.j;
    }

    public Usage F() {
        Usage usage = this.u;
        return usage == null ? Usage.n() : usage;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14544h.isEmpty()) {
            codedOutputStream.b(1, z());
        }
        if (!this.j.isEmpty()) {
            codedOutputStream.b(2, E());
        }
        for (int i = 0; i < this.l.size(); i++) {
            codedOutputStream.c(3, this.l.get(i));
        }
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            codedOutputStream.c(4, this.m.get(i2));
        }
        for (int i3 = 0; i3 < this.n.size(); i3++) {
            codedOutputStream.c(5, this.n.get(i3));
        }
        if (this.o != null) {
            codedOutputStream.c(6, t());
        }
        if (this.p != null) {
            codedOutputStream.c(8, o());
        }
        if (this.q != null) {
            codedOutputStream.c(9, v());
        }
        if (this.r != null) {
            codedOutputStream.c(10, B());
        }
        if (this.s != null) {
            codedOutputStream.c(11, n());
        }
        if (this.t != null) {
            codedOutputStream.c(12, r());
        }
        if (this.u != null) {
            codedOutputStream.c(15, F());
        }
        for (int i4 = 0; i4 < this.v.size(); i4++) {
            codedOutputStream.c(18, this.v.get(i4));
        }
        if (this.f14543g != null) {
            codedOutputStream.c(20, q());
        }
        if (this.w != null) {
            codedOutputStream.c(21, s());
        }
        if (!this.k.isEmpty()) {
            codedOutputStream.b(22, A());
        }
        for (int i5 = 0; i5 < this.x.size(); i5++) {
            codedOutputStream.c(23, this.x.get(i5));
        }
        for (int i6 = 0; i6 < this.y.size(); i6++) {
            codedOutputStream.c(24, this.y.get(i6));
        }
        for (int i7 = 0; i7 < this.z.size(); i7++) {
            codedOutputStream.c(25, this.z.get(i7));
        }
        if (this.A != null) {
            codedOutputStream.c(26, p());
        }
        if (this.B != null) {
            codedOutputStream.c(27, x());
        }
        if (this.C != null) {
            codedOutputStream.c(28, y());
        }
        if (this.D != null) {
            codedOutputStream.c(29, D());
        }
        if (!this.i.isEmpty()) {
            codedOutputStream.b(33, w());
        }
        if (this.E != null) {
            codedOutputStream.c(37, C());
        }
        if (this.F != null) {
            codedOutputStream.c(101, u());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f14544h.isEmpty() ? CodedOutputStream.a(1, z()) + 0 : 0;
        if (!this.j.isEmpty()) {
            a2 += CodedOutputStream.a(2, E());
        }
        int i2 = a2;
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            i2 += CodedOutputStream.a(3, this.l.get(i3));
        }
        for (int i4 = 0; i4 < this.m.size(); i4++) {
            i2 += CodedOutputStream.a(4, this.m.get(i4));
        }
        for (int i5 = 0; i5 < this.n.size(); i5++) {
            i2 += CodedOutputStream.a(5, this.n.get(i5));
        }
        if (this.o != null) {
            i2 += CodedOutputStream.a(6, t());
        }
        if (this.p != null) {
            i2 += CodedOutputStream.a(8, o());
        }
        if (this.q != null) {
            i2 += CodedOutputStream.a(9, v());
        }
        if (this.r != null) {
            i2 += CodedOutputStream.a(10, B());
        }
        if (this.s != null) {
            i2 += CodedOutputStream.a(11, n());
        }
        if (this.t != null) {
            i2 += CodedOutputStream.a(12, r());
        }
        if (this.u != null) {
            i2 += CodedOutputStream.a(15, F());
        }
        for (int i6 = 0; i6 < this.v.size(); i6++) {
            i2 += CodedOutputStream.a(18, this.v.get(i6));
        }
        if (this.f14543g != null) {
            i2 += CodedOutputStream.a(20, q());
        }
        if (this.w != null) {
            i2 += CodedOutputStream.a(21, s());
        }
        if (!this.k.isEmpty()) {
            i2 += CodedOutputStream.a(22, A());
        }
        for (int i7 = 0; i7 < this.x.size(); i7++) {
            i2 += CodedOutputStream.a(23, this.x.get(i7));
        }
        for (int i8 = 0; i8 < this.y.size(); i8++) {
            i2 += CodedOutputStream.a(24, this.y.get(i8));
        }
        for (int i9 = 0; i9 < this.z.size(); i9++) {
            i2 += CodedOutputStream.a(25, this.z.get(i9));
        }
        if (this.A != null) {
            i2 += CodedOutputStream.a(26, p());
        }
        if (this.B != null) {
            i2 += CodedOutputStream.a(27, x());
        }
        if (this.C != null) {
            i2 += CodedOutputStream.a(28, y());
        }
        if (this.D != null) {
            i2 += CodedOutputStream.a(29, D());
        }
        if (!this.i.isEmpty()) {
            i2 += CodedOutputStream.a(33, w());
        }
        if (this.E != null) {
            i2 += CodedOutputStream.a(37, C());
        }
        if (this.F != null) {
            i2 += CodedOutputStream.a(101, u());
        }
        this.f18584c = i2;
        return i2;
    }

    public Authentication n() {
        Authentication authentication = this.s;
        return authentication == null ? Authentication.n() : authentication;
    }

    public Backend o() {
        Backend backend = this.p;
        return backend == null ? Backend.n() : backend;
    }

    public Billing p() {
        Billing billing = this.A;
        return billing == null ? Billing.n() : billing;
    }

    public UInt32Value q() {
        UInt32Value uInt32Value = this.f14543g;
        return uInt32Value == null ? UInt32Value.n() : uInt32Value;
    }

    public Context r() {
        Context context = this.t;
        return context == null ? Context.n() : context;
    }

    public Control s() {
        Control control = this.w;
        return control == null ? Control.n() : control;
    }

    public Documentation t() {
        Documentation documentation = this.o;
        return documentation == null ? Documentation.n() : documentation;
    }

    public Experimental u() {
        Experimental experimental = this.F;
        return experimental == null ? Experimental.o() : experimental;
    }

    public Http v() {
        Http http = this.q;
        return http == null ? Http.n() : http;
    }

    public String w() {
        return this.i;
    }

    public Logging x() {
        Logging logging = this.B;
        return logging == null ? Logging.n() : logging;
    }

    public Monitoring y() {
        Monitoring monitoring = this.C;
        return monitoring == null ? Monitoring.n() : monitoring;
    }

    public String z() {
        return this.f14544h;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Q q = null;
        switch (Q.f14528a[methodToInvoke.ordinal()]) {
            case 1:
                return new Service();
            case 2:
                return f14540d;
            case 3:
                this.l.L();
                this.m.L();
                this.n.L();
                this.v.L();
                this.x.L();
                this.y.L();
                this.z.L();
                return null;
            case 4:
                return new Builder(q);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Service service = (Service) obj2;
                this.f14543g = (UInt32Value) visitor.a(this.f14543g, service.f14543g);
                this.f14544h = visitor.a(!this.f14544h.isEmpty(), this.f14544h, !service.f14544h.isEmpty(), service.f14544h);
                this.i = visitor.a(!this.i.isEmpty(), this.i, !service.i.isEmpty(), service.i);
                this.j = visitor.a(!this.j.isEmpty(), this.j, !service.j.isEmpty(), service.j);
                this.k = visitor.a(!this.k.isEmpty(), this.k, true ^ service.k.isEmpty(), service.k);
                this.l = visitor.a(this.l, service.l);
                this.m = visitor.a(this.m, service.m);
                this.n = visitor.a(this.n, service.n);
                this.o = (Documentation) visitor.a(this.o, service.o);
                this.p = (Backend) visitor.a(this.p, service.p);
                this.q = (Http) visitor.a(this.q, service.q);
                this.r = (Quota) visitor.a(this.r, service.r);
                this.s = (Authentication) visitor.a(this.s, service.s);
                this.t = (Context) visitor.a(this.t, service.t);
                this.u = (Usage) visitor.a(this.u, service.u);
                this.v = visitor.a(this.v, service.v);
                this.w = (Control) visitor.a(this.w, service.w);
                this.x = visitor.a(this.x, service.x);
                this.y = visitor.a(this.y, service.y);
                this.z = visitor.a(this.z, service.z);
                this.A = (Billing) visitor.a(this.A, service.A);
                this.B = (Logging) visitor.a(this.B, service.B);
                this.C = (Monitoring) visitor.a(this.C, service.C);
                this.D = (SystemParameters) visitor.a(this.D, service.D);
                this.E = (SourceInfo) visitor.a(this.E, service.E);
                this.F = (Experimental) visitor.a(this.F, service.F);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14542f |= service.f14542f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        switch (x) {
                            case 0:
                                z = true;
                            case 10:
                                this.f14544h = codedInputStream.w();
                            case 18:
                                this.j = codedInputStream.w();
                            case 26:
                                if (!this.l.M()) {
                                    this.l = GeneratedMessageLite.a(this.l);
                                }
                                this.l.add((Api) codedInputStream.a(Api.q(), extensionRegistryLite));
                            case 34:
                                if (!this.m.M()) {
                                    this.m = GeneratedMessageLite.a(this.m);
                                }
                                this.m.add((Type) codedInputStream.a(Type.q(), extensionRegistryLite));
                            case 42:
                                if (!this.n.M()) {
                                    this.n = GeneratedMessageLite.a(this.n);
                                }
                                this.n.add((Enum) codedInputStream.a(Enum.p(), extensionRegistryLite));
                            case 50:
                                Documentation.Builder b2 = this.o != null ? this.o.b() : null;
                                this.o = (Documentation) codedInputStream.a(Documentation.r(), extensionRegistryLite);
                                if (b2 != null) {
                                    b2.b((Documentation.Builder) this.o);
                                    this.o = b2.T();
                                }
                            case 66:
                                Backend.Builder b3 = this.p != null ? this.p.b() : null;
                                this.p = (Backend) codedInputStream.a(Backend.o(), extensionRegistryLite);
                                if (b3 != null) {
                                    b3.b((Backend.Builder) this.p);
                                    this.p = b3.T();
                                }
                            case 74:
                                Http.Builder b4 = this.q != null ? this.q.b() : null;
                                this.q = (Http) codedInputStream.a(Http.o(), extensionRegistryLite);
                                if (b4 != null) {
                                    b4.b((Http.Builder) this.q);
                                    this.q = b4.T();
                                }
                            case 82:
                                Quota.Builder b5 = this.r != null ? this.r.b() : null;
                                this.r = (Quota) codedInputStream.a(Quota.o(), extensionRegistryLite);
                                if (b5 != null) {
                                    b5.b((Quota.Builder) this.r);
                                    this.r = b5.T();
                                }
                            case 90:
                                Authentication.Builder b6 = this.s != null ? this.s.b() : null;
                                this.s = (Authentication) codedInputStream.a(Authentication.o(), extensionRegistryLite);
                                if (b6 != null) {
                                    b6.b((Authentication.Builder) this.s);
                                    this.s = b6.T();
                                }
                            case 98:
                                Context.Builder b7 = this.t != null ? this.t.b() : null;
                                this.t = (Context) codedInputStream.a(Context.o(), extensionRegistryLite);
                                if (b7 != null) {
                                    b7.b((Context.Builder) this.t);
                                    this.t = b7.T();
                                }
                            case 122:
                                Usage.Builder b8 = this.u != null ? this.u.b() : null;
                                this.u = (Usage) codedInputStream.a(Usage.q(), extensionRegistryLite);
                                if (b8 != null) {
                                    b8.b((Usage.Builder) this.u);
                                    this.u = b8.T();
                                }
                            case 146:
                                if (!this.v.M()) {
                                    this.v = GeneratedMessageLite.a(this.v);
                                }
                                this.v.add((Endpoint) codedInputStream.a(Endpoint.s(), extensionRegistryLite));
                            case 162:
                                UInt32Value.Builder b9 = this.f14543g != null ? this.f14543g.b() : null;
                                this.f14543g = (UInt32Value) codedInputStream.a(UInt32Value.o(), extensionRegistryLite);
                                if (b9 != null) {
                                    b9.b((UInt32Value.Builder) this.f14543g);
                                    this.f14543g = b9.T();
                                }
                            case 170:
                                Control.Builder b10 = this.w != null ? this.w.b() : null;
                                this.w = (Control) codedInputStream.a(Control.p(), extensionRegistryLite);
                                if (b10 != null) {
                                    b10.b((Control.Builder) this.w);
                                    this.w = b10.T();
                                }
                            case 178:
                                this.k = codedInputStream.w();
                            case 186:
                                if (!this.x.M()) {
                                    this.x = GeneratedMessageLite.a(this.x);
                                }
                                this.x.add((LogDescriptor) codedInputStream.a(LogDescriptor.q(), extensionRegistryLite));
                            case 194:
                                if (!this.y.M()) {
                                    this.y = GeneratedMessageLite.a(this.y);
                                }
                                this.y.add((MetricDescriptor) codedInputStream.a(MetricDescriptor.s(), extensionRegistryLite));
                            case 202:
                                if (!this.z.M()) {
                                    this.z = GeneratedMessageLite.a(this.z);
                                }
                                this.z.add((MonitoredResourceDescriptor) codedInputStream.a(MonitoredResourceDescriptor.r(), extensionRegistryLite));
                            case 210:
                                Billing.Builder b11 = this.A != null ? this.A.b() : null;
                                this.A = (Billing) codedInputStream.a(Billing.o(), extensionRegistryLite);
                                if (b11 != null) {
                                    b11.b((Billing.Builder) this.A);
                                    this.A = b11.T();
                                }
                            case 218:
                                Logging.Builder b12 = this.B != null ? this.B.b() : null;
                                this.B = (Logging) codedInputStream.a(Logging.o(), extensionRegistryLite);
                                if (b12 != null) {
                                    b12.b((Logging.Builder) this.B);
                                    this.B = b12.T();
                                }
                            case 226:
                                Monitoring.Builder b13 = this.C != null ? this.C.b() : null;
                                this.C = (Monitoring) codedInputStream.a(Monitoring.o(), extensionRegistryLite);
                                if (b13 != null) {
                                    b13.b((Monitoring.Builder) this.C);
                                    this.C = b13.T();
                                }
                            case 234:
                                SystemParameters.Builder b14 = this.D != null ? this.D.b() : null;
                                this.D = (SystemParameters) codedInputStream.a(SystemParameters.o(), extensionRegistryLite);
                                if (b14 != null) {
                                    b14.b((SystemParameters.Builder) this.D);
                                    this.D = b14.T();
                                }
                            case 266:
                                this.i = codedInputStream.w();
                            case 298:
                                SourceInfo.Builder b15 = this.E != null ? this.E.b() : null;
                                this.E = (SourceInfo) codedInputStream.a(SourceInfo.o(), extensionRegistryLite);
                                if (b15 != null) {
                                    b15.b((SourceInfo.Builder) this.E);
                                    this.E = b15.T();
                                }
                            case 810:
                                Experimental.Builder b16 = this.F != null ? this.F.b() : null;
                                this.F = (Experimental) codedInputStream.a(Experimental.p(), extensionRegistryLite);
                                if (b16 != null) {
                                    b16.b((Experimental.Builder) this.F);
                                    this.F = b16.T();
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
                if (f14541e == null) {
                    synchronized (Service.class) {
                        if (f14541e == null) {
                            f14541e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14540d);
                        }
                    }
                }
                return f14541e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14540d;
    }
}
