
public class Management {

    Task head;

    public void addTask(int id, String name, String status) {

        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
            return;
        }

        Task temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newTask;
    }

    public void traverse() {

        Task temp = head;

        while (temp != null) {
            System.out.println(temp.taskName);
            temp = temp.next;
        }
    }

    public Task search(int id) {

        Task temp = head;

        while (temp != null) {

            if (temp.taskId == id)
                return temp;

            temp = temp.next;
        }

        return null;
    }

    public void delete(int id) {

        if (head == null)
            return;

        if (head.taskId == id) {
            head = head.next;
            return;
        }

        Task temp = head;

        while (temp.next != null &&
                temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    public static void main(String[] args) {
        Management management = new Management();

        management.addTask(1, "Create project plan", "Pending");
        management.addTask(2, "Develop feature", "In Progress");
        management.addTask(3, "Test application", "Pending");

        System.out.println("All tasks:");
        management.traverse();

        System.out.println("\nSearch result:");
        System.out.println(management.search(2));

        management.delete(1);

        System.out.println("\nAfter deleting task 1:");
        management.traverse();
    }
}
