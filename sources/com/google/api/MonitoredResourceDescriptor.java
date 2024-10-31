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
public final class MonitoredResourceDescriptor extends GeneratedMessageLite<MonitoredResourceDescriptor, Builder> implements MonitoredResourceDescriptorOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final MonitoredResourceDescriptor f14496d = new MonitoredResourceDescriptor();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<MonitoredResourceDescriptor> f14497e;

    /* renamed from: f, reason: collision with root package name */
    private int f14498f;

    /* renamed from: g, reason: collision with root package name */
    private String f14499g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f14500h = "";
    private String i = "";
    private String j = "";
    private Internal.ProtobufList<LabelDescriptor> k = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<MonitoredResourceDescriptor, Builder> implements MonitoredResourceDescriptorOrBuilder {
        /* synthetic */ Builder(H h2) {
            this();
        }

        private Builder() {
            super(MonitoredResourceDescriptor.f14496d);
        }
    }

    static {
        f14496d.l();
    }

    private MonitoredResourceDescriptor() {
    }

    public static Parser<MonitoredResourceDescriptor> r() {
        return f14496d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14500h.isEmpty()) {
            codedOutputStream.b(1, q());
        }
        if (!this.i.isEmpty()) {
            codedOutputStream.b(2, o());
        }
        if (!this.j.isEmpty()) {
            codedOutputStream.b(3, n());
        }
        for (int i = 0; i < this.k.size(); i++) {
            codedOutputStream.c(4, this.k.get(i));
        }
        if (this.f14499g.isEmpty()) {
            return;
        }
        codedOutputStream.b(5, p());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f14500h.isEmpty() ? CodedOutputStream.a(1, q()) + 0 : 0;
        if (!this.i.isEmpty()) {
            a2 += CodedOutputStream.a(2, o());
        }
        if (!this.j.isEmpty()) {
            a2 += CodedOutputStream.a(3, n());
        }
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            a2 += CodedOutputStream.a(4, this.k.get(i2));
        }
        if (!this.f14499g.isEmpty()) {
            a2 += CodedOutputStream.a(5, p());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.j;
    }

    public String o() {
        return this.i;
    }

    public String p() {
        return this.f14499g;
    }

    public String q() {
        return this.f14500h;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        H h2 = null;
        switch (H.f14434a[methodToInvoke.ordinal()]) {
            case 1:
                return new MonitoredResourceDescriptor();
            case 2:
                return f14496d;
            case 3:
                this.k.L();
                return null;
            case 4:
                return new Builder(h2);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                MonitoredResourceDescriptor monitoredResourceDescriptor = (MonitoredResourceDescriptor) obj2;
                this.f14499g = visitor.a(!this.f14499g.isEmpty(), this.f14499g, !monitoredResourceDescriptor.f14499g.isEmpty(), monitoredResourceDescriptor.f14499g);
                this.f14500h = visitor.a(!this.f14500h.isEmpty(), this.f14500h, !monitoredResourceDescriptor.f14500h.isEmpty(), monitoredResourceDescriptor.f14500h);
                this.i = visitor.a(!this.i.isEmpty(), this.i, !monitoredResourceDescriptor.i.isEmpty(), monitoredResourceDescriptor.i);
                this.j = visitor.a(!this.j.isEmpty(), this.j, true ^ monitoredResourceDescriptor.j.isEmpty(), monitoredResourceDescriptor.j);
                this.k = visitor.a(this.k, monitoredResourceDescriptor.k);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14498f |= monitoredResourceDescriptor.f14498f;
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
                                this.f14500h = codedInputStream.w();
                            } else if (x == 18) {
                                this.i = codedInputStream.w();
                            } else if (x == 26) {
                                this.j = codedInputStream.w();
                            } else if (x == 34) {
                                if (!this.k.M()) {
                                    this.k = GeneratedMessageLite.a(this.k);
                                }
                                this.k.add((LabelDescriptor) codedInputStream.a(LabelDescriptor.p(), extensionRegistryLite));
                            } else if (x != 42) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f14499g = codedInputStream.w();
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
                if (f14497e == null) {
                    synchronized (MonitoredResourceDescriptor.class) {
                        if (f14497e == null) {
                            f14497e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14496d);
                        }
                    }
                }
                return f14497e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14496d;
    }
}
