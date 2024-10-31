package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.developers.mobile.targeting.proto.ClientSignalsProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfo;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class FetchEligibleCampaignsRequest extends GeneratedMessageLite<FetchEligibleCampaignsRequest, Builder> implements FetchEligibleCampaignsRequestOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final FetchEligibleCampaignsRequest f18315d = new FetchEligibleCampaignsRequest();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<FetchEligibleCampaignsRequest> f18316e;

    /* renamed from: f, reason: collision with root package name */
    private int f18317f;

    /* renamed from: h, reason: collision with root package name */
    private ClientAppInfo f18319h;
    private ClientSignalsProto.ClientSignals j;

    /* renamed from: g, reason: collision with root package name */
    private String f18318g = "";
    private Internal.ProtobufList<CampaignImpression> i = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<FetchEligibleCampaignsRequest, Builder> implements FetchEligibleCampaignsRequestOrBuilder {
        /* synthetic */ Builder(d dVar) {
            this();
        }

        public Builder a(String str) {
            b();
            ((FetchEligibleCampaignsRequest) this.f18586b).b(str);
            return this;
        }

        private Builder() {
            super(FetchEligibleCampaignsRequest.f18315d);
        }

        public Builder a(ClientAppInfo clientAppInfo) {
            b();
            ((FetchEligibleCampaignsRequest) this.f18586b).a(clientAppInfo);
            return this;
        }

        public Builder a(Iterable<? extends CampaignImpression> iterable) {
            b();
            ((FetchEligibleCampaignsRequest) this.f18586b).a(iterable);
            return this;
        }

        public Builder a(ClientSignalsProto.ClientSignals clientSignals) {
            b();
            ((FetchEligibleCampaignsRequest) this.f18586b).a(clientSignals);
            return this;
        }
    }

    static {
        f18315d.l();
    }

    private FetchEligibleCampaignsRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (str != null) {
            this.f18318g = str;
            return;
        }
        throw new NullPointerException();
    }

    public static FetchEligibleCampaignsRequest o() {
        return f18315d;
    }

    public static Builder r() {
        return f18315d.b();
    }

    private void s() {
        if (this.i.M()) {
            return;
        }
        this.i = GeneratedMessageLite.a(this.i);
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f18318g.isEmpty() ? CodedOutputStream.a(1, p()) + 0 : 0;
        if (this.f18319h != null) {
            a2 += CodedOutputStream.a(2, q());
        }
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            a2 += CodedOutputStream.a(3, this.i.get(i2));
        }
        if (this.j != null) {
            a2 += CodedOutputStream.a(4, n());
        }
        this.f18584c = a2;
        return a2;
    }

    public ClientSignalsProto.ClientSignals n() {
        ClientSignalsProto.ClientSignals clientSignals = this.j;
        return clientSignals == null ? ClientSignalsProto.ClientSignals.o() : clientSignals;
    }

    public String p() {
        return this.f18318g;
    }

    public ClientAppInfo q() {
        ClientAppInfo clientAppInfo = this.f18319h;
        return clientAppInfo == null ? ClientAppInfo.p() : clientAppInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ClientAppInfo clientAppInfo) {
        if (clientAppInfo != null) {
            this.f18319h = clientAppInfo;
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Iterable<? extends CampaignImpression> iterable) {
        s();
        AbstractMessageLite.a(iterable, this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ClientSignalsProto.ClientSignals clientSignals) {
        if (clientSignals != null) {
            this.j = clientSignals;
            return;
        }
        throw new NullPointerException();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18318g.isEmpty()) {
            codedOutputStream.b(1, p());
        }
        if (this.f18319h != null) {
            codedOutputStream.c(2, q());
        }
        for (int i = 0; i < this.i.size(); i++) {
            codedOutputStream.c(3, this.i.get(i));
        }
        if (this.j != null) {
            codedOutputStream.c(4, n());
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        d dVar = null;
        switch (d.f18330a[methodToInvoke.ordinal()]) {
            case 1:
                return new FetchEligibleCampaignsRequest();
            case 2:
                return f18315d;
            case 3:
                this.i.L();
                return null;
            case 4:
                return new Builder(dVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest = (FetchEligibleCampaignsRequest) obj2;
                this.f18318g = visitor.a(!this.f18318g.isEmpty(), this.f18318g, true ^ fetchEligibleCampaignsRequest.f18318g.isEmpty(), fetchEligibleCampaignsRequest.f18318g);
                this.f18319h = (ClientAppInfo) visitor.a(this.f18319h, fetchEligibleCampaignsRequest.f18319h);
                this.i = visitor.a(this.i, fetchEligibleCampaignsRequest.i);
                this.j = (ClientSignalsProto.ClientSignals) visitor.a(this.j, fetchEligibleCampaignsRequest.j);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f18317f |= fetchEligibleCampaignsRequest.f18317f;
                }
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
                                if (x == 10) {
                                    this.f18318g = codedInputStream.w();
                                } else if (x == 18) {
                                    ClientAppInfo.Builder b2 = this.f18319h != null ? this.f18319h.b() : null;
                                    this.f18319h = (ClientAppInfo) codedInputStream.a(ClientAppInfo.s(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((ClientAppInfo.Builder) this.f18319h);
                                        this.f18319h = b2.T();
                                    }
                                } else if (x == 26) {
                                    if (!this.i.M()) {
                                        this.i = GeneratedMessageLite.a(this.i);
                                    }
                                    this.i.add((CampaignImpression) codedInputStream.a(CampaignImpression.p(), extensionRegistryLite));
                                } else if (x != 34) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    ClientSignalsProto.ClientSignals.Builder b3 = this.j != null ? this.j.b() : null;
                                    this.j = (ClientSignalsProto.ClientSignals) codedInputStream.a(ClientSignalsProto.ClientSignals.t(), extensionRegistryLite);
                                    if (b3 != null) {
                                        b3.b((ClientSignalsProto.ClientSignals.Builder) this.j);
                                        this.j = b3.T();
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
                if (f18316e == null) {
                    synchronized (FetchEligibleCampaignsRequest.class) {
                        if (f18316e == null) {
                            f18316e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18315d);
                        }
                    }
                }
                return f18316e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18315d;
    }
}
