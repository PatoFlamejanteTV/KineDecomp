package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;

/* loaded from: classes2.dex */
public final class QRCode {

    /* renamed from: a */
    private Mode f19255a;

    /* renamed from: b */
    private ErrorCorrectionLevel f19256b;

    /* renamed from: c */
    private Version f19257c;

    /* renamed from: d */
    private int f19258d = -1;

    /* renamed from: e */
    private ByteMatrix f19259e;

    public static boolean a(int i) {
        return i >= 0 && i < 8;
    }

    public ByteMatrix a() {
        return this.f19259e;
    }

    public void b(int i) {
        this.f19258d = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f19255a);
        sb.append("\n ecLevel: ");
        sb.append(this.f19256b);
        sb.append("\n version: ");
        sb.append(this.f19257c);
        sb.append("\n maskPattern: ");
        sb.append(this.f19258d);
        if (this.f19259e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f19259e);
        }
        sb.append(">>\n");
        return sb.toString();
    }

    public void a(Mode mode) {
        this.f19255a = mode;
    }

    public void a(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f19256b = errorCorrectionLevel;
    }

    public void a(Version version) {
        this.f19257c = version;
    }

    public void a(ByteMatrix byteMatrix) {
        this.f19259e = byteMatrix;
    }
}
