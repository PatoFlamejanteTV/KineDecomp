package org.keyczar.exceptions;

import org.keyczar.i18n.Messages;

/* loaded from: classes3.dex */
public class NoPrimaryKeyException extends KeyNotFoundException {
    private static final long serialVersionUID = 2435853068538255446L;

    public NoPrimaryKeyException() {
        super(Messages.getString("NoPrimaryKeyFound", new Object[0]));
    }
}
