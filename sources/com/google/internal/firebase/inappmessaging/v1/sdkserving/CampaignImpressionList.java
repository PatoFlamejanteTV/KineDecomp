package com.google.internal.firebase.inappmessaging.v1.sdkserving;

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
public final class CampaignImpressionList extends GeneratedMessageLite<CampaignImpressionList, Builder> implements CampaignImpressionListOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final CampaignImpressionList f18307d = new CampaignImpressionList();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<CampaignImpressionList> f18308e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<CampaignImpression> f18309f = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<CampaignImpressionList, Builder> implements CampaignImpressionListOrBuilder {
        /* synthetic */ Builder(b bVar) {
            this();
        }

        public Builder a(CampaignImpression campaignImpression) {
            b();
            ((CampaignImpressionList) this.f18586b).a(campaignImpression);
            return this;
        }

        private Builder() {
            super(CampaignImpressionList.f18307d);
        }
    }

    static {
        f18307d.l();
    }

    private CampaignImpressionList() {
    }

    public static CampaignImpressionList o() {
        return f18307d;
    }

    public static Parser<CampaignImpressionList> p() {
        return f18307d.f();
    }

    private void q() {
        if (this.f18309f.M()) {
            return;
        }
        this.f18309f = GeneratedMessageLite.a(this.f18309f);
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f18309f.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f18309f.get(i3));
        }
        this.f18584c = i2;
        return i2;
    }

    public List<CampaignImpression> n() {
        return this.f18309f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignImpression campaignImpression) {
        if (campaignImpression != null) {
            q();
            this.f18309f.add(campaignImpression);
            return;
        }
        throw new NullPointerException();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f18309f.size(); i++) {
            codedOutputStream.c(1, this.f18309f.get(i));
        }
    }

    public static Builder a(CampaignImpressionList campaignImpressionList) {
        return f18307d.b().b((Builder) campaignImpressionList);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        b bVar = null;
        switch (b.f18328a[methodToInvoke.ordinal()]) {
            case 1:
                return new CampaignImpressionList();
            case 2:
                return f18307d;
            case 3:
                this.f18309f.L();
                return null;
            case 4:
                return new Builder(bVar);
            case 5:
                this.f18309f = ((GeneratedMessageLite.Visitor) obj).a(this.f18309f, ((CampaignImpressionList) obj2).f18309f);
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
                                    if (!this.f18309f.M()) {
                                        this.f18309f = GeneratedMessageLite.a(this.f18309f);
                                    }
                                    this.f18309f.add((CampaignImpression) codedInputStream.a(CampaignImpression.p(), extensionRegistryLite));
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
                if (f18308e == null) {
                    synchronized (CampaignImpressionList.class) {
                        if (f18308e == null) {
                            f18308e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18307d);
                        }
                    }
                }
                return f18308e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18307d;
    }
}
