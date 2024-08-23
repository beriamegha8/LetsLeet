class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0, denominator = 1;

        //parsing the expression acc to + or -
        Scanner scanner = new Scanner(expression).useDelimiter("(?=[-+])");
        
        while (scanner.hasNext()) {
            String fraction = scanner.next(); //stores individual fractions
            String[] parts = fraction.split("/"); //separates numerator and denominator
            int num = Integer.parseInt(parts[0]);
            int denom = Integer.parseInt(parts[1]);

            //performing the addition/subtraction
            numerator = numerator * denom + num * denominator;
            denominator *= denom;

            //reducing the fraction to its irreducible form by dividing by gdc
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return numerator + "/" + denominator;
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
