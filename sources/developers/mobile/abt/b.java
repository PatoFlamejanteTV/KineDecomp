package developers.mobile.abt;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes3.dex */
public final class b extends GeneratedMessageLite<b, a> implements c {

    /* renamed from: d, reason: collision with root package name */
    private static final b f26729d = new b();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<b> f26730e;

    /* renamed from: f, reason: collision with root package name */
    private String f26731f = "";

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes3.dex */
    public static final class a extends GeneratedMessageLite.Builder<b, a> implements c {
        /* synthetic */ a(developers.mobile.abt.a aVar) {
            this();
        }

        private a() {
            super(b.f26729d);
        }
    }

    static {
        f26729d.l();
    }

    private b() {
    }

    public static Parser<b> o() {
        return f26729d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f26731f.isEmpty()) {
            return;
        }
        codedOutputStream.b(1, n());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f26731f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f26731f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        developers.mobile.abt.a aVar = null;
        switch (developers.mobile.abt.a.f26728a[methodToInvoke.ordinal()]) {
            case 1:
                return new b();
            case 2:
                return f26729d;
            case 3:
                return null;
            case 4:
                return new a(aVar);
            case 5:
                b bVar = (b) obj2;
                this.f26731f = ((GeneratedMessageLite.Visitor) obj).a(!this.f26731f.isEmpty(), this.f26731f, true ^ bVar.f26731f.isEmpty(), bVar.f26731f);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x != 10) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f26731f = codedInputStream.w();
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
                if (f26730e == null) {
                    synchronized (b.class) {
                        if (f26730e == null) {
                            f26730e = new GeneratedMessageLite.DefaultInstanceBasedParser(f26729d);
                        }
                    }
                }
                return f26730e;
            default:
                throw new UnsupportedOperationException();
        }
        return f26729d;
    }
}
