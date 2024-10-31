package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseException;

/* loaded from: classes2.dex */
public class PhoneAuthProvider {

    /* renamed from: a */
    private FirebaseAuth f16409a;

    /* loaded from: classes2.dex */
    public static class ForceResendingToken extends AbstractSafeParcelable {
        public static final Parcelable.Creator<ForceResendingToken> CREATOR = new zzc();

        @SafeParcelable.Constructor
        public ForceResendingToken() {
        }

        public static ForceResendingToken a() {
            return new ForceResendingToken();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            SafeParcelWriter.a(parcel, SafeParcelWriter.a(parcel));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class OnVerificationStateChangedCallbacks {

        /* renamed from: a */
        private static final Logger f16410a = new Logger("PhoneAuthProvider", new String[0]);

        public abstract void a(FirebaseException firebaseException);

        public abstract void a(PhoneAuthCredential phoneAuthCredential);

        public void a(String str) {
            f16410a.c("Sms auto retrieval timed-out.", new Object[0]);
        }

        public void a(String str, ForceResendingToken forceResendingToken) {
        }
    }

    private PhoneAuthProvider(FirebaseAuth firebaseAuth) {
        this.f16409a = firebaseAuth;
    }

    public static PhoneAuthProvider a(FirebaseAuth firebaseAuth) {
        return new PhoneAuthProvider(firebaseAuth);
    }
}
