package dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import application.Controller;

public class DynamicProxy implements InvocationHandler {

	//The instance which this proxy intercepts methods from.

	/**
	 * This DynamicProxy intercepts method invocations on the provided target object.
	 *
	 * The purpose of this DynamicProxy is to intercept method calls made on the target object. The intercepted
	 * method invocations are then routed to a controller, where the actual method execution takes place. From the
	 * client's perspective, it appears as though the methods are called directly on the object obtained from the
	 * controller using object-oriented methodology. 
	 * 
	 * NOTE: The target object is the reference provided when a method is invoked. It is not
	 * the controller itself but serves as a conduit for routing method calls to the controller.
	 *
	 * @param target The object on which method invocations are intercepted.
	 * @return The proxy object that intercepts method calls on the provided target object.
	 */
	public static Object instantiate(Object target) {
		Class<?> targetClass = target.getClass();
		Class<?> interfaces[] = targetClass.getInterfaces();

		return Proxy.newProxyInstance(targetClass.getClassLoader(),
				interfaces, new DynamicProxy());
	}

	private DynamicProxy() {}
	
	//TODO: check wording
	/**
	 * This invocation handler intercepts method calls on the associated proxy object.
	 *
	 * When a method is called on the proxy object, this invocation handler intercepts the call and performs specific
	 * actions based on the method name. 
	 * If the method name is "registerAction" a new interface is generated with the provided method as a parameter,
	 * The proxy object is then redefined with the new interface. 
	 * If the method name is "removeAction" the corresponding method is removed from the logic
	 * of interfaces, and the proxy object is redefined accordingly. 
	 * Otherwise, the method is called normally.
	 *
	 * @param proxy  The proxy object on which the method is called.
	 * @param method The method being invoked.
	 * @param args   The list ofarguments passed to the method.
	 * @return The result of the method invocation.
	 * @throws Exception
	 */ 
	//TODO: What does proxy do here?? Compatibility with java definitions?
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Exception
	{
		String	id = method.getName();
		Controller	controller;
		controller = Controller.instantiate();
		Object result = controller.invoke_async(id, args[0]);
		return result;
	}
}
