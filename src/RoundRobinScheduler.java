import java.util.LinkedList;
//    >>>>>>>>>>>>>>>>>>>>>>>***<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//    Q5.  Use a queue to simulate Round Robin Scheduling

//  جدولة Round Robin هي خوارزمية جدولة تقوم بتخصيص وقت المعالج للعمليات بالتناوب
//  وفقًا لشريحة زمنية محددة (quantum). يمكن استخدام صف لمحاكاة هذه الجدولة بفعالية.
public class RoundRobinScheduler {

    public static void main(String[] args) {
        int quantum = 2; // شريحة الوقت

        // بيانات العمليات (اسم العملية، وقت الاندفاع)
        Process[] processes = {
                new Process("A", 5),
                new Process("B", 3),
                new Process("C", 4),
        };

        LinkedList<Process> queue = new LinkedList<>();
        for (Process process : processes) {
            queue.add(process);
        }

        int completed = 0;
        while (completed != processes.length) {
            Process process = queue.pollFirst();
            if (process.burstTime <= quantum) {
                process.burstTime = 0;
                System.out.println("Process " + process.name + " completed");
                completed++;
            } else {
                process.burstTime -= quantum;
                System.out.println("Process " + process.name + " partially executed, remaining time: " + process.burstTime);
                queue.addLast(process);
            }
        }

        // حساب المتوسطات
        int totalTurnaroundTime = 0;
        int totalWaitingTime = 0;
        for (Process process : processes) {
            totalTurnaroundTime += process.turnaroundTime;
            totalWaitingTime += process.waitingTime;
        }

        double avgTurnaroundTime = (double) totalTurnaroundTime / processes.length;
        double avgWaitingTime = (double) totalWaitingTime / processes.length;

        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
        System.out.println("Average Waiting Time: " + avgWaitingTime);
    }
}

class Process {
    String name;
    int burstTime;
    int turnaroundTime;
    int waitingTime;

    public Process(String name, int burstTime) {
        this.name = name;
        this.burstTime = burstTime;
    }
}

