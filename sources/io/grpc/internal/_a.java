package io.grpc.internal;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import io.grpc.F;
import io.grpc.P;
import io.grpc.Status;
import io.grpc.internal.AbstractC2411a;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* compiled from: Http2ClientStreamTransportState.java */
/* loaded from: classes3.dex */
public abstract class _a extends AbstractC2411a.c {
    private static final F.a<Integer> q = new Za();
    private static final P.e<Integer> r = io.grpc.F.a(":status", q);
    private Status s;
    private io.grpc.P t;
    private Charset u;
    private boolean v;

    /* JADX INFO: Access modifiers changed from: protected */
    public _a(int i, Mc mc, Rc rc) {
        super(i, mc, rc);
        this.u = Charsets.f15078c;
    }

    private static Charset d(io.grpc.P p) {
        String str = (String) p.b(GrpcUtil.i);
        if (str != null) {
            try {
                return Charset.forName(str.split("charset=", 2)[r2.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return Charsets.f15078c;
    }

    private Status e(io.grpc.P p) {
        Status b2;
        Status status = (Status) p.b(io.grpc.H.f27092b);
        if (status != null) {
            return status.b((String) p.b(io.grpc.H.f27091a));
        }
        if (this.v) {
            return Status.f27131d.b("missing GRPC status in response");
        }
        Integer num = (Integer) p.b(r);
        if (num != null) {
            b2 = GrpcUtil.a(num.intValue());
        } else {
            b2 = Status.p.b("missing HTTP status code");
        }
        return b2.a("missing GRPC status, inferred error from HTTP status code");
    }

    private static void f(io.grpc.P p) {
        p.a(r);
        p.a(io.grpc.H.f27092b);
        p.a(io.grpc.H.f27091a);
    }

    @Nullable
    private Status g(io.grpc.P p) {
        Integer num = (Integer) p.b(r);
        if (num == null) {
            return Status.p.b("Missing HTTP status code");
        }
        String str = (String) p.b(GrpcUtil.i);
        if (GrpcUtil.b(str)) {
            return null;
        }
        return GrpcUtil.a(num.intValue()).a("invalid content-type: " + str);
    }

    @Override // io.grpc.internal.AbstractC2411a.c, io.grpc.internal.MessageDeframer.a
    public /* bridge */ /* synthetic */ void a(boolean z) {
        super.a(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Finally extract failed */
    public void b(io.grpc.P p) {
        Preconditions.a(p, "headers");
        Status status = this.s;
        if (status != null) {
            this.s = status.a("headers: " + p);
            return;
        }
        try {
            if (this.v) {
                this.s = Status.p.b("Received headers twice");
                Status status2 = this.s;
                if (status2 != null) {
                    this.s = status2.a("headers: " + p);
                    this.t = p;
                    this.u = d(p);
                    return;
                }
                return;
            }
            Integer num = (Integer) p.b(r);
            if (num != null && num.intValue() >= 100 && num.intValue() < 200) {
                Status status3 = this.s;
                if (status3 != null) {
                    this.s = status3.a("headers: " + p);
                    this.t = p;
                    this.u = d(p);
                    return;
                }
                return;
            }
            this.v = true;
            this.s = g(p);
            if (this.s != null) {
                Status status4 = this.s;
                if (status4 != null) {
                    this.s = status4.a("headers: " + p);
                    this.t = p;
                    this.u = d(p);
                    return;
                }
                return;
            }
            f(p);
            a(p);
            Status status5 = this.s;
            if (status5 != null) {
                this.s = status5.a("headers: " + p);
                this.t = p;
                this.u = d(p);
            }
        } catch (Throwable th) {
            Status status6 = this.s;
            if (status6 != null) {
                this.s = status6.a("headers: " + p);
                this.t = p;
                this.u = d(p);
            }
            throw th;
        }
    }

    protected abstract void b(Status status, boolean z, io.grpc.P p);

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(io.grpc.P p) {
        Preconditions.a(p, "trailers");
        if (this.s == null && !this.v) {
            this.s = g(p);
            if (this.s != null) {
                this.t = p;
            }
        }
        Status status = this.s;
        if (status != null) {
            this.s = status.a("trailers: " + p);
            b(this.s, false, this.t);
            return;
        }
        Status e2 = e(p);
        f(p);
        a(p, e2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(InterfaceC2426dc interfaceC2426dc, boolean z) {
        Status status = this.s;
        if (status != null) {
            this.s = status.a("DATA-----------------------------\n" + C2434fc.a(interfaceC2426dc, this.u));
            interfaceC2426dc.close();
            if (this.s.f().length() > 1000 || z) {
                b(this.s, false, this.t);
                return;
            }
            return;
        }
        if (!this.v) {
            b(Status.p.b("headers not received before payload"), false, new io.grpc.P());
            return;
        }
        b(interfaceC2426dc);
        if (z) {
            this.s = Status.p.b("Received unexpected EOS on DATA frame from server.");
            this.t = new io.grpc.P();
            a(this.s, false, this.t);
        }
    }
}
