package com.google.internal.firebase.inappmessaging.v1;

import com.google.developers.mobile.targeting.proto.Conditions;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class GetConditionEstimationRequest extends GeneratedMessageLite<GetConditionEstimationRequest, Builder> implements GetConditionEstimationRequestOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final GetConditionEstimationRequest f18248d = new GetConditionEstimationRequest();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<GetConditionEstimationRequest> f18249e;

    /* renamed from: f, reason: collision with root package name */
    private String f18250f = "";

    /* renamed from: g, reason: collision with root package name */
    private Conditions.Condition f18251g;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<GetConditionEstimationRequest, Builder> implements GetConditionEstimationRequestOrBuilder {
        /* synthetic */ Builder(f fVar) {
            this();
        }

        private Builder() {
            super(GetConditionEstimationRequest.f18248d);
        }
    }

    static {
        f18248d.l();
    }

    private GetConditionEstimationRequest() {
    }

    public static GetConditionEstimationRequest n() {
        return f18248d;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18250f.isEmpty()) {
            codedOutputStream.b(1, o());
        }
        if (this.f18251g != null) {
            codedOutputStream.c(2, p());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18250f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
        if (this.f18251g != null) {
            a2 += CodedOutputStream.a(2, p());
        }
        this.f18584c = a2;
        return a2;
    }

    public String o() {
        return this.f18250f;
    }

    public Conditions.Condition p() {
        Conditions.Condition condition = this.f18251g;
        return condition == null ? Conditions.Condition.o() : condition;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        f fVar = null;
        switch (f.f18295a[methodToInvoke.ordinal()]) {
            case 1:
                return new GetConditionEstimationRequest();
            case 2:
                return f18248d;
            case 3:
                return null;
            case 4:
                return new Builder(fVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                GetConditionEstimationRequest getConditionEstimationRequest = (GetConditionEstimationRequest) obj2;
                this.f18250f = visitor.a(!this.f18250f.isEmpty(), this.f18250f, true ^ getConditionEstimationRequest.f18250f.isEmpty(), getConditionEstimationRequest.f18250f);
                this.f18251g = (Conditions.Condition) visitor.a(this.f18251g, getConditionEstimationRequest.f18251g);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f18250f = codedInputStream.w();
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                Conditions.Condition.Builder b2 = this.f18251g != null ? this.f18251g.b() : null;
                                this.f18251g = (Conditions.Condition) codedInputStream.a(Conditions.Condition.p(), extensionRegistryLite);
                                if (b2 != null) {
                                    b2.b((Conditions.Condition.Builder) this.f18251g);
                                    this.f18251g = b2.T();
                                }
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
                if (f18249e == null) {
                    synchronized (GetConditionEstimationRequest.class) {
                        if (f18249e == null) {
                            f18249e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18248d);
                        }
                    }
                }
                return f18249e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18248d;
    }
}
