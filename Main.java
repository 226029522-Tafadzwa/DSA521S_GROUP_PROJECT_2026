
import java.util.Scanner;
 
class Main {
 
    // ---------- Student ----------
    static class Student {
        String Name;
        String StudentNo;
        String ServiceType;
        int Estimated_Serv_Time;
 
        public Student(String Name, String StudentNo, String ServiceType, int Estimated_Serv_Time) {
            this.Name = Name;
            this.StudentNo = StudentNo;
            this.ServiceType = ServiceType;
            this.Estimated_Serv_Time = Estimated_Serv_Time;
        }
 
        @Override
        public String toString() {
            return this.Name + " - " + this.StudentNo + " - " + this.ServiceType + " - " + this.Estimated_Serv_Time;
        }
    }
 
    static Student Student1 = new Student("Maria", "221045678", "Registration", 12);
    static Student Student2 = new Student("Tomas", "222034512", "Student Card", 5);
    static Student Student3 = new Student("Ndapewa", "223041876", "Fees", 8);
    static Student Student4 = new Student("Simon", "221067341", "Documents", 4);
 
    // ---------- Queue ----------
    static int front = -1;
    static int rear = -1;
    static int size = 8;
    static Student[] queue = new Student[size];
    static LinkedList list = new LinkedList();
 
    public static void enqueue(Student Student) {
        if (rear == size - 1) {
            System.out.println(" Queue is full");
        } else if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
            queue[rear] = Student;
        } else {
            rear++;
            queue[rear] = Student;
        }
    }
 
    public static void dequeue() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty !");
        } else if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            System.out.println("Student Deleted is: " + queue[front]);
            front++;
        }
    }
 
    public static void isEmpty() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty !");
        } else {
            System.out.println("Queue is not empty !");
        }
    }
 
    public static void peek() {
        if (rear == -1) {
            System.out.println("Queue is empty !");
        } else {
            System.out.println(queue[front]);
        }
    }
 
    // ---------- Linked list ----------
    static class Node {
        Student Student;
        Node next;
 
        public Node(Student Student) {
            this.Student = Student;
            this.next = null;
        }
    }
 
    static class LinkedList {
        Node head;
 
        void insertBeg(Student Student) {
            Node newNode = new Node(Student);
            newNode.next = head;
            head = newNode;
        }
 
        void insertEnd(Student Student) {
            Node newNode = new Node(Student);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }
 
        void Display() {
            Node current = head;
            while (current != null) {
                System.out.println("Name: " + current.Student.Name);
                System.out.println("Student Number: " + current.Student.StudentNo);
                System.out.println("Service Type: " + current.Student.ServiceType);
                System.out.println("Estimated Time: " + current.Student.Estimated_Serv_Time);
                System.out.println("--------------------------------------------------- ");
                current = current.next;
            }
        }
    }
 
    // ---------- Input helpers (STEP 1) ----------
    static Scanner input = new Scanner(System.in);
 
    static int readInt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(input.nextLine().trim());
    }
 
    static Student readStudent() {
        System.out.println("Enter student name: ");
        String name = input.nextLine();
        System.out.println("Enter student number: ");
        String studentNo = input.nextLine();
        System.out.println("Enter service type: ");
        String serviceType = input.nextLine();
        int time = readInt("Enter estimated service time (min): ");
        return new Student(name, studentNo, serviceType, time);
    }
 
    // ---------- Main ----------
    public static void main(String[] args) {
 
        enqueue(Student1);
        enqueue(Student2);
        enqueue(Student3);
        enqueue(Student4);
 
        while (true) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("****************CAMPUS SERVICE CENTER**********************");
            System.out.println("-----------------------------------------------------------");
            System.out.println("1. Add student to waiting queue");
            System.out.println("2. Serve next student ");
            System.out.println("3. Display waiting student");
            System.out.println("4. Verify if queue is Empty or not ");
            System.out.println("5. Search in the queue");
            System.out.println("6. Add student service record ");
            System.out.println("7. Display student service records");
            System.out.println("8. Remove student record");
            System.out.println("9. Display daily statistic");
            System.out.println("10. Sort service time ");
            System.out.println("11. Run sorting times ");
            System.out.println("12. Exit ");
 
            int choice = readInt("Enter your choice: ");
 
            if (choice == 1) {
                enqueue(readStudent());
                System.out.println("Student added in queue!");
            } else if (choice == 2) {
                dequeue();
            } else if (choice == 3) {
                if (front == -1 && rear == -1) {
                    System.out.println("Queue is empty !");
                } else {
                    for (int i = front; i < rear + 1; i++) {
                        System.out.println(queue[i]);
                    }
                }
            } else if (choice == 4) {
                isEmpty();
            } else if (choice == 5) {
                peek();
            } else if (choice == 6) {
                System.out.println("1.Insert record in End ");
                System.out.println("2.Insert record in begin ");
                System.out.println("3.Insert record in the specific position (not implemented yet)");
                System.out.println("4.Delete Record (not implemented yet)");
                System.out.println("5.Search Record (not implemented yet)");
                System.out.println("6.Display Record ");
                int option = readInt("Enter your option: ");
                switch (option) {
                    case 1:
                        list.insertEnd(readStudent());
                        System.out.println("Student service record added at the end.");
                        break;
                    case 2:
                        list.insertBeg(readStudent());
                        System.out.println("Student service record added at the beginning.");
                        break;
                    case 6:
                        list.Display();
                        break;
                    default:
                        System.out.println("Not implemented yet.");
                }
            } else if (choice == 7) {
                list.Display();
            } else {
                System.out.println("Invalid Operation! Try again...");
                break;
            }
        }
    }
}
