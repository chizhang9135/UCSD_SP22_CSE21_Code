public class Salary {
    public void salaryInRange(int[] a, int low, int high) {
        int sum = 0;
        int number = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            count++;
            if (a[i]>=low && a[i]<=high) {
                sum = sum + a[i];
                number++;
            }
        }
        System.out.println("Loop counts: " + count);
        if (number == 0) {
            System.out.println("(0,0)");
        }
        else {
            System.out.println("(" + (sum / number) + "," + number + ")");
        }
    }

    public static void main(String[] args) {
        Salary salary = new Salary();
        int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        salary.salaryInRange(intArray,4,8);
    }
}
