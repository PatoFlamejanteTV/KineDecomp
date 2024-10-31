package com.google.firebase.inappmessaging;

import com.google.firebase.inappmessaging.ClientAppInfo;
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
public final class CampaignAnalytics extends GeneratedMessageLite<CampaignAnalytics, Builder> implements CampaignAnalyticsOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final CampaignAnalytics f17433d = new CampaignAnalytics();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<CampaignAnalytics> f17434e;

    /* renamed from: f, reason: collision with root package name */
    private int f17435f;

    /* renamed from: h, reason: collision with root package name */
    private Object f17437h;
    private ClientAppInfo k;
    private long l;
    private int n;

    /* renamed from: g, reason: collision with root package name */
    private int f17436g = 0;
    private String i = "";
    private String j = "";
    private String m = "";

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<CampaignAnalytics, Builder> implements CampaignAnalyticsOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        public Builder a(String str) {
            b();
            ((CampaignAnalytics) this.f18586b).b(str);
            return this;
        }

        public Builder b(String str) {
            b();
            ((CampaignAnalytics) this.f18586b).c(str);
            return this;
        }

        private Builder() {
            super(CampaignAnalytics.f17433d);
        }

        public Builder a(ClientAppInfo clientAppInfo) {
            b();
            ((CampaignAnalytics) this.f18586b).a(clientAppInfo);
            return this;
        }

        public Builder a(long j) {
            b();
            ((CampaignAnalytics) this.f18586b).a(j);
            return this;
        }

        public Builder a(EventType eventType) {
            b();
            ((CampaignAnalytics) this.f18586b).a(eventType);
            return this;
        }

        public Builder a(DismissType dismissType) {
            b();
            ((CampaignAnalytics) this.f18586b).a(dismissType);
            return this;
        }

        public Builder a(RenderErrorReason renderErrorReason) {
            b();
            ((CampaignAnalytics) this.f18586b).a(renderErrorReason);
            return this;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public enum EventCase implements Internal.EnumLite {
        EVENT_TYPE(5),
        DISMISS_TYPE(6),
        RENDER_ERROR_REASON(7),
        FETCH_ERROR_REASON(8),
        EVENT_NOT_SET(0);

        private final int value;

        EventCase(int i) {
            this.value = i;
        }

        public static EventCase forNumber(int i) {
            if (i == 0) {
                return EVENT_NOT_SET;
            }
            if (i == 5) {
                return EVENT_TYPE;
            }
            if (i == 6) {
                return DISMISS_TYPE;
            }
            if (i == 7) {
                return RENDER_ERROR_REASON;
            }
            if (i != 8) {
                return null;
            }
            return FETCH_ERROR_REASON;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static EventCase valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        f17433d.l();
    }

    private CampaignAnalytics() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (str != null) {
            this.f17435f |= 1;
            this.i = str;
            return;
        }
        throw new NullPointerException();
    }

    public static Builder x() {
        return f17433d.b();
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = (this.f17435f & 1) == 1 ? 0 + CodedOutputStream.a(1, r()) : 0;
        if ((this.f17435f & 2) == 2) {
            a2 += CodedOutputStream.a(2, n());
        }
        if ((this.f17435f & 4) == 4) {
            a2 += CodedOutputStream.a(3, o());
        }
        if ((this.f17435f & 8) == 8) {
            a2 += CodedOutputStream.b(4, this.l);
        }
        if (this.f17436g == 5) {
            a2 += CodedOutputStream.a(5, ((Integer) this.f17437h).intValue());
        }
        if (this.f17436g == 6) {
            a2 += CodedOutputStream.a(6, ((Integer) this.f17437h).intValue());
        }
        if (this.f17436g == 7) {
            a2 += CodedOutputStream.a(7, ((Integer) this.f17437h).intValue());
        }
        if (this.f17436g == 8) {
            a2 += CodedOutputStream.a(8, ((Integer) this.f17437h).intValue());
        }
        if ((this.f17435f & 256) == 256) {
            a2 += CodedOutputStream.a(9, q());
        }
        if ((this.f17435f & 512) == 512) {
            a2 += CodedOutputStream.c(10, this.n);
        }
        int c2 = a2 + this.f18583b.c();
        this.f18584c = c2;
        return c2;
    }

    public String n() {
        return this.j;
    }

    public ClientAppInfo o() {
        ClientAppInfo clientAppInfo = this.k;
        return clientAppInfo == null ? ClientAppInfo.n() : clientAppInfo;
    }

    public EventCase p() {
        return EventCase.forNumber(this.f17436g);
    }

    public String q() {
        return this.m;
    }

    public String r() {
        return this.i;
    }

    public boolean s() {
        return (this.f17435f & 2) == 2;
    }

    public boolean t() {
        return (this.f17435f & 512) == 512;
    }

    public boolean u() {
        return (this.f17435f & 8) == 8;
    }

    public boolean v() {
        return (this.f17435f & 256) == 256;
    }

    public boolean w() {
        return (this.f17435f & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (str != null) {
            this.f17435f |= 2;
            this.j = str;
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ClientAppInfo clientAppInfo) {
        if (clientAppInfo != null) {
            this.k = clientAppInfo;
            this.f17435f |= 4;
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        this.f17435f |= 8;
        this.l = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EventType eventType) {
        if (eventType != null) {
            this.f17436g = 5;
            this.f17437h = Integer.valueOf(eventType.getNumber());
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DismissType dismissType) {
        if (dismissType != null) {
            this.f17436g = 6;
            this.f17437h = Integer.valueOf(dismissType.getNumber());
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RenderErrorReason renderErrorReason) {
        if (renderErrorReason != null) {
            this.f17436g = 7;
            this.f17437h = Integer.valueOf(renderErrorReason.getNumber());
            return;
        }
        throw new NullPointerException();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if ((this.f17435f & 1) == 1) {
            codedOutputStream.b(1, r());
        }
        if ((this.f17435f & 2) == 2) {
            codedOutputStream.b(2, n());
        }
        if ((this.f17435f & 4) == 4) {
            codedOutputStream.c(3, o());
        }
        if ((this.f17435f & 8) == 8) {
            codedOutputStream.e(4, this.l);
        }
        if (this.f17436g == 5) {
            codedOutputStream.e(5, ((Integer) this.f17437h).intValue());
        }
        if (this.f17436g == 6) {
            codedOutputStream.e(6, ((Integer) this.f17437h).intValue());
        }
        if (this.f17436g == 7) {
            codedOutputStream.e(7, ((Integer) this.f17437h).intValue());
        }
        if (this.f17436g == 8) {
            codedOutputStream.e(8, ((Integer) this.f17437h).intValue());
        }
        if ((this.f17435f & 256) == 256) {
            codedOutputStream.b(9, q());
        }
        if ((this.f17435f & 512) == 512) {
            codedOutputStream.g(10, this.n);
        }
        this.f18583b.a(codedOutputStream);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x0047. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f17509b[methodToInvoke.ordinal()]) {
            case 1:
                return new CampaignAnalytics();
            case 2:
                return f17433d;
            case 3:
                return null;
            case 4:
                return new Builder(aVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                CampaignAnalytics campaignAnalytics = (CampaignAnalytics) obj2;
                this.i = visitor.a(w(), this.i, campaignAnalytics.w(), campaignAnalytics.i);
                this.j = visitor.a(s(), this.j, campaignAnalytics.s(), campaignAnalytics.j);
                this.k = (ClientAppInfo) visitor.a(this.k, campaignAnalytics.k);
                this.l = visitor.a(u(), this.l, campaignAnalytics.u(), campaignAnalytics.l);
                this.m = visitor.a(v(), this.m, campaignAnalytics.v(), campaignAnalytics.m);
                this.n = visitor.a(t(), this.n, campaignAnalytics.t(), campaignAnalytics.n);
                int i = a.f17508a[campaignAnalytics.p().ordinal()];
                if (i == 1) {
                    this.f17437h = visitor.c(this.f17436g == 5, this.f17437h, campaignAnalytics.f17437h);
                } else if (i == 2) {
                    this.f17437h = visitor.c(this.f17436g == 6, this.f17437h, campaignAnalytics.f17437h);
                } else if (i == 3) {
                    this.f17437h = visitor.c(this.f17436g == 7, this.f17437h, campaignAnalytics.f17437h);
                } else if (i == 4) {
                    this.f17437h = visitor.c(this.f17436g == 8, this.f17437h, campaignAnalytics.f17437h);
                } else if (i == 5) {
                    visitor.a(this.f17436g != 0);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    int i2 = campaignAnalytics.f17436g;
                    if (i2 != 0) {
                        this.f17436g = i2;
                    }
                    this.f17435f |= campaignAnalytics.f17435f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r9) {
                    try {
                        int x = codedInputStream.x();
                        switch (x) {
                            case 0:
                                r9 = true;
                            case 10:
                                String v = codedInputStream.v();
                                this.f17435f |= 1;
                                this.i = v;
                            case 18:
                                String v2 = codedInputStream.v();
                                this.f17435f |= 2;
                                this.j = v2;
                            case 26:
                                ClientAppInfo.Builder b2 = (this.f17435f & 4) == 4 ? this.k.b() : null;
                                this.k = (ClientAppInfo) codedInputStream.a(ClientAppInfo.t(), extensionRegistryLite);
                                if (b2 != null) {
                                    b2.b((ClientAppInfo.Builder) this.k);
                                    this.k = b2.T();
                                }
                                this.f17435f |= 4;
                            case 32:
                                this.f17435f |= 8;
                                this.l = codedInputStream.k();
                            case 40:
                                int f2 = codedInputStream.f();
                                if (EventType.forNumber(f2) == null) {
                                    super.a(5, f2);
                                } else {
                                    this.f17436g = 5;
                                    this.f17437h = Integer.valueOf(f2);
                                }
                            case 48:
                                int f3 = codedInputStream.f();
                                if (DismissType.forNumber(f3) == null) {
                                    super.a(6, f3);
                                } else {
                                    this.f17436g = 6;
                                    this.f17437h = Integer.valueOf(f3);
                                }
                            case 56:
                                int f4 = codedInputStream.f();
                                if (RenderErrorReason.forNumber(f4) == null) {
                                    super.a(7, f4);
                                } else {
                                    this.f17436g = 7;
                                    this.f17437h = Integer.valueOf(f4);
                                }
                            case 64:
                                int f5 = codedInputStream.f();
                                if (FetchErrorReason.forNumber(f5) == null) {
                                    super.a(8, f5);
                                } else {
                                    this.f17436g = 8;
                                    this.f17437h = Integer.valueOf(f5);
                                }
                            case 74:
                                String v3 = codedInputStream.v();
                                this.f17435f |= 256;
                                this.m = v3;
                            case 80:
                                this.f17435f |= 512;
                                this.n = codedInputStream.j();
                            default:
                                if (!a(x, codedInputStream)) {
                                    r9 = true;
                                }
                        }
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
                if (f17434e == null) {
                    synchronized (CampaignAnalytics.class) {
                        if (f17434e == null) {
                            f17434e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17433d);
                        }
                    }
                }
                return f17434e;
            default:
                throw new UnsupportedOperationException();
        }
        return f17433d;
    }
}
