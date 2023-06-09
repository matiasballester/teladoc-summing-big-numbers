package com.teladochealth.benchmark;

import com.teladochealth.BigNumbers;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 0)
@Measurement(iterations = 10)
public class BenchmarkBigNumbers {

    @Param({"10"})
    private int N;

    private final List<List<String>> DATA_FOR_TESTING = new ArrayList<>(N);
    private BigNumbers bigNumbers;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BenchmarkBigNumbers.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setup() {
        createData();
        bigNumbers = new com.teladochealth.BigNumbers();
    }

    @Benchmark
    public void sum(Blackhole bh) {
        for (List<String> data : DATA_FOR_TESTING) {
            bigNumbers.sum(data.get(0), data.get(1));
            bh.consume(bigNumbers);
        }
    }

    private void createData() {
        Random random = new Random();
        random.nextLong();
        for (int i = 0; i < N; i++)
            DATA_FOR_TESTING.add(List.of(String.valueOf(random.nextLong()), String.valueOf(random.nextLong())));
    }

}
