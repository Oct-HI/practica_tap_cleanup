package application;

import java.io.Serializable;
import java.util.function.Function;

/**
 * A class that represents an invokable function with a unique identifier, the invokable function itself,
 * and the allocated RAM for execution.
 */
public class Invokable implements Serializable{

	private String id;
    private Object invokable;
    private long ram;

<<<<<<< Updated upstream
    /**
=======
	/**
>>>>>>> Stashed changes
     * Constructs an Invokable instance with the specified ID, invokable function, and allocated RAM.
     *
     * @param id        The unique identifier for the invokable function.
     * @param invokable The invokable function.
     * @param ram       The allocated RAM for the invokable function.
     */
<<<<<<< Updated upstream
    public Invokable(String id, Object invokable, long ram) {
        this.ram = ram;
        this.invokable = invokable;
        this.id = id;
    }
=======
	public Invokable(String id, Object invokable, long ram) {
		this.ram = ram;
		this.invokable = invokable;
		this.id	= id;
	}
>>>>>>> Stashed changes

    /**
     * Gets the ID of the invokable function.
     *
     * @return The unique identifier.
     */
<<<<<<< Updated upstream
    public String getId() {
        return id;
    }

    /**
=======
	public String getId()
	{
		return (id);
	}

	/**
>>>>>>> Stashed changes
     * Gets the invokable function.
     *
     * @return The invokable function.
     */
<<<<<<< Updated upstream
    public Object getInvokable() {
        return invokable;
    }

    /**
=======
    public Object getInvokable()
	{
		return (this.invokable);
	}

	/**
>>>>>>> Stashed changes
     * Gets the allocated RAM for the invokable function.
     *
     * @return The allocated RAM.
     */
<<<<<<< Updated upstream
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
=======
	public long getRam()
	{
		return (this.ram);
	}
>>>>>>> Stashed changes
}
