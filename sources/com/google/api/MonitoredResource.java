package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class MonitoredResource extends GeneratedMessageLite<MonitoredResource, Builder> implements MonitoredResourceOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final MonitoredResource f14490d = new MonitoredResource();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<MonitoredResource> f14491e;

    /* renamed from: f, reason: collision with root package name */
    private int f14492f;

    /* renamed from: h, reason: collision with root package name */
    private MapFieldLite<String, String> f14494h = MapFieldLite.emptyMapField();

    /* renamed from: g, reason: collision with root package name */
    private String f14493g = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<MonitoredResource, Builder> implements MonitoredResourceOrBuilder {
        /* synthetic */ Builder(G g2) {
            this();
        }

        private Builder() {
            super(MonitoredResource.f14490d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final MapEntryLite<String, String> f14495a;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            f14495a = MapEntryLite.a(fieldType, "", fieldType, "");
        }
    }

    static {
        f14490d.l();
    }

    private MonitoredResource() {
    }

    private MapFieldLite<String, String> o() {
        return this.f14494h;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14493g.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        for (Map.Entry<String, String> entry : o().entrySet()) {
            a.f14495a.a(codedOutputStream, 2, (int) entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f14493g.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        for (Map.Entry<String, String> entry : o().entrySet()) {
            a2 += a.f14495a.a(2, (int) entry.getKey(), entry.getValue());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14493g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        G g2 = null;
        switch (G.f14433a[methodToInvoke.ordinal()]) {
            case 1:
                return new MonitoredResource();
            case 2:
                return f14490d;
            case 3:
                this.f14494h.makeImmutable();
                return null;
            case 4:
                return new Builder(g2);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                MonitoredResource monitoredResource = (MonitoredResource) obj2;
                this.f14493g = visitor.a(!this.f14493g.isEmpty(), this.f14493g, true ^ monitoredResource.f14493g.isEmpty(), monitoredResource.f14493g);
                this.f14494h = visitor.a(this.f14494h, monitoredResource.o());
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14492f |= monitoredResource.f14492f;
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
                                this.f14493g = codedInputStream.w();
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.f14494h.isMutable()) {
                                    this.f14494h = this.f14494h.mutableCopy();
                                }
                                a.f14495a.a(this.f14494h, codedInputStream, extensionRegistryLite);
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
                if (f14491e == null) {
                    synchronized (MonitoredResource.class) {
                        if (f14491e == null) {
                            f14491e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14490d);
                        }
                    }
                }
                return f14491e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14490d;
    }
}
