package org.keyczar.exceptions;

import org.keyczar.i18n.Messages;

/* loaded from: classes.dex */
public class KeyNotFoundException extends KeyczarException {
    private static final long serialVersionUID = -2745196315795456118L;

    public KeyNotFoundException(byte[] bArr) {
        super(Messages.getString("KeyWithHashIdentifier", Integer.toHexString(((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyNotFoundException(String str) {
        super(str);
    }
}
