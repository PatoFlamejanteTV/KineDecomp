package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

/* loaded from: classes2.dex */
public class OnEventResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnEventResponse> CREATOR = new zzbb();

    /* renamed from: a, reason: collision with root package name */
    final int f1105a;
    final int b;
    final ChangeEvent c;
    final CompletionEvent d;
    final QueryResultEventParcelable e;
    final ChangesAvailableEvent f;
    final ProgressEvent g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnEventResponse(int i, int i2, ChangeEvent changeEvent, CompletionEvent completionEvent, QueryResultEventParcelable queryResultEventParcelable, ChangesAvailableEvent changesAvailableEvent, ProgressEvent progressEvent) {
        this.f1105a = i;
        this.b = i2;
        this.c = changeEvent;
        this.d = completionEvent;
        this.e = queryResultEventParcelable;
        this.f = changesAvailableEvent;
        this.g = progressEvent;
    }

    public DriveEvent a() {
        switch (this.b) {
            case 1:
                return this.c;
            case 2:
                return this.d;
            case 3:
                return this.e;
            case 4:
                return this.f;
            case 5:
            case 6:
                return this.g;
            default:
                throw new IllegalStateException("Unexpected event type " + this.b);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbb.a(this, parcel, i);
    }
}
