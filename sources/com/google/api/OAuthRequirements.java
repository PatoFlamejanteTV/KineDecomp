package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class OAuthRequirements extends GeneratedMessageLite<OAuthRequirements, Builder> implements OAuthRequirementsOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final OAuthRequirements f14511d = new OAuthRequirements();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<OAuthRequirements> f14512e;

    /* renamed from: f, reason: collision with root package name */
    private String f14513f = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<OAuthRequirements, Builder> implements OAuthRequirementsOrBuilder {
        /* synthetic */ Builder(J j) {
            this();
        }

        private Builder() {
            super(OAuthRequirements.f14511d);
        }
    }

    static {
        f14511d.l();
    }

    private OAuthRequirements() {
    }

    public static OAuthRequirements o() {
        return f14511d;
    }

    public static Parser<OAuthRequirements> p() {
        return f14511d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f14513f.isEmpty()) {
            return;
        }
        codedOutputStream.b(1, n());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f14513f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14513f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        J j = null;
        switch (J.f14450a[methodToInvoke.ordinal()]) {
            case 1:
                return new OAuthRequirements();
            case 2:
                return f14511d;
            case 3:
                return null;
            case 4:
                return new Builder(j);
            case 5:
                OAuthRequirements oAuthRequirements = (OAuthRequirements) obj2;
                this.f14513f = ((GeneratedMessageLite.Visitor) obj).a(!this.f14513f.isEmpty(), this.f14513f, true ^ oAuthRequirements.f14513f.isEmpty(), oAuthRequirements.f14513f);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x != 10) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f14513f = codedInputStream.w();
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
                if (f14512e == null) {
                    synchronized (OAuthRequirements.class) {
                        if (f14512e == null) {
                            f14512e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14511d);
                        }
                    }
                }
                return f14512e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14511d;
    }
}
