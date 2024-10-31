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
public final class ListCampaignsResponse extends GeneratedMessageLite<ListCampaignsResponse, Builder> implements ListCampaignsResponseOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final ListCampaignsResponse f18269d = new ListCampaignsResponse();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<ListCampaignsResponse> f18270e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<CampaignProto.Campaign> f18271f = GeneratedMessageLite.k();

    /* renamed from: g, reason: collision with root package name */
    private Internal.ProtobufList<CampaignAnalyticsSummary> f18272g = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ListCampaignsResponse, Builder> implements ListCampaignsResponseOrBuilder {
        /* synthetic */ Builder(j jVar) {
            this();
        }

        private Builder() {
            super(ListCampaignsResponse.f18269d);
        }
    }

    static {
        f18269d.l();
    }

    private ListCampaignsResponse() {
    }

    public static ListCampaignsResponse n() {
        return f18269d;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f18271f.size(); i++) {
            codedOutputStream.c(1, this.f18271f.get(i));
        }
        for (int i2 = 0; i2 < this.f18272g.size(); i2++) {
            codedOutputStream.c(2, this.f18272g.get(i2));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f18271f.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f18271f.get(i3));
        }
        for (int i4 = 0; i4 < this.f18272g.size(); i4++) {
            i2 += CodedOutputStream.a(2, this.f18272g.get(i4));
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        j jVar = null;
        switch (j.f18298a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListCampaignsResponse();
            case 2:
                return f18269d;
            case 3:
                this.f18271f.L();
                this.f18272g.L();
                return null;
            case 4:
                return new Builder(jVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ListCampaignsResponse listCampaignsResponse = (ListCampaignsResponse) obj2;
                this.f18271f = visitor.a(this.f18271f, listCampaignsResponse.f18271f);
                this.f18272g = visitor.a(this.f18272g, listCampaignsResponse.f18272g);
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
                                if (!this.f18271f.M()) {
                                    this.f18271f = GeneratedMessageLite.a(this.f18271f);
                                }
                                this.f18271f.add((CampaignProto.Campaign) codedInputStream.a(CampaignProto.Campaign.z(), extensionRegistryLite));
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.f18272g.M()) {
                                    this.f18272g = GeneratedMessageLite.a(this.f18272g);
                                }
                                this.f18272g.add((CampaignAnalyticsSummary) codedInputStream.a(CampaignAnalyticsSummary.p(), extensionRegistryLite));
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
                if (f18270e == null) {
                    synchronized (ListCampaignsResponse.class) {
                        if (f18270e == null) {
                            f18270e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18269d);
                        }
                    }
                }
                return f18270e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18269d;
    }
}
