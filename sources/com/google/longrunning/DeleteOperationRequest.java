package com.google.longrunning;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class DeleteOperationRequest extends GeneratedMessageLite<DeleteOperationRequest, Builder> implements DeleteOperationRequestOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final DeleteOperationRequest f18341d = new DeleteOperationRequest();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<DeleteOperationRequest> f18342e;

    /* renamed from: f, reason: collision with root package name */
    private String f18343f = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<DeleteOperationRequest, Builder> implements DeleteOperationRequestOrBuilder {
        /* synthetic */ Builder(b bVar) {
            this();
        }

        private Builder() {
            super(DeleteOperationRequest.f18341d);
        }
    }

    static {
        f18341d.l();
    }

    private DeleteOperationRequest() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f18343f.isEmpty()) {
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
        int a2 = this.f18343f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18343f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        b bVar = null;
        switch (b.f18363a[methodToInvoke.ordinal()]) {
            case 1:
                return new DeleteOperationRequest();
            case 2:
                return f18341d;
            case 3:
                return null;
            case 4:
                return new Builder(bVar);
            case 5:
                DeleteOperationRequest deleteOperationRequest = (DeleteOperationRequest) obj2;
                this.f18343f = ((GeneratedMessageLite.Visitor) obj).a(!this.f18343f.isEmpty(), this.f18343f, true ^ deleteOperationRequest.f18343f.isEmpty(), deleteOperationRequest.f18343f);
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
                                this.f18343f = codedInputStream.w();
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
                if (f18342e == null) {
                    synchronized (DeleteOperationRequest.class) {
                        if (f18342e == null) {
                            f18342e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18341d);
                        }
                    }
                }
                return f18342e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18341d;
    }
}
