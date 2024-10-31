package com.google.internal.firebase.inappmessaging.v1;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class CreateCampaignRequest extends GeneratedMessageLite<CreateCampaignRequest, Builder> implements CreateCampaignRequestOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final CreateCampaignRequest f18237d = new CreateCampaignRequest();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<CreateCampaignRequest> f18238e;

    /* renamed from: f, reason: collision with root package name */
    private CampaignProto.Campaign f18239f;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<CreateCampaignRequest, Builder> implements CreateCampaignRequestOrBuilder {
        /* synthetic */ Builder(c cVar) {
            this();
        }

        private Builder() {
            super(CreateCampaignRequest.f18237d);
        }
    }

    static {
        f18237d.l();
    }

    private CreateCampaignRequest() {
    }

    public static CreateCampaignRequest o() {
        return f18237d;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f18239f != null) {
            codedOutputStream.c(1, n());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18239f != null ? 0 + CodedOutputStream.a(1, n()) : 0;
        this.f18584c = a2;
        return a2;
    }

    public CampaignProto.Campaign n() {
        CampaignProto.Campaign campaign = this.f18239f;
        return campaign == null ? CampaignProto.Campaign.p() : campaign;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        c cVar = null;
        switch (c.f18292a[methodToInvoke.ordinal()]) {
            case 1:
                return new CreateCampaignRequest();
            case 2:
                return f18237d;
            case 3:
                return null;
            case 4:
                return new Builder(cVar);
            case 5:
                this.f18239f = (CampaignProto.Campaign) ((GeneratedMessageLite.Visitor) obj).a(this.f18239f, ((CreateCampaignRequest) obj2).f18239f);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x != 10) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    CampaignProto.Campaign.Builder b2 = this.f18239f != null ? this.f18239f.b() : null;
                                    this.f18239f = (CampaignProto.Campaign) codedInputStream.a(CampaignProto.Campaign.z(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((CampaignProto.Campaign.Builder) this.f18239f);
                                        this.f18239f = b2.T();
                                    }
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        }
                    } catch (IOException e3) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f18238e == null) {
                    synchronized (CreateCampaignRequest.class) {
                        if (f18238e == null) {
                            f18238e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18237d);
                        }
                    }
                }
                return f18238e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18237d;
    }
}
