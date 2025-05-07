package com.solvians.showcase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class CertificateUpdateGenerator {
    private final int threads;
    private final int quotes;

    public CertificateUpdateGenerator(int threads, int quotes) {
        this.threads = threads;
        this.quotes = quotes;
    }

    public Stream<CertificateUpdate> generateQuotes() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        // TODO: Implement me.
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        List<Callable<CertificateUpdate>> tasks = new ArrayList<>();

        for (int i = 0; i < quotes*threads; i++) {
            tasks.add(new CertificateUpdateCallable());
        }
        try{
            List<Future<CertificateUpdate>> futures = executorService.invokeAll(tasks);
            List<CertificateUpdate> updates = new ArrayList<>();
            for (Future<CertificateUpdate> future : futures) {
                updates.add(future.get());
            }
            executorService.shutdown();
            return updates.stream();
        }catch (Exception e) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
            throw new RuntimeException(e);
        }
//        List<CertificateUpdate> updateList = new ArrayList<CertificateUpdate>();
//        for (int i = 0; i < threads * quotes; i++) {
//            updateList.add(new CertificateUpdate());
//        }
//        return Stream.generate(CertificateUpdate::new).parallel().limit(quotes);
    }
}
