package org.keyczar.enums;

import com.google.gson.annotations.Expose;

/* loaded from: classes.dex */
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

    int getValue() {
        return this.value;
    }

    static CipherMode getMode(int i) {
        switch (i) {
            case 0:
                return CBC;
            case 1:
                return CTR;
            case 2:
                return ECB;
            case 3:
                return DET_CBC;
            default:
                return null;
        }
    }

    public int getOutputSize(int i, int i2) {
        if (this == CBC) {
            return i * ((i2 / i) + 2);
        }
        if (this != ECB) {
            if (this == CTR) {
                return i2 + (i / 2);
            }
            if (this == DET_CBC) {
                return i * ((i2 / i) + 1);
            }
            return 0;
        }
        return i;
    }
}
