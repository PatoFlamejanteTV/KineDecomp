package com.google.rpc;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class LocalizedMessage extends GeneratedMessageLite<LocalizedMessage, Builder> implements LocalizedMessageOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final LocalizedMessage f18855d = new LocalizedMessage();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<LocalizedMessage> f18856e;

    /* renamed from: f, reason: collision with root package name */
    private String f18857f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f18858g = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<LocalizedMessage, Builder> implements LocalizedMessageOrBuilder {
        /* synthetic */ Builder(e eVar) {
            this();
        }

        private Builder() {
            super(LocalizedMessage.f18855d);
        }
    }

    static {
        f18855d.l();
    }

    private LocalizedMessage() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18857f.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        if (this.f18858g.isEmpty()) {
            return;
        }
        codedOutputStream.b(2, o());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18857f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        if (!this.f18858g.isEmpty()) {
            a2 += CodedOutputStream.a(2, o());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18857f;
    }

    public String o() {
        return this.f18858g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        e eVar = null;
        switch (e.f18894a[methodToInvoke.ordinal()]) {
            case 1:
                return new LocalizedMessage();
            case 2:
                return f18855d;
            case 3:
                return null;
            case 4:
                return new Builder(eVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                LocalizedMessage localizedMessage = (LocalizedMessage) obj2;
                this.f18857f = visitor.a(!this.f18857f.isEmpty(), this.f18857f, !localizedMessage.f18857f.isEmpty(), localizedMessage.f18857f);
                this.f18858g = visitor.a(!this.f18858g.isEmpty(), this.f18858g, true ^ localizedMessage.f18858g.isEmpty(), localizedMessage.f18858g);
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
                                this.f18857f = codedInputStream.w();
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18858g = codedInputStream.w();
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
                if (f18856e == null) {
                    synchronized (LocalizedMessage.class) {
                        if (f18856e == null) {
                            f18856e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18855d);
                        }
                    }
                }
                return f18856e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18855d;
    }
}
