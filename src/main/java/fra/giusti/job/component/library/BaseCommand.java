package fra.giusti.job.component.library;

public abstract class BaseCommand<T,K> {
    public abstract K  execute(T input);
}
