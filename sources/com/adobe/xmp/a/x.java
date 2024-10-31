package com.adobe.xmp.a;

import com.adobe.xmp.XMPException;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: XMPSerializerHelper.java */
/* loaded from: classes.dex */
public class x {
    public static void a(p pVar, OutputStream outputStream, com.adobe.xmp.b.f fVar) throws XMPException {
        if (fVar == null) {
            fVar = new com.adobe.xmp.b.f();
        }
        if (fVar.p()) {
            pVar.b();
        }
        new y().a(pVar, outputStream, fVar);
    }

    public static String a(p pVar, com.adobe.xmp.b.f fVar) throws XMPException {
        if (fVar == null) {
            fVar = new com.adobe.xmp.b.f();
        }
        fVar.a(true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
        a(pVar, byteArrayOutputStream, fVar);
        try {
            return byteArrayOutputStream.toString(fVar.f());
        } catch (UnsupportedEncodingException unused) {
            return byteArrayOutputStream.toString();
        }
    }
}
