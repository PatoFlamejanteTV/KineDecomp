package com.nexstreaming.app.general.expression;

/* loaded from: classes.dex */
public class ExpressionEvalException extends Exception {
    private static final long serialVersionUID = 1;

    public ExpressionEvalException() {
    }

    public ExpressionEvalException(String str, Throwable th) {
        super(str, th);
    }

    public ExpressionEvalException(String str) {
        super(str);
    }

    public ExpressionEvalException(Throwable th) {
        super(th);
    }
}
