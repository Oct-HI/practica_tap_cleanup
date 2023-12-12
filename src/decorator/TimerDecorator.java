package decorator;
import java.util.function.Function;

public class TimerDecorator<T, R> extends Decorator<T, R>{

	public TimerDecorator(Function<T, R> function) {
		super(function);
	}

	/**
	 * Applies the timer decorator logic to the given argument, measuring the execution time of the underlying function.
	 *
	 * @param t The argument to be passed to the decorated function.
	 * @return The result of applying the timer decorator logic to the provided argument.
	 */
	@Override
	public R apply(T t) {
		long	timeExecution;
		R		result;

		timeExecution = System.nanoTime();
		result = getFunction().apply(t);
		timeExecution = System.nanoTime() - timeExecution;
		System.out.println("Time of execution is " + timeExecution + " ns.");
		return (result);
	}

}
