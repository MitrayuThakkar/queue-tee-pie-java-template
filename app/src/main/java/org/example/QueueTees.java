package org.example;

public class QueueTees {

    private Cutie[] queue;  // Array to hold the queue items
    private int front;      // Points to the front of the queue
    private int back;       // Points to the next available space
    private int size;       // Current size of the queue

    private static final int MAX_SIZE = 5;  // Set a max size for the queue

    // Constructor to initialize the queue
    public QueueTees() {
        queue = new Cutie[MAX_SIZE];
        front = 0;
        back = 0;
        size = 0;
    }

    // Enqueue a new Cutie to the queue
    public void enqueue(Cutie cutie) {
        if (size == MAX_SIZE) {
            System.out.println("Queue is full! Cannot enqueue another cutie.");
            return;
        }
        queue[back] = cutie;
        back = (back + 1) % MAX_SIZE;  // Circular increment
        size++;
    }

    // Dequeue a Cutie from the queue
    public Cutie dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return null;
        }
        Cutie removedCutie = queue[front];
        front = (front + 1) % MAX_SIZE;  // Circular increment
        size--;
        return removedCutie;
    }

    // Peek at the front element of the queue without removing it
    public Cutie peek() {
        if (size == 0) {
            System.out.println("Queue is empty! Nothing to peek.");
            return null;
        }
        return queue[front];
    }

    // Get the current size of the queue
    public int size() {
        return size;
    }

    // Clear the entire queue
    public void clear() {
        for (int i = 0; i < size; i++) {
            queue[(front + i) % MAX_SIZE] = null;
        }
        front = 0;
        back = 0;
        size = 0;
    }
}
