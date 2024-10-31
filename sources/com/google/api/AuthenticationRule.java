package com.google.api;

import com.google.api.OAuthRequirements;
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
public final class AuthenticationRule extends GeneratedMessageLite<AuthenticationRule, Builder> implements AuthenticationRuleOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final AuthenticationRule f14342d = new AuthenticationRule();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<AuthenticationRule> f14343e;

    /* renamed from: f, reason: collision with root package name */
    private int f14344f;

    /* renamed from: h, reason: collision with root package name */
    private OAuthRequirements f14346h;
    private boolean i;

    /* renamed from: g, reason: collision with root package name */
    private String f14345g = "";
    private Internal.ProtobufList<AuthRequirement> j = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthenticationRule, Builder> implements AuthenticationRuleOrBuilder {
        /* synthetic */ Builder(C1467e c1467e) {
            this();
        }

        private Builder() {
            super(AuthenticationRule.f14342d);
        }
    }

    static {
        f14342d.l();
    }

    private AuthenticationRule() {
    }

    public static Parser<AuthenticationRule> p() {
        return f14342d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14345g.isEmpty()) {
            codedOutputStream.b(1, o());
        }
        if (this.f14346h != null) {
            codedOutputStream.c(2, n());
        }
        boolean z = this.i;
        if (z) {
            codedOutputStream.b(5, z);
        }
        for (int i = 0; i < this.j.size(); i++) {
            codedOutputStream.c(7, this.j.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f14345g.isEmpty() ? CodedOutputStream.a(1, o()) + 0 : 0;
        if (this.f14346h != null) {
            a2 += CodedOutputStream.a(2, n());
        }
        boolean z = this.i;
        if (z) {
            a2 += CodedOutputStream.a(5, z);
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            a2 += CodedOutputStream.a(7, this.j.get(i2));
        }
        this.f18584c = a2;
        return a2;
    }

    public OAuthRequirements n() {
        OAuthRequirements oAuthRequirements = this.f14346h;
        return oAuthRequirements == null ? OAuthRequirements.o() : oAuthRequirements;
    }

    public String o() {
        return this.f14345g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1467e c1467e = null;
        switch (C1467e.f15022a[methodToInvoke.ordinal()]) {
            case 1:
                return new AuthenticationRule();
            case 2:
                return f14342d;
            case 3:
                this.j.L();
                return null;
            case 4:
                return new Builder(c1467e);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                AuthenticationRule authenticationRule = (AuthenticationRule) obj2;
                this.f14345g = visitor.a(!this.f14345g.isEmpty(), this.f14345g, true ^ authenticationRule.f14345g.isEmpty(), authenticationRule.f14345g);
                this.f14346h = (OAuthRequirements) visitor.a(this.f14346h, authenticationRule.f14346h);
                boolean z = this.i;
                boolean z2 = authenticationRule.i;
                this.i = visitor.a(z, z, z2, z2);
                this.j = visitor.a(this.j, authenticationRule.j);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14344f |= authenticationRule.f14344f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z3 = false;
                while (!z3) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f14345g = codedInputStream.w();
                            } else if (x == 18) {
                                OAuthRequirements.Builder b2 = this.f14346h != null ? this.f14346h.b() : null;
                                this.f14346h = (OAuthRequirements) codedInputStream.a(OAuthRequirements.p(), extensionRegistryLite);
                                if (b2 != null) {
                                    b2.b((OAuthRequirements.Builder) this.f14346h);
                                    this.f14346h = b2.T();
                                }
                            } else if (x == 40) {
                                this.i = codedInputStream.c();
                            } else if (x != 58) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.j.M()) {
                                    this.j = GeneratedMessageLite.a(this.j);
                                }
                                this.j.add((AuthRequirement) codedInputStream.a(AuthRequirement.p(), extensionRegistryLite));
                            }
                        }
                        z3 = true;
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
                if (f14343e == null) {
                    synchronized (AuthenticationRule.class) {
                        if (f14343e == null) {
                            f14343e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14342d);
                        }
                    }
                }
                return f14343e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14342d;
    }
}
