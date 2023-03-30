import java.io.Serializable;
import java.util.Iterator;

public class AnimalList implements Iterable<Animal>, Serializable {
    private int size = 0;
    private AnimalNode head = null, tail = null;

    boolean isEmpty() {
        return (size == 0);
    }

    void addFirst(Animal animal) {
        AnimalNode n = new AnimalNode(animal);
        if (isEmpty()) {
            head = tail = n;
        } else {
            n.next = head;
            head = n;
        }
        size++;
    }

    void addLast(Animal animal) {
        AnimalNode n = new AnimalNode(animal);
        if (isEmpty())
            head = tail = n;
        else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    void add(int index, Animal animal) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addFirst(animal);
        } else if (index == size) {
            addLast(animal);
        } else {
            AnimalNode n = new AnimalNode(animal);
            AnimalNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            n.next = current.next;
            current.next = n;
            size++;
        }
    }

    Animal removeFirst() {
        if (size == 0) {
            return null;
        } else {
            AnimalNode toRemove = head;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return toRemove.element;
        }
    }

    Animal removeLast() {
        if (size == 0) {
            return null;
        } else {
            AnimalNode toRemove = tail;
            AnimalNode current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
            size--;
            return toRemove.element;
        }
    }

    Animal remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (size == 0) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            AnimalNode prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            AnimalNode current = prev.next;
            prev.next = current.next;
            size--;
            return current.element;
        }
    }

    Animal getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    Animal getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    Animal get(int index) {
        if (index == 0) {
            return getFirst();
        } else if (index == size - 1) {
            return getLast();
        } else {
            AnimalNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.element;
        }
    }

    Animal set(int index, Animal animal) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            AnimalNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Animal n = current.element;
            current.element = animal;
            return n;
        }
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Animal a : this) {
            string.append(a.toString() + "\n");
        }
        return string.toString();
    }

    public Iterator<Animal> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Animal> {
        private AnimalNode current = head;

        public boolean hasNext() {
            return (current != null);
        }

        public Animal next() {
            Animal e = current.element;
            current = current.next;
            return e;
        }
    }

    AnimalList getHungryAnimals() {
        AnimalList hungryAnims = new AnimalList();
        for (Animal a : this) {
            if (a.getEnergy() < 50) {
                hungryAnims.addLast(a);
            }
        }
        return hungryAnims;
    }

    AnimalList getStarvingAnimals() {
        AnimalList starvingAnims = new AnimalList();
        for (Animal a : this) {
            if (a.getEnergy() < 17) {
                starvingAnims.addLast(a);
            }
        }
        return starvingAnims;
    }

    AnimalList getAnimalsInBarn() {
        AnimalList animsInBarn = new AnimalList();
        for (Animal a : this) {
            if ((a.getX() >= 450 || a.getX() <= 550) && (a.getY() >= 50 || a.getY() <= 150)) {
                animsInBarn.addLast(a);
            }
        }
        return animsInBarn;
    }

    double getRequiredFood() {
        double food = 0;
        for (Animal a : this) {
            food += (100 - a.getEnergy());
        }
        return food;
    }

    class AnimalNode implements Serializable {
        Animal element;
        AnimalNode next;

        public AnimalNode(Animal e) {
            element = e;
        }
    }

    public int size() {
        return size;
    }
}