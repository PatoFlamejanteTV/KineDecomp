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
public final class Http extends GeneratedMessageLite<Http, Builder> implements HttpOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Http f14435d = new Http();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Http> f14436e;

    /* renamed from: f, reason: collision with root package name */
    private int f14437f;

    /* renamed from: g, reason: collision with root package name */
    private Internal.ProtobufList<HttpRule> f14438g = GeneratedMessageLite.k();

    /* renamed from: h, reason: collision with root package name */
    private boolean f14439h;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Http, Builder> implements HttpOrBuilder {
        /* synthetic */ Builder(C1482u c1482u) {
            this();
        }

        private Builder() {
            super(Http.f14435d);
        }
    }

    static {
        f14435d.l();
    }

    private Http() {
    }

    public static Http n() {
        return f14435d;
    }

    public static Parser<Http> o() {
        return f14435d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f14438g.size(); i++) {
            codedOutputStream.c(1, this.f14438g.get(i));
        }
        boolean z = this.f14439h;
        if (z) {
            codedOutputStream.b(2, z);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14438g.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f14438g.get(i3));
        }
        boolean z = this.f14439h;
        if (z) {
            i2 += CodedOutputStream.a(2, z);
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1482u c1482u = null;
        switch (C1482u.f15039a[methodToInvoke.ordinal()]) {
            case 1:
                return new Http();
            case 2:
                return f14435d;
            case 3:
                this.f14438g.L();
                return null;
            case 4:
                return new Builder(c1482u);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Http http = (Http) obj2;
                this.f14438g = visitor.a(this.f14438g, http.f14438g);
                boolean z = this.f14439h;
                boolean z2 = http.f14439h;
                this.f14439h = visitor.a(z, z, z2, z2);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14437f |= http.f14437f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z3 = false;
                while (!z3) {
                    try {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    if (!this.f14438g.M()) {
                                        this.f14438g = GeneratedMessageLite.a(this.f14438g);
                                    }
                                    this.f14438g.add((HttpRule) codedInputStream.a(HttpRule.w(), extensionRegistryLite));
                                } else if (x != 16) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f14439h = codedInputStream.c();
                                }
                            }
                            z3 = true;
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
                if (f14436e == null) {
                    synchronized (Http.class) {
                        if (f14436e == null) {
                            f14436e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14435d);
                        }
                    }
                }
                return f14436e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14435d;
    }
}
