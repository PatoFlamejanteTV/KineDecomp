package com.google.rpc;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class DebugInfo extends GeneratedMessageLite<DebugInfo, Builder> implements DebugInfoOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final DebugInfo f18843d = new DebugInfo();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<DebugInfo> f18844e;

    /* renamed from: f, reason: collision with root package name */
    private int f18845f;

    /* renamed from: g, reason: collision with root package name */
    private Internal.ProtobufList<String> f18846g = GeneratedMessageLite.k();

    /* renamed from: h, reason: collision with root package name */
    private String f18847h = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<DebugInfo, Builder> implements DebugInfoOrBuilder {
        /* synthetic */ Builder(c cVar) {
            this();
        }

        private Builder() {
            super(DebugInfo.f18843d);
        }
    }

    static {
        f18843d.l();
    }

    private DebugInfo() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f18846g.size(); i++) {
            codedOutputStream.b(1, this.f18846g.get(i));
        }
        if (this.f18847h.isEmpty()) {
            return;
        }
        codedOutputStream.b(2, n());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f18846g.size(); i3++) {
            i2 += CodedOutputStream.a(this.f18846g.get(i3));
        }
        int size = 0 + i2 + (o().size() * 1);
        if (!this.f18847h.isEmpty()) {
            size += CodedOutputStream.a(2, n());
        }
        this.f18584c = size;
        return size;
    }

    public String n() {
        return this.f18847h;
    }

    public List<String> o() {
        return this.f18846g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        c cVar = null;
        switch (c.f18892a[methodToInvoke.ordinal()]) {
            case 1:
                return new DebugInfo();
            case 2:
                return f18843d;
            case 3:
                this.f18846g.L();
                return null;
            case 4:
                return new Builder(cVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                DebugInfo debugInfo = (DebugInfo) obj2;
                this.f18846g = visitor.a(this.f18846g, debugInfo.f18846g);
                this.f18847h = visitor.a(!this.f18847h.isEmpty(), this.f18847h, true ^ debugInfo.f18847h.isEmpty(), debugInfo.f18847h);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f18845f |= debugInfo.f18845f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                String w = codedInputStream.w();
                                if (!this.f18846g.M()) {
                                    this.f18846g = GeneratedMessageLite.a(this.f18846g);
                                }
                                this.f18846g.add(w);
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18847h = codedInputStream.w();
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
                if (f18844e == null) {
                    synchronized (DebugInfo.class) {
                        if (f18844e == null) {
                            f18844e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18843d);
                        }
                    }
                }
                return f18844e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18843d;
    }
}
