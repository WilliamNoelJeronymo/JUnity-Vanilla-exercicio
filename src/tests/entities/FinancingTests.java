package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingTests {

	@Test
	public void constructorShouldCreatObjectWhenValidData() {
		Financing f = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
		Assertions.assertEquals(100000.00, f.getTotalAmount());
		Assertions.assertEquals(2000.00, f.getIncome());
		Assertions.assertEquals(80, f.getMonths());
	}

	@Test
	public void constructorShouldThrowIllegalArgumentExceptionWhenInvalidData() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancing(100000.00, 2000.00, 20);
		});
	}

	@Test
	public void setTotalAmountShouldUpdateTotalBalanceWhenValidData() {
		Financing f = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
		f.setTotalAmount(90000.00);
		Assertions.assertEquals(90000.00, f.getTotalAmount());
	}

	@Test
	public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
			f.setTotalAmount(150000.00);
		});
	}

	@Test
	public void setIncomeShouldUpdateIncomeWhenValidData() {
		Financing f = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
		f.setIncome(3000.00);

		Assertions.assertEquals(3000.00, f.getIncome());
	}

	@Test
	public void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
			f.setIncome(500.00);
		});
	}

	@Test
	public void setMonthsShouldUpdateMonthsWhenValidData() {
		Financing f = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
		f.setMonths(90);

		Assertions.assertEquals(90, f.getMonths());
	}

	@Test
	public void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancing(100000.00, 2000.00, 20);
			f.setMonths(10);
		});
	}

	@Test
	public void entryShouldCalculateCorrectly() {
		Financing f = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
		Assertions.assertEquals(20000.00, f.entry());
	}

	@Test
	public void quotaShouldCalculateCorrectly() {
		Financing f = FinancingFactory.createFinancing(100000.00, 2000.00, 80);
		Assertions.assertEquals(1000.00, f.quota());
	}

}
