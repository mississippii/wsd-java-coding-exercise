package com.solvians.showcase;

import java.util.concurrent.Callable;

public class CertificateUpdateCallable implements Callable<CertificateUpdate> {
    @Override
    public CertificateUpdate call() throws Exception {
        return new CertificateUpdate();
    }
}
