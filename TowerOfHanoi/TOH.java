import java.util.InputMismatchException;
import java.util.Scanner;

// Java program for iterative
// Tower of Hanoi
public class TOH{

    // A structure to represent a stack
    class Stack
    {
        int capacity;
        int top;
        int array[];
    }

    // Function to create a stack of given capacity.
    Stack createStack(int capacity)
    {
        Stack stack = new Stack();
        stack.capacity = capacity;
        stack.top = -1;
        stack.array = new int[capacity];
        return stack;
    }

    // Stack is full when the top is equal
// to the last index
    boolean isFull(Stack stack)
    {
        return (stack.top == stack.capacity - 1);
    }

    // Stack is empty when top is equal to -1
    boolean isEmpty(Stack stack)
    {
        return (stack.top == -1);
    }

    // Function to add an item to stack.It
// increases top by 1
    void push(Stack stack, int item)
    {
        if (isFull(stack))
            return;

        stack.array[++stack.top] = item;
    }

    // Function to remove an item from stack.It
// decreases top by 1
    int pop(Stack stack)
    {
        if (isEmpty(stack))
            return Integer.MIN_VALUE;

        return stack.array[stack.top--];
    }

    // Function to implement legal movement between
// two poles
    void moveDisksBetweenTwoPoles(Stack src, Stack dest,
                                  String s, String d)
    {
        int pole1TopDisk = pop(src);
        int pole2TopDisk = pop(dest);

        // When pole 1 is empty
        if (pole1TopDisk == Integer.MIN_VALUE)
        {
            push(src, pole2TopDisk);
            moveDisk(d, s, pole2TopDisk);
        }

        // When pole2 pole is empty
        else if (pole2TopDisk == Integer.MIN_VALUE)
        {
            push(dest, pole1TopDisk);
            moveDisk(s, d, pole1TopDisk);
        }

        // When top disk of pole1 > top disk of pole2
        else if (pole1TopDisk > pole2TopDisk)
        {
            push(src, pole1TopDisk);
            push(src, pole2TopDisk);
            moveDisk(d, s, pole2TopDisk);
        }
        // When top disk of pole1 < top disk of pole2
        else
        {
            push(dest, pole2TopDisk);
            push(dest, pole1TopDisk);
            moveDisk(s, d, pole1TopDisk);
        }
    }

    // Function to show the movement of disks
    void moveDisk(String fromPeg, String toPeg, int disk)
    {
        System.out.println("Move the disk " + disk +
                " from " + fromPeg +
                " to " + toPeg);
    }

    // Function to implement TOH puzzle
    void tohIterative(int num_of_disks, Stack
            src, Stack aux, Stack dest)
    {
        int i, total_num_of_moves;
        String s = "Left Pole", d = "Middle Pole", a = "Right Pole";

        // If number of disks is even, then
        // interchange destination pole and
        // auxiliary pole
        if (num_of_disks % 2 == 0)
        {
            String temp = d;
            d = a;
            a = temp;
        }
        total_num_of_moves = (int)(Math.pow(
                2, num_of_disks) - 1);

        // Larger disks will be pushed first
        for(i = num_of_disks; i >= 1; i--)
            push(src, i);

        for(i = 1; i <= total_num_of_moves; i++)
        {
            if (i % 3 == 1)
                moveDisksBetweenTwoPoles(src, dest, s, d);

            else if (i % 3 == 2)
                moveDisksBetweenTwoPoles(src, aux, s, a);

            else if (i % 3 == 0)
                moveDisksBetweenTwoPoles(aux, dest, a, d);
        }
        System.out.println("Total number of move is: " + total_num_of_moves);
    }

    // Driver code
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("What is the number of disks? Enter less than one will terminate the program: ");
                int num_of_disks = scanner.nextInt();
                if (num_of_disks < 1) {
                    break;
                }
                TOH ob = new TOH();
                Stack src, dest, aux;

                // Create three stacks of size 'num_of_disks'
                // to hold the disks
                src = ob.createStack(num_of_disks);
                dest = ob.createStack(num_of_disks);
                aux = ob.createStack(num_of_disks);

                ob.tohIterative(num_of_disks, src, aux, dest);
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please input only integer!");
                scanner.next();
            }
        }
        System.out.println("The function has been terminated!");
    }
}

// This code is inspire by Sumit Ghosh

