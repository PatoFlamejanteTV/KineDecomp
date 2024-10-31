package com.nexstreaming.app.general.expression;

/* loaded from: classes.dex */
public class TokenNotMatchedException extends Exception {
    private static final long serialVersionUID = 1;

    public TokenNotMatchedException(int i) {
        super("No matching token at: " + i);
    }
}
