
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
 
    // STEP 2: returns the served student (null if the queue is empty)
    public static Student dequeue() {
        if (front == -1 && rear == -1) {
            return null;
        }
        Student served = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        return served;
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
 
        // Insert at the beginning
        void insertBeg(Student Student) {
            Node newNode = new Node(Student);
            newNode.next = head;
            head = newNode;
        }
 
        // Insert at the end
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
 
        // Insert at a given position (1 = beginning, 2 = second node, ...).
        // Returns false if the position is invalid.
        boolean insertStudent(Student Student, int position) {
            if (position < 1) {
                return false;
            }
            if (position == 1) {
                insertBeg(Student);
                return true;
            }
            // walk to the node BEFORE the wanted position
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            if (current == null) {
                return false; // position is beyond size + 1
            }
            Node newNode = new Node(Student);
            newNode.next = current.next;  // new node points to the rest
            current.next = newNode;       // previous node points to new node
            return true;
        }
 
        // Delete the record with the given student number.
        // Returns false if it was not found.
        boolean deleteStudent(String studentNo) {
            if (head == null) {
                return false;
            }
            if (head.Student.StudentNo.equals(studentNo)) { // deleting the first node
                head = head.next;
                return true;
            }
            Node current = head;
            while (current.next != null && !current.next.Student.StudentNo.equals(studentNo)) {
                current = current.next;
            }
            if (current.next == null) {
                return false; // not found
            }
            current.next = current.next.next; // skip the deleted node
            return true;
        }
 
        // Search by student number. Returns the node, or null if not found.
        Node searchStudent(String studentNo) {
            Node current = head;
            while (current != null) {
                if (current.Student.StudentNo.equals(studentNo)) {
                    return current;
                }
                current = current.next;
            }
            return null;
        }
 
        // Traverse and print all records
        void displayStudents() {
            if (head == null) {
                System.out.println("No service records yet.");
                return;
            }
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
 
    // ---------- Input helpers ----------
    static Scanner input = new Scanner(System.in);
 
    static int readInt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(input.nextLine().trim());
    }
 
    static String readLine(String prompt) {
        System.out.println(prompt);
        return input.nextLine().trim();
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
 
    // ---------- Record operations used by the menu ----------
    static void deleteRecord() {
        String no = readLine("Enter the student number to delete: ");
        if (list.deleteStudent(no)) {
            System.out.println("Record deleted.");
        } else {
            System.out.println("Record not found.");
        }
    }
 
    static void searchRecord() {
        String no = readLine("Enter the student number to search: ");
        Node found = list.searchStudent(no);
        if (found == null) {
            System.out.println("Record not found.");
        } else {
            System.out.println("Record found: " + found.Student);
        }
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
                Student served = dequeue();
                if (served == null) {
                    System.out.println("Queue is empty !");
                } else {
                    System.out.println("Now serving: " + served);
                }
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
                System.out.println("1.Insert record at the End ");
                System.out.println("2.Insert record at the Beginning ");
                System.out.println("3.Insert record at a specific position ");
                System.out.println("4.Delete Record ");
                System.out.println("5.Search Record ");
                System.out.println("6.Display Records ");
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
                    case 3:
                        int position = readInt("Enter the position (1 = beginning): ");
                        Student s = readStudent();
                        if (list.insertStudent(s, position)) {
                            System.out.println("Student service record added at position " + position + ".");
                        } else {
                            System.out.println("Invalid position. Record not added.");
                        }
                        break;
                    case 4:
                        deleteRecord();
                        break;
                    case 5:
                        searchRecord();
                        break;
                    case 6:
                        list.displayStudents();
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } else if (choice == 7) {
                list.displayStudents();
            } else if (choice == 8) {
                deleteRecord();
            } else {
                System.out.println("Invalid Operation...");
                break;
            }
        }
    }
}
 







