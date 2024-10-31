package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Handler;
import android.support.v4.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public final class FingerprintManagerCompat {

    /* renamed from: a */
    private final Context f1176a;

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$1 */
    /* loaded from: classes.dex */
    public static class AnonymousClass1 extends FingerprintManager.AuthenticationCallback {
        AnonymousClass1() {
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationError(int i, CharSequence charSequence) {
            AuthenticationCallback.this.onAuthenticationError(i, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationFailed() {
            AuthenticationCallback.this.onAuthenticationFailed();
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationHelp(int i, CharSequence charSequence) {
            AuthenticationCallback.this.onAuthenticationHelp(i, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(FingerprintManagerCompat.b(authenticationResult.getCryptoObject())));
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }
    }

    /* loaded from: classes.dex */
    public static final class AuthenticationResult {

        /* renamed from: a */
        private final CryptoObject f1178a;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.f1178a = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.f1178a;
        }
    }

    private FingerprintManagerCompat(Context context) {
        this.f1176a = context;
    }

    public static CryptoObject b(FingerprintManager.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new CryptoObject(cryptoObject.getMac());
        }
        return null;
    }

    public static FingerprintManagerCompat from(Context context) {
        return new FingerprintManagerCompat(context);
    }

    public void authenticate(CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        FingerprintManager a2;
        if (Build.VERSION.SDK_INT < 23 || (a2 = a(this.f1176a)) == null) {
            return;
        }
        a2.authenticate(a(cryptoObject), cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null, i, a(authenticationCallback), handler);
    }

    public boolean hasEnrolledFingerprints() {
        FingerprintManager a2;
        return Build.VERSION.SDK_INT >= 23 && (a2 = a(this.f1176a)) != null && a2.hasEnrolledFingerprints();
    }

    public boolean isHardwareDetected() {
        FingerprintManager a2;
        return Build.VERSION.SDK_INT >= 23 && (a2 = a(this.f1176a)) != null && a2.isHardwareDetected();
    }

    private static FingerprintManager a(Context context) {
        if (context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static class CryptoObject {

        /* renamed from: a */
        private final Signature f1179a;

        /* renamed from: b */
        private final Cipher f1180b;

        /* renamed from: c */
        private final Mac f1181c;

        public CryptoObject(Signature signature) {
            this.f1179a = signature;
            this.f1180b = null;
            this.f1181c = null;
        }

        public Cipher getCipher() {
            return this.f1180b;
        }

        public Mac getMac() {
            return this.f1181c;
        }

        public Signature getSignature() {
            return this.f1179a;
        }

        public CryptoObject(Cipher cipher) {
            this.f1180b = cipher;
            this.f1179a = null;
            this.f1181c = null;
        }

        public CryptoObject(Mac mac) {
            this.f1181c = mac;
            this.f1180b = null;
            this.f1179a = null;
        }
    }

    private static FingerprintManager.CryptoObject a(CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getMac());
        }
        return null;
    }

    private static FingerprintManager.AuthenticationCallback a(AuthenticationCallback authenticationCallback) {
        return new FingerprintManager.AuthenticationCallback() { // from class: android.support.v4.hardware.fingerprint.FingerprintManagerCompat.1
            AnonymousClass1() {
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationError(int i, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationError(i, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationFailed() {
                AuthenticationCallback.this.onAuthenticationFailed();
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationHelp(int i, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationHelp(i, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(FingerprintManagerCompat.b(authenticationResult.getCryptoObject())));
            }
        };
    }
}
