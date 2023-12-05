package test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import RMI.InvokerInterface;
import application.Controller;
import application.Invoker;
import faas_exceptions.InvokerNotValid;

public class BasicTestController {

	private Controller controller;

	/*
	 * This gets called before each Test.
	 * (for some reason BeforeEach couldn't be used)
	 */
	@Before
	public void	controllerInitialization()
	{
		controller = Controller.instantiate();
		System.out.println("Controller instantiated");
	}

	/*
	 * Test to check if Controller gets instantiated correctly with
	 * multiple instantiations.
	 */
	@Test
	public void	testControllerMultipleInstantiation()
	{
		assertTrue(controller != null);
		Controller controller2 = Controller.instantiate();
		assertEquals(controller, controller2);
 	}

	/*
	 * Test to check if Invokers get correctly registered in our Controller.
	 */
	@Test
	public void	testRegisterInvokerCorrecly()
	{
		assertThrows(InvokerNotValid.class, () -> controller.registerInvoker(null));
		Invoker invoker = Invoker.createInvoker(1);
		try {
			controller.registerInvoker(invoker);
			assertThrows(InvokerNotValid.class, () -> controller.registerInvoker(invoker));
		} catch (InvokerNotValid e) {
		}
		List<InvokerInterface> invokers = controller.getInvokerInterfaces();
		assertTrue(invokers.contains(invoker));
		assertTrue(invokers.size() == 1);
 	}

	/*
	 * Test to check if Invokers get correctly deleted in our Controller.
	 */
	@Test
	public void	testDeleteInvokerCorrecly()
	{
		assertThrows(InvokerNotValid.class, () -> controller.deleteInvoker(null));
		Invoker invoker = Invoker.createInvoker(1);
		assertThrows(InvokerNotValid.class, () -> controller.deleteInvoker(invoker));
		try {
			controller.registerInvoker(invoker);
			controller.deleteInvoker(invoker);
		} catch (InvokerNotValid e) {
		}
		List<InvokerInterface> invokers = controller.getInvokerInterfaces();
		assertTrue(!invokers.contains(invoker));
		assertTrue(invokers.size() == 0);
 	}

}
