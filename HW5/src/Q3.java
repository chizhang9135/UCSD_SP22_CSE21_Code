public class Q3 {
    public double[] counterfeit(double[] input, int a, int b) {
        double[] output = null;
        double sum = 0;

        for (int i = a; i < b; i++) {
            sum = sum + input[i];
        }

        if (input.length == sum) {
            return input;
        }
        else {
            counterfeit(input, a, (a+b)/2);
            counterfeit(input,(a+b)/2+1,b);
        }
        return null;
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        double[] input = {1,1,1,1,1,0.9,1,1,1};
        System.out.println(q3.counterfeit(input,0,3));
    }
}
