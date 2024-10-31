package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class BackendRule extends GeneratedMessageLite<BackendRule, Builder> implements BackendRuleOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final BackendRule f14354d = new BackendRule();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<BackendRule> f14355e;

    /* renamed from: f, reason: collision with root package name */
    private String f14356f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f14357g = "";

    /* renamed from: h, reason: collision with root package name */
    private double f14358h;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BackendRule, Builder> implements BackendRuleOrBuilder {
        /* synthetic */ Builder(C1470h c1470h) {
            this();
        }

        private Builder() {
            super(BackendRule.f14354d);
        }
    }

    static {
        f14354d.l();
    }

    private BackendRule() {
    }

    public static Parser<BackendRule> p() {
        return f14354d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14356f.isEmpty()) {
            codedOutputStream.b(1, o());
        }
        if (!this.f14357g.isEmpty()) {
            codedOutputStream.b(2, n());
        }
        double d2 = this.f14358h;
        if (d2 != 0.0d) {
            codedOutputStream.b(3, d2);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f14356f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
        if (!this.f14357g.isEmpty()) {
            a2 += CodedOutputStream.a(2, n());
        }
        double d2 = this.f14358h;
        if (d2 != 0.0d) {
            a2 += CodedOutputStream.a(3, d2);
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14357g;
    }

    public String o() {
        return this.f14356f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1470h c1470h = null;
        boolean z = false;
        switch (C1470h.f15025a[methodToInvoke.ordinal()]) {
            case 1:
                return new BackendRule();
            case 2:
                return f14354d;
            case 3:
                return null;
            case 4:
                return new Builder(c1470h);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                BackendRule backendRule = (BackendRule) obj2;
                this.f14356f = visitor.a(!this.f14356f.isEmpty(), this.f14356f, !backendRule.f14356f.isEmpty(), backendRule.f14356f);
                this.f14357g = visitor.a(!this.f14357g.isEmpty(), this.f14357g, !backendRule.f14357g.isEmpty(), backendRule.f14357g);
                this.f14358h = visitor.a(this.f14358h != 0.0d, this.f14358h, backendRule.f14358h != 0.0d, backendRule.f14358h);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f14356f = codedInputStream.w();
                            } else if (x == 18) {
                                this.f14357g = codedInputStream.w();
                            } else if (x != 25) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f14358h = codedInputStream.e();
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
                if (f14355e == null) {
                    synchronized (BackendRule.class) {
                        if (f14355e == null) {
                            f14355e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14354d);
                        }
                    }
                }
                return f14355e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14354d;
    }
}
