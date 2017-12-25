class Metrics {
    //private static long timeUsed = 0;
    //private static long memoryUsed = 0;

    public Metrics() {}

    private static long timeStart = 0;
    private static long memoryStart = 0;
    private static long timeEnd = 0;
    private static long memoryEnd = 0;

    static void start() {
        timeStart = System.nanoTime();
        memoryStart = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
    }

    static void stop() {
        timeEnd = System.nanoTime();
        memoryEnd = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
    }

    static double getTime() {
        return (double)(timeEnd - timeStart)/1000000000;
    }

    static double getMemory() {
        return (double)(memoryEnd - memoryStart)/1024/1024;
    }

    static void clear(){
        timeStart = 0;
        memoryStart = 0;
        timeEnd = 0;
        memoryEnd = 0;
    }
}
