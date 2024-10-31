package com.mixpanel.android.java_websocket.c;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

/* compiled from: Charsetfunctions.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static CodingErrorAction f2996a = CodingErrorAction.REPORT;

    public static byte[] a(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] b(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String a(ByteBuffer byteBuffer) throws InvalidDataException {
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(f2996a);
        newDecoder.onUnmappableCharacter(f2996a);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            return charBuffer;
        } catch (CharacterCodingException e) {
            throw new InvalidDataException(1007, e);
        }
    }
}
