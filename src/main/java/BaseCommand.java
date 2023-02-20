public abstract class BaseCommand {

    public Invoker invoker;
    private String backup;


    public BaseCommand(Invoker invoker) {
        this.invoker = invoker;
    }

    void backup() {

    }

    public abstract boolean execute();
}

