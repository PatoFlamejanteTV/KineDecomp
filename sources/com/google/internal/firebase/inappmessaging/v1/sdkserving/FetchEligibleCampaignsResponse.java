package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class FetchEligibleCampaignsResponse extends GeneratedMessageLite<FetchEligibleCampaignsResponse, Builder> implements FetchEligibleCampaignsResponseOrBuilder {

    /* renamed from: d */
    private static final FetchEligibleCampaignsResponse f18320d = new FetchEligibleCampaignsResponse();

    /* renamed from: e */
    private static volatile Parser<FetchEligibleCampaignsResponse> f18321e;

    /* renamed from: f */
    private int f18322f;

    /* renamed from: g */
    private Internal.ProtobufList<CampaignProto.ThickContent> f18323g = GeneratedMessageLite.k();

    /* renamed from: h */
    private long f18324h;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<FetchEligibleCampaignsResponse, Builder> implements FetchEligibleCampaignsResponseOrBuilder {
        /* synthetic */ Builder(e eVar) {
            this();
        }

        public Builder a(long j) {
            b();
            ((FetchEligibleCampaignsResponse) this.f18586b).a(j);
            return this;
        }

        private Builder() {
            super(FetchEligibleCampaignsResponse.f18320d);
        }
    }

    static {
        f18320d.l();
    }

    private FetchEligibleCampaignsResponse() {
    }

    public static FetchEligibleCampaignsResponse n() {
        return f18320d;
    }

    public static Builder q() {
        return f18320d.b();
    }

    public static Parser<FetchEligibleCampaignsResponse> r() {
        return f18320d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f18323g.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f18323g.get(i3));
        }
        long j = this.f18324h;
        if (j != 0) {
            i2 += CodedOutputStream.b(2, j);
        }
        this.f18584c = i2;
        return i2;
    }

    public long o() {
        return this.f18324h;
    }

    public List<CampaignProto.ThickContent> p() {
        return this.f18323g;
    }

    public void a(long j) {
        this.f18324h = j;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f18323g.size(); i++) {
            codedOutputStream.c(1, this.f18323g.get(i));
        }
        long j = this.f18324h;
        if (j != 0) {
            codedOutputStream.e(2, j);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (e.f18331a[methodToInvoke.ordinal()]) {
            case 1:
                return new FetchEligibleCampaignsResponse();
            case 2:
                return f18320d;
            case 3:
                this.f18323g.L();
                return null;
            case 4:
                return new Builder(null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse = (FetchEligibleCampaignsResponse) obj2;
                this.f18323g = visitor.a(this.f18323g, fetchEligibleCampaignsResponse.f18323g);
                this.f18324h = visitor.a(this.f18324h != 0, this.f18324h, fetchEligibleCampaignsResponse.f18324h != 0, fetchEligibleCampaignsResponse.f18324h);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f18322f |= fetchEligibleCampaignsResponse.f18322f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    if (!this.f18323g.M()) {
                                        this.f18323g = GeneratedMessageLite.a(this.f18323g);
                                    }
                                    this.f18323g.add((CampaignProto.ThickContent) codedInputStream.a(CampaignProto.ThickContent.t(), extensionRegistryLite));
                                } else if (x != 16) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f18324h = codedInputStream.k();
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
                if (f18321e == null) {
                    synchronized (FetchEligibleCampaignsResponse.class) {
                        if (f18321e == null) {
                            f18321e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18320d);
                        }
                    }
                }
                return f18321e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18320d;
    }
}
