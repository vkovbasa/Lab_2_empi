import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Вхідні дані
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер студента N: ");
        int N = scanner.nextInt();
        int size = 3 * (N + 10);

        // Генерація випадкової послідовності
        Random random = new Random();
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            sequence.add(random.nextInt(5) + 1); // Значення з набору {1, 2, 3, 4, 5}
        }

        // Виведення вихідних даних
        System.out.println("Вихідна послідовність: " + sequence);

        // Побудова варіаційного ряду (сортування)
        List<Integer> sortedSequence = new ArrayList<>(sequence);
        Collections.sort(sortedSequence);
        System.out.println("Варіаційний ряд: " + sortedSequence);

        // Статистичний розподіл
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : sortedSequence) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Статистичний розподіл:");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("Число " + entry.getKey() + ": " + entry.getValue() + " разів");
        }

        // Інтегральна частота
        System.out.println("Інтегральна частота:");
        int cumulativeFrequency = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            cumulativeFrequency += entry.getValue();
            System.out.println("Число " + entry.getKey() + ": " + cumulativeFrequency);
        }

        // Частість
        System.out.println("Частість:");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            double relativeFrequency = (double) entry.getValue() / size;
            System.out.printf("Число %d: %.4f%n", entry.getKey(), relativeFrequency);
        }

        // Завершення програми
        scanner.close();
    }
}
