package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class DocumentationRule extends GeneratedMessageLite<DocumentationRule, Builder> implements DocumentationRuleOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final DocumentationRule f14419d = new DocumentationRule();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<DocumentationRule> f14420e;

    /* renamed from: f, reason: collision with root package name */
    private String f14421f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f14422g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f14423h = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentationRule, Builder> implements DocumentationRuleOrBuilder {
        /* synthetic */ Builder(r rVar) {
            this();
        }

        private Builder() {
            super(DocumentationRule.f14419d);
        }
    }

    static {
        f14419d.l();
    }

    private DocumentationRule() {
    }

    public static Parser<DocumentationRule> q() {
        return f14419d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14421f.isEmpty()) {
            codedOutputStream.b(1, p());
        }
        if (!this.f14422g.isEmpty()) {
            codedOutputStream.b(2, o());
        }
        if (this.f14423h.isEmpty()) {
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
        int a2 = this.f14421f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, p());
        if (!this.f14422g.isEmpty()) {
            a2 += CodedOutputStream.a(2, o());
        }
        if (!this.f14423h.isEmpty()) {
            a2 += CodedOutputStream.a(3, n());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14423h;
    }

    public String o() {
        return this.f14422g;
    }

    public String p() {
        return this.f14421f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        r rVar = null;
        switch (r.f15035a[methodToInvoke.ordinal()]) {
            case 1:
                return new DocumentationRule();
            case 2:
                return f14419d;
            case 3:
                return null;
            case 4:
                return new Builder(rVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                DocumentationRule documentationRule = (DocumentationRule) obj2;
                this.f14421f = visitor.a(!this.f14421f.isEmpty(), this.f14421f, !documentationRule.f14421f.isEmpty(), documentationRule.f14421f);
                this.f14422g = visitor.a(!this.f14422g.isEmpty(), this.f14422g, !documentationRule.f14422g.isEmpty(), documentationRule.f14422g);
                this.f14423h = visitor.a(!this.f14423h.isEmpty(), this.f14423h, true ^ documentationRule.f14423h.isEmpty(), documentationRule.f14423h);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f14421f = codedInputStream.w();
                            } else if (x == 18) {
                                this.f14422g = codedInputStream.w();
                            } else if (x != 26) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f14423h = codedInputStream.w();
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
                if (f14420e == null) {
                    synchronized (DocumentationRule.class) {
                        if (f14420e == null) {
                            f14420e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14419d);
                        }
                    }
                }
                return f14420e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14419d;
    }
}
