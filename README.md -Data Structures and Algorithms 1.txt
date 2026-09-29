Data Structures and Algorithms 1 — Group Mini-Project 2026 Namibia University of Science and Technology Faculty of Computing and Informatics

Project Description

A Java simulation of the NUST Campus Service Centre, built to demonstrate the correct selection, implementation, and analysis of core data structures and algorithms. The system manages student waiting lines, service records, postfix expression evaluation, daily statistics, and comparative performance testing of sorting algorithms — all implemented from scratch, without built-in Java data structure or sorting classes.

Group Members
	
1.Nelca Maleka Zinga -226046389
2.Gizela S. A. Manuel -226029069
3.Ndasilwohenda Nandiinotya -224080881
4.Paulina Salom	       226082830
5.Shikongo Andreas Hafeni Pombili-226035271
6.Tafadzwa Blazio Mutakiwa-226029522



Features Implemented
Queue  manages the student waiting line (enqueue, dequeue, peek, isEmpty, displayQueue)
Singly Linked List — maintains student service records (insert at beginning/end/position, delete, search, display)
Stack — evaluates postfix arithmetic expressions (push, pop, peek, evaluatePostfix)
Array Statistics — computes total, average, highest, lowest service time and count of services over 10 minutes, using manual traversal (no built-in max()/min()/sum())
Sorting Algorithms — custom implementations of Selection Sort, Insertion Sort, Merge Sort, and Quick Sort, each with comparison and swap/shift counters
Algorithm Experiment — compares all four sorting algorithms on randomly generated arrays (20, 50, 100, 500 elements) and on an almost-sorted 100-element array, measuring comparisons and execution time
Postfix Evaluation Demo — traces the expression 5 3 + 2 * step by step, ending in the final result 16
Integrated Service-Centre Menu — a single Java program tying the Queue, Linked List, Array, and Sorting components together
Requirements
Java Development Kit (JDK) 17 or later
No external libraries required — all data structures and sorting algorithms are implemented manually
How to Compile and Run
Clone the repository:
   git clone - https://github.com/226029522-Tafadzwa/DSA521S_GROUP_PROJECT_2026.git
Compile all Java source files:
   javac *.java
Run the integrated Campus Service Centre menu:
   java Main
To run the standalone Stack/postfix demonstration:
   java Postfix
To run the sorting algorithm experiment (Part C):
   java PartC
Menu Options (Integrated System)

Option	Structure / Operation
1	Add student to waiting queue — Queue enqueue
2	Serve next student — Queue dequeue
3	Display the waiting list — Queue traversal
4	Verify if the queue is empty — Queue isEmpty
5	Search in the queue — Queue peek/search
6	Add student service record — Linked List insertion
7	Display student service records — Linked List traversal
8	Remove student record — Linked List deletion
9	Display daily statistics — Array processing
10	Sort service times — Sorting algorithm(s)
11	Run sorting experiment — Algorithm comparison
12	Exit

Restrictions Followed
No built-in sort() or equivalent sorting functions
No built-in Stack, Queue, or LinkedList classes — all implemented manually with arrays/nodes
No built-in max(), min(), or sum() used for array statistics
GitHub Repository

https://github.com/226029522-Tafadzwa/DSA521S_GROUP_PROJECT_2026.git
Documentation

The full project report (PDF) — including diagrams, pseudocode, traces, the algorithm experiment analysis, and system screenshots 