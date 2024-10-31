package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ClientAppInfo extends GeneratedMessageLite<ClientAppInfo, Builder> implements ClientAppInfoOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final ClientAppInfo f18310d = new ClientAppInfo();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<ClientAppInfo> f18311e;

    /* renamed from: f, reason: collision with root package name */
    private String f18312f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f18313g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f18314h = "";

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ClientAppInfo, Builder> implements ClientAppInfoOrBuilder {
        /* synthetic */ Builder(c cVar) {
            this();
        }

        public Builder a(String str) {
            b();
            ((ClientAppInfo) this.f18586b).b(str);
            return this;
        }

        public Builder b(String str) {
            b();
            ((ClientAppInfo) this.f18586b).c(str);
            return this;
        }

        public Builder c(String str) {
            b();
            ((ClientAppInfo) this.f18586b).d(str);
            return this;
        }

        private Builder() {
            super(ClientAppInfo.f18310d);
        }
    }

    static {
        f18310d.l();
    }

    private ClientAppInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (str != null) {
            this.f18312f = str;
            return;
        }
        throw new NullPointerException();
    }

    public static ClientAppInfo p() {
        return f18310d;
    }

    public static Builder r() {
        return f18310d.b();
    }

    public static Parser<ClientAppInfo> s() {
        return f18310d.f();
    }

    public String n() {
        return this.f18313g;
    }

    public String o() {
        return this.f18314h;
    }

    public String q() {
        return this.f18312f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (str != null) {
            this.f18313g = str;
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (str != null) {
            this.f18314h = str;
            return;
        }
        throw new NullPointerException();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18312f.isEmpty()) {
            codedOutputStream.b(1, q());
        }
        if (!this.f18313g.isEmpty()) {
            codedOutputStream.b(2, n());
        }
        if (this.f18314h.isEmpty()) {
            return;
        }
        codedOutputStream.b(3, o());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18312f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, q());
        if (!this.f18313g.isEmpty()) {
            a2 += CodedOutputStream.a(2, n());
        }
        if (!this.f18314h.isEmpty()) {
            a2 += CodedOutputStream.a(3, o());
        }
        this.f18584c = a2;
        return a2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        c cVar = null;
        switch (c.f18329a[methodToInvoke.ordinal()]) {
            case 1:
                return new ClientAppInfo();
            case 2:
                return f18310d;
            case 3:
                return null;
            case 4:
                return new Builder(cVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ClientAppInfo clientAppInfo = (ClientAppInfo) obj2;
                this.f18312f = visitor.a(!this.f18312f.isEmpty(), this.f18312f, !clientAppInfo.f18312f.isEmpty(), clientAppInfo.f18312f);
                this.f18313g = visitor.a(!this.f18313g.isEmpty(), this.f18313g, !clientAppInfo.f18313g.isEmpty(), clientAppInfo.f18313g);
                this.f18314h = visitor.a(!this.f18314h.isEmpty(), this.f18314h, true ^ clientAppInfo.f18314h.isEmpty(), clientAppInfo.f18314h);
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
                                this.f18312f = codedInputStream.w();
                            } else if (x == 18) {
                                this.f18313g = codedInputStream.w();
                            } else if (x != 26) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18314h = codedInputStream.w();
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
                if (f18311e == null) {
                    synchronized (ClientAppInfo.class) {
                        if (f18311e == null) {
                            f18311e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18310d);
                        }
                    }
                }
                return f18311e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18310d;
    }
}
