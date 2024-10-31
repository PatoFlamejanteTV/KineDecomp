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
public final class MetricRule extends GeneratedMessageLite<MetricRule, Builder> implements MetricRuleOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final MetricRule f14484d = new MetricRule();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<MetricRule> f14485e;

    /* renamed from: f, reason: collision with root package name */
    private int f14486f;

    /* renamed from: h, reason: collision with root package name */
    private MapFieldLite<String, Long> f14488h = MapFieldLite.emptyMapField();

    /* renamed from: g, reason: collision with root package name */
    private String f14487g = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<MetricRule, Builder> implements MetricRuleOrBuilder {
        /* synthetic */ Builder(F f2) {
            this();
        }

        private Builder() {
            super(MetricRule.f14484d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final MapEntryLite<String, Long> f14489a = MapEntryLite.a(WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, 0L);
    }

    static {
        f14484d.l();
    }

    private MetricRule() {
    }

    public static Parser<MetricRule> o() {
        return f14484d.f();
    }

    private MapFieldLite<String, Long> p() {
        return this.f14488h;
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14487g.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        for (Map.Entry<String, Long> entry : p().entrySet()) {
            a.f14489a.a(codedOutputStream, 2, (int) entry.getKey(), (String) entry.getValue());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f14487g.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        for (Map.Entry<String, Long> entry : p().entrySet()) {
            a2 += a.f14489a.a(2, (int) entry.getKey(), (String) entry.getValue());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14487g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        F f2 = null;
        switch (F.f14432a[methodToInvoke.ordinal()]) {
            case 1:
                return new MetricRule();
            case 2:
                return f14484d;
            case 3:
                this.f14488h.makeImmutable();
                return null;
            case 4:
                return new Builder(f2);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                MetricRule metricRule = (MetricRule) obj2;
                this.f14487g = visitor.a(!this.f14487g.isEmpty(), this.f14487g, true ^ metricRule.f14487g.isEmpty(), metricRule.f14487g);
                this.f14488h = visitor.a(this.f14488h, metricRule.p());
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14486f |= metricRule.f14486f;
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
                                this.f14487g = codedInputStream.w();
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.f14488h.isMutable()) {
                                    this.f14488h = this.f14488h.mutableCopy();
                                }
                                a.f14489a.a(this.f14488h, codedInputStream, extensionRegistryLite);
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
                if (f14485e == null) {
                    synchronized (MetricRule.class) {
                        if (f14485e == null) {
                            f14485e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14484d);
                        }
                    }
                }
                return f14485e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14484d;
    }
}
