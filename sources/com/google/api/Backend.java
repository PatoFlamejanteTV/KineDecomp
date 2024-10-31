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
public final class Backend extends GeneratedMessageLite<Backend, Builder> implements BackendOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Backend f14351d = new Backend();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Backend> f14352e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<BackendRule> f14353f = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Backend, Builder> implements BackendOrBuilder {
        /* synthetic */ Builder(C1469g c1469g) {
            this();
        }

        private Builder() {
            super(Backend.f14351d);
        }
    }

    static {
        f14351d.l();
    }

    private Backend() {
    }

    public static Backend n() {
        return f14351d;
    }

    public static Parser<Backend> o() {
        return f14351d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f14353f.size(); i++) {
            codedOutputStream.c(1, this.f14353f.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14353f.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f14353f.get(i3));
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1469g c1469g = null;
        switch (C1469g.f15024a[methodToInvoke.ordinal()]) {
            case 1:
                return new Backend();
            case 2:
                return f14351d;
            case 3:
                this.f14353f.L();
                return null;
            case 4:
                return new Builder(c1469g);
            case 5:
                this.f14353f = ((GeneratedMessageLite.Visitor) obj).a(this.f14353f, ((Backend) obj2).f14353f);
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
                                    if (!this.f14353f.M()) {
                                        this.f14353f = GeneratedMessageLite.a(this.f14353f);
                                    }
                                    this.f14353f.add((BackendRule) codedInputStream.a(BackendRule.p(), extensionRegistryLite));
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
                if (f14352e == null) {
                    synchronized (Backend.class) {
                        if (f14352e == null) {
                            f14352e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14351d);
                        }
                    }
                }
                return f14352e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14351d;
    }
}
