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
public final class Context extends GeneratedMessageLite<Context, Builder> implements ContextOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Context f14373d = new Context();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Context> f14374e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<ContextRule> f14375f = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Context, Builder> implements ContextOrBuilder {
        /* synthetic */ Builder(C1474l c1474l) {
            this();
        }

        private Builder() {
            super(Context.f14373d);
        }
    }

    static {
        f14373d.l();
    }

    private Context() {
    }

    public static Context n() {
        return f14373d;
    }

    public static Parser<Context> o() {
        return f14373d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f14375f.size(); i++) {
            codedOutputStream.c(1, this.f14375f.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14375f.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f14375f.get(i3));
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1474l c1474l = null;
        switch (C1474l.f15028a[methodToInvoke.ordinal()]) {
            case 1:
                return new Context();
            case 2:
                return f14373d;
            case 3:
                this.f14375f.L();
                return null;
            case 4:
                return new Builder(c1474l);
            case 5:
                this.f14375f = ((GeneratedMessageLite.Visitor) obj).a(this.f14375f, ((Context) obj2).f14375f);
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
                                    if (!this.f14375f.M()) {
                                        this.f14375f = GeneratedMessageLite.a(this.f14375f);
                                    }
                                    this.f14375f.add((ContextRule) codedInputStream.a(ContextRule.q(), extensionRegistryLite));
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
                if (f14374e == null) {
                    synchronized (Context.class) {
                        if (f14374e == null) {
                            f14374e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14373d);
                        }
                    }
                }
                return f14374e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14373d;
    }
}
