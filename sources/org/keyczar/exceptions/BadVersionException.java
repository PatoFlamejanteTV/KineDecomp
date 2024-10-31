package org.keyczar.exceptions;

import org.keyczar.i18n.Messages;

/* loaded from: classes3.dex */
public class BadVersionException extends KeyczarException {
    private static final long serialVersionUID = 7164364283899332453L;

    public BadVersionException(byte b2) {
        super(Messages.getString("BadVersionNumber", Byte.valueOf(b2)));
    }
}
