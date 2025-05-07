package com.solvians.showcase;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class CertificateUpdate {
    private final long timestamp;
    private final String isin;
    private final double bidPrice;
    private final int bidSize;
    private final double askPrice;
    private final int askSize;
    private final LocalDate maturityDate;

    public CertificateUpdate() {
        this.timestamp = System.currentTimeMillis();
        this.isin = ISINGenerator.generateISIN();
        this.bidPrice = 100.00 + ThreadLocalRandom.current().nextDouble(100);
        this.bidSize = 1000 + ThreadLocalRandom.current().nextInt(4001);
        this.askPrice = 100.00 + ThreadLocalRandom.current().nextDouble(100);
        this.askSize = 1000 + ThreadLocalRandom.current().nextInt(9001);
        this.maturityDate = LocalDate.now().plusYears(2);
    }

    @Override
    public String toString() {
        return "CertificateUpdate \n" +
                "[TimeStamp=" + timestamp +"\n"+
                "ISIN=" + isin + "\n"+
                "BidPrice="+ bidPrice+"\n"+
                "BidSize=" + bidSize + "\n"+
                "AskPrice="+askPrice+"\n"+
                "AskSize=" + askSize+"\n"+
                "MaturityDate=" + maturityDate + "]";
    }
}
