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
public final class RolloutExperimentRequest extends GeneratedMessageLite<RolloutExperimentRequest, Builder> implements RolloutExperimentRequestOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final RolloutExperimentRequest f18273d = new RolloutExperimentRequest();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<RolloutExperimentRequest> f18274e;

    /* renamed from: f, reason: collision with root package name */
    private String f18275f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f18276g = "";

    /* renamed from: h, reason: collision with root package name */
    private CampaignProto.ExperimentalCampaignRollout f18277h;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RolloutExperimentRequest, Builder> implements RolloutExperimentRequestOrBuilder {
        /* synthetic */ Builder(k kVar) {
            this();
        }

        private Builder() {
            super(RolloutExperimentRequest.f18273d);
        }
    }

    static {
        f18273d.l();
    }

    private RolloutExperimentRequest() {
    }

    public static RolloutExperimentRequest n() {
        return f18273d;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18275f.isEmpty()) {
            codedOutputStream.b(1, p());
        }
        if (!this.f18276g.isEmpty()) {
            codedOutputStream.b(2, o());
        }
        if (this.f18277h != null) {
            codedOutputStream.c(3, q());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18275f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, p());
        if (!this.f18276g.isEmpty()) {
            a2 += CodedOutputStream.a(2, o());
        }
        if (this.f18277h != null) {
            a2 += CodedOutputStream.a(3, q());
        }
        this.f18584c = a2;
        return a2;
    }

    public String o() {
        return this.f18276g;
    }

    public String p() {
        return this.f18275f;
    }

    public CampaignProto.ExperimentalCampaignRollout q() {
        CampaignProto.ExperimentalCampaignRollout experimentalCampaignRollout = this.f18277h;
        return experimentalCampaignRollout == null ? CampaignProto.ExperimentalCampaignRollout.n() : experimentalCampaignRollout;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        k kVar = null;
        switch (k.f18299a[methodToInvoke.ordinal()]) {
            case 1:
                return new RolloutExperimentRequest();
            case 2:
                return f18273d;
            case 3:
                return null;
            case 4:
                return new Builder(kVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                RolloutExperimentRequest rolloutExperimentRequest = (RolloutExperimentRequest) obj2;
                this.f18275f = visitor.a(!this.f18275f.isEmpty(), this.f18275f, !rolloutExperimentRequest.f18275f.isEmpty(), rolloutExperimentRequest.f18275f);
                this.f18276g = visitor.a(!this.f18276g.isEmpty(), this.f18276g, true ^ rolloutExperimentRequest.f18276g.isEmpty(), rolloutExperimentRequest.f18276g);
                this.f18277h = (CampaignProto.ExperimentalCampaignRollout) visitor.a(this.f18277h, rolloutExperimentRequest.f18277h);
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
                                if (x == 10) {
                                    this.f18275f = codedInputStream.w();
                                } else if (x == 18) {
                                    this.f18276g = codedInputStream.w();
                                } else if (x != 26) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    CampaignProto.ExperimentalCampaignRollout.Builder b2 = this.f18277h != null ? this.f18277h.b() : null;
                                    this.f18277h = (CampaignProto.ExperimentalCampaignRollout) codedInputStream.a(CampaignProto.ExperimentalCampaignRollout.s(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((CampaignProto.ExperimentalCampaignRollout.Builder) this.f18277h);
                                        this.f18277h = b2.T();
                                    }
                                }
                            }
                            z = true;
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw new RuntimeException(e3.setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f18274e == null) {
                    synchronized (RolloutExperimentRequest.class) {
                        if (f18274e == null) {
                            f18274e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18273d);
                        }
                    }
                }
                return f18274e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18273d;
    }
}
