package okhttp3.internal.http2;

import okhttp3.z;
import okio.ByteString;

/* compiled from: Header.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f29023a = ByteString.encodeUtf8(":");

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f29024b = ByteString.encodeUtf8(":status");

    /* renamed from: c, reason: collision with root package name */
    public static final ByteString f29025c = ByteString.encodeUtf8(":method");

    /* renamed from: d, reason: collision with root package name */
    public static final ByteString f29026d = ByteString.encodeUtf8(":path");

    /* renamed from: e, reason: collision with root package name */
    public static final ByteString f29027e = ByteString.encodeUtf8(":scheme");

    /* renamed from: f, reason: collision with root package name */
    public static final ByteString f29028f = ByteString.encodeUtf8(":authority");

    /* renamed from: g, reason: collision with root package name */
    public final ByteString f29029g;

    /* renamed from: h, reason: collision with root package name */
    public final ByteString f29030h;
    final int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Header.java */
    /* renamed from: okhttp3.internal.http2.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0168a {
        void a(z zVar);
    }

    public a(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f29029g.equals(aVar.f29029g) && this.f29030h.equals(aVar.f29030h);
    }

    public int hashCode() {
        return ((527 + this.f29029g.hashCode()) * 31) + this.f29030h.hashCode();
    }

    public String toString() {
        return okhttp3.a.e.a("%s: %s", this.f29029g.utf8(), this.f29030h.utf8());
    }

    public a(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public a(ByteString byteString, ByteString byteString2) {
        this.f29029g = byteString;
        this.f29030h = byteString2;
        this.i = byteString.size() + 32 + byteString2.size();
    }
}
