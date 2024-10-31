package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class SystemParameter extends GeneratedMessageLite<SystemParameter, Builder> implements SystemParameterOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final SystemParameter f14548d = new SystemParameter();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<SystemParameter> f14549e;

    /* renamed from: f, reason: collision with root package name */
    private String f14550f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f14551g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f14552h = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<SystemParameter, Builder> implements SystemParameterOrBuilder {
        /* synthetic */ Builder(T t) {
            this();
        }

        private Builder() {
            super(SystemParameter.f14548d);
        }
    }

    static {
        f14548d.l();
    }

    private SystemParameter() {
    }

    public static Parser<SystemParameter> q() {
        return f14548d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14550f.isEmpty()) {
            codedOutputStream.b(1, o());
        }
        if (!this.f14551g.isEmpty()) {
            codedOutputStream.b(2, n());
        }
        if (this.f14552h.isEmpty()) {
            return;
        }
        codedOutputStream.b(3, p());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f14550f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
        if (!this.f14551g.isEmpty()) {
            a2 += CodedOutputStream.a(2, n());
        }
        if (!this.f14552h.isEmpty()) {
            a2 += CodedOutputStream.a(3, p());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14551g;
    }

    public String o() {
        return this.f14550f;
    }

    public String p() {
        return this.f14552h;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        T t = null;
        switch (T.f14561a[methodToInvoke.ordinal()]) {
            case 1:
                return new SystemParameter();
            case 2:
                return f14548d;
            case 3:
                return null;
            case 4:
                return new Builder(t);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                SystemParameter systemParameter = (SystemParameter) obj2;
                this.f14550f = visitor.a(!this.f14550f.isEmpty(), this.f14550f, !systemParameter.f14550f.isEmpty(), systemParameter.f14550f);
                this.f14551g = visitor.a(!this.f14551g.isEmpty(), this.f14551g, !systemParameter.f14551g.isEmpty(), systemParameter.f14551g);
                this.f14552h = visitor.a(!this.f14552h.isEmpty(), this.f14552h, true ^ systemParameter.f14552h.isEmpty(), systemParameter.f14552h);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f14550f = codedInputStream.w();
                            } else if (x == 18) {
                                this.f14551g = codedInputStream.w();
                            } else if (x != 26) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f14552h = codedInputStream.w();
                            }
                        }
                        z = true;
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
                if (f14549e == null) {
                    synchronized (SystemParameter.class) {
                        if (f14549e == null) {
                            f14549e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14548d);
                        }
                    }
                }
                return f14549e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14548d;
    }
}
