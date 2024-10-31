package com.google.protobuf;

/* loaded from: classes2.dex */
public class LazyFieldLite {

    /* renamed from: a */
    private static final ExtensionRegistryLite f18637a = ExtensionRegistryLite.a();

    /* renamed from: b */
    private ByteString f18638b;

    /* renamed from: c */
    private ExtensionRegistryLite f18639c;

    /* renamed from: d */
    protected volatile MessageLite f18640d;

    /* renamed from: e */
    private volatile ByteString f18641e;

    public int a() {
        if (this.f18641e != null) {
            return this.f18641e.size();
        }
        ByteString byteString = this.f18638b;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f18640d != null) {
            return this.f18640d.d();
        }
        return 0;
    }

    public MessageLite b(MessageLite messageLite) {
        a(messageLite);
        return this.f18640d;
    }

    public MessageLite c(MessageLite messageLite) {
        MessageLite messageLite2 = this.f18640d;
        this.f18638b = null;
        this.f18641e = null;
        this.f18640d = messageLite;
        return messageLite2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.f18640d;
        MessageLite messageLite2 = lazyFieldLite.f18640d;
        if (messageLite == null && messageLite2 == null) {
            return b().equals(lazyFieldLite.b());
        }
        if (messageLite != null && messageLite2 != null) {
            return messageLite.equals(messageLite2);
        }
        if (messageLite != null) {
            return messageLite.equals(lazyFieldLite.b(messageLite.a()));
        }
        return b(messageLite2.a()).equals(messageLite2);
    }

    public int hashCode() {
        return 1;
    }

    public ByteString b() {
        if (this.f18641e != null) {
            return this.f18641e;
        }
        ByteString byteString = this.f18638b;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.f18641e != null) {
                return this.f18641e;
            }
            if (this.f18640d == null) {
                this.f18641e = ByteString.EMPTY;
            } else {
                this.f18641e = this.f18640d.c();
            }
            return this.f18641e;
        }
    }

    protected void a(MessageLite messageLite) {
        if (this.f18640d != null) {
            return;
        }
        synchronized (this) {
            if (this.f18640d != null) {
                return;
            }
            try {
                if (this.f18638b != null) {
                    this.f18640d = messageLite.f().a(this.f18638b, this.f18639c);
                    this.f18641e = this.f18638b;
                } else {
                    this.f18640d = messageLite;
                    this.f18641e = ByteString.EMPTY;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f18640d = messageLite;
                this.f18641e = ByteString.EMPTY;
            }
        }
    }
}
