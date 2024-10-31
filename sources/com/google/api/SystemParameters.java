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
public final class SystemParameters extends GeneratedMessageLite<SystemParameters, Builder> implements SystemParametersOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final SystemParameters f14558d = new SystemParameters();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<SystemParameters> f14559e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<SystemParameterRule> f14560f = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<SystemParameters, Builder> implements SystemParametersOrBuilder {
        /* synthetic */ Builder(V v) {
            this();
        }

        private Builder() {
            super(SystemParameters.f14558d);
        }
    }

    static {
        f14558d.l();
    }

    private SystemParameters() {
    }

    public static SystemParameters n() {
        return f14558d;
    }

    public static Parser<SystemParameters> o() {
        return f14558d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f14560f.size(); i++) {
            codedOutputStream.c(1, this.f14560f.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14560f.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f14560f.get(i3));
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        V v = null;
        switch (V.f14573a[methodToInvoke.ordinal()]) {
            case 1:
                return new SystemParameters();
            case 2:
                return f14558d;
            case 3:
                this.f14560f.L();
                return null;
            case 4:
                return new Builder(v);
            case 5:
                this.f14560f = ((GeneratedMessageLite.Visitor) obj).a(this.f14560f, ((SystemParameters) obj2).f14560f);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
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
                                if (x != 10) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    if (!this.f14560f.M()) {
                                        this.f14560f = GeneratedMessageLite.a(this.f14560f);
                                    }
                                    this.f14560f.add((SystemParameterRule) codedInputStream.a(SystemParameterRule.o(), extensionRegistryLite));
                                }
                            }
                            z = true;
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw new RuntimeException(e3.setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f14559e == null) {
                    synchronized (SystemParameters.class) {
                        if (f14559e == null) {
                            f14559e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14558d);
                        }
                    }
                }
                return f14559e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14558d;
    }
}
