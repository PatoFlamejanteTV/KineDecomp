package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Usage extends GeneratedMessageLite<Usage, Builder> implements UsageOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Usage f14563d = new Usage();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Usage> f14564e;

    /* renamed from: f, reason: collision with root package name */
    private int f14565f;

    /* renamed from: g, reason: collision with root package name */
    private Internal.ProtobufList<String> f14566g = GeneratedMessageLite.k();

    /* renamed from: h, reason: collision with root package name */
    private Internal.ProtobufList<UsageRule> f14567h = GeneratedMessageLite.k();
    private String i = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Usage, Builder> implements UsageOrBuilder {
        /* synthetic */ Builder(W w) {
            this();
        }

        private Builder() {
            super(Usage.f14563d);
        }
    }

    static {
        f14563d.l();
    }

    private Usage() {
    }

    public static Usage n() {
        return f14563d;
    }

    public static Parser<Usage> q() {
        return f14563d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f14566g.size(); i++) {
            codedOutputStream.b(1, this.f14566g.get(i));
        }
        for (int i2 = 0; i2 < this.f14567h.size(); i2++) {
            codedOutputStream.c(6, this.f14567h.get(i2));
        }
        if (this.i.isEmpty()) {
            return;
        }
        codedOutputStream.b(7, o());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14566g.size(); i3++) {
            i2 += CodedOutputStream.a(this.f14566g.get(i3));
        }
        int size = i2 + 0 + (p().size() * 1);
        for (int i4 = 0; i4 < this.f14567h.size(); i4++) {
            size += CodedOutputStream.a(6, this.f14567h.get(i4));
        }
        if (!this.i.isEmpty()) {
            size += CodedOutputStream.a(7, o());
        }
        this.f18584c = size;
        return size;
    }

    public String o() {
        return this.i;
    }

    public List<String> p() {
        return this.f14566g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        W w = null;
        switch (W.f14574a[methodToInvoke.ordinal()]) {
            case 1:
                return new Usage();
            case 2:
                return f14563d;
            case 3:
                this.f14566g.L();
                this.f14567h.L();
                return null;
            case 4:
                return new Builder(w);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Usage usage = (Usage) obj2;
                this.f14566g = visitor.a(this.f14566g, usage.f14566g);
                this.f14567h = visitor.a(this.f14567h, usage.f14567h);
                this.i = visitor.a(!this.i.isEmpty(), this.i, true ^ usage.i.isEmpty(), usage.i);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14565f |= usage.f14565f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                String w2 = codedInputStream.w();
                                if (!this.f14566g.M()) {
                                    this.f14566g = GeneratedMessageLite.a(this.f14566g);
                                }
                                this.f14566g.add(w2);
                            } else if (x == 50) {
                                if (!this.f14567h.M()) {
                                    this.f14567h = GeneratedMessageLite.a(this.f14567h);
                                }
                                this.f14567h.add((UsageRule) codedInputStream.a(UsageRule.o(), extensionRegistryLite));
                            } else if (x != 58) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.i = codedInputStream.w();
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
                if (f14564e == null) {
                    synchronized (Usage.class) {
                        if (f14564e == null) {
                            f14564e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14563d);
                        }
                    }
                }
                return f14564e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14563d;
    }
}
