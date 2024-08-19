package com.frm.commandcenter;

import com.frm.commandcenter.model.Command;
import com.frm.commandcenter.service.CommandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CommandCenterApplicationTests {

	@Autowired
	private CommandService commandService;

	@Test
	void testCreateCommand() {
		Command command = new Command();
		command.setControlNumber("123456");
		command.setProductName("Product A");
		command.setUnitPrice(new BigDecimal("100.00"));
		command.setId(1L);

		Command savedCommand = commandService.saveCommand(command);

		assertThat(savedCommand.getId()).isNotNull();
		assertThat(savedCommand.getTotalPrice()).isEqualByComparingTo(new BigDecimal("100.00"));
	}
}
