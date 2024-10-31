package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class AuthorizationConfig extends GeneratedMessageLite<AuthorizationConfig, Builder> implements AuthorizationConfigOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final AuthorizationConfig f14347d = new AuthorizationConfig();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<AuthorizationConfig> f14348e;

    /* renamed from: f, reason: collision with root package name */
    private String f14349f = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthorizationConfig, Builder> implements AuthorizationConfigOrBuilder {
        /* synthetic */ Builder(C1468f c1468f) {
            this();
        }

        private Builder() {
            super(AuthorizationConfig.f14347d);
        }
    }

    static {
        f14347d.l();
    }

    private AuthorizationConfig() {
    }

    public static AuthorizationConfig n() {
        return f14347d;
    }

    public static Parser<AuthorizationConfig> p() {
        return f14347d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f14349f.isEmpty()) {
            return;
        }
        codedOutputStream.b(1, o());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f14349f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
        this.f18584c = a2;
        return a2;
    }

    public String o() {
        return this.f14349f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1468f c1468f = null;
        switch (C1468f.f15023a[methodToInvoke.ordinal()]) {
            case 1:
                return new AuthorizationConfig();
            case 2:
                return f14347d;
            case 3:
                return null;
            case 4:
                return new Builder(c1468f);
            case 5:
                AuthorizationConfig authorizationConfig = (AuthorizationConfig) obj2;
                this.f14349f = ((GeneratedMessageLite.Visitor) obj).a(!this.f14349f.isEmpty(), this.f14349f, true ^ authorizationConfig.f14349f.isEmpty(), authorizationConfig.f14349f);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x != 10) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f14349f = codedInputStream.w();
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
                if (f14348e == null) {
                    synchronized (AuthorizationConfig.class) {
                        if (f14348e == null) {
                            f14348e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14347d);
                        }
                    }
                }
                return f14348e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14347d;
    }
}
