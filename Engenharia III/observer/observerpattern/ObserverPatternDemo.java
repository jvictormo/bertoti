import java.util.ArrayList;
import java.util.List;

// Interface do Observer
interface Observer {
    void update(String message);
}

// Interface do Subject
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// Implementação concreta do Subject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(message);
        }
    }
}

// Implementação concreta do Observer
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " recebeu a mensagem: " + message);
    }
}

// Demonstração do padrão Observer
public class ObserverPatternDemo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver("Observer1");
        Observer observer2 = new ConcreteObserver("Observer2");

        // Registro dos observers
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        // Atualização do estado: os observers serão notificados
        subject.setMessage("Olá, Observadores!");
    }
}