package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

class CertificateUpdateCallableTest {

    @Test
    void call() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CertificateUpdateCallable callable = new CertificateUpdateCallable();
        Future<CertificateUpdate> future = executorService.submit(callable);
        CertificateUpdate certificateUpdate = future.get();
        executorService.shutdown();

        assertNotNull(certificateUpdate, "CertificateUpdate object should be not null");
        assertNotNull(certificateUpdate.toString(), "CertificateUpdate toString() should be not null");
    }
}