package org.keyczar.enums;

import com.google.gson.annotations.Expose;

/* loaded from: classes3.dex */
public enum CipherMode {
    CBC(0, "AES/CBC/PKCS5Padding", true),
    CTR(1, "AES/CTR/NoPadding", true),
    ECB(2, "AES/ECB/NoPadding", false),
    DET_CBC(3, "AES/CBC/PKCS5Padding", false);

    private String jceMode;

    @Expose
    private int value;

    CipherMode(int i, String str, boolean z) {
        this.value = i;
        this.jceMode = str;
    }

    public String getMode() {
        return this.jceMode;
    }

    public int getOutputSize(int i, int i2) {
        if (this == CBC) {
            return ((i2 / i) + 2) * i;
        }
        if (this == ECB) {
            return i;
        }
        if (this == CTR) {
            return i2 + (i / 2);
        }
        if (this == DET_CBC) {
            return ((i2 / i) + 1) * i;
        }
        return 0;
    }

    int getValue() {
        return this.value;
    }

    static CipherMode getMode(int i) {
        if (i == 0) {
            return CBC;
        }
        if (i == 1) {
            return CTR;
        }
        if (i == 2) {
            return ECB;
        }
        if (i != 3) {
            return null;
        }
        return DET_CBC;
    }
}
