package org.keyczar.exceptions;

import org.keyczar.i18n.Messages;
import org.keyczar.interfaces.KeyType;

/* loaded from: classes3.dex */
public class UnsupportedTypeException extends KeyczarException {
    private static final long serialVersionUID = 1;

    public UnsupportedTypeException(KeyType keyType) {
        super(Messages.getString("InvalidTypeInInput", keyType));
    }
}
