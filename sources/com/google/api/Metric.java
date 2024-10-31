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
public final class Metric extends GeneratedMessageLite<Metric, Builder> implements MetricOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Metric f14473d = new Metric();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Metric> f14474e;

    /* renamed from: f, reason: collision with root package name */
    private int f14475f;

    /* renamed from: h, reason: collision with root package name */
    private MapFieldLite<String, String> f14477h = MapFieldLite.emptyMapField();

    /* renamed from: g, reason: collision with root package name */
    private String f14476g = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Metric, Builder> implements MetricOrBuilder {
        /* synthetic */ Builder(B b2) {
            this();
        }

        private Builder() {
            super(Metric.f14473d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final MapEntryLite<String, String> f14478a;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            f14478a = MapEntryLite.a(fieldType, "", fieldType, "");
        }
    }

    static {
        f14473d.l();
    }

    private Metric() {
    }

    private MapFieldLite<String, String> o() {
        return this.f14477h;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (Map.Entry<String, String> entry : o().entrySet()) {
            a.f14478a.a(codedOutputStream, 2, (int) entry.getKey(), entry.getValue());
        }
        if (this.f14476g.isEmpty()) {
            return;
        }
        codedOutputStream.b(3, n());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (Map.Entry<String, String> entry : o().entrySet()) {
            i2 += a.f14478a.a(2, (int) entry.getKey(), entry.getValue());
        }
        if (!this.f14476g.isEmpty()) {
            i2 += CodedOutputStream.a(3, n());
        }
        this.f18584c = i2;
        return i2;
    }

    public String n() {
        return this.f14476g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        B b2 = null;
        switch (B.f14350a[methodToInvoke.ordinal()]) {
            case 1:
                return new Metric();
            case 2:
                return f14473d;
            case 3:
                this.f14477h.makeImmutable();
                return null;
            case 4:
                return new Builder(b2);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Metric metric = (Metric) obj2;
                this.f14476g = visitor.a(!this.f14476g.isEmpty(), this.f14476g, true ^ metric.f14476g.isEmpty(), metric.f14476g);
                this.f14477h = visitor.a(this.f14477h, metric.o());
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14475f |= metric.f14475f;
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
                            if (x == 18) {
                                if (!this.f14477h.isMutable()) {
                                    this.f14477h = this.f14477h.mutableCopy();
                                }
                                a.f14478a.a(this.f14477h, codedInputStream, extensionRegistryLite);
                            } else if (x != 26) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f14476g = codedInputStream.w();
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
                if (f14474e == null) {
                    synchronized (Metric.class) {
                        if (f14474e == null) {
                            f14474e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14473d);
                        }
                    }
                }
                return f14474e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14473d;
    }
}
