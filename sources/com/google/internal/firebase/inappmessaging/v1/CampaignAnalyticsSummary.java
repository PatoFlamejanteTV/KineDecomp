package com.google.internal.firebase.inappmessaging.v1;

import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.internal.firebase.inappmessaging.v1.DateRange;
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
public final class CampaignAnalyticsSummary extends GeneratedMessageLite<CampaignAnalyticsSummary, Builder> implements CampaignAnalyticsSummaryOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final CampaignAnalyticsSummary f18208d = new CampaignAnalyticsSummary();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<CampaignAnalyticsSummary> f18209e;

    /* renamed from: f, reason: collision with root package name */
    private int f18210f;

    /* renamed from: h, reason: collision with root package name */
    private DateRange f18212h;
    private int i;
    private int j;
    private int l;

    /* renamed from: g, reason: collision with root package name */
    private String f18211g = "";
    private Internal.ProtobufList<CommonTypesProto.DailyAnalyticsSummary> k = GeneratedMessageLite.k();
    private Internal.ProtobufList<CommonTypesProto.DailyConversionSummary> m = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<CampaignAnalyticsSummary, Builder> implements CampaignAnalyticsSummaryOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        private Builder() {
            super(CampaignAnalyticsSummary.f18208d);
        }
    }

    static {
        f18208d.l();
    }

    private CampaignAnalyticsSummary() {
    }

    public static Parser<CampaignAnalyticsSummary> p() {
        return f18208d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18211g.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        if (this.f18212h != null) {
            codedOutputStream.c(2, o());
        }
        int i = this.i;
        if (i != 0) {
            codedOutputStream.g(3, i);
        }
        int i2 = this.j;
        if (i2 != 0) {
            codedOutputStream.g(4, i2);
        }
        for (int i3 = 0; i3 < this.k.size(); i3++) {
            codedOutputStream.c(5, this.k.get(i3));
        }
        int i4 = this.l;
        if (i4 != 0) {
            codedOutputStream.g(6, i4);
        }
        for (int i5 = 0; i5 < this.m.size(); i5++) {
            codedOutputStream.c(7, this.m.get(i5));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f18211g.isEmpty() ? CodedOutputStream.a(1, n()) + 0 : 0;
        if (this.f18212h != null) {
            a2 += CodedOutputStream.a(2, o());
        }
        int i2 = this.i;
        if (i2 != 0) {
            a2 += CodedOutputStream.c(3, i2);
        }
        int i3 = this.j;
        if (i3 != 0) {
            a2 += CodedOutputStream.c(4, i3);
        }
        int i4 = a2;
        for (int i5 = 0; i5 < this.k.size(); i5++) {
            i4 += CodedOutputStream.a(5, this.k.get(i5));
        }
        int i6 = this.l;
        if (i6 != 0) {
            i4 += CodedOutputStream.c(6, i6);
        }
        for (int i7 = 0; i7 < this.m.size(); i7++) {
            i4 += CodedOutputStream.a(7, this.m.get(i7));
        }
        this.f18584c = i4;
        return i4;
    }

    public String n() {
        return this.f18211g;
    }

    public DateRange o() {
        DateRange dateRange = this.f18212h;
        return dateRange == null ? DateRange.n() : dateRange;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18289a[methodToInvoke.ordinal()]) {
            case 1:
                return new CampaignAnalyticsSummary();
            case 2:
                return f18208d;
            case 3:
                this.k.L();
                this.m.L();
                return null;
            case 4:
                return new Builder(aVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                CampaignAnalyticsSummary campaignAnalyticsSummary = (CampaignAnalyticsSummary) obj2;
                this.f18211g = visitor.a(!this.f18211g.isEmpty(), this.f18211g, !campaignAnalyticsSummary.f18211g.isEmpty(), campaignAnalyticsSummary.f18211g);
                this.f18212h = (DateRange) visitor.a(this.f18212h, campaignAnalyticsSummary.f18212h);
                this.i = visitor.a(this.i != 0, this.i, campaignAnalyticsSummary.i != 0, campaignAnalyticsSummary.i);
                this.j = visitor.a(this.j != 0, this.j, campaignAnalyticsSummary.j != 0, campaignAnalyticsSummary.j);
                this.k = visitor.a(this.k, campaignAnalyticsSummary.k);
                this.l = visitor.a(this.l != 0, this.l, campaignAnalyticsSummary.l != 0, campaignAnalyticsSummary.l);
                this.m = visitor.a(this.m, campaignAnalyticsSummary.m);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f18210f |= campaignAnalyticsSummary.f18210f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f18211g = codedInputStream.w();
                            } else if (x == 18) {
                                DateRange.Builder b2 = this.f18212h != null ? this.f18212h.b() : null;
                                this.f18212h = (DateRange) codedInputStream.a(DateRange.o(), extensionRegistryLite);
                                if (b2 != null) {
                                    b2.b((DateRange.Builder) this.f18212h);
                                    this.f18212h = b2.T();
                                }
                            } else if (x == 24) {
                                this.i = codedInputStream.j();
                            } else if (x == 32) {
                                this.j = codedInputStream.j();
                            } else if (x == 42) {
                                if (!this.k.M()) {
                                    this.k = GeneratedMessageLite.a(this.k);
                                }
                                this.k.add((CommonTypesProto.DailyAnalyticsSummary) codedInputStream.a(CommonTypesProto.DailyAnalyticsSummary.n(), extensionRegistryLite));
                            } else if (x == 48) {
                                this.l = codedInputStream.j();
                            } else if (x != 58) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.m.M()) {
                                    this.m = GeneratedMessageLite.a(this.m);
                                }
                                this.m.add((CommonTypesProto.DailyConversionSummary) codedInputStream.a(CommonTypesProto.DailyConversionSummary.n(), extensionRegistryLite));
                            }
                        }
                        r1 = true;
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
                if (f18209e == null) {
                    synchronized (CampaignAnalyticsSummary.class) {
                        if (f18209e == null) {
                            f18209e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18208d);
                        }
                    }
                }
                return f18209e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18208d;
    }
}
