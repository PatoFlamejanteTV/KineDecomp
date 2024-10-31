package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class FieldMask extends GeneratedMessageLite<FieldMask, Builder> implements FieldMaskOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final FieldMask f18572d = new FieldMask();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<FieldMask> f18573e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<String> f18574f = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<FieldMask, Builder> implements FieldMaskOrBuilder {
        /* synthetic */ Builder(C1670y c1670y) {
            this();
        }

        private Builder() {
            super(FieldMask.f18572d);
        }
    }

    static {
        f18572d.l();
    }

    private FieldMask() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f18574f.size(); i++) {
            codedOutputStream.b(1, this.f18574f.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f18574f.size(); i3++) {
            i2 += CodedOutputStream.a(this.f18574f.get(i3));
        }
        int size = 0 + i2 + (n().size() * 1);
        this.f18584c = size;
        return size;
    }

    public List<String> n() {
        return this.f18574f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1670y c1670y = null;
        switch (C1670y.f18800a[methodToInvoke.ordinal()]) {
            case 1:
                return new FieldMask();
            case 2:
                return f18572d;
            case 3:
                this.f18574f.L();
                return null;
            case 4:
                return new Builder(c1670y);
            case 5:
                this.f18574f = ((GeneratedMessageLite.Visitor) obj).a(this.f18574f, ((FieldMask) obj2).f18574f);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x != 10) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    String w = codedInputStream.w();
                                    if (!this.f18574f.M()) {
                                        this.f18574f = GeneratedMessageLite.a(this.f18574f);
                                    }
                                    this.f18574f.add(w);
                                }
                            }
                            z = true;
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
                if (f18573e == null) {
                    synchronized (FieldMask.class) {
                        if (f18573e == null) {
                            f18573e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18572d);
                        }
                    }
                }
                return f18573e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18572d;
    }
}
