package org.keyczar.interfaces;

import java.nio.ByteBuffer;
import org.keyczar.exceptions.KeyczarException;

/* loaded from: classes.dex */
public interface VerifyingStream extends Stream {
    int digestSize();

    void initVerify() throws KeyczarException;

    void updateVerify(ByteBuffer byteBuffer) throws KeyczarException;

    boolean verify(ByteBuffer byteBuffer) throws KeyczarException;
}
