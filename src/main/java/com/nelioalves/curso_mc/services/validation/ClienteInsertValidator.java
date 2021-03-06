package com.nelioalves.curso_mc.services.validation;

import com.nelioalves.curso_mc.domain.Cliente;
import com.nelioalves.curso_mc.dto.ClienteNewDTO;
import com.nelioalves.curso_mc.enums.TipoCliente;
import com.nelioalves.curso_mc.repositories.ClienteRepository;
import com.nelioalves.curso_mc.resources.exception.FieldMessage;
import com.nelioalves.curso_mc.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepository repo;

    @Override
    public void initialize(ClienteInsert ann){
    }

    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context){

        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj","CPF inválido!"));
        }

        if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj","CNPJ inválido!"));
        }

        Cliente aux = repo.findByEmail(objDto.getEmail());
        if (aux != null){
            list.add(new FieldMessage("email","Email já existente!"));
        }

        // inclua os testes aqui, inserindo erros na lista
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }

}
