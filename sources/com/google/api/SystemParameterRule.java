package com.google.api;

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
public final class SystemParameterRule extends GeneratedMessageLite<SystemParameterRule, Builder> implements SystemParameterRuleOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final SystemParameterRule f14553d = new SystemParameterRule();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<SystemParameterRule> f14554e;

    /* renamed from: f, reason: collision with root package name */
    private int f14555f;

    /* renamed from: g, reason: collision with root package name */
    private String f14556g = "";

    /* renamed from: h, reason: collision with root package name */
    private Internal.ProtobufList<SystemParameter> f14557h = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<SystemParameterRule, Builder> implements SystemParameterRuleOrBuilder {
        /* synthetic */ Builder(U u) {
            this();
        }

        private Builder() {
            super(SystemParameterRule.f14553d);
        }
    }

    static {
        f14553d.l();
    }

    private SystemParameterRule() {
    }

    public static Parser<SystemParameterRule> o() {
        return f14553d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14556g.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        for (int i = 0; i < this.f14557h.size(); i++) {
            codedOutputStream.c(2, this.f14557h.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f14556g.isEmpty() ? CodedOutputStream.a(1, n()) + 0 : 0;
        for (int i2 = 0; i2 < this.f14557h.size(); i2++) {
            a2 += CodedOutputStream.a(2, this.f14557h.get(i2));
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14556g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        U u = null;
        switch (U.f14562a[methodToInvoke.ordinal()]) {
            case 1:
                return new SystemParameterRule();
            case 2:
                return f14553d;
            case 3:
                this.f14557h.L();
                return null;
            case 4:
                return new Builder(u);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                SystemParameterRule systemParameterRule = (SystemParameterRule) obj2;
                this.f14556g = visitor.a(!this.f14556g.isEmpty(), this.f14556g, true ^ systemParameterRule.f14556g.isEmpty(), systemParameterRule.f14556g);
                this.f14557h = visitor.a(this.f14557h, systemParameterRule.f14557h);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14555f |= systemParameterRule.f14555f;
                }
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
                                if (x == 10) {
                                    this.f14556g = codedInputStream.w();
                                } else if (x != 18) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    if (!this.f14557h.M()) {
                                        this.f14557h = GeneratedMessageLite.a(this.f14557h);
                                    }
                                    this.f14557h.add((SystemParameter) codedInputStream.a(SystemParameter.q(), extensionRegistryLite));
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        }
                    } catch (IOException e3) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f14554e == null) {
                    synchronized (SystemParameterRule.class) {
                        if (f14554e == null) {
                            f14554e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14553d);
                        }
                    }
                }
                return f14554e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14553d;
    }
}
