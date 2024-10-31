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
public final class Quota extends GeneratedMessageLite<Quota, Builder> implements QuotaOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Quota f14529d = new Quota();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Quota> f14530e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<QuotaLimit> f14531f = GeneratedMessageLite.k();

    /* renamed from: g, reason: collision with root package name */
    private Internal.ProtobufList<MetricRule> f14532g = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Quota, Builder> implements QuotaOrBuilder {
        /* synthetic */ Builder(O o) {
            this();
        }

        private Builder() {
            super(Quota.f14529d);
        }
    }

    static {
        f14529d.l();
    }

    private Quota() {
    }

    public static Quota n() {
        return f14529d;
    }

    public static Parser<Quota> o() {
        return f14529d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f14531f.size(); i++) {
            codedOutputStream.c(3, this.f14531f.get(i));
        }
        for (int i2 = 0; i2 < this.f14532g.size(); i2++) {
            codedOutputStream.c(4, this.f14532g.get(i2));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14531f.size(); i3++) {
            i2 += CodedOutputStream.a(3, this.f14531f.get(i3));
        }
        for (int i4 = 0; i4 < this.f14532g.size(); i4++) {
            i2 += CodedOutputStream.a(4, this.f14532g.get(i4));
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        O o = null;
        switch (O.f14510a[methodToInvoke.ordinal()]) {
            case 1:
                return new Quota();
            case 2:
                return f14529d;
            case 3:
                this.f14531f.L();
                this.f14532g.L();
                return null;
            case 4:
                return new Builder(o);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Quota quota = (Quota) obj2;
                this.f14531f = visitor.a(this.f14531f, quota.f14531f);
                this.f14532g = visitor.a(this.f14532g, quota.f14532g);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 26) {
                                if (!this.f14531f.M()) {
                                    this.f14531f = GeneratedMessageLite.a(this.f14531f);
                                }
                                this.f14531f.add((QuotaLimit) codedInputStream.a(QuotaLimit.t(), extensionRegistryLite));
                            } else if (x != 34) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.f14532g.M()) {
                                    this.f14532g = GeneratedMessageLite.a(this.f14532g);
                                }
                                this.f14532g.add((MetricRule) codedInputStream.a(MetricRule.o(), extensionRegistryLite));
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
                if (f14530e == null) {
                    synchronized (Quota.class) {
                        if (f14530e == null) {
                            f14530e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14529d);
                        }
                    }
                }
                return f14530e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14529d;
    }
}
