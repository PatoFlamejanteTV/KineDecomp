package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class HttpBody extends GeneratedMessageLite<HttpBody, Builder> implements HttpBodyOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final HttpBody f14440d = new HttpBody();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<HttpBody> f14441e;

    /* renamed from: f, reason: collision with root package name */
    private String f14442f = "";

    /* renamed from: g, reason: collision with root package name */
    private ByteString f14443g = ByteString.EMPTY;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<HttpBody, Builder> implements HttpBodyOrBuilder {
        /* synthetic */ Builder(C1483v c1483v) {
            this();
        }

        private Builder() {
            super(HttpBody.f14440d);
        }
    }

    static {
        f14440d.l();
    }

    private HttpBody() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14442f.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        if (this.f14443g.isEmpty()) {
            return;
        }
        codedOutputStream.b(2, this.f14443g);
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f14442f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        if (!this.f14443g.isEmpty()) {
            a2 += CodedOutputStream.a(2, this.f14443g);
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14442f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1483v c1483v = null;
        switch (C1483v.f15040a[methodToInvoke.ordinal()]) {
            case 1:
                return new HttpBody();
            case 2:
                return f14440d;
            case 3:
                return null;
            case 4:
                return new Builder(c1483v);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                HttpBody httpBody = (HttpBody) obj2;
                this.f14442f = visitor.a(!this.f14442f.isEmpty(), this.f14442f, !httpBody.f14442f.isEmpty(), httpBody.f14442f);
                this.f14443g = visitor.a(this.f14443g != ByteString.EMPTY, this.f14443g, httpBody.f14443g != ByteString.EMPTY, httpBody.f14443g);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f14442f = codedInputStream.w();
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f14443g = codedInputStream.d();
                            }
                        }
                        r1 = true;
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
                if (f14441e == null) {
                    synchronized (HttpBody.class) {
                        if (f14441e == null) {
                            f14441e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14440d);
                        }
                    }
                }
                return f14441e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14440d;
    }
}
