package testing.controller;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import application.Controller;
import faas_exceptions.OperationNotValid;
import invoker.Invoker;
import invoker.InvokerInterface;

/**
 * The BasicTestController class contains basic test cases for the Controller class.
 * Checks correct instantiation of Controller and registration of invokers.
 */
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
		assertSame(controller, controller2);
 	}

	/*
	 * Test to check if Invokers get correctly registered in our Controller.
	 */
	@Test
	public void	testRegisterInvokerCorrecly()
	{
		assertThrows(OperationNotValid.class, () -> controller.registerInvoker(null));
		Invoker invoker = Invoker.createInvoker(1);
		try {
			controller.registerInvoker(invoker);
			assertThrows(OperationNotValid.class, () -> controller.registerInvoker(invoker));
		} catch (OperationNotValid e) {
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
		assertThrows(OperationNotValid.class, () -> controller.deleteInvoker(null));
		Invoker invoker = Invoker.createInvoker(1);
		assertThrows(OperationNotValid.class, () -> controller.deleteInvoker(invoker));
		try {
			controller.registerInvoker(invoker);
			controller.deleteInvoker(invoker);
		} catch (OperationNotValid e) {
		}
		List<InvokerInterface> invokers = controller.getInvokerInterfaces();
		assertTrue(!invokers.contains(invoker));
		assertTrue(invokers.size() == 0);
 	}

}
