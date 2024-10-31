package com.google.api;

import com.google.protobuf.Any;
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
public final class SourceInfo extends GeneratedMessageLite<SourceInfo, Builder> implements SourceInfoOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final SourceInfo f14545d = new SourceInfo();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<SourceInfo> f14546e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<Any> f14547f = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<SourceInfo, Builder> implements SourceInfoOrBuilder {
        /* synthetic */ Builder(S s) {
            this();
        }

        private Builder() {
            super(SourceInfo.f14545d);
        }
    }

    static {
        f14545d.l();
    }

    private SourceInfo() {
    }

    public static SourceInfo n() {
        return f14545d;
    }

    public static Parser<SourceInfo> o() {
        return f14545d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f14547f.size(); i++) {
            codedOutputStream.c(1, this.f14547f.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14547f.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f14547f.get(i3));
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        S s = null;
        switch (S.f14539a[methodToInvoke.ordinal()]) {
            case 1:
                return new SourceInfo();
            case 2:
                return f14545d;
            case 3:
                this.f14547f.L();
                return null;
            case 4:
                return new Builder(s);
            case 5:
                this.f14547f = ((GeneratedMessageLite.Visitor) obj).a(this.f14547f, ((SourceInfo) obj2).f14547f);
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
                                    if (!this.f14547f.M()) {
                                        this.f14547f = GeneratedMessageLite.a(this.f14547f);
                                    }
                                    this.f14547f.add((Any) codedInputStream.a(Any.p(), extensionRegistryLite));
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
                if (f14546e == null) {
                    synchronized (SourceInfo.class) {
                        if (f14546e == null) {
                            f14546e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14545d);
                        }
                    }
                }
                return f14546e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14545d;
    }
}
