package com.google.api;

import com.google.api.CustomHttpPattern;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class HttpRule extends GeneratedMessageLite<HttpRule, Builder> implements HttpRuleOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final HttpRule f14444d = new HttpRule();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<HttpRule> f14445e;

    /* renamed from: f, reason: collision with root package name */
    private int f14446f;

    /* renamed from: h, reason: collision with root package name */
    private Object f14448h;

    /* renamed from: g, reason: collision with root package name */
    private int f14447g = 0;
    private String i = "";
    private String j = "";
    private Internal.ProtobufList<HttpRule> k = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<HttpRule, Builder> implements HttpRuleOrBuilder {
        /* synthetic */ Builder(C1484w c1484w) {
            this();
        }

        private Builder() {
            super(HttpRule.f14444d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public enum PatternCase implements Internal.EnumLite {
        GET(2),
        PUT(3),
        POST(4),
        DELETE(5),
        PATCH(6),
        CUSTOM(8),
        PATTERN_NOT_SET(0);

        private final int value;

        PatternCase(int i) {
            this.value = i;
        }

        public static PatternCase forNumber(int i) {
            if (i == 0) {
                return PATTERN_NOT_SET;
            }
            if (i == 8) {
                return CUSTOM;
            }
            if (i == 2) {
                return GET;
            }
            if (i == 3) {
                return PUT;
            }
            if (i == 4) {
                return POST;
            }
            if (i == 5) {
                return DELETE;
            }
            if (i != 6) {
                return null;
            }
            return PATCH;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static PatternCase valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        f14444d.l();
    }

    private HttpRule() {
    }

    public static HttpRule o() {
        return f14444d;
    }

    public static Parser<HttpRule> w() {
        return f14444d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.i.isEmpty()) {
            codedOutputStream.b(1, v());
        }
        if (this.f14447g == 2) {
            codedOutputStream.b(2, q());
        }
        if (this.f14447g == 3) {
            codedOutputStream.b(3, u());
        }
        if (this.f14447g == 4) {
            codedOutputStream.b(4, t());
        }
        if (this.f14447g == 5) {
            codedOutputStream.b(5, p());
        }
        if (this.f14447g == 6) {
            codedOutputStream.b(6, r());
        }
        if (!this.j.isEmpty()) {
            codedOutputStream.b(7, n());
        }
        if (this.f14447g == 8) {
            codedOutputStream.c(8, (CustomHttpPattern) this.f14448h);
        }
        for (int i = 0; i < this.k.size(); i++) {
            codedOutputStream.c(11, this.k.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.i.isEmpty() ? CodedOutputStream.a(1, v()) + 0 : 0;
        if (this.f14447g == 2) {
            a2 += CodedOutputStream.a(2, q());
        }
        if (this.f14447g == 3) {
            a2 += CodedOutputStream.a(3, u());
        }
        if (this.f14447g == 4) {
            a2 += CodedOutputStream.a(4, t());
        }
        if (this.f14447g == 5) {
            a2 += CodedOutputStream.a(5, p());
        }
        if (this.f14447g == 6) {
            a2 += CodedOutputStream.a(6, r());
        }
        if (!this.j.isEmpty()) {
            a2 += CodedOutputStream.a(7, n());
        }
        if (this.f14447g == 8) {
            a2 += CodedOutputStream.a(8, (CustomHttpPattern) this.f14448h);
        }
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            a2 += CodedOutputStream.a(11, this.k.get(i2));
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.j;
    }

    public String p() {
        return this.f14447g == 5 ? (String) this.f14448h : "";
    }

    public String q() {
        return this.f14447g == 2 ? (String) this.f14448h : "";
    }

    public String r() {
        return this.f14447g == 6 ? (String) this.f14448h : "";
    }

    public PatternCase s() {
        return PatternCase.forNumber(this.f14447g);
    }

    public String t() {
        return this.f14447g == 4 ? (String) this.f14448h : "";
    }

    public String u() {
        return this.f14447g == 3 ? (String) this.f14448h : "";
    }

    public String v() {
        return this.i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1484w c1484w = null;
        switch (C1484w.f15042b[methodToInvoke.ordinal()]) {
            case 1:
                return new HttpRule();
            case 2:
                return f14444d;
            case 3:
                this.k.L();
                return null;
            case 4:
                return new Builder(c1484w);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                HttpRule httpRule = (HttpRule) obj2;
                this.i = visitor.a(!this.i.isEmpty(), this.i, !httpRule.i.isEmpty(), httpRule.i);
                this.j = visitor.a(!this.j.isEmpty(), this.j, !httpRule.j.isEmpty(), httpRule.j);
                this.k = visitor.a(this.k, httpRule.k);
                switch (C1484w.f15041a[httpRule.s().ordinal()]) {
                    case 1:
                        this.f14448h = visitor.a(this.f14447g == 2, this.f14448h, httpRule.f14448h);
                        break;
                    case 2:
                        this.f14448h = visitor.a(this.f14447g == 3, this.f14448h, httpRule.f14448h);
                        break;
                    case 3:
                        this.f14448h = visitor.a(this.f14447g == 4, this.f14448h, httpRule.f14448h);
                        break;
                    case 4:
                        this.f14448h = visitor.a(this.f14447g == 5, this.f14448h, httpRule.f14448h);
                        break;
                    case 5:
                        this.f14448h = visitor.a(this.f14447g == 6, this.f14448h, httpRule.f14448h);
                        break;
                    case 6:
                        this.f14448h = visitor.e(this.f14447g == 8, this.f14448h, httpRule.f14448h);
                        break;
                    case 7:
                        visitor.a(this.f14447g != 0);
                        break;
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    int i = httpRule.f14447g;
                    if (i != 0) {
                        this.f14447g = i;
                    }
                    this.f14446f |= httpRule.f14446f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r7) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.i = codedInputStream.w();
                            } else if (x == 18) {
                                String w = codedInputStream.w();
                                this.f14447g = 2;
                                this.f14448h = w;
                            } else if (x == 26) {
                                String w2 = codedInputStream.w();
                                this.f14447g = 3;
                                this.f14448h = w2;
                            } else if (x == 34) {
                                String w3 = codedInputStream.w();
                                this.f14447g = 4;
                                this.f14448h = w3;
                            } else if (x == 42) {
                                String w4 = codedInputStream.w();
                                this.f14447g = 5;
                                this.f14448h = w4;
                            } else if (x == 50) {
                                String w5 = codedInputStream.w();
                                this.f14447g = 6;
                                this.f14448h = w5;
                            } else if (x == 58) {
                                this.j = codedInputStream.w();
                            } else if (x == 66) {
                                CustomHttpPattern.Builder b2 = this.f14447g == 8 ? ((CustomHttpPattern) this.f14448h).b() : null;
                                this.f14448h = codedInputStream.a(CustomHttpPattern.p(), extensionRegistryLite);
                                if (b2 != null) {
                                    b2.b((CustomHttpPattern.Builder) this.f14448h);
                                    this.f14448h = b2.T();
                                }
                                this.f14447g = 8;
                            } else if (x != 90) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.k.M()) {
                                    this.k = GeneratedMessageLite.a(this.k);
                                }
                                this.k.add((HttpRule) codedInputStream.a(w(), extensionRegistryLite));
                            }
                        }
                        r7 = true;
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
                if (f14445e == null) {
                    synchronized (HttpRule.class) {
                        if (f14445e == null) {
                            f14445e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14444d);
                        }
                    }
                }
                return f14445e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14444d;
    }
}
