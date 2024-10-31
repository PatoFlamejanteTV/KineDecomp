package com.facebook.ads.internal.androidx.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: assets/audience_network.dex */
public class LinearLayoutManager$SavedState implements Parcelable {
    public static final Parcelable.Creator<LinearLayoutManager$SavedState> CREATOR = new Parcelable.Creator<LinearLayoutManager$SavedState>() { // from class: com.facebook.ads.redexgen.X.6n
        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.os.Parcelable.Creator
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final LinearLayoutManager$SavedState createFromParcel(Parcel parcel) {
            return new LinearLayoutManager$SavedState(parcel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.os.Parcelable.Creator
        /* renamed from: A01, reason: merged with bridge method [inline-methods] */
        public final LinearLayoutManager$SavedState[] newArray(int i) {
            return new LinearLayoutManager$SavedState[i];
        }
    };
    public int A00;
    public int A01;
    public boolean A02;

    public LinearLayoutManager$SavedState() {
    }

    public LinearLayoutManager$SavedState(Parcel parcel) {
        this.A01 = parcel.readInt();
        this.A00 = parcel.readInt();
        this.A02 = parcel.readInt() == 1;
    }

    public LinearLayoutManager$SavedState(LinearLayoutManager$SavedState linearLayoutManager$SavedState) {
        this.A01 = linearLayoutManager$SavedState.A01;
        this.A00 = linearLayoutManager$SavedState.A00;
        this.A02 = linearLayoutManager$SavedState.A02;
    }

    public final void A00() {
        this.A01 = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0012, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A01() {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A01
            if (r0 < 0) goto L10
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L12;
                case 4: goto Ld;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            r1 = 1
            r0 = 3
            goto L6
        Ld:
            r1 = 0
            r0 = 3
            goto L6
        L10:
            r0 = 4
            goto L6
        L12:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState.A01():boolean");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:            r3.writeInt(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:            return;     */
    @Override // android.os.Parcelable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeToParcel(android.os.Parcel r3, int r4) {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A01
            r3.writeInt(r0)
            int r0 = r2.A00
            r3.writeInt(r0)
            boolean r0 = r2.A02
            if (r0 == 0) goto L1a
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L1c;
                case 4: goto L17;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            r1 = 1
            r0 = 3
            goto L10
        L17:
            r1 = 0
            r0 = 3
            goto L10
        L1a:
            r0 = 4
            goto L10
        L1c:
            android.os.Parcel r3 = (android.os.Parcel) r3
            r3.writeInt(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState.writeToParcel(android.os.Parcel, int):void");
    }
}
