class Solution {
    // Function to get all prime numbers up to n using Sieve of Eratosthenes
    private List<Integer> getPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
    
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        // Get all prime numbers up to the maximum value in nums
        List<Integer> primes = getPrimes(1000);
        
        // Start from index 0
        int prev = 0;  // Previous value to compare with
        
        for (int i = 0; i < n; i++) {
            if (nums[i] <= prev) {
                // If current number is less than or equal to previous,
                // it's impossible to make array strictly increasing
                return false;
            }
            
            // Find the largest prime p where nums[i] - p > prev
            int maxPrime = 0;
            for (int prime : primes) {
                if (prime >= nums[i]) break;
                if (nums[i] - prime > prev) {
                    maxPrime = prime;
                }
            }
            
            // Subtract the prime if found
            nums[i] -= maxPrime;
            prev = nums[i];  // Update previous value
        }
        
        return true;
    }
}
