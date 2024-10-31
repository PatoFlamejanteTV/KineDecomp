package com.nexstreaming.app.general.tracelog;

import com.nexstreaming.app.general.tracelog.TLP;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class AuthPromocodeResponse implements TLP.BaseResponse {
    public String cache_exp_date;
    public String exp_date;
    public int result;
    public long log_date = 0;
    public int event_idx = 0;

    @Override // com.nexstreaming.app.general.tracelog.TLP.BaseResponse
    public int getResult() {
        return this.result;
    }

    public ResponseCode getResponseCode() {
        return ResponseCode.fromValue(this.result);
    }

    public Date getExpDate() {
        if (this.exp_date == null || this.exp_date.length() < 1) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(this.exp_date);
        } catch (ParseException e) {
            return null;
        }
    }

    public Date getCacheExpDate() {
        Date cacheExpDateInternal = getCacheExpDateInternal();
        if (cacheExpDateInternal == null) {
            Date date = new Date(System.currentTimeMillis() - 1702967296);
            Date expDate = getExpDate();
            return expDate.after(date) ? date : expDate;
        }
        return cacheExpDateInternal;
    }

    private Date getCacheExpDateInternal() {
        if (this.cache_exp_date == null || this.cache_exp_date.length() < 1) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(this.cache_exp_date);
        } catch (ParseException e) {
            return null;
        }
    }
}
