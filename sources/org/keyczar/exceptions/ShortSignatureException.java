package org.keyczar.exceptions;

import org.keyczar.i18n.Messages;

/* loaded from: classes3.dex */
public class ShortSignatureException extends KeyczarException {
    private static final long serialVersionUID = 4756259412053573790L;

    public ShortSignatureException(int i) {
        super(Messages.getString("SignatureTooShort", Integer.valueOf(i)));
    }
}
