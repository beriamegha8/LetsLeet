class Solution {  
    public int[] closestPrimes(int left, int right) {  
        List<Integer> primes = PList(left, right);  

        if (primes.size()< 2) {  
            return new int[]{-1, -1};  
        }  

        int[] result = {-1, -1};  
        int min= Integer.MAX_VALUE;  

        for (int i= 0; i< primes.size()- 1; i++) {  
            int p1 = primes.get(i);  
            int p2 = primes.get(i + 1);  
            int diff = p2- p1;  

            if (diff< min) {  
                min= diff;  
                result[0] = p1;  
                result[1] = p2;  
            }  
        }  
        return result;  
    }  

    private static List<Integer> PList(int left, int right) {  
        List<Integer> primes = new ArrayList<>();  
        for (int i = left; i <= right; i++) {  
            if (isP(i)) {  
                primes.add(i); 
            }  
        }  
        return primes;  
    }  

    private static boolean isP(int n) {  
        if(n <= 1){
            return false;
        }   
        for (int i= 2; i*i<= n; i++) {  
            if(n % i == 0){
                return false; 
            }  
        }  
        return true;  
    }  
}
