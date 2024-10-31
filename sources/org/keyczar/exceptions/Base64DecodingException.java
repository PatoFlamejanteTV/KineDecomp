package org.keyczar.exceptions;

/* loaded from: classes3.dex */
public class Base64DecodingException extends KeyczarException {
    private static final long serialVersionUID = -2574909128694204517L;

    public Base64DecodingException(Throwable th) {
        super(th);
    }

    public Base64DecodingException(String str) {
        super(str);
    }
}
