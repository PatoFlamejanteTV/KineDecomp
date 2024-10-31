package com.google.cloud.audit;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class AuthorizationInfo extends GeneratedMessageLite<AuthorizationInfo, Builder> implements AuthorizationInfoOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final AuthorizationInfo f15053d = new AuthorizationInfo();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<AuthorizationInfo> f15054e;

    /* renamed from: f, reason: collision with root package name */
    private String f15055f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f15056g = "";

    /* renamed from: h, reason: collision with root package name */
    private boolean f15057h;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthorizationInfo, Builder> implements AuthorizationInfoOrBuilder {
        /* synthetic */ Builder(c cVar) {
            this();
        }

        private Builder() {
            super(AuthorizationInfo.f15053d);
        }
    }

    static {
        f15053d.l();
    }

    private AuthorizationInfo() {
    }

    public static Parser<AuthorizationInfo> p() {
        return f15053d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f15055f.isEmpty()) {
            codedOutputStream.b(1, o());
        }
        if (!this.f15056g.isEmpty()) {
            codedOutputStream.b(2, n());
        }
        boolean z = this.f15057h;
        if (z) {
            codedOutputStream.b(3, z);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f15055f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
        if (!this.f15056g.isEmpty()) {
            a2 += CodedOutputStream.a(2, n());
        }
        boolean z = this.f15057h;
        if (z) {
            a2 += CodedOutputStream.a(3, z);
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f15056g;
    }

    public String o() {
        return this.f15055f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        c cVar = null;
        switch (c.f15064a[methodToInvoke.ordinal()]) {
            case 1:
                return new AuthorizationInfo();
            case 2:
                return f15053d;
            case 3:
                return null;
            case 4:
                return new Builder(cVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                AuthorizationInfo authorizationInfo = (AuthorizationInfo) obj2;
                this.f15055f = visitor.a(!this.f15055f.isEmpty(), this.f15055f, !authorizationInfo.f15055f.isEmpty(), authorizationInfo.f15055f);
                this.f15056g = visitor.a(!this.f15056g.isEmpty(), this.f15056g, true ^ authorizationInfo.f15056g.isEmpty(), authorizationInfo.f15056g);
                boolean z = this.f15057h;
                boolean z2 = authorizationInfo.f15057h;
                this.f15057h = visitor.a(z, z, z2, z2);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z3 = false;
                while (!z3) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f15055f = codedInputStream.w();
                            } else if (x == 18) {
                                this.f15056g = codedInputStream.w();
                            } else if (x != 24) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f15057h = codedInputStream.c();
                            }
                        }
                        z3 = true;
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
                if (f15054e == null) {
                    synchronized (AuthorizationInfo.class) {
                        if (f15054e == null) {
                            f15054e = new GeneratedMessageLite.DefaultInstanceBasedParser(f15053d);
                        }
                    }
                }
                return f15054e;
            default:
                throw new UnsupportedOperationException();
        }
        return f15053d;
    }
}
