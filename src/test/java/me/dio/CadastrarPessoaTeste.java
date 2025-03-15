package me.dio;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {
    
    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCorreios(){
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("PI", "Teresina","Geovane Prado", "Niolena", "Vale quem tem");
        Mockito.when(apiDosCorreios.buscaComBaseNoCep("64000200")).thenReturn(dadosLocalizacao);
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Samuel", "12345678", LocalDate.now(), "64000200");

        assertEquals("Samuel", pessoa.getNome());
        assertEquals("12345678", pessoa.getDocumento());
        assertEquals("PI", pessoa.getEndereco().getUf());
        assertEquals("Teresina", pessoa.getEndereco().getCidade());
        assertEquals("Niolena", pessoa.getEndereco().getComplemento());

    }


}
