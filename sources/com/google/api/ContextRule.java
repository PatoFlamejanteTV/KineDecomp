package com.google.api;

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
public final class ContextRule extends GeneratedMessageLite<ContextRule, Builder> implements ContextRuleOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final ContextRule f14376d = new ContextRule();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<ContextRule> f14377e;

    /* renamed from: f, reason: collision with root package name */
    private int f14378f;

    /* renamed from: g, reason: collision with root package name */
    private String f14379g = "";

    /* renamed from: h, reason: collision with root package name */
    private Internal.ProtobufList<String> f14380h = GeneratedMessageLite.k();
    private Internal.ProtobufList<String> i = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ContextRule, Builder> implements ContextRuleOrBuilder {
        /* synthetic */ Builder(C1475m c1475m) {
            this();
        }

        private Builder() {
            super(ContextRule.f14376d);
        }
    }

    static {
        f14376d.l();
    }

    private ContextRule() {
    }

    public static Parser<ContextRule> q() {
        return f14376d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14379g.isEmpty()) {
            codedOutputStream.b(1, p());
        }
        for (int i = 0; i < this.f14380h.size(); i++) {
            codedOutputStream.b(2, this.f14380h.get(i));
        }
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            codedOutputStream.b(3, this.i.get(i2));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f14379g.isEmpty() ? CodedOutputStream.a(1, p()) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14380h.size(); i3++) {
            i2 += CodedOutputStream.a(this.f14380h.get(i3));
        }
        int size = a2 + i2 + (o().size() * 1);
        int i4 = 0;
        for (int i5 = 0; i5 < this.i.size(); i5++) {
            i4 += CodedOutputStream.a(this.i.get(i5));
        }
        int size2 = size + i4 + (n().size() * 1);
        this.f18584c = size2;
        return size2;
    }

    public List<String> n() {
        return this.i;
    }

    public List<String> o() {
        return this.f14380h;
    }

    public String p() {
        return this.f14379g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1475m c1475m = null;
        switch (C1475m.f15029a[methodToInvoke.ordinal()]) {
            case 1:
                return new ContextRule();
            case 2:
                return f14376d;
            case 3:
                this.f14380h.L();
                this.i.L();
                return null;
            case 4:
                return new Builder(c1475m);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ContextRule contextRule = (ContextRule) obj2;
                this.f14379g = visitor.a(!this.f14379g.isEmpty(), this.f14379g, true ^ contextRule.f14379g.isEmpty(), contextRule.f14379g);
                this.f14380h = visitor.a(this.f14380h, contextRule.f14380h);
                this.i = visitor.a(this.i, contextRule.i);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14378f |= contextRule.f14378f;
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
                                this.f14379g = codedInputStream.w();
                            } else if (x == 18) {
                                String w = codedInputStream.w();
                                if (!this.f14380h.M()) {
                                    this.f14380h = GeneratedMessageLite.a(this.f14380h);
                                }
                                this.f14380h.add(w);
                            } else if (x != 26) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                String w2 = codedInputStream.w();
                                if (!this.i.M()) {
                                    this.i = GeneratedMessageLite.a(this.i);
                                }
                                this.i.add(w2);
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
                if (f14377e == null) {
                    synchronized (ContextRule.class) {
                        if (f14377e == null) {
                            f14377e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14376d);
                        }
                    }
                }
                return f14377e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14376d;
    }
}
