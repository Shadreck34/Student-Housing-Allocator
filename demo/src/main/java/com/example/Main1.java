import java.util.*;

class Student {
    private String name;
    private int id;
    private boolean allocated;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.allocated = false;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isAllocated() {
        return allocated;
    }

    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }
}

class Room {
    private int roomNumber;
    private boolean occupied;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.occupied = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}

class HousingAllocator {
    private List<Student> students;
    private List<Room> rooms;

    public HousingAllocator() {
        students = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void allocateHousing() {
        for (Student student : students) {
            for (Room room : rooms) {
                if (!room.isOccupied()) {
                    student.setAllocated(true);
                    room.setOccupied(true);
                    System.out.println("Allocated Room " + room.getRoomNumber() + " to " + student.getName());
                    break;
                }
            }
        }
    }
}

public class Main1{
    public static void main(String[] args) {
        HousingAllocator allocator = new HousingAllocator();

        // Adding students
        allocator.addStudent(new Student("John", 101));
        allocator.addStudent(new Student("Alice", 102));
        allocator.addStudent(new Student("Bob", 103));

        // Adding rooms
        allocator.addRoom(new Room(1));
        allocator.addRoom(new Room(2));
        allocator.addRoom(new Room(3));

        // Allocating housing
        allocator.allocateHousing();
    }
}
