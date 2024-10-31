package com.google.longrunning;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class GetOperationRequest extends GeneratedMessageLite<GetOperationRequest, Builder> implements GetOperationRequestOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final GetOperationRequest f18344d = new GetOperationRequest();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<GetOperationRequest> f18345e;

    /* renamed from: f, reason: collision with root package name */
    private String f18346f = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<GetOperationRequest, Builder> implements GetOperationRequestOrBuilder {
        /* synthetic */ Builder(c cVar) {
            this();
        }

        private Builder() {
            super(GetOperationRequest.f18344d);
        }
    }

    static {
        f18344d.l();
    }

    private GetOperationRequest() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f18346f.isEmpty()) {
            return;
        }
        codedOutputStream.b(1, n());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18346f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18346f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        c cVar = null;
        switch (c.f18364a[methodToInvoke.ordinal()]) {
            case 1:
                return new GetOperationRequest();
            case 2:
                return f18344d;
            case 3:
                return null;
            case 4:
                return new Builder(cVar);
            case 5:
                GetOperationRequest getOperationRequest = (GetOperationRequest) obj2;
                this.f18346f = ((GeneratedMessageLite.Visitor) obj).a(!this.f18346f.isEmpty(), this.f18346f, true ^ getOperationRequest.f18346f.isEmpty(), getOperationRequest.f18346f);
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
                                this.f18346f = codedInputStream.w();
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
                if (f18345e == null) {
                    synchronized (GetOperationRequest.class) {
                        if (f18345e == null) {
                            f18345e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18344d);
                        }
                    }
                }
                return f18345e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18344d;
    }
}
