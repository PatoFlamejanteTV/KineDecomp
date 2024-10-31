package com.nexstreaming.app.general.tracelog;

import com.nexstreaming.app.general.tracelog.TLP;

/* loaded from: classes2.dex */
public class CpOrderIdResponse implements TLP.BaseResponse {
    public long log_date = 0;
    private int result = -1;
    public String cporderid = null;
    public String prepay_id = null;
    public String timestamp = null;
    public String packageValue = null;
    public String key = null;

    @Override // com.nexstreaming.app.general.tracelog.TLP.BaseResponse
    public int getResult() {
        return this.result;
    }

    public String toString() {
        return "CpOrderIdResponse{result=" + this.result + ", cporderid='" + this.cporderid + "', log_date=" + this.log_date + ", prepay_id='" + this.prepay_id + "'}";
    }
}
