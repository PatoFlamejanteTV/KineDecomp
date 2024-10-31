package com.google.firebase.inappmessaging;

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
    private static final ClientAppInfo f17438d = new ClientAppInfo();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<ClientAppInfo> f17439e;

    /* renamed from: f, reason: collision with root package name */
    private int f17440f;

    /* renamed from: g, reason: collision with root package name */
    private String f17441g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f17442h = "";

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ClientAppInfo, Builder> implements ClientAppInfoOrBuilder {
        /* synthetic */ Builder(b bVar) {
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

        private Builder() {
            super(ClientAppInfo.f17438d);
        }
    }

    static {
        f17438d.l();
    }

    private ClientAppInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (str != null) {
            this.f17440f |= 1;
            this.f17441g = str;
            return;
        }
        throw new NullPointerException();
    }

    public static ClientAppInfo n() {
        return f17438d;
    }

    public static Builder s() {
        return f17438d.b();
    }

    public static Parser<ClientAppInfo> t() {
        return f17438d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = (this.f17440f & 1) == 1 ? 0 + CodedOutputStream.a(1, p()) : 0;
        if ((this.f17440f & 2) == 2) {
            a2 += CodedOutputStream.a(2, o());
        }
        int c2 = a2 + this.f18583b.c();
        this.f18584c = c2;
        return c2;
    }

    public String o() {
        return this.f17442h;
    }

    public String p() {
        return this.f17441g;
    }

    public boolean q() {
        return (this.f17440f & 2) == 2;
    }

    public boolean r() {
        return (this.f17440f & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (str != null) {
            this.f17440f |= 2;
            this.f17442h = str;
            return;
        }
        throw new NullPointerException();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if ((this.f17440f & 1) == 1) {
            codedOutputStream.b(1, p());
        }
        if ((this.f17440f & 2) == 2) {
            codedOutputStream.b(2, o());
        }
        this.f18583b.a(codedOutputStream);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        b bVar = null;
        switch (b.f17510a[methodToInvoke.ordinal()]) {
            case 1:
                return new ClientAppInfo();
            case 2:
                return f17438d;
            case 3:
                return null;
            case 4:
                return new Builder(bVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ClientAppInfo clientAppInfo = (ClientAppInfo) obj2;
                this.f17441g = visitor.a(r(), this.f17441g, clientAppInfo.r(), clientAppInfo.f17441g);
                this.f17442h = visitor.a(q(), this.f17442h, clientAppInfo.q(), clientAppInfo.f17442h);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f17440f |= clientAppInfo.f17440f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                String v = codedInputStream.v();
                                this.f17440f = 1 | this.f17440f;
                                this.f17441g = v;
                            } else if (x != 18) {
                                if (!a(x, codedInputStream)) {
                                }
                            } else {
                                String v2 = codedInputStream.v();
                                this.f17440f |= 2;
                                this.f17442h = v2;
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
                if (f17439e == null) {
                    synchronized (ClientAppInfo.class) {
                        if (f17439e == null) {
                            f17439e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17438d);
                        }
                    }
                }
                return f17439e;
            default:
                throw new UnsupportedOperationException();
        }
        return f17438d;
    }
}
