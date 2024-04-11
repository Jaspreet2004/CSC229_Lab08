import java.util.Scanner;

public class Main {
    static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    static boolean containsDigitThree(int num) {
        while (num != 0) {
            if (num % 10 == 3) return true;
            num /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        SinglyLinkedList primeList = new SinglyLinkedList();
        SinglyLinkedList primeWithThreeList = new SinglyLinkedList();

        for (int i = 0; i <= n; i++) {
            if (isPrime(i)) {
                primeList.insert(i);
                if (containsDigitThree(i)) {
                    primeWithThreeList.insert(i);
                }
            }
        }

        System.out.println("Prime numbers between 0 and " + n + ": ");
        System.out.println("Prime List: ");
        int sumPrime = primeList.sum();
        System.out.println("Sum of prime numbers in the list are: " + sumPrime);

        System.out.println("Prime numbers (with digit 3) between 0 and " + n + ": ");
        System.out.println("Prime List (with Digit 3): ");
        int sumPrimeWithThree = primeWithThreeList.sum();
        System.out.println("Sum of prime numbers (with digit 3) in the list: " + sumPrimeWithThree);
    }
}