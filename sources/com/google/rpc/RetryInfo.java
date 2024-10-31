package com.google.rpc;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class RetryInfo extends GeneratedMessageLite<RetryInfo, Builder> implements RetryInfoOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final RetryInfo f18883d = new RetryInfo();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<RetryInfo> f18884e;

    /* renamed from: f, reason: collision with root package name */
    private Duration f18885f;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RetryInfo, Builder> implements RetryInfoOrBuilder {
        /* synthetic */ Builder(j jVar) {
            this();
        }

        private Builder() {
            super(RetryInfo.f18883d);
        }
    }

    static {
        f18883d.l();
    }

    private RetryInfo() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f18885f != null) {
            codedOutputStream.c(1, n());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18885f != null ? 0 + CodedOutputStream.a(1, n()) : 0;
        this.f18584c = a2;
        return a2;
    }

    public Duration n() {
        Duration duration = this.f18885f;
        return duration == null ? Duration.n() : duration;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        j jVar = null;
        switch (j.f18899a[methodToInvoke.ordinal()]) {
            case 1:
                return new RetryInfo();
            case 2:
                return f18883d;
            case 3:
                return null;
            case 4:
                return new Builder(jVar);
            case 5:
                this.f18885f = (Duration) ((GeneratedMessageLite.Visitor) obj).a(this.f18885f, ((RetryInfo) obj2).f18885f);
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
                                    Duration.Builder b2 = this.f18885f != null ? this.f18885f.b() : null;
                                    this.f18885f = (Duration) codedInputStream.a(Duration.o(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((Duration.Builder) this.f18885f);
                                        this.f18885f = b2.T();
                                    }
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
                if (f18884e == null) {
                    synchronized (RetryInfo.class) {
                        if (f18884e == null) {
                            f18884e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18883d);
                        }
                    }
                }
                return f18884e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18883d;
    }
}
