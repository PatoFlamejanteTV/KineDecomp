package com.flurry.sdk;

import java.security.MessageDigest;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public class an extends MessageDigest {

    /* renamed from: a, reason: collision with root package name */
    private CRC32 f462a;

    public an() {
        super("CRC");
        this.f462a = new CRC32();
    }

    @Override // java.security.MessageDigestSpi
    protected void engineReset() {
        this.f462a.reset();
    }

    @Override // java.security.MessageDigestSpi
    protected void engineUpdate(byte b) {
        this.f462a.update(b);
    }

    @Override // java.security.MessageDigestSpi
    protected void engineUpdate(byte[] bArr, int i, int i2) {
        this.f462a.update(bArr, i, i2);
    }

    @Override // java.security.MessageDigestSpi
    protected byte[] engineDigest() {
        long value = this.f462a.getValue();
        return new byte[]{(byte) (((-16777216) & value) >> 24), (byte) ((16711680 & value) >> 16), (byte) ((65280 & value) >> 8), (byte) ((value & 255) >> 0)};
    }

    public byte[] a() {
        return engineDigest();
    }
}
