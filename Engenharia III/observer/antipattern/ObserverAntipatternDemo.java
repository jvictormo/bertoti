import java.util.ArrayList;
import java.util.List;

// Interface para observers que trabalham com feedback
interface ObserverWithFeedback {
    void update(SubjectWithFeedback subject);
}

// Subject que permite feedback dos observers
class SubjectWithFeedback {
    private List<ObserverWithFeedback> observers = new ArrayList<>();
    private String message;
    private boolean notifying = false;

    public void setMessage(String message) {
        if (notifying) return; // Evita reentrância
        this.message = message;
        notifying = true;
        notifyObservers();
        notifying = false;
    }

    public String getMessage() {
        return message;
    }

    public void registerObserver(ObserverWithFeedback o) {
        observers.add(o);
    }

    public void removeObserver(ObserverWithFeedback o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (ObserverWithFeedback o : observers) {
            o.update(this);
        }
    }
}

// Observer com comportamento inadequado que atualiza o subject dentro do update()
class FaultyObserver implements ObserverWithFeedback {
    private String name;

    public FaultyObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(SubjectWithFeedback subject) {
        System.out.println(name + " recebeu mensagem: " + subject.getMessage());
        // Comportamento incorreto: ao atualizar, o observer altera o estado do subject,
        // causando nova notificação e iniciando um loop de feedback.
        subject.setMessage("Novo valor definido por " + name);
    }
}

// Demonstração do antipadrão do Observer
public class ObserverAntipatternDemo {
    public static void main(String[] args) {
        SubjectWithFeedback subject = new SubjectWithFeedback();
        ObserverWithFeedback faultyObserver = new FaultyObserver("FaultyObserver");

        subject.registerObserver(faultyObserver);

        subject.setMessage("Valor Inicial");
    }
}
