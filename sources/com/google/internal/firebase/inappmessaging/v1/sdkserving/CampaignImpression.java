package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class CampaignImpression extends GeneratedMessageLite<CampaignImpression, Builder> implements CampaignImpressionOrBuilder {

    /* renamed from: d */
    private static final CampaignImpression f18303d = new CampaignImpression();

    /* renamed from: e */
    private static volatile Parser<CampaignImpression> f18304e;

    /* renamed from: f */
    private String f18305f = "";

    /* renamed from: g */
    private long f18306g;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<CampaignImpression, Builder> implements CampaignImpressionOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        public Builder a(String str) {
            b();
            ((CampaignImpression) this.f18586b).b(str);
            return this;
        }

        private Builder() {
            super(CampaignImpression.f18303d);
        }

        public Builder a(long j) {
            b();
            ((CampaignImpression) this.f18586b).a(j);
            return this;
        }
    }

    static {
        f18303d.l();
    }

    private CampaignImpression() {
    }

    public void b(String str) {
        if (str != null) {
            this.f18305f = str;
            return;
        }
        throw new NullPointerException();
    }

    public static Builder o() {
        return f18303d.b();
    }

    public static Parser<CampaignImpression> p() {
        return f18303d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18305f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        long j = this.f18306g;
        if (j != 0) {
            a2 += CodedOutputStream.b(2, j);
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18305f;
    }

    public void a(long j) {
        this.f18306g = j;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18305f.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        long j = this.f18306g;
        if (j != 0) {
            codedOutputStream.e(2, j);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (a.f18327a[methodToInvoke.ordinal()]) {
            case 1:
                return new CampaignImpression();
            case 2:
                return f18303d;
            case 3:
                return null;
            case 4:
                return new Builder(null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                CampaignImpression campaignImpression = (CampaignImpression) obj2;
                this.f18305f = visitor.a(!this.f18305f.isEmpty(), this.f18305f, !campaignImpression.f18305f.isEmpty(), campaignImpression.f18305f);
                this.f18306g = visitor.a(this.f18306g != 0, this.f18306g, campaignImpression.f18306g != 0, campaignImpression.f18306g);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f18305f = codedInputStream.w();
                            } else if (x != 16) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18306g = codedInputStream.k();
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
                if (f18304e == null) {
                    synchronized (CampaignImpression.class) {
                        if (f18304e == null) {
                            f18304e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18303d);
                        }
                    }
                }
                return f18304e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18303d;
    }
}
