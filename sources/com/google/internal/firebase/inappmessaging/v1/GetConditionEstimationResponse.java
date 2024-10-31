package com.google.internal.firebase.inappmessaging.v1;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class GetConditionEstimationResponse extends GeneratedMessageLite<GetConditionEstimationResponse, Builder> implements GetConditionEstimationResponseOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final GetConditionEstimationResponse f18252d = new GetConditionEstimationResponse();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<GetConditionEstimationResponse> f18253e;

    /* renamed from: f, reason: collision with root package name */
    private long f18254f;

    /* renamed from: g, reason: collision with root package name */
    private int f18255g;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<GetConditionEstimationResponse, Builder> implements GetConditionEstimationResponseOrBuilder {
        /* synthetic */ Builder(g gVar) {
            this();
        }

        private Builder() {
            super(GetConditionEstimationResponse.f18252d);
        }
    }

    static {
        f18252d.l();
    }

    private GetConditionEstimationResponse() {
    }

    public static GetConditionEstimationResponse n() {
        return f18252d;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.f18254f;
        if (j != 0) {
            codedOutputStream.e(1, j);
        }
        int i = this.f18255g;
        if (i != 0) {
            codedOutputStream.g(2, i);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        long j = this.f18254f;
        int b2 = j != 0 ? 0 + CodedOutputStream.b(1, j) : 0;
        int i2 = this.f18255g;
        if (i2 != 0) {
            b2 += CodedOutputStream.c(2, i2);
        }
        this.f18584c = b2;
        return b2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        g gVar = null;
        switch (g.f18296a[methodToInvoke.ordinal()]) {
            case 1:
                return new GetConditionEstimationResponse();
            case 2:
                return f18252d;
            case 3:
                return null;
            case 4:
                return new Builder(gVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                GetConditionEstimationResponse getConditionEstimationResponse = (GetConditionEstimationResponse) obj2;
                this.f18254f = visitor.a(this.f18254f != 0, this.f18254f, getConditionEstimationResponse.f18254f != 0, getConditionEstimationResponse.f18254f);
                this.f18255g = visitor.a(this.f18255g != 0, this.f18255g, getConditionEstimationResponse.f18255g != 0, getConditionEstimationResponse.f18255g);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 8) {
                                this.f18254f = codedInputStream.k();
                            } else if (x != 16) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18255g = codedInputStream.j();
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
                if (f18253e == null) {
                    synchronized (GetConditionEstimationResponse.class) {
                        if (f18253e == null) {
                            f18253e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18252d);
                        }
                    }
                }
                return f18253e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18252d;
    }
}
