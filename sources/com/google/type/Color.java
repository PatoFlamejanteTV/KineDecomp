package com.google.type;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Color extends GeneratedMessageLite<Color, Builder> implements ColorOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Color f18905d = new Color();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Color> f18906e;

    /* renamed from: f, reason: collision with root package name */
    private float f18907f;

    /* renamed from: g, reason: collision with root package name */
    private float f18908g;

    /* renamed from: h, reason: collision with root package name */
    private float f18909h;
    private FloatValue i;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Color, Builder> implements ColorOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        private Builder() {
            super(Color.f18905d);
        }
    }

    static {
        f18905d.l();
    }

    private Color() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        float f2 = this.f18907f;
        if (f2 != 0.0f) {
            codedOutputStream.b(1, f2);
        }
        float f3 = this.f18908g;
        if (f3 != 0.0f) {
            codedOutputStream.b(2, f3);
        }
        float f4 = this.f18909h;
        if (f4 != 0.0f) {
            codedOutputStream.b(3, f4);
        }
        if (this.i != null) {
            codedOutputStream.c(4, n());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        float f2 = this.f18907f;
        int a2 = f2 != 0.0f ? 0 + CodedOutputStream.a(1, f2) : 0;
        float f3 = this.f18908g;
        if (f3 != 0.0f) {
            a2 += CodedOutputStream.a(2, f3);
        }
        float f4 = this.f18909h;
        if (f4 != 0.0f) {
            a2 += CodedOutputStream.a(3, f4);
        }
        if (this.i != null) {
            a2 += CodedOutputStream.a(4, n());
        }
        this.f18584c = a2;
        return a2;
    }

    public FloatValue n() {
        FloatValue floatValue = this.i;
        return floatValue == null ? FloatValue.n() : floatValue;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18934a[methodToInvoke.ordinal()]) {
            case 1:
                return new Color();
            case 2:
                return f18905d;
            case 3:
                return null;
            case 4:
                return new Builder(aVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Color color = (Color) obj2;
                this.f18907f = visitor.a(this.f18907f != 0.0f, this.f18907f, color.f18907f != 0.0f, color.f18907f);
                this.f18908g = visitor.a(this.f18908g != 0.0f, this.f18908g, color.f18908g != 0.0f, color.f18908g);
                this.f18909h = visitor.a(this.f18909h != 0.0f, this.f18909h, color.f18909h != 0.0f, color.f18909h);
                this.i = (FloatValue) visitor.a(this.i, color.i);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r1) {
                    try {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 13) {
                                    this.f18907f = codedInputStream.i();
                                } else if (x == 21) {
                                    this.f18908g = codedInputStream.i();
                                } else if (x == 29) {
                                    this.f18909h = codedInputStream.i();
                                } else if (x != 34) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    FloatValue.Builder b2 = this.i != null ? this.i.b() : null;
                                    this.i = (FloatValue) codedInputStream.a(FloatValue.o(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((FloatValue.Builder) this.i);
                                        this.i = b2.T();
                                    }
                                }
                            }
                            r1 = true;
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
                if (f18906e == null) {
                    synchronized (Color.class) {
                        if (f18906e == null) {
                            f18906e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18905d);
                        }
                    }
                }
                return f18906e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18905d;
    }
}
