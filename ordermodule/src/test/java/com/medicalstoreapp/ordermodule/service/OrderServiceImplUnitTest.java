package com.medicalstoreapp.ordermodule.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.medicalstoreapp.ordermodule.dao.IOrderRepository;
import com.medicalstoreapp.ordermodule.dto.AddOrderRequest;
import com.medicalstoreapp.ordermodule.dto.OrderDetails;
import com.medicalstoreapp.ordermodule.entities.CreatedOrder;
import com.medicalstoreapp.ordermodule.exceptions.OrderNotFoundException;
import com.medicalstoreapp.ordermodule.util.DateConverter;
import com.medicalstoreapp.ordermodule.util.OrderUtil;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplUnitTest {
	
	@Mock
	private IOrderRepository orderRepo;
	
	@Mock
	private DateConverter dateConverter;
	
	@Mock
	private OrderUtil orderUtil;
	
	@InjectMocks
	@Spy
	private OrderServiceImpl service;
	
	
	/**
	 * Scenario: Finding the OrderDetails by orderId
	 * Expectation: Result should contain the orderDetails
	 */
	@Test
	public void testFindByOrderId_1() {
		long orderId = 1;
		CreatedOrder createdOrder = mock(CreatedOrder.class);
		Optional<CreatedOrder> optional = Optional.of(createdOrder);
		when(orderRepo.findById(orderId)).thenReturn(optional);
		CreatedOrder result = service.findByOrderId(orderId);
		assertEquals(createdOrder, result);
		verify(orderRepo).findById(orderId);
	}
	
	
	/**
	 * Scenario: Order not found exception while giving the wrong id
	 * Expectation: OrderNotFoundException should thrown
	 */
	@Test
	public void testFindByOrderId_2() {
		long orderId = -10;
		Executable executable = () -> {
			Optional<CreatedOrder> optional = Optional.empty();
			when(orderRepo.findById(orderId)).thenReturn(optional);
			service.findByOrderId(orderId);
		};
		assertThrows(OrderNotFoundException.class, executable);
	}
	
	
	/**
	 * Scenario: test addOrder method
	 * Expectation: Result should contain the placed orderDetails.
	 * 
	 */
	@Test
	public void testAddOrder_1() {
		AddOrderRequest request = mock(AddOrderRequest.class);
		CreatedOrder order = mock(CreatedOrder.class);
		LocalDate date = LocalDate.now();
		doReturn(order).when(service).newOrder();
		doReturn(date).when(service).newLocalDate();
		when(orderRepo.save(order)).thenReturn(order);
		OrderDetails orderDetails = mock(OrderDetails.class);
		when(orderUtil.toOrderDetails(order)).thenReturn(orderDetails);
		OrderDetails result  = service.addOrder(request);
		assertEquals(orderDetails,result);
		verify(orderRepo).save(order);
		verify(orderUtil).toOrderDetails(order);
	}
	

	/**
	 * Scenario: Fetch all orders
	 * Expectation: Result should contain all the orders.
	 */
	@Test
	public void testFetchAllOrders() {
		List<CreatedOrder> orders = mock(List.class);
		List<OrderDetails> orderDetailsList = mock(List.class);
		when(orderRepo.findAll()).thenReturn(orders);
		when(orderUtil.toOrderDetailsList(orders)).thenReturn(orderDetailsList);
		List<OrderDetails> result = service.fetchAllOrders();
		assertEquals(orderDetailsList,result);
	}
}
