package com.google.rpc;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class RequestInfo extends GeneratedMessageLite<RequestInfo, Builder> implements RequestInfoOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final RequestInfo f18874d = new RequestInfo();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<RequestInfo> f18875e;

    /* renamed from: f, reason: collision with root package name */
    private String f18876f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f18877g = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RequestInfo, Builder> implements RequestInfoOrBuilder {
        /* synthetic */ Builder(h hVar) {
            this();
        }

        private Builder() {
            super(RequestInfo.f18874d);
        }
    }

    static {
        f18874d.l();
    }

    private RequestInfo() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18876f.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        if (this.f18877g.isEmpty()) {
            return;
        }
        codedOutputStream.b(2, o());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18876f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        if (!this.f18877g.isEmpty()) {
            a2 += CodedOutputStream.a(2, o());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18876f;
    }

    public String o() {
        return this.f18877g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        h hVar = null;
        switch (h.f18897a[methodToInvoke.ordinal()]) {
            case 1:
                return new RequestInfo();
            case 2:
                return f18874d;
            case 3:
                return null;
            case 4:
                return new Builder(hVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                RequestInfo requestInfo = (RequestInfo) obj2;
                this.f18876f = visitor.a(!this.f18876f.isEmpty(), this.f18876f, !requestInfo.f18876f.isEmpty(), requestInfo.f18876f);
                this.f18877g = visitor.a(!this.f18877g.isEmpty(), this.f18877g, true ^ requestInfo.f18877g.isEmpty(), requestInfo.f18877g);
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
                                this.f18876f = codedInputStream.w();
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18877g = codedInputStream.w();
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
                if (f18875e == null) {
                    synchronized (RequestInfo.class) {
                        if (f18875e == null) {
                            f18875e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18874d);
                        }
                    }
                }
                return f18875e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18874d;
    }
}
