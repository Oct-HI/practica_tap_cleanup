package application;

import java.io.Serializable;
import java.util.function.Function;

public class Invokable implements Serializable{

	private String id;
    private Object invokable;
    private long ram;

    /**
     * Constructs an Invokable instance with the specified ID, invokable function, and allocated RAM.
     *
     * @param id        The unique identifier for the invokable function.
     * @param invokable The invokable function.
     * @param ram       The allocated RAM for the invokable function.
     */
    public Invokable(String id, Object invokable, long ram) {
        this.ram = ram;
        this.invokable = invokable;
        this.id = id;
    }

    /**
     * Gets the ID of the invokable function.
     *
     * @return The unique identifier.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the invokable function.
     *
     * @return The invokable function.
     */
    public Object getInvokable() {
        return invokable;
    }

    /**
     * Gets the allocated RAM for the invokable function.
     *
     * @return The allocated RAM.
     */
    public long getRam() {
        return ram;
    }

    /**
     * Applies the function to the provided arguments.
     *
     *
     * @param args The arguments to be passed to the invokable function.
     * @param <T>  The type of the argument.
     * @param <R>  The type of the result.
     * @return The result of applying the invokable function to the arguments. //TODO:Define this better
     */
	@SuppressWarnings("unchecked")
    public <T, R> R apply(T args) {
        return ((Function<T, R>) invokable).apply(args);
    }
}
