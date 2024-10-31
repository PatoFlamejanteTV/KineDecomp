package com.nexstreaming.app.general.expression;

/* loaded from: classes.dex */
public class ExpressionParseException extends Exception {
    private static final long serialVersionUID = 1;

    public ExpressionParseException(String str) {
        super(str);
    }

    public ExpressionParseException() {
    }

    public ExpressionParseException(String str, Throwable th) {
        super(str, th);
    }

    public ExpressionParseException(Throwable th) {
        super(th);
    }
}
