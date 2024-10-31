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
public final class UpdateCampaignRequest extends GeneratedMessageLite<UpdateCampaignRequest, Builder> implements UpdateCampaignRequestOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final UpdateCampaignRequest f18286d = new UpdateCampaignRequest();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<UpdateCampaignRequest> f18287e;

    /* renamed from: f, reason: collision with root package name */
    private CampaignProto.Campaign f18288f;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<UpdateCampaignRequest, Builder> implements UpdateCampaignRequestOrBuilder {
        /* synthetic */ Builder(n nVar) {
            this();
        }

        private Builder() {
            super(UpdateCampaignRequest.f18286d);
        }
    }

    static {
        f18286d.l();
    }

    private UpdateCampaignRequest() {
    }

    public static UpdateCampaignRequest o() {
        return f18286d;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f18288f != null) {
            codedOutputStream.c(1, n());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18288f != null ? 0 + CodedOutputStream.a(1, n()) : 0;
        this.f18584c = a2;
        return a2;
    }

    public CampaignProto.Campaign n() {
        CampaignProto.Campaign campaign = this.f18288f;
        return campaign == null ? CampaignProto.Campaign.p() : campaign;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        n nVar = null;
        switch (n.f18302a[methodToInvoke.ordinal()]) {
            case 1:
                return new UpdateCampaignRequest();
            case 2:
                return f18286d;
            case 3:
                return null;
            case 4:
                return new Builder(nVar);
            case 5:
                this.f18288f = (CampaignProto.Campaign) ((GeneratedMessageLite.Visitor) obj).a(this.f18288f, ((UpdateCampaignRequest) obj2).f18288f);
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
                                    CampaignProto.Campaign.Builder b2 = this.f18288f != null ? this.f18288f.b() : null;
                                    this.f18288f = (CampaignProto.Campaign) codedInputStream.a(CampaignProto.Campaign.z(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((CampaignProto.Campaign.Builder) this.f18288f);
                                        this.f18288f = b2.T();
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
                if (f18287e == null) {
                    synchronized (UpdateCampaignRequest.class) {
                        if (f18287e == null) {
                            f18287e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18286d);
                        }
                    }
                }
                return f18287e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18286d;
    }
}
