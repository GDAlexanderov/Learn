package org.example;

import java.util.*;

public class CacheSimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер кэша (N): ");
        int cacheSize = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Введите последовательность запросов (через пробел): ");
        String[] requestsInput = scanner.nextLine().split(" ");
        int[] requests = Arrays.stream(requestsInput)
                .mapToInt(Integer::parseInt)
                .toArray();

        int cacheHits = simulateOptimalCache(cacheSize, requests);
        int totalRequests = requests.length;
        double hitRate = (double) cacheHits / totalRequests * 100;

        System.out.println("\nРезультаты:");
        System.out.println("Всего запросов: " + totalRequests);
        System.out.println("Попаданий в кэш: " + cacheHits);
        System.out.printf("Процент попаданий: %.2f%%\n", hitRate);
    }

    /**
     * Алгоритм оптимального кэширования (OPT/Bélády)
     * Заменяет данные, которые будут использоваться позже всех
     */
    public static int simulateOptimalCache(int cacheSize, int[] requests) {
        if (cacheSize == 0) return 0;

        Set<Integer> cache = new LinkedHashSet<>();
        int cacheHits = 0;

        // Предварительно создаем карту следующих вхождений для каждого элемента
        Map<Integer, Queue<Integer>> nextOccurrences = new HashMap<>();
        for (int i = 0; i < requests.length; i++) {
            int data = requests[i];
            nextOccurrences.computeIfAbsent(data, k -> new LinkedList<>()).add(i);
        }

        for (int i = 0; i < requests.length; i++) {
            int currentRequest = requests[i];

            // Удаляем текущую позицию из очереди следующих вхождений
            if (nextOccurrences.containsKey(currentRequest)) {
                Queue<Integer> queue = nextOccurrences.get(currentRequest);
                if (!queue.isEmpty()) queue.poll();
            }

            // Если данные уже в кэше - это попадание
            if (cache.contains(currentRequest)) {
                cacheHits++;
                continue;
            }

            // Если кэш не полный, просто добавляем
            if (cache.size() < cacheSize) {
                cache.add(currentRequest);
            } else {
                // Находим элемент в кэше, который будет использоваться позже всех
                int farthestNextUse = -1;
                int elementToRemove = -1;

                for (int cachedElement : cache) {
                    Queue<Integer> nextUses = nextOccurrences.get(cachedElement);

                    if (nextUses == null || nextUses.isEmpty()) {
                        // Этот элемент больше не понадобится
                        elementToRemove = cachedElement;
                        break;
                    }

                    int nextUse = nextUses.peek();
                    if (nextUse > farthestNextUse) {
                        farthestNextUse = nextUse;
                        elementToRemove = cachedElement;
                    }
                }

                // Удаляем выбранный элемент и добавляем новый
                cache.remove(elementToRemove);
                cache.add(currentRequest);
            }
        }

        return cacheHits;
    }

    /**
     * Альтернативная реализация с алгоритмом LRU (Least Recently Used)
     * для сравнения производительности
     */
    public static int simulateLRUCache(int cacheSize, int[] requests) {
        if (cacheSize == 0) return 0;

        LinkedHashSet<Integer> cache = new LinkedHashSet<>(cacheSize);
        int cacheHits = 0;

        for (int request : requests) {
            if (cache.contains(request)) {
                // Попадание в кэш - перемещаем в конец (самый недавно использованный)
                cache.remove(request);
                cache.add(request);
                cacheHits++;
            } else {
                if (cache.size() == cacheSize) {
                    // Удаляем самый старый элемент (первый в LinkedHashSet)
                    int firstKey = cache.iterator().next();
                    cache.remove(firstKey);
                }
                cache.add(request);
            }
        }

        return cacheHits;
    }
}
