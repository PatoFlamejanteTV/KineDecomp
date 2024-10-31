package com.google.cloud.audit;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class AuthenticationInfo extends GeneratedMessageLite<AuthenticationInfo, Builder> implements AuthenticationInfoOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final AuthenticationInfo f15050d = new AuthenticationInfo();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<AuthenticationInfo> f15051e;

    /* renamed from: f, reason: collision with root package name */
    private String f15052f = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthenticationInfo, Builder> implements AuthenticationInfoOrBuilder {
        /* synthetic */ Builder(b bVar) {
            this();
        }

        private Builder() {
            super(AuthenticationInfo.f15050d);
        }
    }

    static {
        f15050d.l();
    }

    private AuthenticationInfo() {
    }

    public static AuthenticationInfo n() {
        return f15050d;
    }

    public static Parser<AuthenticationInfo> p() {
        return f15050d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f15052f.isEmpty()) {
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
        int a2 = this.f15052f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
        this.f18584c = a2;
        return a2;
    }

    public String o() {
        return this.f15052f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        b bVar = null;
        switch (b.f15063a[methodToInvoke.ordinal()]) {
            case 1:
                return new AuthenticationInfo();
            case 2:
                return f15050d;
            case 3:
                return null;
            case 4:
                return new Builder(bVar);
            case 5:
                AuthenticationInfo authenticationInfo = (AuthenticationInfo) obj2;
                this.f15052f = ((GeneratedMessageLite.Visitor) obj).a(!this.f15052f.isEmpty(), this.f15052f, true ^ authenticationInfo.f15052f.isEmpty(), authenticationInfo.f15052f);
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
                                this.f15052f = codedInputStream.w();
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
                if (f15051e == null) {
                    synchronized (AuthenticationInfo.class) {
                        if (f15051e == null) {
                            f15051e = new GeneratedMessageLite.DefaultInstanceBasedParser(f15050d);
                        }
                    }
                }
                return f15051e;
            default:
                throw new UnsupportedOperationException();
        }
        return f15050d;
    }
}
