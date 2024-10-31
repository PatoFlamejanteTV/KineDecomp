package com.google.firebase.database.tubesock;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface b {
        WebSocketMessage a();

        boolean a(byte[] bArr);
    }

    public static b a(byte b2) {
        if (b2 == 2) {
            return new C0094a();
        }
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* renamed from: com.google.firebase.database.tubesock.a$a */
    /* loaded from: classes2.dex */
    public static class C0094a implements b {

        /* renamed from: b */
        private int f17241b = 0;

        /* renamed from: a */
        private List<byte[]> f17240a = new ArrayList();

        C0094a() {
        }

        @Override // com.google.firebase.database.tubesock.a.b
        public boolean a(byte[] bArr) {
            this.f17240a.add(bArr);
            this.f17241b += bArr.length;
            return true;
        }

        @Override // com.google.firebase.database.tubesock.a.b
        public WebSocketMessage a() {
            byte[] bArr = new byte[this.f17241b];
            int i = 0;
            for (int i2 = 0; i2 < this.f17240a.size(); i2++) {
                byte[] bArr2 = this.f17240a.get(i2);
                System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
                i += bArr2.length;
            }
            return new WebSocketMessage(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class c implements b {

        /* renamed from: a */
        private static ThreadLocal<CharsetDecoder> f17242a = new com.google.firebase.database.tubesock.b();

        /* renamed from: b */
        private static ThreadLocal<CharsetEncoder> f17243b = new com.google.firebase.database.tubesock.c();

        /* renamed from: c */
        private StringBuilder f17244c = new StringBuilder();

        /* renamed from: d */
        private ByteBuffer f17245d;

        c() {
        }

        private String b(byte[] bArr) {
            try {
                return f17242a.get().decode(ByteBuffer.wrap(bArr)).toString();
            } catch (CharacterCodingException unused) {
                return null;
            }
        }

        @Override // com.google.firebase.database.tubesock.a.b
        public boolean a(byte[] bArr) {
            String b2 = b(bArr);
            if (b2 == null) {
                return false;
            }
            this.f17244c.append(b2);
            return true;
        }

        @Override // com.google.firebase.database.tubesock.a.b
        public WebSocketMessage a() {
            if (this.f17245d != null) {
                return null;
            }
            return new WebSocketMessage(this.f17244c.toString());
        }
    }
}
