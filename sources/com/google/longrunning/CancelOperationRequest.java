package com.google.longrunning;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class CancelOperationRequest extends GeneratedMessageLite<CancelOperationRequest, Builder> implements CancelOperationRequestOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final CancelOperationRequest f18338d = new CancelOperationRequest();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<CancelOperationRequest> f18339e;

    /* renamed from: f, reason: collision with root package name */
    private String f18340f = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<CancelOperationRequest, Builder> implements CancelOperationRequestOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        private Builder() {
            super(CancelOperationRequest.f18338d);
        }
    }

    static {
        f18338d.l();
    }

    private CancelOperationRequest() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f18340f.isEmpty()) {
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
        int a2 = this.f18340f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18340f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18362a[methodToInvoke.ordinal()]) {
            case 1:
                return new CancelOperationRequest();
            case 2:
                return f18338d;
            case 3:
                return null;
            case 4:
                return new Builder(aVar);
            case 5:
                CancelOperationRequest cancelOperationRequest = (CancelOperationRequest) obj2;
                this.f18340f = ((GeneratedMessageLite.Visitor) obj).a(!this.f18340f.isEmpty(), this.f18340f, true ^ cancelOperationRequest.f18340f.isEmpty(), cancelOperationRequest.f18340f);
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
                                this.f18340f = codedInputStream.w();
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
                if (f18339e == null) {
                    synchronized (CancelOperationRequest.class) {
                        if (f18339e == null) {
                            f18339e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18338d);
                        }
                    }
                }
                return f18339e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18338d;
    }
}
