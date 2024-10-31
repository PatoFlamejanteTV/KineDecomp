package org.keyczar.interfaces;

import java.nio.ByteBuffer;
import org.keyczar.exceptions.KeyczarException;

/* loaded from: classes3.dex */
public interface DecryptingStream extends Stream {
    int doFinalDecrypt(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws KeyczarException;

    VerifyingStream getVerifyingStream();

    void initDecrypt(ByteBuffer byteBuffer) throws KeyczarException;

    int maxOutputSize(int i);

    int updateDecrypt(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws KeyczarException;
}
