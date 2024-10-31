package com.google.internal.firebase.inappmessaging.v1;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
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
public final class RolloutExperimentResponse extends GeneratedMessageLite<RolloutExperimentResponse, Builder> implements RolloutExperimentResponseOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final RolloutExperimentResponse f18278d = new RolloutExperimentResponse();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<RolloutExperimentResponse> f18279e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<CampaignProto.Campaign> f18280f = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RolloutExperimentResponse, Builder> implements RolloutExperimentResponseOrBuilder {
        /* synthetic */ Builder(l lVar) {
            this();
        }

        private Builder() {
            super(RolloutExperimentResponse.f18278d);
        }
    }

    static {
        f18278d.l();
    }

    private RolloutExperimentResponse() {
    }

    public static RolloutExperimentResponse n() {
        return f18278d;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f18280f.size(); i++) {
            codedOutputStream.c(1, this.f18280f.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f18280f.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f18280f.get(i3));
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        l lVar = null;
        switch (l.f18300a[methodToInvoke.ordinal()]) {
            case 1:
                return new RolloutExperimentResponse();
            case 2:
                return f18278d;
            case 3:
                this.f18280f.L();
                return null;
            case 4:
                return new Builder(lVar);
            case 5:
                this.f18280f = ((GeneratedMessageLite.Visitor) obj).a(this.f18280f, ((RolloutExperimentResponse) obj2).f18280f);
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
                                    if (!this.f18280f.M()) {
                                        this.f18280f = GeneratedMessageLite.a(this.f18280f);
                                    }
                                    this.f18280f.add((CampaignProto.Campaign) codedInputStream.a(CampaignProto.Campaign.z(), extensionRegistryLite));
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
                if (f18279e == null) {
                    synchronized (RolloutExperimentResponse.class) {
                        if (f18279e == null) {
                            f18279e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18278d);
                        }
                    }
                }
                return f18279e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18278d;
    }
}
