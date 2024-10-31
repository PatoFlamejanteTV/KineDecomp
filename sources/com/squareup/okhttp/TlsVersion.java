package com.squareup.okhttp;

/* loaded from: classes3.dex */
public enum TlsVersion {
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");

    final String javaName;

    TlsVersion(String str) {
        this.javaName = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static TlsVersion forJavaName(String str) {
        char c2;
        switch (str.hashCode()) {
            case -503070503:
                if (str.equals("TLSv1.1")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -503070502:
                if (str.equals("TLSv1.2")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 79201641:
                if (str.equals("SSLv3")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 79923350:
                if (str.equals("TLSv1")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            return TLS_1_2;
        }
        if (c2 == 1) {
            return TLS_1_1;
        }
        if (c2 == 2) {
            return TLS_1_0;
        }
        if (c2 == 3) {
            return SSL_3_0;
        }
        throw new IllegalArgumentException("Unexpected TLS version: " + str);
    }

    public String javaName() {
        return this.javaName;
    }
}