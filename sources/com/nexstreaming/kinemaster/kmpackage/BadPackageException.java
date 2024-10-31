package com.nexstreaming.kinemaster.kmpackage;

/* loaded from: classes.dex */
public class BadPackageException extends KineMasterPackageException {
    private static final long serialVersionUID = 1;

    public BadPackageException() {
    }

    public BadPackageException(String str, Throwable th) {
        super(str, th);
    }

    public BadPackageException(String str) {
        super(str);
    }

    public BadPackageException(Throwable th) {
        super(th);
    }
}
