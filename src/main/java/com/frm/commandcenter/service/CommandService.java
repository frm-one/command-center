package com.frm.commandcenter.service;

import com.frm.commandcenter.model.Command;
import com.frm.commandcenter.repository.CommandRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommandService {

    private final CommandRepository commandRepository;

    // Injeção de dependência via construtor
    public CommandService(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    // Método para salvar um novo Command
    public Command saveCommand(Command command) {
        // Verifica se o número de controle já está registrado
        if (commandRepository.existsByControlNumber(command.getControlNumber())) {
            throw new IllegalArgumentException("Control number already registered");
        }

        // Define a data de registro se não estiver definida
        if (command.getRegistrationDate() == null) {
            command.setRegistrationDate(LocalDateTime.now());
        }

        // Define a quantidade padrão se não estiver definida
        if (command.getQuantity() == null) {
            command.setQuantity(1);
        }

        // Calcula o preço total, aplicando descontos se necessário
        BigDecimal totalPrice = command.getUnitPrice().multiply(BigDecimal.valueOf(command.getQuantity()));
        if (command.getQuantity() > 5) {
            BigDecimal discount = command.getQuantity() >= 10 ? new BigDecimal("0.10") : new BigDecimal("0.05");
            totalPrice = totalPrice.multiply(BigDecimal.ONE.subtract(discount));
        }

        command.setTotalPrice(totalPrice);

        // Salva e retorna o Command
        return commandRepository.save(command);
    }

    // Método para buscar Commands com critérios opcionais
    public List<Command> getCommands(Optional<String> controlNumber, Optional<LocalDateTime> registrationDate) {
        // Cria uma especificação inicial vazia
        Specification<Command> spec = Specification.where(null);

        // Adiciona o critério de número de controle, se fornecido
        if (controlNumber.isPresent()) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("controlNumber"), controlNumber.get()));
        }

        // Adiciona o critério de data de registro, se fornecido
        if (registrationDate.isPresent()) {
            spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("registrationDate"), registrationDate.get()));
        }

        // Retorna a lista de Commands que correspondem aos critérios
        return commandRepository.findAll();
    }
}
