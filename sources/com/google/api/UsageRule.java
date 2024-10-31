package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class UsageRule extends GeneratedMessageLite<UsageRule, Builder> implements UsageRuleOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final UsageRule f14568d = new UsageRule();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<UsageRule> f14569e;

    /* renamed from: f, reason: collision with root package name */
    private String f14570f = "";

    /* renamed from: g, reason: collision with root package name */
    private boolean f14571g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f14572h;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<UsageRule, Builder> implements UsageRuleOrBuilder {
        /* synthetic */ Builder(X x) {
            this();
        }

        private Builder() {
            super(UsageRule.f14568d);
        }
    }

    static {
        f14568d.l();
    }

    private UsageRule() {
    }

    public static Parser<UsageRule> o() {
        return f14568d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14570f.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        boolean z = this.f14571g;
        if (z) {
            codedOutputStream.b(2, z);
        }
        boolean z2 = this.f14572h;
        if (z2) {
            codedOutputStream.b(3, z2);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f14570f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        boolean z = this.f14571g;
        if (z) {
            a2 += CodedOutputStream.a(2, z);
        }
        boolean z2 = this.f14572h;
        if (z2) {
            a2 += CodedOutputStream.a(3, z2);
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14570f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        X x = null;
        switch (X.f14575a[methodToInvoke.ordinal()]) {
            case 1:
                return new UsageRule();
            case 2:
                return f14568d;
            case 3:
                return null;
            case 4:
                return new Builder(x);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                UsageRule usageRule = (UsageRule) obj2;
                this.f14570f = visitor.a(!this.f14570f.isEmpty(), this.f14570f, true ^ usageRule.f14570f.isEmpty(), usageRule.f14570f);
                boolean z = this.f14571g;
                boolean z2 = usageRule.f14571g;
                this.f14571g = visitor.a(z, z, z2, z2);
                boolean z3 = this.f14572h;
                boolean z4 = usageRule.f14572h;
                this.f14572h = visitor.a(z3, z3, z4, z4);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z5 = false;
                while (!z5) {
                    try {
                        int x2 = codedInputStream.x();
                        if (x2 != 0) {
                            if (x2 == 10) {
                                this.f14570f = codedInputStream.w();
                            } else if (x2 == 16) {
                                this.f14571g = codedInputStream.c();
                            } else if (x2 != 24) {
                                if (!codedInputStream.f(x2)) {
                                }
                            } else {
                                this.f14572h = codedInputStream.c();
                            }
                        }
                        z5 = true;
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
                if (f14569e == null) {
                    synchronized (UsageRule.class) {
                        if (f14569e == null) {
                            f14569e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14568d);
                        }
                    }
                }
                return f14569e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14568d;
    }
}
