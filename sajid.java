import java.util.*;

public class Main {
    public static int[][] findSumCombinations(int[] nums, int target) {
        Map<Integer, List<List<Integer>>> combinationsMap = new HashMap<>();
        List<List<Integer>> combinations = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num1 = nums[i];
                int num2 = nums[j];
                if (num1 + num2 == target) {
                    List<Integer> pair = Arrays.asList(num1, num2);
                    combinations.add(pair);
                }
            }
        }

        combinationsMap.put(target, combinations);

        int[][] result = new int[combinations.size()][2];
        for (int i = 0; i < combinations.size(); i++) {
            List<Integer> pair = combinations.get(i);
            result[i][0] = pair.get(0);
            result[i][1] = pair.get(1);
        }

        return result;
    }

    public static int[][] findDoubleSumCombinations(int[] nums, int target) {
        int doubleTarget = target * 2;

        List<List<Integer>> combinations = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num1 = nums[i];
                int num2 = nums[j];
                if (num1 + num2 == doubleTarget) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(num1);
                    pair.add(num2);
                    combinations.add(pair);
                }
            }
        }

        int[][] result = new int[combinations.size()][];
        for (int i = 0; i < combinations.size(); i++) {
            List<Integer> pair = combinations.get(i);
            result[i] = new int[pair.size()];
            for (int j = 0; j < pair.size(); j++) {
                result[i][j] = pair.get(j);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int numElements = scanner.nextInt();

        int[] nums = new int[numElements];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < numElements; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        int[][] sumCombinations = findSumCombinations(nums, target);
        System.out.println("First Combination For \"" + target + "\": " + Arrays.deepToString(sumCombinations));

        int[] mergedArray = Arrays.stream(nums).sorted().toArray();
        System.out.println("Merge Into a Single Array: " + Arrays.toString(mergedArray));

        int[][] doubleSumCombinations = findDoubleSumCombinations(mergedArray, target);
        System.out.println("Second Combination For \"" + (target * 2) + "\": " + Arrays.deepToString(doubleSumCombinations));
    }
}
