package com.google.cloud.audit;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class RequestMetadata extends GeneratedMessageLite<RequestMetadata, Builder> implements RequestMetadataOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final RequestMetadata f15058d = new RequestMetadata();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<RequestMetadata> f15059e;

    /* renamed from: f, reason: collision with root package name */
    private String f15060f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f15061g = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RequestMetadata, Builder> implements RequestMetadataOrBuilder {
        /* synthetic */ Builder(d dVar) {
            this();
        }

        private Builder() {
            super(RequestMetadata.f15058d);
        }
    }

    static {
        f15058d.l();
    }

    private RequestMetadata() {
    }

    public static RequestMetadata p() {
        return f15058d;
    }

    public static Parser<RequestMetadata> q() {
        return f15058d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f15060f.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        if (this.f15061g.isEmpty()) {
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
        int a2 = this.f15060f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        if (!this.f15061g.isEmpty()) {
            a2 += CodedOutputStream.a(2, o());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f15060f;
    }

    public String o() {
        return this.f15061g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        d dVar = null;
        switch (d.f15065a[methodToInvoke.ordinal()]) {
            case 1:
                return new RequestMetadata();
            case 2:
                return f15058d;
            case 3:
                return null;
            case 4:
                return new Builder(dVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                RequestMetadata requestMetadata = (RequestMetadata) obj2;
                this.f15060f = visitor.a(!this.f15060f.isEmpty(), this.f15060f, !requestMetadata.f15060f.isEmpty(), requestMetadata.f15060f);
                this.f15061g = visitor.a(!this.f15061g.isEmpty(), this.f15061g, true ^ requestMetadata.f15061g.isEmpty(), requestMetadata.f15061g);
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
                                this.f15060f = codedInputStream.w();
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f15061g = codedInputStream.w();
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
                if (f15059e == null) {
                    synchronized (RequestMetadata.class) {
                        if (f15059e == null) {
                            f15059e = new GeneratedMessageLite.DefaultInstanceBasedParser(f15058d);
                        }
                    }
                }
                return f15059e;
            default:
                throw new UnsupportedOperationException();
        }
        return f15058d;
    }
}
