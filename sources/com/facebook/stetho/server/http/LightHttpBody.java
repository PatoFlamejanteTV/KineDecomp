package com.facebook.stetho.server.http;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public abstract class LightHttpBody {

    /* renamed from: com.facebook.stetho.server.http.LightHttpBody$1 */
    /* loaded from: classes.dex */
    public static class AnonymousClass1 extends LightHttpBody {
        final /* synthetic */ byte[] val$body;
        final /* synthetic */ String val$contentType;

        AnonymousClass1(String str, byte[] bArr) {
            str = str;
            bArr = bArr;
        }

        @Override // com.facebook.stetho.server.http.LightHttpBody
        public int contentLength() {
            return bArr.length;
        }

        @Override // com.facebook.stetho.server.http.LightHttpBody
        public String contentType() {
            return str;
        }

        @Override // com.facebook.stetho.server.http.LightHttpBody
        public void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(bArr);
        }
    }

    public static LightHttpBody create(String str, String str2) {
        try {
            return create(str.getBytes("UTF-8"), str2);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public abstract int contentLength();

    public abstract String contentType();

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public static LightHttpBody create(byte[] bArr, String str) {
        return new LightHttpBody() { // from class: com.facebook.stetho.server.http.LightHttpBody.1
            final /* synthetic */ byte[] val$body;
            final /* synthetic */ String val$contentType;

            AnonymousClass1(String str2, byte[] bArr2) {
                str = str2;
                bArr = bArr2;
            }

            @Override // com.facebook.stetho.server.http.LightHttpBody
            public int contentLength() {
                return bArr.length;
            }

            @Override // com.facebook.stetho.server.http.LightHttpBody
            public String contentType() {
                return str;
            }

            @Override // com.facebook.stetho.server.http.LightHttpBody
            public void writeTo(OutputStream outputStream) throws IOException {
                outputStream.write(bArr);
            }
        };
    }
}
