package com.google.internal.firebase.inappmessaging.v1;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class DeleteCampaignRequest extends GeneratedMessageLite<DeleteCampaignRequest, Builder> implements DeleteCampaignRequestOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final DeleteCampaignRequest f18244d = new DeleteCampaignRequest();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<DeleteCampaignRequest> f18245e;

    /* renamed from: f, reason: collision with root package name */
    private String f18246f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f18247g = "";

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<DeleteCampaignRequest, Builder> implements DeleteCampaignRequestOrBuilder {
        /* synthetic */ Builder(e eVar) {
            this();
        }

        private Builder() {
            super(DeleteCampaignRequest.f18244d);
        }
    }

    static {
        f18244d.l();
    }

    private DeleteCampaignRequest() {
    }

    public static DeleteCampaignRequest o() {
        return f18244d;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18246f.isEmpty()) {
            codedOutputStream.b(1, p());
        }
        if (this.f18247g.isEmpty()) {
            return;
        }
        codedOutputStream.b(2, n());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18246f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, p());
        if (!this.f18247g.isEmpty()) {
            a2 += CodedOutputStream.a(2, n());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18247g;
    }

    public String p() {
        return this.f18246f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        e eVar = null;
        switch (e.f18294a[methodToInvoke.ordinal()]) {
            case 1:
                return new DeleteCampaignRequest();
            case 2:
                return f18244d;
            case 3:
                return null;
            case 4:
                return new Builder(eVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                DeleteCampaignRequest deleteCampaignRequest = (DeleteCampaignRequest) obj2;
                this.f18246f = visitor.a(!this.f18246f.isEmpty(), this.f18246f, !deleteCampaignRequest.f18246f.isEmpty(), deleteCampaignRequest.f18246f);
                this.f18247g = visitor.a(!this.f18247g.isEmpty(), this.f18247g, true ^ deleteCampaignRequest.f18247g.isEmpty(), deleteCampaignRequest.f18247g);
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
                                this.f18246f = codedInputStream.w();
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18247g = codedInputStream.w();
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
                if (f18245e == null) {
                    synchronized (DeleteCampaignRequest.class) {
                        if (f18245e == null) {
                            f18245e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18244d);
                        }
                    }
                }
                return f18245e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18244d;
    }
}
