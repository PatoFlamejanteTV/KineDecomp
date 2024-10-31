package com.nexstreaming.kinemaster.kmpackage;

/* loaded from: classes.dex */
public class MissingDependencyException extends KineMasterPackageException {
    private static final long serialVersionUID = 1;

    public MissingDependencyException() {
    }

    public MissingDependencyException(String str, Throwable th) {
        super(str, th);
    }

    public MissingDependencyException(String str) {
        super(str);
    }

    public MissingDependencyException(Throwable th) {
        super(th);
    }
}
